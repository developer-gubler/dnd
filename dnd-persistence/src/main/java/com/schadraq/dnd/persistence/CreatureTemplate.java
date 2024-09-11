package com.schadraq.dnd.persistence;

import java.util.UUID;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	@Id @org.springframework.data.annotation.Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column
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
	@Column(value = "family_id")
	@NotNull
	private UUID familyId;

	/**
	 * NOTE: R2DBC does NOT support relations  (ie foreign key definitions).
	 * 		 As a result, I had to change this to just a UUID.  It is important
	 * 		 to create your tables outside of JPA so that the table
	 * 		 is created with the foreign key and the database (instead of the
	 * 		 application) can still enforce the relation.
	 */
	@Column(value = "size_id")
	@NotNull
	private UUID sizeId;
	
	@Column
	@NotBlank
	private String alignment;

	@Column(value = "speed_walk")
    @Min(value = 0, message = "Walking speed cannot be less than 0")
	private Short speedWalk;

	@Column(value = "speed_burrow")
    @Min(value = 0, message = "Burrowing speed cannot be less than 0")
	private Short speedBurrow;

	@Column(value = "speed_climb")
    @Min(value = 0, message = "Climbing speed cannot be less than 0")
	private Short speedClimb;

	@Column(value = "speed_fly")
    @Min(value = 0, message = "Flying speed cannot be less than 0")
	private Short speedFly;

	@Column(value = "speed_swim")
    @Min(value = 0, message = "Swimming speed cannot be less than 0")
	private Short speedSwim;

	@Column
    @Positive
	private Short str;

	@Column
    @Positive
	private Short dex;

	@Column
    @Positive
	private Short con;

	@Column(value = "int")
    @Positive
	private Short intelligence;

	@Column
    @Positive
	private Short wis;

	@Column
    @Positive
	private Short cha;

	@Column(value = "hit_points")
    @Positive
	private Short hitPoints;
	
	@Column(value = "hit_dice")
	@NotBlank
	private String hitDice;

	@Column(value = "armor_class")
    @Positive
	private Short armorClass;

	@Column(value = "proficiency_bonus")
    @Positive
	private Short proficiencyBonus;

	/**
	 * NOTE: R2DBC does NOT support relations  (ie foreign key definitions).
	 * 		 As a result, I had to change this to just a UUID.  It is important
	 * 		 to create your tables outside of JPA so that the table
	 * 		 is created with the foreign key and the database (instead of the
	 * 		 application) can still enforce the relation.
	 */
	@Column(value = "challenge_rating_id")
	@NotNull
	private UUID challengeRatingId;

	@Column(value = "save_str")
	@NotNull
	private Boolean saveStr;

	@Column(value = "save_dex")
	@NotNull
	private Boolean saveDex;

	@Column(value = "save_con")
	@NotNull
	private Boolean saveCon;

	@Column(value = "save_int")
	@NotNull
	private Boolean saveInt;

	@Column(value = "save_wis")
	@NotNull
	private Boolean saveWis;

	@Column(value = "save_cha")
	@NotNull
	private Boolean saveCha;
	
	@Column
	@NotBlank
	private String acrobatics;
	
	@Column(value = "animal_handling")
	@NotBlank
	private String animalHandling;
	
	@Column
	@NotBlank
	private String arcana;
	
	@Column
	@NotBlank
	private String athletics;
	
	@Column
	@NotBlank
	private String deception;
	
	@Column
	@NotBlank
	private String history;
	
	@Column
	@NotBlank
	private String insight;
	
	@Column
	@NotBlank
	private String intimidation;
	
	@Column
	@NotBlank
	private String investigation;
	
	@Column
	@NotBlank
	private String medicine;
	
	@Column
	@NotBlank
	private String nature;
	
	@Column
	@NotBlank
	private String perception;
	
	@Column
	@NotBlank
	private String performance;
	
	@Column
	@NotBlank
	private String persuasion;
	
	@Column
	@NotBlank
	private String religion;
	
	@Column(value = "sleight_of_hand")
	@NotBlank
	private String sleightOfHand;
	
	@Column
	@NotBlank
	private String stealth;
	
	@Column
	@NotBlank
	private String survival;
	
	@Column(value = "alchemists_supplies")
	@NotBlank
	private String alchemistsSupplies;
	
	@Column(value = "brewers_supplies")
	@NotBlank
	private String brewersSupplies;
	
	@Column(value = "calligraphers_supplies")
	@NotBlank
	private String calligraphersSupplies;
	
	@Column(value = "carpenters_tools")
	@NotBlank
	private String carpentersTools;
	
	@Column(value = "cartographer_tools")
	@NotBlank
	private String cartographerTools;
	
	@Column(value = "cobblers_tools")
	@NotBlank
	private String cobblersTools;
	
	@Column(value = "cooks_utensils")
	@NotBlank
	private String cooksUtensils;
	
	@Column(value = "disguise_kit")
	@NotBlank
	private String disguiseKit;
	
	@Column(value = "forgery_kit")
	@NotBlank
	private String forgeryKit;
	
	@Column(value = "gaming_set")
	@NotBlank
	private String gamingSet;
	
	@Column(value = "glassblowers_tools")
	@NotBlank
	private String glassblowersTools;
	
	@Column(value = "herbalism_kit")
	@NotBlank
	private String herbalismKit;
	
	@Column(value = "jewelers_tools")
	@NotBlank
	private String jewelersTools;
	
	@Column(value = "land_and_water_vehicles")
	@NotBlank
	private String landAndWaterVehicles;
	
	@Column(value = "leatherworkers_tools")
	@NotBlank
	private String leatherworkersTools;
	
	@Column(value = "masons_tools")
	@NotBlank
	private String masonsTools;
	
	@Column(value = "musical_instrument")
	@NotBlank
	private String musicalInstrument;
	
	@Column(value = "navigators_tools")
	@NotBlank
	private String navigatorsTools;
	
	@Column(value = "painters_supplies")
	@NotBlank
	private String paintersSupplies;
	
	@Column(value = "poisoners_kit")
	@NotBlank
	private String poisonersKit;
	
	@Column(value = "potters_tools")
	@NotBlank
	private String pottersTools;
	
	@Column(value = "smiths_tools")
	@NotBlank
	private String smithsTools;
	
	@Column(value = "thieves_tools")
	@NotBlank
	private String thievesTools;
	
	@Column(value = "tinkers_tools")
	@NotBlank
	private String tinkersTools;
	
	@Column(value = "weavers_tools")
	@NotBlank
	private String weaversTools;
	
	@Column(value = "woodcarvers_tools")
	@NotBlank
	private String woodcarversTools;

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
		this.familyId = family_id;
		this.sizeId = creature_size_id;
		this.alignment = alignment;
		this.speedWalk = speed_walk;
		this.speedBurrow = speed_burrow;
		this.speedClimb = speed_climb;
		this.speedFly = speed_fly;
		this.speedSwim = speed_swim;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.intelligence = intelligence;
		this.wis = wis;
		this.cha = cha;
		this.hitPoints = hit_points;
		this.hitDice = hit_dice;
		this.armorClass = armor_class;
		this.proficiencyBonus = proficiency_bonus;
		this.challengeRatingId = challenge_rating_id;
		this.saveStr = save_str;
		this.saveDex = save_dex;
		this.saveCon = save_con;
		this.saveInt = save_int;
		this.saveWis = save_wis;
		this.saveCha = save_cha;
		this.acrobatics = acrobatics;
		this.animalHandling = animal_handling;
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
		this.sleightOfHand = sleight_of_hand;
		this.stealth = stealth;
		this.survival = survival;
		this.alchemistsSupplies = alchemists_supplies;
		this.brewersSupplies = brewers_supplies;
		this.calligraphersSupplies = calligraphers_supplies;
		this.carpentersTools = carpenters_tools;
		this.cartographerTools = cartographer_tools;
		this.cobblersTools = cobblers_tools;
		this.cooksUtensils = cooks_utensils;
		this.disguiseKit = disguise_kit;
		this.forgeryKit = forgery_kit;
		this.gamingSet = gaming_set;
		this.glassblowersTools = glassblowers_tools;
		this.herbalismKit = herbalism_kit;
		this.jewelersTools = jewelers_tools;
		this.landAndWaterVehicles = land_and_water_vehicles;
		this.leatherworkersTools = leatherworkers_tools;
		this.masonsTools = masons_tools;
		this.musicalInstrument = musical_instrument;
		this.navigatorsTools = navigators_tools;
		this.paintersSupplies = painters_supplies;
		this.poisonersKit = poisoners_kit;
		this.pottersTools = potters_tools;
		this.smithsTools = smiths_tools;
		this.thievesTools = thieves_tools;
		this.tinkersTools = tinkers_tools;
		this.weaversTools = weavers_tools;
		this.woodcarversTools = woodcarvers_tools;
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
