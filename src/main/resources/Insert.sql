# -- Insert into Domains
# INSERT INTO domains (domain_id, program, batch, capacity, qualification) VALUES
#  (1, 'M.Tech CSE', 2024, 100, 'Bachelor\'s in CS'),
#  (2, 'M.Tech ECE', 2024, 80, 'Bachelor\'s in ECE'),
#  (3, 'iM.Tech CSE', 2024, 120, '10th and 12th'),
#  (4, 'MS', 2024, 90, 'Bachelor\'s in IT'),
#  (5, 'M.Tech Data Science', 2024, 50, 'Bachelor\'s in CS/IT'),
#  (6, 'iM.Tech AI', 2024, 100, 'Bachelor\'s in CS');
#
# -- Insert into Specialisation
# INSERT INTO specialisation (specialisation_id, code, name, description, year, credits_required) VALUES
#  (1, 'AI', 'Artificial Intelligence', 'Focus on ML, AI, and neural networks', 2024, 64),
#  (2, 'CN', 'Computer Networks', 'Networking protocols and security', 2024, 64),
#  (3, 'VLSI', 'VLSI Design', 'Focus on VLSI and embedded systems', 2024, 64),
#  (4, 'SE', 'Software Engineering', 'Focus on software development and methodologies', 2024, 48),
#  (5, 'TSCD', 'Theory of Software and Computing Data', 'Focus on software theories and data computation techniques', 2024, 48);
# -- Insert into Students
# INSERT INTO students (student_id, roll_number, first_name, last_name, email, cgpa, total_credits, graduation_year, photograph_path, domain_id, specialisation_id) VALUES
# (1, 'IMT2024001', 'John', 'Doe', 'john.doe@gmail.com', 3.5, 32, 2024, '/images/john_doe.jpg', 3, 5),
# (2, 'MS2024002', 'Jane', 'Smith', 'jane.smith@gmail.com', 3.1, 20, 2024, '/images/jane_smith.jpg', 4, 2),
# (3, 'IMT2024003', 'Alice', 'Johnson', 'alice.j@gmail.com', 3.8, 32, 2024, '/images/alice.jpg', 3, 4),
# (4, 'IMT2024004', 'Robert', 'Williams', 'robert.williams@gmail.com', 3.2, 158, 2024, '/images/robert.jpg', 6, 1),
# (5, 'MS2024005', 'Emily', 'Brown', 'emily.brown@gmail.com', 3.3, 24, 2024, '/images/emily.jpg', 4, 3),
# (6, 'MT2024006', 'Michael', 'Davis', 'michael.davis@gmail.com', 3.8, 30, 2024, '/images/michael.jpg', 1, 5),
# (7, 'MT2024019', 'Sophia', 'Lee', 'sophia.lee@gmail.com', 3.5, 20, 2024, '/images/sophia.jpg', 2, 3),
# (8, 'MT2024051', 'William', 'Harris', 'william.harris@gmail.com', 4.0, 20, 2024, '/images/william.jpg', 5, 1);
# -- Insert into Placement_Student
# INSERT INTO placement_student (id, placement_id, student_id, cv_application, about, acceptance, comments, date) VALUES
# (1, 101, 1, '/cv/john_doe.pdf', 'Skilled in AI and ML', TRUE, 'Great potential', '2024-12-01'),
# (2, 102, 2, '/cv/jane_smith.pdf', 'Expert in computer vision', FALSE, 'Awaiting decision', '2024-12-02'),
# (3, 103, 3, '/cv/alice_johnson.pdf', 'Strong VLSI background', FALSE, 'Improve coding', '2024-12-03'),
# (4, 104, 4, '/cv/robert_williams.pdf', 'Skilled in Data Science', FALSE, 'Great potential', '2024-12-05'),
# (5, 105, 5, '/cv/emily_brown.pdf', 'Expert in Cybersecurity', TRUE, 'Good communication', '2024-12-06'),
# (6, 106, 6, '/cv/michael_davis.pdf', 'Skilled in Full-stack Dev', TRUE, 'Strong coding skills', '2024-12-07'),
# (7, 107, 7, '/cv/sophia_lee.pdf', 'Skilled in Software Dev', FALSE, 'Needs experience', '2024-12-08'),
# (8, 108, 8, '/cv/william_harris.pdf', 'Focus on AI Development', TRUE, 'Highly technical', '2024-12-09');

INSERT INTO education_details (student_id, school_12th_name, school_12th_percentage, school_10th_name, school_10th_percentage, btech_college_name, btech_college_cgpa)
VALUES
    (1, 'Springfield High School', 92.5, 'Greenwood Academy', 88.4, 'IIT Delhi', 8.7),
    (2, 'St. Paul\'s High School', 89.3, 'Oxford High', 91.2, 'MIT', 8.1),
    (3, 'Riverside High School', 94.6, 'Hillside Academy', 87.5, 'NIT Trichy', 8.9),
    (4, 'Bright Future School', 85.0, 'Central High', 84.3, 'BITS Pilani', 8.4),
    (5, 'Modern Public School', 90.2, 'City Convent School', 89.7, 'IIT Kanpur', 8.3),
    (6, 'Hilltop High School', 93.4, 'Sunrise Academy', 90.5, 'IIT Madras', 9.0),
    (7, 'Star Academy', 88.7, 'Elite High School', 86.9, 'IIT Bombay', 8.5),
    (8, 'Heritage School', 91.8, 'Crescent Public School', 90.2, 'NIT Warangal', 9.3);
