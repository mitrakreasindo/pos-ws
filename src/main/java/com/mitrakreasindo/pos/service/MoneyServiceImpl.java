/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.entities.Money;

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
	public double getCoshToDay()
	{
		Query q = entityManager.createNativeQuery("select cost_today from viewcosttoday");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	@Override
	public double getCoshThisWeek()
	{
		Query q = entityManager.createNativeQuery("select cost_this_week from viewcostthisweek");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	@Override
	public double getCoshThisMonth()
	{
		Query q = entityManager.createNativeQuery("select cost_this_month from viewcostthismonth");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	@Override
	public double getCoshThisYear()
	{
		Query q = entityManager.createNativeQuery("select cost_this_year from viewcostthisyear");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}
	
	@Override
	public double getRevenueToDay()
	{
		Query q = entityManager.createNativeQuery("select revenue_today from viewrevenuetoday");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	@Override
	public double getRevenueThisWeek()
	{
		Query q = entityManager.createNativeQuery("select revenue_this_week from viewrevenuethisweek");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}
	
	@Override
	public double getRevenueThisMonth()
	{
		Query q = entityManager.createNativeQuery("select revenue_this_month from viewrevenuethismonth");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	@Override
	public double getRevenueThisYear()
	{
		Query q = entityManager.createNativeQuery("select revenue_this_year from viewrevenuethisyear");
		return ((List<Double>) q.getResultList()).stream().filter(x -> x != null).mapToDouble(Double::doubleValue).sum();
	}

	
	
	@Override
	public Money getCostInfo()
	{
		Money money = new Money();
		money.setDay(getCoshToDay());
		money.setWeek(getCoshThisWeek());
		money.setMonth(getCoshThisMonth());
		money.setYear(getCoshThisYear());
		return money;
	}

	@Override
	public Money getRevenueInfo()
	{
		Money money = new Money();
		money.setDay(getRevenueToDay());
		money.setWeek(getRevenueThisWeek());
		money.setMonth(getRevenueThisMonth());
		money.setYear(getRevenueThisYear());
		return money;
	}

}
