package com.mycompany.ecommerce.service;

import java.util.List;

import com.mycompany.ecommerce.entity.Purchasing;

/**
 * 
 * @author oguzhankinik
 *
 */
public interface PurchasingService {

	public void save(final Purchasing purchasing);
	
	public List<Purchasing> list(final boolean approval);
	
}
