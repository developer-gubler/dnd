package com.schadraq.dnd_battle.persistence;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureTemplateRepository extends R2dbcRepository<CreatureTemplate, UUID> {

}
