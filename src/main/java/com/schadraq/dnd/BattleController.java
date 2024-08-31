package com.schadraq.dnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schadraq.dnd.persistence.Battle;
import com.schadraq.dnd.persistence.BattleParticipant;
import com.schadraq.dnd.service.BattleService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/dnd/battle")
@Slf4j
public class BattleController {

	@Autowired
	private BattleService svcBattle;

	@PostMapping("/create-battle")
	public Mono<Battle> createBattle(@RequestBody Battle battle) {
		return svcBattle.createBattle(battle);
	}

	@PostMapping(value = "/create-single-battle-participant", consumes = "application/json", produces = "application/json")
	public Mono<BattleParticipant> createBattleParticipant(@RequestBody BattleParticipant participant) {
		return svcBattle.createSingleBattleParticipant(participant);
	}

	@DeleteMapping(value = "/delete-single-battle-participant", consumes = "application/json", produces = "application/json")
	public void deleteBattleParticipant(@RequestBody BattleParticipant participant) {
		svcBattle.deleteSingleBattleParticipant(participant);
	}
}
