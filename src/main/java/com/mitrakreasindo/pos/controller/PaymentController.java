/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.service.PaymentService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/payments")
public class PaymentController
{

	@Autowired
	PaymentService service;
	
	@PutMapping(value = "/{merchantCode}")
	public HashMap<Integer, String> update(@PathVariable("merchantCode") String merchantCode, @RequestParam("receiptId") String receiptId, @RequestParam("tendered_amount") float tenderAmount)
	{
		return service.update(merchantCode, receiptId, tenderAmount);
	}
	
}
