/**
 * 
 */
package com.mitrakreasindo.pos.service;

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
	public List<ViewSalesItem> findAll(String merchantCode, String salesId)
	{
		try
    {
      Query q = entityManager.createNativeQuery("SELECT * FROM " + merchantCode + "." + t.getAnnotation(Table.class).name() + " where salesId = '" + salesId + "' and sflag = true", ViewSalesItem.class);
      return q.getResultList();
    }
    catch (Exception e)
    {
      return null;
    }
	}
	
}
