package com.schadraq.dnd_battle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schadraq.dnd_battle.persistence.ChallengeRating;
import com.schadraq.dnd_battle.persistence.CreatureClassification;
import com.schadraq.dnd_battle.persistence.CreatureTemplate;
import com.schadraq.dnd_battle.persistence.CreatureFamily;
import com.schadraq.dnd_battle.service.CreatureService;
import com.schadraq.dnd_battle.persistence.CreatureSize;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/dnd/creature")
@Slf4j
public class CreatureController {

	@Autowired
	private CreatureService svcCreature;

	@GetMapping("/classifications")
	public Flux<CreatureClassification> getCreatureClassificationList() {
		return svcCreature.getClassificationList();
	}

	@GetMapping("/families")
	public Flux<CreatureFamily> getCreatureFamilyList() {
		return svcCreature.getFamilyList();
	}

	@GetMapping("/challenge-ratings")
	public Flux<ChallengeRating> getChallengeRatingList() {
		return svcCreature.getChallengeRatingList();
	}

	@GetMapping("/sizes")
	public Flux<CreatureSize> getCreatureSizeList() {
		return svcCreature.getSizeList();
	}

	@GetMapping("/templates")
	public Flux<CreatureTemplate> getCreatureList() {
		return svcCreature.getCreatureList();
	}

	@GetMapping("/template")
	public Mono<Optional<CreatureTemplate>> getCreature(@RequestParam UUID id) {
		return svcCreature.getCreature(id);
	}
}
