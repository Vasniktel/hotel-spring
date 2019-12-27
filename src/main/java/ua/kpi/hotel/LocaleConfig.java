package ua.kpi.hotel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class LocaleConfig implements WebMvcConfigurer {
  @Bean
  public LocaleResolver getLocaleResolver() {
    var slr = new SessionLocaleResolver();
    slr.setDefaultLocale(Locale.US);
    return slr;
  }

  @Bean
  public LocaleChangeInterceptor getLocaleChangeInterceptor() {
    var lci = new LocaleChangeInterceptor();
    lci.setParamName("lang");
    return lci;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(getLocaleChangeInterceptor());
  }
}
