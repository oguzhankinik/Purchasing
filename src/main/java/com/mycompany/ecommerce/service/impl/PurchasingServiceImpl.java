package com.mycompany.ecommerce.service.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import com.mycompany.ecommerce.entity.Purchasing;
import com.mycompany.ecommerce.repo.PurchasingRepo;
import com.mycompany.ecommerce.service.PurchasingService;

/**
 * 
 * @author oguzhankinik
 *
 */
@Service
public class PurchasingServiceImpl implements PurchasingService {

	//@YamlConf
	
	private final PurchasingRepo purchasingRepo;

	public PurchasingServiceImpl(PurchasingRepo purchasingRepo) {
		this.purchasingRepo = purchasingRepo;
	}

	@Override
	public void save(final Purchasing purchasing) {
		Validate.notNull(purchasing, "The purchasing must not be %s", null);

		double totalPurchasedAmount = findByEmbeddedIdAndApprovalTrue;
		if(totalPurchasedAmount >= limit) { // 190>=200, 	210>=200
			approval = false;
		} else if ((purchasing.getAmount() + totalPurchasedAmount) > limit) { // (50+140)>200, 	(50+190)>200
			approval = false;
		} else { // 
			approval = true;
		}
		
		purchasingRepo.save(purchasing);

	}

	@Override
	public List<Purchasing> list(final boolean approval) {
		final List<Purchasing> purchasingList = purchasingRepo.findByApproval(approval);
		return purchasingList;
	}

}
