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

	ViewSale find(String merchantCode, String id);

	List<ViewSale> findAll(String merchantCode);
	
	List<ViewSale> findAllByPeopleId(String merchantCode, String personId);
	
	List<ViewSale> findAllByPeopleId(String merchantCode, String personId, Timestamp fromDate, Timestamp toDate);

}
