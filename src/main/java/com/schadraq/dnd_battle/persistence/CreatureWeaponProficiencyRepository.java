package com.schadraq.dnd_battle.persistence;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface CreatureWeaponProficiencyRepository extends R2dbcRepository<CreatureWeaponProficiency, UUID> {

	public Flux<CreatureWeaponProficiency> findAllByCreatureId(UUID creatureId);

}
