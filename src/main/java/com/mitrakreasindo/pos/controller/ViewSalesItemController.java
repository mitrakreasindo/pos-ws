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
	
	@GetMapping(value="/{merchantCode}/salesitems/{id}")
  public ViewSalesItem find(@PathVariable("merchantCode") String merchantCode, @PathVariable("id") String id)
  {
  	return service.find(merchantCode, id);
  }
  
  @GetMapping(value="/{merchantCode}/salesitems")
  public List<ViewSalesItem> findAll(@PathVariable("merchantCode") String merchantCode)
  {
  	return service.findAll(merchantCode);
  }
  
  @GetMapping(value="/{merchantCode}/{salesid}/salesitems")
  public List<ViewSalesItem> findAll(@PathVariable("merchantCode") String merchantCode, @PathVariable("salesid") String salesid)
  {
  	return service.findAll(merchantCode, salesid);
  }
	
}
