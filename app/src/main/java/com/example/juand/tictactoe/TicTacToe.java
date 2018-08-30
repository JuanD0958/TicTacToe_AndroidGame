package com.example.juand.tictactoe;

public class TicTacToe {
    private GameBoard board;
    private int playerTurn = 1;
    private GameActivity controller;

    public TicTacToe(GameBoard board){

        this.board = board;
    }

    public void setController(GameActivity controller){

        this.controller = controller;
    }

    public int onClickButton(int i, int j){
        if (board.isBoardCellUsed(i,j)) return 0;
        checkAndDrawPlayer(i, j,1,"O");
        checkAndDrawPlayer(i, j,2,"X");
        checkBoardState();
        switchPlayer();
        return 1;
    }

    private void checkAndDrawPlayer(int i, int j, int playerOnTurn, String playerSymbol) {

        if(!board.isBoardCellUsed(i,j) && playerTurn==playerOnTurn){

            board.setDataBoardPosition(i,j,playerTurn);
            controller.drawPlayerOnBoard(i,j,playerSymbol);
        }
    }


    private void switchPlayer(){
        playerTurn = playerTurn^3;
    }


    private void checkBoardState(){
        if (board.isThereAWinner()){
            showMessage("Player " + playerTurn + " has won!");
            controller.diableButtons(false);
        } else if (board.isTie()){
            showMessage("Tie Game");
            controller.diableButtons(false);
        }
    }

    private void showMessage(String strMessage) {
        controller.showMessage(strMessage);
    }

    public void resetGame() {
        board.resetBoard();
        controller.resetButtons();
    }
}
