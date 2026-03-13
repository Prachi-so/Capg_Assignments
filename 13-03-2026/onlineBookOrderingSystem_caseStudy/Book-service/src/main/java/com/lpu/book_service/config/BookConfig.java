package com.lpu.book_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

public static final String QUEUE_NAME="Recharge_queue";
	
	//from amqp.core
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME,true);  //true- even if consumer server off, it will store in queue and send when restart, if false then when server off it will not send
	}
	
	//to convert java-json-java
	@Bean
	public MessageConverter jsonMessageConverter() { //messageconverter interface
		return new Jackson2JsonMessageConverter();  //internally it will convert
	}
}
