BEGIN;

--KCDM database creation
CREATE DATABASE IF NOT EXISTS kcdm;

--Setup API User
CREATE USER IF NOT EXISTS kcdm_api@'%' IDENTIFIED BY 'radhakr!$n@781';

--Setup API Database Privileges
GRANT INSERT, SELECT, UPDATE, DELETE ,SHOW VIEW ON kcdm.* TO kcdm_api@'%';

COMMIT;