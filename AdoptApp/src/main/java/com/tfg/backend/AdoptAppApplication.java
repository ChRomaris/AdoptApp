package com.tfg.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class AdoptAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdoptAppApplication.class, args);
	}
	
	    @Bean
	    public MessageSource messageSource() {
	    	
	        ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
	        
	        bean.setBasename("classpath:messages");
	        bean.setDefaultEncoding("UTF-8");
	        
	        return bean;
	    }

}
