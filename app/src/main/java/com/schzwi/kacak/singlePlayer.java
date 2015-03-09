package com.schzwi.kacak;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;


public class singlePlayer extends ActionBarActivity {

    int player = 0, computer = 47;
    Card[] cardArray = new Card[52];

    Card[] playerDeck = new Card[26];
    Card[] playerHand = new Card[5];
    Card[] playerTrap = new Card[5];
    Card[] playerMonsters = new Card[5];

    Card[] computerDeck = new Card[26];  //half of default
    Card[] computerHand = new Card[5];
    Card[] computerTrap = new Card[5];
    Card[] computerMonsters = new Card[5];

    Card[] discard = new Card[52]; //could hold entire deck if necessary

    Card backCard = new Card();
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
        for (int i = 0; i < cardArray.length; i++) { //consider for:each
            if(playerCounter < maxDeck && computerCounter < maxDeck) {
                currRand = randomInt(2);
                if(currRand == 0) {
                    playerDeck[playerCounter] = new Card(cardArray[i]);
                    playerCounter++;
                } else {
                    computerDeck[computerCounter] = new Card(cardArray[i]);
                    computerCounter++;
                }
            } else if(computerCounter < maxDeck) {
                computerDeck[computerCounter] = new Card(cardArray[i]);
                computerCounter++;
            }
            else {
                playerDeck[playerCounter] = new Card(cardArray[i]);
                playerCounter++;
            }
        }
        shuffleDeck(player); //so suits aren't int order
        updatePlayerHand();
    }

    public void updatePlayerHand() {
        for(int i = 0;i < playerHand.length;i++) {
            if(playerHand[i] == null) {
                for(int q = 0;q < playerDeck.length;q++) {
                    if(!(playerDeck[q] == null)) {
                        playerHand[i] = new Card(playerDeck[q]);
                        playerHand[i].setRevealed(true);
                        playerDeck[q] = null;
                    }
                    if(playerHand[i] != null)
                        break;
                }
            }
        }
        ImageView hand1 = (ImageView)findViewById(R.id.img4_0);
        ImageView hand2 = (ImageView)findViewById(R.id.img4_1);
        ImageView hand3 = (ImageView)findViewById(R.id.img4_2);
        ImageView hand4 = (ImageView)findViewById(R.id.img4_3);
        ImageView hand5 = (ImageView)findViewById(R.id.img4_4);

        hand1.setImageResource(playerHand[0].getImage());
        hand2.setImageResource(playerHand[1].getImage());
        hand3.setImageResource(playerHand[2].getImage());
        hand4.setImageResource(playerHand[3].getImage());
        hand5.setImageResource(playerHand[4].getImage());


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

    public void shuffleDeck(int deck) {
        Card tempCard = new Card();
        if(deck == 0) {
            for(int i = 0; i < 500; i++) {
                int randCardLocation1 = randomInt(26);
                int randCardLocation2 = randomInt(26);
                if(randCardLocation1 != randCardLocation2) {
                    tempCard = playerDeck[randCardLocation1];
                    playerDeck[randCardLocation1] = playerDeck[randCardLocation2];
                    playerDeck[randCardLocation2] = tempCard;
                }
            }
        } else {
            for(int i = 0; i < 500; i++) {
                int randCardLocation1 = randomInt(26);
                int randCardLocation2 = randomInt(26);
                if(randCardLocation1 != randCardLocation2) {
                    tempCard = computerDeck[randCardLocation1];
                    computerDeck[randCardLocation1] = computerDeck[randCardLocation2];
                    computerDeck[randCardLocation2] = tempCard;
                }
            }
        }
    }


    public boolean onTouchEvent(MotionEvent touchEvent)
    {
        ImageView hand1 = (ImageView)findViewById(R.id.img4_0);
        switch(touchEvent.getAction())
        {
            case MotionEvent.ACTION_UP:
            {
                hand1.setImageResource(backCard.getImage());

            }
        }
        return false;
    }


}

