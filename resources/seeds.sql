INSERT INTO bands(name) VALUES ('The Beatles');
INSERT INTO bands(name) VALUES ('The Doors');

INSERT INTO members(first_name, last_name, email)
VALUES ('John', 'Lennon', 'jlennon@beatles.com');
INSERT INTO members(first_name, last_name, email)
VALUES ('Paul', 'McCartney', 'pmccartney@beatles.com');
INSERT INTO members(first_name, last_name, email)
VALUES ('George', 'Harrison', 'gharrison@beatles.com');
INSERT INTO members(first_name, last_name, email)
VALUES ('Ringo', 'Starr', 'rstarr@beatles.com');

INSERT INTO bands_members(band_id, member_id) VALUES(1, 1);
INSERT INTO bands_members(band_id, member_id) VALUES(1, 2);
INSERT INTO bands_members(band_id, member_id) VALUES(1, 3);
INSERT INTO bands_members(band_id, member_id) VALUES(1, 4);
