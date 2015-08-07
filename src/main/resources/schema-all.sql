DROP TABLE people;

CREATE TABLE people  (
    person_id BIGINT NOT NULL auto_increment,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    PRIMARY KEY (person_id)
);

/*
DROP TABLE member;
DROP TABLE dailyRelation;

CREATE TABLE member (
    id bigint not null auto_increment,
	  mail varchar(30) not null,
	  password varchar(14) not null,
    name varchar(20),
    sex varchar(1),
    phone varchar(20),
    birthday varchar(8),
	  deviceRegId varchar(255),
	  phoneAuth varchar(6),
    age integer(3),
	  kakaoId varchar(20),
    address1 varchar(20),
	  address2 varchar(20),
    createAt datetime,
	  updateAt datetime,
	  nickName varchar(20),
	  job varchar(40),
	  characterType varchar(80),
	  height integer(3),
	  bodyType varchar(80),
	  religion varchar(10),
    bloodType varchar(2),
	  selfIntroduction varchar(255),
	  hobby varchar(160),
    idealType varchar(120),
    myAppeal varchar(120),
    drinkAndSmoke varchar(40),
    wantDate varchar(100),
 	  firstPoint varchar(40),
	  image1 varchar(40),
	  image2 varchar(40),
	  image3 varchar(40),
	  image4 varchar(40),
    PRIMARY KEY (id),
	  index(mail),
	  index(name),
	  index(createAt),
    index(updateAt)
);

create table dailyRelation (
    id bigint not null auto_increment,
    relationDay date,
    male varchar(30),
    female varchar(30),
	  maleResponse varchar(20),
	  femaleResponse varchar(20),
	  temp1 varchar(50),
    temp2 varchar(50),
    createAt datetime,
	  updateAt datetime,
     PRIMARY KEY (id),
	  index(relationDay),
	  index(male),
	  index(female)
);
*/
