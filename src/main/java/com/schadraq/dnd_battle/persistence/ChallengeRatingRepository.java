package com.schadraq.dnd_battle.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRatingRepository extends R2dbcRepository<ChallengeRating, UUID> {

}
