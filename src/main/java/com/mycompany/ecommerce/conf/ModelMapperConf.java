package com.mycompany.ecommerce.conf;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycompany.ecommerce.dto.PurchasingInvoiceDTO;
import com.mycompany.ecommerce.entity.PurchasingInvoice;
import com.mycompany.ecommerce.entity.PurchasingSpecialist;

/**
 * This configuration class is helper the to map objects' conversion.
 * 
 * @author oguzhankinik
 *
 */
@Configuration
public class ModelMapperConf {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		// PurchasingInvoiceDTO to PurchasingSpecialist property mapping
		modelMapper.addMappings(new PropertyMap<PurchasingInvoiceDTO, PurchasingSpecialist>() {
			@Override
			protected void configure() {
				map().getPurchasingSpecialistId().setFirstName(source.getFirstName());
				map().getPurchasingSpecialistId().setLastName(source.getLastName());
				map().getPurchasingSpecialistId().setEmail(source.getEmail());
			}
		});

		// PurchasingInvoiceDTO to PurchasingInvoice property mapping
		modelMapper.addMappings(new PropertyMap<PurchasingInvoiceDTO, PurchasingInvoice>() {
			@Override
			protected void configure() {
				map().getPurchasingSpecialist().getPurchasingSpecialistId().setFirstName(source.getFirstName());
				map().getPurchasingSpecialist().getPurchasingSpecialistId().setLastName(source.getLastName());
				map().getPurchasingSpecialist().getPurchasingSpecialistId().setEmail(source.getEmail());
			}
		});

		// PurchasingInvoice to PurchasingInvoiceDTO property mapping
		modelMapper.addMappings(new PropertyMap<PurchasingInvoice, PurchasingInvoiceDTO>() {
			@Override
			protected void configure() {
				map().setFirstName(source.getPurchasingSpecialist().getPurchasingSpecialistId().getFirstName());
				map().setLastName(source.getPurchasingSpecialist().getPurchasingSpecialistId().getLastName());
				map().setEmail(source.getPurchasingSpecialist().getPurchasingSpecialistId().getEmail());
			}
		});

		return modelMapper;
	}
}
