# Library-Management-System-Project
<img width="796" alt="Screenshot 2024-03-22 at 8 26 23 PM" src="https://github.com/Hamzenium/Library-Management-System-Project/assets/67511980/e85fd044-f6b2-4348-a45a-dc89015fb48a">

# Library Management System

## Overview

This project is a Library Management System that automates the core operations of a library, such as user management, book borrowing, returning, and payment gateway integration. It also supports newsletter subscriptions, penalty calculations for late returns, and more. The system follows Object-Oriented Programming (OOP) principles and uses various design patterns like Strategy, Factory, and Iterator to ensure flexibility, maintainability, and scalability.

## Design Choices

### 1. **Object-Oriented Design (OOP)**
The Library Management System is built using OOP principles to ensure that the system is modular, extensible, and maintainable. Key OOP concepts used include:

- **Encapsulation:** Each class is designed to handle its own data and responsibilities, ensuring that the system's components are loosely coupled and can be modified independently.
- **Abstraction:** High-level interfaces are provided for interaction with the system's components, while the internal workings are hidden from the user. For example, the payment system interface abstracts different types of payment methods, allowing them to be used interchangeably without affecting the rest of the system.
- **Inheritance:** Some classes inherit common functionality from base classes, reducing code duplication. For instance, different types of users (e.g., Librarian, Regular User) inherit common attributes and behaviors from a base User class.
- **Polymorphism:** Methods like `processPayment()` can be used polymorphically across different types of payment methods, ensuring the system remains flexible and easy to extend with new payment options.

### 2. **Payment Gateway Strategy (Strategy Design Pattern)**
The payment processing module is designed using the **Strategy pattern**. This pattern allows the system to handle multiple types of payment methods (e.g., credit card, online payment) by encapsulating the payment logic into separate strategy classes.

- **Why this design?** The Strategy pattern provides flexibility by allowing the payment methods to be changed at runtime without altering the client code. This makes it easier to add new payment methods in the future.
  
Classes involved:
- **Payment** (context class) - This class uses a `PaymentGatewayStrategy` to process payments.
- **PaymentGatewayStrategy** (interface) - Defines the common interface for all payment methods.
- **CreditCardPayment**, **OnlinePayment**, etc. (concrete strategies) - Implementations of the `PaymentGatewayStrategy` interface for specific payment types.

This pattern decouples the payment logic from other parts of the system, allowing the payment module to be extended or modified independently.

### 3. **User Factory (Factory Design Pattern)**
The system uses the **Factory pattern** to manage user creation. By employing this pattern, the system can easily create users with different roles, such as librarians, students, and admins, without exposing the creation logic to the client code.

- **Why this design?** The Factory pattern helps to centralize the logic for user creation, making it easy to instantiate various user types based on the input or role, ensuring consistency and reducing complexity.
  
Classes involved:
- **User** (abstract base class) - Represents a general user with common properties (e.g., `name`, `email`).
- **Librarian**, **Student**, **Admin** (concrete classes) - Represent specific user types with additional behavior.
- **UserFactory** - A factory class responsible for creating the appropriate user objects based on role or other attributes.

This approach allows for easy extension if new user roles are added in the future, without needing to modify the system's core logic.

### 4. **Iterator Pattern (ItemIterator Design Pattern)**
The **Iterator pattern** is used for iterating over the library’s collection of items (books, magazines, etc.) without exposing the internal structure of the collection. This pattern ensures that the system can easily traverse items, especially when dealing with large data sets, while maintaining a consistent interface.

- **Why this design?** The Iterator pattern provides a standardized way of accessing elements in a collection, promoting loose coupling and making it easy to switch between different types of collections (e.g., arrays, lists) without affecting the code that uses them.
  
Classes involved:
- **ItemIterator** (iterator interface) - Defines methods for traversing items (e.g., `hasNext()`, `next()`).
- **LibraryItems** (aggregate) - The collection of items (books, magazines) being iterated over.
- **ConcreteIterator** - The actual iterator that traverses the library items.

This design simplifies the process of adding new types of items to the library system, as the client code remains unaware of the underlying collection changes.

### 5. **Separation of Concerns and Modularity**
Each major component of the system is encapsulated in its own module or class. This modular design promotes separation of concerns, ensuring that changes to one part of the system (e.g., payment processing) do not directly affect other parts (e.g., user management).

Examples of modular components:
- **User Management:** Manages user registration, login, and profiles.
- **Book Borrowing/Returning:** Handles the borrowing and return process, including updating item availability.
- **Payment Processing:** Manages the payment for late fees or book purchases using various strategies.
- **Newsletter Subscription:** Allows users to subscribe or unsubscribe to newsletters.

By organizing the code into independent modules, each with a specific responsibility, the system becomes easier to maintain, test, and extend.

### 6. **Input/Output (I/O) Design**
The system currently uses file-based I/O for storing user data, book information, and transaction details. The I/O operations are abstracted into separate classes to ensure that the system is decoupled from the underlying storage mechanism, making it easier to transition to a more scalable database solution in the future.

- **Why this design?** File-based storage is lightweight and simple to implement, making it a suitable choice for this prototype. However, it can be easily replaced with a database solution in the future, such as MySQL or MongoDB, without requiring major changes to the system architecture.

Classes involved:
- **FileIOHandler** - Handles all file operations, including reading and writing data to CSV or text files.
- **DatabaseIOHandler** (future enhancement) - Potential class for future database integration.

This design keeps the system's data layer flexible and adaptable to different storage technologies.

## Features

- **User Management:** Allows for the creation and management of different user types (e.g., Librarian, Student, Admin).
- **Book Borrowing/Returning:** Tracks books borrowed and returned, including due dates and penalties.
- **Payment Gateway Integration:** Supports multiple payment methods (e.g., credit card, online payment) for overdue fees or book purchases.
- **Newsletters:** Users can subscribe or unsubscribe to library newsletters.
- **Penalty Calculation:** Calculates penalties for late book returns based on library policy.

<img width="795" alt="Screenshot 2024-03-22 at 8 26 31 PM" src="https://github.com/Hamzenium/Library-Management-System-Project/assets/67511980/e786e890-9dec-4ae2-a6cc-aedf81e621b8">


<img width="861" alt="Screenshot 2024-03-22 at 8 26 55 PM" src="https://github.com/Hamzenium/Library-Management-System-Project/assets/67511980/ba7fafa1-ce54-4da3-ba69-c1e2bc177018">


<img width="432" alt="Screenshot 2024-03-22 at 8 27 22 PM" src="https://github.com/Hamzenium/Library-Management-System-Project/assets/67511980/e3b7fba8-e120-43b2-86d8-3e255acb3268">


## Setup and Usage

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
