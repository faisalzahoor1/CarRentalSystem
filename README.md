Rental System
The RentalSystem Java class is a simple car rental system allowing users to perform various actions like renting cars, returning cars, handling complaints, and administrative tasks.

Functionality Overview
Features
Adding and Deleting Cars

Admin-exclusive functionalities for adding and deleting cars from the system.
User Authentication

Validates usernames and passwords provided by the admin.
Customer Menu

Allows customers to:
View available cars.
Rent a car.
Return a rented car.
Exit the system.
Complaint Portal

Permits users to submit queries or complaints. Stores the submissions in a file named "Complains.txt".
Admin Portal

Provides access to admin functionalities, including:
Adding cars to the system.
Deleting cars from the system.
Code Structure
Attributes
isCarAvailable: Tracks the availability status of cars.
Cost: Stores the base cost per day for each car.
Cars: Maintains a list of available cars.
Methods
AddCars(): Adds cars to the system with details like name, availability, and base cost per day.
DeleteCars(): Deletes cars from the system based on provided car ID.
isUsernameValid(String username): Validates the username based on specific criteria.
isPasswordValid(String password): Validates the password based on specific criteria.
CustomerMenu(): Displays a menu for customers to interact with the system.
Complain(): Allows users to submit complaints or suggestions and stores them in a file.
Admin(): Provides access to admin functionalities like adding or deleting cars.
AvailableCars(): Displays available cars with their respective costs per day.
RentACar(): Facilitates the process of renting a car.
ReturnCar(): Handles the return of a rented car.
main(String[] args): The main entry point presenting the main menu for users to select options.
Usage
To use the system:

Run the Java application.
Choose options from the displayed menus:
Customers can access the customer menu.
Users can submit complaints.
Admins can access the admin portal.
This document provides an overview of the functionalities and structure of the RentalSystem Java class. It explains the available features and how users (customers and admins) can interact with the system.

Please feel free to further elaborate or customize this Markdown document based on your specific needs or additional information you wish to include.














