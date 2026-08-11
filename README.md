# 💵 Currency Change Calculator (Java, OOP)
### Denomination Breakdown & Record Management System Built in Core Java

[![Java](https://img.shields.io/badge/Java-OOP-ED8B00.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](#license)

## 📌 Overview

A console-based Java application that manages a set of customer currency records and breaks each amount down into the fewest possible AED banknote denominations (1000, 500, 200, 100, 50, 20, 10, 5). Built as a foundational exercise in **object-oriented design, input validation, and array-based data management** — the kind of core programming discipline that underlies every larger system.

The program supports entering records interactively (with duplicate-name and multiple-of-5 validation) or loading a built-in hardcoded test set, then offers a menu-driven interface to look up a specific customer's change breakdown, find the smallest/largest account, and aggregate denomination and total-amount statistics across all records.

## 🎯 Relevant Skills Demonstrated

- **Clean separation of concerns (OOP fundamentals):** the `changeC` class encapsulates all data and denomination-calculation logic for a single customer record (private fields, getters/setters, a greedy-algorithm helper method), while `Client` handles all I/O, menu control flow, and record management — a textbook separation between a domain model and its controller.
- **Defensive input validation:** every user input is validated before being accepted — duplicate name checks (`ifNameExists`), business-rule validation (amounts must be multiples of 5), and graceful "not found" handling for lookups — rather than assuming well-formed input.
- **Algorithmic thinking:** `calculateChange()` implements a straightforward greedy denomination-breakdown algorithm (successive integer division and modulo across descending note values) — the same class of algorithm used in real-world cash-handling and POS systems.
- **Testability by design:** a dedicated `hardcodedTestCases()` method preloads known records specifically so the program can be verified deterministically without requiring manual re-entry of test data — an early instinct toward reproducible testing.
- **Menu-driven application architecture:** a `switch`-based command dispatcher (`processMenu`) cleanly routes six distinct operations (lookup, min/max search, aggregate totals) without duplicating logic.

## ⚙️ How It Works

**Flow:** `Student Info → Hardcoded Test Records → Interactive Data Entry (validated) → Menu Loop → Dispatch to Operation`

- **`changeC`** stores a customer's `name` and `amount`, and on construction (or amount update) immediately computes the note breakdown via a private `calculateChange()` method using successive division/modulo from the largest denomination (1000) down to the smallest (5).
- **`Client`** holds an array of up to 50 `changeC` records and drives the program: `inputData()` loops on user entry until the user declines to add more, validating both name uniqueness and the multiple-of-5 amount rule before storing each record.
- The **menu** offers six operations: display a specific customer's change breakdown, find the smallest/largest account and show its breakdown, total note counts by denomination across *all* records, total currency value across all records, and exit.

## 🛠️ Tech Stack

`Java` · Core OOP (encapsulation, constructors, getters/setters) · `Scanner`-based console I/O · Array-based record storage · Greedy algorithm design

## 📁 Repository Structure

```
├── src/
│   └── ChangeC/
│       ├── Client.java     # Main class — I/O, menu, record management
│       └── changeC.java    # Domain model — customer record + denomination logic
├── build.xml               # Ant build script (NetBeans project)
└── README.md
```

## 🚀 Running the Project

```bash
javac src/ChangeC/*.java -d out
java -cp out Client
```
Or open the project directly in **NetBeans/Apache Ant** (project files included) and run `Client.java`.

On launch, the program preloads 10 hardcoded test records, then prompts for additional entries (enter `N` when asked to add more to skip straight to the menu).

## 🔮 Future Work

- Replace the fixed-size array (`changeC[50]`) with a dynamic collection (`ArrayList<changeC>`) to remove the hardcoded capacity limit
- Extract input validation into reusable, unit-testable methods decoupled from `Scanner`/console I/O
- Add automated unit tests (JUnit) for `calculateChange()` covering edge cases (zero amount, exact single-denomination amounts)

## 📄 License

This project is available under the MIT License.

---

*This project was completed as a foundational academic assignment (ICT167) focused on object-oriented programming fundamentals in Java.*
