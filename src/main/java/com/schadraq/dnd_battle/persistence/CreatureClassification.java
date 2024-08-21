package com.schadraq.dnd_battle.persistence;

import java.util.UUID;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "creature_classification")
@Data
@EqualsAndHashCode(callSuper=false)
public class CreatureClassification extends BaseEntity {

	@Id @org.springframework.data.annotation.Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column
	@NotNull(message = "Name must be between 1 to 64 characters")
	@Size(min = 1, max = 64)
	private String name;

	protected CreatureClassification() {
		
	}

	public CreatureClassification(String name) {
		this.name = name;
	}

	public CreatureClassification(UUID id, String name) {
		this(name);
		this.id = id;
	}

}
