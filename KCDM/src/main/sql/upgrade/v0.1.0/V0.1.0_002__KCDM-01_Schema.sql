--
-- File: KCDM-01_Schema.sql
-- Author: Shekhar T <shekar.t@niranta.in>
--
-- JIRA: KCDM-01 - Database Design and development
--
-- Description: Setup initial schema and all related entities.
--

--
-- The SQL script will make no assumption about the database name.
-- Responsibility of picking the right database name lies with the database user of this script.
BEGIN;


CREATE TABLE `kc_student_address` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `hno` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `village` VARCHAR(45) NOT NULL,
  `town` VARCHAR(45) NOT NULL,
  `mandal` VARCHAR(45) NOT NULL,
  `district` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `pincode` VARCHAR(45) NOT NULL,
  `student_id` INT(10) UNSIGNED NOT NULL,
  `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` TINYINT(1) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  INDEX `fk_kc_student_address_idx` (`student_id` ASC),
  CONSTRAINT `fk_kc_student_address`
    FOREIGN KEY (`student_id`)
    REFERENCES `kc_student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `users` (
  `username` VARCHAR(128) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `full_name` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `enabled` TINYINT(1) NOT NULL,
  PRIMARY KEY (`username`));




