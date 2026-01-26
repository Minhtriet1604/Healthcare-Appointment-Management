CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE patients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_of_birth DATE,
    gender VARCHAR(50),
    medical_history TEXT,
    user_id BIGINT UNIQUE,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE doctors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    specialty VARCHAR(255),
    degree VARCHAR(255),
    work_schedule TEXT,
    user_id BIGINT UNIQUE,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE appointments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    appointment_time TIMESTAMP,
    status VARCHAR(50),
    doctor_id BIGINT NOT NULL,
    patient_id BIGINT NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES doctors(id),
    FOREIGN KEY (patient_id) REFERENCES patients(id)
);