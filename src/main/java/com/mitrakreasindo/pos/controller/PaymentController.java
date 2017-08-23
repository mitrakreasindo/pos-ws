/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping(value = "/api/payments", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController
{

	@Autowired
	PaymentService service;
	
	@PutMapping
	public HashMap<Integer, String> update(@RequestParam("receiptId") String receiptId, @RequestParam("tendered_amount") float tenderAmount)
	{
		return service.update(receiptId, tenderAmount);
	}
	
}
