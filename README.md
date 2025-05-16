The run method prompts for user ID and password, validating against the staff HashMap (Foundation Gear). If valid, it directs to showMenu based on user role (Control Gear). For admins (SuperUser), showMenu offers 11 options; for staff (Staff), 4 options (Role Gear). Data flows as follows: Issue Book (issueBook) takes a book ID, checks books HashMap for availability, prompts for customer ID, verifies customers HashMap, updates Book.lend (sets renters_ID, due date via LocalDate), and Renter.setBookOnLoan (Operations Gear). Return Book (returnBook) validates book ID, clears Book.bringBack and Renter.setBookOnLoan. Add Book (addBook) uses nextId to generate an ID, stores a new Book in books. Remove Book (removeBook) deletes from books if available. Create/Delete Staff/Customer (createStaff, deleteStaff, createCustomer, deleteCustomer) manage staff/customers HashMaps, ensuring unique IDs via nextId. List Books/Staff (listBooks, listStaff) display data from HashMaps. The Validation Gear checks inputs/states, outputting errors (e.g., invalid ID). Data flows back to showMenu until the user quits, ensuring modular, secure interactions


#UML Discription#
8Regent Kids Library Management System in three key areas: core types, inheritance, and relationships.

Core Types

RegentKidsLibrary (top-right) is our controller. It holds three maps—staff: Map<String,User>, customers: Map<String,Renter>, and books: Map<String,Book>—and provides all operations (initialize, run, issueBook, returnBook, add/remove book, create/delete staff & customer, listBooks, listStaff, nextId).

Position (bottom-left) is an enum with values ADMIN and STAFF, assigning role levels to users.

Inheritance Hierarchy

User (center-left) is an abstract base class declaring common fields (user_ID, p_word, f_name, l_name, job_role) and an abstract showMenu(RegentKidsLibrary, Scanner).

SuperUser and Staff extend User, inheriting those fields and implementing their own showMenu logic (full vs. limited menu).

Associations

RegentKidsLibrary “manages” many Users, Renters, and Books (solid lines with “many” multiplicities).

Book (right) holds its own data plus rental status (on_shelves, renters_ID, returnDay) and operations (lend(), bringBack()).

Renter (bottom-right) models a customer with fields (user_ID, f_name, l_name, cellNum, bookOnLoan) and getters/setters to track loans.

Books are “rented by” Renters (arrow from Book back to Renter), and customers are maintained in RegentKidsLibrary*
