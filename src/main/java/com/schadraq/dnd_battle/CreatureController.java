package com.schadraq.dnd_battle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schadraq.dnd_battle.persistence.Armor;
import com.schadraq.dnd_battle.persistence.Battle;
import com.schadraq.dnd_battle.persistence.BattleParticipant;
import com.schadraq.dnd_battle.persistence.ChallengeRating;
import com.schadraq.dnd_battle.persistence.CreatureClassification;
import com.schadraq.dnd_battle.persistence.CreatureTemplate;
import com.schadraq.dnd_battle.persistence.CreatureFamily;
import com.schadraq.dnd_battle.persistence.Weapon;
import com.schadraq.dnd_battle.service.BattleService;
import com.schadraq.dnd_battle.service.CreatureService;
import com.schadraq.dnd_battle.service.EquipmentService;
import com.schadraq.dnd_battle.persistence.CreatureSize;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/dnd/creature")
@Slf4j
public class CreatureController {

	@Autowired
	private BattleService svcBattle;

	@Autowired
	private CreatureService svcCreature;

	@Autowired
	private EquipmentService svcEquipment;
	
	@GetMapping("/armors")
	public List<Armor> getArmorList() {
		return svcEquipment.getArmorList();
	}

	@GetMapping("/weapons")
	public List<Weapon> getWeaponList() {
		return svcEquipment.getWeaponList();
	}

	@GetMapping("/classifications")
	public List<CreatureClassification> getCreatureClassificationList() {
		return svcCreature.getClassificationList();
	}

	@GetMapping("/families")
	public List<CreatureFamily> getCreatureFamilyList() {
		return svcCreature.getFamilyList();
	}

	@GetMapping("/challenge-ratings")
	public List<ChallengeRating> getChallengeRatingList() {
		return svcCreature.getChallengeRatingList();
	}

	@GetMapping("/sizes")
	public List<CreatureSize> getCreatureSizeList() {
		return svcCreature.getSizeList();
	}

	@GetMapping("/templates")
	public List<CreatureTemplate> getCreatureList() {
		return svcCreature.getCreatureList();
	}

	@GetMapping("/template")
	public Optional<CreatureTemplate> getCreature(@RequestParam UUID id) {
		return svcCreature.getCreature(id);
	}

	@PostMapping("/create-battle")
	public Battle createBattle(@RequestBody Battle battle) {
		return svcBattle.createBattle(battle);
	}

	@PostMapping(value = "/create-single-battle-participant", consumes = "application/json", produces = "application/json")
	public BattleParticipant createBattleParticipant(@RequestBody BattleParticipant participant) {
		return svcBattle.createSingleBattleParticipant(participant);
	}

	@DeleteMapping(value = "/delete-single-battle-participant", consumes = "application/json", produces = "application/json")
	public void deleteBattleParticipant(@RequestBody BattleParticipant participant) {
		svcBattle.deleteSingleBattleParticipant(participant);
	}
}
