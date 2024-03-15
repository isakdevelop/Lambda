 -- soccer JPA 버전
 CREATE TABLE stadium (
                          id INTEGER AUTO_INCREMENT PRIMARY KEY,
                          stadium_name VARCHAR(40) NOT NULL,
                          hometeam_id varchar(10) not null ,
                          seat_count INTEGER not null ,
                          address varchar(60) not null,
                          ddd varchar(10) not null,
                          tel varchar(10) not null
 );

 CREATE TABLE schedule (
                           id INTEGER AUTO_INCREMENT not null ,
                           sche_date varchar(10),
                           stadium_id INTEGER not null ,
                           guban varchar(10) not null ,
                           hometeam_id varchar(10) not null ,
                           awayteam_id varchar(10) not null ,
                           home_score INTEGER not null ,
                           away_score INTEGER not null,
                           primary key (id),
                           foreign key(stadium_id) references stadium (id)
 );

 CREATE TABLE team (
                       id INTEGER auto_increment primary key ,
                       region_name varchar(10) not null ,
                       team_name varchar(40) not null ,
                       e_team_name varchar(50) not null ,
                       orig_yyyy varchar(10) not null ,
                       zip_code1 varchar(10) not null ,
                       zip_code2 varchar(10) not null ,
                       address varchar(80) not null ,
                       ddd varchar(10) not null ,
                       tel varchar(10) not null ,
                       fax varchar(10) not null ,
                       homepage varchar(50) not null ,
                       owner varchar(10) not null ,
                       stadium_id INTEGER not null ,
                       foreign key(stadium_id) references stadium (id)
 );

 CREATE TABLE player (
                         id INTEGER auto_increment not null ,
                         player_name varchar(20) not null ,
                         e_player_name varchar(40) not null ,
                         nickname varchar(30) not null ,
                         join_yyyy varchar(10) not null ,
                         position varchar(10) not null ,
                         back_no INTEGER not null ,
                         nation varchar(20) not null ,
                         birth_date DATE not null ,
                         solar varchar(10) not null ,
                         height INTEGER not null ,
                         weight INTEGER not null ,
                         team_id INTEGER not null ,
                         primary key (id),
                         foreign key(team_id) references team (id)

 );