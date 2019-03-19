CREATE TABLE `properties` (
  `id` int(11) NOT NULL auto_increment,
  `key` varchar(200) NOT NULL,
  `value` varchar(2000) NOT NULL,
  `application` varchar(50) NOT NULL,
  `profile` varchar(50) NOT NULL,
  `label` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);