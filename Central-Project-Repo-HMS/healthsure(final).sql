drop database if exists healthsure;

create database healthsure;
use healthsure;
-- provider operations (Abhishek Narayan)
-- Table: providers
CREATE TABLE Providers (
    provider_id VARCHAR(20) PRIMARY KEY ,
    provider_name VARCHAR(100) NOT NULL,
    hospital_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    address VARCHAR(225) NOT NULL,
    city VARCHAR(225) NOT NULL,
    state VARCHAR(225)NOT NULL,   
    zip_code VARCHAR(225)NOT NULL,
    status ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
 
-- Table: doctors
CREATE TABLE Doctors (
    doctor_id VARCHAR(20) PRIMARY KEY ,
    provider_id VARCHAR(20),
    doctor_name VARCHAR(100) NOT NULL,
    qualification VARCHAR(255),
    specialization VARCHAR(100),
    license_no VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    address VARCHAR(225) NOT NULL,
    gender VARCHAR(10),
    password VARCHAR(255) NOT NULL,
    login_status ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING',
    doctor_status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'INACTIVE',
    FOREIGN KEY (provider_id) REFERENCES Providers(provider_id)
);
 
-- Table: accounts
CREATE TABLE Accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    provider_id VARCHAR(20),
    bank_name VARCHAR(100),
    ifsc_code VARCHAR(11),
    account_number VARCHAR(20),
    FOREIGN KEY (provider_id) REFERENCES Providers(provider_id)
);
 
-- Table: otp_logs (provider-Abhisekh)
CREATE TABLE Otp_logs (
    otp_id INT PRIMARY KEY AUTO_INCREMENT,
    user_type ENUM('PROVIDER', 'RECIPIENT', 'PHARMACY', 'ADMIN'),
    otp_code VARCHAR(10) NOT NULL,
    is_used BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- Table: user_password_reset (provider-Abhisekh)
CREATE TABLE Provider_password (
    reset_id INT PRIMARY KEY AUTO_INCREMENT,
    provider_id VARCHAR(20) NOT NULL,
    old_password VARCHAR(255),
    new_password VARCHAR(255),
    reset_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (provider_id) REFERENCES Providers(provider_id) 
);

-- ......................................................................................................
-- Table: doctor_availability (provider-Satya)
CREATE TABLE Doctor_availability (
    availability_id VARCHAR(36) PRIMARY KEY,
    doctor_id VARCHAR(36) NOT NULL,
    available_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    slot_type ENUM('STANDARD', 'ADHOC') DEFAULT 'STANDARD',
    max_capacity INT NOT NULL DEFAULT 15,
    is_recurring BOOLEAN DEFAULT FALSE,
    notes VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id)
);

-- ................................................................................................
-- Recepient (Sulekha Mishra)
-- Create Recipient table
CREATE TABLE Recipient (
    h_id VARCHAR(20) PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    mobile VARCHAR(10) UNIQUE NOT NULL,
    user_name VARCHAR(100) UNIQUE NOT NULL,
    gender ENUM('MALE', 'FEMALE') NOT NULL,
    dob DATE NOT NULL,
    address VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    status ENUM('ACTIVE', 'INACTIVE', 'BLOCKED') DEFAULT 'ACTIVE',
    login_attempts INT DEFAULT 0,                        -- for blocking after failed attempts
    locked_until DATETIME DEFAULT NULL,                 -- temporary lock after multiple failures
    last_login DATETIME DEFAULT NULL,                   -- store last successful login
    password_updated_at DATETIME DEFAULT CURRENT_TIMESTAMP -- for password expiry check
);

-- Create Otp table
CREATE TABLE Otp (
    otp_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(100) UNIQUE NOT NULL,
    otp_code INT NOT NULL,                              -- OTP number as integer
    new_password VARCHAR(255),                          -- optional: for password reset
    status ENUM('PENDING', 'VERIFIED', 'EXPIRED') DEFAULT 'PENDING',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    expires_at DATETIME NOT NULL,
	purpose ENUM('REGISTER','FORGOT_PASSWORD') NOT NULL,
    -- Link to Recipient table
    CONSTRAINT FOREIGN KEY (user_name) REFERENCES Recipient(user_name) ON DELETE CASCADE
);

