DROP DATABASE IF EXISTS foodontime;

CREATE DATABASE foodontime;

USE foodontime;

CREATE USER foodontime_user@localhost IDENTIFIED BY 'foodontime';

GRANT ALL
ON foodontime.*
TO foodontime_user@localhost;


GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP
ON foodontime.*
TO foodontime_user@localhost;