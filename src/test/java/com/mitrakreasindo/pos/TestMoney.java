/**
 * 
 */
package com.mitrakreasindo.pos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		double day = service.getCoshToDay();
		double week = service.getCoshThisWeek();
		double month = service.getCoshThisMonth();
		double year = service.getCoshThisYear();
		System.out.println("total ============= day "+day+" week "+week+" month "+month+" year "+year);
		
		
		double rday = service.getRevenueToDay();
		System.out.println(" rday =============== "+rday);
		double rweek = service.getRevenueThisWeek();
		System.out.println(" rweek =============== "+rweek);
		double rmonth = service.getRevenueThisMonth();
		System.out.println(" rmonth =============== "+rmonth);
		double ryear = service.getRevenueThisYear();
		System.out.println(" ryear =============== "+ryear);
		System.out.println("total ============= day "+rday+" week "+rweek+" month "+rmonth+" year "+ryear);
	}

}
