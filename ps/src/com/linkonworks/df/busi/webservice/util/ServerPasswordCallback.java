package com.linkonworks.df.busi.webservice.util;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class ServerPasswordCallback implements CallbackHandler{

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		// TODO Auto-generated method stub
		
		WSPasswordCallback  callback=(WSPasswordCallback )callbacks[0];
		String password=callback.getPassword();
		String identifier=callback.getIdentifier();
		if (password.equals("josen") && identifier.equals("admin")) {   
            // 验证通过   
        } else {   
            throw new SecurityException("验证失败");   
        }   
	}

}
