package com.schadraq.dnd.persistence;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface ArmorRepository extends R2dbcRepository<Armor, UUID> {

}
