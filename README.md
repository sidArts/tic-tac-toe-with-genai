# Tic-Tac-Toe Game with Java

A classic Tic-Tac-Toe game built with Java for 2 players, featuring a graphical user interface (GUI) using Java Swing. This desktop application allows two players to play against each other on the same computer.

## Features

- ✨ Clean and intuitive GUI built with Java Swing
- 🎮 Two-player gameplay (Player X vs Player O)
- 🎨 Color-coded players (X in red-orange, O in blue)
- 🔄 New Game button to restart the game
- 🏆 Win detection for rows, columns, and diagonals
- 🤝 Draw detection when the board is full
- 📱 Desktop application that runs on Windows, macOS, and Linux

## Requirements

- Java Development Kit (JDK) 8 or higher
- No external dependencies required (uses Java's built-in Swing library)

## How to Build and Run

### Option 1: Using the Run Scripts (Easiest)

**On Linux/macOS:**
```bash
./run.sh
```

**On Windows:**
```cmd
run.bat
```

### Option 2: Manual Compilation and Execution

1. Compile the Java files:
```bash
cd src
javac TicTacToe.java TicTacToeGUI.java
```

2. Run the game:
```bash
java TicTacToeGUI
```

## How to Play

1. Launch the game using one of the methods above
2. A 3x3 grid window will appear
3. Player X always goes first
4. Click on any empty cell to place your mark (X or O)
5. Players alternate turns
6. The first player to get 3 marks in a row (horizontally, vertically, or diagonally) wins
7. If all cells are filled without a winner, the game ends in a draw
8. Click "New Game" button to start a new game

## Project Structure

```
tic-tac-toe-with-genai/
├── src/
│   ├── TicTacToe.java      # Core game logic
│   └── TicTacToeGUI.java   # GUI implementation
├── run.sh                   # Linux/macOS run script
├── run.bat                  # Windows run script
├── .gitignore              # Git ignore file
└── README.md               # This file
```

## Game Logic

- **TicTacToe.java**: Contains the core game logic including:
  - Board state management
  - Move validation
  - Win/draw detection
  - Player turn switching

- **TicTacToeGUI.java**: Provides the graphical interface with:
  - 3x3 grid of clickable buttons
  - Status label showing current player and game result
  - New Game button to reset the board

## License

This is an open-source project generated with GitHub Copilot.
