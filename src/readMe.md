## This code was created for the SWE4305 OOP coursework (HE26228)
## Code Overview – Regent Kids Library LMS

This Java-based console application simulates a Library Management System (LMS) using Object-Oriented Programming (OOP) principles. It demonstrates **encapsulation, inheritance, abstraction**, and **polymorphism** in a practical educational context.

### Key Features:
- **Role-based access** for Admin and Staff using `Position` enum.
- **Polymorphic menus** via abstract `User` class and overridden `showMenu()` methods.
- **HashMap data structures** to manage books, staff, and renters dynamically.
- **Core operations**: Add/remove books, issue/return handling, user/customer management.
- **Input validation** with boundary checks and structured error messages.

### Main Classes:
- `RegentKidsLibrary`: System controller, menu logic, and execution.
- `User`, `SuperUser`, `Staff`: Role classes with polymorphic behavior.
- `Book`, `Renter`: Entities with encapsulated attributes and logic.


