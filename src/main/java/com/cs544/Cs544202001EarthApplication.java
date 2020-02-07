package com.cs544;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;



@SpringBootApplication
@EnableJms

public class Cs544202001EarthApplication{
	@Bean
	public JmsListenerContainerFactory<?> myFactory (ConnectionFactory connectionFactory ,
														DefaultJmsListenerContainerFactoryConfigurer congfigurer)
	{
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		congfigurer.configure(factory, connectionFactory);
		return factory;	
	}
	
	public static void main(String[] args) {
		
	 ConfigurableApplicationContext context = SpringApplication.run(Cs544202001EarthApplication.class, args);
		try {
		 	JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
			System.out.println("Transmission Start");
			jmsTemplate.convertAndSend("WebServiceStatus","Your Web Service is runing well");
		}catch(Exception e){System.out.println(e.getMessage());}
	}
}
