CREATE TABLE `arm_shd_database`.`records` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `number_of_record` INT UNSIGNED,
  `dist` TINYINT NOT NULL,
  `department` TINYINT NOT NULL,
  `first_create` TINYINT NOT NULL DEFAULT 0,
  `edited` TINYINT NOT NULL DEFAULT 0,
  `deleted` TINYINT NOT NULL DEFAULT 0,
  `file_record` MEDIUMBLOB(1000000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `dateIndex` (`date` ASC));