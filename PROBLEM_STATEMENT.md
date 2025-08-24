# 📌 Problem Statement: Coursera Automation

## 🎯 Objective
Automate the process of identifying beginner-friendly Web Development courses, exploring Language Learning categories, and validating forms on Coursera (or a similar platform).

---

## 🔍 Detailed Description

### 1. Identify Courses
- Search for **Web Development courses**.  
- Apply filters:
  - **Beginner Level**  
  - **English Language**  
- Extract and display details of the **first two courses**:
  - Course Name  
  - Total Learning Hours  
  - Rating  

---

### 2. Explore Language Learning
- Navigate to **Language Learning**.  
- Extract:
  - All available languages  
  - Different levels (Beginner, Intermediate, Advanced, etc.)  
  - **Total course count** for each combination  

---

### 3. Form Validation – For Enterprise
- From **Home Page**, go to:  
  `For Enterprise → Campus → Products`  
- Scroll to the **"Ready to Transform"** form.  
- Fill the form with at least **one invalid input** (e.g., incorrect email format).  
- **Capture and display the error/warning message.**  

---

## 🔑 Key Automation Scope

- Handling **multiple browser windows**  
- Using **search options** and applying filters  
- Extracting **multiple dropdown items** into collections  
- Navigating back to **Home Page**  
- Filling forms (text fields, dropdowns, checkboxes)  
- Capturing **warning/error messages**  
- Scrolling web pages  

---

## 🛠️ Suggested Tools

- **Language:** Java  
- **Automation Framework:** Selenium WebDriver  
- **Testing Framework:** TestNG  
- **Build Tool:** Maven  
- **IDE:** Eclipse / VS Code  
