#!/bin/bash
# Script to compile and run the Tic Tac Toe game

echo "Compiling Tic Tac Toe game..."
cd src
javac TicTacToe.java TicTacToeGUI.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Starting game..."
    java TicTacToeGUI
else
    echo "Compilation failed!"
    exit 1
fi
