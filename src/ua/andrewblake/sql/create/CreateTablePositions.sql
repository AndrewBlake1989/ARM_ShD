CREATE TABLE `arm_shd_database`.`positions` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `position_full` VARCHAR(100) NOT NULL,
  `position_short` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `position_full_UNIQUE` (`position_full` ASC),
  UNIQUE INDEX `position_short_UNIQUE` (`position_short` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Довідник посад';