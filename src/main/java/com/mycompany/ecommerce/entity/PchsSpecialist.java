package com.mycompany.ecommerce.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.mycompany.ecommerce.entity.pk.PchsSpecialistId;

import lombok.Data;


/**
 * 
 * @author oguzhankinik
 *
 */
@Entity
@Data
public class PchsSpecialist extends Account {

	@EmbeddedId
	private PchsSpecialistId pchsSpecialistId;
	
	private Double purchasedAmount;
	
}
