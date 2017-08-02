/**
 * 
 */
package com.mitrakreasindo.pos.service;

import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.ViewSale;

/**
 * @author miftakhul
 *
 */
@Service
public class ViewSalesServiceImpl extends BaseServiceImpl<ViewSale> implements ViewSalesService
{

	public ViewSalesServiceImpl()
	{
		super(ViewSale.class);
	}
	
}
