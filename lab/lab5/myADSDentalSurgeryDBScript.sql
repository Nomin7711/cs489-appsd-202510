USE asd;
-- surgeries
CREATE TABLE surgery (
                         surgeryId INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100),
                         address VARCHAR(200),
                         telephone VARCHAR(20)
);

-- appointments
CREATE TABLE appointment (
                             appointmentId INT AUTO_INCREMENT PRIMARY KEY,
                             appointmentdate DATE,
                             appointmenttime TIME,
                             status VARCHAR(20),
                             dentistId INT,
                             patientId INT,
                             surgeryId INT,
                             FOREIGN KEY (dentistId) REFERENCES dentist(dentistId),
                             FOREIGN KEY (patientId) REFERENCES patient(patientId),
                             FOREIGN KEY (surgeryId) REFERENCES surgery(surgeryId)
);

-- bills
CREATE TABLE bill (
                      billId INT AUTO_INCREMENT PRIMARY KEY,
                      appointmentId INT,
                      amount DECIMAL(10,2),
                      paymentstatus VARCHAR(20),
                      issueddate DATE,
                      FOREIGN KEY (appointmentId) REFERENCES appointment(appointmentId)
);

USE asd;

-- Dentists
INSERT INTO dentist (firstname, lastname, contactphone, email, specialization)
VALUES
    ('Tony', 'Smith', '555-1111', 'tony.smith@example.com', 'Orthodontist'),
    ('Helen', 'Pearson', '555-2222', 'helen.pearson@example.com', 'Periodontist'),
    ('Robin', 'Plevin', '555-3333', 'robin.plevin@example.com', 'Endodontist');
-- Patients
INSERT INTO patient (firstname, lastname, contactphone, email, mailingaddress, dateofbirth, hasunpaidbill)
VALUES
    ('Gillian', 'White', '555-4444', 'gillian.white@gmail.com', '12 Maple St', '1988-03-21', FALSE),
    ('Jill', 'Bell', '555-5555', 'jill.bell@gmail.com', '34 Oak Ave', '1992-07-15', TRUE),
    ('Ian', 'MacKay', '555-6666', 'ian.mackay@gmail.com', '56 Pine Rd', '1985-12-01', FALSE),
    ('John', 'Walker', '555-7777', 'john.walker@gmail.com', '78 Cedar Blvd', '1990-05-10', FALSE);
-- Surgeries
INSERT INTO surgery (name, address, telephone)
VALUES
    ('Central Dental', '101 Center St', '555-8888'),
    ('Eastside Dental', '202 East Rd', '555-9999');
INSERT INTO appointment (appointmentdate, appointmenttime, status, dentistid, patientid, surgeryid)
VALUES
    ('2025-10-10', '09:00:00', 'Scheduled', 1, 1, 1), -- Tony Smith sees Gillian White
    ('2025-10-11', '11:00:00', 'Scheduled', 1, 2, 2), -- Tony Smith sees Jill Bell
    ('2025-10-12', '14:00:00', 'Completed', 2, 3, 1), -- Helen Pearson sees Ian MacKay
    ('2025-10-13', '10:00:00', 'Scheduled', 3, 4, 2); -- Robin Plevin sees John Walker
-- Bills
INSERT INTO bill (appointmentid, amount, paymentstatus, issueddate)
VALUES
    (1, 200.00, 'Paid', '2025-10-10'),
    (2, 150.00, 'Unpaid', '2025-10-11'),
    (3, 300.00, 'Paid', '2025-10-12'),
    (4, 180.00, 'Unpaid', '2025-10-13');


# Display the list of ALL Dentists registered in the system, sorted in ascending order of their lastNames
select * from dentist order by lastname asc;
# Display the list of ALL Appointments for a given Dentist by their dentist_Id number. Include in the result, the Patient information.
select d.dentistId, d.lastname, d.firstname, d.specialization, a.appointmentdate, a.appointmenttime from appointment a join asd.dentist d on d.dentistId = a.dentistId;
# Display the list of ALL Appointments that have been scheduled at a Surgery Location
select s.name, s.telephone, a.appointmentdate, a.appointmenttime, a.status from appointment a join asd.surgery s on s.surgeryId = a.surgeryId;
# Display the list of the Appointments booked for a given Patient on a given Date.
select p.firstname, p.lastname, p.email, a.appointmentdate, a.appointmenttime, a.status from appointment a join patient p on p.patientId = a.patientId where appointmentdate='2025-10-12';
