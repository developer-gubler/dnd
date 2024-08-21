--DROP TABLE IF EXISTS creature_weapon_xref;

--DROP TABLE IF EXISTS creature_weapon_proficiency;

--DROP TABLE IF EXISTS weapon;

--DROP TABLE IF EXISTS creature_armor_xref;

--DROP TABLE IF EXISTS creature_armor_proficiency;

--DROP TABLE IF EXISTS armor;

--DROP TABLE IF EXISTS language;

--DROP TABLE IF EXISTS condition;

--DROP TABLE IF EXISTS battle_participant;

--DROP TABLE IF EXISTS battle;

--DROP TABLE IF EXISTS creature;

--DROP TABLE IF EXISTS creature_template;

--DROP TABLE IF EXISTS creature_family;

--DROP TABLE IF EXISTS creature_classification;

--DROP TABLE IF EXISTS creature_size;

--DROP TABLE IF EXISTS challenge_rating;

--DROP TABLE IF EXISTS battle_participant;

--DROP TABLE IF EXISTS battle;

--DROP TYPE IF EXISTS alignment_type;
--DROP TYPE IF EXISTS ability_level;
--DROP TYPE IF EXISTS armor_type;
--DROP TYPE IF EXISTS damage_type;
--DROP TYPE IF EXISTS weapon_type;

CREATE TABLE IF NOT EXISTS challenge_rating
(
    id uuid primary key,
    cr double precision NOT NULL,
    experience bigint NOT NULL,
    CONSTRAINT unique_cr_experience UNIQUE (experience)
        INCLUDE(experience),
    CONSTRAINT unique_cr_value UNIQUE (cr)
        INCLUDE(cr),
    CONSTRAINT check_cr_value CHECK (cr > 0::double precision),
    CONSTRAINT check_cr_experience CHECK (experience > 0)
);

CREATE TABLE IF NOT EXISTS creature_size
(
    id uuid primary key,
    name character varying(16) NOT NULL,
    space double precision NOT NULL,
    CONSTRAINT unique_size_name UNIQUE (name)
        INCLUDE(name),
    CONSTRAINT check_size_space CHECK (space > 0.0::double precision AND space <= 20.0::double precision) NOT VALID
);

CREATE TABLE IF NOT EXISTS creature_classification
(
    id uuid primary key,
    name character varying(64) NOT NULL,
    CONSTRAINT unique_type_name UNIQUE (name)
        INCLUDE(name)
);

