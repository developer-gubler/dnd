package com.schadraq.dnd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/dnd")
public class PersistenceController {
	
	@GetMapping("/greeting")
	public Mono<String> getGreeting() {
		return Mono.just("Greetings, Adventurer!");
	}
}
