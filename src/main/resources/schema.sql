DROP TABLE IF EXISTS element;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS continent;


	CREATE TABLE category (
	  id INT AUTO_INCREMENT  PRIMARY KEY,
	  category_name VARCHAR(30) NOT NULL
	);

CREATE TABLE element (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  element_name VARCHAR(30) NOT NULL,
  fk_parent_id INT
);

ALTER TABLE element ADD FOREIGN KEY ( fk_parent_id ) REFERENCES element( id ) ;

CREATE TABLE continent (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

CREATE TABLE country (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  fk_parent_id INT
);

ALTER TABLE country ADD FOREIGN KEY ( fk_parent_id ) REFERENCES continent( id ) ;

CREATE TABLE city (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  fk_parent_id INT
);

ALTER TABLE city ADD FOREIGN KEY ( fk_parent_id ) REFERENCES country( id ) ;