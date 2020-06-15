package com.mycompany.ecommerce.entity.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Composite primary key of Purchasing Specialist object
 * 
 * @author oguzhankinik
 *
 */
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PurchasingSpecialistId implements Serializable {

	private static final long serialVersionUID = -151097750372248647L;

	@Column(length = 255, nullable = false)
	private String firstName;

	@Column(length = 255, nullable = false)
	private String lastName;

	@Column(length = 320, nullable = false, unique = true)
	private String email;

}
