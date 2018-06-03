package br.net.ti2.MarinaAbramovick.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigStatic {
	
    public static String SECRET;
    @Value("${app.SECRET}")
    public void setDatabase(String sct) {
    	SECRET = sct;
    }	
}
