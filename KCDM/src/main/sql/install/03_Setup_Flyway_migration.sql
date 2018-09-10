BEGIN;

--Setup Migration User
CREATE USER IF NOT EXISTS kcdm_migrate@'%' IDENTIFIED BY 'radhakr!$n@781';

--Setup Privileges
GRANT ALL PRIVILEGES ON kcdm.* TO kcdm_migrate@'%';
GRANT ALL PRIVILEGES ON kcdm_qa.* TO kcdm_migrate@'%';

COMMIT;
