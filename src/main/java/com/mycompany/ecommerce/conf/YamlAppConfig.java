package com.mycompany.ecommerce.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * This configuration class provide use properties which in the application.yml.
 * Note: org.springframework.beans.factory.annotation @Value also provide shortcut usage.
 * 
 * @author oguzhankinik
 *
 */
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class YamlAppConfig {

	private double limit;

}
