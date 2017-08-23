/**
 * 
 */
package com.mitrakreasindo.pos.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author mitradev
 *
 */
@Component
public class TenantInterceptor extends HandlerInterceptorAdapter
{

	Logger log = Logger.getLogger(TenantContext.class);	
	private static final String SCHEMA_HEADER = "merchantCode";
	
	@Autowired
	private Environment env;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		String schema = request.getHeader(SCHEMA_HEADER);
		boolean schemaSet = false;
		
		if (env.getActiveProfiles()[0].toString().equals("dev")) 
		{
			if (request.getRequestURL().toString().contains("api/v2/api-docs") || request.getRequestURL().toString().contains("swagger"))
			{
				TenantContext.setCurrentSchema(TenantContext.defaultSchema);
				schemaSet = true;
				return schemaSet;
			}
		}
		
		if (StringUtils.isEmpty(schema))
		{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.getWriter().write("{\"error\":\"No merchantCode\"}");
			response.getWriter().flush();
		}
		else
		{
			TenantContext.setCurrentSchema(schema);
			schemaSet = true;
		}
		
		return schemaSet;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception
	{
		TenantContext.clear();
	}
	
}
