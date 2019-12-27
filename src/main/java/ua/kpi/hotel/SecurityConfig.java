package ua.kpi.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private final UserDetailsService detailsService;

  public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService detailsService) {
    this.detailsService = detailsService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
          .antMatchers("/register").permitAll()
          .antMatchers("/template", "/pay").hasAuthority("USER")
          .antMatchers("/reserve", "/assign", "/inspect").hasAuthority("ADMIN")
          .anyRequest().authenticated()
          .and()
        .formLogin()
          .loginPage("/login")
          .successHandler(getDispatcher())
          .usernameParameter("login")
          .passwordParameter("password")
          .permitAll()
          .and()
        .logout()
          .permitAll();
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager getAuthenticationManager() throws Exception {
    return authenticationManager();
  }

  @Bean
  public AuthenticationSuccessHandler getDispatcher() {
    return new RoleBasedDispatcher();
  }

  @Autowired
  public void getAuthenticationManager(AuthenticationManagerBuilder builder) throws Exception {
    builder.userDetailsService(detailsService).passwordEncoder(getPasswordEncoder());
  }
}
