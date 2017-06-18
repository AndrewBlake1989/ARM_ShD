CREATE TABLE `arm_shd_database`.`peregons` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `shch` INT UNSIGNED NOT NULL,
  `closed` TINYINT NOT NULL DEFAULT 0,
  `comment` VARCHAR(500) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_simp_prg_shch_idx` (`shch` ASC),
  CONSTRAINT `fk_simp_prg_shch`
    FOREIGN KEY (`shch`)
    REFERENCES `arm_shd_database`.`shch` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;