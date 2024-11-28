-- Add foreign key to Students for domains
ALTER TABLE students
    ADD domain_id INT, -- Adds the new column

    ADD CONSTRAINT fk_students_domain -- Creates the foreign key constraint
        FOREIGN KEY (domain_id)
            REFERENCES domains(domain_id);


-- Add foreign key to Students for specialisation
ALTER TABLE students
    ADD specialisation_id INT, -- Adds the new column

    ADD CONSTRAINT fk_students_specialisation -- Creates the foreign key constraint
        FOREIGN KEY (specialisation_id)
            REFERENCES specialisation(specialisation_id);


-- Add foreign key to Students for placement
ALTER TABLE students
    ADD placement_id INT, -- Adds the new column

    ADD CONSTRAINT fk_students_placement -- Creates the foreign key constraint
        FOREIGN KEY (placement_id)
            REFERENCES placement_student(id);


-- Add foreign key to Placement_Student for student_id
ALTER TABLE placement_student
    ADD CONSTRAINT fk_placement_student
        FOREIGN KEY (student_id)
            REFERENCES students(student_id);

-- Adding a foreign key constraint to link student_id in education_details to student_id in students table
ALTER TABLE education_details
    ADD CONSTRAINT fk_student_id
        FOREIGN KEY (student_id)
            REFERENCES students(student_id);
