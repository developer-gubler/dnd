INSERT INTO challenge_rating
VALUES (random_uuid(), 0.125, 25);

INSERT INTO challenge_rating
VALUES (random_uuid(), 0.25, 50);

INSERT INTO challenge_rating
VALUES ('f8d4ed21-b84c-4c7a-9e8d-be77e3b7453b', 0.5, 100);

INSERT INTO challenge_rating
VALUES ('40e26256-dac8-4834-a055-62d9457dc908', 1, 200);

INSERT INTO challenge_rating
VALUES ('124080f8-c2fd-4896-b2af-4d112f67649a', 2, 450);

INSERT INTO challenge_rating
VALUES ('8d6e8a20-ee7c-4f4e-8992-6977bebfe71e', 3, 700);

INSERT INTO challenge_rating
VALUES ('d0605c7b-30f2-485d-a9dd-1d5c4aafd33c', 4, 1100);

INSERT INTO challenge_rating
VALUES ('69c3406a-930e-45cb-99fe-f439909c07ab', 5, 1800);

INSERT INTO challenge_rating
VALUES (random_uuid(), 6, 2300);

INSERT INTO challenge_rating
VALUES (random_uuid(), 7, 2900);

INSERT INTO challenge_rating
VALUES (random_uuid(), 8, 3900);

INSERT INTO challenge_rating
VALUES (random_uuid(), 9, 5000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 10, 5900);

INSERT INTO challenge_rating
VALUES (random_uuid(), 11, 7200);

INSERT INTO challenge_rating
VALUES (random_uuid(), 12, 8400);

INSERT INTO challenge_rating
VALUES (random_uuid(), 13, 10000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 14, 11500);

INSERT INTO challenge_rating
VALUES (random_uuid(), 15, 13000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 16, 15000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 17, 18000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 18, 20000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 19, 22000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 20, 25000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 21, 33000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 22, 44000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 23, 50000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 24, 62000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 25, 75000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 26, 90000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 27, 105000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 28, 120000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 29, 135000);

INSERT INTO challenge_rating
VALUES (random_uuid(), 30, 155000);

INSERT INTO creature_size
VALUES (random_uuid(), 'tiny', 2.5);

INSERT INTO creature_size
VALUES (random_uuid(), 'small', 5);

INSERT INTO creature_size
VALUES ('4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'medium', 5);

INSERT INTO creature_size
VALUES ('7ce51487-ad83-49cb-8953-8378fb6d388f', 'large', 10);

INSERT INTO creature_size
VALUES (random_uuid(), 'huge', 15);

INSERT INTO creature_size
VALUES (random_uuid(), 'gargantuan', 20);

INSERT INTO creature_classification
VALUES ('c05573a1-72db-4171-9044-521736414390', 'Aberration');

INSERT INTO creature_classification
VALUES ('145af406-35cc-4e27-8c60-e9bb8aecd468', 'Beast');

INSERT INTO creature_classification
VALUES ('d9c177d9-1bc2-4492-8c87-eda9ef48ea87', 'Celestial');

INSERT INTO creature_classification
VALUES ('137cdaf6-0d45-4686-a586-440ca065d4b4', 'Construct');

INSERT INTO creature_classification
VALUES ('981f7e8b-b586-4732-b254-0098817bb5bf', 'Dragon');

INSERT INTO creature_classification
VALUES ('c572d7d1-bda0-4178-9120-4147a9ab7b8c', 'Elemental');

INSERT INTO creature_classification
VALUES ('09ef0ae2-a70b-4d0e-af4c-94e6fba054a8', 'Fey');

INSERT INTO creature_classification
VALUES ('5d815e1b-bde7-4e4b-8a94-2990421129cd', 'Fiend');

INSERT INTO creature_classification
VALUES ('dc575e25-a4aa-4ad8-9dca-0c79aa5e0e67', 'Giant');

INSERT INTO creature_classification
VALUES ('20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Humanoid');

INSERT INTO creature_classification
VALUES ('e873157e-6afe-4453-a6bc-407a49912c45', 'Monstrosity');

INSERT INTO creature_classification
VALUES ('fd3b6470-5c73-45fb-838b-78c73889d69b', 'Ooze');

INSERT INTO creature_classification
VALUES ('25b9895e-c26d-4d38-ba79-ae8271d66ba3', 'Plant');

INSERT INTO creature_classification
VALUES ('145a7840-de30-4f95-bb81-ef82d284ba01', 'Undead');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), 'c05573a1-72db-4171-9044-521736414390', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '145af406-35cc-4e27-8c60-e9bb8aecd468', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), 'd9c177d9-1bc2-4492-8c87-eda9ef48ea87', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '137cdaf6-0d45-4686-a586-440ca065d4b4', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '981f7e8b-b586-4732-b254-0098817bb5bf', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), 'c572d7d1-bda0-4178-9120-4147a9ab7b8c', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '09ef0ae2-a70b-4d0e-af4c-94e6fba054a8', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '5d815e1b-bde7-4e4b-8a94-2990421129cd', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES ('60e77f04-3ab2-4494-9469-73c26d2aaad4', 'dc575e25-a4aa-4ad8-9dca-0c79aa5e0e67', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), 'e873157e-6afe-4453-a6bc-407a49912c45', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), 'fd3b6470-5c73-45fb-838b-78c73889d69b', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '25b9895e-c26d-4d38-ba79-ae8271d66ba3', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '145a7840-de30-4f95-bb81-ef82d284ba01', '-');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), 'd9c177d9-1bc2-4492-8c87-eda9ef48ea87', 'Angel');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), 'd9c177d9-1bc2-4492-8c87-eda9ef48ea87', 'Titan');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '5d815e1b-bde7-4e4b-8a94-2990421129cd', 'Demon');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '5d815e1b-bde7-4e4b-8a94-2990421129cd', 'Devil');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '5d815e1b-bde7-4e4b-8a94-2990421129cd', 'Yugoloth');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Aasimar');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Bugbear');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Dragonborn');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Dwarf');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Elf');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Firbolg');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Gnome');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Goblin');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Goliath');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Half-Elf');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Half-Orc');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Halfling');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Hobgoblin');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Human');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Kenku');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Kobold');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Lizardfolk');

