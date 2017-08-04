/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.HashMap;

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
  public HashMap<Integer, String> post(String merchantCode, Category category)
  {
    MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("category_id", category.getId());
    param.addValue("category_name", category.getName());
    param.addValue("parent_id", category.getParentid());
    param.addValue("text_tip", category.getTexttip());
    param.addValue("category_showname", category.isCatshowname());
    param.addValue("category_image", category.getImage());
    param.addValue("category_colour", category.getColour());
    param.addValue("category_order", category.getCatorder());
        
    return executeProcedure("insert_category", merchantCode, param);
  }


  
  @Override
  public HashMap<Integer, String> put(String merchantCode, String id, Category category)
  {
    MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("category_id", category.getId());
    param.addValue("category_name", category.getName());
    param.addValue("parent_id", category.getParentid());
    param.addValue("text_tip", category.getTexttip());
    param.addValue("category_showname", category.isCatshowname());
    param.addValue("category_image", category.getImage());
    param.addValue("category_colour", category.getColour());
    param.addValue("category_order", category.getCatorder());
        
    return executeProcedure("update_category", merchantCode, param);
  }

  
  @Override
  public HashMap<Integer, String> delete(String merchantCode, String id)
  {
    MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("category_id", id);
    
    return executeProcedure("delete_category", merchantCode, param);    
  }
	

}
