package com.schadraq.dnd_battle;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schadraq.dnd_battle.persistence.Armor;
import com.schadraq.dnd_battle.persistence.Weapon;
import com.schadraq.dnd_battle.service.EquipmentService;

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
}
