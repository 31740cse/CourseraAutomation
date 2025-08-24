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
![Open Project in VS Code](images/open_project.png)

---

### 2. Expand Java Section
- In the **Explorer sidebar**, expand the **Java Projects** subsection  
- Locate your Maven project  

📷 Screenshot:  
![Expand Java Projects](images/expand_java.png)

---

### 3. Run the Tests
- Expand the `src/test/java` directory  
- Right-click on a test class or method  
- Select **Run Test** (or **Debug Test**)  

📷 Screenshot:  
![Run Tests](images/run_tests.png)

---

## ⚡ Alternative (Maven CLI)

You can also run the tests directly from the terminal:

```bash
mvn test
