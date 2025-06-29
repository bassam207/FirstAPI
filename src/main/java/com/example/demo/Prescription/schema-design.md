# Smart Clinic Schema Design

## PostgreSQL Database Design

### Table: patients
- id: SERIAL PRIMARY KEY
- name: VARCHAR(100) NOT NULL
- age: INTEGER
- gender: VARCHAR(10)
- phone: BIGINT UNIQUE
- clinic_id: INTEGER REFERENCES clinics(id)
- registered_at: TIMESTAMP DEFAULT CURRENT_TIMESTAMP

### Table: doctors
- id: SERIAL PRIMARY KEY
- name: VARCHAR(100) NOT NULL
- speciality: VARCHAR(100)
- phone: BIGINT UNIQUE

### Table: clinics
- id: SERIAL PRIMARY KEY
- name: VARCHAR(100) NOT NULL

### Table: appointments
- id: SERIAL PRIMARY KEY
- date: DATE NOT NULL
- time: TIME NOT NULL
- doctor_id: INTEGER REFERENCES doctors(id) ON DELETE CASCADE
- patient_id: INTEGER REFERENCES patients(id) ON DELETE CASCADE
- status: INTEGER DEFAULT 0 -- 0 = Scheduled, 1 = Completed, 2 = Cancelled

### Table: patient_bio
- id: SERIAL PRIMARY KEY
- patient_id: INTEGER UNIQUE REFERENCES patients(id)
- weight: DECIMAL(5,2)
- height: DECIMAL(5,2)
- blood_type: VARCHAR(5)

### Table: prescriptions
- id: SERIAL PRIMARY KEY
- appointment_id: INTEGER REFERENCES appointments(id)

### Table: medications
- id: SERIAL PRIMARY KEY
- name: VARCHAR(100) NOT NULL
- form: VARCHAR(50)
- strength: VARCHAR(50)

### Table: prescribed_medications
- id: SERIAL PRIMARY KEY
- prescription_id: INTEGER REFERENCES prescriptions(id)
- medication_id: INTEGER REFERENCES medications(id)
- dosage: VARCHAR(100)
- frequency: VARCHAR(100)
- duration: VARCHAR(50)

---

## MongoDB Collection Design

### Collection: doctor_notes

```json
{
  "_id": "ObjectId('66b123abc')",
  "appointmentId": 101,
  "doctorId": 5,
  "patientId": 12,
  "note": "Patient has mild fever. Advise Paracetamol 500mg for 5 days.",
  "createdAt": "2025-06-20T12:00:00"
}
{
  "_id": "ObjectId('66b456def')",
  "appointmentId": 101,
  "patientId": 12,
  "doctorId": 5,
  "rating": 4.5,
  "comments": "Doctor was professional and kind.",
  "submittedAt": "2025-06-20T13:00:00"
}
{
  "_id": "ObjectId('66b789ghi')",
  "senderId": 12,
  "receiverId": 5,
  "senderRole": "patient",
  "message": "Can I take this medicine after food?",
  "sentAt": "2025-06-20T14:00:00"
}
