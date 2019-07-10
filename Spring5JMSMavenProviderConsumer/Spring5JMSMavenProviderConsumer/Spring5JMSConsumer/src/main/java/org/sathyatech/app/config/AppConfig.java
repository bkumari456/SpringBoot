package org.sathyatech.app.config;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

@Configuration
@ComponentScan(basePackages= {"org.sathyatech.app"})
@EnableJms
public class AppConfig {

	@Autowired
	private MessageListener messageListener;
	
	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory c=new ActiveMQConnectionFactory();
		c.setBrokerURL("tcp://localhost:61616");
		return c;
	}
	@Bean
	public MessageListenerContainer listenerContainer() {
		DefaultMessageListenerContainer m=new DefaultMessageListenerContainer();
		m.setConnectionFactory(connectionFactory());
		m.setDestinationName("my-test-spring");
		m.setMessageListener(messageListener);
		return m;
	}
	
}
