# FlightSearch
### FlightSearch was built using Agile principles and Test-Driven-Development
### Project was designed and each method built along-side its test (JUnit)
### Apache Ant was used as the build file:
#### ant init : builds directories
#### ant compile: compiles java classes in /src into .class in /bin
#### ant jar : using .class files to build an executable jar file in /dist
#### ant test : Runs extensive JUnit tests on each class and its methods
#### ant doc : Creates generous and detail javadoc in /doc
#### ant clean : wipes all files and directories made by Ant.


### How to use this program
##### After compiling using 'ant compile' or any ant target that has dependences with target 'compile', .class files for each .java file will be made in bin/ directory. From here, running the program requires the following command: 
&nbsp;&nbsp;&nbsp;java src.SearchMap "inputfilename" "outputfilename"
##### The program requires the "src." prefix because that is the package where the Main-class is located. JUnit and Ant had issues/warnings with not using any package (default) and so this seemed most appropriate as it was consistent with Java programming standards.
##### The inputfile should be located in the bin directory (or a relative file path given with name) when this is called, or a FileNotFoundException will be thrown/caught and the program will terminate
##### The outputfile with paths/costs will be created and stored in the same bin/ directory
