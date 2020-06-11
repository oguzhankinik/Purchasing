package com.mycompany.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;

/**
 * 
 * @author oguzhankinik
 *
 */
@Entity
@NamedQuery(name = "Purchasing.findByApprove", query = "select p from Purchasing p where p.approval = ?1")
@Data
public class Purchasing {

	@Id
	private Long id;
	
	private Long amount;
	
	@Column(name = "product_name", length = 6)	
	private String productName;
	
	@Column(name = "bill_no", length = 6)
	private String billNo;
	
	private boolean approval;
}
