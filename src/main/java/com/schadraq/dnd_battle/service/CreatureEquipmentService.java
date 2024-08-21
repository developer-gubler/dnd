package com.schadraq.dnd_battle.service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import com.schadraq.dnd_battle.persistence.Armor;
import com.schadraq.dnd_battle.persistence.CreatureArmorProficiency;
import com.schadraq.dnd_battle.persistence.CreatureArmorProficiencyRepository;
import com.schadraq.dnd_battle.persistence.CreatureArmorXrefRepository;
import com.schadraq.dnd_battle.persistence.CreatureWeaponProficiencyRepository;
import com.schadraq.dnd_battle.persistence.CreatureWeaponXrefRepository;
import com.schadraq.dnd_battle.persistence.Weapon;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * NOTE: This class demonstrates how to handle three issues with the non-reactive version:
 *		- Failure in either inventory service or shipping service can have a cascading effect.
 *		- The calls to external systems and database are all blocking in nature.
 *		- The deployment can’t handle failures and fluctuating loads automatically.
 */
@Service
@Slf4j
public class CreatureEquipmentService extends BaseService {

	@Autowired
	private CreatureArmorProficiencyRepository repoCreatureArmorProficiency;

	@Autowired
	private CreatureArmorXrefRepository repoCreatureArmorXref;

	@Autowired
	private CreatureWeaponProficiencyRepository repoCreatureWeaponProficiency;

	@Autowired
	private CreatureWeaponXrefRepository repoCreatureWeaponXref;

	public Flux<String> getCreatureArmorProficiency(@RequestParam UUID creature_id) {
		Flux<CreatureArmorProficiency> list = repoCreatureArmorProficiency.findAllByCreatureId(creature_id);
		return Flux.fromStream(
				list.toStream()
					.map(i -> i.getType()));
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
