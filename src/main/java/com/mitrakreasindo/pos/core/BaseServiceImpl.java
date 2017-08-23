/**
 * 
 */
package com.mitrakreasindo.pos.core;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.mitrakreasindo.pos.config.TenantContext;


/**
 * @author miftakhul
 *
 */
public abstract class BaseServiceImpl<T>
{

  @Autowired
  DataSource dataSource;
  
  @PersistenceContext
  protected EntityManager entityManager;
  
  protected Class<T> t;
  
  public BaseServiceImpl(Class<T> t)
  {
    this.t = t;
  }
  
//  protected HashMap<Integer, String> executeProcedure(String spName, String schemaName, SqlParameterSource param)
//  {
//    SimpleJdbcCall call = new SimpleJdbcCall(dataSource);
//    call.withProcedureName(spName);
//    call.setSchemaName(schemaName);
//    
//    Map<String, Object> out = call.execute(param);
//    HashMap<Integer, String> result = new HashMap<Integer, String>();
//    
//    result.put(Integer.parseInt(out.get("retval").toString()), out.get("message").toString());
//    
//    return result;
//  }
 
  protected HashMap<Integer, String> executeProcedure(String spName, SqlParameterSource param)
  {
    SimpleJdbcCall call = new SimpleJdbcCall(dataSource);
    call.withProcedureName(spName);
    call.setSchemaName(TenantContext.getCurrentSchema());
    
    Map<String, Object> out = call.execute(param);
    HashMap<Integer, String> result = new HashMap<Integer, String>();
    
    result.put(Integer.parseInt(out.get("retval").toString()), out.get("message").toString());
    
    return result;
  }
  
  public T find(String id)
  {
    try
    {
      Query q = entityManager.createNativeQuery("SELECT * FROM " + t.getAnnotation(Table.class).name() + " where id = '" + id + "' and sflag = true", t);
      return (T) q.getSingleResult();
    }
    catch (Exception e)
    {
      return null;
    }
  }

  public List<T> findAll()
  {
    try
    {
    	Query q = entityManager.createNativeQuery("SELECT * FROM " + t.getAnnotation(Table.class).name() + " where sflag = true", t);
      return q.getResultList();
    }
    catch (Exception e)
    {
      return null;
    }
  }

  public int count()
  {
    try
    {
      Query q = entityManager.createNativeQuery("SELECT count(id) FROM " +t.getAnnotation(Table.class).name() + " where sflag = true");
      BigInteger result = (BigInteger)q.getSingleResult();
      return result.intValue();
    }
    catch (Exception e)
    {
      return 0;
    }
  }
  
}
