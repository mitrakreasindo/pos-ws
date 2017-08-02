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

import com.mitrakreasindo.pos.entities.ClosedCash;
import com.mitrakreasindo.pos.service.ClosedCashService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/closedcashes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClosedCashController
{

	@Autowired
	private ClosedCashService service;
	
	@PostMapping("/{merchantCode}")
	public HashMap<Integer, String> post(@PathVariable("merchantCode") String merchantCode, @RequestBody ClosedCash closedCash)
	{
		return service.post(merchantCode, closedCash);
	}
	
}
