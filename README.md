hbase-web
==========

build hbase-core and then run: 
`mvn spring-boot:run`

Prerequisties
-------------
- install Kite (https://github.com/kite-sdk/kite)
- install hbase-core (https://github.com/coughman/hbase-core)

Package the webapp
------------------
`mvn clean package`

Maven profiles are enabled for deploy environments.  For instance if you want to build the webapp for production:
- modify src/main/resources/production/application.properties
- `mvn -P production clean package`
