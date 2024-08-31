package com.schadraq.dnd;

import org.springframework.boot.SpringApplication;

import com.schadraq.dnd.DndApplication;

public class TestDndBattleApplication {

	public static void main(String[] args) {
		SpringApplication.from(DndApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
