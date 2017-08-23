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
import org.springframework.web.bind.annotation.RequestHeader;


/**
 * @author miftakhul
 *
 */
public abstract class SimpleController<T, ID extends Serializable, Service extends BaseService<T>>
{
  @Autowired
  protected Service service;
  
  @PostMapping
  public HashMap<Integer, String> post(@RequestBody T t)
  {
  	return service.post(t);
  }
  
  @PutMapping(value="/{id}")
  public HashMap<Integer, String> put(@PathVariable("id") String id, @RequestBody T t)
  {
  	return service.put(id, t);
  }
  
  @DeleteMapping(value="/{id}")
  public HashMap<Integer, String> delete(@PathVariable("id") String id)
  {
  	return service.delete(id);
  }
  
  @GetMapping(value="/{id}")
  public T find(@PathVariable("id") String id)
  {
  	return (T) service.find(id);
  }
  
  @GetMapping
  public List<T> findAll()
  {
  	return service.findAll();
  }
  
  @GetMapping(value="/count",produces=MediaType.TEXT_PLAIN_VALUE)
  public int count()
  {
  	return service.count();
  }
  
}
