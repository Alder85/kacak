package com.schzwi.kacak;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class singlePlayer extends ActionBarActivity {

    int heart = 1, club = 2, diamond = 3, spade = 4;
    int ace = 1, two = 2, three = 3, four = 4, five = 5, six = 6,
    seven = 7, eight = 8, nine = 9, ten = 10, jack = 11, queen = 12, king = 13;
    Card[] cardArray = new Card[52];
    Card[] playerHand = new Card[26];
    Card[] computerHand = new Card[26];  //half of default
    Card[] discard = new Card[52]; //could hold entire deck if necessary

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        int count = 0;
        for(int i = 1;i < 5;i++) {  //1-4
            for(int q = 1;q < 14;q++) {  //1-13
                cardArray[count] = new Card(i, q);
                count++;
            }
        }

        int currRand;
        int playerCounter = 0;
        int computerCounter = 0;
        int maxDeck = cardArray.length / 2;
        for (int i = 0; i < cardArray.length; i++) {
            if(playerCounter < maxDeck && computerCounter < maxDeck) {
                currRand = randomInt(2);
                if(currRand == 0) {
                    playerHand[playerCounter] = new Card(cardArray[i]);
                    playerCounter++;
                } else {
                    computerHand[computerCounter] = new Card(cardArray[i]);
                    computerCounter++;
                }
            } else if(computerCounter < maxDeck) {
                computerHand[computerCounter] = new Card(cardArray[i]);
                computerCounter++;
            }
            else {
                playerHand[playerCounter] = new Card(cardArray[i]);
                playerCounter++;
            }
        }
        Card potatoe = new Card();
    }

    /**
     * randomInt simplifies returning a specific random number
     * @param num What range of random numbers
     * @return A number between 0 and num, inclusive (0 - num)
     */
    public static int randomInt(int num)
    {
        return (int)(Math.random() * num);
    }
}