-- ..............................................................................................................
-- Table: appointment (provider-Sandhan)

CREATE TABLE Appointment (
    appointment_id VARCHAR(36) PRIMARY KEY,
    doctor_id VARCHAR(36) NOT NULL,
    h_id VARCHAR(36) NOT NULL,
    availability_id VARCHAR(36) NOT NULL,
    provider_id VARCHAR(36) NOT NULL,
    requested_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    booked_at TIMESTAMP NULL,
    status ENUM('PENDING', 'BOOKED', 'CANCELLED', 'COMPLETED') DEFAULT 'PENDING',
    notes TEXT,
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
    FOREIGN KEY (h_id) REFERENCES Recipient(h_id),
    FOREIGN KEY (availability_id) REFERENCES doctor_availability(availability_id),
    FOREIGN KEY (provider_id) REFERENCES providers(provider_id)
);
-- ........................................................................................................

-- procedure and prescription ( nirmalya satapathy )

CREATE TABLE medical_procedure (									
    procedure_id      VARCHAR(20) PRIMARY KEY,
    appointment_id    VARCHAR(20) NOT NULL,
    h_id         VARCHAR(20) NOT NULL,
    provider_id       VARCHAR(20) NOT NULL,
    doctor_id 		 VARCHAR(20) NOT NULL,
    procedure_date   DATE NOT NULL,
    diagnosis        TEXT NOT NULL,
    recommendations  TEXT,
    from_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    to_date       TIMESTAMP ,
    created_at		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (appointment_id) REFERENCES appointment(appointment_id),
    FOREIGN KEY (h_id) REFERENCES recipient(h_id),
	FOREIGN KEY (provider_id) REFERENCES Providers(provider_id),
	FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id)
);

CREATE TABLE procedure_test (
    test_id         VARCHAR(20) PRIMARY KEY,
    procedure_id    VARCHAR(20) NOT NULL,
    test_name       VARCHAR(100) NOT NULL,
    test_date       DATE NOT NULL,
    result_summary  TEXT,
    status          VARCHAR(50) DEFAULT 'Completed',
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (procedure_id) REFERENCES medical_procedure(procedure_id)
);
 
CREATE TABLE prescription (
    prescription_id  VARCHAR(20) PRIMARY KEY,
    procedure_id      VARCHAR(20) NOT NULL,
    h_id         VARCHAR(20) NOT NULL,
    provider_id       VARCHAR(20) NOT NULL,
	doctor_id 		 VARCHAR(20) NOT NULL,
    medicine_name     VARCHAR(255) NOT NULL,
    dosage            VARCHAR(100),
    duration          VARCHAR(100),
    notes             TEXT,
	written_on		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (procedure_id) REFERENCES medical_procedure(procedure_id),
	FOREIGN KEY (h_id) REFERENCES recipient(h_id),
	FOREIGN KEY (provider_id) REFERENCES Providers(provider_id),
	FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id)
);


-- .............................................................................................................
-- pharmacy management (Anantha kumar Swain)
CREATE TABLE Pharmacy (
    pharmacy_id VARCHAR(10) PRIMARY KEY,
    pharmacy_name VARCHAR(100) NOT NULL,
    contact_no VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(45) NOT NULL,
    created_at DATE NOT NULL,
    state VARCHAR(50) NOT NULL,
    city VARCHAR(100) NOT NULL,
    license_no VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL
);
 
