# AutoHub - Car Showroom Management System

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](./LICENSE)

## 🚗 Overview

**AutoHub** is a comprehensive Car Showroom Management System designed to streamline operations for car dealerships and showrooms. The system provides a robust platform for managing vehicle inventory, showroom operations, employee management, and customer interactions across multiple locations.

### Key Features

- **Multi-Role Access Control**: Separate interfaces for Admins and Users (Managers/Employees)
- **Real-time Inventory Management**: Add, update, delete, and view car inventory across multiple showrooms
- **Employee & Manager Management**: Comprehensive staff management with role-based permissions
- **Showroom Operations**: Multi-location support with detailed showroom management
- **Data Persistence**: Secure binary file system with automatic database synchronization
- **Cross-Platform Database Management**: Custom `.dbm` file system for seamless data portability

## 🏗️ System Architecture

### Database Schema

The system utilizes a relational database structure with the following core tables:

- **Cars**: Vehicle inventory with specifications and pricing
- **Showrooms**: Location and ownership details
- **Managers**: Management staff information and assignments
- **Employees**: Staff details and departmental assignments
- **Divisions**: Organizational departments
- **Availability**: Car-to-showroom availability mapping

### File System Structure

```
AutoHub/
├── src/
│   ├── classes/           # Java class files
│   ├── *.dbm             # Database Manager files
│   ├── *.adm             # Admin Manager files
│   └── *.usrm            # User Manager files
├── admins/               # Admin account files (.ad)
├── users/                # User account files (.usr)
└── images/               # Vehicle image galleries
    └── <CAR_ID>_<CAR_NAME>/
```

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK)** 8 or higher
- **MySQL Server** 8.0 or higher
- **IntelliJ IDEA** (recommended IDE)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Lionel-Logan/AutoHub.git
   cd AutoHub
   ```

2. **Set up MySQL Database**
   - Install MySQL Server
   - Create a new database for the application
   - Ensure MySQL service is running

3. **Configure Database Connection**
   - Update database connection parameters in the configuration files
   - Set up appropriate user privileges

4. **Build and Run**
   ```bash
   # Using IntelliJ IDEA
   # Open the project in IntelliJ IDEA
   # Build the project (Ctrl+F9)
   # Run the main application class
   ```

## 💼 User Roles & Permissions

### Admin Capabilities
- **Inventory Management**: Full CRUD operations on vehicle inventory
- **Staff Management**: Hire, manage, and remove employees and managers
- **Showroom Operations**: Create and manage multiple showroom locations
- **System Administration**: Database management and account oversight
- **Reporting**: Comprehensive system reports and analytics

### Manager/Employee Capabilities
- **Inventory Viewing**: Browse available vehicles and specifications
- **Staff Overview**: View team members and organizational structure
- **Account Management**: Personal account settings and preferences
- **Showroom-Specific Access**: Role-based access to relevant showroom data

## 🔧 Technical Features

### Security & Data Management
- **Binary File Encryption**: All data files are binary-encoded for enhanced security
- **Automatic Synchronization**: Database state management across multiple machines
- **Session Management**: Secure login/logout with credential validation
- **Data Integrity**: Comprehensive validation and error handling

### Performance Optimizations
- **Efficient Query Processing**: Optimized SQL query generation and execution
- **Memory Management**: Smart object lifecycle management
- **Caching Strategy**: Intelligent data caching for improved response times

## 📊 Database Management System

### Custom .dbm Files
AutoHub implements a proprietary Database Manager file system:
- **Portability**: Transfer database state between different machines
- **Version Control**: Track all database operations chronologically
- **Reliability**: Automatic database reconstruction and validation
- **Offline Capability**: Full functionality without cloud dependencies

## 🛠️ Development Guidelines

### Code Standards
- **Naming Conventions**: 
  - Functions: `camelCase` (e.g., `writeToFile`)
  - Variables: `PascalCase` (e.g., `FileName`, `EmployeeName`)
  - Classes: `PascalCase` with descriptive names
- **Documentation**: Comprehensive inline comments for all functions
- **Error Handling**: Robust exception handling throughout the application

### Architecture Patterns
- **Object-Oriented Design**: Clean separation of concerns with dedicated classes
- **MVC Pattern**: Clear separation between data, business logic, and presentation
- **Factory Pattern**: Efficient object creation and management

## 📁 Core Classes

| Class | Purpose |
|-------|---------|
| `Admin` | Admin user account management |
| `User` | Employee/Manager account handling |
| `DatabaseManager` | Database operations and .dbm file management |
| `Car` | Vehicle data model |
| `Showroom` | Showroom location management |
| `Employee` | Staff member data model |
| `Manager` | Management staff data model |

## 🚀 Key Functionalities

### For Administrators
- **Vehicle Management**: Add, update, delete vehicles with image gallery support
- **Inventory Control**: Track vehicle availability across all showrooms
- **Staff Administration**: Complete employee lifecycle management
- **Business Intelligence**: Comprehensive reporting and analytics
- **System Maintenance**: Database optimization and maintenance tools

### For Users
- **Inventory Browse**: Search and view available vehicles
- **Team Management**: View and manage team members (Manager role)
- **Personal Dashboard**: Account management and preferences
- **Reporting**: Generate relevant reports within scope of access

## 🔒 Security Features

- **Role-Based Access Control**: Granular permissions based on user roles
- **Binary File Encryption**: Secure storage of sensitive data
- **Session Management**: Secure authentication and session handling
- **Data Validation**: Comprehensive input validation and sanitization

## 📈 Future Enhancements

- **Web Interface**: Browser-based access for enhanced accessibility
- **Mobile Application**: iOS and Android companion apps
- **API Integration**: RESTful API for third-party integrations
- **Advanced Analytics**: Business intelligence and predictive analytics
- **Cloud Synchronization**: Multi-location cloud-based data synchronization'

## Screenshots

<img width="400" height="600" alt="Screenshot 2024-10-07 001657" src="https://github.com/user-attachments/assets/c55ab095-a332-4f44-a17f-90b3dfa43877" />
<img width="400" height="600" alt="Authentication ss" src="https://github.com/user-attachments/assets/389ad569-7762-48e8-8559-13cde64e6958" />

<img width="1351" height="858" alt="Screenshot 2024-10-07 012208" src="https://github.com/user-attachments/assets/ca689eb0-38ed-4ea4-86a4-c22a2dcd9961" />
<img width="1350" height="862" alt="Screenshot 2024-10-07 012314" src="https://github.com/user-attachments/assets/8dbf207d-02ef-45a0-b50a-ff5022dadb9c" />
<img width="1350" height="862" alt="Dashboard ss" src="https://github.com/user-attachments/assets/a423ad2d-9ee4-413f-97cf-5d508796ba67" />

## 📞 Support

For support, feature requests, or bug reports:
- Create an issue on GitHub
- Contact the development team

## 🏆 Acknowledgments

- Appreciation for the open-source community for continuous inspiration

---

**AutoHub** - Revolutionizing Car Showroom Management, One Feature at a Time 🚗✨
