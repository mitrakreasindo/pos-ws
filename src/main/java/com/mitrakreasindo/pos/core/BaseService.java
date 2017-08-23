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
	HashMap<Integer, String> post(T t);
  
	HashMap<Integer, String> put(String id, T t);
  
	HashMap<Integer, String> delete(String id);
  
  T find(String id);
  
  List<T> findAll();
  
  int count();
  
}
