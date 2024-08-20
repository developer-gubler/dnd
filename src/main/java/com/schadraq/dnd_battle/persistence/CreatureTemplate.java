package com.schadraq.dnd_battle.persistence;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * NOTE: This class really represents a template for creating creatures.
 */
@Entity
@Table(name = "creature_template")
@Data
@EqualsAndHashCode(callSuper=false)
public class CreatureTemplate extends BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false, unique = true)
	@NotNull(message = "Name must be between 1 to 32 characters")
	@Size(min = 1, max = 32)
	private String name;

	/**
	 * NOTE: R2DBC does NOT support relations  (ie foreign key definitions).
	 * 		 As a result, I had to change this to just a UUID.  It is important
	 * 		 to create your tables outside of JPA so that the table
	 * 		 is created with the foreign key and the database (instead of the
	 * 		 application) can still enforce the relation.
	 */
	@Column(nullable = false)
	@NotNull
	private UUID family_id;

	/**
	 * NOTE: R2DBC does NOT support relations  (ie foreign key definitions).
	 * 		 As a result, I had to change this to just a UUID.  It is important
	 * 		 to create your tables outside of JPA so that the table
	 * 		 is created with the foreign key and the database (instead of the
	 * 		 application) can still enforce the relation.
	 */
	@Column(nullable = false)
	@NotNull
	private UUID creature_size_id;
	
	@Column(nullable = false)
	@NotBlank
	private String alignment;

	@Column(nullable = false)
    @Min(value = 0, message = "Walking speed cannot be less than 0")
	private Short speed_walk;

	@Column(nullable = false)
    @Min(value = 0, message = "Burrowing speed cannot be less than 0")
	private Short speed_burrow;

	@Column(nullable = false)
    @Min(value = 0, message = "Climbing speed cannot be less than 0")
	private Short speed_climb;

	@Column(nullable = false)
    @Min(value = 0, message = "Flying speed cannot be less than 0")
	private Short speed_fly;

	@Column(nullable = false)
    @Min(value = 0, message = "Swimming speed cannot be less than 0")
	private Short speed_swim;

	@Column(nullable = false)
    @Positive
	private Short str;

	@Column(nullable = false)
    @Positive
	private Short dex;

	@Column(nullable = false)
    @Positive
	private Short con;

	@Column(name = "int", nullable = false)
    @Positive
	private Short intelligence;

	@Column(nullable = false)
    @Positive
	private Short wis;

	@Column(nullable = false)
    @Positive
	private Short cha;

	@Column(nullable = false)
    @Positive
	private Short hit_points;
	
	@Column(nullable = false)
	@NotBlank
	private String hit_dice;

	@Column(nullable = false)
    @Positive
	private Short armor_class;

	@Column(nullable = false)
    @Positive
	private Short proficiency_bonus;

	/**
	 * NOTE: R2DBC does NOT support relations  (ie foreign key definitions).
	 * 		 As a result, I had to change this to just a UUID.  It is important
	 * 		 to create your tables outside of JPA so that the table
	 * 		 is created with the foreign key and the database (instead of the
	 * 		 application) can still enforce the relation.
	 */
	@Column(nullable = false)
	@NotNull
	private UUID challenge_rating_id;

	@Column(nullable = false)
	@NotNull
	private Boolean save_str;

	@Column(nullable = false)
	@NotNull
	private Boolean save_dex;

	@Column(nullable = false)
	@NotNull
	private Boolean save_con;

	@Column(nullable = false)
	@NotNull
	private Boolean save_int;

	@Column(nullable = false)
	@NotNull
	private Boolean save_wis;

	@Column(nullable = false)
	@NotNull
	private Boolean save_cha;
	
	@Column(nullable = false)
	@NotBlank
	private String acrobatics;
	
	@Column(nullable = false)
	@NotBlank
	private String animal_handling;
	
	@Column(nullable = false)
	@NotBlank
	private String arcana;
	
	@Column(nullable = false)
	@NotBlank
	private String athletics;
	
	@Column(nullable = false)
	@NotBlank
	private String deception;
	
	@Column(nullable = false)
	@NotBlank
	private String history;
	
	@Column(nullable = false)
	@NotBlank
	private String insight;
	
	@Column(nullable = false)
	@NotBlank
	private String intimidation;
	
	@Column(nullable = false)
	@NotBlank
	private String investigation;
	
	@Column(nullable = false)
	@NotBlank
	private String medicine;
	
	@Column(nullable = false)
	@NotBlank
	private String nature;
	
	@Column(nullable = false)
	@NotBlank
	private String perception;
	
	@Column(nullable = false)
	@NotBlank
	private String performance;
	
	@Column(nullable = false)
	@NotBlank
	private String persuasion;
	
	@Column(nullable = false)
	@NotBlank
	private String religion;
	
	@Column(nullable = false)
	@NotBlank
	private String sleight_of_hand;
	
	@Column(nullable = false)
	@NotBlank
	private String stealth;
	
	@Column(nullable = false)
	@NotBlank
	private String survival;
	
	@Column(nullable = false)
	@NotBlank
	private String alchemists_supplies;
	
	@Column(nullable = false)
	@NotBlank
	private String brewers_supplies;
	
	@Column(nullable = false)
	@NotBlank
	private String calligraphers_supplies;
	
	@Column(nullable = false)
	@NotBlank
	private String carpenters_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String cartographer_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String cobblers_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String cooks_utensils;
	
	@Column(nullable = false)
	@NotBlank
	private String disguise_kit;
	
	@Column(nullable = false)
	@NotBlank
	private String forgery_kit;
	
	@Column(nullable = false)
	@NotBlank
	private String gaming_set;
	
	@Column(nullable = false)
	@NotBlank
	private String glassblowers_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String herbalism_kit;
	
	@Column(nullable = false)
	@NotBlank
	private String jewelers_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String land_and_water_vehicles;
	
	@Column(nullable = false)
	@NotBlank
	private String leatherworkers_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String masons_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String musical_instrument;
	
	@Column(nullable = false)
	@NotBlank
	private String navigators_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String painters_supplies;
	
	@Column(nullable = false)
	@NotBlank
	private String poisoners_kit;
	
	@Column(nullable = false)
	@NotBlank
	private String potters_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String smiths_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String thieves_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String tinkers_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String weavers_tools;
	
	@Column(nullable = false)
	@NotBlank
	private String woodcarvers_tools;

	protected CreatureTemplate() {
		
	}

	public CreatureTemplate(String name, UUID family_id, UUID creature_size_id, String alignment,
			Short speed_walk, Short speed_burrow, Short speed_climb, Short speed_fly, Short speed_swim,
			Short str, Short dex, Short con, Short intelligence, Short wis, Short cha,
			Short hit_points, String hit_dice, Short armor_class, Short proficiency_bonus, UUID challenge_rating_id,
			Boolean save_str, Boolean save_dex, Boolean save_con, Boolean save_int, Boolean save_wis, Boolean save_cha,
			String acrobatics, String animal_handling, String arcana, String athletics, String deception,
			String history, String insight, String intimidation, String investigation, String medicine, String nature,
			String perception, String performance, String persuasion, String religion, String sleight_of_hand,
			String stealth, String survival, String alchemists_supplies, String brewers_supplies, String calligraphers_supplies,
			String carpenters_tools, String cartographer_tools, String cobblers_tools, String cooks_utensils,
			String disguise_kit, String forgery_kit, String gaming_set, String glassblowers_tools, String herbalism_kit,
			String jewelers_tools, String land_and_water_vehicles, String leatherworkers_tools, String masons_tools,
			String musical_instrument, String navigators_tools, String painters_supplies, String poisoners_kit,
			String potters_tools, String smiths_tools, String thieves_tools, String tinkers_tools,
			String weavers_tools, String woodcarvers_tools) {
		this.name = name;
		this.family_id = family_id;
		this.creature_size_id = creature_size_id;
		this.alignment = alignment;
		this.speed_walk = speed_walk;
		this.speed_burrow = speed_burrow;
		this.speed_climb = speed_climb;
		this.speed_fly = speed_fly;
		this.speed_swim = speed_swim;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.intelligence = intelligence;
		this.wis = wis;
		this.cha = cha;
		this.hit_points = hit_points;
		this.hit_dice = hit_dice;
		this.armor_class = armor_class;
		this.proficiency_bonus = proficiency_bonus;
		this.challenge_rating_id = challenge_rating_id;
		this.save_str = save_str;
		this.save_dex = save_dex;
		this.save_con = save_con;
		this.save_int = save_int;
		this.save_wis = save_wis;
		this.save_cha = save_cha;
		this.acrobatics = acrobatics;
		this.animal_handling = animal_handling;
		this.arcana = arcana;
		this.athletics = athletics;
		this.deception = deception;
		this.history = history;
		this.insight = insight;
		this.intimidation = intimidation;
		this.investigation = investigation;
		this.medicine = medicine;
		this.nature = nature;
		this.perception = perception;
		this.performance = performance;
		this.persuasion = persuasion;
		this.religion = religion;
		this.sleight_of_hand = sleight_of_hand;
		this.stealth = stealth;
		this.survival = survival;
		this.alchemists_supplies = alchemists_supplies;
		this.brewers_supplies = brewers_supplies;
		this.calligraphers_supplies = calligraphers_supplies;
		this.carpenters_tools = carpenters_tools;
		this.cartographer_tools = cartographer_tools;
		this.cobblers_tools = cobblers_tools;
		this.cooks_utensils = cooks_utensils;
		this.disguise_kit = disguise_kit;
		this.forgery_kit = forgery_kit;
		this.gaming_set = gaming_set;
		this.glassblowers_tools = glassblowers_tools;
		this.herbalism_kit = herbalism_kit;
		this.jewelers_tools = jewelers_tools;
		this.land_and_water_vehicles = land_and_water_vehicles;
		this.leatherworkers_tools = leatherworkers_tools;
		this.masons_tools = masons_tools;
		this.musical_instrument = musical_instrument;
		this.navigators_tools = navigators_tools;
		this.painters_supplies = painters_supplies;
		this.poisoners_kit = poisoners_kit;
		this.potters_tools = potters_tools;
		this.smiths_tools = smiths_tools;
		this.thieves_tools = thieves_tools;
		this.tinkers_tools = tinkers_tools;
		this.weavers_tools = weavers_tools;
		this.woodcarvers_tools = woodcarvers_tools;
	}

	public CreatureTemplate(UUID id, String name, UUID family_id, UUID creature_size_id, String alignment,
			Short speed_walk, Short speed_burrow, Short speed_climb, Short speed_fly, Short speed_swim,
			Short str, Short dex, Short con, Short intelligence, Short wis, Short cha,
			Short hit_points, String hit_dice, Short armor_class, Short proficiency_bonus, UUID challenge_rating_id,
			Boolean save_str, Boolean save_dex, Boolean save_con, Boolean save_int, Boolean save_wis, Boolean save_cha,
			String acrobatics, String animal_handling, String arcana, String athletics, String deception,
			String history, String insight, String intimidation, String investigation, String medicine, String nature,
			String perception, String performance, String persuasion, String religion, String sleight_of_hand,
			String stealth, String survival, String alchemists_supplies, String brewers_supplies, String calligraphers_supplies,
			String carpenters_tools, String cartographer_tools, String cobblers_tools, String cooks_utensils,
			String disguise_kit, String forgery_kit, String gaming_set, String glassblowers_tools, String herbalism_kit,
			String jewelers_tools, String land_and_water_vehicles, String leatherworkers_tools, String masons_tools,
			String musical_instrument, String navigators_tools, String painters_supplies, String poisoners_kit,
			String potters_tools, String smiths_tools, String thieves_tools, String tinkers_tools,
			String weavers_tools, String woodcarvers_tools) {
		this(name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim,
				str, dex, con, intelligence, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id,
				save_str, save_dex, save_con, save_int, save_wis, save_cha,
				acrobatics, animal_handling, arcana, athletics, deception,
				history, insight, intimidation, investigation, medicine, nature, // 37
				perception, performance, persuasion, religion, sleight_of_hand,
				stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, // 47
				carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils,
				disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit,
				jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools,
				musical_instrument, navigators_tools, painters_supplies, poisoners_kit,
				potters_tools, smiths_tools, thieves_tools, tinkers_tools,
				weavers_tools, woodcarvers_tools);
		this.id = id;
	}
}
