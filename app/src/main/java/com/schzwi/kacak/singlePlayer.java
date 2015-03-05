package com.schzwi.kacak;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class singlePlayer extends ActionBarActivity {

    int heart = 1, club = 2, diamond = 3, spade = 4;
    int ace = 1, two = 2, three = 3, four = 4, five = 5, six = 6,
    seven = 7, eight = 8, nine = 9, ten = 10, jack = 11, queen = 12, king = 13;
    Card[][] cardArray = new Card[4][12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        for(int i = 1;i < 5;i++) {  //1-4
            for(int q = 1;q < 13;q++) {  //1- 12
                cardArray[i][q] = new Card(i, q);
            }
        }

    }

}
