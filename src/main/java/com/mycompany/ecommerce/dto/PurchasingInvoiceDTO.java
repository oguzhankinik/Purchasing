package com.mycompany.ecommerce.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author oguzhankinik
 *
 */
@Data
@ApiModel("Purchasing Invoice Data Transfer Object")
public class PurchasingInvoiceDTO {

	@ApiModelProperty(value = "Purchasing Invoice ID")
	private Long id;

	// used with directly classField syntax so unnecessary
	// private PurchasingSpecialistDTO purchasingSpecialistDTO;

	@NotNull
	@NotBlank(message = "First Name is mandatory.")
	@ApiModelProperty(value = "First name of Purchasing Specialist", required = true)
	private String firstName;

	@NotNull
	@NotBlank(message = "Last Name is mandatory.")
	@ApiModelProperty(value = "Last name of Purchasing Specialist", required = true)
	private String lastName;

	@NotNull
	@Email(message = "Email is not valid.")
	@ApiModelProperty(value = "Email of Purchasing Specialist", required = true)
	private String email;

	// for without charge or free product amount
	@Min(value = 0)
	@NotNull
	@ApiModelProperty(value = "Amount of Purchasing Invoice", required = true)
	private Double amount;

	@NotNull
	@ApiModelProperty(value = "Name of product", required = true)
	private String productName;

	@NotNull
	@ApiModelProperty(value = "Bill number", required = true)
	private String billNo;

	@ApiModelProperty(value = "Status of approval property")
	private boolean approval;

	@ApiModelProperty(value = "The create time of record")
	private LocalDateTime createTime;

}
