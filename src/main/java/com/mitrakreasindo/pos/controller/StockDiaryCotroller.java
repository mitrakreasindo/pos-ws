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
@RequestMapping(value = "/api/stocks", produces = MediaType.APPLICATION_JSON_VALUE)
public class StockDiaryCotroller
{
	
	@Autowired
	private StockDiaryService service;
	
	@PostMapping(value="/diary")
  public HashMap<Integer, String> post(@RequestBody StockDiary stockDiary)
  {
  	return service.post(stockDiary);
  }
	
	@GetMapping(value="/diary/{id}")
  public StockDiary find(@PathVariable("id") String id)
  {
  	return service.find(id);
  }
  
  @GetMapping(value="/diary")
  public List<StockDiary> findAll()
  {
  	return service.findAll();
  }
  
  @GetMapping(value="/diary/count",produces=MediaType.TEXT_PLAIN_VALUE)
  public int count()
  {
  	return service.count();
  }
}
