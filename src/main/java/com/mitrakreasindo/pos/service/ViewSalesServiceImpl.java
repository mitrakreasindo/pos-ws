/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.ViewSale;

/**
 * @author miftakhul
 *
 */
@Service
public class ViewSalesServiceImpl extends BaseServiceImpl<ViewSale> implements ViewSalesService
{

	public ViewSalesServiceImpl()
	{
		super(ViewSale.class);
	}

	@Override
	public List<ViewSale> findAllByPeopleId(String personId)
	{
		Query q = entityManager.createNativeQuery("SELECT * FROM "+ViewSale.class.getAnnotation(Table.class).name()+" WHERE person = '"+personId+"'", ViewSale.class);
		return q.getResultList();
	}
	
	@Override
	public List<ViewSale> findAllByPeopleId(String personId, Timestamp fromDate, Timestamp toDate)
	{
		Query q = entityManager.createNativeQuery("SELECT * FROM "+ViewSale.class.getAnnotation(Table.class).name()+" WHERE person = '"+personId+"' AND datenew between '"+fromDate.toString()+"' AND '"+toDate.toString()+"'", ViewSale.class);
		return q.getResultList();
	}

	
}