INSERT INTO creature_family (id, classification_id, name)
VALUES ('7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Orc');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Tabaxi');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Tiefling');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Triton');

INSERT INTO creature_family (id, classification_id, name)
VALUES (random_uuid(), '20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12', 'Yuan-ti');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('05808cc6-637e-4d49-a396-a6e2af138664', 'Orc', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 16, 12, 16, 9, 13, 12, 15, '2d8 + 6', 13, 2, 'f8d4ed21-b84c-4c7a-9e8d-be77e3b7453b', false, false, false, false, false, false, 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('5c1b2d75-876e-46d8-acd8-28e215a3635e', 'Orc War Chief', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 18, 12, 18, 11, 11, 16, 93, '11d8 + 44', 16, 2, 'd0605c7b-30f2-485d-a9dd-1d5c4aafd33c', true, false, true, false, true, false, 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('a6f4b077-c93c-49c8-9e48-fdbc53e45880', 'Orc Commander', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 16, 13, 16, 8, 10, 16, 52, '7d8 + 21', 19, 2, 'd0605c7b-30f2-485d-a9dd-1d5c4aafd33c', false, false, false, false, false, false, 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('f1694098-2622-480a-9b91-1cd54a06faa6', 'Orc Blade of Ilneval', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 17, 11, 17, 10, 12, 14, 60, '8d8 + 24', 18, 2, 'd0605c7b-30f2-485d-a9dd-1d5c4aafd33c', false, false, false, false, true, false, 'none', 'none', 'none', 'none', 'none', 'none', 'proficient', 'proficient', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('874ef372-d3c8-4c43-8afb-a846c4d14ec3', 'Orc Claw of Luthic', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 14, 15, 16, 10, 15, 11, 45, '6d8 + 18', 14, 2, '124080f8-c2fd-4896-b2af-4d112f67649a', false, false, false, false, false, false, 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'proficient', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('9aa9150d-3b96-4f2f-aabf-a5b84078669e', 'Orc Archer', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 14, 16, 14, 7, 11, 10, 19, '3d8 + 6', 14, 2, 'f8d4ed21-b84c-4c7a-9e8d-be77e3b7453b', false, false, false, false, false, false, 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('96da032e-c800-46b3-8928-c78e6fb3970f', 'Orc Scout', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 16, 14, 14, 11, 13, 11, 58, '9d8 + 18', 13, 2, '8d6e8a20-ee7c-4f4e-8992-6977bebfe71e', false, false, false, false, false, false, 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'proficient', 'none', 'none', 'proficient', 'proficient', 'none', 'none', 'none', 'none', 'proficient', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('4761eb21-92f5-4cf9-a9de-c8fd08aa090e', 'Orc War Drummer', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 16, 12, 16, 7, 11, 16, 45, '6d8 + 18', 13, 2, '124080f8-c2fd-4896-b2af-4d112f67649a', false, false, false, false, false, false, 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('72e2a27e-c35f-48dc-aec9-e96a42b3076f', 'Orc Eye of Gruumsh', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 16, 12, 16, 9, 13, 12, 45, '6d8 + 18', 16, 2, '124080f8-c2fd-4896-b2af-4d112f67649a', false, false, false, false, false, false, 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('c27a8a7d-9a50-4889-85fd-12a6e51eea34', 'Orog', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 18, 12, 18, 12, 11, 12, 42, '5d8 + 20', 18, 2, '124080f8-c2fd-4896-b2af-4d112f67649a', false, false, false, false, false, false, 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('9aa2a9f8-27a7-4797-87c8-2887f8b79d60', 'Orc Berserker', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 45, 0, 0, 0, 0, 17, 15, 17, 7, 8, 16, 67, '9d8 + 27', 15, 4, '69c3406a-930e-45cb-99fe-f439909c07ab', false, false, false, false, false, false, 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('11e4c7c7-934a-43d5-b2f0-da441b6ad0e3', 'Orc Captain', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 16, 13, 16, 8, 9, 14, 45, '6d8 + 18', 19, 2, '8d6e8a20-ee7c-4f4e-8992-6977bebfe71e', false, false, false, false, false, false, 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('6b32a7a3-ab4b-463f-8a0a-fb1b817bc986', 'Orc Battleborn', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 16, 13, 16, 7, 8, 13, 37, '5d8 + 15', 16, 2, '40e26256-dac8-4834-a055-62d9457dc908', false, false, false, false, false, false, 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('fe5f8421-591e-4431-8cda-1abb29932cb8', 'Orc Hand of Yurtrus', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 12, 11, 16, 11, 14, 9, 30, '4d8 + 12', 12, 2, '124080f8-c2fd-4896-b2af-4d112f67649a', false, false, false, false, false, false, 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'proficient', 'none', 'proficient', 'none', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('c779bbde-f639-4e3d-830f-cfc166d1b7c5', 'Orc Nurtured One of Yurtrus', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 15, 8, 16, 7, 11, 7, 30, '4d8 + 12', 9, 2, 'f8d4ed21-b84c-4c7a-9e8d-be77e3b7453b', false, false, false, false, false, false, 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('620d2627-b34f-4146-8075-1d86ba93aa7f', 'War Orc', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 18, 12, 18, 12, 11, 12, 42, '5d8 + 20', 18, 2, '124080f8-c2fd-4896-b2af-4d112f67649a', false, false, false, false, false, false, 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'proficient', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('5091265c-1645-47f2-8f1f-381b899085ad', 'Ogre', '60e77f04-3ab2-4494-9469-73c26d2aaad4', '7ce51487-ad83-49cb-8953-8378fb6d388f', 'CE', 40, 0, 0, 0, 0, 19, 8, 16, 5, 7, 7, 59, '7d10 + 21', 11, 2, '124080f8-c2fd-4896-b2af-4d112f67649a', false, false, false, false, false, false, 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO creature_template (id, name, family_id, creature_size_id, alignment, speed_walk, speed_burrow, speed_climb, speed_fly, speed_swim, str, dex, con, int, wis, cha, hit_points, hit_dice, armor_class, proficiency_bonus, challenge_rating_id, save_str, save_dex, save_con, save_int, save_wis, save_cha, acrobatics, animal_handling, arcana, athletics, deception, history, insight, intimidation, investigation, medicine, nature, perception, performance, persuasion, religion, sleight_of_hand, stealth, survival, alchemists_supplies, brewers_supplies, calligraphers_supplies, carpenters_tools, cartographer_tools, cobblers_tools, cooks_utensils, disguise_kit, forgery_kit, gaming_set, glassblowers_tools, herbalism_kit, jewelers_tools, land_and_water_vehicles, leatherworkers_tools, masons_tools, musical_instrument, navigators_tools, painters_supplies, poisoners_kit, potters_tools, smiths_tools, thieves_tools, tinkers_tools, weavers_tools, woodcarvers_tools)
VALUES ('28e75eed-ce58-4ec8-8faa-58c62dd29c1b', 'Orc Shaman', '7f74e64f-f097-41d1-8f4a-d1e2db6bf46f', '4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f', 'CE', 30, 0, 0, 0, 0, 13, 15, 13, 15, 16, 11, 55, '10d8 + 10', 14, 2, 'd0605c7b-30f2-485d-a9dd-1d5c4aafd33c', false, false, false, false, false, false, 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'proficient', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');

INSERT INTO language
VALUES (random_uuid(), 'common');

INSERT INTO language
VALUES (random_uuid(), 'dwarvish');

INSERT INTO language
VALUES (random_uuid(), 'elvish');

INSERT INTO language
VALUES (random_uuid(), 'giant');

INSERT INTO language
VALUES (random_uuid(), 'gnomish');

INSERT INTO language
VALUES (random_uuid(), 'goblin');

INSERT INTO language
VALUES (random_uuid(), 'halfling');

INSERT INTO language
VALUES (random_uuid(), 'orc');

INSERT INTO language
VALUES (random_uuid(), 'abyssal');

INSERT INTO language
VALUES (random_uuid(), 'celestial');

INSERT INTO language
VALUES (random_uuid(), 'deep speech');

INSERT INTO language
VALUES (random_uuid(), 'draconic');

INSERT INTO language
VALUES (random_uuid(), 'infernal');

INSERT INTO language
VALUES (random_uuid(), 'primordial');

INSERT INTO language
VALUES (random_uuid(), 'sylvan');

INSERT INTO language
VALUES (random_uuid(), 'undercommon');

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES ('cdc1871f-0e4c-4f0d-b853-b2576edf61f3', 'Natural', 0.0, 0.0, 'none', 10, TRUE, 10, 0, FALSE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES ('fe03c298-9f21-49f8-b743-2980f5fbe2f5', 'Padded', 500, 8.0, 'light', 11, TRUE, 10, 0, TRUE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES ('099dc58b-433c-4ea8-a738-e4555d1ab2df', 'Leather', 1000, 10.0, 'light', 11, TRUE, 10, 0, FALSE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES ('b1e073aa-8b1f-4be0-b86e-48a303d6e5a7', 'Studded Leather', 4500, 13.0, 'light', 12, TRUE, 10, 0, FALSE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES ('91d3f674-3237-4d21-89ad-5d1686770565', 'Hide', 1000, 12.0, 'medium', 12, TRUE, 2, 0, FALSE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES (random_uuid(), 'Chain Shirt', 5000, 20.0, 'medium', 13, TRUE, 2, 0, FALSE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES (random_uuid(), 'Scale Mail', 5000, 45.0, 'medium', 14, TRUE, 2, 0, TRUE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES (random_uuid(), 'Breastplate', 40000, 20.0, 'medium', 14, TRUE, 2, 0, FALSE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES ('16414eb2-6a83-451a-96aa-ccfdf814b652', 'Half Plate', 75000, 40.0, 'medium', 15, TRUE, 2, 0, TRUE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES ('4124cbb7-2357-441f-afd7-153da50b7f6d', 'Ring Mail', 3000, 40.0, 'heavy', 14, FALSE, 0, 0, TRUE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES ('79b5c32a-3a0b-46f5-82e5-39bd43356a57', 'Chain Mail', 7500, 55.0, 'heavy', 16, FALSE, 0, 13, TRUE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES (random_uuid(), 'Splint', 20000, 60.0, 'heavy', 17, FALSE, 0, 15, TRUE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES ('90288164-c213-4680-98f8-0273072a71cf', 'Plate', 150000, 65.0, 'heavy', 18, FALSE, 0, 15, TRUE); 

INSERT INTO armor (id, name, price, weight, type, ac, add_dex, max_dex_bonus, str_req, stealth_disadvantage)
VALUES ('184bafca-aaff-4ef4-ac76-77cec956e31d', 'Shield', 1000, 6.0, 'shield', 2, FALSE, 0, 0, FALSE); 

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '05808cc6-637e-4d49-a396-a6e2af138664', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '5c1b2d75-876e-46d8-acd8-28e215a3635e', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '5c1b2d75-876e-46d8-acd8-28e215a3635e', 'medium');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '5c1b2d75-876e-46d8-acd8-28e215a3635e', 'heavy');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'a6f4b077-c93c-49c8-9e48-fdbc53e45880', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'a6f4b077-c93c-49c8-9e48-fdbc53e45880', 'medium');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'a6f4b077-c93c-49c8-9e48-fdbc53e45880', 'heavy');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', 'medium');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', 'heavy');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', 'shield');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '874ef372-d3c8-4c43-8afb-a846c4d14ec3', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '9aa9150d-3b96-4f2f-aabf-a5b84078669e', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '96da032e-c800-46b3-8928-c78e6fb3970f', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '4761eb21-92f5-4cf9-a9de-c8fd08aa090e', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '72e2a27e-c35f-48dc-aec9-e96a42b3076f', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '72e2a27e-c35f-48dc-aec9-e96a42b3076f', 'medium');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '72e2a27e-c35f-48dc-aec9-e96a42b3076f', 'heavy');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '72e2a27e-c35f-48dc-aec9-e96a42b3076f', 'shield');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'c27a8a7d-9a50-4889-85fd-12a6e51eea34', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'c27a8a7d-9a50-4889-85fd-12a6e51eea34', 'medium');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'c27a8a7d-9a50-4889-85fd-12a6e51eea34', 'heavy');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '9aa2a9f8-27a7-4797-87c8-2887f8b79d60', 'none');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '11e4c7c7-934a-43d5-b2f0-da441b6ad0e3', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '11e4c7c7-934a-43d5-b2f0-da441b6ad0e3', 'medium');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '11e4c7c7-934a-43d5-b2f0-da441b6ad0e3', 'heavy');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '6b32a7a3-ab4b-463f-8a0a-fb1b817bc986', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'fe5f8421-591e-4431-8cda-1abb29932cb8', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), 'c779bbde-f639-4e3d-830f-cfc166d1b7c5', 'none');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '620d2627-b34f-4146-8075-1d86ba93aa7f', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '620d2627-b34f-4146-8075-1d86ba93aa7f', 'medium');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '620d2627-b34f-4146-8075-1d86ba93aa7f', 'heavy');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '5091265c-1645-47f2-8f1f-381b899085ad', 'light');

INSERT INTO creature_armor_proficiency
VALUES (random_uuid(), '28e75eed-ce58-4ec8-8faa-58c62dd29c1b', 'light');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '05808cc6-637e-4d49-a396-a6e2af138664', '91d3f674-3237-4d21-89ad-5d1686770565');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '5c1b2d75-876e-46d8-acd8-28e215a3635e', '79b5c32a-3a0b-46f5-82e5-39bd43356a57');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), 'a6f4b077-c93c-49c8-9e48-fdbc53e45880', '16414eb2-6a83-451a-96aa-ccfdf814b652');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', '79b5c32a-3a0b-46f5-82e5-39bd43356a57');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', '184bafca-aaff-4ef4-ac76-77cec956e31d');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '874ef372-d3c8-4c43-8afb-a846c4d14ec3', '91d3f674-3237-4d21-89ad-5d1686770565');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '9aa9150d-3b96-4f2f-aabf-a5b84078669e', '099dc58b-433c-4ea8-a738-e4555d1ab2df');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '96da032e-c800-46b3-8928-c78e6fb3970f', '099dc58b-433c-4ea8-a738-e4555d1ab2df');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '4761eb21-92f5-4cf9-a9de-c8fd08aa090e', '91d3f674-3237-4d21-89ad-5d1686770565');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '72e2a27e-c35f-48dc-aec9-e96a42b3076f', '4124cbb7-2357-441f-afd7-153da50b7f6d');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '72e2a27e-c35f-48dc-aec9-e96a42b3076f', '184bafca-aaff-4ef4-ac76-77cec956e31d');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), 'c27a8a7d-9a50-4889-85fd-12a6e51eea34', '90288164-c213-4680-98f8-0273072a71cf');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '9aa2a9f8-27a7-4797-87c8-2887f8b79d60', 'cdc1871f-0e4c-4f0d-b853-b2576edf61f3');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '11e4c7c7-934a-43d5-b2f0-da441b6ad0e3', '16414eb2-6a83-451a-96aa-ccfdf814b652');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '6b32a7a3-ab4b-463f-8a0a-fb1b817bc986', 'b1e073aa-8b1f-4be0-b86e-48a303d6e5a7');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), 'fe5f8421-591e-4431-8cda-1abb29932cb8', '91d3f674-3237-4d21-89ad-5d1686770565');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), 'c779bbde-f639-4e3d-830f-cfc166d1b7c5', 'cdc1871f-0e4c-4f0d-b853-b2576edf61f3');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '620d2627-b34f-4146-8075-1d86ba93aa7f', '90288164-c213-4680-98f8-0273072a71cf');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '5091265c-1645-47f2-8f1f-381b899085ad', '91d3f674-3237-4d21-89ad-5d1686770565');

INSERT INTO creature_armor_xref
VALUES (random_uuid(), '28e75eed-ce58-4ec8-8faa-58c62dd29c1b', '91d3f674-3237-4d21-89ad-5d1686770565');

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('59257171-75d5-45e6-b8b5-7b235b08e9a5', 'Fist / Foot', 0, '1', 'bludgeoning', 0.0, 'none', NULL, false, false, true, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Club', 10, '1d4', 'bludgeoning', 2.0, 'simple melee', NULL, false, false, true, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('5bf55c7f-303e-415a-8504-afaf60945b69', 'Dagger', 200, '1d4', 'piercing', 1.0, 'simple melee', NULL, true, false, true, false, false, false, '20/60', false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('87e31638-de32-481a-9148-b89c6339a5ec', 'Greatclub', 20, '1d8', 'bludgeoning', 10.0, 'simple melee', NULL, false, false, false, false, false, false, NULL, true, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Handaxe', 500, '1d6', 'slashing', 2.0, 'simple melee', NULL, false, false, true, false, false, false, '20/60', false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('1b6519bd-8e2e-4f20-89d4-530df128d7c2', 'Javelin', 50, '1d6', 'piercing', 2.0, 'simple melee', NULL, false, false, false, false, false, false, '30/120', false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Light Hammer', 200, '1d4', 'bludgeoning', 2.0, 'simple melee', NULL, false, false, true, false, false, false, '20/60', false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Mace', 500, '1d6', 'bludgeoning', 4.0, 'simple melee', NULL, false, false, false, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('49ca61dc-c0c9-4ed8-b904-443db66ea9d6', 'Quarterstaff', 20, '1d6', 'bludgeoning', 4.0, 'simple melee', NULL, false, false, false, false, false, false, NULL, false, '1d8');

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Sickle', 100, '1d4', 'slashing', 2.0, 'simple melee', NULL, false, false, true, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('f12e3bc5-2052-479d-ad45-635e8312ac4a', 'Spear', 100, '1d6', 'piercing', 3.0, 'simple melee', NULL, false, false, false, false, false, false, '20/60', false, '1d8');

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Light Crossbow', 2500, '1d8', 'piercing', 5.0, 'simple ranged', '80/320', false, false, false, true, false, false, NULL, true, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Dart', 5, '1d4', 'piercing', 0.25, 'simple ranged', NULL, true, false, false, false, false, false, '20/60', false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('18bf4338-da22-4542-90e7-291f645bc30d', 'Shortbow', 2500, '1d6', 'piercing', 2.0, 'simple ranged', '80/320', false, false, false, false, false, false, NULL, true, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Sling', 10, '1d4', 'bludgeoning', 0.0, 'simple ranged', '30/120', false, false, false, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('d3b13c04-130a-4114-89b0-ca4ea6b5f276', 'Battleaxe', 1000, '1d8', 'slashing', 4.0, 'martial melee', NULL, false, false, false, false, false, false, NULL, false, '1d10');

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Flail', 1000, '1d8', 'bludgeoning', 2.0, 'martial melee', NULL, false, false, false, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Glaive', 2000, '1d10', 'slashing', 6.0, 'martial melee', NULL, false, true, false, false, true, false, NULL, true, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('fe03a173-3a9e-408e-b8cd-1aeee4c7cb37', 'Greataxe', 3000, '1d12', 'slashing', 7.0, 'martial melee', NULL, false, true, false, false, false, false, NULL, true, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Greatsword', 5000, '2d6', 'slashing', 6.0, 'martial melee', NULL, false, true, false, false, false, false, NULL, true, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Halberd', 2000, '1d10', 'slashing', 6.0, 'martial melee', NULL, false, true, false, false, true, false, NULL, true, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Lance', 1000, '1d12', 'piercing', 6.0, 'martial melee', NULL, false, false, false, false, true, true, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('4cb8c02b-7379-4e60-ab7e-8bcec399193e', 'Longsword', 1500, '1d8', 'slashing', 3.0, 'martial melee', NULL, false, false, false, false, false, false, NULL, false, '1d10');

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Maul', 1000, '2d6', 'bludgeoning', 10.0, 'martial melee', NULL, false, true, false, false, false, false, NULL, true, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Morningstar', 1500, '1d8', 'piercing', 4.0, 'martial melee', NULL, false, false, false, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Pike', 500, '1d10', 'piercing', 18.0, 'martial melee', NULL, false, true, false, false, true, false, NULL, true, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Rapier', 2500, '1d8', 'piercing', 2.0, 'martial melee', NULL, true, false, false, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Scimitar', 2500, '1d6', 'slashing', 3.0, 'martial melee', NULL, true, false, true, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('5550af19-7dac-4c38-afa3-e0fc7dabdfcd', 'Shortsword', 1000, '1d6', 'piercing', 2.0, 'martial melee', NULL, true, false, true, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Trident', 500, '1d6', 'piercing', 4.0, 'martial melee', NULL, false, false, false, false, false, false, '20/60', false, '1d8');

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'War Pick', 500, '1d8', 'piercing', 2.0, 'martial melee', NULL, false, false, false, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Warhammer', 1500, '1d8', 'bludgeoning', 2.0, 'martial melee', NULL, false, false, false, false, false, false, NULL, false, '1d10');

INSERT INTO weapo (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Whip', 200, '1d4', 'slashing', 3.0, 'martial melee', NULL, true, false, false, false, true, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Blowgun', 1000, '1', 'piercing', 1.0, 'martial ranged', '25/100', false, false, false, true, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Hand Crossbow', 7500, '1d6', 'piercing', 3.0, 'martial ranged', '30/120', false, false, true, true, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Heavy Crossbow', 5000, '1d10', 'piercing', 18.0, 'martial ranged', '100/400', false, true, false, true, false, false, NULL, true, NULL);

INSERT INTO weapon
VALUES ('a0fb466b-4070-4049-a3d0-96352167d5d5', 'Longbow', 5000, '1d8', 'piercing', 2.0, 'martial ranged', '150/600', false, true, false, false, false, false, NULL, true, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES (random_uuid(), 'Net', 100, '0', 'bludgeoning', 3.0, 'martial ranged', NULL, false, false, false, false, false, true, '5/15', false, NULL);

INSERT INTO weapo (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('d628241a-712d-4e6d-8f06-97198ea063e0', 'Touch of the White Hand', 0, '2d8', 'necrotic', 0.0, 'none', NULL, false, false, true, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('430174af-c5e5-47ba-a341-9e48aad6f453', 'Claws 1d4', 0, '1d4', 'slashing', 0.0, 'none', NULL, false, false, true, false, false, false, NULL, false, NULL);

INSERT INTO weapon (id, name, price, damage, dmg_type, weight, wpn_type, ammunition, finesse, heavy, light, loading, reach, special, thrown, two_handed, versatile)
VALUES ('200c5242-4a86-40f7-971f-9dd070e6f08b', 'Claws 1d8', 0, '1d8', 'slashing', 0.0, 'none', NULL, false, false, true, false, false, false, NULL, false, NULL);

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '05808cc6-637e-4d49-a396-a6e2af138664', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '05808cc6-637e-4d49-a396-a6e2af138664', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '05808cc6-637e-4d49-a396-a6e2af138664', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '5c1b2d75-876e-46d8-acd8-28e215a3635e', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '5c1b2d75-876e-46d8-acd8-28e215a3635e', 'f12e3bc5-2052-479d-ad45-635e8312ac4a');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '5c1b2d75-876e-46d8-acd8-28e215a3635e', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), 'a6f4b077-c93c-49c8-9e48-fdbc53e45880', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), 'a6f4b077-c93c-49c8-9e48-fdbc53e45880', 'd3b13c04-130a-4114-89b0-ca4ea6b5f276');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', '4cb8c02b-7379-4e60-ab7e-8bcec399193e');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '874ef372-d3c8-4c43-8afb-a846c4d14ec3', '200c5242-4a86-40f7-971f-9dd070e6f08b');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '9aa9150d-3b96-4f2f-aabf-a5b84078669e', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '9aa9150d-3b96-4f2f-aabf-a5b84078669e', '5bf55c7f-303e-415a-8504-afaf60945b69');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '9aa9150d-3b96-4f2f-aabf-a5b84078669e', '18bf4338-da22-4542-90e7-291f645bc30d');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '96da032e-c800-46b3-8928-c78e6fb3970f', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '96da032e-c800-46b3-8928-c78e6fb3970f', '5550af19-7dac-4c38-afa3-e0fc7dabdfcd');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '96da032e-c800-46b3-8928-c78e6fb3970f', 'a0fb466b-4070-4049-a3d0-96352167d5d5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '4761eb21-92f5-4cf9-a9de-c8fd08aa090e', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '4761eb21-92f5-4cf9-a9de-c8fd08aa090e', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '4761eb21-92f5-4cf9-a9de-c8fd08aa090e', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '72e2a27e-c35f-48dc-aec9-e96a42b3076f', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '72e2a27e-c35f-48dc-aec9-e96a42b3076f', 'f12e3bc5-2052-479d-ad45-635e8312ac4a');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), 'c27a8a7d-9a50-4889-85fd-12a6e51eea34', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), 'c27a8a7d-9a50-4889-85fd-12a6e51eea34', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), 'c27a8a7d-9a50-4889-85fd-12a6e51eea34', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '9aa2a9f8-27a7-4797-87c8-2887f8b79d60', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '9aa2a9f8-27a7-4797-87c8-2887f8b79d60', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '11e4c7c7-934a-43d5-b2f0-da441b6ad0e3', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '11e4c7c7-934a-43d5-b2f0-da441b6ad0e3', '4cb8c02b-7379-4e60-ab7e-8bcec399193e'); -- NOTE: actually "broadsword", but that doesn't exist in D&D

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '6b32a7a3-ab4b-463f-8a0a-fb1b817bc986', '5550af19-7dac-4c38-afa3-e0fc7dabdfcd'); -- NOTE: actually spiked guantlet

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), 'fe5f8421-591e-4431-8cda-1abb29932cb8', 'd628241a-712d-4e6d-8f06-97198ea063e0');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), 'c779bbde-f639-4e3d-830f-cfc166d1b7c5', '430174af-c5e5-47ba-a341-9e48aad6f453');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '620d2627-b34f-4146-8075-1d86ba93aa7f', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '620d2627-b34f-4146-8075-1d86ba93aa7f', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '620d2627-b34f-4146-8075-1d86ba93aa7f', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '5091265c-1645-47f2-8f1f-381b899085ad', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '5091265c-1645-47f2-8f1f-381b899085ad', '87e31638-de32-481a-9148-b89c6339a5ec');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '5091265c-1645-47f2-8f1f-381b899085ad', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '28e75eed-ce58-4ec8-8faa-58c62dd29c1b', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_proficiency
VALUES (random_uuid(), '28e75eed-ce58-4ec8-8faa-58c62dd29c1b', '49ca61dc-c0c9-4ed8-b904-443db66ea9d6');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '05808cc6-637e-4d49-a396-a6e2af138664', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '05808cc6-637e-4d49-a396-a6e2af138664', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '05808cc6-637e-4d49-a396-a6e2af138664', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '5c1b2d75-876e-46d8-acd8-28e215a3635e', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '5c1b2d75-876e-46d8-acd8-28e215a3635e', 'f12e3bc5-2052-479d-ad45-635e8312ac4a');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '5c1b2d75-876e-46d8-acd8-28e215a3635e', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), 'a6f4b077-c93c-49c8-9e48-fdbc53e45880', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), 'a6f4b077-c93c-49c8-9e48-fdbc53e45880', 'd3b13c04-130a-4114-89b0-ca4ea6b5f276');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), 'f1694098-2622-480a-9b91-1cd54a06faa6', '4cb8c02b-7379-4e60-ab7e-8bcec399193e');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '874ef372-d3c8-4c43-8afb-a846c4d14ec3', '200c5242-4a86-40f7-971f-9dd070e6f08b');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '9aa9150d-3b96-4f2f-aabf-a5b84078669e', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '9aa9150d-3b96-4f2f-aabf-a5b84078669e', '5bf55c7f-303e-415a-8504-afaf60945b69');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '9aa9150d-3b96-4f2f-aabf-a5b84078669e', '18bf4338-da22-4542-90e7-291f645bc30d');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '96da032e-c800-46b3-8928-c78e6fb3970f', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '96da032e-c800-46b3-8928-c78e6fb3970f', '5550af19-7dac-4c38-afa3-e0fc7dabdfcd');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '96da032e-c800-46b3-8928-c78e6fb3970f', 'a0fb466b-4070-4049-a3d0-96352167d5d5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '4761eb21-92f5-4cf9-a9de-c8fd08aa090e', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '4761eb21-92f5-4cf9-a9de-c8fd08aa090e', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '4761eb21-92f5-4cf9-a9de-c8fd08aa090e', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '72e2a27e-c35f-48dc-aec9-e96a42b3076f', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '72e2a27e-c35f-48dc-aec9-e96a42b3076f', 'f12e3bc5-2052-479d-ad45-635e8312ac4a');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), 'c27a8a7d-9a50-4889-85fd-12a6e51eea34', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), 'c27a8a7d-9a50-4889-85fd-12a6e51eea34', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), 'c27a8a7d-9a50-4889-85fd-12a6e51eea34', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '9aa2a9f8-27a7-4797-87c8-2887f8b79d60', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '9aa2a9f8-27a7-4797-87c8-2887f8b79d60', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '11e4c7c7-934a-43d5-b2f0-da441b6ad0e3', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '11e4c7c7-934a-43d5-b2f0-da441b6ad0e3', '4cb8c02b-7379-4e60-ab7e-8bcec399193e'); -- NOTE: actually "broadsword", but that doesn't exist in D&D

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '6b32a7a3-ab4b-463f-8a0a-fb1b817bc986', '5550af19-7dac-4c38-afa3-e0fc7dabdfcd'); -- NOTE: actually spiked guantlet

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), 'fe5f8421-591e-4431-8cda-1abb29932cb8', 'd628241a-712d-4e6d-8f06-97198ea063e0');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), 'c779bbde-f639-4e3d-830f-cfc166d1b7c5', '430174af-c5e5-47ba-a341-9e48aad6f453');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '620d2627-b34f-4146-8075-1d86ba93aa7f', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '620d2627-b34f-4146-8075-1d86ba93aa7f', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '620d2627-b34f-4146-8075-1d86ba93aa7f', 'fe03a173-3a9e-408e-b8cd-1aeee4c7cb37');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '5091265c-1645-47f2-8f1f-381b899085ad', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '5091265c-1645-47f2-8f1f-381b899085ad', '87e31638-de32-481a-9148-b89c6339a5ec');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '5091265c-1645-47f2-8f1f-381b899085ad', '1b6519bd-8e2e-4f20-89d4-530df128d7c2');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '28e75eed-ce58-4ec8-8faa-58c62dd29c1b', '59257171-75d5-45e6-b8b5-7b235b08e9a5');

