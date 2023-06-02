INSERT INTO client
       (name)
VALUES
       ('Ellen Pompeo'),
       ('Justin Chambers'),
       ('Jesse Williams'),
       ('Patrick Dempsey'),
       ('Sandra Oh'),
	   ('Meredith Grey'),
       ('Miranda Bailey'),
       ('Richard Webber'),
       ('Alex Karev'),
       ('Owen Hunt')
;

INSERT INTO planet
       (id, name)
VALUES
       ('MER', 'Mercury'),
       ('VEN', 'Venus'),
       ('EAR', 'Earth'),
       ('MAR', 'Mars'),
       ('JUP', 'Jupiter'),
       ('SAT', 'Saturn'),
       ('URA', 'Uranus'),
       ('NEP', 'Neptune')
;

INSERT INTO ticket
       (client_id, from_planet_id, to_planet_id)
VALUES
       (1, 'MER', 'EAR'),
       (2, 'VEN', 'JUP'),
       (3, 'MER', 'MAR'),
       (4, 'MAR', 'URA'),
       (5, 'EAR', 'JUP'),
	   (6, 'SAT', 'URA'),
       (7, 'MER', 'VEN'),
       (8, 'MAR', 'NEP'),
       (9, 'JUP', 'SAT'),
       (10, 'VEN', 'EAR')
;

