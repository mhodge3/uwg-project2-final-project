-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema rpg_story_mapper_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rpg_story_mapper_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rpg_story_mapper_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `rpg_story_mapper_db` ;

-- -----------------------------------------------------
-- Table `rpg_story_mapper_db`.`players`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpg_story_mapper_db`.`players` (
  `player_id` INT(11) NOT NULL AUTO_INCREMENT,
  `player_name` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `player_password` VARCHAR(255) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `player_email` VARCHAR(255) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `player_country_code` CHAR(4) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL DEFAULT 'USA',
  PRIMARY KEY (`player_id`),
  UNIQUE INDEX `demo.players_id_UNIQUE` (`player_id` ASC) VISIBLE,
  UNIQUE INDEX `demo.players_name_UNIQUE` (`player_name` ASC) VISIBLE,
  UNIQUE INDEX `demo.player_email_UNIQUE` (`player_email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `rpg_story_mapper_db`.`admins`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpg_story_mapper_db`.`admins` (
  `admin_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `player_id` INT(11) NOT NULL,
  PRIMARY KEY (`admin_id`, `player_id`),
  UNIQUE INDEX `admin_id_UNIQUE` (`admin_id` ASC) VISIBLE,
  INDEX `fk_admin_player_id_idx` (`player_id` ASC) VISIBLE,
  UNIQUE INDEX `player_id_UNIQUE` (`player_id` ASC) VISIBLE,
  CONSTRAINT `fk_players_playerId`
    FOREIGN KEY (`player_id`)
    REFERENCES `rpg_story_mapper_db`.`players` (`player_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `rpg_story_mapper_db`.`characters_npc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpg_story_mapper_db`.`characters_npc` (
  `character_npc_id` INT(11) NOT NULL AUTO_INCREMENT,
  `character_npc_name` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `character_npc_description` VARCHAR(255) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `character_npc_type` INT(11) NOT NULL,
  `character_npc_faction` INT(11) NOT NULL,
  `character_npc_pos_x` DECIMAL(10,2) NOT NULL,
  `character_npc_pos_y` DECIMAL(10,2) NOT NULL,
  `character_npc_pos_z` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`character_npc_id`),
  UNIQUE INDEX `demo.characters_npc_id_UNIQUE` (`character_npc_id` ASC) VISIBLE,
  UNIQUE INDEX `demo.characters_npc_name_UNIQUE` (`character_npc_name` ASC) VISIBLE,
  UNIQUE INDEX `demo.characters_npc_description_UNIQUE` (`character_npc_description` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `rpg_story_mapper_db`.`items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpg_story_mapper_db`.`items` (
  `item_id` INT(11) NOT NULL AUTO_INCREMENT,
  `item_name` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL DEFAULT 'Item Name',
  `item_description` VARCHAR(255) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL DEFAULT 'Item Description',
  `item_type` INT(11) NOT NULL DEFAULT '0',
  `is_quest_item` TINYINT(4) NOT NULL DEFAULT '0',
  `is_implicit_item` TINYINT(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`item_id`),
  UNIQUE INDEX `item_id_UNIQUE` (`item_id` ASC) VISIBLE,
  UNIQUE INDEX `demo.item_name_UNIQUE` (`item_name` ASC) VISIBLE,
  UNIQUE INDEX `demo.item_description_UNIQUE` (`item_description` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `rpg_story_mapper_db`.`charactersPlayer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpg_story_mapper_db`.`charactersPlayer` (
  `character_id` INT(11) NOT NULL,
  `character_player_id` INT(11) NOT NULL,
  `characte_name` VARCHAR(45) NOT NULL,
  `character_type` INT(11) NOT NULL,
  `character_faction` INT(11) NOT NULL,
  `character_posX` DECIMAL(10,2) NOT NULL,
  `character_posY` DECIMAL(10,2) NOT NULL,
  `character_posZ` DECIMAL(10,2) NOT NULL,
  INDEX `fk_charactersPlayer_players1_idx` (`character_player_id` ASC) VISIBLE,
  PRIMARY KEY (`character_id`),
  CONSTRAINT `fk_charactersPlayer_players1`
    FOREIGN KEY (`character_player_id`)
    REFERENCES `rpg_story_mapper_db`.`players` (`player_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rpg_story_mapper_db`.`inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpg_story_mapper_db`.`inventory` (
  `inventory_id` INT(11) NOT NULL,
  `character_id` INT(11) NOT NULL,
  PRIMARY KEY (`inventory_id`, `character_id`),
  INDEX `fk_inventory_characters_npc1_idx` (`character_id` ASC) VISIBLE,
  CONSTRAINT `fk_items_itenid`
    FOREIGN KEY (`inventory_id`)
    REFERENCES `rpg_story_mapper_db`.`items` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inventory_characters_npc1`
    FOREIGN KEY (`character_id`)
    REFERENCES `rpg_story_mapper_db`.`characters_npc` (`character_npc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inventory_charactersPlayer1`
    FOREIGN KEY (`character_id`)
    REFERENCES `rpg_story_mapper_db`.`charactersPlayer` (`character_player_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rpg_story_mapper_db`.`quests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpg_story_mapper_db`.`quests` (
  `quest_id` INT(11) NOT NULL,
  `pre_req_quest-id` INT(11) NOT NULL,
  `confict_id` INT(11) NOT NULL,
  `min_chartacter_level` INT(11) NOT NULL,
  `quest_name` VARCHAR(45) NOT NULL,
  `quest_description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`quest_id`, `pre_req_quest-id`),
  INDEX `fk_quests_questid_idx` (`pre_req_quest-id` ASC) VISIBLE,
  CONSTRAINT `fk_quests_questid`
    FOREIGN KEY (`pre_req_quest-id`)
    REFERENCES `rpg_story_mapper_db`.`quests` (`quest_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rpg_story_mapper_db`.`characterPlayerQyestPlayerLog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpg_story_mapper_db`.`characterPlayerQyestPlayerLog` (
  `quest_id` INT(11) NOT NULL,
  `character_id` INT(11) NOT NULL,
  `quest_status` INT NOT NULL,
  INDEX `fk_characterPlayerQyestPlayerLog_quests1_idx` (`quest_id` ASC) VISIBLE,
  INDEX `fk_characterPlayerQyestPlayerLog_charactersPlayer1_idx` (`character_id` ASC) VISIBLE,
  PRIMARY KEY (`quest_id`),
  CONSTRAINT `fk_characterPlayerQyestPlayerLog_quests1`
    FOREIGN KEY (`quest_id`)
    REFERENCES `rpg_story_mapper_db`.`quests` (`quest_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_characterPlayerQyestPlayerLog_charactersPlayer1`
    FOREIGN KEY (`character_id`)
    REFERENCES `rpg_story_mapper_db`.`charactersPlayer` (`character_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rpg_story_mapper_db`.`questItems`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpg_story_mapper_db`.`questItems` (
  `quest_id` INT(11) NOT NULL,
  `item_id` INT(11) NOT NULL,
  `item_quantity` INT NOT NULL,
  PRIMARY KEY (`quest_id`, `item_id`),
  INDEX `fk_questItems_items1_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `fk_questItems_items1`
    FOREIGN KEY (`item_id`)
    REFERENCES `rpg_story_mapper_db`.`items` (`item_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_questItems_quests1`
    FOREIGN KEY (`quest_id`)
    REFERENCES `rpg_story_mapper_db`.`quests` (`quest_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rpg_story_mapper_db`.`conflicts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpg_story_mapper_db`.`conflicts` (
  `confkict_id` INT(11) NOT NULL AUTO_INCREMENT,
  `conflict_name` VARCHAR(45) NOT NULL,
  `conflict_description` VARCHAR(45) NOT NULL,
  `conflict_template` INT(11) NOT NULL,
  PRIMARY KEY (`confkict_id`),
  CONSTRAINT `fk_conflicts_quests1`
    FOREIGN KEY (`confkict_id`)
    REFERENCES `rpg_story_mapper_db`.`quests` (`quest_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rpg_story_mapper_db`.`gameStory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpg_story_mapper_db`.`gameStory` (
  `game_story_name` VARCHAR(45) NOT NULL,
  `game_story_summary` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`game_story_name`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
