//Module: Object Oriented Programming
//Author: Umid Saodatov (HE26228)
//Project: Regent Kids Library Inventory System



// importing necessary packages
import java.time.LocalDate; //local date - for date and time
import java.util.HashMap; // hashmap - for key-value pairs
import java.util.Map; // map - for key-value pairs (ref to: Data Structures)
import java.util.Scanner; // scanner - for user input (ref to: User Input Handling)

// ---ENUM: JOB POSITIONS---
// Role types for access control, ADMIN/STAFF
// Enumerate defining user roles for distinct specified role management
enum Position { ADMIN, STAFF }

// ---ABSTRACT USER---
// User parent class, holds info for admin & staff
// The class that holds common information for administrators and employees.  (ref. to: Polymorphism and Inheritance)
abstract class User {
    private String user_ID;
    private String p_word;
    private String f_name;
    private String l_name;
    private Position job_role;

    // Constructor that initializes the details of the user (ref to: Management & Initialization of Objects)
    public User(String user_ID, String p_word, String f_name, String l_name, Position job_role) {
        this.user_ID  = user_ID;
        this.p_word   = p_word;
        this.f_name   = f_name;
        this.l_name   = l_name;
        this.job_role = job_role;
    }

    // Gives back the user's identifier (ref to: Data Retrieval)
    public String getUser_ID()  { return user_ID; }

    // Returns the password of the user (ref to: Data Retrieval)
    public String getP_word()   { return p_word; }

    // Gives back the first name of the user. (ref to: Data Retrieval)
    public String getF_name()   { return f_name; }

    // Returns the last name of the user (ref to: Data Retrieval)
    public String getL_name()   { return l_name; }

    // Returns the role of the user.
    public Position getJob_role() { return job_role; }

    // Abstract method to show menus in a different way for the Admin and for the Staff.
    // (ref to: Polymorphism and Dynamic Behavior)
    public abstract void showMenu(RegentKidsLibrary system, Scanner sc);
}

// ---ADMIN USER CLASS---
// Admin user object, max permissions, menu override
// An admin user with unique privileges is represented (ref to: Specialized User Roles)
class SuperUser extends User {
    // Constructor for initializing admin details (ref to: Object Initialization & Role Management)
    public SuperUser(String id, String pw, String fn, String ln) {
        super(id, pw, fn, ln, Position.ADMIN);
    }

    // Admin menu for user interface & interaction (ref to: User Interface & Interaction)
    @Override
    public void showMenu(RegentKidsLibrary sys, Scanner sc) {
        // Show admin name and menu, allow all admin actions
        System.out.printf("Signed In as ADMIN %s %s%n", getF_name(), getL_name());
        while (true) {
            System.out.println("\nAdmin Menu – choose an action:");
            System.out.println(
                    "1. Issue Book  2. Return Book  3. Add New Book  4. Remove Book  5. Create USER  6. Delete USER  " +
                            "7. New Customer  8. Delete Customer  9. List All Books  10. List All USERS  11. Quit");
            int opt = sc.nextInt(); sc.nextLine();

            switch (opt) {
                case 1:
                    sys.issueBook(sc);        // Issue book to customer
                    break;
                case 2:
                    sys.returnBook(sc);       // Return book from customer
                    break;
                case 3:
                    sys.addBook(sc);          // Add new book
                    break;
                case 4:
                    sys.removeBook(sc);       // Remove book
                    break;
                case 5:
                    sys.createStaff(sc);      // Add staff user
                    break;
                case 6:
                    sys.deleteStaff(sc);      // Remove staff user
                    break;
                case 7:
                    sys.createCustomer(sc);   // Add customer
                    break;
                case 8:
                    sys.deleteCustomer(sc);   // Remove customer
                    break;
                case 9:
                    sys.listBooks();          // List all books
                    break;
                case 10:
                    sys.listStaff();          // List all staff users
                    break;
                case 11:
                    return;                   // Quit admin menu
                default:
                    System.out.println("Incorrect option. Try again."); // incorrect input
            }

        }
        }
    }


