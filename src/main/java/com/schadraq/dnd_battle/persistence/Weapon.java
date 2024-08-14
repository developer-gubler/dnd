package com.schadraq.dnd_battle.persistence;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Weapon extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false, unique = true)
	@NotNull(message = "Name must be between 1 to 64 characters")
	@Size(min = 1, max = 64)
	private String name;
	
	@Column(nullable = false)
	@Min(value = 0)
	private Long price;

	@Column(nullable = false)
	@NotNull(message = "Name must be between 1 to 16 characters")
	@Size(min = 1, max = 16)
	private String damage;

	@Column(nullable = false)
	@NotBlank
	private String dmg_type;

	@Column(nullable = false)
	@Min(value = 0)
	private BigDecimal weight;

	@Column(nullable = false)
	@NotBlank
	private String wpn_type;

	@Column(nullable = true)
	@Nullable
	private String ammunition;

	@Column(nullable = false)
	@NotNull
	private Boolean finesse;

	@Column(nullable = false)
	@NotNull
	private Boolean heavy;

	@Column(nullable = false)
	@NotNull
	private Boolean light;

	@Column(nullable = false)
	@NotNull
	private Boolean loading;

	@Column(nullable = false)
	@NotNull
	private Boolean reach;

	@Column(nullable = false)
	@NotNull
	private Boolean special;

	@Column(nullable = true)
	@Nullable
	private String thrown;

	@Column(nullable = false)
	@NotNull
	private Boolean two_handed;

	@Column(nullable = true)
	@Nullable
	private String versatile;

	protected Weapon() {
		
	}

	public Weapon(String name, Long price, String damage, String dmg_type, BigDecimal weight, String wpn_type, String ammunition, Boolean finesse, Boolean heavy, Boolean light, Boolean loading, Boolean reach, Boolean special, String thrown, Boolean two_handed, String versatile) {
		this(UUID.randomUUID(), name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile);
	}

	public Weapon(UUID id, String name, Long price, String damage, String dmg_type, BigDecimal weight, String wpn_type, String ammunition, Boolean finesse, Boolean heavy, Boolean light, Boolean loading, Boolean reach, Boolean special, String thrown, Boolean two_handed, String versatile) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.damage = damage;
		this.dmg_type = dmg_type;
		this.weight = weight;
		this.wpn_type = wpn_type;
		this.ammunition = ammunition;
		this.finesse = finesse;
		this.heavy = heavy;
		this.light = light;
		this.loading = loading;
		this.reach = reach;
		this.special = special;
		this.thrown = thrown;
		this.two_handed = two_handed;
		this.versatile = versatile;
	}
}
