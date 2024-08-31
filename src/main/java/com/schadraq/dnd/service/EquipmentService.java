package com.schadraq.dnd.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schadraq.dnd.persistence.Armor;
import com.schadraq.dnd.persistence.ArmorRepository;
import com.schadraq.dnd.persistence.Weapon;
import com.schadraq.dnd.persistence.WeaponRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class EquipmentService extends BaseService {

	@Autowired
	private ArmorRepository repoArmor;

	@Autowired
	private WeaponRepository repoWeapon;

	public Flux<Armor> getArmorList() {
		return repoArmor.findAll();
	}

	public Mono<Armor> getArmor(UUID armor_id) {
		log.info("armor id: " + armor_id);
		return repoArmor.findById(armor_id);
	}

	public Flux<Weapon> getWeaponList() {
		return repoWeapon.findAll();
	}

	public Mono<Weapon> getWeapon(UUID weapon_id) {
		log.info("weapon id: " + weapon_id);
		return repoWeapon.findById(weapon_id);
	}
}
