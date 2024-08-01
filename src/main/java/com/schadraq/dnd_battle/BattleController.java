package com.schadraq.dnd_battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schadraq.dnd_battle.persistence.Alignment;

@RestController
@RequestMapping("dnd-battle")
public class BattleController {

	@Autowired
	private AlignmentService serviceAlignment;
	
	@GetMapping("/alignments")
	public List<Alignment> getAlignmentList() {
		return serviceAlignment.getAlignments();
	}
}
