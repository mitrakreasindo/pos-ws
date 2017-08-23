/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.core.SimpleController;
import com.mitrakreasindo.pos.entities.Login;
import com.mitrakreasindo.pos.entities.People;
import com.mitrakreasindo.pos.service.PeopleService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/peoples", produces = MediaType.APPLICATION_JSON_VALUE)
public class PeopleController extends SimpleController<People, Long, PeopleService>
{
	
	@PostMapping(value = "/auth")
	public HashMap<Integer, String> login(@RequestBody Login login)
	{
		return service.login(login);
	}
	
}
