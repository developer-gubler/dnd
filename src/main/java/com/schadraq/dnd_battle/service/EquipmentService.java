package com.schadraq.dnd_battle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schadraq.dnd_battle.persistence.Armor;
import com.schadraq.dnd_battle.persistence.ArmorRepository;
import com.schadraq.dnd_battle.persistence.Weapon;
import com.schadraq.dnd_battle.persistence.WeaponRepository;

@Service
public class EquipmentService extends BaseService {

	@Autowired
	private ArmorRepository repoArmor;

	@Autowired
	private WeaponRepository repoWeapon;

	public List<Armor> getArmorList() {
		return repoArmor.findAll();
	}

	public List<Weapon> getWeaponList() {
		return repoWeapon.findAll();
	}
}
