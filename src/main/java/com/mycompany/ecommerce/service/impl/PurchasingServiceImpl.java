package com.mycompany.ecommerce.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.apache.commons.lang3.Validate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycompany.ecommerce.dto.PageT;
import com.mycompany.ecommerce.dto.PurchasingInvoiceDTO;
import com.mycompany.ecommerce.entity.PurchasingInvoice;
import com.mycompany.ecommerce.entity.PurchasingSpecialist;
import com.mycompany.ecommerce.exception.CodedException;
import com.mycompany.ecommerce.repo.PurchasingInvoiceRepo;
import com.mycompany.ecommerce.repo.PurchasingSpecialistRepo;
//import com.mycompany.ecommerce.repo.UserAccountRepo;
import com.mycompany.ecommerce.service.PurchasingService;

import lombok.extern.slf4j.Slf4j;

/**
 * This is the service class for operations in the Purchasing. operations ->
 * adding and listing purchasing invoices
 * 
 * @author oguzhankinik
 *
 */
@Service
@Slf4j
public class PurchasingServiceImpl implements PurchasingService {

	@Value("${app.limit}")
	private double purchasingLimit;

	private final PurchasingInvoiceRepo purchasingInvoiceRepo;
	private final PurchasingSpecialistRepo purchasingSpecialistRepo;
	private final ModelMapper modelMapper;

	public PurchasingServiceImpl(PurchasingInvoiceRepo purchasingInvoiceRepo,
			PurchasingSpecialistRepo purchasingSpecialistRepo, ModelMapper modelMapper) {
		this.purchasingInvoiceRepo = purchasingInvoiceRepo;
		this.purchasingSpecialistRepo = purchasingSpecialistRepo;
		this.modelMapper = modelMapper;
	}

	@Transactional
	@Override
	public PurchasingInvoiceDTO add(final PurchasingInvoiceDTO purchasingInvoiceDTO) {
		Validate.notNull(purchasingInvoiceDTO, "The purchasing invoice must not be null");

		PurchasingSpecialist purchasingSpecialist = purchasingSpecialistRepo
				.findByPurchasingSpecialistIdEmail(purchasingInvoiceDTO.getEmail());

		boolean approval = false;
		boolean newPurchasingSpecialist = false;
		double newPurchasedAmount;

		// calculate new purchased amount
		if (Objects.isNull(purchasingSpecialist)) {
			// create purchasingSpecialist instance from PurchasingInvoiceDTO
			purchasingSpecialist = modelMapper.map(purchasingInvoiceDTO, PurchasingSpecialist.class);
			newPurchasingSpecialist = true;
			newPurchasedAmount = purchasingInvoiceDTO.getAmount();
		} else {
			newPurchasedAmount = purchasingSpecialist.getPurchasedAmount() + purchasingInvoiceDTO.getAmount();
		}

		// compare purchased amount with configured limit
		if (newPurchasedAmount <= purchasingLimit) { // (140+50)=<200 TRUE, (190+50)<=200 FALSE
			approval = true;
			purchasingSpecialist.setPurchasedAmount(newPurchasedAmount);
		}

		// if approval then save purchasing specialist updated with new amount
		if (approval) {
			purchasingSpecialist = purchasingSpecialistRepo.save(purchasingSpecialist);
		} else if (newPurchasingSpecialist) { // if over limit and new purchasing specialist
			purchasingSpecialist.setPurchasedAmount(0.0);
			purchasingSpecialist = purchasingSpecialistRepo.save(purchasingSpecialist);
		}

		purchasingInvoiceDTO.setApproval(approval);

		// create purchasingInvoice instance from purchasingInvoiceDTO then save
		PurchasingInvoice purchasingInvoice = modelMapper.map(purchasingInvoiceDTO, PurchasingInvoice.class);
		purchasingInvoice.setPurchasingSpecialist(purchasingSpecialist);
		purchasingInvoice = purchasingInvoiceRepo.save(purchasingInvoice);

		if (approval) {
			log.info("Saved PurchasingSpecialist as :" + purchasingSpecialist + " and PurchasingInvoice as :"
					+ purchasingInvoice);
		} else {
			log.warn("Saved PurchasingSpecialist as :" + purchasingSpecialist + " and PurchasingInvoice as :"
					+ purchasingInvoice);
		}
		return modelMapper.map(purchasingInvoice, PurchasingInvoiceDTO.class);
	}

	@Override
	public List<PurchasingInvoiceDTO> list(final boolean approval) {
		try {
			List<PurchasingInvoice> purchasingInvoiceList = purchasingInvoiceRepo.findByApproval(approval);
			List<PurchasingInvoiceDTO> postDtoList = Arrays
					.asList(modelMapper.map(purchasingInvoiceList, PurchasingInvoiceDTO[].class));
			return postDtoList;
		} catch (Exception e) {
			throw new CodedException("Unexpected an error occurred");
		}
	}

	@Override
	public PageT<PurchasingInvoiceDTO> list(Pageable pageable, boolean approval) {
		Page<PurchasingInvoice> purchasingInvoicePage = purchasingInvoiceRepo.findByApproval(approval, pageable);
		PageT page = new PageT<PurchasingInvoiceDTO>();
		PurchasingInvoiceDTO[] dtos = modelMapper.map(purchasingInvoicePage.getContent(), PurchasingInvoiceDTO[].class);
		page.setStat(purchasingInvoicePage, Arrays.asList(dtos));
		return page;
	}

}
