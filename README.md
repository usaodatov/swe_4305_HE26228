# Regent Kids Library LMS – SWE4305

This repository contains the source code, UML design, and demonstration screenshots for the **Regent Kids Library Management System**, developed as part of the SWE4305 Object-Oriented Programming coursework (HE26228). The project applies Java and core OOP principles: **encapsulation, abstraction, inheritance, and polymorphism**.

##  Repository Structure
src/ # Java source code (RegentKidsLibrary.java & classes)
Screenshots/ # System demo screenshots (login, book/user actions, errors)
UML-Readme # Summary of UML diagram use and structure
RegentKidsLibrary.drawio.png # Main UML Class Diagram (exported from draw.io)
README.md # This project overview file
idea/ # IntelliJ project configuration
gitignore # Git ignore file for compiled classes and IDE config
RegentKidsLibrary_SWE4305__HE26228.iml # IntelliJ module file



## Key Features

- Role-based login for Admin and Staff via `Position` enum.
- Dynamic data handling with `HashMap` collections for books, staff, and renters.
- Menu-driven interface using `Scanner`, with polymorphic `showMenu()` calls.
- Code modularity ensures separation of concerns and scalability.
- Edge-case error handling for invalid input, ID duplication, and book availability.

## Screenshots

Find all relevant screenshots under `Screenshots/` demonstrating:
- Login authentication
- Book management (Add, List, Borrow, Return)
- User creation & error validation

## UMLDesign

The UML class diagram (`RegentKidsLibrary.drawio.png`) illustrates:
- Inheritance from `User` → `SuperUser` / `Staff`
- Aggregation of `Book`, `User`, and `Renter` in `RegentKidsLibrary`
- Unidirectional relationships and encapsulated class structure

