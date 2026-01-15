# java-train-reservation-backend
A Java-based Command Line Interface (CLI) application for train ticket bookings. Features include user authentication with BCrypt password hashing, train searching by route, and real-time seat selection. Data is persisted using JSON files managed via the Jackson library. Built with Gradle.
IRCTC Ticket Booking System (CLI)
A Java-based Command Line Interface (CLI) application designed to simulate a train reservation system. This project demonstrates core Java concepts, file-based data persistence, and secure user authentication.

🚀 Features
Secure User Authentication: Handles user sign-up and login with password encryption using BCrypt.

Train Search: Find available trains by entering source and destination stations.

Seat Booking: Interactive seat selection using a matrix system (Rows/Columns).

Booking Management: Users can fetch their existing bookings or cancel a specific ticket by its ID.

Data Persistence: All user and train data is stored and managed via local JSON files using the Jackson library.

🛠️ Tech Stack
Language: Java

Build Tool: Gradle

Libraries:

Jackson Databind: For JSON parsing and object mapping.

jBCrypt: For secure password hashing.

Google Guava: For optimized collection handling.

📂 Project Structure
ticket.booking.entities: Contains data models like User, Train, and Ticket.

ticket.booking.services: Contains the core logic for user operations (UserBookingService) and train management (TrainService).

ticket.booking.util: Utility classes for password hashing.

ticket.booking.LocalDb: Storage location for users.json and trains.json.

⚙️ Setup and Installation
Clone the Repository:

git clone https://github.com/YOUR_USERNAME/irctc-ticket-booking-system.git
Update File Paths: Before running, update the USER_PATH in UserBookingService.java and TrainDbPath in TrainService.java to point to your local project directory.

Current configured path: D:\IRCTC\app\src\main\java\ticket\booking\LocalDb\.

Build the Project:

./gradlew build
Run the Application:



./gradlew run
