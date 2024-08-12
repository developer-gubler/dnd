CREATE TABLE IF NOT EXISTS challenge_rating
(
    id uuid primary key,
    cr numeric(5,3) NOT NULL,
    experience bigint NOT NULL,
    CONSTRAINT unique_cr_experience UNIQUE (experience),
    CONSTRAINT unique_cr_value UNIQUE (cr),
    CHECK (cr > 0),
    CHECK (experience > 0)
);

CREATE TABLE IF NOT EXISTS creature_size
(
    id uuid primary key,
    name VARCHAR(16) NOT NULL,
    space numeric(3,1) NOT NULL,
    CONSTRAINT unique_size_name UNIQUE (name),
    CHECK (space > 0 AND space <= 20)
);

CREATE TABLE IF NOT EXISTS creature_classification
(
    id uuid primary key,
    name VARCHAR(64) NOT NULL,
    CONSTRAINT unique_type_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS creature_family
(
    id uuid primary key,
    classification_id uuid NOT NULL REFERENCES creature_classification(id),
    name VARCHAR(32) NOT NULL,
    CONSTRAINT unique_family_classification UNIQUE (classification_id, name)
);

CREATE TYPE alignment_type AS ENUM ('U', 'LG', 'NG', 'CG', 'LN', 'N', 'CN', 'LE', 'NE', 'CE');

CREATE TYPE ability_level AS ENUM ('none', 'proficient', 'expertise');

CREATE TABLE IF NOT EXISTS creature_template
(
    id uuid primary key,
    name VARCHAR(32) NOT NULL,
    family_id uuid NOT NULL REFERENCES creature_family(id),
    creature_size_id uuid NOT NULL REFERENCES creature_size(id),
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
    hit_dice VARCHAR(16) NOT NULL,
    armor_class smallint NOT NULL,
    proficiency_bonus smallint NOT NULL,
    challenge_rating_id uuid NOT NULL REFERENCES challenge_rating(id),
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
    CONSTRAINT unique_creature UNIQUE (name),
    CHECK (speed_walk >= 0 AND speed_walk < 200),
    CHECK (speed_burrow >= 0 AND speed_burrow < 200),
    CHECK (speed_climb >= 0 AND speed_climb < 200),
    CHECK (speed_fly >= 0 AND speed_fly < 200),
    CHECK (speed_swim >= 0 AND speed_swim < 200),
    CHECK (str > 0 AND str < 50),
    CHECK (dex > 0 AND dex < 50),
    CHECK (con > 0 AND con < 50),
    CHECK (int > 0 AND int < 50),
    CHECK (wis > 0 AND wis < 50),
    CHECK (cha > 0 AND cha < 50),
    CHECK (armor_class > 0 AND armor_class < 50)
);

CREATE TABLE IF NOT EXISTS language
(
    id uuid primary key,
    name VARCHAR(32) NOT NULL,
    CONSTRAINT unique_language_name UNIQUE (name)
);

CREATE TYPE armor_type AS ENUM ('none', 'light', 'medium', 'heavy', 'shield');

CREATE TABLE IF NOT EXISTS armor
(
    id uuid primary key,
    name VARCHAR(64) NOT NULL,
    price bigint NOT NULL,
    weight numeric NOT NULL,
    type armor_type NOT NULL,
    ac bigint NOT NULL,
    add_dex boolean NOT NULL,
    max_dex_bonus bigint NOT NULL,
    str_req bigint NOT NULL, 
    stealth_disadvantage boolean NOT NULL,
    CONSTRAINT unique_armor_name UNIQUE (name),
    CHECK (price >= 0::bigint),
    CHECK (weight >= 0::numeric),
    CHECK (ac > 0::bigint),
    CHECK (max_dex_bonus >= 0::bigint),
    CHECK (str_req >= 0::bigint)
);

CREATE TABLE IF NOT EXISTS creature_armor_proficiency
(
    id uuid primary key,
    creature_id uuid NOT NULL REFERENCES creature_template(id),
    type armor_type NOT NULL
);

CREATE TABLE IF NOT EXISTS creature_armor_xref
(
    id uuid primary key,
    creature_id uuid NOT NULL REFERENCES creature_template(id),
    armor_id uuid NOT NULL REFERENCES armor(id)
);

CREATE TYPE damage_type AS ENUM ('acid', 'bludgeoning', 'cold', 'fire', 'force', 'lightning', 'necrotic', 'piercing', 'poison', 'psychic', 'radiant', 'slashing', 'thunder');

CREATE TYPE weapon_type AS ENUM ('none', 'simple melee', 'simple ranged', 'martial melee', 'martial ranged');

CREATE TABLE IF NOT EXISTS weapon
(
    id uuid primary key,
    name VARCHAR(64) NOT NULL,
    price bigint NOT NULL,
    damage VARCHAR(16) NOT NULL,
    dmg_type damage_type NOT NULL,
    weight numeric NOT NULL,
    wpn_type weapon_type NOT NULL,
    ammunition VARCHAR(16),
    finesse boolean NOT NULL DEFAULT false,
    heavy boolean NOT NULL DEFAULT false,
    light boolean NOT NULL DEFAULT false,
    loading boolean NOT NULL DEFAULT false,
    reach boolean NOT NULL DEFAULT false,
    special boolean NOT NULL DEFAULT false,
    thrown VARCHAR(16),
    two_handed boolean NOT NULL DEFAULT false,
    versatile VARCHAR(16),
    CONSTRAINT unique_weapon_name UNIQUE (name),
    CHECK (price >= 0),
    CHECK (weight >= 0)
);

CREATE TABLE IF NOT EXISTS creature_weapon_proficiency
(
    id uuid primary key,
    creature_id uuid NOT NULL REFERENCES creature_template(id),
    weapon_id uuid NOT NULL REFERENCES weapon(id)
);

CREATE TABLE IF NOT EXISTS creature_weapon_xref
(
    id uuid primary key,
    creature_id uuid NOT NULL REFERENCES creature_template(id),
    weapon_id uuid NOT NULL REFERENCES weapon(id)
);

--CREATE TABLE IF NOT EXISTS Alignment
--(
--    id uuid primary key,
--    abbr VARCHAR(2) NOT NULL,
--    name VARCHAR(32) NOT NULL,
--    description VARCHAR(128) NOT NULL,
--    CONSTRAINT unique_abbr UNIQUE (abbr),
--    CONSTRAINT unique_alignment UNIQUE (name),
--    CONSTRAINT unique_description UNIQUE (description)
--);

--CREATE TABLE IF NOT EXISTS Ability
--(
--    id uuid primary key,
--    name VARCHAR(16) NOT NULL,
--    abbr VARCHAR(8) NOT NULL,
--    constraint unique_ability_name UNIQUE (name)
--);

--CREATE TABLE IF NOT EXISTS skill
--(
--    id uuid primary key,
--    ability_id uuid NOT NULL REFERENCES ability(id),
--    name VARCHAR(32) NOT NULL,
--    CONSTRAINT unique_skill_name UNIQUE (name)
--);

-- CREATE TABLE IF NOT EXISTS creature_proficiency
-- (
--     id bigint primary key,
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
--    name VARCHAR(16) NOT NULL,
--    CONSTRAINT unique_damage_type_name UNIQUE (name)
--);


