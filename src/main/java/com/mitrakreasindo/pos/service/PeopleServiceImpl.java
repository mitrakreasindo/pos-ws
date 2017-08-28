package com.mitrakreasindo.pos.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.Login;
import com.mitrakreasindo.pos.entities.People;
import com.mitrakreasindo.pos.util.GeneralFunction;

@Service
public class PeopleServiceImpl extends BaseServiceImpl<People> implements PeopleService
{

	public PeopleServiceImpl()
	{
		super(People.class);
	}

	@Override
	public HashMap<Integer, String> post(People t)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("person_id", t.getId());
		param.addValue("person_name", t.getName());
		param.addValue("person_full_name", t.getFullname());
		param.addValue("person_id_type", t.getPersonalIdType());
		param.addValue("person_id_number", t.getPersonalId());
		param.addValue("person_npwp", t.getNpwpPribadi());
		param.addValue("phone_num", t.getPhoneNumber());
		param.addValue("email_addr", t.getEmail());
		param.addValue("person_gender", t.getGender());
		param.addValue("person_birthdate", t.getBirthdate());
		param.addValue("card_no", t.getCard());
		param.addValue("person_role", t.getRole().getId());
		param.addValue("visibility", t.isVisible());
		param.addValue("image_code", t.getImage());
		
		try
    {
      param.addValue("app_pass", GeneralFunction.checkNullString(GeneralFunction.encryptPassword(t.getApppassword())));
    }
    catch (Exception e)
    {
      //return 
    }
		return executeProcedure("insert_user", param);
	}

	@Override
	public HashMap<Integer, String> put(String id, People t)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("person_id", t.getId());
		param.addValue("person_name", t.getName());
		param.addValue("person_full_name", t.getFullname());
		param.addValue("person_id_type", t.getPersonalIdType());
		param.addValue("person_id_number", t.getPersonalId());
		param.addValue("person_npwp", t.getNpwpPribadi());
		param.addValue("phone_num", t.getPhoneNumber());
		param.addValue("email_addr", t.getEmail());
		param.addValue("card_no", t.getCard());
		param.addValue("visibility", t.isVisible());
		param.addValue("image_code", t.getImage());
		
		try
    {
      if(t.getApppassword() == "" || t.getApppassword() == null){
        param.addValue("app_pass", "");
      }
      else{
      	param.addValue("app_pass", GeneralFunction.checkNullString(GeneralFunction.encryptPassword(t.getApppassword())));
      }
      
      if(t.getOldPassword() == "" || t.getOldPassword() == null){
        param.addValue("old_pass", "");
      }
      else{
      	param.addValue("old_pass", GeneralFunction.checkNullString(GeneralFunction.encryptPassword(t.getOldPassword())));
      }
    }
    catch (Exception e)
    {
      //return 
    }
		return executeProcedure("update_user", param);
	}

	@Override
	public HashMap<Integer, String> delete(String id)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("person_id", id);
		
		return executeProcedure("delete_user", param);
	}

	@Override
	public List<People> findPeopleOnSales()
	{
		List<People> peoples = new ArrayList<>();
		Query query = entityManager.createNativeQuery(
				"SELECT * FROM people as p, sales as s WHERE p.id = s.person",
				People.class);
		return peoples = query.getResultList();
	}

	
	@Override
	public HashMap<Integer, String> login(Login login)
	{
	
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("merchant_code", GeneralFunction.checkNullString(login.getKodeMerchant()));
    param.addValue("merchant_user_name", GeneralFunction.checkNullString(login.getUsername()));
    
    try
    {
      param.addValue("pass", GeneralFunction.checkNullString(GeneralFunction.encryptPassword(login.getPassword())));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
		return executeProcedure("login", param);
	}


	@Override
	public List<People> findPeopleOnViewSales()
	{
		List<People> peoples = new ArrayList<>();
		Query query = entityManager.createNativeQuery(
				"SELECT * FROM people as p, viewsales as s WHERE p.id = s.person",
				People.class);
		return peoples = query.getResultList();
	}

	@Override
	public List<String> findPeopleIdOnViewSales(Timestamp fromDate, Timestamp toDate)
	{
		Query query = entityManager.createNativeQuery(
				"SELECT DISTINCT p.id FROM people as p, viewsales as s WHERE p.id = s.person AND s.datenew between '"+fromDate.toString()+"' AND '"+toDate.toString()+"'");
		return query.getResultList();
	}

}
