package com.schadraq.dnd.persistence;

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
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "challenge_rating")
@Data
@EqualsAndHashCode(callSuper=false)
public class ChallengeRating extends BaseEntity {

	@Id @org.springframework.data.annotation.Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column
	@NotNull
	@Positive
	private BigDecimal cr;
	
	@Column
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
