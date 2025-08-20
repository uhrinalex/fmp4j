## Prerequisites

You need to have **Java 21** installed to build and run this project.

---

## 1. Install Java 21

* **Mac**: Use [Homebrew OpenJDK 21](https://formulae.brew.sh/formula/openjdk@21) to install Java 21.
* **Linux (Debian/Ubuntu)**: Install via the package manager (`openjdk-21-jdk`).
  See [Ubuntu OpenJDK package](https://packages.ubuntu.com/search?keywords=openjdk-21).
* **Windows**: Download and install Java 21 from either:
  * [Oracle JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
  * [Adoptium Temurin 21](https://adoptium.net/en-GB/temurin/releases/?version=21)

### Verify Java Installation

```bash
java -version
```

You should see something like:

```
java version "21"
```

---

## 2. Clone the Project

```bash
git clone https://github.com/sorndotdev/fmp4j.git
cd fmp4j
```

---

## 3. Build the Project

Make sure you're in the **root directory** of the project (where the `build.gradle` file is located).

### On Mac/Linux:

```bash
./gradlew clean build
```

### On Windows (Command Prompt or PowerShell):

```bash
gradlew.bat clean build
```

> 🔄 This will clean previous build artifacts and compile the entire project.

---

## ✅ Done

If the build is successful, you're ready to start development!

Please set up [IntelliJ Checkstyle Plugin](docs/CHECKSTYLE.md) next.