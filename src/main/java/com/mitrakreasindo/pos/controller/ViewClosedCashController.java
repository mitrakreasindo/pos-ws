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

import com.mitrakreasindo.pos.entities.ViewClosedCash;
import com.mitrakreasindo.pos.service.ViewClosedCashService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/closedcash", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViewClosedCashController
{

	@Autowired
	private ViewClosedCashService viewClosedCashService;
	
	@GetMapping(value = "/{receipt_id}")
	public ViewClosedCash findById(@PathVariable("receipt_id") String receiptId)
	{
		return viewClosedCashService.find(receiptId);
	}
		
	@GetMapping(value = "/money/{moneyId}")
	public List<ViewClosedCash> findByMoneyId(@PathVariable("moneyId") String moneyId)
	{
		return viewClosedCashService.findByMoney(moneyId);
	}
	
	@GetMapping
	public List<ViewClosedCash> findAll()
	{
		return viewClosedCashService.findAll();
	}
}
