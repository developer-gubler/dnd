package com.schadraq.dnd.persistence;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;


@Repository
public interface CreatureWeaponXrefRepository extends R2dbcRepository<CreatureWeaponXref, UUID> {

	public Flux<CreatureWeaponXref> findAllByCreatureId(UUID creatureId);
}
