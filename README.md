# Java Selenium Examples

This directory contains example scripts and dependencies for running automated Selenium tests on Sauce Labs using Java. You can use these scripts to test your Sauce Labs authentication credentials, the setup of your automated testing environment, and try out Sauce Labs features, like cross-browser testing. Feel free to copy these files or clone the entire directory to your local environment to experiment with creating your own automated Selenium tests!

#### For Demonstration Purposes Only

The code in these scripts is provided on an "AS-IS” basis without warranty of any kind, either express or implied, including without limitation any implied warranties of condition, uninterrupted use, merchantability, fitness for a particular purpose, or non-infringement. These scripts are provided for educational and demonstration purposes only, and should not be used in production. Issues regarding these scripts should be submitted through GitHub. These scripts are maintained by the Technical Services team at Sauce Labs.

<br />

## Description

These procedures will show you to set up a Selenium environment for Java. The scripts in this repository allow you run a simple automated test to validate your Selenium environment and your [saucelabs.com](https://app.saucelabs.com/login) account credentials.

<br />

## Exercises

To begin the exercises refer [to this page](selenium-exercsies/EXERCISE_README.md).

## Prerequisites

In order to complete these exercises you must complete the following prerequisite installation and configuration steps:

* Install Git
* Install IntelliJ
* Install JDK
* Setup Project

### Install Git

[Git](https://git-scm.com/doc) is a version control system that lets you check out code from a repository, 
work with that code on your own branch, and then merge that code with any changes that have been made by other developers. 
Git is an essential tool for distributed development teams, and is a critical component of the continuous 
integration/continuous development toolchain.

#### MacOSX:

1. Go to [https://git-scm.com/downloads](https://git-scm.com/downloads).
2. Under **Downloads**, click **Mac OS X**.
3. When the download completes, double-click the `.dmg` file open the installer package.
4. Double-click the installer package to begin the installation.
    > *Security Warning*
    >
    > You may see a warning message that the package can't be opened because it's not from a recognized developer. 
    If this happens, go to System Preferences > Security and Privacy Settings, and click Open Anyway.
5. Click **Continue** for the installation, and enter your local password to authorize the installation.

#### Windows:

1. Go to [https://git-scm.com/downloads](https://git-scm.com/downloads)
2. Under **Downloads**, click on **Windows**.
3. When the dialog opens asking if you want to allow the app to make changes to your device, click Yes.
4. Follow the steps in the setup wizard to complete the installation. You should accept all the default settings.
<br />

### Install IntelliJ

[IntelliJ](https://www.jetbrains.com/idea/) is an integrated development environment that incorporates several tools for developing and running Java code. You will be using IntelliJ to write and edit the sample Selenium scripts used in the exercises.  For these exercises you only need to download the free Community edition.

#### MacOSX:

1. Go to [https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)
2. Click **Download**.
3. On the **Downloads** page, select **macOS**.
4. Under **Community**, click **Download**.
5. When the download completes, double-click the .dmg file open the installer package.
6. Double-click the installer package to begin the installation.
7. Drag and drop the IntelliJ icon into the **Applications** folder.

#### Windows:

1. Go to [https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)
2. Click **Download**.
3. On the **Downloads** page, select **Windows**.
4. Under **Community**, click **Download**.
5. When the download completes, double-click the `.exe` file to launch the installation wizard. 
You should accept all the default settings.
<br />

### Install the Java Developer's Kit (JDK)

The [Java SE Developer Kit](http://www.oracle.com/technetwork/java/javase/overview/index.html) lets you develop and 
deploy Java applications on desktops and servers. It is needed to compile our test code.

#### MacOSX:

1. Go to [the JDK downloads](https://www.oracle.com/technetwork/java/javase/downloads/index.html) page, locate the latest release, select the download button.
2. Under **Java SE Development Kit {version}**, select the **Accept License Agreement** radio button.
3. Click the download link for **Mac OS**.
4. When the download completes, double-click the `.dmg` file open the installer package.
Double-click the installer package to begin the installation.

#### Windows:

1. Go to [the JDK downloads](https://www.oracle.com/technetwork/java/javase/downloads/index.html) page, locate the latest release, select the download button.
2. Under **Java SE Development Kit {version}**, select the **Accept License Agreement** radio button.
3. Click the download link for **Windows x64**.
4. When the download completes, double-click the `.exe` file open the installer package.
5. Double-click the installer package to begin the installation. You should accept all the default settings.
<br />

### Setup the Project

#### Ensure IntelliJ is Correctly Configured:

1. **Run Hello World**
    * In IntelliJ, select **File > New > Project.**
    * In the **New Project** dialog window, select **Java** (default).
    * IntelliJ should automatically detect the JDK and appear in the **Project SDK** field. If you don't see the JDK, select **New** and navigate to where you installed the JDK. 
    * Select **Next**, then select **Create project from template > Java Hello World.**
    * Name the project **SauceDemo** and select **Finish.** 
        > you can also decide whether or not to display IntelliJ tool tips.
    * From the main toolbar, select **Run > Run 'Main'**.
        > In the main console at the bottom the words ` Hello World!` should appear, along with ` Process finished with exit code 0`. 

2. **Configure the Selenium Standalone Server**
    * Open a browser and navigate to the [SeleniumHQ Downloads page](https://www.seleniumhq.org/download/).
    * Under **Selenium Standalone Server** select the version link to download the file (extract/unzip the archive if necessary).
        > You can download the package to any directory, just ensure you remember the location when configuring Selenium in IntelliJ.
    * In IntelliJ, select **File > Project Structure > Modules.**
    * Select the **Dependencies** tab and navigate to the bottom of the window.
    * Select the **+** symbol, followed by **JARs or Directories.**
    * Navigate to the location of the **Selenium .jar** file and select **Open.**
    * Select **Apply** followed by **OK.**
    * In the **Project** pane of IntelliJ, select the triangle next to **External Libraries**
        > You should see the Selenium Standalone Server `.jar` file

3. **Configure the TestNG Framework**
    * In IntelliJ, select **File > Project Structure > Modules.**
    * Select the **Dependecies** tab and navigate to the bottom of the window.
    * elect the **+** symbol, followed by **JARs or Directories.**
    * Navigate to `Applications/IntelliJ IDEA CE/Contents/plugins/lib/`
    * Select both `testng-plugin.jar` and `testng.jar`, select **Apply > OK.**
    * In the **Project** pane of IntelliJ, select the triangle next to **External Libraries**
        > You should see the TestNG `.jar` files
        
#### Run The Sample Project in IntelliJ:
4. **Add the Test Script**
    * In the **Project** pane of IntelliJ, right-click on **src,** select **New > Java Class.**
    * Name the class ` InstantJavaTestNGTest `, then select **OK.**
    * Download the test script from [here](https://github.com/saucelabs-training/demo-java/blob/master/InstantSauceTest.java).
    * In IntelliJ, delete any code from your default class and paste in the test script
        >To run tests on Sauce Labs, you must aquire your user name and access key 

5. **Configuring your Sauce Labs Credentials**
    * Login to [www.saucelabs.com](https://app.saucelabs.com/login).
    > If you don't have a Sauce Labs account, create a free trial [here](https://signup.saucelabs.com/signup/trial)
    * In the upper-right corner, select the down arrow next to your name.
    * In the drop down menu, select **User Settings.**
    * Copy and paste both your **`Username`** and **`Access Key`** to your clipboard
    * In IntelliJ, replace the below strings with your **`Username`** and **`Access Key`**
        ```
        String sauceUserName = "YOUR USER NAME";
        String sauceAccessKey = "YOUR ACCESS KEY";
        ```
6. **Running the Test on Sauce Labs**
    * In IntelliJ, select the **`InstantJavaTestNGTest`** class, right-click anywhere, select **`Run shouldOpenSafari()`**, and check the console at the bottom of the window.
    * You should see the following in the IntelliJ console:
    ```
    [TestNG] Running:
        /Users/{user}/Library/Caches/IntelliJIdea2018.3/temp-testng-customsuite.xml

    ```
    * In the Sauce Labs Dashboard, select the **Automated Tests** tab.
        > The `shouldOpenSafari()` test should appear running.
    * Once the test completes, select the link for **`shouldOpenSafari()`** check the **Commands** tab to see all `HTTP` requests in screenshot form.
    * In the **Watch** tab, you can click on the play button to see a full video of the test.
    * Finally, in IntelliJ you'll see a green check mark next to a message that read something like so:
        ```
        Test passed: 1 of 1 test - 17s 750ms
        ```