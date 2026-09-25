# Telegram Resume Analyzer

A Java-based Telegram bot that analyzes PDF resumes and provides an overall resume score, detected skills, skill gaps, suggestions, and learning resources.

## Features

- 📄 Accepts PDF resumes through Telegram
- ⭐ Generates an overall resume score out of 10
- 🎯 Detects relevant job roles
- ✅ Identifies skills found in the resume
- ❌ Identifies important missing or weak skills
- 💡 Provides resume improvement suggestions
- 🎓 Recommends learning resources
- ☕ Built using Java
- 📑 Uses Apache PDFBox for PDF text extraction
- 🤖 Uses Telegram Bot API

## Technologies Used

- Java
- Telegram Bot API
- Apache PDFBox
- HTTP/HTTPS
- VS Code

## Project Structure

```text
TelegramResumeAnalyzer
├── Main.java
├── ResumeAnalyzer.java
├── ResumeReader.java
└── TelegramBot.java
