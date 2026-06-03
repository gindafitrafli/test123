@echo off

:: shutdown running  container
docker compose -f docker-compose-local.yaml down

:: delete jar
cd /d "clientfacing"
call gradlew.bat clean
cd /d "%~dp0"

cd /d "employeefacing"
call gradlew.bat clean
cd /d "%~dp0"


