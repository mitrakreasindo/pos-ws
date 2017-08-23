/**
 * 
 */
package com.mitrakreasindo.pos.service;

import com.mitrakreasindo.pos.entities.Money;

/**
 * @author miftakhul
 *
 */
public interface MoneyService
{

	Money getCostInfo();
	
	Money getRevenueInfo();
	
	double getCoshToDay();
	
	double getCoshThisWeek();
	
	double getCoshThisMonth();
	
	double getCoshThisYear();
	
	double getRevenueToDay();
	
	double getRevenueThisWeek();
	
	double getRevenueThisMonth();
	
	double getRevenueThisYear();
	
	
}
