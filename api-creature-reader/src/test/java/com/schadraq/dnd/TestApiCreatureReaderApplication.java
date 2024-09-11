package com.schadraq.dnd;

import org.springframework.boot.SpringApplication;

public class TestApiCreatureReaderApplication {

	public static void main(String[] args) {
		SpringApplication.from(ApiCreatureReaderApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
