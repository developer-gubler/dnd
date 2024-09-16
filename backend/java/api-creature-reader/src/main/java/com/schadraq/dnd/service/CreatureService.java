package com.schadraq.dnd.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schadraq.dnd.persistence.ChallengeRating;
import com.schadraq.dnd.persistence.ChallengeRatingRepository;
import com.schadraq.dnd.persistence.CreatureClassification;
import com.schadraq.dnd.persistence.CreatureClassificationRepository;
import com.schadraq.dnd.persistence.CreatureFamily;
import com.schadraq.dnd.persistence.CreatureFamilyRepository;
import com.schadraq.dnd.persistence.CreatureSize;
import com.schadraq.dnd.persistence.CreatureSizeRepository;
import com.schadraq.dnd.persistence.CreatureTemplate;
import com.schadraq.dnd.persistence.CreatureTemplateRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
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
		return repoCreatureClassification.findAll();
	}

	public Flux<CreatureFamily> getFamilyList() {
		return repoCreatureFamily.findAll();
	}

	public Flux<ChallengeRating> getChallengeRatingList() {
		return repoChallengeRating.findAll();
	}

	public Flux<CreatureSize> getSizeList() {
		return repoCreatureSize.findAll();
	}

	public Flux<CreatureTemplate> getCreatureList() {
		return repoCreature.findAll();
	}

	public Mono<CreatureTemplate> getCreature(UUID creature_id) {
		log.info("creature id: " + creature_id.toString());
		return repoCreature.findById(creature_id);
	}
}
