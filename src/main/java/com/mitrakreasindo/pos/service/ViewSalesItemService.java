/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.List;

import com.mitrakreasindo.pos.entities.ViewSalesItem;

/**
 * @author miftakhul
 *
 */
public interface ViewSalesItemService
{

	ViewSalesItem find(String merchantCode, String id);
	
	List<ViewSalesItem> findAll(String merchantCode);
	
	List<ViewSalesItem> findAll(String merchantCode, String saleId);

}
