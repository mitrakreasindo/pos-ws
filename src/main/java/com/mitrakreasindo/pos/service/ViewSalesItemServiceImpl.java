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
import com.mitrakreasindo.pos.entities.ViewSalesItem;

/**
 * @author miftakhul
 *
 */
@Service
public class ViewSalesItemServiceImpl extends BaseServiceImpl<ViewSalesItem> implements ViewSalesItemService
{

	public ViewSalesItemServiceImpl()
	{
		super(ViewSalesItem.class);
	}


	
	@Override
	public List<ViewSalesItem> findAll(String salesId)
	{
		try
    {
      Query q = entityManager.createNativeQuery("SELECT * FROM " + t.getAnnotation(Table.class).name() + " where sales_id = '" + salesId + "' and sflag = true", ViewSalesItem.class);
      return q.getResultList();
    }
    catch (Exception e)
    {
      return null;
    }
	}
	
	@Override
	public List<ViewSalesItem> findAllByCategoryId(String categoryId, Timestamp fromDate,
			Timestamp toDate)
	{
		Query q = entityManager.createNativeQuery(""
				+ "select si.* from categories as c, products as p, "
				+"viewsales as s, viewsalesitems as si where si.sales_id = s.id "
						+ "and p.id = si.product and c.id = p.category and s.datenew between '"+fromDate.toString()+"' "
								+ "AND '"+toDate.toString()+"' and c.id = '"+categoryId+"'", ViewSalesItem.class);
		return q.getResultList();
	}
	
}
