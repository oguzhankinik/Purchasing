package com.mycompany.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mycompany.ecommerce.dto.PageT;
import com.mycompany.ecommerce.dto.PurchasingInvoiceDTO;

/**
 * 
 * @author oguzhankinik
 *
 */
public interface PurchasingService {

	PurchasingInvoiceDTO add(final PurchasingInvoiceDTO purchasingInvoice);

	List<PurchasingInvoiceDTO> list(final boolean approval);

	PageT<PurchasingInvoiceDTO> list(final Pageable pageable, final boolean approval);

}
