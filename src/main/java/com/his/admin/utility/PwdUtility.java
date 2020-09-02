package com.his.admin.utility;


import org.springframework.stereotype.Component;

import com.his.constants.AppConstants;

@Component
public class PwdUtility{
	
	public String generatePassword()
	{
		int n=AppConstants.PWD_LENGTH;
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n); 
		  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString();
	}

}
