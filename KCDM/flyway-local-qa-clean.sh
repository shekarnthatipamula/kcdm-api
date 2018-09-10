#!/bin/bash

#
# migrate test database
#

mvn --batch-mode flyway:clean -Dflyway.url=jdbc:mysql://localhost:3306/kcdm_qa -Dflyway.schemas=kcdm_qa