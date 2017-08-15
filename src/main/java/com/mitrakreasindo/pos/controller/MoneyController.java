/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.service.Money;
import com.mitrakreasindo.pos.service.MoneyService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/monies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoneyController
{
	
	@Autowired
	private MoneyService service;

	@GetMapping(value="{merchantCode}/cost")
	public Money getCosh(@PathVariable("merchantCode") String merchantCode)
	{
		return service.getCostInfo(merchantCode);		
	}
	
	@GetMapping(value="{merchantCode}/revenue")
	public Money getRevenue(@PathVariable("merchantCode") String merchantCode)
	{
		return service.getRevenueInfo(merchantCode);
	}
	
}
