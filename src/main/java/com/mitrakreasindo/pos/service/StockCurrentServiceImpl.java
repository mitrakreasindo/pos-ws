package com.mitrakreasindo.pos.service;

import java.util.HashMap;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.StockCurrent;
import com.mitrakreasindo.pos.util.GeneralFunction;

@Service
public class StockCurrentServiceImpl extends BaseServiceImpl<StockCurrent> implements StockCurrentService
{

	public StockCurrentServiceImpl()
	{
		super(StockCurrent.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HashMap<Integer, String> post(StockCurrent stockCurrent)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id", GeneralFunction.checkNullString(stockCurrent.getProduct()));
		param.addValue("product_location", GeneralFunction.checkNullString(stockCurrent.getLocation()));
		param.addValue("attributeset_instance_id", GeneralFunction.checkNullString(stockCurrent.getAttributesetinstance_id()));
		param.addValue("product_units", stockCurrent.getUnits());
		
		return executeProcedure("update_stockcurrent", param);
	}

}
