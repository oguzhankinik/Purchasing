package com.mycompany.ecommerce.restapi;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.ecommerce.entity.Purchasing;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author oguzhankinik
 *
 */
@RestController
@RequestMapping("/purchasing")
@Slf4j
public class PurchasingRestApi {

	
	@PostMapping(value="add")
	public ResponseEntity<?> insertInvoice(@Valid @RequestBody Purchasing purchasing) {
		
		return new ResponseEntity<>("insertInvoice", HttpStatus.OK);
	}
	
	@GetMapping(value="list")
	public ResponseEntity<?> retrievePurchasingInvoice() {
		
		return new ResponseEntity<>("retrievePurchasingInvoice", HttpStatus.OK);
	}
	
}
