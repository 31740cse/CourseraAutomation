# 🚀 Hackathon Idea: Automated Course Identification & Validation

## 📌 Problem Statement: Identify Courses

The goal is to **automate the process of identifying beginner-friendly Web Development courses** and explore other features on an e-learning platform (e.g., [Coursera.org](https://www.coursera.org)).

### 🎯 Tasks

1. **Search & Display Courses**
   - Search for **Web Development** courses.  
   - Apply filters:
     - Beginner level  
     - English language  
   - Extract and display details of the **first two courses**:
     - Course Name  
     - Total Learning Hours  
     - Rating  

2. **Language Learning Section**
   - Navigate to the **Language Learning** category.  
   - Extract:
     - All available languages  
     - Different levels (Beginner, Intermediate, Advanced, etc.)  
     - **Total count** of courses for each combination.  

3. **Form Validation – "For Enterprise"**
   - From **Home Page**, go to:  
     `For Enterprise → Campus → Products`  
   - Scroll to the **"Ready to Transform"** form.  
   - Fill the form with at least **one invalid input** (e.g., incorrect email format).  
   - **Capture and display the error/warning message.**  

---

## 🔑 Key Automation Scope

This problem covers essential Selenium/Web Automation concepts:

- ✅ Handling **multiple browser windows/tabs**  
- ✅ Using **search options** and applying filters  
- ✅ Extracting **multiple dropdown list items** & storing them in collections  
- ✅ Navigating back to **Home Page**  
- ✅ Filling forms (with different objects: text fields, dropdowns, checkboxes)  
- ✅ Capturing **warning/error messages**  
- ✅ Scrolling down a web page  

---

## 🛠️ Suggested Tools & Tech Stack

- **Language**: Java / Python / C# (any)  
- **Framework**: Selenium WebDriver / Playwright  
- **Test Runner**: JUnit / TestNG / PyTest  
- **Reporting**: Extent Reports / Allure  

---

## 📂 Expected Output

1. **First 2 Web Development Courses (Beginner, English)**  
   - Course Name  
   - Total Hours  
   - Rating  

2. **Language Learning Section**  
   - List of languages  
   - Levels per language  
   - Total course count  

3. **Form Validation**  
   - Captured error message for invalid input  

---
