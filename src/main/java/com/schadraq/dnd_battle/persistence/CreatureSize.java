package com.schadraq.dnd_battle.persistence;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name = "creature_size")
@Data
public class CreatureSize extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false, unique=true)
	@NotBlank
	private String name;

	@Column(nullable = false, unique = true)
	@Positive
	private BigDecimal space;

	protected CreatureSize() {
		
	}

	public CreatureSize(@NotBlank String name, @Positive BigDecimal space) {
		this.name = name;
		this.space = space;
	}

	public CreatureSize(@NotBlank UUID id, @NotBlank String name, @Positive BigDecimal space) {
		this(name, space);
		this.id = id;
	}
}
