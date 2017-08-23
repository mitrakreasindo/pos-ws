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
  
	List<Category> findCategoriesFromSalesItem(Timestamp fromDate, Timestamp toDate);
	
	List<Category> findParentCategoriesFromSalesItem(Timestamp fromDate, Timestamp toDate);
	
	List<Category> findSubCategoriesFromSalesItem(Timestamp fromDate, Timestamp toDate);
	
	List<Category> findSubCategoriesFromSalesItemByCategoryId(String categoryId, Timestamp fromDate, Timestamp toDate);
	
}