INSERT INTO creature_weapon_xref
VALUES (random_uuid(), '28e75eed-ce58-4ec8-8faa-58c62dd29c1b', '49ca61dc-c0c9-4ed8-b904-443db66ea9d6');

--INSERT INTO Alignment
--VALUES (random_uuid(), 'U', 'unaligned', 'Does not make moral or ethical choices, but rather acts on instinct.');

--INSERT INTO Alignment
--VALUES (random_uuid(), 'LG', 'lawful good', 'Can be counted on to do the right thing as expected by society.');

--INSERT INTO Alignment
--VALUES (random_uuid(), 'NG', 'neutral good', 'Do the best they can to help others according to their needs.');

--INSERT INTO Alignment
--VALUES (random_uuid(), 'CG', 'chaotic good', 'Act as their conscience directs, with little regard for what others expect.');

--INSERT INTO Alignment
--VALUES (random_uuid(), 'LN', 'lawful neutral', 'Act in accordance with law, tradition, or personal codes.');

--INSERT INTO Alignment
--VALUES (random_uuid(), 'N', 'neutral', 'Those who prefer to steer clear of moral questions and dont take sides, doing what seems best at the time.');

--INSERT INTO Alignment
--VALUES (random_uuid(), 'CN', 'chaotic neutral', 'Follow their whims, holding their personal freedom above all else.');

