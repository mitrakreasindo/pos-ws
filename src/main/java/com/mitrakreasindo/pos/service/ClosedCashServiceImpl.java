package com.mitrakreasindo.pos.service;
import java.util.HashMap;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.ClosedCash;

/**
 * 
 */

/**
 * @author miftakhul
 *
 */
@Service
public class ClosedCashServiceImpl extends BaseServiceImpl<ClosedCash> implements ClosedCashService
{

	/**
	 * @param t
	 */
	public ClosedCashServiceImpl()
	{
		super(ClosedCash.class);
	}

	@Override
	public HashMap<Integer, String> post(ClosedCash closedCash)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("money_id", closedCash.getMoney());
		param.addValue("host_name", closedCash.getHost());
		param.addValue("date_end", closedCash.getDateend());
		
		return executeProcedure("close_cash", param);
	}

}
