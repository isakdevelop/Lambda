insert into menu(item, category) values ('[ MENU ]', 'user');
insert into menu(item, category) values ('0. EXIT', 'user');
insert into menu(item, category) values ('1. Sign_up', 'user');
insert into menu(item, category) values ('2. Login', 'user');
insert into menu(item, category) values ('3. Select_Id', 'user');
insert into menu(item, category) values ('4. Password_Change', 'user');
insert into menu(item, category) values ('5. Withdrawal', 'user');
insert into menu(item, category) values ('6. Find_user', 'user');
insert into menu(item, category) values ('7. Find_User_By_Name', 'user');
insert into menu(item, category) values ('8. Find_User_By_Job', 'user');
insert into menu(item, category) values ('9. User_Count', 'user');
insert into menu(item, category) values ('10. Create_table', 'user');
insert into menu(item, category) values ('11. Delete_table', 'user');
insert into menu(item, category) values ('input command : ', 'user');

create table menu(
     id int primary key auto_increment ,
     item varchar(30) not null ,
     category varchar(50) not null
)