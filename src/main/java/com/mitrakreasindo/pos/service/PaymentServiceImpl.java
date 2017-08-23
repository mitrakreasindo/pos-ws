/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.HashMap;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.Payment;

/**
 * @author miftakhul
 *
 */
@Service
public class PaymentServiceImpl extends BaseServiceImpl<Payment> implements PaymentService
{

	/**
	 * @param t
	 */
	public PaymentServiceImpl()
	{
		super(Payment.class);
	}

	@Override
	public HashMap<Integer, String> update(String receiptId, float tendered)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("receipt_id", receiptId);
    param.addValue("tendered_amount", tendered);
        
    return executeProcedure("update_payment", param);
	}

}
