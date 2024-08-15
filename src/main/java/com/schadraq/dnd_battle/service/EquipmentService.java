package com.schadraq.dnd_battle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schadraq.dnd_battle.persistence.Armor;
import com.schadraq.dnd_battle.persistence.ArmorRepository;
import com.schadraq.dnd_battle.persistence.Weapon;
import com.schadraq.dnd_battle.persistence.WeaponRepository;

import reactor.core.publisher.Flux;

@Service
public class EquipmentService extends BaseService {

	@Autowired
	private ArmorRepository repoArmor;

	@Autowired
	private WeaponRepository repoWeapon;

	public Flux<Armor> getArmorList() {
		return repoArmor.findAll();
	}

	public Flux<Weapon> getWeaponList() {
		return repoWeapon.findAll();
	}
}
