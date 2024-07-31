package com.schadraq.dnd_battle.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlignmentRepository extends JpaRepository<Alignment, Long> {

}
