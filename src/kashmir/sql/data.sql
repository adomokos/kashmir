-- name: find-member-by-id
-- Find the member with the given ID(s).
SELECT *
FROM members
WHERE id = :id

-- name: count-members
-- Counts the number of members
SELECT count(*) AS count
FROM members
