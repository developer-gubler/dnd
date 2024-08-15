package com.schadraq.dnd_battle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schadraq.dnd_battle.persistence.Battle;
import com.schadraq.dnd_battle.persistence.BattleParticipant;
import com.schadraq.dnd_battle.persistence.BattleParticipantRepository;
import com.schadraq.dnd_battle.persistence.BattleRepository;

import reactor.core.publisher.Mono;

@Service
public class BattleService extends BaseService {

	@Autowired
	private BattleRepository repoBattle;

	@Autowired
	private BattleParticipantRepository repoBattleParticipant;

	public Mono<Battle> createBattle(Battle battle) {
        
        getConstraintViolations(battle);

        return Mono.just(repoBattle.saveAndFlush(battle));
	}

	public Mono<BattleParticipant> createSingleBattleParticipant(BattleParticipant participant) {
        
        getConstraintViolations(participant);

        return Mono.just(repoBattleParticipant.saveAndFlush(participant));
	}

	public void deleteSingleBattleParticipant(BattleParticipant participant) {
        
        getConstraintViolations(participant);

		repoBattleParticipant.delete(participant);
	}
}
