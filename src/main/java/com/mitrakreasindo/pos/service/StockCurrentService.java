package com.mitrakreasindo.pos.service;

import java.util.HashMap;

import com.mitrakreasindo.pos.entities.StockCurrent;

public interface StockCurrentService
{

	HashMap<Integer, String> post(StockCurrent stockCurrent);
	
}
