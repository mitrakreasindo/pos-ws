/**
 * 
 */
package com.mitrakreasindo.pos;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mitradev
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TableTest
{

	@PersistenceContext
	EntityManager em;
	
	@Test
	public void test()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testTable()
	{
		System.out.println("==== testing table");
		Query q = em.createNativeQuery("select * from table_datu");
		q.getSingleResult();
		System.out.println("==== testing table success");
	}

}
