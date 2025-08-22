package in.sal.springboot.web_application.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService 
{
//	private String name;
//	private String password;
	public boolean authenticate(String name,String password)
	{
		if(name.equals("Sandip") && password.equals("Sal"))
		{
			return true;
		}
		return false;
	}
}
