package com.nsw.fsjavapostgresreact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FsJavaPostgresReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsJavaPostgresReactApplication.class, args);
	}

	@GetMapping
	public String helloWorld(){
		return "AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH!!!";
	}

}
