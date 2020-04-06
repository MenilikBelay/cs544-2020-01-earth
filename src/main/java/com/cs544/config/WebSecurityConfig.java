package com.cs544.config;

import com.cs544.domain.Role;
import com.cs544.service.UserDetailsServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService () {
		return new UserDetailsServiceImp();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
    };
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
    
/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().anyRequest().hasAnyRole(Role.ADMIN.toString(), 
    		  Role.ADMIN.toString(), Role.FACULTY.toString())
      .and().authorizeRequests().antMatchers(HttpMethod.GET,"/locationlist").hasRole(" STUDENT").and()
      .formLogin()
      .and()

              .logout().permitAll().logoutSuccessUrl("/login")
      .and()
      .csrf().disable();
    }*/
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        //   super.configure(http);
        http.httpBasic().and()
                .csrf().disable()
                .authorizeRequests()
                //only for users with admin role : xlm= access="ROLE_ADMIN"
                .antMatchers("/admin/**").hasAnyRole(Role.ADMIN.toString())
                .antMatchers("/faculty/**").hasAnyRole(Role.FACULTY.toString())
                .antMatchers("/student/**").hasAnyRole(Role.STUDENT.toString())


                // xml= access="IS_AUTHENTICATED_ANONYMOUSLY"
                .antMatchers("/anonymous*").anonymous().// access=none
                antMatchers("/login*").permitAll().anyRequest().authenticated()
                .and()
                .formLogin()

                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error=true")
                //  .failureHandler(authenticationFailureHandler())
                .and()
                .logout().logoutSuccessUrl("/login")
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID");
        //   .logoutSuccessHandler(logoutSuccessHandler());
        http.sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true).and().sessionFixation();
    }
}
