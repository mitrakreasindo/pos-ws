/**
 * 
 */
package com.mitrakreasindo.pos.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.entities.Merchant;

/**
 * @author miftakhul
 *
 */
@Service
public class MerchantServiceImpl  implements MerchantService
{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Merchant findByMerchantCode(String merchantCode)
	{
		
		Query q = entityManager.createNativeQuery("Select * from "+Merchant.class.getAnnotation(Table.class).name()+ " where code = '"+merchantCode+"'", Merchant.class);
		return (Merchant) q.getSingleResult();
	}

}
