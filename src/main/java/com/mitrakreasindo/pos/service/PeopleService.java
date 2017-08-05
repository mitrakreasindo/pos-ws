package com.mitrakreasindo.pos.service;

import java.util.HashMap;
import java.util.List;

import com.mitrakreasindo.pos.core.BaseService;
import com.mitrakreasindo.pos.entities.Login;
import com.mitrakreasindo.pos.entities.People;

public interface PeopleService extends BaseService<People>
{
	
	HashMap<Integer, String> login(String merchantCode, Login login);
	
	List<People> findPeopleOnSales(String merchantCode);
	
}
