package com.schadraq.dnd_battle.persistence;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "creature_classification")
@Data
public class CreatureClassification extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false, unique = true)
	@NotBlank
	private String name;

	protected CreatureClassification() {
		
	}

	public CreatureClassification(@NotBlank String name) {
		this.name = name;
	}

	public CreatureClassification(@NotBlank UUID id, @NotBlank String name) {
		this(name);
		this.id = id;
	}

}
