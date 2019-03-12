create database course_api;
use course_api;
create user 'courseuser'@'localhost' identified by 'password123';
grant all on course_api.* to 'courseuser'@'localhost';
