/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.entities.MerchantCategory;
import com.mitrakreasindo.pos.entities.MerchantRegistration;
import com.mitrakreasindo.pos.service.MerchantCategoryService;
import com.mitrakreasindo.pos.service.MerchantRegistrationService;
import com.mitrakreasindo.pos.util.GeneralFunction;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/merchants", produces = MediaType.APPLICATION_JSON_VALUE)
public class MerchantController
{

	@Autowired
	private MerchantRegistrationService merchantService;
	
	@Autowired
	private MerchantCategoryService merchantCategoryService;

	@PostMapping
	public HashMap<Integer, String> post(@RequestBody MerchantRegistration merchantRegistration)
	{
		HashMap<Integer, String> result = new HashMap<Integer, String>();

		// Generate password
		String generatedpassword = GeneralFunction.generatePassword();
		// String generatedpassword = "Admin1234!";
		String username = merchantRegistration.getMerchant().getCode() + "_ADMIN";
		merchantRegistration.getPeople().setApppassword(generatedpassword);
		merchantRegistration.getPeople().setName(username);
		
		if (merchantRegistration.getMerchant().getEmail() == null)
		{
			// set default email
			merchantRegistration.getMerchant().setEmail(merchantRegistration.getPeople().getEmail());
		}

		// Exec sp
		HashMap<Integer, String> spresult = new HashMap<Integer, String>();
		spresult = merchantService.post(merchantRegistration);

		// If succes or return = 0 than send email
		Map.Entry<Integer, String> entry = spresult.entrySet().iterator().next();
		if (entry.getKey() == 0)
		{
			boolean isSent = GeneralFunction.sendRegistrationMail(merchantRegistration);
			if (isSent == false)
			{
				result.put(1,
						"Registrasi merchant berhasil dan terdapat kendala dalam pengiriman email. Mohon hubungi contact yang tersedia.");
				return result;
			}
		}

		return spresult;
	}
	
	
	@GetMapping(value = "/categories")
	public List<MerchantCategory> findAllMerchantCategory()
	{
		return merchantCategoryService.findAll();
	}
	
	@GetMapping(value = "/categories/name")
	public List<MerchantCategory> findAllMerchantCategoryName()
	{
		return merchantCategoryService.findName();
	}
	
	@GetMapping(value = "/categories/subname/{name}")
	public List<MerchantCategory> findAllMerchantCategorySubName(@PathVariable("name") String name)
	{
		return merchantCategoryService.findSub(name);
	}

}
