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

import com.mitrakreasindo.pos.entities.MerchantCategory;

/**
 * @author mitradev
 *
 */
@Service
public class MerchantCategoryServiceImpl implements MerchantCategoryService
{
	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public List<MerchantCategory> findAll(String merchantCode)
	{
		try
    {
      Query q = entityManager.createNativeQuery("SELECT * FROM " + merchantCode + "." + MerchantCategory.class.getAnnotation(Table.class).name() + " where sflag = true", MerchantCategory.class);
      return q.getResultList();
    }
    catch (Exception e)
    {
      return null;
    }
	}

	@Override
	public List<MerchantCategory> findName(String merchantCode)
	{
		Query query = entityManager.createNativeQuery("select distinct on(name)id, name, subcategory, sflag \n" +
	      "from "+merchantCode+"." + MerchantCategory.class.getAnnotation(Table.class).name() + " \n" +
	      "where sflag = true \n"+
	      "order by name", MerchantCategory.class);
	    return query.getResultList();
	}

	@Override
	public List<MerchantCategory> findSub(String merchantCode, String name)
	{
    Query query = entityManager.createNativeQuery("select id, name, subcategory, sflag \n" +
        "from "+merchantCode+"." + MerchantCategory.class.getAnnotation(Table.class).name() + "\n" +
        "where sflag = true \n" +
        "and name = '"+name+"'", MerchantCategory.class);
      return query.getResultList();
	}

}
