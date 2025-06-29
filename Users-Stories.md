# User Stories for Smart Clinic Management System

## 👨‍💼 Admin User Stories

### **Title:**

*As an admin, I want to add new doctors, so that they can use the system.*

**Acceptance Criteria:**

1. Admin can open a form to create a new doctor account.
2. The form requires name, email, specialty, and password.
3. Doctor appears in the doctors list after saving.

**Priority:** High
**Story Points:** 3
**Notes:**

* Must validate email uniqueness.

---

### **Title:**

*As an admin, I want to add new patients, so that they can book appointments.*

**Acceptance Criteria:**

1. Admin can open a form to create a new patient account.
2. The form requires name, gender, age, and phone.
3. Patient appears in the patients list after saving.

**Priority:** High
**Story Points:** 3
**Notes:**

* Phone number must be unique.

---

## 👨‍⚕️ Doctor User Stories

### **Title:**

*As a doctor, I want to view a patient’s medical file, so that I can understand their history.*

**Acceptance Criteria:**

1. Doctor logs in and selects a patient from a list.
2. System shows medical history, previous prescriptions, and complaints.
3. Doctor cannot view patients not assigned to them.

**Priority:** High
**Story Points:** 5

---

### **Title:**

*As a doctor, I want to add a prescription to a patient, so that I can treat their condition.*

**Acceptance Criteria:**

1. Doctor can open a form under the patient’s profile.
2. Form allows selection of medication, dosage, and duration.
3. Prescription is saved and linked to the patient.

**Priority:** High
**Story Points:** 4
**Notes:**

* Use auto-suggestion for medications.

---

### **Title:**

*As a doctor, I want to cancel my own appointment, so that I can manage my schedule.*

**Acceptance Criteria:**

1. Doctor views their upcoming appointments.
2. Doctor selects and cancels one.
3. Patient is notified automatically.

**Priority:** Medium
**Story Points:** 3

---

## 🧑‍⚕️ Patient User Stories

### **Title:**

*As a patient, I want to view my profile and medical history, so that I can stay informed.*

**Acceptance Criteria:**

1. Patient logs in and sees their personal information.
2. Patient can view all prescriptions, complaints, and past visits.
3. Data is read-only.

**Priority:** Medium
**Story Points:** 2

---

### **Title:**

*As a patient, I want to view and cancel my appointments, so that I can manage my schedule.*

**Acceptance Criteria:**

1. Patient logs in and sees upcoming appointments.
2. Patient can cancel any appointment at least 24 hours in advance.
3. Doctor is notified of the cancellation.

**Priority:** High
**Story Points:** 3
