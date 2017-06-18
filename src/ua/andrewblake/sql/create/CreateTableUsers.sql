CREATE TABLE `arm_shd_database`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `access_id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `position` INT(10) UNSIGNED NOT NULL,
  `administrator` TINYINT NOT NULL,
  `deleted` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `access_id_UNIQUE` (`access_id` ASC),
  INDEX `fk_users_positions_idx` (`position` ASC),
  CONSTRAINT `fk_users_positions`
    FOREIGN KEY (`position`)
    REFERENCES `arm_shd_database`.`positions` (`id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Таблиця користувачів та адміністраторів БД з розмежуванням прав доступу.';