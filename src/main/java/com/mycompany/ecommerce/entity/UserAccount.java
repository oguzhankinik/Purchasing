package com.mycompany.ecommerce.entity;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author oguzhankinik
 *
 */
@Getter
@Setter
@ToString
public class UserAccount extends BaseEntity {

	private static final long serialVersionUID = -4402899633359745098L;

	@Column
	protected String alias;

	@Column
	protected boolean active = true;

}
