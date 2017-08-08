/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author miftakhul
 *
 */
public class test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
System.out.println(t.toString());
	}

}
