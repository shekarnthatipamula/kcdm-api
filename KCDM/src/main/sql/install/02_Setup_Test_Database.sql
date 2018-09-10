BEGIN;

--KCDM database creation
CREATE DATABASE IF NOT EXISTS kcdm_qa;

--Setup API User
CREATE USER IF NOT EXISTS kcdm_api@'%' IDENTIFIED BY 'radhakr!$n@781';

--Setup API Database Privileges
GRANT ALL PRIVILEGES ON kcdm_qa.* TO kcdm_api@'%';

COMMIT;