CREATE TABLE Medicines (
    medicine_id VARCHAR(10) PRIMARY KEY,
    medicine_name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    quantity_in_stock INT NOT NULL,
    expiry_date DATE NOT NULL,
    unit_price DOUBLE NOT NULL,
    pharmacy_id VARCHAR(10) NOT NULL,
    purpose VARCHAR(100) NOT NULL,
    batch_no VARCHAR(20) NOT NULL,
    FOREIGN KEY (pharmacy_id) REFERENCES Pharmacy(pharmacy_id)
);
 
CREATE TABLE Pharmacists (
    pharmacist_id VARCHAR(10) PRIMARY KEY,
    pharmacist_name VARCHAR(100) NOT NULL,
    phone_no VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    pharmacy_id VARCHAR(10) NOT NULL,
    FOREIGN KEY (pharmacy_id) REFERENCES Pharmacy(pharmacy_id)
);
 
CREATE TABLE Dispensed_Medicines (
    dispense_id VARCHAR(10) PRIMARY KEY,
    medicine_id VARCHAR(10) NOT NULL,
    quantity_dispensed INT NOT NULL,
    dispense_date DATE NOT NULL,
    prescription_id varchar(10) Not Null,
    doctor_id VARCHAR(10) NOT NULL,
    h_id VARCHAR(10) NOT NULL,
    pharmacist_id VARCHAR(10) NOT NULL,
    pharmacy_id VARCHAR(10) NOT NULL,
    FOREIGN KEY (prescription_id) REFERENCES prescription(prescription_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id),
    FOREIGN KEY (h_id) REFERENCES Recipient(h_id),
    FOREIGN KEY (medicine_id) REFERENCES Medicines(medicine_id),
    FOREIGN KEY (pharmacist_id) REFERENCES Pharmacists(pharmacist_id),
    FOREIGN KEY (pharmacy_id) REFERENCES Pharmacy(pharmacy_id)
);
 
CREATE TABLE Equipment (
    equipment_id VARCHAR(10) PRIMARY KEY,
    equipment_name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    unit_price DOUBLE NOT NULL,
    purpose VARCHAR(100) NOT NULL,
    purchase_date DATE NOT NULL,
    pharmacy_id VARCHAR(10) NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (pharmacy_id) REFERENCES Pharmacy(pharmacy_id)
);
 
CREATE TABLE Dispensed_Equipments (
    dispensed_equip_id VARCHAR(10) PRIMARY KEY,
    equipment_id VARCHAR(10) NOT NULL,
    quantity_dispensed INT NOT NULL,
    dispense_date DATE NOT NULL,
    prescription_id varchar(10) Not Null,
    doctor_id VARCHAR(10) NOT NULL,
    h_id VARCHAR(10) NOT NULL,
    pharmacist_id VARCHAR(10) NOT NULL,
    pharmacy_id VARCHAR(10) NOT NULL,
    FOREIGN KEY (prescription_id) REFERENCES prescription(prescription_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id),
    FOREIGN KEY (h_id) REFERENCES Recipient(h_id),
    FOREIGN KEY (equipment_id) REFERENCES Equipment(equipment_id),
    FOREIGN KEY (pharmacist_id) REFERENCES Pharmacists(pharmacist_id),
    FOREIGN KEY (pharmacy_id) REFERENCES Pharmacy(pharmacy_id)
);
 
CREATE TABLE Pharmacy_Otp (
    otp_id INT AUTO_INCREMENT PRIMARY KEY,
    pharmacy_id VARCHAR(20) NOT NULL,
    otp_code VARCHAR(6) NOT NULL,
    purpose ENUM('REGISTER', 'FORGOT_PASSWORD') NOT NULL,
    new_password VARCHAR(255),
    status ENUM('PENDING', 'VERIFIED', 'EXPIRED') NOT NULL DEFAULT 'PENDING',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    expires_at DATETIME NOT NULL,
    FOREIGN KEY (pharmacy_id) REFERENCES Pharmacy(pharmacy_id)
);
 
-- ........................................................................................................
-- insurance (Ravikant Turi)

