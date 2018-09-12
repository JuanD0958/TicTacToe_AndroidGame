package com.example.juand.tictactoe;

import android.arch.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {
    private TicTacToe ticTacToe;

    public TicTacToe getTicTacToe() {
        if(null==ticTacToe){
            ticTacToe = new TicTacToe(new GameBoard());
        }
        return ticTacToe;
    }
}
