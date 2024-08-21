package com.schadraq.dnd_battle.persistence;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.lang.NonNull;

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

	@Id @org.springframework.data.annotation.Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column
	@NotBlank
	private String name;

	@Column
	@Min(value = 0)
	private Long price;

	@Column
	@Min(value = 0)
	private BigDecimal weight;

	@Column
	@NotBlank
	private String type;

	@Column
	@Min(value = 0)
	private Short ac;

	@Column(value = "add_dex")
	@NonNull
	private Boolean addDex;

	@Column(value = "max_dex_bonus")
	@Min(value = 0)
	private Short maxDexBonus;

	@Column(value = "str_req")
	@Min(value = 0)
	private Short strReq;

	@Column(value = "stealth_disadvantage")
	@NonNull
	private Boolean stealthDisadvantage;

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
		this.addDex = add_dex;
		this.maxDexBonus = max_dex_bonus;
		this.strReq = str_req;
		this.stealthDisadvantage = stealth_disadvantage;
	}
}
