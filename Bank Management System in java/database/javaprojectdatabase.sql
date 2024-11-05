create database bankManagement;
USE bankManagement;
use bankManagement;
create table signup(form_no varchar(30), name varchar(30), father_name varchar(30), DOB varchar(30), gender varchar(30), email varchar(50), martial_status varchar(30), address varchar(70), pincode varchar(40), state varchar(50)); 
select * from signup;
create table signuptwo(form_no varchar(30), religion varchar(30), category varchar(30), income varchar(30), education varchar(30), occupation varchar(30), pan varchar(50), adhaar varchar(30), seniorcitizen varchar(70), existing_account varchar(40)); 
select * from signuptwo;

create table signupthree(form_no varchar(30), acccountType varchar(30), cardNo varchar(30), pinNo varchar(30), serviceRequired varchar(200)); 
select * from signupthree;

alter table signupthree rename column cardNo to card_No;

create table login(form_no varchar(30), card_number varchar(50), pin varchar(30));
select * from login;

alter table login rename column card_number to card_No; 
alter table login rename column pin to pinNo;

create table bank(pinNo varchar(30), date varchar(30), type varchar(20), ammount varchar(20));
select * from bank;

alter table bank rename column type to transactionType;
alter table bank rename column ammount to amount;
DESCRIBE login;  -- For MySQL
DESCRIBE bank;
