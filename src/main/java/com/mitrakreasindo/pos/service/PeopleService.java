package com.mitrakreasindo.pos.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import com.mitrakreasindo.pos.core.BaseService;
import com.mitrakreasindo.pos.entities.Login;
import com.mitrakreasindo.pos.entities.People;

public interface PeopleService extends BaseService<People>
{
	
	HashMap<Integer, String> login(Login login);
	
	List<People> findPeopleOnSales();
	
	List<People> findPeopleOnViewSales();
	
	List<String> findPeopleIdOnViewSales(Timestamp fromDate, Timestamp toDate);
	
}
