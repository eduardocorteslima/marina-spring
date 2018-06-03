package br.net.ti2.MarinaAbramovick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "br.net.ti2.MarinaAbramovick")
@SpringBootApplication
public class MarinaAbramovickApplication {
	public static void main(String[] args) {
		SpringApplication.run(MarinaAbramovickApplication.class, args);
	}
}
