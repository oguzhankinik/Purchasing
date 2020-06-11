package com.mycompany.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.ecommerce.entity.Purchasing;

/**
 * 
 * @author oguzhankinik
 *
 */
@Repository
public interface PurchasingRepo extends JpaRepository<Purchasing, Long> {

}
