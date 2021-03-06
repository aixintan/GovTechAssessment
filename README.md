# GovTech Assessment
> This java application allows user to track their shared expenses, so that everyone gets paid back.

## Table of contents
* [Technologies](#technologies)
* [Setup](#setup)
* [Test](#test)

## Technologies
* Java

## Setup
You may choose to run in any development software such as Eclipse, IntelliJ, Command Prompt (terminal) and etc.
Make sure maven is installed.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/your_username_/Project-Name.git
   ```
2. Install mvn - Maven
   ```sh
   https://maven.apache.org/install.html
   ```
3. Useful commands you can use to run the project:

   a. Compile the project and generate target folder
   ```sh
   mvn compile
   ```
   b. Builds the maven project and installs it into local maven repository.
   ```sh
   mvn install
   ```
   c. Clean the target/ folder.
   ```sh
   mvn clean install
   ```
   d. Package the project.
   ```sh
   mvn package
   ```

To Run via terminal:
1. Compile class file. Navigate to the path where the class files are stored, then type this in your terminal:
   ```sh
   javac *.java
   ```   
2. Once the files are compiled, run the main file (Calculator.java):
   ```sh
   java Calculator.MavenEclipseProject.Calculator
   ```   
   
## Test
If you want to run all the unit test classes.
```sh
mvn test
```

If you want to run a single test class.
```sh
mvn -Dtest=CalculatorTest test
```
