package com.mitrakreasindo.pos.service;

import java.util.HashMap;
import java.util.List;

import com.mitrakreasindo.pos.entities.StockDiary;

public interface StockDiaryService
{
	HashMap<Integer, String> post(String merchantCode, StockDiary stockDiary);
	
	StockDiary find(String merchantCode, String id);
  
  List<StockDiary > findAll(String merchantCode);
  
  int count(String merchantCode);
  
}
