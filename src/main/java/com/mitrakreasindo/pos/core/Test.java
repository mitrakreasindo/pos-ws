/**
 * 
 */
package com.mitrakreasindo.pos.core;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 * @author mitradev
 *
 */
public class Test
{

	DataSource datassource;
//	SimpleJdbcCall call = new SimpleJdbcCall(datassource);
	public void testa()
	{

		SimpleJdbcCall call = new SimpleJdbcCall(datassource);
	  call.withProcedureName("");
	  
	  JdbcTemplate tem = new JdbcTemplate();
	  
	}
	
}
