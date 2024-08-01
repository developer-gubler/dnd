package com.schadraq.dnd_battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schadraq.dnd_battle.persistence.Alignment;
import com.schadraq.dnd_battle.persistence.AlignmentRepository;

@Service
public class AlignmentService {

	@Autowired
	private AlignmentRepository repo;
	
	public List<Alignment> getAlignments() {
		return repo.findAll();
	}
}
