package com.mitrakreasindo.pos.service;

import java.util.HashMap;
import com.mitrakreasindo.pos.entities.MerchantRegistration;

public interface MerchantRegistrationService
{
	HashMap<Integer, String> post(MerchantRegistration t);

}
