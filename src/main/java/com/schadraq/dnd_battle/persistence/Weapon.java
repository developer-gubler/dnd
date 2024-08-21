package com.schadraq.dnd_battle.persistence;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.relational.core.mapping.Column;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Weapon extends BaseEntity {

	@Id @org.springframework.data.annotation.Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column
	@NotNull(message = "Name must be between 1 to 64 characters")
	@Size(min = 1, max = 64)
	private String name;
	
	@Column
	@Min(value = 0)
	private Long price;

	@Column
	@NotNull(message = "Name must be between 1 to 16 characters")
	@Size(min = 1, max = 16)
	private String damage;

	@Column(value = "dmg_type")
	@NotBlank
	private String damageType;

	@Column
	@Min(value = 0)
	private BigDecimal weight;

	@Column(value = "wpn_type")
	@NotBlank
	private String weaponType;

	@Column
	@Nullable
	private String ammunition;

	@Column
	@NotNull
	private Boolean finesse;

	@Column
	@NotNull
	private Boolean heavy;

	@Column
	@NotNull
	private Boolean light;

	@Column
	@NotNull
	private Boolean loading;

	@Column
	@NotNull
	private Boolean reach;

	@Column
	@NotNull
	private Boolean special;

	@Column
	@Nullable
	private String thrown;

	@Column(value = "two_handed")
	@NotNull
	private Boolean twoHanded;

	@Column
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
		this.damageType = dmg_type;
		this.weight = weight;
		this.weaponType = wpn_type;
		this.ammunition = ammunition;
		this.finesse = finesse;
		this.heavy = heavy;
		this.light = light;
		this.loading = loading;
		this.reach = reach;
		this.special = special;
		this.thrown = thrown;
		this.twoHanded = two_handed;
		this.versatile = versatile;
	}
}
