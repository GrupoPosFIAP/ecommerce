build-app:
	docker build -p 8080:8080 -t pagamentos .

build-database:
	docker build -p 27017:27017 -t mongodb-pagamentos -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=pass mongodb:latest

up-env:
	docker compose up