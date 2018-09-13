package com.example.juand.tictactoe.domain.usecase;

/**
 * Created by NoaD on 01/05/2017.
 */

public interface UseCaseUiThreadPool {

    void post(final Runnable runnable);
}
