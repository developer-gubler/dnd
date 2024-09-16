package com.schadraq.dnd;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schadraq.dnd.persistence.Armor;
import com.schadraq.dnd.persistence.Weapon;
import com.schadraq.dnd.service.EquipmentService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/dnd/equipment")
@Slf4j
public class EquipmentController {

	@Autowired
	private EquipmentService svcEquipment;
	
	@GetMapping("/armor-list")
	public Flux<Armor> getArmorList() {
		return svcEquipment.getArmorList();
	}
	
	@GetMapping("/armor")
	public Mono<Armor> getArmor(@RequestParam UUID armor_id) {
		log.info("armor id: " + armor_id);
		return svcEquipment.getArmor(armor_id);
	}

	@GetMapping("/weapon-list")
	public Flux<Weapon> getWeaponList() {
		return svcEquipment.getWeaponList();
	}
	
	@GetMapping("/weapon")
	public Mono<Weapon> getWeapon(@RequestParam UUID weapon_id) {
		log.info("weapon id: " + weapon_id);
		return svcEquipment.getWeapon(weapon_id);
	}

	@GetMapping("/creature-armor-proficiency")
	public Flux<String> getCreatureArmorProficiency(@RequestParam UUID creature_id) {
		log.info("creature id: " + creature_id.toString());
		return svcEquipment.getCreatureArmorProficiency(creature_id);
	}

	@GetMapping("/creature-armor-list")
	public Flux<Armor> getCreatureArmorList(@RequestParam UUID creature_id) {
		log.info("creature id: " + creature_id.toString());
		return svcEquipment.getCreatureArmorList(creature_id);
	}

	@GetMapping("/creature-weapon-proficiency")
	public Flux<Weapon> getCreatureWeaponProficiency(@RequestParam UUID creature_id) {
		log.info("creature id: " + creature_id.toString());
		return svcEquipment.getCreatureWeaponProficiency(creature_id);
	}

	@GetMapping("/creature-weapon-list")
	public Flux<Weapon> getCreatureWeaponList(@RequestParam UUID creature_id) {
		log.info("creature id: " + creature_id.toString());
		return svcEquipment.getCreatureWeaponList(creature_id);
	}
}
