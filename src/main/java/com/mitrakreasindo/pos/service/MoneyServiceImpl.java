/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

/**
 * @author miftakhul
 *
 */
@Service
public class MoneyServiceImpl implements MoneyService
{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public double getCoshToDay(String merchantCode)
	{
		Query q = entityManager.createNativeQuery("select cost_today from "+merchantCode+".viewcosttoday");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	@Override
	public double getCoshThisWeek(String merchantCode)
	{
		Query q = entityManager.createNativeQuery("select cost_this_week from "+merchantCode+".viewcostthisweek");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	@Override
	public double getCoshThisMonth(String merchantCode)
	{
		Query q = entityManager.createNativeQuery("select cost_this_month from "+merchantCode+".viewcostthismonth");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	@Override
	public double getCoshThisYear(String merchantCode)
	{
		Query q = entityManager.createNativeQuery("select cost_this_year from "+merchantCode+".viewcostthisyear");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}
	
	@Override
	public double getRevenueToDay(String merchantCode)
	{
		Query q = entityManager.createNativeQuery("select revenue_today from "+merchantCode+".viewrevenuetoday");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	@Override
	public double getRevenueThisWeek(String merchantCode)
	{
		Query q = entityManager.createNativeQuery("select revenue_this_week from "+merchantCode+".viewrevenuethisweek");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}
	
	@Override
	public double getRevenueThisMonth(String merchantCode)
	{
		Query q = entityManager.createNativeQuery("select revenue_this_month from "+merchantCode+".viewrevenuethismonth");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	@Override
	public double getRevenueThisYear(String merchantCode)
	{
		Query q = entityManager.createNativeQuery("select revenue_this_year from "+merchantCode+".viewrevenuethisyear");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	
	
	@Override
	public Money getCostInfo(String merchantCode)
	{
		Money money = new Money();
		money.setDay(getCoshToDay(merchantCode));
		money.setWeek(getCoshThisWeek(merchantCode));
		money.setMonth(getCoshThisMonth(merchantCode));
		money.setYear(getCoshThisYear(merchantCode));
		return money;
	}

	@Override
	public Money getRevenueInfo(String merchantCode)
	{
		Money money = new Money();
		money.setDay(getRevenueToDay(merchantCode));
		money.setWeek(getRevenueThisWeek(merchantCode));
		money.setMonth(getRevenueThisMonth(merchantCode));
		money.setYear(getRevenueThisYear(merchantCode));
		return money;
	}

}
