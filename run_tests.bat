@echo off

REM Navigate to your Maven project directory
cd /d "D:\Automation_Redefined\Cogmento-CRM-Web"

REM Run TestNG suite using Maven
mvn -DsuiteXmlFile=testng.xml test

pause
