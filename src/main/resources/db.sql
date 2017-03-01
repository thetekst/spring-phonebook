-- CREATE SCHEMA IF NOT EXISTS `spring_phonebook_db` DEFAULT CHARACTER SET utf8 ;

-- create card
CREATE TABLE `profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8

-- Insert DAO
INSERT INTO profile (username, phone) VALUES ('admin', '(495) 345-23-54');