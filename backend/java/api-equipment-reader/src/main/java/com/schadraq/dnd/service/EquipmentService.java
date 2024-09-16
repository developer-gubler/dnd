package com.schadraq.dnd.service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import com.schadraq.dnd.persistence.Armor;
import com.schadraq.dnd.persistence.ArmorRepository;
import com.schadraq.dnd.persistence.CreatureArmorProficiencyRepository;
import com.schadraq.dnd.persistence.CreatureArmorXrefRepository;
import com.schadraq.dnd.persistence.CreatureWeaponProficiencyRepository;
import com.schadraq.dnd.persistence.CreatureWeaponXrefRepository;
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

	@Autowired
	private CreatureArmorProficiencyRepository repoCreatureArmorProficiency;

	@Autowired
	private CreatureArmorXrefRepository repoCreatureArmorXref;

	@Autowired
	private CreatureWeaponProficiencyRepository repoCreatureWeaponProficiency;

	@Autowired
	private CreatureWeaponXrefRepository repoCreatureWeaponXref;

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

	public Flux<String> getCreatureArmorProficiency(@RequestParam UUID creature_id) {
		return repoCreatureArmorProficiency
				.findAllByCreatureId(creature_id)
				.map(i -> i.getType());
	}

	public Flux<Armor> getCreatureArmorList(@RequestParam UUID creature_id) {
//		return repoCreatureArmorXref.findAllByCreature(creature_id)
//					.flatMap(i -> {log.info("armor id: " + i.getArmor()); return repoArmor.findById(i.getArmor());});
		return repoCreatureArmorXref.findAllByCreatureId(creature_id)
				.flatMap(i -> {
					log.info("armor id: " + i.getArmorId());
					return WebClient
			                .builder()
			                .baseUrl("http://localhost:8080")
			                .defaultHeader("Content-Type", "application/json")
			                .build()
			                .method(HttpMethod.GET)
			                .uri("/api/dnd/equipment/armor?armor_id=" + i.getArmorId())
//			                .body(BodyInserters.fromValue(i.getArmorId()))
			                .accept(MediaType.APPLICATION_JSON)
			                .acceptCharset(StandardCharsets.UTF_8)
			                .retrieve()
			                .bodyToFlux(Armor.class);
				});
	}

	public Flux<Weapon> getCreatureWeaponProficiency(@RequestParam UUID creature_id) {
//		return repoCreatureWeaponProficiency.findAllByCreature(creature_id)
//				.flatMap(i -> {log.info("weapon id: " + i.getWeapon()); return repoWeapon.findById(i.getWeapon());});
		return repoCreatureWeaponProficiency.findAllByCreatureId(creature_id)
				.flatMap(i -> {
					log.info("weapon id: " + i.getWeaponId());
					return WebClient
			                .builder()
			                .baseUrl("http://localhost:8080")
			                .defaultHeader("Content-Type", "application/json")
			                .build()
			                .method(HttpMethod.GET)
			                .uri("/api/dnd/equipment/weapon?weapon_id=" + i.getWeaponId())
//			                .body(BodyInserters.fromValue(i.getWeaponId()))
			                .accept(MediaType.APPLICATION_JSON)
			                .acceptCharset(StandardCharsets.UTF_8)
			                .retrieve()
			                .bodyToFlux(Weapon.class);
				});
	}

	public Flux<Weapon> getCreatureWeaponList(@RequestParam UUID creature_id) {
//		return repoCreatureWeaponXref.findAllByCreature(creature_id)
//				.flatMap(i -> {log.info("weapon id: " + i.getWeapon()); return repoWeapon.findById(i.getWeapon());});
		return repoCreatureWeaponXref.findAllByCreatureId(creature_id)
				.flatMap(i -> {
					log.info("weapon id: " + i.getWeaponId());
					return WebClient
			                .builder()
			                .baseUrl("http://localhost:8080")
			                .defaultHeader("Content-Type", "application/json")
			                .build()
			                .method(HttpMethod.GET)
			                .uri("/api/dnd/equipment/weapon?weapon_id=" + i.getWeaponId())
//			                .body(BodyInserters.fromValue(i.getWeaponId()))
			                .accept(MediaType.APPLICATION_JSON)
			                .acceptCharset(StandardCharsets.UTF_8)
			                .retrieve()
			                .bodyToFlux(Weapon.class);
				});
	}
}
