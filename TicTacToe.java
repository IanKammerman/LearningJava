import java.util.Scanner;

public class TicTacToe {
    private static final char X = 'X';
    private static final char O = 'O';
    private static final char EMPTY = ' ';
    private char[][] board;
    private char currentPlayer;
    private boolean status;

    public TicTacToe(){
        board = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = EMPTY;
            }
        }
        currentPlayer = X;
        status = false;
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        while (!status) {
            printBoard();
            System.out.println("Welcome to Tic Tac Toe, Enter row and column");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if(row < 0 || col < 0 || row >= 3 || col >= 3 || board[row][col] != EMPTY){
                System.out.println("Invalid, try again");
            } else{
                board[row][col] = currentPlayer;
                if (checkWin()){
                    status = true;
                    printBoard();
                    System.out.println(currentPlayer + "Wins!");
                } else if (checkDraw()){
                    status = true;
                    printBoard();
                    System.out.println("Draw!");
                } else {
                    currentPlayer = (currentPlayer == X) ? O : X;
                }
            }
        }
        scanner.close();
    }
    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);  
                if (j < 2) {
                    System.out.print("|");  
                }
            }
            System.out.println(); 
            if (i < 2) {
                System.out.println("-----"); 
            }
        }
    }

    private boolean checkWin(){
        for(int i = 0; i < 3; i++){
            if(board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
            if(board[0][i] != EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }
        if(board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if(board[0][2] != EMPTY && board[0][2] == board [1][1] && board [1][1] == board[2][0]) return true;
        return false;
    }
    private boolean checkDraw(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == EMPTY) return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        TicTacToe game = new TicTacToe();
        game.play();
    }
}