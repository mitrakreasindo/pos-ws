/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.HashMap;

/**
 * @author miftakhul
 *
 */
public interface PaymentService
{

	HashMap<Integer, String> update(String receiptId, float tendered);
	
}
