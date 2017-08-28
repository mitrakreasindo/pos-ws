/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.Category;

/**
 * @author miftakhul
 *
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService
{

	@Autowired 
  DataSource dataSource;
	
  public CategoryServiceImpl()	
  {
		super(Category.class);
	}
    
  @Override
  public HashMap<Integer, String> post(Category category)
  {
    MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("category_id", category.getId());
    param.addValue("category_name", category.getName());
    param.addValue("text_tip", category.getTexttip());
    param.addValue("category_showname", category.isCatshowname());
    param.addValue("category_image", category.getImage());
    param.addValue("category_colour", category.getColour());
    param.addValue("category_order", category.getCatorder());
    
    param.addValue("parent_id", category.getParentid() != null ? 
    		category.getParentid().getId() : null );
        
    return executeProcedure("insert_category", param);
  }


  
  @Override
  public HashMap<Integer, String> put(String id, Category category)
  {
    MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("category_id", category.getId());
    param.addValue("category_name", category.getName());
    param.addValue("text_tip", category.getTexttip());
    param.addValue("category_showname", category.isCatshowname());
    param.addValue("category_image", category.getImage());
    param.addValue("category_colour", category.getColour());
    param.addValue("category_order", category.getCatorder());
        
    param.addValue("parent_id", category.getParentid() != null ? 
    		category.getParentid().getId() : null );
    
    return executeProcedure("update_category", param);
  }

  
  @Override
  public HashMap<Integer, String> delete(String id)
  {
    MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("category_id", id);
    
    return executeProcedure("delete_category", param);    
  }

  @Override
	public List<Category> findCategoriesFromSalesItem(Timestamp fromDate, Timestamp toDate)
	{
		Query q = entityManager.createNativeQuery(""
				+ "select c.* from categories as c, products as p, "
				+"viewsales as s, viewsalesitems as si where si.sales_id = s.id "
						+ "and p.id = si.product and c.id = p.category and s.datenew between '"+fromDate.toString()+"' "
								+ "AND '"+toDate.toString()+"' group by c.id", Category.class); 
		return q.getResultList();
	}
  
	@Override
	public List<Category> findParentCategoriesFromSalesItem(Timestamp fromDate, Timestamp toDate)
	{
		Query q = entityManager.createNativeQuery(""
				+ "select cP.* from categories as cP, categories as c, products as p, "
				+"viewsales as s, viewsalesitems as si where si.sales_id = s.id "
						+ "and p.id = si.product and c.id = p.category and c.parentid = cP.id and s.datenew between '"+fromDate.toString()+"' "
								+ "AND '"+toDate.toString()+"' group by cP.id", Category.class); 
		return q.getResultList();
	}
	
	@Override
	public List<Category> findSubCategoriesFromSalesItem( Timestamp fromDate, Timestamp toDate)
	{
		Query q = entityManager.createNativeQuery(""
				+ "select c.* from categories as c, products as p, "
				+"viewsales as s, viewsalesitems as si where si.sales_id = s.id "
						+ "and p.id = si.product and c.id = p.category and c.parentid is not null and s.datenew between '"+fromDate.toString()+"' "
								+ "AND '"+toDate.toString()+"' group by c.id", Category.class); 
		return q.getResultList();
	}
	
	@Override
	public List<Category> findSubCategoriesFromSalesItemByCategoryId(String categoryId, Timestamp fromDate, Timestamp toDate)
	{
		Query q = entityManager.createNativeQuery(""
				+ "select c.* from categories as c, products as p, "
				+"viewsales as s, viewsalesitems as si where si.sales_id = s.id "
						+ "and p.id = si.product and c.id = p.category and c.parentid = '"+categoryId+"' and s.datenew between '"+fromDate.toString()+"' "
								+ "AND '"+toDate.toString()+"' group by c.id", Category.class); 
		return q.getResultList();
	}
	
}
