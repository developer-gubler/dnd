package com.schadraq.dnd.persistence;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;


@Repository
public interface CreatureArmorProficiencyRepository extends R2dbcRepository<CreatureArmorProficiency, UUID> {

	public Flux<CreatureArmorProficiency> findAllByCreatureId(UUID creatureId);
}
