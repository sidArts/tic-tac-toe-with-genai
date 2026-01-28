/**
 * Simple test program to verify the core game logic
 * This can be run in a headless environment without GUI
 */
public class TicTacToeTest {
    
    public static void main(String[] args) {
        System.out.println("Starting Tic Tac Toe Logic Tests...\n");
        
        int testsPassed = 0;
        int totalTests = 0;
        
        // Test 1: Initial state
        totalTests++;
        TicTacToe game = new TicTacToe();
        if (game.getCurrentPlayer() == 'X' && !game.isGameOver()) {
            System.out.println("✓ Test 1 PASSED: Initial state is correct");
            testsPassed++;
        } else {
            System.out.println("✗ Test 1 FAILED: Initial state is incorrect");
        }
        
        // Test 2: Making valid moves
        totalTests++;
        game.reset();
        boolean moveResult = game.makeMove(0, 0);
        if (moveResult && game.getCell(0, 0) == 'X' && game.getCurrentPlayer() == 'O') {
            System.out.println("✓ Test 2 PASSED: Valid move works correctly");
            testsPassed++;
        } else {
            System.out.println("✗ Test 2 FAILED: Valid move doesn't work");
        }
        
        // Test 3: Invalid move on occupied cell
        totalTests++;
        game.reset();
        game.makeMove(0, 0);
        boolean invalidMove = game.makeMove(0, 0);
        if (!invalidMove && game.getCurrentPlayer() == 'O') {
            System.out.println("✓ Test 3 PASSED: Invalid move on occupied cell rejected");
            testsPassed++;
        } else {
            System.out.println("✗ Test 3 FAILED: Invalid move on occupied cell not rejected");
        }
        
        // Test 4: Horizontal win detection
        totalTests++;
        game.reset();
        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X wins
        if (game.isGameOver() && game.getWinner() == 'X') {
            System.out.println("✓ Test 4 PASSED: Horizontal win detected");
            testsPassed++;
        } else {
            System.out.println("✗ Test 4 FAILED: Horizontal win not detected");
        }
        
        // Test 5: Vertical win detection
        totalTests++;
        game.reset();
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(1, 1); // O
        game.makeMove(2, 0); // X wins
        if (game.isGameOver() && game.getWinner() == 'X') {
            System.out.println("✓ Test 5 PASSED: Vertical win detected");
            testsPassed++;
        } else {
            System.out.println("✗ Test 5 FAILED: Vertical win not detected");
        }
        
        // Test 6: Diagonal win detection
        totalTests++;
        game.reset();
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 1); // X
        game.makeMove(0, 2); // O
        game.makeMove(2, 2); // X wins
        if (game.isGameOver() && game.getWinner() == 'X') {
            System.out.println("✓ Test 6 PASSED: Diagonal win detected");
            testsPassed++;
        } else {
            System.out.println("✗ Test 6 FAILED: Diagonal win not detected");
        }
        
        // Test 7: Draw detection
        totalTests++;
        game.reset();
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(0, 2); // X
        game.makeMove(1, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(2, 0); // O
        game.makeMove(1, 2); // X
        game.makeMove(2, 2); // O
        game.makeMove(2, 1); // X - Draw
        if (game.isGameOver() && game.getWinner() == 'D') {
            System.out.println("✓ Test 7 PASSED: Draw detected");
            testsPassed++;
        } else {
            System.out.println("✗ Test 7 FAILED: Draw not detected");
        }
        
        // Test 8: Reset functionality
        totalTests++;
        game.reset();
        if (!game.isGameOver() && game.getCurrentPlayer() == 'X' && game.getCell(0, 0) == ' ') {
            System.out.println("✓ Test 8 PASSED: Reset works correctly");
            testsPassed++;
        } else {
            System.out.println("✗ Test 8 FAILED: Reset doesn't work");
        }
        
        // Test 9: Bounds checking for getCell
        totalTests++;
        game.reset();
        if (game.getCell(-1, 0) == ' ' && game.getCell(0, -1) == ' ' && 
            game.getCell(3, 0) == ' ' && game.getCell(0, 3) == ' ') {
            System.out.println("✓ Test 9 PASSED: Bounds checking works correctly");
            testsPassed++;
        } else {
            System.out.println("✗ Test 9 FAILED: Bounds checking doesn't work");
        }
        
        // Print summary
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Test Results: " + testsPassed + "/" + totalTests + " tests passed");
        if (testsPassed == totalTests) {
            System.out.println("All tests PASSED! ✓");
            System.exit(0);
        } else {
            System.out.println("Some tests FAILED! ✗");
            System.exit(1);
        }
    }
}
