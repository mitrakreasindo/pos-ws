/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.sql.Timestamp;
import java.util.List;

import com.mitrakreasindo.pos.entities.ViewSale;

/**
 * @author miftakhul
 *
 */
public interface ViewSalesService
{

	ViewSale find(String id);

	List<ViewSale> findAll();
	
	List<ViewSale> findAllByPeopleId(String personId);
	
	List<ViewSale> findAllByPeopleId(String personId, Timestamp fromDate, Timestamp toDate);
	
}
