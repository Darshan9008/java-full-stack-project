package com.xworkz.vendorManagementSystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.vendorManagementSystem")
@EnableWebMvc
public class BeanConfiguration {
	
	public BeanConfiguration() {
		// TODO Auto-generated constructor stub
		System.out.println("created bean configuration");
	}
	
	public ViewResolver viewResolver() {
		
		ViewResolver resolver=new InternalResourceViewResolver("/",".jsp");
		return resolver;
		
	} 
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntity() {
		return new LocalContainerEntityManagerFactoryBean();
	}
	
	

}
