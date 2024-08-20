package com.schadraq.dnd_battle.persistence;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "battle")
@Data
@EqualsAndHashCode(callSuper=false)
public class Battle extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	@NotNull
	private Instant start;

	@Column(nullable = false)
	@NotNull(message = "Location must be between 1 to 64 characters")
	@Size(min = 1, max = 64)
	private String location;

	protected Battle() {
		
	}

	public Battle(String location) {
		this(Instant.now(), location);
	}

	public Battle(Instant start, String location) {
		this(UUID.randomUUID(), start, location);
	}

	public Battle(UUID id, Instant start, String location) {
		this.id = id;
		this.start = start;
		this.location = location;
	}
}
