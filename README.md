

# 📚 **Java Functional Programming Examples**

This repository demonstrates how to work with **functional interfaces**, **lambdas**, **streams**, and **collections** in **Java**.  
It contains two main examples:

---

## **1. LambdaExample.java**

**Demonstrates how to use:**
- **Predicate<User>** for filtering users.
- **Comparator<User>** for sorting users.
- **Java Streams API** with **functional interfaces** and **lambda expressions**.

### **Features:**
- Listing **all users**.
- Listing **active users** (using **anonymous classes** and **lambdas**).
- Filtering users by **age** and sorting them by **name** or **age**.
- Combining multiple conditions (e.g., **active users older than 8 years**).

### **Key Concepts:**
- **Predicate<T>** to define a **filtering rule**.
- **Comparator<T>** to define a **sorting rule**.
- Using streams: `.filter()`, `.sorted()`, and `.forEach()`.

---

## **2. StreamsExample.java**

**Demonstrates more advanced usage of:**
- **Streams** on **nested collections** (authors and their books).
- **Filtering** and **mapping** using **functional interfaces** and **lambdas**.
- **Aggregations** like **average price calculation**.

### **Features:**
- Listing **all authors**.
- Filtering **active authors**.
- Listing **active (published) books** for all authors.
- Calculating the **average price** of all books.
- Finding **active authors** who have at least one **published book**.

### **Key Concepts:**
- Stream transformations: `.flatMap()`, `.filter()`, `.mapToInt()`, `.average()`.
- **Functional Interfaces**: `Consumer`, `Predicate`, `Function<T, R>`.
- **Lambda expressions** and **method references** (`System.out::println`).

---

## 💡 **Technologies Used**
- **Java 8+**
- **Functional Interfaces** (`Predicate`, `Consumer`, `Function`, `Comparator`)
- **Java Streams API**

---
