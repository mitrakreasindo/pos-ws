/**
 * 
 */
package com.mitrakreasindo.pos.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mitradev
 *
 */
@Component
public class MultiTenantConnectionProfiderImpl implements MultiTenantConnectionProvider
{

	@Autowired
	DataSource datasource;
	
	@Override
	public boolean isUnwrappableAs(Class arg0)
	{
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0)
	{
		return null;
	}

	@Override
	public Connection getAnyConnection() throws SQLException
	{
		return datasource.getConnection();
	}

	@Override
	public Connection getConnection(String schema) throws SQLException
	{
		Connection connection = getAnyConnection();		
		try
		{
			if (schema != null)
			{
				connection.createStatement().execute("set search_path to "+schema);
			}
			else
			{
				connection.createStatement().execute("set search_path to "+TenantContext.defaultSchema);
			}
		} 
		catch (SQLException e)
		{
			throw new HibernateException("Problem setting schema to "+schema, e);
		}
		
		return connection;
	}

	@Override
	public void releaseAnyConnection(Connection connection) throws SQLException
	{
		connection.close();
	}

	@Override
	public void releaseConnection(String schema, Connection connection) throws SQLException
	{
		try
		{
			connection.createStatement().execute("set search_path to "+TenantContext.defaultSchema);
		} 
		catch (SQLException e)
		{
			throw new HibernateException("Problem setting schema to "+schema, e);
		}
		connection.close();
	}

	@Override
	public boolean supportsAggressiveRelease()
	{
		return true;
	}

}
