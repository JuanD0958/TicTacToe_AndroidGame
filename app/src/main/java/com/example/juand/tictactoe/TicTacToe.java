package com.example.juand.tictactoe;

public class TicTacToe {
    private int [][] board = {{0,0,0},{0,0,0},{0,0,0}};
    private int playerTurn = 1;
    private GameActivity controller;


    public TicTacToe() {
    }

    public void setController(GameActivity controller){
        this.controller = controller;
    }

    public int onClickButton(int i, int j){
        if (board[i][j]!= 0) return 0;
        checkAndDrawPlayer(i, j,1,"O");
        checkAndDrawPlayer(i, j,2,"X");
        checkBoardState();
        switchPlayer();
        return 1;
    }

    private void checkAndDrawPlayer(int i, int j, int playerOnTurn, String playerSymbol) {
        if(board[i][j]==0 && playerTurn==playerOnTurn){
            board[i][j] = playerTurn;
            controller.drawPlayerOnBoard(i,j,playerSymbol);
        }
    }


    private void switchPlayer(){
        playerTurn = playerTurn^3;
    }


    private void checkBoardState(){
        if (checkBoardDirections(board)){
            showMessage("Player " + playerTurn + " has won!");
            controller.diableButtons(false);
        } else if (checkFullBoard()){
            showMessage("Tie Game");
            controller.diableButtons(false);
        }
    }

    private void showMessage(String strMessage) {
        controller.showMessage(strMessage);
    }


    private boolean checkFullBoard() {
        for (int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                if(board[x][y]==0) return false;
            }
        }
        return true;
    }


    public void resetBoard() {
        for (int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                board[x][y]=0;
            }
        }
        controller.resetButtons();
    }

    private boolean checkBoardDirections(int [][]testBoard){
        if (checkColumns(testBoard)) return true;
        if (checkRows(testBoard)) return true;
        if (diagonalRight(testBoard, 0, 2)) return true;
        if (diagonalRight(testBoard, 2, 0)) return true;
        return false;
    }

    private boolean diagonalRight(int[][] testBoard, int i, int i2) {
        return     testBoard[0][i] != 0
                && testBoard[0][i] == testBoard[1][1]
                && testBoard[1][1] == testBoard[2][i2];
    }

    private boolean checkRows(int[][] testBoard) {
        for (int y=0;y<3;y++) {
            if(testBoard[0][y]!=0 && testBoard[0][y] == testBoard[1][y] && testBoard[1][y] == testBoard[2][y]){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(int[][] testBoard) {
        for (int x=0;x<3;x++) {
            if (testBoard[x][0]!=0 && testBoard[x][0] == testBoard[x][1] && testBoard[x][1] == testBoard[x][2]) {
                return true;
            }
        }
        return false;
    }
}
