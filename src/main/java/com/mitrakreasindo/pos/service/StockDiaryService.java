package com.mitrakreasindo.pos.service;

import java.util.HashMap;
import java.util.List;

import com.mitrakreasindo.pos.entities.StockDiary;

public interface StockDiaryService
{
	HashMap<Integer, String> post(StockDiary stockDiary);
	
	StockDiary find(String id);
  
  List<StockDiary > findAll();
  
  int count();
  
}
