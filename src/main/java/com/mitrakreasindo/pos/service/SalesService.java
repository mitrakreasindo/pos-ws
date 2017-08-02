package com.mitrakreasindo.pos.service;

import java.util.HashMap;

import com.mitrakreasindo.pos.entities.SalesPack;

public interface SalesService
{
	
	HashMap<Integer, String> post(String codeMerchant, SalesPack salesPack);
	
}
