package com.example.juand.tictactoe;

public class GameBoard {
    private int [][] board = {{0,0,0},{0,0,0},{0,0,0}};

    public boolean isBoardCellUsed(int posX, int posY) {
        return board[posX][posY]!=0;
    }

    public void setDataBoardPosition(int posX, int posY, int value){
        this.board[posX][posY] = value;
    }


    public boolean isTie() {
        for (int posX=0;posX<3;posX++){
            for(int posY=0;posY<3;posY++){
                if(board[posX][posY]==0){
                    return false;
                }
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
    }

    public boolean isThereAWinner(){
        if (checkColumns(this.board)) return true;
        if (checkRows(this.board)) return true;
        if (diagonalRight(this.board, 0, 2)) return true;
        if (diagonalRight(this.board, 2, 0)) return true;
        return false;
    }

    public boolean diagonalRight(int[][] testBoard, int i, int i2) {
        return     testBoard[0][i] != 0
                && testBoard[0][i] == testBoard[1][1]
                && testBoard[1][1] == testBoard[2][i2];
    }

    public boolean checkRows(int[][] testBoard) {
        for (int y=0;y<3;y++) {
            if(testBoard[0][y]!=0 && testBoard[0][y] == testBoard[1][y] && testBoard[1][y] == testBoard[2][y]){
                return true;
            }
        }
        return false;
    }

    public boolean checkColumns(int[][] testBoard) {
        for (int x=0;x<3;x++) {
            if (testBoard[x][0]!=0 && testBoard[x][0] == testBoard[x][1] && testBoard[x][1] == testBoard[x][2]) {
                return true;
            }
        }
        return false;
    }
}
