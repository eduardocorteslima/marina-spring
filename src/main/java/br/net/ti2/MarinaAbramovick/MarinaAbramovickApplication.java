package br.net.ti2.MarinaAbramovick;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarinaAbramovickApplication {
	
	@Autowired
	private Marina marina;
	
	public static void main(String[] args) {
		SpringApplication.run(MarinaAbramovickApplication.class, args);
	}
	
	/*@PostConstruct
	public void teste() {
		marina.exec();
	}*/
	
}
