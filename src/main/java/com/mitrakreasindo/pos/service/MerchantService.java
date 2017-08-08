/**
 * 
 */
package com.mitrakreasindo.pos.service;

import com.mitrakreasindo.pos.entities.Merchant;

/**
 * @author miftakhul
 *
 */
public interface MerchantService
{
	
	Merchant findByMerchantCode(String merchantCode);
	
}
