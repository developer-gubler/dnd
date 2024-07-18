package com.schadraq.dnd_battle;

import org.springframework.boot.SpringApplication;

public class TestDndBattleApplication {

	public static void main(String[] args) {
		SpringApplication.from(DndBattleApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
