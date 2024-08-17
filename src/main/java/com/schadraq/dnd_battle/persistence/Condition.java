package com.schadraq.dnd_battle.persistence;

import java.util.UUID;

import org.springframework.lang.NonNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "condition")
@Data
public class Condition extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	/**
	 * NOTE: R2DBC does NOT support relations  (ie foreign key definitions).
	 * 		 As a result, I had to change this to just a UUID.  It is important
	 * 		 to create your tables outside of JPA so that the table
	 * 		 is created with the foreign key and the database (instead of the
	 * 		 application) can still enforce the relation.
	 */
	@Column(nullable = false)
	@NonNull
	private UUID battle_id;

//	private BattleParticipant source;
//
//	private List<BattleParticipant> target;

	protected Condition() {
		
	}

	public Condition(UUID battle_id) {
		this(UUID.randomUUID(), battle_id);
	}

	public Condition(UUID id, UUID battle_id) {
		this.id = id;
		this.battle_id = battle_id;
	}
}
