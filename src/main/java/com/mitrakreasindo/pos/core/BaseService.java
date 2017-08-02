/**
 * 
 */
package com.mitrakreasindo.pos.core;

import java.util.HashMap;
import java.util.List;

/**
 * @author miftakhul
 *
 */
public interface BaseService<T>
{
	HashMap<Integer, String> post(String merchantCode, T t);
  
	HashMap<Integer, String> put(String merchantCode, String id, T t);
  
	HashMap<Integer, String> delete(String merchantCode, String id);
  
  T find(String merchantCode, String id);
  
  List<T> findAll(String merchantCode);
  
  int count(String merchantCode);
  
}
