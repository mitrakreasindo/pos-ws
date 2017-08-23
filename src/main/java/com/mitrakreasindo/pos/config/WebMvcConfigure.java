/**
 * 
 */
package com.mitrakreasindo.pos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author mitradev
 *
 */
@Configuration
public class WebMvcConfigure extends WebMvcConfigurerAdapter
{

	@Autowired
	TenantInterceptor interceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(interceptor);
	}
	
}
