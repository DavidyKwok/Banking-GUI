# Banking-GUI-Project
The Banking GUI Project is a system designed to allow the manager to create usernames and passwords for each customer and allows customers to login, deposit, withdraw, and make a purchase.

## Overview

The Banking GUI Project is designed to manage customer's bank accounts using Java and JavaFX. It allows different user roles to interact with the system in various ways:

- **Manager**: Can create and delete customers (Username: admin, Password: admin).
- **Customers**: Can withdraw, deposit and make a purchase of more than $50 with a fee depending on their level.


### Login Interface

![image](https://github.com/user-attachments/assets/409718e2-37cf-4107-8cd3-39d757b89ff7)


### Customer Management Interface

![image](https://github.com/user-attachments/assets/b3a4715d-8ad4-4922-a8ca-575c1a177d37)

## Features

- **Customer Account Management**:
  - Create new customer accounts.
  - Delete existing accounts.


### Customer Account Interface

![image](https://github.com/user-attachments/assets/d2afd5a8-4ed5-4403-b84a-687d02eec57e)



- **Level System**:
  - Customers with less than $10,000 in their account have an account level of silver which applies a fee of $20 on every purchase.
  - Customers with more than $10,000 but less than $20,000 in their account have an account level of gold which applies a fee of $10 on every purchase.
  - Customers with more than $20,000 in their account have an account level of platinum which doesn't have a fee on all purchases.

## Technologies Used

- **Java**: Core programming language used for development.
- **JavaFX**: Provides the graphical user interface (GUI) for the application.
