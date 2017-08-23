/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.List;

import com.mitrakreasindo.pos.entities.ViewUnPaidTrans;

/**
 * @author miftakhul
 *
 */
public interface ViewUnPaidTransService
{

	ViewUnPaidTrans find(String id);

	List<ViewUnPaidTrans> findAll();
	
}
