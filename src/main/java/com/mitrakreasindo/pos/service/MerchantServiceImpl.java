package com.mitrakreasindo.pos.service;

import java.util.HashMap;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.MerchantRegistration;
import com.mitrakreasindo.pos.util.GeneralFunction;

@Service
public class MerchantServiceImpl extends BaseServiceImpl<MerchantRegistration> implements MerchantService
{

	public MerchantServiceImpl()
	{
		super(MerchantRegistration.class);
	}

	@Override
	public HashMap<Integer, String> post(String merchantCode, MerchantRegistration t)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("merchant_code", t.getMerchant().getCode());
		param.addValue("merchant_name", t.getMerchant().getName());
		param.addValue("merchant_email", t.getMerchant().getEmail());
		param.addValue("merchant_phone", t.getMerchant().getPhone());
		param.addValue("merchant_address", t.getMerchant().getAddress());
		param.addValue("the_type", t.getMerchant().getCategory().getId());
		param.addValue("merchant_npwp", t.getMerchant().getNpwpperusahaan());
		param.addValue("person_id", t.getPeople().getId());
		param.addValue("person_name", t.getPeople().getName());
		param.addValue("person_full_name", t.getPeople().getFullname());
		param.addValue("person_gender", t.getPeople().getGender());
		param.addValue("person_birthdate", t.getPeople().getBirthdate());
		param.addValue("person_id_type", t.getPeople().getPersonalIdType());
		param.addValue("person_id_number", t.getPeople().getPersonalId());
		param.addValue("person_npwp", t.getPeople().getNpwpPribadi());
		param.addValue("card_no", t.getPeople().getCard());
		param.addValue("visibility", t.getPeople().isVisible());
		param.addValue("image_code", t.getPeople().getImage());
		
		try
    {
      param.addValue("app_pass", GeneralFunction.encryptPassword(GeneralFunction.checkNullString(t.getPeople().getApppassword())));
    }
    catch (Exception e)
    {
      //return 
    }
		
		return executeProcedure("insert_merchant", merchantCode, param);
	}


}
