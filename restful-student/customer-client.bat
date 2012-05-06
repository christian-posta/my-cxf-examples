@echo off

setlocal


set URL="http://localhost:9000/customerservice/customers/search?firstName=Joe&lastName=Bloggs"
set COMMAND=.\etc\curl-7.14.0\curl.exe -X GET %URL%

echo Performing a HTTP get on %URL% using curl
echo.
echo %COMMAND%
echo.
echo Result = 
echo.
%COMMAND%
echo.
echo.