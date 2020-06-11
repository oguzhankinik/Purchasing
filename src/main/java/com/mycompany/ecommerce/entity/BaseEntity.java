package com.mycompany.ecommerce.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author oguzhankinik
 *
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 3094617549302193217L;

	@Getter @Setter
	@Version
	protected Long version;
	
	@Getter @Setter
	@Column(name = "create_time")
	protected LocalDateTime createTime;
	
	@PrePersist
	protected void populatePreValues() {
		createTime = LocalDateTime.now();
	}
	
	
}
