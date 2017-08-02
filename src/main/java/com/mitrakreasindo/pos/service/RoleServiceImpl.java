/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.util.HashMap;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.Role;

/**
 * @author miftakhul
 *
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService
{
 
  public RoleServiceImpl() {
		super(Role.class);
	}

  @Override
  public HashMap<Integer, String> post(String merchantCode, Role role)
  {
    MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("role_id", role.getId());
    param.addValue("role_name", role.getName());
    param.addValue("permission_lists", role.getPermissions());
    param.addValue("rights_level", role.getRightslevel());
        
    return executeProcedure("insert_role", merchantCode, param);
  }
  
  @Override
  public HashMap<Integer, String> put(String merchantCode, String id, Role role)
  {
  	MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("role_id", role.getId());
    param.addValue("role_name", role.getName());
    param.addValue("permission_lists", role.getPermissions());
    param.addValue("rights_level", role.getRightslevel());
        
    return executeProcedure("update_role", merchantCode, param);
  }
  
  @Override
  public HashMap<Integer, String> delete(String merchantCode, String id)
  {
  	MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("role_id", id);
        
    return executeProcedure("delete_role", merchantCode, param);
  }

}
