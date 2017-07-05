CREATE SCHEMA IF NOT EXISTS `arm_shd_database`;

CREATE TABLE `arm_shd_database`.`shch` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `code` VARCHAR(5) NOT NULL,
  `deleted` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Таблиця Дистанцій сигналізації і зв\'язку (ШЧ) Львівської Залізниці';

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

  CREATE TABLE `arm_shd_database`.`stations` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `shch` INT UNSIGNED NOT NULL,
  `closed` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_simp_st_shch_idx` (`shch` ASC),
  CONSTRAINT `fk_simp_st_shch`
    FOREIGN KEY (`shch`)
    REFERENCES `arm_shd_database`.`shch` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `arm_shd_database`.`peregons` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `shch` INT UNSIGNED NOT NULL,
  `closed` TINYINT NOT NULL DEFAULT 0,
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

CREATE TABLE `arm_shd_database`.`records` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `number_of_record` INT UNSIGNED,
  `dist` TINYINT NOT NULL,
  `department` TINYINT NOT NULL,
  `first_create` TINYINT NOT NULL DEFAULT 0,
  `edited` TINYINT NOT NULL DEFAULT 0,
  `deleted` TINYINT NOT NULL DEFAULT 0,
  `file_record` MEDIUMBLOB NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `dateIndex` (`date` ASC));

INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Program Developer', 'Author');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Адміністратор', 'Адмін');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Старший диспетчер служби сигналізації та зв\'язку', 'ШДС');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер служби сигналізації та зв\'язку', 'ШД');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер дистанції сигналізації та зв\'язку ШЧ-1', 'ШЧД-1');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер дистанції сигналізації та зв\'язку ШЧ-2', 'ШЧД-2');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер дистанції сигналізації та зв\'язку ШЧ-3', 'ШЧД-3');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер дистанції сигналізації та зв\'язку ШЧ-4', 'ШЧД-4');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер дистанції сигналізації та зв\'язку ШЧ-5', 'ШЧД-5');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер дистанції сигналізації та зв\'язку ШЧ-6', 'ШЧД-6');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер дистанції сигналізації та зв\'язку ШЧ-8', 'ШЧД-8');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер дистанції сигналізації та зв\'язку ШЧ-9', 'ШЧД-9');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер дистанції сигналізації та зв\'язку ШЧ-10', 'ШЧД-10');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер дистанції сигналізації та зв\'язку ШЧ-11', 'ШЧД-11');
INSERT INTO arm_shd_database.positions (position_full, position_short) VALUES ('Диспетчер дистанції сигналізації та зв\'язку ШЧ-12', 'ШЧД-12');

insert into arm_shd_database.shch (name, code, deleted) values ('Львівська дистанція сигналізації та зв\'язку', 'ШЧ-1', 0);
insert into arm_shd_database.shch (name, code, deleted) values ('Львівська дистанція зв\'язку', 'ШЧ-2', 0);
insert into arm_shd_database.shch (name, code, deleted) values ('Здолбунівська дистанція сигналізації та зв\'язку', 'ШЧ-3', 0);
insert into arm_shd_database.shch (name, code, deleted) values ('Стрийська дистанція сигналізації та зв\'язку', 'ШЧ-4', 0);
insert into arm_shd_database.shch (name, code, deleted) values ('Івано-Франківська дистанція сигналізації та зв\'язку', 'ШЧ-5', 0);
insert into arm_shd_database.shch (name, code, deleted) values ('Сарненська дистанція сигналізації та зв\'язку', 'ШЧ-6', 0);
insert into arm_shd_database.shch (name, code, deleted) values ('Тернопільська дистанція сигналізації та зв\'язку', 'ШЧ-8', 0);
insert into arm_shd_database.shch (name, code, deleted) values ('Мукачівська дистанція сигналізації та зв\'язку', 'ШЧ-9', 0);
insert into arm_shd_database.shch (name, code, deleted) values ('Ужгородська дистанція сигналізації та зв\'язку', 'ШЧ-10', 0);
insert into arm_shd_database.shch (name, code, deleted) values ('Чернівецька дистанція сигналізації та зв\'язку', 'ШЧ-11', 0);
insert into arm_shd_database.shch (name, code, deleted) values ('Ковельська дистанція сигналізації та зв\'язку', 'ШЧ-12', 0);

INSERT INTO arm_shd_database.users (access_id, name, position, administrator, deleted) VALUES ('lost77521', 'Бакало Андрій Іванович', 1, 1, 0);
INSERT INTO arm_shd_database.users (access_id, name, position, administrator, deleted) VALUES ('lz-sh-admin', 'Адміністратор програми', 2, 1, 0);