package com.schadraq.dnd.persistence;

import java.util.UUID;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "battle_participant")
@Data
@EqualsAndHashCode(callSuper=false)
public class BattleParticipant extends BaseEntity {

	@Id @org.springframework.data.annotation.Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	/**
	 * NOTE: R2DBC does NOT support relations  (ie foreign key definitions).
	 * 		 As a result, I had to change this to just a UUID.  It is important
	 * 		 to create your tables outside of JPA so that the table
	 * 		 is created with the foreign key and the database (instead of the
	 * 		 application) can still enforce the relation.
	 */
	@Column(value = "battle_id")
	@NotNull
	private UUID battleId;

	/**
	 * NOTE: R2DBC does NOT support relations  (ie foreign key definitions).
	 * 		 As a result, I had to change this to just a UUID.  It is important
	 * 		 to manually create your tables outside of JPA so that the table
	 * 		 is created with the foreign key and the database (instead of the
	 * 		 application) can still enforce the relation.
	 */
	@Column(value = "template_id")
	@NotNull
	private UUID templateId;

	@Column
	@NotNull
    @Positive
	private Short initiative;

	@Column(value = "hit_points")
	@NotNull
    @Min(value = 0)
	private Short hitPoints;

	protected BattleParticipant() {
		
	}

	public BattleParticipant(UUID battle_id, UUID template_id, Short initiative, Short hit_points) {
		this(UUID.randomUUID(), battle_id, template_id, initiative, hit_points);
	}

	public BattleParticipant(UUID id, UUID battle_id, UUID template_id, Short initiative, Short hit_points) {
		this.id = id;
		this.battleId = battle_id;
		this.templateId = template_id;
		this.initiative = initiative;
		this.hitPoints = hit_points;
	}
}
