INSERT INTO person (id, name,email) VALUES (1, 'John Doe','juanmoran@unicauca.edu.co');
INSERT INTO person (id, name,email) VALUES (2, 'Jane Smith','juanmoran@unicauca.edu.co');
INSERT INTO person (id, name,email) VALUES (3, 'Robert Johnson','juanmoran@unicauca.edu.co');
INSERT INTO person (id, name,email) VALUES (4, 'John Doe 2','juanmoran@unicauca.edu.co');
INSERT INTO person (id, name,email) VALUES (5, 'Jane Smith 2','juanmoran@unicauca.edu.co');
INSERT INTO person (id, name,email) VALUES (6, 'Robert Johnson 2','juanmoran@unicauca.edu.co');
INSERT INTO person (id, name,email) VALUES (7, 'John Doe 3','juanmoran@unicauca.edu.co');
INSERT INTO person (id, name,email) VALUES (8, 'Jane Smith 3','juanmoran@unicauca.edu.co');
INSERT INTO person (id, name,email) VALUES (9, 'Robert Johnson 3','juanmoran@unicauca.edu.co');
INSERT INTO events (person_id, name) VALUES (1, 'Conference 2024');
INSERT INTO events (person_id, name) VALUES (2, 'Tech Summit 2024');
INSERT INTO events (person_id, name) VALUES (3, 'AI Expo 2024');
INSERT INTO participants (events_id, person_id) VALUES (1, 1);
INSERT INTO participants (events_id, person_id) VALUES (1, 2);
INSERT INTO participants (events_id, person_id) VALUES (2, 3);
INSERT INTO participants (events_id, person_id) VALUES (3, 4);

