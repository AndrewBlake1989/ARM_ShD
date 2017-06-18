CREATE TABLE `arm_shd_database`.`equipment_technical_points` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `year` INT UNSIGNED NOT NULL,
  `shch` TINYINT UNSIGNED NOT NULL,
  `ec` DECIMAL(7,2) UNSIGNED NOT NULL DEFAULT 0,
  `klz` DECIMAL(7,2) UNSIGNED NOT NULL DEFAULT 0,
  `ab` DECIMAL(7,2) UNSIGNED NOT NULL DEFAULT 0,
  `rpb` DECIMAL(7,2) UNSIGNED NOT NULL DEFAULT 0,
  `ps` DECIMAL(7,2) UNSIGNED NOT NULL DEFAULT 0,
  `gac` DECIMAL(7,2) UNSIGNED NOT NULL DEFAULT 0,
  `dc` DECIMAL(7,2) UNSIGNED NOT NULL DEFAULT 0,
  `other` DECIMAL(7,2) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));