/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.entities.StockDiary;
import com.mitrakreasindo.pos.service.StockDiaryService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/stockcurrents", produces = MediaType.APPLICATION_JSON_VALUE)
public class StockDiaryCotroller
{
	
	@Autowired
	private StockDiaryService service;
	
	@PostMapping(value="/{merchantCode}")
  public HashMap<Integer, String> post(@PathVariable("merchantCode") String merchantCode, @RequestBody StockDiary stockDiary)
  {
  	return service.post(merchantCode, stockDiary);
  }
	
	@GetMapping(value="/{merchantCode}/{id}")
  public StockDiary find(@PathVariable("merchantCode") String merchantCode, @PathVariable("id") String id)
  {
  	return service.find(merchantCode, id);
  }
  
  @GetMapping(value="/{merchantCode}")
  public List<StockDiary> findAll(@PathVariable("merchantCode") String merchantCode)
  {
  	return service.findAll(merchantCode);
  }
  
  @GetMapping(value="/{merchantCode}/count",produces=MediaType.TEXT_PLAIN_VALUE)
  public int count(@PathVariable("merchantCode") String merchantCode)
  {
  	return service.count(merchantCode);
  }
}
