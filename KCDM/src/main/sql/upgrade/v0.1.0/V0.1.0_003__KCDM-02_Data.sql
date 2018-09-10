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


INSERT INTO `users` (`username`, `password`, `role`, `full_name`, `country`, `enabled`) VALUES ('mukesh', '$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W', 'STUDENT', 'Mukesh Sharma', 'India', '1');
INSERT INTO `users` (`username`, `password`, `role`, `full_name`, `country`, `enabled`) VALUES ('tarun', '$2a$10$QifQnP.XqXDW0Lc4hSqEg.GhTqZHoN2Y52/hoWr4I5ePxK7D2Pi8q', 'PERSON', 'Tarun Singh', 'India', '1');

COMMIT;