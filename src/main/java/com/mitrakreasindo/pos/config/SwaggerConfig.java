/**
 * 
 */
package com.mitrakreasindo.pos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author miftakhul
 *
 */
@Configuration
@Profile("dev")
@EnableSwagger2
public class SwaggerConfig
{

	@Bean
	public Docket allApi()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.mitrakreasindo.pos.controller"))
				.build();
	}
	
}
