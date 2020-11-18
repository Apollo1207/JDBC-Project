CREATE DATABASE IF NOT EXISTS `fedyniak_illya_db` DEFAULT CHARACTER SET utf8;
USE `fedyniak_illya_db`;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `fedyniak_illya_db`.`received_call`;
DROP TABLE IF EXISTS `fedyniak_illya_db`.`person_information_report`;
DROP TABLE IF EXISTS `fedyniak_illya_db`.`description`;
DROP TABLE IF EXISTS `fedyniak_illya_db`.`emergency_details`;
DROP TABLE IF EXISTS `fedyniak_illya_db`.`received_call_has_crew_accepted`;
DROP TABLE IF EXISTS `fedyniak_illya_db`.`crew_accepted`;
DROP TABLE IF EXISTS `fedyniak_illya_db`.`crew_accepted_has_rescuer_of_crew`;
DROP TABLE IF EXISTS `fedyniak_illya_db`.`rescuer_of_crew`;
DROP TABLE IF EXISTS `fedyniak_illya_db`.`injury_on_call`;
SET FOREIGN_KEY_CHECKS = 1;

-- -----------------------------------------------------
-- Table `fedyniak_illya_db`.`emergency_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fedyniak_illya_db`.`emergency_details`
(
    `id`    INT         NOT NULL AUTO_INCREMENT,
    `type`  VARCHAR(20) NOT NULL,
    `cause` VARCHAR(80) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fedyniak_illya_db`.`description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fedyniak_illya_db`.`description`
(
    `id`                   INT         NOT NULL AUTO_INCREMENT,
    `short_description`                VARCHAR(20) NOT NULL,
    `expanded_description`             VARCHAR(80) NULL,
    `emergency_details_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_description_emergency_details1_idx` (`emergency_details_id` ASC) VISIBLE,
    CONSTRAINT `fk_description_emergency_details1`
        FOREIGN KEY (`emergency_details_id`)
            REFERENCES `fedyniak_illya_db`.`emergency_details` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fedyniak_illya_db`.`person_information_report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fedyniak_illya_db`.`person_information_report`
(
    `id`           INT         NOT NULL AUTO_INCREMENT,
    `name`         VARCHAR(30) NOT NULL,
    `last_name`    VARCHAR(30) NULL,
    `phone_number` VARCHAR(25) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fedyniak_illya_db`.`received_call`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fedyniak_illya_db`.`received_call`
(
    `id`                           INT         NOT NULL AUTO_INCREMENT,
    `description_id`               INT         NOT NULL,
    `address`                      VARCHAR(50) NOT NULL,
    `person_information_report_id` INT         NOT NULL,
    `datetime`                     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `fk_received_call_description_idx` (`description_id` ASC) VISIBLE,
    INDEX `fk_received_call_person_information_report1_idx` (`person_information_report_id` ASC) VISIBLE,
    CONSTRAINT `fk_received_call_description`
        FOREIGN KEY (`description_id`)
            REFERENCES `fedyniak_illya_db`.`description` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_received_call_person_information_report1`
        FOREIGN KEY (`person_information_report_id`)
            REFERENCES `fedyniak_illya_db`.`person_information_report` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fedyniak_illya_db`.`crew_accepted`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fedyniak_illya_db`.`crew_accepted`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `number`        VARCHAR(5)  NOT NULL,
    `number_of_car` VARCHAR(10) NOT NULL,
    `type_of_car`   VARCHAR(40) NULL,
    `depature_time` DATETIME    NOT NULL,
    `arrive_time`   DATETIME    NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fedyniak_illya_db`.`injury_on_call`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fedyniak_illya_db`.`injury_on_call`
(
    `id`                    INT         NOT NULL AUTO_INCREMENT,
    `name_of_injury`        VARCHAR(30) NOT NULL,
    `description_of_injury` VARCHAR(80) NOT NULL,
    `number_of_hospital`    VARCHAR(20) NOT NULL,
    `diagnosis`             VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fedyniak_illya_db`.`rescuer_of_crew`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fedyniak_illya_db`.`rescuer_of_crew`
(
    `id`                   INT         NOT NULL AUTO_INCREMENT,
    `name`                 VARCHAR(45) NOT NULL,
    `last_name`            VARCHAR(45) NOT NULL,
    `sur_name`             VARCHAR(45) NOT NULL,
    `number_of_token`      VARCHAR(8)  NOT NULL,
    rank_position                 VARCHAR(25) NOT NULL,
    `date_of_birth`        DATE        NOT NULL,
    `address_of_residence` VARCHAR(45) NOT NULL,
    `injury_on_call_id`    INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_rescuer_of_crew_injury_on_call1_idx` (`injury_on_call_id` ASC) VISIBLE,
    CONSTRAINT `fk_rescuer_of_crew_injury_on_call1`
        FOREIGN KEY (`injury_on_call_id`)
            REFERENCES `fedyniak_illya_db`.`injury_on_call` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fedyniak_illya_db`.`received_call_has_crew_accepted`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fedyniak_illya_db`.`received_call_has_crew_accepted`
(
    `received_call_id` INT NOT NULL,
    `crew_accepted_id` INT NOT NULL,
    PRIMARY KEY (`received_call_id`, `crew_accepted_id`),
    INDEX `fk_received_call_has_crew_accepted_crew_accepted1_idx` (`crew_accepted_id` ASC) VISIBLE,
    INDEX `fk_received_call_has_crew_accepted_received_call1_idx` (`received_call_id` ASC) VISIBLE,
    CONSTRAINT `fk_received_call_has_crew_accepted_received_call1`
        FOREIGN KEY (`received_call_id`)
            REFERENCES `fedyniak_illya_db`.`received_call` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_received_call_has_crew_accepted_crew_accepted1`
        FOREIGN KEY (`crew_accepted_id`)
            REFERENCES `fedyniak_illya_db`.`crew_accepted` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fedyniak_illya_db`.`crew_accepted_has_rescuer_of_crew`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fedyniak_illya_db`.`crew_accepted_has_rescuer_of_crew`
(
    `crew_accepted_id`   INT NOT NULL,
    `rescuer_of_crew_id` INT NOT NULL,
    PRIMARY KEY (`crew_accepted_id`, `rescuer_of_crew_id`),
    INDEX `fk_crew_accepted_has_rescuer_of_crew_rescuer_of_crew1_idx` (`rescuer_of_crew_id` ASC) VISIBLE,
    INDEX `fk_crew_accepted_has_rescuer_of_crew_crew_accepted1_idx` (`crew_accepted_id` ASC) VISIBLE,
    CONSTRAINT `fk_crew_accepted_has_rescuer_of_crew_crew_accepted1`
        FOREIGN KEY (`crew_accepted_id`)
            REFERENCES `fedyniak_illya_db`.`crew_accepted` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_crew_accepted_has_rescuer_of_crew_rescuer_of_crew1`
        FOREIGN KEY (`rescuer_of_crew_id`)
            REFERENCES `fedyniak_illya_db`.`rescuer_of_crew` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


CREATE INDEX rescuer_of_crew_name_idx ON rescuer_of_crew (name);
CREATE INDEX rescuer_of_crew_last_name_idx ON rescuer_of_crew (last_name);

INSERT INTO `fedyniak_illya_db`.`injury_on_call` (`name_of_injury`, `description_of_injury`, `number_of_hospital`,
                                                  `diagnosis`)
VALUES ('hedache', 'severe hedache', '3542', 'damaged nasal septum'),
       ('nausea', 'nausea and dizziness', '8542', 'carbon monoxide poisoning'),
       ('fracture', 'leg fracture', '4542', 'bone fracture'),
       ('burns', 'burns of hands and legs', '5542', '86% of body burns'),
       ('burns', 'burns of hands and abdomen', '7542', '55% of body burns'),
       ('bruise', 'burns of hand and leg', '8942', '15% of body burns'),
       ('bleeding', 'bruise of the hand', '8142', 'bone fracture'),
       ('bleeding', 'bleeding from the leg', '8242', 'high pressure'),
       ('hornet bite', 'arterial bleeding from the leg', '8249', 'lack of blood'),
       ('burns', 'anaphylactic shock', '8342', 'swollen blood vessels');


INSERT INTO `fedyniak_illya_db`.`rescuer_of_crew` (`name`, `last_name`, `sur_name`, `number_of_token`, rank_position,
                                                   `date_of_birth`, `address_of_residence`, `injury_on_call_id`)
VALUES ('Maksym', 'Vit', 'Born', '23', 'commissioned officer', '1985-02-01', 'Zelena', '1'),
       ('Ivan', 'Romanenko', 'Dorn', '34', 'commissioned officer', '1985-03-01', 'Masaryka', '2'),
       ('Dmytro', 'Dmytrenko', 'Morn', '55', 'enlisted personnel', '1985-04-01', 'Gorodotska', '3'),
       ('Stepan', 'Maksymenko', 'Dorn', '23', 'enlisted personnel', '1985-05-01', 'Metaleva', '4'),
       ('Petro', 'Ivanenko', 'Lorn', '12', 'enlisted personnel', '1985-06-01', 'Zavodska', '5'),
       ('Maksym', 'Petrenko', 'Dorn', '1', 'enlisted personnel', '1985-07-01', 'Masaryka', '6'),
       ('Paul', 'Li', 'Gorn', '8', 'commissioned officer', '1985-08-01', 'Zbyralna', '7'),
       ('John', 'Lion', 'Born', '9', 'commissioned officer', '1985-02-01', 'Chornovola', '8'),
       ('Fernando', 'Barrington', 'Lorn', '9', 'commissioned officer', '1985-02-01', 'Myrona', '9'),
       ('Bruno', 'Burn', 'Morn', '5', 'commissioned officer', '1985-02-01', 'Galytska', '10');



INSERT INTO `fedyniak_illya_db`.`crew_accepted` (`number`, `number_of_car`, `type_of_car`, `depature_time`,
                                                 `arrive_time`)
VALUES ('2341', 'ВС2345АН', 'a', '2020-10-05 15:43:31', '2020-10-05 21:15:58'),
       ('2342', 'ВС2245АН', 'b', '2020-10-05 16:43:31', '2020-10-05 21:15:58'),
       ('2343', 'ВС2445АН', 'c', '2020-10-05 17:43:31', '2020-10-05 21:15:58'),
       ('2344', 'ВС2545АН', 'e', '2020-10-05 17:43:31', '2020-10-05 21:15:58'),
       ('2345', 'ВС2645АН', 'd', '2020-10-05 19:43:31', '2020-10-05 21:15:58'),
       ('2346', 'ВС2745АН', 'm', '2020-10-05 22:43:31', '2020-10-05 21:15:58'),
       ('2347', 'ВС2845АН', 'r', '2020-10-05 20:43:31', '2020-10-05 21:15:58'),
       ('2348', 'ВС2945АН', 'l', '2020-10-05 17:43:31', '2020-10-05 21:15:58'),
       ('2349', 'ВС1045АН', 'k', '2020-10-05 15:43:31', '2020-10-05 21:15:58'),
       ('2310', 'ВС9345АН', 'p', '2020-10-05 17:43:31', '2020-10-05 21:15:58');


INSERT INTO `fedyniak_illya_db`.`crew_accepted_has_rescuer_of_crew` (`crew_accepted_id`, `rescuer_of_crew_id`)
VALUES ('1', '1'),
       ('2', '2'),
       ('3', '3'),
       ('4', '4'),
       ('5', '5'),
       ('6', '6'),
       ('7', '7'),
       ('8', '8'),
       ('9', '9'),
       ('10', '10');


INSERT INTO `fedyniak_illya_db`.`emergency_details` (`type`, `cause`)
VALUES ('domestic', 'parental neglect'),
       ('domestic', 'arson of the car'),
       ('domestic', 'short circuit'),
       ('domestic', 'accident'),
       ('non-domestic', 'not specified'),
       ('non-domestic', 'lightning strike'),
       ('non-domestic', 'careless handling of fire'),
       ('non-domestic', 'careless handling of fire'),
       ('domestic', 'accident'),
       ('domestic', 'short circuit');


INSERT INTO `fedyniak_illya_db`.`description` (short_description, expanded_description, `emergency_details_id`)
VALUES ('domestic', '', '1'),
       ('domestic', 'collision of three cars. one of them was overturned, two were injured', '2'),
       ('domestic', 'gas explosion in a high-rise building', '3'),
       ('domestic', '', '4'),
       ('non-domestic', 'burning private house', '5'),
       ('non-domestic', 'gas exlposion in a high-rise building(25 floor)', '6'),
       ('non-domestic', '', '7'),
       ('non-domestic', '', '8'),
       ('domestic', 'rescue a cat on a tree', '9'),
       ('domestic', '', '10');


INSERT INTO `fedyniak_illya_db`.`person_information_report` (`name`, `last_name`, `phone_number`)
VALUES ('Mykola', 'Ivanenko', '+380632409001'),
       ('Oksana', '', '+380632409002'),
       ('Dmytro', 'Petrenko', '+380632409003'),
       ('Alina', '', '+380632409004'),
       ('Ivan', '', '+380632409005'),
       ('Olena', '', '+380632409006'),
       ('Ulyana', 'Maksymenko', '+380632409007'),
       ('Roman', 'Dmytrenko', '+380632409008'),
       ('Illya', '', '+380632409009'),
       ('Elizaveta', '', '+380632409010'),
       ('Sergii', '', '+380632409011');

INSERT INTO `fedyniak_illya_db`.`received_call` (`description_id`, `address`, `person_information_report_id`)
VALUES ('1', 'Rubchaka, 2', '1'),
       ('2', 'Zelena, 2', '2'),
       ('3', 'Myrona, 2', '3'),
       ('4', 'Gorodotska, 2', '4'),
       ('5', 'Galytska, 2', '5'),
       ('6', 'Shevchenka, 2', '6'),
       ('7', 'Antonovycha, 2', '7'),
       ('8', 'Bandery, 2', '8'),
       ('9', 'Zalizna, 2', '9'),
       ('10', 'Pletenetskogo, 2', '10');



INSERT INTO `fedyniak_illya_db`.`received_call_has_crew_accepted` (`received_call_id`, `crew_accepted_id`)
VALUES ('1', '1'),
       ('2', '2'),
       ('3', '3'),
       ('4', '4'),
       ('5', '5'),
       ('6', '6'),
       ('7', '7'),
       ('8', '8'),
       ('9', '9'),
       ('10', '10');















