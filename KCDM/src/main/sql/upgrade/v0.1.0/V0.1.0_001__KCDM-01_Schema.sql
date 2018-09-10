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

CREATE TABLE `kc_student` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NOT NULL,
  `age` INT(2) NOT NULL,
  `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`));

