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

	ViewClosedCash find(String id);
	
	List<ViewClosedCash> findAll();
	
	List<ViewClosedCash> findByMoney(String moneyId);
	
}
