package com.example.juand.tictactoe;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.example.juand.tictactoe.databinding.ActivityGameBinding;

public class GameActivity extends AppCompatActivity {

    protected Button btnTL, btnTM, btnTR;
    protected Button btnML, btnMM, btnMR;
    protected Button btnBL, btnBM, btnBR;
    protected Button restartGameButton;
    protected TicTacToe game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ActivityGameBinding activityGameBinding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        setBindingWithButtons(activityGameBinding);
        configureGameBoard();
        setListenersToButtons();
    }

    private void configureGameBoard() {
        game = new TicTacToe();
        game.setController(this);
        game.resetBoard();
    }

    private void setListenersToButtons() {
        btnTL.setOnClickListener(event -> game.onClickButton(0, 0));
        btnTM.setOnClickListener(event -> game.onClickButton(1, 0));
        btnTR.setOnClickListener(event -> game.onClickButton(2, 0));
        btnML.setOnClickListener(event -> game.onClickButton(0, 1));
        btnMM.setOnClickListener(event -> game.onClickButton(1, 1));
        btnMR.setOnClickListener(event -> game.onClickButton(2, 1));
        btnBL.setOnClickListener(event -> game.onClickButton(0, 2));
        btnBM.setOnClickListener(event -> game.onClickButton(1, 2));
        btnBR.setOnClickListener(event -> game.onClickButton(2, 2));
        restartGameButton.setOnClickListener(event -> game.resetBoard());
    }

    public void diableButtons(boolean enabled){
        btnTL.setEnabled(enabled);
        btnTM.setEnabled(enabled);
        btnTR.setEnabled(enabled);
        btnML.setEnabled(enabled);
        btnMM.setEnabled(enabled);
        btnMR.setEnabled(enabled);
        btnBL.setEnabled(enabled);
        btnBM.setEnabled(enabled);
        btnBR.setEnabled(enabled);
    }

    private void setBindingWithButtons(ActivityGameBinding activityGameBinding) {
        btnTL = activityGameBinding.btnTL;
        btnTM = activityGameBinding.btnTM;
        btnTR = activityGameBinding.btnTR;
        btnML = activityGameBinding.btnML;
        btnMM = activityGameBinding.btnMM;
        btnMR = activityGameBinding.btnMR;
        btnBL = activityGameBinding.btnBL;
        btnBM = activityGameBinding.btnBM;
        btnBR = activityGameBinding.btnBR;
        restartGameButton = activityGameBinding.restartGameButton;
    }

    public void resetButtons() {
        String blank = "";
        btnTL.setText(blank);
        btnTM.setText(blank);
        btnTR.setText(blank);
        btnML.setText(blank);
        btnMM.setText(blank);
        btnMR.setText(blank);
        btnBL.setText(blank);
        btnBM.setText(blank);
        btnBR.setText(blank);
        diableButtons(true);
    }

    public void drawPlayerOnBoard(int i, int j,String text){
        if (i == 0 && j==0) btnTL.setText(text);
        else if (i == 1 && j==0) btnTM.setText(text);
        else if (i == 2 && j==0) btnTR.setText(text);
        else if (i == 0 && j==1) btnML.setText(text);
        else if (i == 1 && j==1) btnMM.setText(text);
        else if (i == 2 && j==1) btnMR.setText(text);
        else if (i == 0 && j==2) btnBL.setText(text);
        else if (i == 1 && j==2) btnBM.setText(text);
        else if (i == 2 && j==2) btnBR.setText(text);
    }


    public void showMessage(String strMessage){
        Toast toast = Toast.makeText(this,strMessage,Toast.LENGTH_SHORT);
        toast.show();
    }
}

