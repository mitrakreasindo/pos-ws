/**
 * 
 */
package com.mitrakreasindo.pos.service;

import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.Receipt;

/**
 * @author miftakhul
 *
 */
@Service
public class ReceiptServiceImpl extends BaseServiceImpl<Receipt> implements ReceiptService
{

	/**
	 * @param t
	 */
	public ReceiptServiceImpl()
	{
		super(Receipt.class);
	}

}
