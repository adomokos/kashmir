DBNAME=kashmir
USER=kashmir_user
PORT=5432
HOST=localhost

PGPASSWORD=password1

# Builds the DB by dropping and recreating it
build-db:
	dropdb --if-exists --username $(USER) $(DBNAME) -h $(HOST) -p $(PORT)
	createdb --username $(USER) $(DBNAME) -h $(HOST) -p $(PORT)
	lein clj-sql-up migrate
	psql -U $(USER) -d $(DBNAME) --file resources/seeds.sql > /dev/null
