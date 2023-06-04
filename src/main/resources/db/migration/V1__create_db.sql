CREATE TABLE client (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(200) NOT NULL,
	   CONSTRAINT client_check_name CHECK(CHAR_LENGTH(name) >= 3 AND CHAR_LENGTH(name) <= 200)
);

CREATE TABLE planet (
       id VARCHAR(50) NOT NULL PRIMARY KEY,
       name VARCHAR(500) NOT NULL,
       CONSTRAINT planet_check_id CHECK(REGEXP_LIKE(id, '\b[A-Z0-9]+\b')),
	   CONSTRAINT planet_check_name CHECK(CHAR_LENGTH(name) >= 1 AND CHAR_LENGTH(name) <= 500)
);

CREATE TABLE ticket (
       id INT AUTO_INCREMENT PRIMARY KEY,
       created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
       client_id INT,
       from_planet_id VARCHAR(50),
       to_planet_id VARCHAR(50),
       FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE,
       FOREIGN KEY (from_planet_id) REFERENCES planet (id) ON DELETE CASCADE,
       FOREIGN KEY (to_planet_id) REFERENCES planet (id) ON DELETE CASCADE
);
