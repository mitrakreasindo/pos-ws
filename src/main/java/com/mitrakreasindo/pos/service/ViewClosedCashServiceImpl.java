/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;

import org.springframework.stereotype.Service;
import com.mitrakreasindo.pos.entities.ViewClosedCash;

/**
 * @author miftakhul
 *
 */
@Service
public class ViewClosedCashServiceImpl implements ViewClosedCashService
{


	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public ViewClosedCash find(String receiptId)
	{
		Query q = entityManager.createNativeQuery("SELECT * FROM " + ViewClosedCash.class.getAnnotation(Table.class).name() + " where receipt_id = '" + receiptId + "'", ViewClosedCash.class);
    return (ViewClosedCash) q.getSingleResult();
	}
	
	@Override
	public List<ViewClosedCash> findByMoney(String moneyId)
	{
		Query q = entityManager.createNativeQuery("select * from "+ViewClosedCash.class.getAnnotation(Table.class).name()+" where money = '"+moneyId+"'", ViewClosedCash.class);
		return q.getResultList();
	}

	@Override
	public List<ViewClosedCash> findAll()
	{
		Query q = entityManager.createNativeQuery("select * from "+ViewClosedCash.class.getAnnotation(Table.class).name(), ViewClosedCash.class);
		return q.getResultList();
	}

}
