package com.schadraq.dnd_battle.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Alignment extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	@NotBlank
	private String name;

	@Column(unique=true)
	@NotBlank
	private String abbr;
	
	@Column(unique=true)
	@NotBlank
	private String description;

	protected Alignment() {
		
	}

	public Alignment(@NotBlank String name, @NotBlank String abbr, @NotBlank String description) {
		this.name = name;
		this.abbr = abbr;
		this.description = description;
	}

	public Alignment(@Positive Long id, @NotBlank String name, @NotBlank String abbr, @NotBlank String description) {
		this(name, abbr, description);
		this.id = id;
	}
}
