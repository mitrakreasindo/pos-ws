/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.SalesItem;

/**
 * @author miftakhul
 *
 */
@Service
public class SalesItemServiceImpl extends BaseServiceImpl<SalesItem> implements SalesItemService
{

	/**
	 * @param t
	 */
	public SalesItemServiceImpl()
	{
		super(SalesItem.class);
	}


	@Override
	public List<SalesItem> findAllBySalesId(String salesId)
	{
		Query q = entityManager.createNativeQuery("SELECT * FROM "+SalesItem.class.getAnnotation(Table.class).name()+"  WHERE sales_id = '"+salesId+"'", SalesItem.class);
		
		return q.getResultList();
	}
	

	
}
