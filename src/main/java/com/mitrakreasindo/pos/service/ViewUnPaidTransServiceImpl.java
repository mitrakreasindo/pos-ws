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

import com.mitrakreasindo.pos.entities.ViewUnPaidTrans;

/**
 * @author miftakhul
 *
 */
@Service
public class ViewUnPaidTransServiceImpl implements ViewUnPaidTransService
{

	@PersistenceContext
	EntityManager entityManager;
	
	public ViewUnPaidTrans find(String merchantCode, String id)
  {
    try
    {
      Query q = entityManager.createNativeQuery("SELECT * FROM " + merchantCode + "." + ViewUnPaidTrans.class.getAnnotation(Table.class).name() + " where receipt_id = '" + id + "'", ViewUnPaidTrans.class);
      return (ViewUnPaidTrans) q.getSingleResult();
    }
    catch (Exception e)
    {
      return null;
    }
  }

  public List<ViewUnPaidTrans> findAll(String merchantCode)
  {
    try
    {
      Query q = entityManager.createNativeQuery("SELECT * FROM " + merchantCode + "." + ViewUnPaidTrans.class.getAnnotation(Table.class).name(), ViewUnPaidTrans.class);
      return q.getResultList();
    }
    catch (Exception e)
    {
      return null;
    }
  }

	
}