--INSERT INTO Alignment
--VALUES (random_uuid(), 'LE', 'lawful evil', 'Methodically take what they want, within the limits of a code of tradition, loyalty, or order.');

--INSERT INTO Alignment
--VALUES (random_uuid(), 'NE', 'neutral evil', 'Those who do whatever they can get away with, without compassion or qualms.');

--INSERT INTO Alignment
--VALUES ('c2ff2246-0c55-4a04-974d-def0fdcedb5d', 'CE', 'chaotic evil', 'Act with arbitrary violence, spurred by their greed, hatred, or bloodlust.');

--INSERT INTO Ability
--VALUES (random_uuid(), 'strength', 'str');

--INSERT INTO Ability
--VALUES (random_uuid(), 'dexterity', 'dex');

--INSERT INTO Ability
--VALUES (random_uuid(), 'constitution', 'con');

--INSERT INTO Ability
--VALUES (random_uuid(), 'intelligence', 'int');

--INSERT INTO Ability
--VALUES (random_uuid(), 'wisdom', 'wis');

--INSERT INTO Ability
--VALUES (random_uuid(), 'charisma', 'cha');

--INSERT INTO skill
--VALUES (random_uuid(), 2, 'acrobatics');

--INSERT INTO skill
--VALUES (random_uuid(), 5, 'animal handling');

