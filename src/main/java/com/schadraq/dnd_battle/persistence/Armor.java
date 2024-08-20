package com.schadraq.dnd_battle.persistence;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Armor extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false, unique = true)
	@NotBlank
	private String name;
	
	@Column(nullable = false)
	@Min(value = 0)
	private Long price;
	
	@Column(nullable = false)
	@Min(value = 0)
	private BigDecimal weight;
	
	@Column(nullable = false)
	@NotBlank
	private String type;
	
	@Column(nullable = false)
	@Min(value = 0)
	private Short ac;

	@Column(nullable = false)
	@NonNull
	private Boolean add_dex;
	
	@Column(nullable = false)
	@Min(value = 0)
	private Short max_dex_bonus;
	
	@Column(nullable = false)
	@Min(value = 0)
	private Short str_req;

	@Column(nullable = false)
	@NonNull
	private Boolean stealth_disadvantage;

	protected Armor() {
		
	}

	public Armor(String name, Long price, BigDecimal weight, String type, Short ac, Boolean add_dex, Short max_dex_bonus, Short str_req, Boolean stealth_disadvantage) {
		this(UUID.randomUUID(), name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage);
	}

	public Armor(UUID id, String name, Long price, BigDecimal weight, String type, Short ac, Boolean add_dex, Short max_dex_bonus, Short str_req, Boolean stealth_disadvantage) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.type = type;
		this.ac = ac;
		this.add_dex = add_dex;
		this.max_dex_bonus = max_dex_bonus;
		this.str_req = str_req;
		this.stealth_disadvantage = stealth_disadvantage;
	}
}
