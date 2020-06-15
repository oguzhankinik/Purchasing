package com.mycompany.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.mycompany.ecommerce.entity.pk.PurchasingSpecialistId;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author oguzhankinik
 *
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchasingSpecialist extends UserAccount {

	private static final long serialVersionUID = 1521752508373694472L;

	@EmbeddedId
	private PurchasingSpecialistId purchasingSpecialistId;

	@Column(nullable = false)
	private Double purchasedAmount;

	// this relation working as unidirectional
//	@JoinColumn
//	@OneToMany(fetch = FetchType.LAZY)
//	private List<PurchasingInvoice> purchasingInvoices;

}
