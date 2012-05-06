@echo off

setlocal 

if "%CXF_HOME%" == "" (
	echo You must set environment variable CXF_HOME to run this script.
	goto :eof
)

set BASE_DIR=%~dp0

set CXF_JAR=%CXF_HOME%\lib\cxf-manifest.jar
if not exist %CXF_JAR% (
	REM Can't find cxf-manifest.jar; perhaps this is an earlier verion of CXF from when the project was in "incubator" status?
	set CXF_JAR=%CXF_HOME%\lib\cxf-manifest-incubator.jar
)
if not exist %CXF_JAR% (
	echo Unable to locate CXF jar files - cannot proceed. 
	goto :eof
)


set CLASSPATH=%BASE_DIR%\build\classes;%BASE_DIR%\etc;%CXF_JAR%;%CXF_HOME%\etc;%CLASSPATH%

set JVM_ARGS=-Djava.util.logging.config.file=%BASE_DIR%/etc/logging.properties -Dcxf.config.file=cxf-stock-quote.xml

java %JVM_ARGS% stockquote.Server %*
