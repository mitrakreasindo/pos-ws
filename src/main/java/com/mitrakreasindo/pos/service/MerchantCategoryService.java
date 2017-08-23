/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.List;

import com.mitrakreasindo.pos.entities.MerchantCategory;

/**
 * @author mitradev
 *
 */
public interface MerchantCategoryService
{

	List<MerchantCategory> findAll();
	
	List<MerchantCategory> findName();
	
	List<MerchantCategory> findSub(String name);
	
}
