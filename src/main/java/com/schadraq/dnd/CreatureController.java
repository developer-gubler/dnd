package com.schadraq.dnd;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schadraq.dnd.persistence.ChallengeRating;
import com.schadraq.dnd.persistence.CreatureClassification;
import com.schadraq.dnd.persistence.CreatureFamily;
import com.schadraq.dnd.persistence.CreatureSize;
import com.schadraq.dnd.persistence.CreatureTemplate;
import com.schadraq.dnd.service.CreatureService;

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
	public Mono<CreatureTemplate> getCreature(@RequestParam UUID creature_id) {
		log.info("creature id:" + creature_id.toString());
		return svcCreature.getCreature(creature_id);
	}
}
