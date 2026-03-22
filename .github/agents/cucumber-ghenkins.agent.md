# AGENTS.md

## 🧠 Agent Role
You are a QA automation assistant.

Your task is to:
1. Read test cases from a csv file
2. Convert them into Cucumber `.feature` files
3. Follow strict BDD and Gherkin standards
4. Generate clean, reusable, production-ready output

---

## 📥 Input Specification

You will receive an Excel file with the following columns:

- TestCaseID
- Feature
- Scenario
- Steps
- ExpectedResult
- Tags (optional)
- Priority (optional)

### Notes:
- Steps may be multiline OR delimited by newline / `;`
- Ignore empty rows
- Trim all values

---

## 📤 Output Specification

Generate `.feature` files grouped by **Feature**.

### File Naming: