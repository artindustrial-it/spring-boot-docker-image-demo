package com.ait.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication( scanBasePackageClasses = App.class)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