CREATE TABLE Insurance_company (
    company_id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    logo_url VARCHAR(255),
    head_office VARCHAR(255),
    contact_email VARCHAR(100),
    contact_phone VARCHAR(20)
);
CREATE TABLE Insurance_plan (
    plan_id VARCHAR(50) PRIMARY KEY,
    company_id VARCHAR(50) NOT NULL,
    plan_name VARCHAR(100) NOT NULL,
    plan_type ENUM('SELF', 'FAMILY', 'SENIOR', 'CRITICAL_ILLNESS'),
 
    min_entry_age INT DEFAULT 18,
    max_entry_age INT DEFAULT 65,
 
    description TEXT,
    available_cover_amounts VARCHAR(100),
    waiting_period VARCHAR(50),
 
    created_on DATE DEFAULT '2025-06-01',
    expire_date DATE DEFAULT '2099-12-31',
    periodic_diseases ENUM('YES', 'NO'),
 
    FOREIGN KEY (company_id) REFERENCES Insurance_company(company_id)
);
CREATE TABLE Insurance_coverage_option (
    coverage_id VARCHAR(50) PRIMARY KEY,
    plan_id VARCHAR(50),
    premium_amount NUMERIC(9,2),
    coverage_amount NUMERIC(9,2),
    status VARCHAR(30) DEFAULT 'ACTIVE',
    FOREIGN KEY (plan_id) REFERENCES Insurance_plan(plan_id)
);

-- ....................................................................................................
-- Insurance Enrllment (Samikshya Panda)
CREATE TABLE subscribe (
    subscribe_id VARCHAR(50) PRIMARY KEY,
    h_id VARCHAR(50),
    coverage_id VARCHAR(50),
    subscribe_date DATE NOT NULL,
    expiry_date DATE NOT NULL,
    status ENUM('Active', 'Expired') NOT NULL,
    total_premium DECIMAL(10, 2) NOT NULL,
    amount_paid DECIMAL(10, 2) DEFAULT 0.00,
    FOREIGN KEY (h_id) REFERENCES Recipient(h_id),
    FOREIGN KEY (coverage_id) REFERENCES Insurance_coverage_option(coverage_id)
);
-- ........................................................................................................
-- Insurance claim (Harsh Kumar)

CREATE TABLE Claims (
    claim_id VARCHAR(20) PRIMARY KEY,
    coverage_id VARCHAR(20) NOT NULL,
    procedure_id VARCHAR(20) NOT NULL,
    provider_id VARCHAR(20) NOT NULL,                   
    h_id VARCHAR(20) NOT NULL,                      
	claim_status ENUM('PENDING', 'APPROVED', 'DENIED') DEFAULT 'PENDING',
    claim_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    amount_claimed DECIMAL(10, 2) NOT NULL,
    amount_approved DECIMAL(10, 2) DEFAULT 0.00,
	FOREIGN KEY (procedure_id) REFERENCES medical_procedure(procedure_id),
	FOREIGN KEY (provider_id) REFERENCES Providers(provider_id),
	FOREIGN KEY (h_id) REFERENCES Recipient(h_id),
	FOREIGN KEY (coverage_id) REFERENCES subscribe(coverage_id)
);
CREATE TABLE Claim_history(
	claim_history_id VARCHAR(20) PRIMARY KEY,
    claim_id VARCHAR(20),
    description VARCHAR(255),
    action_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (claim_id) REFERENCES Claims(claim_id)
);

-- ....................................................................................................
-- payment history(Premjeet Kumar)
CREATE TABLE Payment_history (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    h_id VARCHAR(20) NOT NULL,
    provider_id VARCHAR(20) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(50),
    payment_status ENUM('pending', 'completed', 'failed') DEFAULT 'pending',
    payment_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    remarks TEXT,
    -- Foreign key constraints (optional, depends on how you're storing doctor/hospital/dentist)
    FOREIGN KEY (h_id) REFERENCES Recipient(h_id),
    FOREIGN KEY (provider_id) REFERENCES Providers(provider_id) 
);