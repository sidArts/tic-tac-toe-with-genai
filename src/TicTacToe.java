/**
 * Core game logic for Tic Tac Toe
 * Manages the board state, player turns, and win/draw detection
 */
public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private char winner;
    
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        winner = ' ';
        initializeBoard();
    }
    
    /**
     * Initialize the board with empty spaces
     */
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    
    /**
     * Make a move at the specified position
     * @param row Row index (0-2)
     * @param col Column index (0-2)
     * @return true if the move was successful, false otherwise
     */
    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }
        
        if (gameOver || board[row][col] != ' ') {
            return false;
        }
        
        board[row][col] = currentPlayer;
        
        if (checkWin()) {
            gameOver = true;
            winner = currentPlayer;
        } else if (isBoardFull()) {
            gameOver = true;
            winner = 'D'; // Draw
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        
        return true;
    }
    
    /**
     * Check if current player has won
     * @return true if current player won, false otherwise
     */
    private boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && 
                board[i][1] == currentPlayer && 
                board[i][2] == currentPlayer) {
                return true;
            }
        }
        
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == currentPlayer && 
                board[1][j] == currentPlayer && 
                board[2][j] == currentPlayer) {
                return true;
            }
        }
        
        // Check diagonals
        if (board[0][0] == currentPlayer && 
            board[1][1] == currentPlayer && 
            board[2][2] == currentPlayer) {
            return true;
        }
        
        if (board[0][2] == currentPlayer && 
            board[1][1] == currentPlayer && 
            board[2][0] == currentPlayer) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Check if the board is full
     * @return true if board is full, false otherwise
     */
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Get the value at a specific position
     * @param row Row index (0-2)
     * @param col Column index (0-2)
     * @return The character at that position
     */
    public char getCell(int row, int col) {
        return board[row][col];
    }
    
    /**
     * Get the current player
     * @return 'X' or 'O'
     */
    public char getCurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * Check if the game is over
     * @return true if game is over, false otherwise
     */
    public boolean isGameOver() {
        return gameOver;
    }
    
    /**
     * Get the winner
     * @return 'X', 'O', 'D' for draw, or ' ' if game is not over
     */
    public char getWinner() {
        return winner;
    }
    
    /**
     * Reset the game to initial state
     */
    public void reset() {
        initializeBoard();
        currentPlayer = 'X';
        gameOver = false;
        winner = ' ';
    }
}
