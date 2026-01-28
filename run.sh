#!/bin/bash
# Script to compile and run the Tic Tac Toe game

echo "Compiling Tic Tac Toe game..."
cd src
javac TicTacToe.java TicTacToeGUI.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Starting game..."
    java TicTacToeGUI
    cd ..
else
    echo "Compilation failed!"
    cd ..
    exit 1
fi
