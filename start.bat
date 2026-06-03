@echo off

:: shutdown running  container
docker compose -f docker-compose-local.yaml down

:: build jar
cd /d "clientfacing"
call gradlew.bat clean build -x test
cd /d "%~dp0"

:: run container
docker compose -f docker-compose-local.yaml build --no-cache && docker compose -f docker-compose-local.yaml up -d
