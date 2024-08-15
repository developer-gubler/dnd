package com.schadraq.dnd_battle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schadraq.dnd_battle.persistence.Armor;
import com.schadraq.dnd_battle.persistence.Weapon;
import com.schadraq.dnd_battle.service.EquipmentService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/dnd/equipment")
@Slf4j
public class EquipmentController {

	@Autowired
	private EquipmentService svcEquipment;
	
	@GetMapping("/armors")
	public Flux<Armor> getArmorList() {
		return svcEquipment.getArmorList();
	}

	@GetMapping("/weapons")
	public Flux<Weapon> getWeaponList() {
		return svcEquipment.getWeaponList();
	}

}
