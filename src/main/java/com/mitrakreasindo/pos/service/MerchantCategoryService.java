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

	List<MerchantCategory> findAll(String merchantCode);
	
	List<MerchantCategory> findName(String merchantCode);
	
	List<MerchantCategory> findSub(String merchantCode, String name);
	
}