--INSERT INTO skill
--VALUES (random_uuid(), 4, 'arcana');

--INSERT INTO skill
--VALUES (random_uuid(), 1, 'athletics');

--INSERT INTO skill
--VALUES (random_uuid(), 6, 'deception');

--INSERT INTO skill
--VALUES (random_uuid(), 4, 'history');

--INSERT INTO skill
--VALUES (random_uuid(), 5, 'insight');

--INSERT INTO skill
--VALUES (random_uuid(), 6, 'intimidation');

--INSERT INTO skill
--VALUES (random_uuid(), 4, 'investigation');

--INSERT INTO skill
--VALUES (random_uuid(), 5, 'medicine');

--INSERT INTO skill
--VALUES (random_uuid(), 4, 'nature');

--INSERT INTO skill
--VALUES (random_uuid(), 5, 'perception');

--INSERT INTO skill
--VALUES (random_uuid(), 6, 'performance');

--INSERT INTO skill
--VALUES (random_uuid(), 6, 'persuasion');

--INSERT INTO skill
--VALUES (random_uuid(), 4, 'religion');

--INSERT INTO skill
--VALUES (random_uuid(), 2, 'sleight of hand');

--INSERT INTO skill
--VALUES (random_uuid(), 2, 'stealth');

--INSERT INTO skill
--VALUES (random_uuid(), 5, 'survival');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'acid');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'bludgeoning');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'cold');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'fire');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'force');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'lightning');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'necrotic');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'piercing');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'poison');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'psychic');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'radiant');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'slashing');

--INSERT INTO damage_type
--VALUES (random_uuid(), 'thunder');

