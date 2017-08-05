package com.mitrakreasindo.pos.service;

import java.util.HashMap;
import java.util.List;

import com.mitrakreasindo.pos.entities.Sale;
import com.mitrakreasindo.pos.entities.SalesPack;

public interface SalesService
{
	
	HashMap<Integer, String> post(String codeMerchant, SalesPack salesPack);
	
	List<Sale> findSalesByPeopleId(String merchantCode, String peopleId);
	
}
