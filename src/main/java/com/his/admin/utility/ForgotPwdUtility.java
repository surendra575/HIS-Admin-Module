package com.his.admin.utility;

import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class ForgotPwdUtility {
	
	private final static String ACC_SID="ACc2f6c9b2dd4a7ccbc1702fdade4a34c5";
	private final static String AUTH_TOKEN="0ef5bdc46cf6ee46f1929e7c80b6a940";
	static
	{
		Twilio.init(ACC_SID, AUTH_TOKEN);
	}
	
	public boolean sendPwdMsg(Long phno,String pwd)
	{
		String ph="+91"+phno;
		try {
		Message.creator(new PhoneNumber(ph),new PhoneNumber("+19196801059"),"Your password for HIS is: "+pwd)
		.create();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

}
