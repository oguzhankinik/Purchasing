package com.mycompany.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.ecommerce.entity.PurchasingSpecialist;

/**
 * This is the Repository interface for Purchasing Specialist DB operations using.
 * 
 * @author oguzhankinik
 *
 */
public interface PurchasingSpecialistRepo extends JpaRepository<PurchasingSpecialist, Long> {

	PurchasingSpecialist findByPurchasingSpecialistIdEmail(String email);

}
