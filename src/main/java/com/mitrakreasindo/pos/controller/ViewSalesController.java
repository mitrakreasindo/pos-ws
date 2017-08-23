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

import com.mitrakreasindo.pos.entities.ViewSale;
import com.mitrakreasindo.pos.service.ViewSalesService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/viewsales", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViewSalesController
{

	@Autowired
	private ViewSalesService service;
	
	@GetMapping(value="/{id}")
  public ViewSale find(@PathVariable("id") String id)
  {
  	return service.find(id);
  }
  
  @GetMapping
  public List<ViewSale> findAll()
  {
  	return service.findAll();
  }
	
}
