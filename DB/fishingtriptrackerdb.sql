-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fishingtriptrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fishingtriptrackerdb` ;

-- -----------------------------------------------------
-- Schema fishingtriptrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fishingtriptrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `fishingtriptrackerdb` ;

-- -----------------------------------------------------
-- Table `trip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trip` ;

CREATE TABLE IF NOT EXISTS `trip` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `description` TEXT NULL,
  `location` VARCHAR(45) NULL,
  `total_price` DOUBLE NULL,
  `start_date` VARCHAR(45) NULL,
  `end_date` VARCHAR(45) NULL,
  `image_url` TEXT NULL,
  `active` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `expense`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `expense` ;

CREATE TABLE IF NOT EXISTS `expense` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `description` VARCHAR(200) NULL,
  `date` DATETIME NULL,
  `image_url` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `location` VARCHAR(45) NULL,
  `trip_id` INT NOT NULL,
  `active` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_expense_trip1_idx` (`trip_id` ASC),
  CONSTRAINT `fk_expense_trip1`
    FOREIGN KEY (`trip_id`)
    REFERENCES `trip` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` TEXT NULL,
  `image_url` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  `active` TINYINT NULL,
  `email` VARCHAR(200) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS admin@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'admin'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `trip`
-- -----------------------------------------------------
START TRANSACTION;
USE `fishingtriptrackerdb`;
INSERT INTO `trip` (`id`, `name`, `description`, `location`, `total_price`, `start_date`, `end_date`, `image_url`, `active`) VALUES (1, 'New Zealand Fishing Trip', 'I had an amazing time and caught so many rainbow trout', 'Auckland, NZ', 15000, NULL, NULL, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `description`, `location`, `total_price`, `start_date`, `end_date`, `image_url`, `active`) VALUES (2, 'British Columbia Exploration', 'Had fun in Canada', 'Vancouver, CA', 12000, NULL, NULL, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `description`, `location`, `total_price`, `start_date`, `end_date`, `image_url`, `active`) VALUES (3, 'Norwegian Excursion', 'Whales! Lots of whales and some climbing adventures', 'Tromso, NO', 25000, NULL, NULL, NULL, 1);
INSERT INTO `trip` (`id`, `name`, `description`, `location`, `total_price`, `start_date`, `end_date`, `image_url`, `active`) VALUES (4, 'Ireland Adventure', 'Castles and knightly adventures!', 'Tipperary, IE', 10000, NULL, NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `expense`
-- -----------------------------------------------------
START TRANSACTION;
USE `fishingtriptrackerdb`;
INSERT INTO `expense` (`id`, `name`, `description`, `date`, `image_url`, `price`, `location`, `trip_id`, `active`) VALUES (1, 'Guided Rafting Fishing Trip', 'so much fun', NULL, NULL, 1500, NULL, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `fishingtriptrackerdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `image_url`, `role`, `active`, `email`) VALUES (1, 'Sandra', 'Harpole', 'admin', 'admin', NULL, 'admin', 1, 'slharpole14@gmail.com');

COMMIT;

