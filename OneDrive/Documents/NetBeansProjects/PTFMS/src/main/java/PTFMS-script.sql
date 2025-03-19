
CREATE SCHEMA IF NOT EXISTS `PTFMS` DEFAULT CHARACTER SET utf8 ;
USE `PTFMS` ;

DROP TABLE IF EXISTS `PTFMS`.`user` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


DROP TABLE IF EXISTS `PTFMS`.`role` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`role` (
  `role_id` INT NOT NULL,
  `role_name` VARCHAR(45) NULL,
  `role_description` VARCHAR(45) NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;

DROP TABLE IF EXISTS `PTFMS`.`user_role` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`user_role` (
  `user_role_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_role_id`),
  CONSTRAINT `fk_user_role_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `PTFMS`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `PTFMS`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

DROP TABLE IF EXISTS `PTFMS`.`permission` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`permission` (
  `permission_id` INT NOT NULL,
  `permssion_name` VARCHAR(45) NULL,
  PRIMARY KEY (`permission_id`))
ENGINE = InnoDB;


DROP TABLE IF EXISTS `PTFMS`.`role_permission` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`role_permission` (
  `role_permission_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`role_permission_id`),
  CONSTRAINT `fk_role_permission_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `PTFMS`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permission_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `PTFMS`.`permission` (`permission_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

DROP TABLE IF EXISTS `PTFMS`.`operator_status` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`operator_status` (
  `status_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `status_type` VARCHAR(45) NULL,
  `timestamp` DATETIME NULL,
  PRIMARY KEY (`status_id`),
  CONSTRAINT `fk_operator_status_user2`
    FOREIGN KEY (`user_id`)
    REFERENCES `PTFMS`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

DROP TABLE IF EXISTS `PTFMS`.`route` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`route` (
  `route_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `route_name` VARCHAR(45) NULL,
  `start_location` VARCHAR(45) NULL,
  `end_location` VARCHAR(45) NULL,
  `distance_km` DECIMAL(10,2) NULL,
  `operating_hours` VARCHAR(45) NULL,
  `stops_count` INT NULL,
  PRIMARY KEY (`route_id`),
  CONSTRAINT `fk_route_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `PTFMS`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

DROP TABLE IF EXISTS `PTFMS`.`vehicle` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`vehicle` (
  `vehicle_id` INT NOT NULL,
  `route_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `vehicle_type` VARCHAR(45) NULL,
  `energy_type` VARCHAR(45) NULL,
  `consumption_rate` DECIMAL(10,2) NULL,
  `max_passengers` INT NULL,
  PRIMARY KEY (`vehicle_id`),
  CONSTRAINT `fk_vehicle_route1`
    FOREIGN KEY (`route_id`)
    REFERENCES `PTFMS`.`route` (`route_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicle_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `PTFMS`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


DROP TABLE IF EXISTS `PTFMS`.`energy_usage` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`energy_usage` (
  `usage_id` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  `date` DATE NULL,
  `kms_traveled` DECIMAL(10,2) NULL,
  `fuel_consumed` DECIMAL(10,2) NULL,
  `energy_used` DECIMAL(10,2) NULL,
  `efficiency` DECIMAL(10,2) NULL,
  PRIMARY KEY (`usage_id`),
  CONSTRAINT `fk_energy_usage_vehicle2`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `PTFMS`.`vehicle` (`vehicle_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

DROP TABLE IF EXISTS `PTFMS`.`vehicle_location` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`vehicle_location` (
  `location_id` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  `latitude` DECIMAL(10,6) NULL,
  `longitude` DECIMAL(10,6) NULL,
  `timestamp` DATETIME NULL,
  PRIMARY KEY (`location_id`),
  CONSTRAINT `fk_vehicle_location_vehicle2`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `PTFMS`.`vehicle` (`vehicle_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

DROP TABLE IF EXISTS `PTFMS`.`station` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`station` (
  `station_id` INT NOT NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`station_id`))
ENGINE = InnoDB;


DROP TABLE IF EXISTS `PTFMS`.`transit_log` ;

CREATE TABLE IF NOT EXISTS `PTFMS`.`transit_log` (
  `log_id` INT NOT NULL,
  `station_id` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  `arrival_time` DATETIME NULL,
  `departure_time` DATETIME NULL,
  PRIMARY KEY (`log_id`),
  CONSTRAINT `fk_transit_log_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `PTFMS`.`vehicle` (`vehicle_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transit_log_station2`
    FOREIGN KEY (`station_id`)
    REFERENCES `PTFMS`.`station` (`station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
