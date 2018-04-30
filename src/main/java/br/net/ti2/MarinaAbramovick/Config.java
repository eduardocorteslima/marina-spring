package br.net.ti2.MarinaAbramovick;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;

@Configuration
public class Config {
	
	@Value("${app.WATSON_USERNAME}")
	String WATSON_USERNAME;

	@Value("${app.WATSON_PASSWORD}")
	String WATSON_PASSWORD;
	
	@Bean
	public Conversation conversation() {
		return  new Conversation("2018-02-16",WATSON_USERNAME,WATSON_PASSWORD);
	}
}
