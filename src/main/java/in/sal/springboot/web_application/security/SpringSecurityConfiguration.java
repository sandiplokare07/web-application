package in.sal.springboot.web_application.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
//	InMemoryUserDetailsManager
//	 InMemoryUserDetailsManager(UserDetails... users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailManager()
	{
		UserDetails userDetails1 = createNewUser("sandip", "Sal");
		UserDetails userDetails2 = createNewUser("sandiplokare", "Sal@");
		
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}

private UserDetails createNewUser(String username, String password) {
	Function<String, String> passwordEncoder
	=input->passwordEncoder().encode(input);
	UserDetails userDetails = User.builder()
								.passwordEncoder(passwordEncoder)
								.username(username)
								.password(password)
								.roles("USER","ADMIN")
								.build();
	return userDetails;
}
	
	/*
	 * @Bean public InMemoryUserDetailsManager createUserDetailManager() {
	 * Function<String, String> passwordEncoder
	 * =input->passwordEncoder().encode(input);
	 * 
	 * UserDetails userDetails = User.builder() .passwordEncoder(passwordEncoder)
	 * .username("sandip") .password("Sal") .roles("USER","ADMIN") .build();
	 * 
	 * return new InMemoryUserDetailsManager(userDetails); }
	 */
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
