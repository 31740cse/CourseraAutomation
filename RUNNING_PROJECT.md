# ▶️ How to Run the Project

Follow these steps to run the **Selenium + TestNG + Maven automation project** in **VS Code** or **Eclipse**.

---

## 📌 Prerequisites
- **Java 17** installed and added to `PATH`
- **Maven** installed (`mvn -v` to verify)
- **VS Code** with the following extensions:
  - Java Extension Pack  
  - TestNG for VS Code  
  - Maven for Java  

---

## ⚡ Steps in VS Code

### 1. Open the Project
- Launch **VS Code**  
- Open the folder: `CoureraAutomation`  

📷 Screenshot:  
![Open Project in VS Code](<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/3cfe1578-2821-4d42-aca4-6613cd6c1fb2" />)

---

### 2. Expand Java Section
- In the **Explorer sidebar**, expand the **Java Projects** subsection  
- Locate your Maven project  

📷 Screenshot:  
![Expand Java Projects](<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/07eb3a95-d445-4b1b-bf76-6512f2218278" />)

---

### 3. Run the Tests
- Expand the `src/test/java` directory  
- Right-click on a test class or method  
- Select **Run Test** (or **Debug Test**)  

📷 Screenshot:  
![Run Tests](<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/5e587c6e-c776-43b0-b79c-711fb2c9cc27" />)

---

## ⚡ Alternative (Maven CLI)

You can also run the tests directly from the terminal:

```bash
mvn test
