-- name: find-member-by-id
-- Find the member with the given ID(s).
SELECT *
FROM members
WHERE id = :id

-- name: count-members
-- Counts the number of members
SELECT count(*) AS count
FROM members

-- name: find-band-by-name-raw
-- Finds a band record based on the provided name
SELECT *
FROM bands
WHERE name = :name

-- name: create-member-raw!
-- Adds a new member with the bands_members association
WITH inserted AS (
  INSERT INTO members (first_name, last_name, email)
  VALUES (:first_name, :last_name, :email)
  RETURNING id
)
INSERT INTO bands_members (member_id, band_id)
SELECT inserted.id, :band_id FROM inserted
