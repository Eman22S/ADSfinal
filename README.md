# 🦷 Dental Appointments Management System
This is a Spring Boot RESTful API designed for managing dental clinic operations. It allows clinics to manage Patients, Dentists, Appointments, and Bills efficiently. The system provides secure authentication, detailed search capabilities, and a clean data model using Spring Data JPA. The application is containerized using Docker and uses MySQL as the relational database.

## 🖼️ SCREENSHOTS

### 🔐 Auth with Bearer Token
![Auth Bearer](screenshots/auth_bearer.png)
### 📋 Get Appointments
![Get Appointments](screenshots/get_appointment.png)
### ❌ Access Denied (Unauthorized)
![Access Denied](screenshots/get_appointment_denied.png)

### ➕ Create Appointment
![Create Appointment](screenshots/create_appointment_success.png)

### ➕ Create Dentist
![Create Dentist](screenshots/create_dentist.png)


### 🔍 Get Dentist by ID
![Get Dentist by ID](screenshots/get_dentist_id.png)

### 🔎 Search Patient by Last Name
![Search Patient](screenshots/search_patientby_lastname.png)


# API Documentation

## Patients

### GET `/api/patients`
Retrieve all patients.

### GET `/api/patients/{id}`
Retrieve a patient by ID.

### POST `/api/patients`
Create a new patient.

#### Request Body
```json
{
  "firstName": "Sara",
  "lastName": "Yared",
  "email": "sara.yared@example.com",
  "phone": "+251912345678",
  "address": "Bole, Addis Ababa",
  "dob": "1990-06-15",
  "patientNo": "P12345"
}
```

### PUT `/api/patients/{id}`
Update an existing patient.

### DELETE `/api/patients/{id}`
Delete a patient by ID.

### GET `/patient/search/{searchString}`
Search patients by a search string (e.g., name).

---

## Dentists

### GET `/api/dentists`
Retrieve all dentists.

### GET `/api/dentists/{dentist_id}`
Retrieve a dentist by ID.

### POST `/api/dentists`
Create a new dentist.

#### Request Body
```json
{
  "firstName": "Dr. Naomi",
  "lastName": "Bekele",
  "email": "naomi.bekele@clinic.com",
  "phone": "+251911223344",
  "specialization": "Orthodontics"
}
```

### DELETE `/api/dentists/{dentist_id}`
Delete a dentist by ID.

---

## Appointments

### GET `/api/appointments`
Retrieve all appointments.

### POST `/api/appointments`
Create a new appointment.

#### Request Body
```json
{
  "dentistId": 1,
  "patientId": 1,
  "surgeryId": 1,
  "appointmentDate": "2025-04-28",
  "appointmentTime": "14:30",
  "status": "Scheduled"
}
```

---

## Bills

### GET `/api/bills/patient/{patientId}`
Retrieve all bills associated with a specific patient.

---

## Authentication

### POST `/api/auth/login`
Login endpoint to obtain JWT.

#### Request Body
```json
{
  "username": "admin",
  "password": "admin"
}
```

