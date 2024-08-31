package com.schadraq.dnd.persistence;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends R2dbcRepository<Weapon, UUID> {

}
