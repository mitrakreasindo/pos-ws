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

import com.mitrakreasindo.pos.entities.Receipt;
import com.mitrakreasindo.pos.service.ReceiptService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/receipts", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceiptController
{

	@Autowired
	private ReceiptService service;
	
	@GetMapping(value="/{merchantCode}/{id}")
  public Receipt find(@PathVariable("merchantCode") String merchantCode, @PathVariable("id") String id)
  {
  	return service.find(merchantCode, id);
  }
  
  @GetMapping(value="/{merchantCode}")
  public List<Receipt> findAll(@PathVariable("merchantCode") String merchantCode)
  {
  	return service.findAll(merchantCode);
  }
	
}
