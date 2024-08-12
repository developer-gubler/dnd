package com.schadraq.dnd_battle.persistence;

import java.util.List;
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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name = "battle_participant")
@Data
public class BattleParticipant extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "template_id", referencedColumnName = "id")
	@NonNull
	private CreatureTemplate template;

	@Column(nullable = false)
    @Positive
	private Short initiative;
	
	@Column(nullable = false)
    @Min(value = 0)
	private Short hit_points;
}
