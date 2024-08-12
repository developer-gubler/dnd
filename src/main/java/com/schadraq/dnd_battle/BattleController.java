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
import com.schadraq.dnd_battle.persistence.ChallengeRatingRepository;
import com.schadraq.dnd_battle.persistence.CreatureClassification;
import com.schadraq.dnd_battle.persistence.CreatureClassificationRepository;
import com.schadraq.dnd_battle.persistence.CreatureTemplate;
import com.schadraq.dnd_battle.persistence.CreatureFamily;
import com.schadraq.dnd_battle.persistence.CreatureFamilyRepository;
import com.schadraq.dnd_battle.persistence.CreatureTemplateRepository;
import com.schadraq.dnd_battle.persistence.CreatureSize;
import com.schadraq.dnd_battle.persistence.CreatureSizeRepository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("dnd-battle")
@Slf4j
public class BattleController {

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

	@GetMapping("/creature-classifications")
	public List<CreatureClassification> getCreatureClassificationList() {
		return repoCreatureClassification.findAll();
	}

	@GetMapping("/creature-families")
	public List<CreatureFamily> getCreatureFamilyList() {
		return repoCreatureFamily.findAll();
	}

	@GetMapping("/challenge-ratings")
	public List<ChallengeRating> getChallengeRatingList() {
		return repoChallengeRating.findAll();
	}

	@GetMapping("/creature-sizes")
	public List<CreatureSize> getCreatureSizeList() {
		return repoCreatureSize.findAll();
	}

	@GetMapping("/creature-templates")
	public List<CreatureTemplate> getCreatureList() {
		return repoCreature.findAll();
	}

	@GetMapping("/creature-template")
	public Optional<CreatureTemplate> getCreature(@NotNull @RequestParam UUID id) {
		Optional<CreatureTemplate> creature = repoCreature.findById(id);
		return creature;
	}
}
