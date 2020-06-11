package com.mycompany.ecommerce.entity.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @author oguzhankinik
 *
 */
@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class PchsSpecialistId implements Serializable {
	
	private static final long serialVersionUID = -151097750372248647L;

	@Column(name = "first_name", length = 255, nullable = false)
	@NotBlank(message = "First Name is mandatory.")
	private String firstName;
	
	@Column(name = "last_name", length = 255, nullable = false)
	@NotBlank(message = "Last Name is mandatory.")
	private String lastName;
	
	@Column(nullable = false)
	@Email(message = "Email is not valid.")
	private String email;

}
