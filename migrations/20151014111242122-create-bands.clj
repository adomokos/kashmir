;; migrations/20151014111242122-create-bands.clj

(defn up []
    ["CREATE TABLE bands(id SERIAL PRIMARY KEY,
                         name varchar(50) NOT NULL,
                         created_at timestamp NOT NULL default CURRENT_TIMESTAMP)"
     "CREATE INDEX index_bands_id ON bands(id)"
     "CREATE TABLE bands_members(id SERIAL PRIMARY KEY,
                                 band_id INTEGER REFERENCES bands (id),
                                 member_id INTEGER REFERENCES members (id),
                                 created_at timestamp NOT NULL default CURRENT_TIMESTAMP)"])

(defn down []
  ["DROP TABLE bands"]
  ["DROP TABLE bands_members"])
