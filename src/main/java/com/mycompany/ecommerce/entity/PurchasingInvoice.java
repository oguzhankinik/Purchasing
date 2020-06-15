package com.mycompany.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author oguzhankinik
 *
 */
@Entity
//@NamedQuery(name = "Purchasing.findByApprovalStatus", query = "select p from Purchasing p where p.approval = ?1")
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchasingInvoice extends BaseEntity {

	private static final long serialVersionUID = -518288240431103306L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "firstName"), @JoinColumn(name = "lastName"), @JoinColumn(name = "email") })
	private PurchasingSpecialist purchasingSpecialist = new PurchasingSpecialist();

	private Double amount;

	private String productName;

	@Column(length = 6)
	private String billNo;

	private boolean approval;

}
