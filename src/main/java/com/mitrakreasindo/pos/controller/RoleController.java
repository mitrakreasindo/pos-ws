/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.core.SimpleController;
import com.mitrakreasindo.pos.entities.Role;
import com.mitrakreasindo.pos.service.RoleService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/roles", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController extends SimpleController<Role, Long, RoleService>
{

}
