# Simple Calculator

A simple calculator application built using JavaFX. This project provides basic arithmetic operations such as addition, subtraction, multiplication, and division.

## Features
- Addition
- Subtraction
- Multiplication
- Division
- Clear (C) button to reset the calculator
- Equals button (=) to calculate the result

## Prerequisites
Before running the project, make sure you have the following installed:
- Java 21 (or compatible version)
- JavaFX SDK 21.0.7 (or compatible version)

## How to Run

### 1. Download and Install JavaFX SDK
- Download JavaFX SDK from the official [JavaFX website](https://openjfx.io/).
- Extract the SDK to a directory of your choice (e.g., `C:\JavaFX\javafx-sdk-21.0.7`).

### 2. Set Up the Project

- Clone or download this project to your local machine.

### 3. Set JavaFX Path

- Ensure the JavaFX SDK is properly set in the `--module-path` when compiling and running.

### 4. Compile and Run

Open the terminal/command prompt, navigate to the project directory, and use the following commands to compile and run the project:

#### Compile:
```bash
javac --module-path "path_to_your_javafx_sdk\lib" --add-modules javafx.controls Main.java
