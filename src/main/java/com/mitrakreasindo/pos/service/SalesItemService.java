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

	SalesItem find(String id);
	
	List<SalesItem> findAll();
	
	List<SalesItem> findAllBySalesId(String salesId);
	
}