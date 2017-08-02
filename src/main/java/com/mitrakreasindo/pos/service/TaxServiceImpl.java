/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.HashMap;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.Tax;
import com.mitrakreasindo.pos.util.GeneralFunction;

/**
 * @author miftakhul
 *
 */
@Service
public class TaxServiceImpl extends BaseServiceImpl<Tax> implements TaxService
{

	/**
	 * @param t
	 */
	public TaxServiceImpl()
	{
		super(Tax.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HashMap<Integer, String> post(String merchantCode, Tax t)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("tax_id", GeneralFunction.checkNullString(t.getId()));
    param.addValue("tax_name", GeneralFunction.checkNullString(t.getName()));
    param.addValue("taxcat_id", GeneralFunction.checkNullString(t.getCategory().getId()));
    param.addValue("tax_rate", t.getRate());
    
		return executeProcedure("insert_taxes_and_taxcategories", merchantCode, param);
	}

	
	@Override
	public HashMap<Integer, String> put(String merchantCode, String id, Tax t)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("tax_id", GeneralFunction.checkNullString(t.getId()));
    param.addValue("tax_name", GeneralFunction.checkNullString(t.getName()));
    param.addValue("taxcat_id", GeneralFunction.checkNullString(t.getCategory().getId()));
    param.addValue("tax_rate", t.getRate());
    
		return executeProcedure("update_taxes_and_taxcategories", merchantCode, param);
	}

	
	@Override
	public HashMap<Integer, String> delete(String merchantCode, String id)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("tax_id", id);
    
		return executeProcedure("delete_taxes_and_taxcategories", merchantCode, param);
	}

}
