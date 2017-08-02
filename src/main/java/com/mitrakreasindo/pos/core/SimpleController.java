/**
 * 
 */
package com.mitrakreasindo.pos.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author miftakhul
 *
 */
public abstract class SimpleController<T, ID extends Serializable, Service extends BaseService<T>>
{
  @Autowired
  protected Service service;
  
  @PostMapping(value="/{merchantCode}")
  public HashMap<Integer, String> post(@PathVariable("merchantCode") String merchantCode, @RequestBody T t)
  {
  	return service.post(merchantCode, t);
  }
  
  @PutMapping(value="/{merchantCode}/{id}")
  public HashMap<Integer, String> put(@PathVariable("merchantCode") String merchantCode, @PathVariable("id") String id, @RequestBody T t)
  {
  	return service.put(merchantCode, id, t);
  }
  
  @DeleteMapping(value="/{merchantCode}/{id}")
  public HashMap<Integer, String> delete(@PathVariable("merchantCode") String merchantCode, @PathVariable("id") String id)
  {
  	return service.delete(merchantCode, id);
  }
  
  @GetMapping(value="/{merchantCode}/{id}")
  public T find(@PathVariable("merchantCode") String merchantCode, @PathVariable("id") String id)
  {
  	return (T) service.find(merchantCode, id);
  }
  
  @GetMapping(value="/{merchantCode}")
  public List<T> findAll(@PathVariable("merchantCode") String merchantCode)
  {
  	return service.findAll(merchantCode);
  }
  
  @GetMapping(value="/{merchantCode}/count",produces=MediaType.TEXT_PLAIN_VALUE)
  public int count(@PathVariable("merchantCode") String merchantCode)
  {
  	return service.count(merchantCode);
  }
  
}
