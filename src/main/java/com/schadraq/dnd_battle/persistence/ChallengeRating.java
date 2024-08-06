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
@Table(name = "challenge_rating")
@Data
public class ChallengeRating extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false, unique = true)
	@Positive
	private BigDecimal cr;
	
	@Column(nullable = false, unique = true)
	@Positive
	private Long experience;

	protected ChallengeRating() {
		
	}

	public ChallengeRating(@Positive BigDecimal cr, @Positive Long experience) {
		this.cr = cr;
		this.experience = experience;
	}

	public ChallengeRating(@NotBlank UUID id, @Positive BigDecimal cr, @Positive Long experience) {
		this(cr, experience);
		this.id = id;
	}
}
