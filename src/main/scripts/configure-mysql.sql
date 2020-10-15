## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE silinde_dev;
CREATE DATABASE silinde_prod;

#Create database service accounts
CREATE USER 'silinde_dev_user'@'localhost' IDENTIFIED BY 'silinde87';
CREATE USER 'silinde_prod_user'@'localhost' IDENTIFIED BY 'silinde87';
CREATE USER 'silinde_dev_user'@'%' IDENTIFIED BY 'silinde87';
CREATE USER 'silinde_prod_user'@'%' IDENTIFIED BY 'silinde87';

#Database grants
GRANT SELECT ON silinde_dev.* to 'silinde_dev_user'@'localhost';
GRANT INSERT ON silinde_dev.* to 'silinde_dev_user'@'localhost';
GRANT DELETE ON silinde_dev.* to 'silinde_dev_user'@'localhost';
GRANT UPDATE ON silinde_dev.* to 'silinde_dev_user'@'localhost';
GRANT SELECT ON silinde_prod.* to 'silinde_prod_user'@'localhost';
GRANT INSERT ON silinde_prod.* to 'silinde_prod_user'@'localhost';
GRANT DELETE ON silinde_prod.* to 'silinde_prod_user'@'localhost';
GRANT UPDATE ON silinde_prod.* to 'silinde_prod_user'@'localhost';
GRANT SELECT ON silinde_dev.* to 'silinde_dev_user'@'%';
GRANT INSERT ON silinde_dev.* to 'silinde_dev_user'@'%';
GRANT DELETE ON silinde_dev.* to 'silinde_dev_user'@'%';
GRANT UPDATE ON silinde_dev.* to 'silinde_dev_user'@'%';
GRANT SELECT ON silinde_prod.* to 'silinde_prod_user'@'%';
GRANT INSERT ON silinde_prod.* to 'silinde_prod_user'@'%';
GRANT DELETE ON silinde_prod.* to 'silinde_prod_user'@'%';
GRANT UPDATE ON silinde_prod.* to 'silinde_prod_user'@'%';