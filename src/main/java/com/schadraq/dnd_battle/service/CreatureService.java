package com.schadraq.dnd_battle.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schadraq.dnd_battle.persistence.ChallengeRating;
import com.schadraq.dnd_battle.persistence.ChallengeRatingRepository;
import com.schadraq.dnd_battle.persistence.CreatureClassification;
import com.schadraq.dnd_battle.persistence.CreatureClassificationRepository;
import com.schadraq.dnd_battle.persistence.CreatureFamily;
import com.schadraq.dnd_battle.persistence.CreatureFamilyRepository;
import com.schadraq.dnd_battle.persistence.CreatureSize;
import com.schadraq.dnd_battle.persistence.CreatureSizeRepository;
import com.schadraq.dnd_battle.persistence.CreatureTemplate;
import com.schadraq.dnd_battle.persistence.CreatureTemplateRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreatureService extends BaseService {

	@Autowired
	private CreatureClassificationRepository repoCreatureClassification;

	@Autowired
	private CreatureFamilyRepository repoCreatureFamily;

	@Autowired
	private ChallengeRatingRepository repoChallengeRating;

	@Autowired
	private CreatureSizeRepository repoCreatureSize;

	@Autowired
	private CreatureTemplateRepository repoCreature;

	public Flux<CreatureClassification> getClassificationList() {
		return Flux.fromIterable(repoCreatureClassification.findAll());
	}

	public Flux<CreatureFamily> getFamilyList() {
		return Flux.fromIterable(repoCreatureFamily.findAll());
	}

	public Flux<ChallengeRating> getChallengeRatingList() {
		return Flux.fromIterable(repoChallengeRating.findAll());
	}

	public Flux<CreatureSize> getSizeList() {
		return Flux.fromIterable(repoCreatureSize.findAll());
	}

	public Flux<CreatureTemplate> getCreatureList() {
		return Flux.fromIterable(repoCreature.findAll());
	}

	public Mono<Optional<CreatureTemplate>> getCreature(UUID id) {
		return Mono.just(repoCreature.findById(id));
	}
}
