/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.entities.Money;
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

	@GetMapping(value="/cost")
	public Money getCosh()
	{
		return service.getCostInfo();		
	}
	
	@GetMapping(value="/revenue")
	public Money getRevenue()
	{
		return service.getRevenueInfo();
	}
	
}
