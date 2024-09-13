package com.schadraq.dnd;

import org.springframework.boot.SpringApplication;

public class TestApiReaderApplication {

	public static void main(String[] args) {
		SpringApplication.from(ApiReaderApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
