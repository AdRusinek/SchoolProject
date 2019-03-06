-- # connect to mysql and run as root user
-- #Create Databases
CREATE DATABASE college_dev;
CREATE DATABASE college_prod;

-- #Create database service accounts
CREATE USER 'college_dev_user'@'localhost' IDENTIFIED BY 'rusinek';
CREATE USER 'college_prod_user'@'localhost' IDENTIFIED BY 'rusinek';
CREATE USER 'college_dev_user'@'%' IDENTIFIED BY 'rusinek';
CREATE USER 'college_prod_user'@'%' IDENTIFIED BY 'rusinek';

-- #Database grants
GRANT SELECT ON college_dev.* to 'college_dev_user'@'localhost';
GRANT INSERT ON college_dev.* to 'college_dev_user'@'localhost';
GRANT DELETE ON college_dev.* to 'college_dev_user'@'localhost';
GRANT UPDATE ON college_dev.* to 'college_dev_user'@'localhost';
GRANT SELECT ON college_prod.* to 'college_prod_user'@'localhost';
GRANT INSERT ON college_prod.* to 'college_prod_user'@'localhost';
GRANT DELETE ON college_prod.* to 'college_prod_user'@'localhost';
GRANT UPDATE ON college_prod.* to 'college_prod_user'@'localhost';
GRANT SELECT ON college_dev.* to 'college_dev_user'@'%';
GRANT INSERT ON college_dev.* to 'college_dev_user'@'%';
GRANT DELETE ON college_dev.* to 'college_dev_user'@'%';
GRANT UPDATE ON college_dev.* to 'college_dev_user'@'%';
GRANT SELECT ON college_prod.* to 'college_prod_user'@'%';
GRANT INSERT ON college_prod.* to 'college_prod_user'@'%';
GRANT DELETE ON college_prod.* to 'college_prod_user'@'%';
GRANT UPDATE ON college_prod.* to 'college_prod_user'@'%';