// ---STAFF USER CLASS---
// Staff user object, limited permissions, menu override
// standard staff user granted standard permissions (ref to: Specialized User Roles)
class Staff extends User {
    // Constructor setting up details of the staff (LO: Role Management & Object Initialization)
    public Staff(String id, String pw, String fn, String ln) {
        super(id, pw, fn, ln, Position.STAFF);
    }

    // Staff-specific menu display (ref to: User Interface & Interaction)
    @Override
    public void showMenu(RegentKidsLibrary sys, Scanner sc) {
        // Shows staff menu, only basic book actions allowed
        while (true) {
            System.out.println("\nStaff Menu – choose an action:");
            System.out.println("1. Issue Book  2. Return Book  3. List All Books  4. Quit");
            int opt = sc.nextInt(); sc.nextLine();

            switch (opt) {
                case 1:
                    sys.issueBook(sc);    // Issue book to customer
                    break;
                case 2:
                    sys.returnBook(sc);   // Return book from customer
                    break;
                case 3:
                    sys.listBooks();      // List all books
                    break;
                case 4:
                    return;               // Quit staff menu
                default:
                    System.out.println("Incorrect option. Try again."); // Wrong input
            }

        }
        }
    }


// ---RENTER CLASS---
// Customer (renter) object, book borrowing profile
// A class that models a customer who rents books.
// retains tenant's identification number, initial given name, final surname, cellular telephone number, and tomes in their possession at the present.
class Renter {
    private String user_ID, f_name, l_name, cellNum, bookOnLoan;

    // Constructor: sets up the details of the renter (ref to: Creating and Managing Objects)
    public Renter(String id, String fn, String ln, String phone) {
        // set renter's unique ID
        this.user_ID = id;
        // set first name of renter
        this.f_name = fn;
        // set tenant's surname
        this.l_name = ln;
        // set tenant's telephone number
        this.cellNum = phone;
    }

    // Retrieves the ID of the renter. (ref to: Data Retrieval)
    public String getUser_ID()  { return user_ID; }

    // Returns renter's first name
    public String getF_name()   { return f_name; }

    // Returns the last name of the renter
    public String getL_name()   { return l_name; }

    // Provides the phone number of the renter.
    public String getCellNum()  { return cellNum; }

    // Provides the identifier for the text that is presently on loan (ref to: Item Tracking)
    public String getBookOnLoan()     { return bookOnLoan; }

    // Establishes or refreshes the i number if presently on loan (ref to: Data Handing)
    public void   setBookOnLoan(String id) { this.bookOnLoan = id; }
}

// ---BOOK CLASS---
// Book object, stores book info, rental status
// Denotes a book that can be checked out (LO: Item Management)
class Book {
    private String book_ID, title, author, renters_ID;
    private boolean on_shelves = true;
    private LocalDate returnDay;

    // Constructor sets book details and availability to true (LO: Object Initialization & Data Management)
    public Book(String id, String t, String a) {
        // establish book ID that is not duplicated anywhere else in the world
        this.book_ID = id;
        // set book title
        this.title = t;
        // set book author
        this.author = a;

    }

    // Return the ID of the book.
    public String getBook_ID()      { return book_ID; }

    // Return the title of the book (LO: Data Retrieval)
    public String getTitle()        { return title;   }

    // Provide the name of the author.
    public String getAuthor()       { return author;  }

    // Verify whether the book can be rented (ref to: Availability Check).
    public boolean isOnShelves()    { return on_shelves; }

    // Return ID of the current renter (if any)
    public String getRenters_ID()   { return renters_ID; }

    public LocalDate getReturnDay() { return returnDay;  }

    //  book as checked out.
    public void lend(String renterId) {
        on_shelves = false; renters_ID = renterId; returnDay = LocalDate.now().plusDays(30);
    }

    // marks that a book has been returned and can now be checked out (ref to: Item Status Update)
    public void bringBack() {
        on_shelves = true; renters_ID = null; returnDay = null;
    }
}

// ---MAIN SYS CLASS---
// Library system logic, menus, collections, entry point.
class RegentKidsLibrary {
    private final Map<String,User> staff = new HashMap<>();
    private final Map<String,Renter> customers = new HashMap<>();
    private final Map<String,Book> books = new HashMap<>();

