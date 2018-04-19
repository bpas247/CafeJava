master - [![Build Status](https://travis-ci.org/bpas247/CafeJava.svg?branch=master)](https://travis-ci.org/bpas247/CafeJava),
develop - [![Build Status](https://travis-ci.org/bpas247/CafeJava.svg?branch=develop)](https://travis-ci.org/bpas247/CafeJava)

# Cafe Java

> A java-based automated CLI inventory manager for cafe shops.

# Table of Contents

-   [Getting Started](#getting-started)
    -   [Prerequisites](#prerequisites)
    -   [Installing](#installing)
-   [Running Tests](#running-tests)
    -   [Running Coding Style Tests](#running-coding-style-tests)
-   [Deployment](#deployment)
-   [Built With](#built-with)
-   [Contributing](#contributing)
-   [Contributors](#contributors)
-   [Versioning](#versioning)
-   [License](#license)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See [deployment](#deployment) for notes on how to deploy the project on a live system.

### Prerequisites

-   **Optional if using wrapper** [Gradle 4.6](https://gradle.org/install/)
-   [Java JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
-   **Optional** [IntelliJ IDEA](https://www.jetbrains.com/idea/)
-   **Optional** [CheckStyle-IDEA](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea)
-   **Optional** [FindBugs-IDEA](https://plugins.jetbrains.com/plugin/3847-findbugs-idea)
-   **Optional** [PMD IntelliJ IDEA Plugin](https://pmd.github.io/latest/pmd_userdocs_tools.html#idea)

### Installing

**Note** Depending on your system, it might be necessary to use `./gradlew` or `./gradlew.bat` instead of `gradle`.
After cloning and forking the repository, run the following command in the command line (or terminal) within the local directory:

    gradle build

To execute the program:

    gradle run

To clean the repository of the current build:

    gradle clean

To build the IntelliJ idea files, run the following command:

    gradle idea

To clean the IntelliJ files:

    gradle cleanIdea

To see all available tasks:

    gradle tasks

## Running Tests

We use JUnit to automate our testing. To run all unit tests, run in the command line (or terminal):

    gradle test

### Running Coding Style Tests

We use checkstyle in order to keep a consistent code format. We also use FindBugs for additional debugging. In order to generate chekstyle and FindBugs reports for the current build, run:

    gradle check

Generated code reports can be found under `..\build\reports\`

## Deployment

Currently there is no way of deploying this system, will add this as `TODO`.

## Built With

-   [Gradle](https://gradle.org/) - Build automation tool
-   [Travis CI](https://travis-ci.org/) - Continuous integration
-   [CheckStyle](http://checkstyle.sourceforge.net/) - Enforces Proper Coding Style Conventions
-   [FindBugs](http://findbugs.sourceforge.net/) - Static Analysis Tool
-   [JUnit](https://junit.org/junit4/) - Test automation tool
-   [PMD](https://pmd.github.io/) - Static Analysis Tool

## Contributing

`TODO` Create CONTRIBUTING.md

## Contributors

-   **Brady Pascoe** - _Initial work_ - [bpas247](https://github.com/bpas247)

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
