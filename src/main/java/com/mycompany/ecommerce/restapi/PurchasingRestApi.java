package com.mycompany.ecommerce.restapi;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.ecommerce.dto.ApiResp;
import com.mycompany.ecommerce.dto.PurchasingInvoiceDTO;
import com.mycompany.ecommerce.request.PurchasingInvoiceReq;
import com.mycompany.ecommerce.service.PurchasingService;
import com.mycompany.ecommerce.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * API to insert purchasing invoices and retrieve purchasing invoices according
 * to approval status.
 * 
 * @author oguzhankinik
 *
 */
@RestController
@RequestMapping(ApiPaths.PURCHASING_CTRL)
@Slf4j
@Api(value = "Purchasing APIs")
public class PurchasingRestApi {

	private final PurchasingService purchasingService;
	private final ModelMapper modelMapper;

	public PurchasingRestApi(PurchasingService purchasingService, ModelMapper modelMapper) {
		this.purchasingService = purchasingService;
		this.modelMapper = modelMapper;
	}

	// TODO @oguzhankinik 20200614 use CodedException
	// TODO @oguzhankinik 20200614 use UUID in CodedException for log file and
	// TODO @oguzhankinik 20200614 don't send 500 error
	// response
	@PostMapping(value = ApiPaths.PCHS_INVOICES)
	@ApiOperation(value = "Adding purchasing invoice", response = PurchasingInvoiceDTO.class)
	public ResponseEntity<?> insertInvoice(@Valid @RequestBody PurchasingInvoiceReq purchasingInvoiceReq) {
		log.debug("called insert purchasing invoice. Content is " + purchasingInvoiceReq);

		PurchasingInvoiceDTO purchasingInvoiceDTO = modelMapper.map(purchasingInvoiceReq, PurchasingInvoiceDTO.class);
		purchasingInvoiceDTO = purchasingService.add(purchasingInvoiceDTO);

		ApiResp apiResp = new ApiResp(purchasingInvoiceDTO.isApproval(), HttpStatus.OK.ordinal(),
				purchasingInvoiceDTO.isApproval() ? "Purchasing invoice was successfully added."
						: "Purchasing invoice was not approved.",
				"", purchasingInvoiceDTO);

		return ResponseEntity.ok(apiResp);
	}

	@GetMapping(value = ApiPaths.PCHS_INVOICES + "/approval/{approval}")
	@ApiOperation(value = "Retrieving purchasing invoices", response = PurchasingInvoiceDTO.class)
	public ResponseEntity<?> retrievePurchasingInvoices(
			@PathVariable(name = "approval", required = true) boolean approval) {
		log.debug("called retrieve purchasing invoices.");

		List<PurchasingInvoiceDTO> purchasingInvoiceDTOList = purchasingService.list(approval);

		ApiResp apiResp = new ApiResp(true, HttpStatus.OK.ordinal(), "Purchasing invoices was retrieved successfully.",
				"", purchasingInvoiceDTOList);
		return ResponseEntity.ok(apiResp);
	}

}
