set projectLocation=C:\\crossover
cd %projectLocation%
set classpath=%projectLocation%\build;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\suite\crossover_suite.xml
pause