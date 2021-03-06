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

import com.mitrakreasindo.pos.entities.ViewUnPaidTrans;
import com.mitrakreasindo.pos.service.ViewUnPaidTransService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/viewunpaidtrans", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViewUnPaidTransController
{

	@Autowired
	private ViewUnPaidTransService service;
	
	@GetMapping(value="/{receiptId}")
  public ViewUnPaidTrans find(@PathVariable("receiptId") String receiptId)
  {
  	return service.find(receiptId);
  }
  
  @GetMapping
  public List<ViewUnPaidTrans> findAll()
  {
  	return service.findAll();
  }
	
}
