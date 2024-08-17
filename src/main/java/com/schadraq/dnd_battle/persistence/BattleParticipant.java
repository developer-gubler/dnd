package com.schadraq.dnd_battle.persistence;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name = "battle_participant")
@Data
public class BattleParticipant extends BaseEntity {

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
	@NotNull
	private UUID battle_id;

	/**
	 * NOTE: R2DBC does NOT support relations  (ie foreign key definitions).
	 * 		 As a result, I had to change this to just a UUID.  It is important
	 * 		 to manually create your tables outside of JPA so that the table
	 * 		 is created with the foreign key and the database (instead of the
	 * 		 application) can still enforce the relation.
	 */
	@Column(nullable = false)
	@NotNull
	private UUID template_id;

	@Column(nullable = false)
	@NotNull
    @Positive
	private Short initiative;

	@Column(nullable = false)
	@NotNull
    @Min(value = 0)
	private Short hit_points;

	protected BattleParticipant() {
		
	}

	public BattleParticipant(UUID battle_id, UUID template_id, Short initiative, Short hit_points) {
		this(UUID.randomUUID(), battle_id, template_id, initiative, hit_points);
	}

	public BattleParticipant(UUID id, UUID battle_id, UUID template_id, Short initiative, Short hit_points) {
		this.id = id;
		this.battle_id = battle_id;
		this.template_id = template_id;
		this.initiative = initiative;
		this.hit_points = hit_points;
	}
}
