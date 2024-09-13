package com.schadraq.dnd.persistence;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface CreatureArmorXrefRepository extends R2dbcRepository<CreatureArmorXref, UUID> {

	public Flux<CreatureArmorXref> findAllByCreatureId(UUID creatureId);
}
