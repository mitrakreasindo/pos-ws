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

	@PostMapping(value = "/{merchantCode}")
	public HashMap<Integer, String> post(@PathVariable("merchantCode") String merchantCode,
			@RequestBody MerchantRegistration merchantRegistration)
	{
		HashMap<Integer, String> result = new HashMap<Integer, String>();

		// Generate password
		String generatedpassword = GeneralFunction.generatePassword();
		// String generatedpassword = "Admin1234!";
		String username = merchantRegistration.getMerchant().getCode() + "_admin";
		merchantRegistration.getPeople().setApppassword(generatedpassword);
		merchantRegistration.getPeople().setName(generatedpassword);

		// Exec sp
		HashMap<Integer, String> spresult = new HashMap<Integer, String>();
		spresult = merchantService.post(merchantCode, merchantRegistration);

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
	
	
	@GetMapping(value = "/{merchantCode}/categories")
	public List<MerchantCategory> findAllMerchantCategory(@PathVariable("merchantCode") String merchantCode)
	{
		return merchantCategoryService.findAll(merchantCode);
	}
	
	@GetMapping(value = "/{merchantCode}/categories/name")
	public List<MerchantCategory> findAllMerchantCategoryName(@PathVariable("merchantCode") String merchantCode)
	{
		return merchantCategoryService.findName(merchantCode);
	}
	
	@GetMapping(value = "/{merchantCode}/categories/subname/{name}")
	public List<MerchantCategory> findAllMerchantCategorySubName(@PathVariable("merchantCode") String merchantCode, @PathVariable("name") String name)
	{
		return merchantCategoryService.findSub(merchantCode, name);
	}

}
