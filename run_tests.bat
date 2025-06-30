@echo off

REM Navigate to your Maven project directory
cd /d "D:\Automation_Redefined\CogmentocrmWeb_DataDriven"

REM Run TestNG suite using Maven
mvn -DsuiteXmlFile=testng.xml test

pause
