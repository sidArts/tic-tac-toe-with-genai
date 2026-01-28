import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI for the Tic Tac Toe game using Java Swing
 * Provides a visual interface for 2 players to play the game
 */
public class TicTacToeGUI extends JFrame {
    private TicTacToe game;
    private JButton[][] buttons;
    private JLabel statusLabel;
    private JButton newGameButton;
    
    public TicTacToeGUI() {
        game = new TicTacToe();
        buttons = new JButton[3][3];
        
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create game board panel
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3, 5, 5));
        boardPanel.setBackground(Color.BLACK);
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create buttons for the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBackground(Color.WHITE);
                
                final int row = i;
                final int col = j;
                
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(row, col);
                    }
                });
                
                boardPanel.add(buttons[i][j]);
            }
        }
        
        // Create status panel
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());
        statusPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        statusLabel = new JLabel("Player X's turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Arial", Font.PLAIN, 16));
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        
        statusPanel.add(statusLabel, BorderLayout.CENTER);
        statusPanel.add(newGameButton, BorderLayout.SOUTH);
        
        // Add panels to frame
        add(boardPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
        
        // Set frame properties
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    /**
     * Handle button click event
     * @param row Row index
     * @param col Column index
     */
    private void handleButtonClick(int row, int col) {
        if (game.makeMove(row, col)) {
            updateBoard();
            
            if (game.isGameOver()) {
                char winner = game.getWinner();
                if (winner == 'D') {
                    statusLabel.setText("Game Over - It's a Draw!");
                } else {
                    statusLabel.setText("Game Over - Player " + winner + " Wins!");
                }
            } else {
                statusLabel.setText("Player " + game.getCurrentPlayer() + "'s turn");
            }
        }
    }
    
    /**
     * Update the board display
     */
    private void updateBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char cell = game.getCell(i, j);
                buttons[i][j].setText(cell == ' ' ? "" : String.valueOf(cell));
                
                // Set color for X and O
                if (cell == 'X') {
                    buttons[i][j].setForeground(new Color(255, 69, 0)); // Red-Orange
                } else if (cell == 'O') {
                    buttons[i][j].setForeground(new Color(30, 144, 255)); // Dodger Blue
                }
            }
        }
    }
    
    /**
     * Reset the game
     */
    private void resetGame() {
        game.reset();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setForeground(Color.BLACK); // Reset color
            }
        }
        statusLabel.setText("Player X's turn");
    }
    
    /**
     * Main method to launch the game
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TicTacToeGUI gui = new TicTacToeGUI();
                gui.setVisible(true);
            }
        });
    }
}
