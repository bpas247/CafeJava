# CafeJava

> Project Definition Document
>
> Document Version: 1.7

## Authors

-   Justin Cheriyan
-   JD Mauthe
-   Brady Pascoe

## Version History

| Date    | Version # | Description                     | Reviser(s)                    |
| ------- | --------- | ------------------------------- | ----------------------------- |
| 4/20/18 | 1.0       | Initial draft                   | Brady Pascoe, Justin Cheriyan |
| 4/22/18 | 1.1       | Reformatted draft               | Brady Pascoe                  |
| 4/25/18 | 1.2       | Meeting revision draft          | All                           |
| 4/25/18 | 1.3       | Post-meeting revisions          | Brady Pascoe                  |
| 4/28/18 | 1.4       | Added Function Requirements     | Brady Pascoe                  |
| 4/29/18 | 1.5       | Added Non-Function Requirements | JD Mauthe                     |
| 5/01/18 | 1.6       | Added Table of Contents         | Brady Pascoe                  |
| 5/02/18 | 1.7       | Final Revisions                 | Brady Pascoe                  |

## Table of Contents

-   [Purpose](#purpose)
-   [Problem/Opportunity](#problemopportunity)
-   [Project Goal](#project-goal)
-   [Project Objectives](#project-objectives)
-   [Project Scope](#project-scope)
-   [Functional Requirements](#functional-requirements)
-   [Non-Functional Requirements](#non-functional-requirements)
-   [Key Stakeholders](#key-stakeholders)
-   [Success Criteria](#success-criteria)
-   [Assumptions](#assumptions)
-   [Constraints](#constraints)
-   [Risks](#risks)
-   [Estimated Duration](#estimated-duration)
-   [Recommended Project Approach](#recommended-project-approach)

## Purpose

This Project Definition Document provides a brief overview of CafeJava to promote a shared understanding of it before a more detailed Plan, Schedule, and Budget is prepared.

## Problem/Opportunity

- Problem: Café stores have to manually take inventory which wastes time and effort.
- Opportunity: Build an automated inventory to keep track of all products, stocks, and transaction history.

## Project Goal

Applying theory-based project management skills to a real world software application.

## Project Objectives

-   Make it easier to keep track of inventory.
-   Provide a centralized place for transaction histories.
-   Learn project management skills through application.
-   Develop high-quality software.

## Project Scope

Current scope includes:

-   Keep track of frozen food items.
-   Keep track of ingredients (sugar, syrup, etc).
-   Keep track of transactions (order list, customer information, etc).
-   Implement using command line interface.
-   Provide unit, component, and system testing.
-   Document using Javadoc.

Additional (if time permits) scope includes:

-   Keep track of recipes.
-   Set up a reminder system if ingredients run low
-   Develop and deploy website for documentation

## Functional Requirements

An employee:

-   Shall be able to display all available frozen food items, sorted by:
    -   Date added (oldest)
    -   Date added (newest)
    -   Name (A to Z)
    -   Name (Z to a)
    -   Price (low to high)
    -   Price (high to low)
    -   Stock (low to high)
    -   Stock (high to low)
    -   Item # (low to high)
    -   Item # (high to low)
-   Shall be able to search for a specific frozen food item, and display the top 10 most relevant results. Can search by:
    -   Name
    -   Date added
    -   Item #
    -   Price
    -   Stock
-   Shall be able to search for a single specific frozen food item, and return nothing if it is not in the database. Can search by:
    -   Name
    -   Item #
-   Shall be able to display all available ingredients, sorted by:
    -   Date added (oldest)
    -   Date added (newest)
    -   Name (A to Z)
    -   Name (Z to a)
    -   Price (low to high)
    -   Price (high to low)
    -   Stock (low to high)
    -   Stock (high to low)
    -   Item # (low to high)
    -   Item # (high to low)
-   Shall be able to search for specific ingredient items, and display the top 10 most relevant results. Can search by:
    -   Name
    -   Date added
    -   Item #
    -   Price
    -   Stock
-   Shall be able to search for a single specific ingredient, and return nothing if it is not in the database. Can search by:
    -   Name
    -   Item #
-   Shall be able to take a customer's order and register the transaction into the system.

A manager:

-   Shall be able to have all of the same functionality of an employee.
-   Shall be able to add a new frozen food item.
-   Shall be able to edit an existing frozen food item.
-   Shall be able to remove an existing frozen food item.
-   Shall be able to increase the stock of an existing frozen food item.
-   Shall be able to decrease the stock of an existing frozen food item.
-   Shall be able to increase the price of an existing frozen food item.
-   Shall be able to decrease the price of an existing frozen food item.
-   Shall be able to add a new ingredient item.
-   Shall be able to edit an existing ingredient item.
-   Shall be able to remove an existing ingredient item.
-   Shall be able to increase the stock of an existing ingredient item.
-   Shall be able to decrease the stock of an existing ingredient item.
-   Shall be able to increase the price of an existing ingredient item.
-   Shall be able to decrease the price of an existing ingredient item.

## Non-Functional Requirements

Usability:

-   Users should be able to fully use the application after 2 hours of training.
-   Errors made by experienced users shall not exceed 3 per hour.

Performance:

-   Interaction between the user and the application should take less than 3 seconds.

Availability:

-   A new installation of the application shall be usable within 6 hours.
-   The application should be available during hours of operation.

## Key Stakeholders

-   Software Management Executive
-   Software Development Team
-   Café Store Employees
-   Café Store Management
-   Customers

## Success Criteria

-   A command line interface system.
-   Fully tested, with at least 80% code coverage.
-   Fully documented deliverable.
-   Create a PowerPoint presentation

## Assumptions

-   Customers do not interact with the system directly.
-   Employees and management are given the same permissions.
-   Employees and management are going to use the system in the same way.
-   Developing and deploying will cost no money.

## Constraints

-   Time constraint (5 weeks).
-   Resource constraint (no money).

## Risks

-   Database leak results in loss of data.
-   Customer interacts with the system directly.
-   Transaction history was altered after finalization.

## Estimated Duration

Final project due: 6/4/18
Final presentation due: 6/5/18

## Recommended Project Approach

It will be a java-based, command line interface application. Technologies used are:

-   Static Analysis Tools: FindBugs, PMD
-   Coding Style Standard: Google Standard
-   Enforce Coding Style: CheckStyle
-   Build Automation: Gradle
-   Continuous Integration: Travis CI
-   Test Automation: JUnit
-   Test Development: Agile with Test-Driven Development (TDD)
-   IDE: IntelliJ

> Date: 5/02/18
