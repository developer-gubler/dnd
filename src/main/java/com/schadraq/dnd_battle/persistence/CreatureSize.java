package com.schadraq.dnd_battle.persistence;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	@Id @org.springframework.data.annotation.Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column
	@NotNull(message = "Name must be between 1 to 16 characters")
	@Size(min = 1, max = 16)
	private String name;

	@Column
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
