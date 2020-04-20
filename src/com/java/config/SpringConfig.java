package com.java.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="com.java")
public class SpringConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("userdetails").setViewName("userdetails");
		registry.addViewController("display").setViewName("display");
		}
    @Bean 
    public CommonsMultipartResolver multipartResolver() { 
        CommonsMultipartResolver resolver=new       
    CommonsMultipartResolver(); 
        resolver.setDefaultEncoding("utf-8"); 
        return resolver; 
    } 

	@Bean
		public ViewResolver getViewResolver() {
			InternalResourceViewResolver vr= new InternalResourceViewResolver();
			vr.setPrefix("/WEB-INF/");
			vr.setSuffix(".jsp");
			return vr;
		}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//if a request comes for img, serve content from images folder
		//images folder should be present as a root folder in your war file.
		registry.addResourceHandler("/img/**").addResourceLocations("/images/")
		.setCacheControl(CacheControl.maxAge(6, TimeUnit.DAYS));
	}
	
    @Bean 
    public MessageSource messageSource() {  
       ResourceBundleMessageSource resource = new        
       ResourceBundleMessageSource(); 
       resource.setBasename("message"); 
       return resource;     
    } 

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
    	LocaleChangeInterceptor ic= new LocaleChangeInterceptor();
    	ic.setParamName("lang");
    	return ic;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(localeChangeInterceptor());
    }
    
    @Bean
    public LocaleResolver localeResolver() {
    	SessionLocaleResolver rc= new SessionLocaleResolver();
    	return rc;
    }
}
