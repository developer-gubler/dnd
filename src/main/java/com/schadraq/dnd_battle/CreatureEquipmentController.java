package com.schadraq.dnd_battle;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schadraq.dnd_battle.persistence.Armor;
import com.schadraq.dnd_battle.persistence.Weapon;
import com.schadraq.dnd_battle.service.CreatureEquipmentService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/dnd/creature-equipment")
@Slf4j
public class CreatureEquipmentController {

	@Autowired
	private CreatureEquipmentService svcCreatureEquipment;

	@GetMapping("/creature-armor-proficiency")
	public Flux<String> getCreatureArmorProficiency(@RequestParam UUID creature_id) {
		log.info("creature id: " + creature_id.toString());
		return svcCreatureEquipment.getCreatureArmorProficiency(creature_id);
	}

	@GetMapping("/creature-armor-list")
	public Flux<Armor> getCreatureArmorList(@RequestParam UUID creature_id) {
		log.info("creature id: " + creature_id.toString());
		return svcCreatureEquipment.getCreatureArmorList(creature_id);
	}

	@GetMapping("/creature-weapon-proficiency")
	public Flux<Weapon> getCreatureWeaponProficiency(@RequestParam UUID creature_id) {
		log.info("creature id: " + creature_id.toString());
		return svcCreatureEquipment.getCreatureWeaponProficiency(creature_id);
	}

	@GetMapping("/creature-weapon-list")
	public Flux<Weapon> getCreatureWeaponList(@RequestParam UUID creature_id) {
		log.info("creature id: " + creature_id.toString());
		return svcCreatureEquipment.getCreatureWeaponList(creature_id);
	}
}
