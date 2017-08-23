/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.sql.Timestamp;
import java.util.List;

import com.mitrakreasindo.pos.entities.ViewSalesItem;

/**
 * @author miftakhul
 *
 */
public interface ViewSalesItemService
{

	ViewSalesItem find(String id);
	
	List<ViewSalesItem> findAll();
	
	List<ViewSalesItem> findAll(String saleId);
	
	List<ViewSalesItem> findAllByCategoryId(String categoryId, Timestamp fromDate, Timestamp toDate);
	
}
