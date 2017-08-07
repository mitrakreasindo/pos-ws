/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.entities.SalesPack;
import com.mitrakreasindo.pos.service.SalesService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/sales", produces = MediaType.APPLICATION_JSON_VALUE)
public class SalesController
{

	@Autowired
	private SalesService salesService;
	
	@PostMapping(value = "/{merchantCode}")
	public HashMap<Integer, String> post(@PathVariable("merchantCode") String merchantCode, @RequestBody SalesPack salesPack)
	{
		return salesService.post(merchantCode, salesPack);
	}
	
}
