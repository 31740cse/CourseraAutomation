# ▶️ How to Run the Project  

![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)  
![Maven](https://img.shields.io/badge/Maven-Build-orange?logo=apachemaven&logoColor=white)  
![Selenium](https://img.shields.io/badge/Selenium-Automation-green?logo=selenium&logoColor=white)  
![TestNG](https://img.shields.io/badge/TestNG-Testing-red?logo=testng&logoColor=white)  

This guide explains how to set up and run the **Selenium + TestNG + Maven automation project** in **VS Code** or **Eclipse**.  

---

## 📌 Prerequisites  
Before running the project, make sure you have:  

- ☕ **Java 17** installed and added to `PATH`  
- ⚡ **Maven** installed (`mvn -v` to verify)  
- 💻 **VS Code** with the following extension:  
  - [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)  

📷 Example (Java Extension Pack Installed):  
<img width="1918" height="997" alt="Java Extension Pack" src="https://github.com/user-attachments/assets/b22cf9fe-578c-46e5-8154-3c6c3ba05ec6" />  

---

## 🚀 Running the Project in VS Code  

### 1️⃣ Open the Project  
- Launch **VS Code**  
- Open the project folder: `CourseraAutomation`  

📷 Screenshot:  
<img width="1920" height="1080" alt="Open Project in VS Code" src="https://github.com/user-attachments/assets/3cfe1578-2821-4d42-aca4-6613cd6c1fb2" />  

---

### 2️⃣ Navigate to Testing Section  
- Go to the **Testing** panel as shown below.  
- ⚠️ *Note: This option will appear only if the Java Extension is installed properly (especially **Test Runner for Java** which comes with Java Extension Pack).*  

📷 Screenshot:  
<img width="1918" height="1043" alt="Testing Section in VS Code" src="https://github.com/user-attachments/assets/af7ed5e6-78c9-4807-9061-680d80ce2acd" />  

---

### 3️⃣ Run the Tests  
- Select the **TestNG test cases** and run them directly.  
- Or use Maven in the integrated terminal:  

```bash
mvn clean test
