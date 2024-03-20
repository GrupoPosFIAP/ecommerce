build-app:
	docker build -t pagamentos .

run-database:
	docker run --name pagamentos-postgresql -d -e POSTGRES_PASSWORD=1234 -e POSTGRES_USER=postgres -e POSTGRES_DB=ecommerce postgres

up-env:
	docker-compose up