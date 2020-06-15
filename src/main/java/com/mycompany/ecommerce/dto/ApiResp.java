package com.mycompany.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author oguzhankinik
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResp {

	private boolean success;

	private int statusCode;

	private String message;

	private String displayMessage;

	private Object data;

}
