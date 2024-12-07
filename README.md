# GatorDB: An In-Memory Database With Transaction Support
# About
## Functionality
- `begin_transaction()`: Starts a new transaction. Note that only a single transaction may exist at a time.
- `put(key, value)`: Adds or updates an entry. It must be done within a transaction.
- `get(key)`: Retrieves a value of an entry given its key. If no such key exists in the database, `NULL` is returned.
- `commit()`: Applies all changes/operations made within the open transaction. This operation closes the transaction.
- `rollback()`: Aborts all changes/operations made within the open transaction. This operation closes the transaction.

## Tests
A few tests have been created to assert the desired behavior of the application. 

The tests mirror the example behavior (provided in the assignment pdf) exactly.

# How to Run The Application
## Set-Up
- Ensure that JDK 21 or later is installed
  
  Run `java -version` to check the JDK version on your machine.

  If you don't have JDK or it is outdated, I recommend the OpenSource JDK Corretto from Amazon.
  
  You can download the version for your OS at [this link](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html) (with installation instructions).

- (ONLY FOR RUNNING IN TERMINAL) Ensure that Maven 3.9 or later is installed
  
  Run `mvn -v` to check the Maven version on your machine.
  
  If you need to install it, download it using [this link](https://maven.apache.org/download.cgi). Here are [installation instructions](https://maven.apache.org/install.html).
  
## Running In The IntelliJ IDE
#### Step 1: Clone the Repository
1. Open IntelliJ IDEA.
2. Go to File > New > Project from Version Control.
3. Paste the repository URL and click Clone.
4. IntelliJ will download the repository and open the project.

#### Step 2: Import as Maven Project
IntelliJ should automatically detect the pom.xml file and import the project as a Maven project.

If IntelliJ doesn’t prompt you:
1. Go to File > Open.
2. Select the pom.xml file in your project directory.
3. Click Open as Project.
4. Wait for IntelliJ to finish indexing and downloading dependencies. You can check the progress in the bottom-right corner.

#### Step 3: Install Dependencies
1. Open the Maven Tool Window: Go to View > Tool Windows > Maven.
2. Click the Reload All Maven Projects button (circular arrows) in the Maven tool window. This will download and install all dependencies listed in the pom.xml.

#### Step 4: Run The Tests
1. Navigate to the src/test/java/com/ufl/gatordb/GatorDBTest.java file.
2. Click on the green play button (it's located in the file itself and the top right corner of IntelliJ. Either works)
3. IntelliJ will open a terminal window. You can view the test results in there.

#### Step 5: Run The Application
1. Navigate to the src/main/java/com/ufl/gatordb/App.java file.
2. Click on the green play button (it's located in the file itself and the top right corner of IntelliJ. Either works)
3. IntelliJ will open a terminal window. You can interact with the CLI in there.

## Running In The Terminal
#### Step 1: Clone the Repository
For SSH, you can run `git clone git@github.com:jesslourenco/ESEP-data-processing-and-storage.git`

#### Step 2: Build and Run the Project
1. Navigate to the project's root with `cd gatordb`
2. Run the Maven lifecycle with `mvn install`. The automated tests will run automatically and show the results.
3. Run the application with `java -cp target/gatordb-1.0-SNAPSHOT.jar com.ufl.gatordb.App`
4. Interact with the CLI.

# Recommendations To Make This An "Official" Assignment at UF
- Limit students to using Java, Python, or C++ since those are languages taught during the program, and graders should already be familiar with them.
- Create automated grading for the coding portion of the assignment. This can be prepared for each of the three languages mentioned. A tool for this I've seen used in other classes is [Gradescope](https://www.gradescope.com/).
- For the above to work, the assignment pdf must be improved. Provide detailed specifications and a rubric for the project. The code should be consistent for automated grading: identical method signatures, expected behaviors and returns, etc. 
