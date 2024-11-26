-- Create Students Table
CREATE TABLE students (
                          student_id INT PRIMARY KEY AUTO_INCREMENT,
                          roll_number VARCHAR(20) NOT NULL UNIQUE,
                          first_name VARCHAR(50) NOT NULL,
                          last_name VARCHAR(50) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          cgpa DECIMAL(3, 2),
                          total_credits INT,
                          graduation_year YEAR,
                          photograph_path VARCHAR(255)
);

-- Create Domains Table
CREATE TABLE domains (
                         domain_id INT PRIMARY KEY AUTO_INCREMENT,
                         program VARCHAR(50) NOT NULL,
                         batch VARCHAR(20) NOT NULL,
                         capacity INT NOT NULL,
                         qualification VARCHAR(100)
);

-- Create Specialisation Table
CREATE TABLE specialisation (
                                specialisation_id INT PRIMARY KEY AUTO_INCREMENT,
                                code VARCHAR(10) NOT NULL UNIQUE,
                                name VARCHAR(100) NOT NULL,
                                description TEXT,
                                year INT NOT NULL,
                                credits_required INT NOT NULL
);

-- Create Placement_Student Table
CREATE TABLE placement_student (
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   placement_id INT NOT NULL,
                                   student_id INT NOT NULL,
                                   cv_application TEXT,
                                   about TEXT,
                                   acceptance BOOLEAN DEFAULT FALSE,
                                   comments TEXT,
                                   date DATE NOT NULL
);

CREATE TABLE education_details (
                                   education_id INT PRIMARY KEY AUTO_INCREMENT,
                                   student_id INT NOT NULL,
                                   school_12th_name VARCHAR(255) NOT NULL,
                                   school_12th_percentage DECIMAL(5, 2) NOT NULL,
                                   school_10th_name VARCHAR(255) NOT NULL,
                                   school_10th_percentage DECIMAL(5, 2) NOT NULL,
                                   btech_college_name VARCHAR(255),
                                   btech_college_cgpa DECIMAL(3, 2),
                                   FOREIGN KEY (student_id) REFERENCES students(student_id)
);
