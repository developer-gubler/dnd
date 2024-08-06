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
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "creature_family")
@Data
public class CreatureFamily extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "classification_id", referencedColumnName = "id")
	private CreatureClassification classication;

	@Column(nullable = false, unique=true)
	@NotBlank
	private String name;

	protected CreatureFamily() {
		
	}

	public CreatureFamily(CreatureClassification classification, @NotBlank String name) {
		this.classication = classification;
		this.name = name;
	}

	public CreatureFamily(@NotBlank UUID id, CreatureClassification classification, @NotBlank String name) {
		this(classification, name);
		this.id = id;
	}
}
