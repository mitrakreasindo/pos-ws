/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.entities.ViewSalesItem;
import com.mitrakreasindo.pos.service.ViewSalesItemService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/viewsales", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViewSalesItemController
{

	@Autowired
	private ViewSalesItemService service;
	
	@GetMapping(value="/salesitems/{id}")
  public ViewSalesItem find(@PathVariable("id") String id)
  {
  	return service.find(id);
  }
  
  @GetMapping(value="/salesitems")
  public List<ViewSalesItem> findAll()
  {
  	return service.findAll();
  }
  
  @GetMapping(value="/{salesid}/salesitems")
  public List<ViewSalesItem> findAll(@PathVariable("salesid") String salesid)
  {
  	return service.findAll(salesid);
  }
	
}
