package co.edu.iudigital.app.service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.edu.iudigital.app.service.iface.IEmailService;

@Service
public class EmailServiceImpl  implements IEmailService {
	
	@Override
	public boolean sendEmail(String message, String to, String subject) {
		// TODO Auto-generated method stub
		return false;
	}

}
