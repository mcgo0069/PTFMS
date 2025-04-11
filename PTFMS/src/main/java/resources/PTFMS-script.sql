DROP DATABASE IF EXISTS ptfms;

CREATE DATABASE ptfms;
USE ptfms;

CREATE TABLE vehicle (
  vehicle_id INT NOT NULL AUTO_INCREMENT,
  vehicle_type VARCHAR(45),
  energy_type VARCHAR(45),
  consumption_rate DECIMAL(10,2),
  max_passengers INT,
  PRIMARY KEY (vehicle_id)
);

INSERT INTO vehicle (vehicle_type, energy_type, consumption_rate, max_passengers)
VALUES 
  ('Diesel Bus', 'Diesel', 10.2, 80),
  ('Electric Light Rail', 'Electric', 3.6, 1500),
  ('Diesel-Electric Train', 'Hybrid', 6.8, 1800),
  ('Diesel Bus', 'Diesel', 8.2, 90),
  ('Diesel Bus', 'Diesel', 12.2, 75),
  ('Diesel-Electric Train', 'Hybrid', 2.5, 1900),
  ('Diesel-Electric Train', 'Hybrid', 4.7, 2000),
  ('Diesel Bus', 'Diesel', 9.3, 85),
  ('Diesel Bus', 'Diesel', 11.0, 70),
  ('Diesel Bus', 'Diesel', 10.5, 95),
  ('Electric Light Rail', 'Electric', 3.9, 1450),
  ('Electric Light Rail', 'Electric', 3.3, 1600),
  ('Electric Light Rail', 'Electric', 4.1, 1550),
  ('Diesel-Electric Train', 'Hybrid', 5.7, 1750),
  ('Diesel-Electric Train', 'Hybrid', 6.2, 1850),
  ('Diesel-Electric Train', 'Hybrid', 7.0, 1950);

CREATE TABLE energy_usage (
  usage_id INT(11) NOT NULL AUTO_INCREMENT,
  date DATE,
  kms_traveled DECIMAL(10,2),
  fuel_consumed DECIMAL(10,2),
  energy_used DECIMAL(10,2),
  efficiency DECIMAL(10,2),
  vehicle_id INT(11) NOT NULL,
  PRIMARY KEY (usage_id),
  FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id));

INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-06', '150', '15', '0', '0.1', '1');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-05', '170', '23', '0', '0.14', '4');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-06', '250', '18', '0', '0.07', '5');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-06', '400', '0', '100000', '25', '2');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-01', '480', '0', '96000', '200', '3');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-02', '500', '0', '88000', '176', '6');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-03', '190', '18', '0', '0.095', '7');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-08', '210', '20', '0', '0.095', '10');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-12', '230', '21', '0', '0.091', '12');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-15', '260', '0', '74000', '284.6', '15');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-17', '500', '0', '102000', '204', '7');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-19', '390', '0', '89000', '228.2', '9');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-06', '175', '16', '0', '0.091', '2');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-09', '160', '15', '0', '0.094', '5');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-13', '280', '0', '66000', '235.7', '8');
INSERT INTO energy_usage (date, kms_traveled, fuel_consumed, energy_used, efficiency, vehicle_id)
VALUES ('2025-04-21', '470', '0', '101000', '214.9', '1');

CREATE TABLE users (
  user_id INT(11) NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(45) ,
  first_name VARCHAR(45),
  last_name VARCHAR(45),
  email VARCHAR(45),
  password VARCHAR(45),
  role VARCHAR(15),
  PRIMARY KEY (user_id));

INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('quinn_goodchild', 'Quinn', 'Goodchild', 'quinn_goodchild@PTFMS.com', '12345678','Transit Manager');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('tom_mcgonegal', 'Tom', 'McGonegal', 'tom_mcgonegal@PTFMS.com', '87654321', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('steve_martin', 'Steve', 'Martin', 'steve_martin@PTFMS.com', '986754231', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('cooper_bertrim', 'Cooper', 'Bertrim', 'cooper_bertrim@PTFMS.com', '11223344', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('britany_donis', 'Britany', 'Donis', 'britany_donis@PTFMS.com', '44332211', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('milene_ruest', 'Milene', 'Ruest', 'milene_ruest@PTFMS.com', '55443322', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('brandon_whalen', 'Brandon', 'Whalen', 'brandon_whalen@PTFMS.com', '99887766', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('keira_amy', 'Keira', 'Amy', 'keira_amy@PTFMS.com', '07240724', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('thomas_william', 'Thomas', 'William', 'thomas_william@PTFMS.com', '03150315', 'Transit Manager');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('sarah_langford', 'Sarah', 'Langford', 'sarah_langford@PTFMS.com', '13579246', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('jordan_michaels', 'Jordan', 'Michaels', 'jordan_michaels@PTFMS.com', '24681357', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('lena_roberts', 'Lena', 'Roberts', 'lena_roberts@PTFMS.com', '11221122', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('bruce_mallory', 'Bruce', 'Mallory', 'bruce_mallory@PTFMS.com', '77889900', 'Transit Manager');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('carla_ross', 'Carla', 'Ross', 'carla_ross@PTFMS.com', '98765432', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('david_han', 'David', 'Han', 'david_han@PTFMS.com', '10293847', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('amy_shields', 'Amy', 'Shields', 'amy_shields@PTFMS.com', '55667788', 'Transit Manager');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('ryan_nguyen', 'Ryan', 'Nguyen', 'ryan_nguyen@PTFMS.com', '66778899', 'Operator');
INSERT INTO users (user_name, first_name, last_name, email, password, role)
VALUES ('natalie_park', 'Natalie', 'Park', 'natalie_park@PTFMS.com', '33445566', 'Operator');

CREATE TABLE operator_status (
  status_id INT(11) NOT NULL AUTO_INCREMENT,
  user_id INT(11) NOT NULL,
  status_type VARCHAR(45),
  timestamp DATETIME,
  PRIMARY KEY (status_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id));

INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('1', 'Off Duty', '2025-04-06 19:45:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('2', 'On Duty', '2025-04-06 06:00:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('5', 'BREAK', '2025-04-06 12:30:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('6', 'Off Duty', '2025-04-06 15:15:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('8', 'On Duty', '2025-04-06 08:30:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('1', 'On Duty', '2025-04-02 06:00:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('2', 'BREAK', '2025-04-02 10:15:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('1', 'Off Duty', '2025-04-02 18:30:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('3', 'On Duty', '2025-04-03 07:00:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('4', 'BREAK', '2025-04-03 12:00:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('5', 'Off Duty', '2025-04-03 19:00:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('4', 'On Duty', '2025-04-05 05:45:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('4', 'BREAK', '2025-04-05 09:30:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('5', 'On Duty', '2025-04-06 06:30:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('9', 'BREAK', '2025-04-06 11:15:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('10', 'Off Duty', '2025-04-06 17:50:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('12', 'On Duty', '2025-04-07 06:00:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('7', 'BREAK', '2025-04-07 10:00:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('8', 'Off Duty', '2025-04-07 18:00:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('3', 'On Duty', '2025-04-09 07:30:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('4', 'BREAK', '2025-04-09 12:30:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('1', 'On Duty', '2025-04-10 08:00:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('8', 'BREAK', '2025-04-10 11:45:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('11', 'Off Duty', '2025-04-10 17:30:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('13', 'On Duty', '2025-04-12 06:30:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('13', 'BREAK', '2025-04-12 10:45:00');
INSERT INTO operator_status (user_id, status_type, timestamp)
VALUES ('15', 'Off Duty', '2025-04-12 19:15:00');


CREATE TABLE route (
  route_id INT(11) NOT NULL AUTO_INCREMENT,
  route_name VARCHAR(45),
  start_location VARCHAR(45),
  end_location VARCHAR(45),
  distance_km DECIMAL(10,2),
  operating_hours VARCHAR(45),
  stops_count INT(11),
  PRIMARY KEY (route_id));
  
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('downtown', 'Nelson St', 'TownLine Blvd', '300', '6am-8pm', '40');
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('uptown', 'Bob Circle', 'King St', '500', '6am-6pm', '35');
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('middletown', 'Miracle Rd', 'Heaven Hwy', '200', '10am-5pm', '20');
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('riverside', 'Oakwood Ave', 'Riverbend St', '350', '7am-7pm', '45');
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('city-center', 'Main St', 'Broadway Ave', '250', '5am-9pm', '30');
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('suburban', 'Greenwood Dr', 'Hillcrest Rd', '400', '8am-6pm', '25');
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('northwest-express', 'Lakeview Blvd', 'Parkway Ave', '600', '6am-10pm', '50');
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('eastridge', 'Valley Rd', 'Lakeside Blvd', '150', '9am-5pm', '15');
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('southgate', 'Eastwood St', 'Southpark Ave', '700', '5am-8pm', '60');
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('highland', 'Hilltop Rd', 'Mountain Ave', '320', '6am-6pm', '40');
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('seaside', 'Coast Blvd', 'Beachfront Rd', '150', '8am-6pm', '25');
INSERT INTO route (route_name, start_location, end_location, distance_km, operating_hours, stops_count)
VALUES ('greenline', 'Park Ave', 'Forest Rd', '450', '7am-7pm', '35');

CREATE TABLE station (
  station_id INT(11) NOT NULL AUTO_INCREMENT,
  address VARCHAR(45) ,
  PRIMARY KEY (station_id));

INSERT INTO station (address)
VALUES ('Cyrville Road');
INSERT INTO station (address)
VALUES ('Merivale Road');
INSERT INTO station (address)
VALUES ('Rideau Street');
INSERT INTO station (address)
VALUES ('Limebank Road');
INSERT INTO station (address)
VALUES ('Carling Avenue');
INSERT INTO station (address)
VALUES ('Bank Street');
INSERT INTO station (address)
VALUES ('Woodroffe Avenue');
INSERT INTO station (address)
VALUES ('Montreal Road');
INSERT INTO station (address)
VALUES ('St. Laurent Boulevard');
INSERT INTO station (address)
VALUES ('Terry Fox Drive');
INSERT INTO station (address)
VALUES ('Gladstone Avenue');
INSERT INTO station (address)
VALUES ('Hunt Club Road');
INSERT INTO station (address)
VALUES ('Somerset Street');
INSERT INTO station (address)
VALUES ('King Edward Avenue');
INSERT INTO station (address)
VALUES ('Bayshore Drive');

CREATE TABLE transit_log (
  log_id INT(11) NOT NULL AUTO_INCREMENT,
  station_id INT(11) NOT NULL,
  vehicle_id INT(11) NOT NULL,
  arrival_time DATETIME,
  departure_time DATETIME,
  PRIMARY KEY (log_id),
FOREIGN KEY (station_id)
    REFERENCES station (station_id),
    FOREIGN KEY (vehicle_id)
    REFERENCES vehicle (vehicle_id));

INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('1','1','2025-06-13 08:00:00','2025-06-13 08:10:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('2','2','2025-06-13 11:14:00','2025-06-13 11:26:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('3','4','2025-06-13 10:00:00','2025-06-13 10:10:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('4','3','2025-06-13 08:00:00','2025-06-13 08:10:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('5','7','2025-06-13 09:43:00','2025-06-13 09:47:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('1','4','2025-06-13 11:10:00','2025-06-13 11:15:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('2','2','2025-06-13 13:33:00','2025-06-13 13:36:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('1','3','2025-04-02 08:30:00','2025-04-02 08:40:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('2','5','2025-04-02 10:15:00','2025-04-02 10:20:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('3','7','2025-04-03 09:00:00','2025-04-03 09:10:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('4','9','2025-04-03 12:30:00','2025-04-03 12:35:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('5','2','2025-04-04 07:45:00','2025-04-04 07:50:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('6','4','2025-04-05 06:30:00','2025-04-05 06:40:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('7','6','2025-04-05 08:00:00','2025-04-05 08:05:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('8','8','2025-04-06 10:20:00','2025-04-06 10:25:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('9','10','2025-04-07 11:15:00','2025-04-07 11:25:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('10','11','2025-04-08 14:30:00','2025-04-08 14:40:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('11','12','2025-04-09 15:00:00','2025-04-09 15:10:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('12','14','2025-04-10 16:30:00','2025-04-10 16:40:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('13','16','2025-04-11 12:00:00','2025-04-11 12:05:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('14','15','2025-04-12 07:50:00','2025-04-12 07:55:00');
INSERT INTO transit_log (station_id, vehicle_id, arrival_time, departure_time)
VALUES ('15','13','2025-04-13 09:30:00','2025-04-13 09:40:00');

CREATE TABLE vehicle_location (
  location_id INT(11) NOT NULL AUTO_INCREMENT,
  vehicle_id INT(11) NOT NULL,
  latitude DECIMAL(10,6),
  longitude DECIMAL(10,6),
  timestamp DATETIME,
  PRIMARY KEY (location_id),
  FOREIGN KEY (vehicle_id)
    REFERENCES vehicle (vehicle_id));

INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('1','45.4215','-75.6972','2025-04-01 10:00:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('2','45.4210','-75.6900','2025-04-02 12:30:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('3','45.4240','-75.6950','2025-04-03 08:15:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('4','45.4250','-75.6930','2025-04-04 09:00:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('5','45.4180','-75.6840','2025-04-05 07:45:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('6','45.4175','-75.6990','2025-04-06 06:00:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('7','45.4280','-75.7010','2025-04-07 06:30:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('8','45.4205','-75.6825','2025-04-08 08:45:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('9','45.4260','-75.6925','2025-04-09 10:00:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('10','45.4215','-75.7040','2025-04-10 11:15:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('11','45.4290','-75.7050','2025-04-11 14:00:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('12','45.4230','-75.7015','2025-04-12 15:30:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('13','45.4205','-75.6820','2025-04-13 16:00:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('14','45.4265','-75.7030','2025-04-14 17:20:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('15','45.4185','-75.6845','2025-04-15 18:45:00');
INSERT INTO vehicle_location (vehicle_id, latitude, longitude, timestamp)
VALUES ('16','45.4315','-75.6905','2025-04-16 20:00:00');

CREATE TABLE maintenance (
  maintenance_id INT NOT NULL AUTO_INCREMENT,
  vehicle_id INT(11) NOT NULL,
  description VARCHAR(45),
  scheduled_date DATETIME,
  PRIMARY KEY (maintenance_id),
  FOREIGN KEY (vehicle_id)
    REFERENCES vehicle (vehicle_id)
);

INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('1', 'new tires', '2024-08-15 10:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('2', 'oil change', '2024-09-10 11:30:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('3', 'battery replacement', '2025-01-05 13:45:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('4', 'replace filters', '2024-10-02 09:15:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('5', 'engine inspection', '2025-02-28 14:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('6', 'brake system check', '2025-03-10 08:30:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('7', 'replace coolant', '2024-12-01 10:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('8', 'replace battery', '2024-11-05 12:15:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('9', 'new tires', '2024-07-30 07:30:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('10', 'air filter replacement', '2024-09-15 15:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('11', 'brake fluid change', '2024-10-10 11:30:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('12', 'oil change', '2025-03-01 08:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('13', 'suspension check', '2025-04-15 16:30:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('14', 'tire alignment', '2025-06-10 09:45:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('15', 'engine diagnostics', '2024-11-20 10:30:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('16', 'regular inspection', '2024-12-12 08:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('7', 'oil change', '2024-10-15 12:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('8', 'new brakes', '2025-03-18 07:45:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('9', 'air conditioning check', '2024-12-25 09:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('12', 'regular inspection', '2025-04-05 10:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('1', 'replace exhaust system', '2024-07-25 11:15:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('12', 'battery replacement', '2024-10-18 09:30:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('13', 'suspension check', '2025-01-10 12:30:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('14', 'tire replacement', '2025-02-05 14:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('5', 'brake system inspection', '2025-04-02 10:15:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('6', 'oil change', '2025-03-22 08:30:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('7', 'engine diagnostics', '2024-11-01 09:45:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('8', 'replace tires', '2025-01-20 07:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('9', 'fuel filter replacement', '2024-09-25 10:30:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('10', 'brake fluid change', '2025-02-18 11:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('13', 'tire alignment', '2024-12-22 14:00:00');
INSERT INTO maintenance (vehicle_id, description, scheduled_date)
VALUES ('2', 'engine inspection', '2025-04-07 16:30:00');

CREATE TABLE assigned_route (
  assigned_route_id INT NOT NULL AUTO_INCREMENT,
  user_id INT(11) NOT NULL,
  route_id INT(11) NOT NULL,
  vehicle_id INT(11) NOT NULL,
  PRIMARY KEY (assigned_route_id),
    FOREIGN KEY (user_id)
    REFERENCES users (user_id),
    FOREIGN KEY (route_id)
    REFERENCES route (route_id),
    FOREIGN KEY (vehicle_id)
    REFERENCES vehicle (vehicle_id));

INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('2', '1', '3');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('3', '4', '5');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('4', '7', '2');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('5', '9', '8');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('8', '10', '6');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('11', '13', '12');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('7', '16', '1');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('8', '2', '7');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('9', '3', '4');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('13', '5', '9');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('16', '6', '11');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('13', '13', '3');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('17', '8', '10');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('18', '11', '6');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('15', '12', '5');
INSERT INTO assigned_route (user_id, vehicle_id, route_id)
VALUES ('6', '14', '2');
