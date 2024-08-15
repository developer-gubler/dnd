package com.schadraq.dnd_battle.service;

import java.util.List;
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

	public List<CreatureClassification> getClassificationList() {
		return repoCreatureClassification.findAll();
	}

	public List<CreatureFamily> getFamilyList() {
		return repoCreatureFamily.findAll();
	}

	public List<ChallengeRating> getChallengeRatingList() {
		return repoChallengeRating.findAll();
	}

	public List<CreatureSize> getSizeList() {
		return repoCreatureSize.findAll();
	}

	public List<CreatureTemplate> getCreatureList() {
		return repoCreature.findAll();
	}

	public Optional<CreatureTemplate> getCreature(UUID id) {
		return repoCreature.findById(id);
	}
}
