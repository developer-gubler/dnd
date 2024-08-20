package com.schadraq.dnd_battle.persistence;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "creature_size")
@Data
@EqualsAndHashCode(callSuper=false)
public class CreatureSize extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false, unique=true)
	@NotNull(message = "Name must be between 1 to 16 characters")
	@Size(min = 1, max = 16)
	private String name;

	@Column(nullable = false)
	@NotNull
	@Positive
	private BigDecimal space;

	protected CreatureSize() {
		
	}

	public CreatureSize(String name, BigDecimal space) {
		this.name = name;
		this.space = space;
	}

	public CreatureSize(UUID id, String name, BigDecimal space) {
		this(name, space);
		this.id = id;
	}
}
