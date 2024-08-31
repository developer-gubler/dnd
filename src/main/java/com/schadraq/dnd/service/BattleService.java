package com.schadraq.dnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schadraq.dnd.persistence.Battle;
import com.schadraq.dnd.persistence.BattleParticipant;
import com.schadraq.dnd.persistence.BattleParticipantRepository;
import com.schadraq.dnd.persistence.BattleRepository;

import reactor.core.publisher.Mono;

@Service
public class BattleService extends BaseService {

	@Autowired
	private BattleRepository repoBattle;

	@Autowired
	private BattleParticipantRepository repoBattleParticipant;

	public Mono<Battle> createBattle(Battle battle) {
        
        getConstraintViolations(battle);

        return repoBattle.save(battle);
	}

	public Mono<BattleParticipant> createSingleBattleParticipant(BattleParticipant participant) {
        
        getConstraintViolations(participant);

        return repoBattleParticipant.save(participant);
	}

	public void deleteSingleBattleParticipant(BattleParticipant participant) {
        
        getConstraintViolations(participant);

		repoBattleParticipant.delete(participant);
	}
}