CREATE TABLE IF NOT EXISTS creature_family
(
    id uuid primary key,
    classification_id uuid NOT NULL,
    name character varying(32) NOT NULL,
    CONSTRAINT unique_family_classification UNIQUE (classification_id, name)
        INCLUDE(classification_id, name),
    CONSTRAINT fk_family_classification_id FOREIGN KEY (classification_id)
        REFERENCES creature_classification (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TYPE alignment_type AS ENUM ('U', 'LG', 'NG', 'CG', 'LN', 'N', 'CN', 'LE', 'NE', 'CE');

CREATE TYPE ability_level AS ENUM ('none', 'proficient', 'expertise');

CREATE TABLE IF NOT EXISTS creature_template
(
    id uuid primary key,
    name character varying(32) NOT NULL,
    family_id uuid NOT NULL,
    size_id uuid NOT NULL,
    alignment alignment_type NOT NULL,
    speed_walk smallint NOT NULL,
    speed_burrow smallint NOT NULL,
    speed_climb smallint NOT NULL,
    speed_fly smallint NOT NULL,
    speed_swim smallint NOT NULL,
    str smallint NOT NULL,
    dex smallint NOT NULL,
    con smallint NOT NULL,
    int smallint NOT NULL,
    wis smallint NOT NULL,
    cha smallint NOT NULL,
    hit_points smallint NOT NULL,
    hit_dice character varying(16) NOT NULL,
    armor_class smallint NOT NULL,
    proficiency_bonus smallint NOT NULL,
    challenge_rating_id uuid NOT NULL,
    save_str boolean NOT NULL DEFAULT false,
    save_dex boolean NOT NULL DEFAULT false,
    save_con boolean NOT NULL DEFAULT false,
    save_int boolean NOT NULL DEFAULT false,
    save_wis boolean NOT NULL DEFAULT false,
    save_cha boolean NOT NULL DEFAULT false,
    acrobatics ability_level NOT NULL DEFAULT 'none',
    animal_handling ability_level NOT NULL DEFAULT 'none',
    arcana ability_level NOT NULL DEFAULT 'none',
    athletics ability_level NOT NULL DEFAULT 'none',
    deception ability_level NOT NULL DEFAULT 'none',
    history ability_level NOT NULL DEFAULT 'none',
    insight ability_level NOT NULL DEFAULT 'none',
    intimidation ability_level NOT NULL DEFAULT 'none',
    investigation ability_level NOT NULL DEFAULT 'none',
    medicine ability_level NOT NULL DEFAULT 'none',
    nature ability_level NOT NULL DEFAULT 'none',
    perception ability_level NOT NULL DEFAULT 'none',
    performance ability_level NOT NULL DEFAULT 'none',
    persuasion ability_level NOT NULL DEFAULT 'none',
    religion ability_level NOT NULL DEFAULT 'none',
    sleight_of_hand ability_level NOT NULL DEFAULT 'none',
    stealth ability_level NOT NULL DEFAULT 'none',
    survival ability_level NOT NULL DEFAULT 'none',
    alchemists_supplies ability_level NOT NULL DEFAULT 'none',
    brewers_supplies ability_level NOT NULL DEFAULT 'none',
    calligraphers_supplies ability_level NOT NULL DEFAULT 'none',
    carpenters_tools ability_level NOT NULL DEFAULT 'none',
    cartographer_tools ability_level NOT NULL DEFAULT 'none',
    cobblers_tools ability_level NOT NULL DEFAULT 'none',
    cooks_utensils ability_level NOT NULL DEFAULT 'none',
    disguise_kit ability_level NOT NULL DEFAULT 'none',
    forgery_kit ability_level NOT NULL DEFAULT 'none',
    gaming_set ability_level NOT NULL DEFAULT 'none',
    glassblowers_tools ability_level NOT NULL DEFAULT 'none',
    herbalism_kit ability_level NOT NULL DEFAULT 'none',
    jewelers_tools ability_level NOT NULL DEFAULT 'none',
    land_and_water_vehicles ability_level NOT NULL DEFAULT 'none',
    leatherworkers_tools ability_level NOT NULL DEFAULT 'none',
    masons_tools ability_level NOT NULL DEFAULT 'none',
    musical_instrument ability_level NOT NULL DEFAULT 'none',
    navigators_tools ability_level NOT NULL DEFAULT 'none',
    painters_supplies ability_level NOT NULL DEFAULT 'none',
    poisoners_kit ability_level NOT NULL DEFAULT 'none',
    potters_tools ability_level NOT NULL DEFAULT 'none',
    smiths_tools ability_level NOT NULL DEFAULT 'none',
    thieves_tools ability_level NOT NULL DEFAULT 'none',
    tinkers_tools ability_level NOT NULL DEFAULT 'none',
    weavers_tools ability_level NOT NULL DEFAULT 'none',
    woodcarvers_tools ability_level NOT NULL DEFAULT 'none',
    CONSTRAINT unique_creature UNIQUE (name)
        INCLUDE(name),
    CONSTRAINT fk_creature_challenge_rating FOREIGN KEY (challenge_rating_id)
        REFERENCES challenge_rating (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_creature_size FOREIGN KEY (size_id)
        REFERENCES creature_size (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_creature_family FOREIGN KEY (family_id)
        REFERENCES creature_family (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT check_creature_speed_walk CHECK (speed_walk >= 0::smallint AND speed_walk < 200::smallint) NOT VALID,
    CONSTRAINT check_creature_speed_burrow CHECK (speed_burrow >= 0::smallint AND speed_burrow < 200::smallint) NOT VALID,
    CONSTRAINT check_creature_speed_climb CHECK (speed_climb >= 0::smallint AND speed_climb < 200::smallint) NOT VALID,
    CONSTRAINT check_creature_speed_fly CHECK (speed_fly >= 0::smallint AND speed_fly < 200::smallint) NOT VALID,
    CONSTRAINT check_creature_speed_swim CHECK (speed_swim >= 0::smallint AND speed_swim < 200::smallint) NOT VALID,
    CONSTRAINT check_creature_str CHECK (str > 0::smallint AND str < 50::smallint) NOT VALID,
    CONSTRAINT check_creature_dex CHECK (dex > 0::smallint AND dex < 50::smallint) NOT VALID,
    CONSTRAINT check_creature_con CHECK (con > 0::smallint AND con < 50::smallint) NOT VALID,
    CONSTRAINT check_creature_int CHECK (int > 0::smallint AND int < 50::smallint) NOT VALID,
    CONSTRAINT check_creature_wis CHECK (wis > 0::smallint AND wis < 50::smallint) NOT VALID,
    CONSTRAINT check_creature_cha CHECK (cha > 0::smallint AND cha < 50::smallint) NOT VALID,
    CONSTRAINT check_creature_armor_class CHECK (armor_class > 0::smallint AND armor_class < 50::smallint) NOT VALID
);

CREATE TABLE IF NOT EXISTS language
(
    id uuid primary key,
    name character varying(32) NOT NULL,
    CONSTRAINT unique_language_name UNIQUE (name)
        INCLUDE(name)
);

CREATE TYPE armor_type AS ENUM ('none', 'light', 'medium', 'heavy', 'shield');

CREATE TABLE IF NOT EXISTS armor
(
    id uuid primary key,
    name character varying(64) NOT NULL,
    price bigint NOT NULL,
    weight double precision NOT NULL,
    type armor_type NOT NULL,
    ac smallint NOT NULL,
    add_dex boolean NOT NULL,
    max_dex_bonus smallint NOT NULL,
    str_req smallint NOT NULL, 
    stealth_disadvantage boolean NOT NULL,
    CONSTRAINT unique_armor_name UNIQUE (name)
        INCLUDE(name),
    CONSTRAINT check_armor_price CHECK (price >= 0::bigint),
    CONSTRAINT check_armor_weight CHECK (weight >= 0::double precision),
    CONSTRAINT check_armor_value CHECK (ac > 0::smallint),
    CONSTRAINT check_armor_max_dex_bonus CHECK (max_dex_bonus >= 0::smallint AND max_dex_bonus <= 10::smallint),
    CONSTRAINT check_armor_str_req CHECK (str_req >= 0::smallint AND str_req <= 30::smallint)
);

CREATE TABLE IF NOT EXISTS creature_armor_proficiency
(
    id uuid primary key,
    creature_id uuid NOT NULL,
    type armor_type NOT NULL,
    CONSTRAINT fk_creature_armor_proficiency_creature FOREIGN KEY (creature_id)
        REFERENCES creature_template (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS creature_armor_xref
(
    id uuid primary key,
    creature_id uuid NOT NULL,
    armor_id uuid NOT NULL,
    CONSTRAINT fk_creature_armor_xref_creature FOREIGN KEY (creature_id)
        REFERENCES creature_template (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_creature_armor_xref_armor FOREIGN KEY (armor_id)
        REFERENCES armor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TYPE damage_type AS ENUM ('acid', 'bludgeoning', 'cold', 'fire', 'force', 'lightning', 'necrotic', 'piercing', 'poison', 'psychic', 'radiant', 'slashing', 'thunder');

CREATE TYPE weapon_type AS ENUM ('none', 'simple melee', 'simple ranged', 'martial melee', 'martial ranged');

CREATE TABLE IF NOT EXISTS weapon
(
    id uuid primary key,
    name character varying(64) NOT NULL,
    price bigint NOT NULL,
    damage character varying(16) NOT NULL,
    dmg_type damage_type NOT NULL,
    weight double precision NOT NULL,
    wpn_type weapon_type NOT NULL,
    ammunition character varying(16),
    finesse boolean NOT NULL DEFAULT false,
    heavy boolean NOT NULL DEFAULT false,
    light boolean NOT NULL DEFAULT false,
    loading boolean NOT NULL DEFAULT false,
    reach boolean NOT NULL DEFAULT false,
    special boolean NOT NULL DEFAULT false,
    thrown character varying(16),
    two_handed boolean NOT NULL DEFAULT false,
    versatile character varying(16),
    CONSTRAINT unique_weapon_name UNIQUE (name)
        INCLUDE(name),
    CONSTRAINT check_weapon_price CHECK (price >= 0::bigint),
    CONSTRAINT check_weapon_weight CHECK (weight >= 0::double precision)
);

CREATE TABLE IF NOT EXISTS creature_weapon_proficiency
(
    id uuid primary key,
    creature_id uuid NOT NULL,
    weapon_id uuid NOT NULL,
    CONSTRAINT fk_creature_weapon_proficiency_creature FOREIGN KEY (creature_id)
        REFERENCES creature_template (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_creature_weapon_proficiency_weapon FOREIGN KEY (weapon_id)
        REFERENCES weapon (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS creature_weapon_xref
(
    id uuid primary key,
    creature_id uuid NOT NULL,
    weapon_id uuid NOT NULL,
    CONSTRAINT fk_creature_weapon_xref_creature FOREIGN KEY (creature_id)
        REFERENCES creature_template (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_creature_weapon_xref_weapon FOREIGN KEY (weapon_id)
        REFERENCES weapon (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS battle
(
    id uuid primary key,
    start timestamp NOT NULL,
    location character varying(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS battle_participant
(
    id uuid primary key,
    battle_id uuid NOT NULL,
    template_id uuid NOT NULL,
    initiative smallint NOT NULL,
    hit_points smallint NOT NULL,
    CONSTRAINT fk_battle_participant_battle FOREIGN KEY (battle_id)
        REFERENCES battle (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_battle_participant_template FOREIGN KEY (template_id)
        REFERENCES creature_template (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--CREATE TABLE IF NOT EXISTS Ability
--(
--    id uuid primary key,
--    name character varying(16) NOT NULL,
--    abbr character varying(8) NOT NULL,
--    CONSTRAINT unique_ability_name UNIQUE (name)
--        INCLUDE(name)
--);

--CREATE TABLE IF NOT EXISTS Alignment
--(
--    id uuid primary key,
--    abbr character varying(2) NOT NULL,
--    name character varying(32) NOT NULL,
--    description character varying(128) NOT NULL,
--    CONSTRAINT unique_abbr UNIQUE (abbr)
--        INCLUDE(abbr),
--    CONSTRAINT unique_alignment UNIQUE (name)
--        INCLUDE(name),
--    CONSTRAINT unique_description UNIQUE (description)
--        INCLUDE(description)
--);

--CREATE TABLE IF NOT EXISTS skill
--(
--    id uuid primary key,
--    ability_id uuid NOT NULL,
--    name character varying(32) NOT NULL,
--    CONSTRAINT unique_skill_name UNIQUE (name)
--        INCLUDE(name),
--    CONSTRAINT fk_skill_ability_id FOREIGN KEY (ability_id)
--        REFERENCES public.ability (id) MATCH SIMPLE
--        ON UPDATE NO ACTION
--        ON DELETE NO ACTION
--        NOT VALID
--);

-- CREATE TABLE IF NOT EXISTS creature_proficiency
-- (
--     id uuid primary key,
--     acrobatics ability_level NOT NULL DEFAULT 'none',
--     animal_handling ability_level NOT NULL DEFAULT 'none',
--     arcana ability_level NOT NULL DEFAULT 'none',
--     athletics ability_level NOT NULL DEFAULT 'none',
--     deception ability_level NOT NULL DEFAULT 'none',
--     history ability_level NOT NULL DEFAULT 'none',
--     insight ability_level NOT NULL DEFAULT 'none',
--     intimidation ability_level NOT NULL DEFAULT 'none',
--     investigation ability_level NOT NULL DEFAULT 'none',
--     medicine ability_level NOT NULL DEFAULT 'none',
--     nature ability_level NOT NULL DEFAULT 'none',
--     perception ability_level NOT NULL DEFAULT 'none',
--     performance ability_level NOT NULL DEFAULT 'none',
--     persuasion ability_level NOT NULL DEFAULT 'none',
--     religion ability_level NOT NULL DEFAULT 'none',
--     sleight_of_hand ability_level NOT NULL DEFAULT 'none',
--     stealth ability_level NOT NULL DEFAULT 'none',
--     survival ability_level NOT NULL DEFAULT 'none',
--     alchemists_supplies ability_level NOT NULL DEFAULT 'none',
--     brewers_supplies ability_level NOT NULL DEFAULT 'none',
--     calligraphers_supplies ability_level NOT NULL DEFAULT 'none',
--     carpenters_tools ability_level NOT NULL DEFAULT 'none',
--     cartographer_tools ability_level NOT NULL DEFAULT 'none',
--     cobblers_tools ability_level NOT NULL DEFAULT 'none',
--     cooks_utensils ability_level NOT NULL DEFAULT 'none',
--     disguise_kit ability_level NOT NULL DEFAULT 'none',
--     forgery_kit ability_level NOT NULL DEFAULT 'none',
--     gaming_set ability_level NOT NULL DEFAULT 'none',
--     glassblowers_tools ability_level NOT NULL DEFAULT 'none',
--     herbalism_kit ability_level NOT NULL DEFAULT 'none',
--     jewelers_tools ability_level NOT NULL DEFAULT 'none',
--     land_and_water_vehicles ability_level NOT NULL DEFAULT 'none',
--     leatherworkers_tools ability_level NOT NULL DEFAULT 'none',
--     masons_tools ability_level NOT NULL DEFAULT 'none',
--     musical_instrument ability_level NOT NULL DEFAULT 'none',
--     navigators_tools ability_level NOT NULL DEFAULT 'none',
--     painters_supplies ability_level NOT NULL DEFAULT 'none',
--     poisoners_kit ability_level NOT NULL DEFAULT 'none',
--     potters_tools ability_level NOT NULL DEFAULT 'none',
--     smiths_tools ability_level NOT NULL DEFAULT 'none',
--     thieves_tools ability_level NOT NULL DEFAULT 'none',
--     tinkers_tools ability_level NOT NULL DEFAULT 'none',
--     weavers_tools ability_level NOT NULL DEFAULT 'none',
--     woodcarvers_tools ability_level NOT NULL DEFAULT 'none',
--     CONSTRAINT fk_creature_proficiency_id FOREIGN KEY (id)
--         REFERENCES creature (id) MATCH SIMPLE
--         ON UPDATE NO ACTION
--         ON DELETE NO ACTION
-- );

--CREATE TABLE IF NOT EXISTS damage_type
--(
--    id uuid primary key,
--    name character varying(16) NOT NULL,
--    CONSTRAINT unique_damage_type_name UNIQUE (name)
--        INCLUDE(name)
--);
