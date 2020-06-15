package com.mycompany.ecommerce.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.ecommerce.entity.PurchasingInvoice;

/**
 * This is the Repository interface for Purchasing Invoice DB operations using.
 * 
 * 
 * @author oguzhankinik
 *
 */
public interface PurchasingInvoiceRepo extends JpaRepository<PurchasingInvoice, Long> {

	List<PurchasingInvoice> findByApproval(boolean approval);

	Page<PurchasingInvoice> findByApproval(boolean approval, Pageable pageable);

	Page<PurchasingInvoice> findAll(Pageable pageable);

}
