/**
 * 
 */
package com.mitrakreasindo.pos;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mitrakreasindo.pos.service.Money;
import com.mitrakreasindo.pos.service.MoneyService;

/**
 * @author miftakhul
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMoney
{
	
	@Autowired
	private MoneyService service;
	
	@Test
	public void test()
	{
//		fail("Not yet implemented");
		System.out.println("================== testing serivice");
		double day = service.getCoshToDay("public");
		double week = service.getCoshThisWeek("public");
		double month = service.getCoshThisMonth("public");
		double year = service.getCoshThisYear("public");
		System.out.println("total ============= day "+day+" week "+week+" month "+month+" year "+year);
		
		
		double rday = service.getRevenueToDay("public");
		System.out.println(" rday =============== "+rday);
		double rweek = service.getRevenueThisWeek("public");
		System.out.println(" rweek =============== "+rweek);
		double rmonth = service.getRevenueThisMonth("public");
		System.out.println(" rmonth =============== "+rmonth);
		double ryear = service.getRevenueThisYear("public");
		System.out.println(" ryear =============== "+ryear);
		System.out.println("total ============= day "+rday+" week "+rweek+" month "+rmonth+" year "+ryear);
	}

}
