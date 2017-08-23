/**
 * 
 */
package com.mitrakreasindo.pos.config;

/**
 * @author mitradev
 *
 */
public class TenantContext
{

	public static String defaultSchema = "public"; 
	private static ThreadLocal<String> currentSchema = new ThreadLocal<>();

	/**
	 * @return the currentSchema
	 */
	public static String getCurrentSchema()
	{
		return currentSchema.get();
	}

	/**
	 * @param currentSchema the currentSchema to set
	 */
	public static void setCurrentSchema(String schema)
	{
		currentSchema.set(schema);
	}
	
	public static void clear() 
	{
		currentSchema.set(null);
	}
	
}