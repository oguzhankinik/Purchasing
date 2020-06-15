package com.mycompany.ecommerce.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This configuration class provide @Transactional DB operations.
 * 
 * @author oguzhankinik
 *
 */
@Configuration
@EnableTransactionManagement
public class SpringDataTrxnMgmtConfig {

	// Spring Boot project and these spring-data-* or spring-tx dependencies provide
	// transaction management will be enabled by default.

}
