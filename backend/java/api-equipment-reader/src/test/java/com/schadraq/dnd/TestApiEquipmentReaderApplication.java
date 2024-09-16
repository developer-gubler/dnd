package com.schadraq.dnd;

import org.springframework.boot.SpringApplication;

public class TestApiEquipmentReaderApplication {

	public static void main(String[] args) {
		SpringApplication.from(ApiEquipmentReaderApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
