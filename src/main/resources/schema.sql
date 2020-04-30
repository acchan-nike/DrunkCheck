CREATE TABLE alcohol_type (
  type_id int(2) NOT NULL,
  name varchar(30) NOT NULL,
  volume int(2) NOT NULL,
  PRIMARY KEY (type_id)
);

CREATE TABLE drink_record (
  id int(5) NOT NULL AUTO_INCREMENT,
  user_id int(5) NOT NULL,
  type_id int(2) NOT NULL,
  quantity int(3) NOT NULL,
  date datetime NOT NULL,
  PRIMARY KEY (id)
) ;

CREATE TABLE user (
  user_id int(3) NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  email varchar(70) NOT NULL,
  password varchar(60) NOT NULL,
  weight int(3) NOT NULL,
  PRIMARY KEY (user_id)
);