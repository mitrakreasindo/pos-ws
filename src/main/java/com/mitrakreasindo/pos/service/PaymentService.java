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

	HashMap<Integer, String> update(String merchantCode, String receiptId, float tendered);
	
}
