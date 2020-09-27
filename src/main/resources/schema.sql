DROP TABLE IF EXISTS element;
DROP TABLE IF EXISTS category;

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