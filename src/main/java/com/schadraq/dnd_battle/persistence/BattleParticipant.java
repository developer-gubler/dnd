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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "battle_id", referencedColumnName = "id", nullable = false)
	@NotNull
	private Battle battle;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "template_id", referencedColumnName = "id", nullable = false)
	@NotNull
	private CreatureTemplate template;

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

	public BattleParticipant(Battle battle, CreatureTemplate template, Short initiative, Short hit_points) {
		this(UUID.randomUUID(), battle, template, initiative, hit_points);
	}

	public BattleParticipant(UUID id, Battle battle, CreatureTemplate template, Short initiative, Short hit_points) {
		this.id = id;
		this.battle = battle;
		this.template = template;
		this.initiative = initiative;
		this.hit_points = hit_points;
	}
}
