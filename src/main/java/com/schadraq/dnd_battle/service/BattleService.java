package com.schadraq.dnd_battle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schadraq.dnd_battle.persistence.Battle;
import com.schadraq.dnd_battle.persistence.BattleParticipant;
import com.schadraq.dnd_battle.persistence.BattleParticipantRepository;
import com.schadraq.dnd_battle.persistence.BattleRepository;

@Service
public class BattleService extends BaseService {

	@Autowired
	private BattleRepository repoBattle;

	@Autowired
	private BattleParticipantRepository repoBattleParticipant;

	public Battle createBattle(Battle battle) {
        
        getConstraintViolations(battle);

        return repoBattle.saveAndFlush(battle);
	}

	public BattleParticipant createSingleBattleParticipant(BattleParticipant participant) {
        
        getConstraintViolations(participant);

        return repoBattleParticipant.saveAndFlush(participant);
	}

	public void deleteSingleBattleParticipant(BattleParticipant participant) {
        
        getConstraintViolations(participant);

		repoBattleParticipant.delete(participant);
	}
}
