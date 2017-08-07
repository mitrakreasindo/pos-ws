/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.List;

import com.mitrakreasindo.pos.entities.ViewClosedCash;

/**
 * @author miftakhul
 *
 */
public interface ViewClosedCashService
{

	ViewClosedCash find(String merchantCode, String id);
	
	List<ViewClosedCash> findAll(String merchantCode);
	
	List<ViewClosedCash> findByMoney(String codeMerchant, String moneyId);
	
}
