/**
 * 
 */
package com.mitrakreasindo.pos.service;


/**
 * @author miftakhul
 *
 */
public interface MoneyService
{

	Money getCostInfo(String merchantCode);
	
	Money getRevenueInfo(String merchantCode);
	
	double getCoshToDay(String merchantCode);
	
	double getCoshThisWeek(String merchantCode);
	
	double getCoshThisMonth(String merchantCode);
	
	double getCoshThisYear(String merchantCode);
	
	double getRevenueToDay(String merchantCode);
	
	double getRevenueThisWeek(String merchantCode);
	
	double getRevenueThisMonth(String merchantCode);
	
	double getRevenueThisYear(String merchantCode);
	
	
}
