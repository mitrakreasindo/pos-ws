/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.List;

import com.mitrakreasindo.pos.entities.Receipt;

/**
 * @author miftakhul
 *
 */
public interface ReceiptService
{

	Receipt find(String merchantCode, String id);

	List<Receipt> findAll(String merchantCode);
	
}
