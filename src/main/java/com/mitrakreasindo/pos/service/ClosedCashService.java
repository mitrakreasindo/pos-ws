/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.HashMap;

import com.mitrakreasindo.pos.entities.ClosedCash;

/**
 * @author miftakhul
 *
 */
public interface ClosedCashService
{

	HashMap<Integer, String> post(ClosedCash closedCash);
	
}
