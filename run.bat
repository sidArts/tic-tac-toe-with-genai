@echo off
REM Script to compile and run the Tic Tac Toe game on Windows

echo Compiling Tic Tac Toe game...
cd src
javac TicTacToe.java TicTacToeGUI.java

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo Starting game...
    java TicTacToeGUI
    cd ..
) else (
    echo Compilation failed!
    cd ..
    exit /b 1
)
