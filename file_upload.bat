@echo off
set /p loc="Enter directory: "
echo %loc%
scp -r %loc% bmere@unix1.csc.calpoly.edu:/home/bmere/www/CPE203
