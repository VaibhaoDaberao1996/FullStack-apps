package com.Transaction.Utils;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().
				group("product-ransaction-api") //this will give the heading on the html nothing special
				.pathsToMatch("/api/productsTransactions/**") //url you want to show 
				.build();
	}
		/*After run the App just enter the below URL
		* "http://localhost:8080/swagger-ui.html" */
}
