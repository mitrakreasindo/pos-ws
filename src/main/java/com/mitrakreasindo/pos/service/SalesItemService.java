/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.List;

import com.mitrakreasindo.pos.entities.SalesItem;

/**
 * @author miftakhul
 *
 */
public interface SalesItemService
{

	SalesItem find(String merchantCode, String id);
	
	List<SalesItem> findAll(String merchantCode);
	
	List<SalesItem> findAllBySalesId(String merchantCode, String salesId);
	
}