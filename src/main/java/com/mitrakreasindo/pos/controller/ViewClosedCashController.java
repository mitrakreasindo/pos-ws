/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/api/closedcash")
public class ViewClosedCashController
{

	@Autowired
	private ViewClosedCashService viewClosedCashService;
	
	@GetMapping(value = "/{codeMerchant}/{receipt_id}")
	public ViewClosedCash findById(@PathVariable("codeMerchant") String codeMerchant, @PathVariable("receipt_id") String receiptId)
	{
		return viewClosedCashService.find(codeMerchant, receiptId);
	}
		
	@GetMapping(value = "/{codeMerchant}/money/{moneyId}")
	public List<ViewClosedCash> findByMoneyId(@PathVariable("codeMerchant") String codeMerchant, @PathVariable("moneyId") String moneyId)
	{
		return viewClosedCashService.findByMoney(codeMerchant, moneyId);
	}
	
	@GetMapping(value = "/{codeMerchant}")
	public List<ViewClosedCash> findAll(@PathVariable("codeMerchant") String codeMerchant)
	{
		return viewClosedCashService.findAll(codeMerchant);
	}
}
