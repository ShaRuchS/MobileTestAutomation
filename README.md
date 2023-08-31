# MobileTestAutomation
This is appium based test automation suite for the Score Android application.

**Project structure**  
.gitignore  
pom.xml  
resources  
|-- application.properties  
|-- theScore.apk
src  
|-- main  
|   |-- java  
|   |   |-- pages  
|   |   |   |-- All application page classes go here  
|   |   |-- stepDefs  
|   |   |   |-- All Gherking step definitions go here  
|   |   |-- utility  
|   |   |   |-- All common utilities go here  
|   |-- resources  
|   |   |-- features  
|   |   |   |-- All BDD feature files go here  
|-- test  
|   |-- java  
|   |   |-- runner  
|   |   |   |-- Runner.java  
|   |-- resources  
|   |   |-- cucumber.properties  

**How to invoke the test?**  
Provide the tag name to execute as CucumberOptions in src/test/java/runner/Runner.java

**Where to find results?**  
HTML report is generated under ./target folder.
