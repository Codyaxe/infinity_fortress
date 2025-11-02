# Infinity Fortress

Infinity Fortress is a console-based turn-based game with gacha elements.

## Prerequisites

Ensure you have the following installed on your system:

- Java Development Kit (JDK) 24 or higher (tested with Java 24)
- Apache Maven
- A terminal or command prompt

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Codyaxe/infinity_fortress.git
   ```

2. Navigate to the project directory:
   ```bash
   cd infinity_fortress
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Running the Game

1. Navigate to the `target` directory:
   ```bash
   cd target
   ```

2. Run the game:
   ```bash
   java -jar infinity-fortress-1.0-SNAPSHOT.jar
   ```

   Or run directly from the project root:
   ```bash
   java -jar target/infinity-fortress-1.0-SNAPSHOT.jar
   ```

   Or double click the run.bat file in the root folder
   ```bash
    run.bat
   ```

## Testing

To run the tests, use the following command:
```bash
mvn test
```
