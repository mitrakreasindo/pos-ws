/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.sql.Timestamp;
import java.util.List;

import com.mitrakreasindo.pos.core.BaseService;
import com.mitrakreasindo.pos.entities.Category;

/**
 * @author miftakhul
 *
 */
public interface CategoryService extends BaseService<Category>
{
  
	List<Category> findCategoriesFromSalesItem(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
}
