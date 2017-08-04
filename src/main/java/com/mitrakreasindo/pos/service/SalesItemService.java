/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.List;

import com.mitrakreasindo.pos.entities.Product;

/**
 * @author miftakhul
 *
 */
public interface SalesItemService
{

	List<Product> findAllProduct();
	
}