    public void initialize() {
        staff.put("admin",   new SuperUser("admin","admin","Admin","User"));
        staff.put("1", new Staff("1","password","Umid","Saodatov"));
    }

    /* START HERE: entry point for running program */
    public static void main(String[] args) {
        RegentKidsLibrary app = new RegentKidsLibrary();
        app.initialize();
        app.run();
    }

    /* main menu loop for login/user selection */
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nREGENT KIDS LIBRARY REGISTRY");
            System.out.println("1. Log In  2. Quit");
            int pick = sc.nextInt(); sc.nextLine();
            if (pick == 2) break;
            if (pick == 1) {
                System.out.print("Enter your USER ID : ");
                String id = sc.nextLine();
                System.out.print("Enter your PASSWORD : ");
                String pw = sc.nextLine();
                User u = staff.get(id);
                if (u != null && u.getP_word().equals(pw)) { u.showMenu(this, sc); }
                else System.out.println("Invalid Log In. Try Again.");
            }
        }
    }

    // ---BOOK OPERATIONS---
    // Issue, return, add, remove books - commands logic
    public void issueBook(Scanner sc) {
        // Issue book to customer if available
        System.out.print("Enter Book ID (0-15): ");
        String bid = sc.nextLine();
        Book bk = books.get(bid);
        if (bk == null || !bk.isOnShelves()) {
            System.out.println("This book doesn’t exist OR is unavailable.");
            return;
        }
        System.out.printf("Book: %s by %s%n", bk.getTitle(), bk.getAuthor()); // %s = string value for book title and author
        System.out.print("Confirm? (1. Yes  2. No) ");
        if (sc.nextInt() != 1) { sc.nextLine(); return; }
        sc.nextLine();

        System.out.println("1. Enter Customer ID  2. List ALL CUSTOMERS");
        int opt = sc.nextInt(); sc.nextLine();
        String cid;
        if (opt == 1) {
            System.out.print("Enter CUSTOMER ID : ");
            cid = sc.nextLine();
        } else {
            customers.values().forEach(c ->
                    System.out.printf("ID: %s, Name: %s %s%n", c.getUser_ID(), c.getF_name(), c.getL_name())); // %s = user ID, first name, last name
            System.out.print("Enter CUSTOMER ID from list: ");
            cid = sc.nextLine();
        }
        Renter renter = customers.get(cid);
        if (renter == null || renter.getBookOnLoan() != null) {
            System.out.println("CUSTOMER doesn’t exist OR already has a book.");
            return;
        }
        System.out.printf("Issue to %s %s? (1. Yes  2. No  3. Cancel) ", renter.getF_name(), renter.getL_name()); // %s = renter's first and last name
        if (sc.nextInt() != 1) { sc.nextLine(); return; }
        sc.nextLine();
        bk.lend(cid); renter.setBookOnLoan(bid);
        System.out.printf("Book issued for 30 days. Due: %s%n", bk.getReturnDay()); // %s = due date string
    }

    public void returnBook(Scanner sc) {
        // Return a book, update status
        System.out.print("Enter Book ID (0-15): ");
        String bid = sc.nextLine();
        Book bk = books.get(bid);
        if (bk == null || bk.isOnShelves()) {
            System.out.println("Book not issued OR doesn’t exist.");
            return;
        }
        Renter renter = customers.get(bk.getRenters_ID());
        bk.bringBack(); renter.setBookOnLoan(null);
        System.out.printf("Book %s returned successfully.%n", bk.getTitle()); // %s = title of returned book
    }

    public void addBook(Scanner sc) {
        // Add new book if not over max
        if (books.size() >= 16) { System.out.println("MAX book number reached."); return; }
        String id = nextId(books,0,15); if (id==null) return;
        System.out.print("Enter Book’s Title: ");  String title  = sc.nextLine();
        System.out.print("Enter Author: ");        String author = sc.nextLine();
        books.put(id,new Book(id,title,author));
        System.out.printf("Book added with ID: %s%n", id); // %s = new book id string
    }

    public void removeBook(Scanner sc) {
        // Remove book if on shelf
        System.out.print("Enter Book ID (0-15): ");
        String id = sc.nextLine();
        Book bk = books.get(id);
        if (bk == null || !bk.isOnShelves()) {
            System.out.println("Book doesn’t exist OR is currently issued.");
            return;
        }
        books.remove(id);
        System.out.println("Book removed successfully.");
    }

    // ---STAFF OPERATIONS---
    // Add/delete staff, list staff users
    public void createStaff(Scanner sc) {
        // Add staff if below limit and ID is free
        if (staff.values().stream().filter(u->u.getJob_role()==Position.STAFF).count()>=5) {
            System.out.println("Maximum USER limit reached."); return;
        }
        System.out.print("Enter User ID -> 0-9  : "); String id=sc.nextLine();
        if (staff.containsKey(id)){ System.out.println("User ID already exists."); return; }
        System.out.print("Enter Password - min 8 characters : "); String pw=sc.nextLine();
        System.out.print("Enter First Name: "); String fn=sc.nextLine();
        System.out.print("Enter Surname: "); String ln=sc.nextLine();
        staff.put(id,new Staff(id,pw,fn,ln));
        System.out.printf("USER created with ID: %s%n", id); // %s = new staff id
    }

    public void deleteStaff(Scanner sc) {
        // Delete staff by ID if exists and is staff
        System.out.print("Enter USER ID: ");
        String id=sc.nextLine();
        User u=staff.get(id);
        if(u==null||u.getJob_role()!=Position.STAFF){ System.out.println("USER does not exist."); return;}
        staff.remove(id);
        System.out.println("USER deleted successfully.");
    }

    public void listStaff() {
        // List all staff users
        boolean any=false;
        for(User u:staff.values())
            if(u.getJob_role()==Position.STAFF){
                System.out.printf("ID: %s, Name: %s %s%n",u.getUser_ID(),u.getF_name(),u.getL_name()); // %s = staff user id, first, last name
                any=true;
            }
        if(!any) System.out.println("No USERS available.");
    }

    // ---CUSTOMER OPERATIONS---
    // Add/delete customers, manage borrowing
    public void createCustomer(Scanner sc){
        // Add customer if below max, create with input
        if(customers.size()>=10){ System.out.println("Maximum CUSTOMER limit reached."); return; }
        String id=nextId(customers,0,9); if(id==null) return;
        System.out.print("Enter First Name: "); String fn=sc.nextLine();
        System.out.print("Enter Last Name: ");  String ln=sc.nextLine();
        System.out.print("Enter Phone Number: "); String phone=sc.nextLine();
        customers.put(id,new Renter(id,fn,ln,phone));
        System.out.printf("Customer created with ID: %s%n", id); // %s = new customer id
    }

    public void deleteCustomer(Scanner sc){
        // Delete customer if exists and no book on loan
        System.out.print("Enter Customer ID (0-9): ");
        String id=sc.nextLine();
        Renter r=customers.get(id);
        if(r==null||r.getBookOnLoan()!=null){
            System.out.println("Customer doesn’t exist OR already has a book.");
            return;
        }
        customers.remove(id);
        System.out.println("Customer removed successfully.");
    }

    // ---LIST BOOKS---
    // List all books with current status
    public void listBooks(){
        if(books.isEmpty()){ System.out.println("No books available."); return; }
        books.values().forEach(b->{
            String status=b.isOnShelves()?"Available":"Borrowed by ID: "+b.getRenters_ID()+", Due: "+b.getReturnDay();
            System.out.printf("ID: %s, Name: %s, Author: %s, Status: %s%n",
                    b.getBook_ID(), b.getTitle(), b.getAuthor(), status); // %s = id, title, author, status
        });
    }

    // ---ID GENERATOR---
    // Generate next available ID in range for user/book
    private String nextId(Map<String,?> m,int min,int max){
        for(int i=min;i<=max;i++){
            String id=String.valueOf(i);
            if(!m.containsKey(id)) return id;
        }
        System.out.printf("No available IDs in range %d to %d.%n",min,max); // %d = min value, %d = max value (integer numbers)
        return null;
    }
}
