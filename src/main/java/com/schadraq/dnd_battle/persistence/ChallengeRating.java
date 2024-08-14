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
import lombok.Data;

@Entity
@Table(name = "challenge_rating")
@Data
public class ChallengeRating extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false, unique = true)
	@NotNull
	@Positive
	private BigDecimal cr;
	
	@Column(nullable = false, unique = true)
	@NotNull
	@Positive
	private Long experience;

	protected ChallengeRating() {
		
	}

	public ChallengeRating(BigDecimal cr, Long experience) {
		this.cr = cr;
		this.experience = experience;
	}

	public ChallengeRating(UUID id, BigDecimal cr, Long experience) {
		this(cr, experience);
		this.id = id;
	}
}
