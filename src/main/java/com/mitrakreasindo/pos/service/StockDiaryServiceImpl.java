package com.mitrakreasindo.pos.service;

import java.util.HashMap;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.StockDiary;
import com.mitrakreasindo.pos.util.GeneralFunction;

@Service
public class StockDiaryServiceImpl extends BaseServiceImpl<StockDiary> implements StockDiaryService
{

	public StockDiaryServiceImpl()
	{
		super(StockDiary.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HashMap<Integer, String> post(StockDiary stockDiary)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		String validator = "";
    param.addValue("stockdiary_id", GeneralFunction.checkNullString(stockDiary.getId()));
    param.addValue("date_new", GeneralFunction.checkNullDate(stockDiary.getDatenew()));
    param.addValue("diary_reason", stockDiary.getReason());
    
    validator = "";
    if(stockDiary.getLocation() != null) validator = stockDiary.getLocation().getId();
    param.addValue("product_location", GeneralFunction.checkNullString(validator));
    
    validator = "";
    if(stockDiary.getProduct()!= null) validator = stockDiary.getProduct().getId();
    param.addValue("product_id", GeneralFunction.checkNullString(validator));
    
    validator = "";
    if(stockDiary.getAttributesetinstanceId() != null) validator = stockDiary.getAttributesetinstanceId().getId();
    param.addValue("attribute_set_instance_id", GeneralFunction.checkNullString(validator));
    
    param.addValue("product_units", stockDiary.getUnits());
    param.addValue("price", stockDiary.getPrice());
    param.addValue("app_user", GeneralFunction.checkNullString(stockDiary.getAppuser()));
		
    return executeProcedure("insert_stockdiary", param);
	}

}
