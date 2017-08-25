/**
 * 
 */
package com.mitrakreasindo.pos.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

/**
 * @author mitradev
 *
 */
@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver
{

	@Override
	public String resolveCurrentTenantIdentifier()
	{
		String schema = TenantContext.getCurrentSchema();
		if (schema != null)
		{
			System.out.println("tenant identifier schema : "+schema);
			return schema;
		}
		System.out.println("tenant identifier schema default : "+TenantContext.defaultSchema);
		return TenantContext.defaultSchema;
	}

	@Override
	public boolean validateExistingCurrentSessions()
	{
		return true;
	}

}
