package com.schzwi.kacak;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class singlePlayer extends ActionBarActivity {

    int player = 0, computer = 47;
    int cardSelected = -1;
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
    Card tempCardStorage = new Card();

    ImageView[] hand = new ImageView[5];
    public void defineHandViews() {
        hand[0] = (ImageView)findViewById(R.id.img4_0);
        hand[1] = (ImageView)findViewById(R.id.img4_1);
        hand[2] = (ImageView)findViewById(R.id.img4_2);
        hand[3] = (ImageView)findViewById(R.id.img4_3);
        hand[4] = (ImageView)findViewById(R.id.img4_4);

        hand[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playerHandClicked(0);
            }
        });
        hand[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playerHandClicked(1);
            }
        });
        hand[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playerHandClicked(2);
            }
        });
        hand[3].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playerHandClicked(3);
            }
        });
        hand[4].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playerHandClicked(4);
            }
        });
    }

    ImageView[] trap = new ImageView[5];
    public void defineTrapViews() {
        trap[0] = (ImageView)findViewById(R.id.img3_0);
        trap[1] = (ImageView)findViewById(R.id.img3_1);
        trap[2] = (ImageView)findViewById(R.id.img3_2);
        trap[3] = (ImageView)findViewById(R.id.img3_3);
        trap[4] = (ImageView)findViewById(R.id.img3_4);

        trap[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });
    }

    ImageView[] monster = new ImageView[5];
    public void defineMonsterViews() {
        monster[0] = (ImageView)findViewById(R.id.img2_0);
        monster[1] = (ImageView)findViewById(R.id.img2_1);
        monster[2] = (ImageView)findViewById(R.id.img2_2);
        monster[3] = (ImageView)findViewById(R.id.img2_3);
        monster[4] = (ImageView)findViewById(R.id.img2_4);




        monster[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playerMonsterClicked(0);
            }
        });
        monster[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playerMonsterClicked(1);
            }
        });
        monster[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playerMonsterClicked(2);
            }
        });
        monster[3].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playerMonsterClicked(3);
            }
        });
        monster[4].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playerMonsterClicked(4);
            }
        });
    }

    ImageView[] cMonster = new ImageView[5];
    public void defineCMonsterViews() {
        cMonster[0] = (ImageView)findViewById(R.id.img1_0);
        cMonster[1] = (ImageView)findViewById(R.id.img1_1);
        cMonster[2] = (ImageView)findViewById(R.id.img1_2);
        cMonster[3] = (ImageView)findViewById(R.id.img1_3);
        cMonster[4] = (ImageView)findViewById(R.id.img1_4);
    }

    ImageView[] cTrap = new ImageView[5];
    public void defineCTrapViews() {
        cTrap[0] = (ImageView)findViewById(R.id.img0_0);
        cTrap[1] = (ImageView)findViewById(R.id.img0_1);
        cTrap[2] = (ImageView)findViewById(R.id.img0_2);
        cTrap[3] = (ImageView)findViewById(R.id.img0_3);
        cTrap[4] = (ImageView)findViewById(R.id.img0_4);
    }

    public void defineAllViewsAndClickListeners() {
        defineHandViews();
        defineTrapViews();
        defineMonsterViews();
        defineCMonsterViews();
        defineCTrapViews();
    }



    public void firstDeal() {
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

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        defineAllViewsAndClickListeners();
        firstDeal();
        shuffleDeck(player); //so suits aren't in order
        updatePlayerHand();
    }

    public void playerHandClicked(int handNum) {
        if (playerHand[handNum] != null) {
            if (playerHand[handNum].isSelected()) {
                cardSelected = -1;
                unSelect(playerHand[handNum], hand[handNum]);
            } else if (cardSelected == -1) {
                tempCardStorage = playerHand[handNum];
                cardSelected = handNum;
                setSelected(playerHand[handNum], hand[handNum]);
            } else {
                unSelect(playerHand[cardSelected], hand[cardSelected]);
                cardSelected = handNum;
                setSelected(playerHand[handNum], hand[handNum]);
                tempCardStorage = playerHand[handNum];
            }
        }
    }

    public void playerMonsterClicked(int monstNum) {
        if(playerMonsters[monstNum] == null) {
            if (cardSelected > -1 && tempCardStorage.isMonster()) {
                playerHand[cardSelected] = null;
                cardSelected = -1;
                playerMonsters[monstNum] = tempCardStorage;
                for (int i = 0; i < 5; i++) {
                    if (playerMonsters[i] != null) {
                        monster[i].setImageResource(playerMonsters[i].getImage());
                    }
                }
                updatePlayerHand();
            }
        }
    }

    public void playerTrapClicked(int trapNum) {

    }

    public void computerMonsterClicked(int monstNum) {

    }

    public void computerTrapClicked(int trapNum) {

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
        for(int i = 0;i < hand.length;i++) {
            hand[i].setImageResource(playerHand[i].getImage());
        }
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

    public void setSelected(Card card, ImageView imageview) {
        card.setSelected(true);
        int x = card.getImage();
        Bitmap bottomImage = BitmapFactory.decodeResource(getResources(), x);
        Bitmap overlay =  BitmapFactory.decodeResource(getResources(), R.drawable.selected_overlay);
        Bitmap combined = overlay(bottomImage, overlay);
        Drawable drawable = new BitmapDrawable(getResources(), combined);

        imageview.setImageDrawable(drawable);
    }

    public void unSelect(Card card, ImageView imageview) {
        card.setSelected(false);
        int x = card.getImage();
        Bitmap bottomImage = BitmapFactory.decodeResource(getResources(), x);
        Drawable drawable = new BitmapDrawable(getResources(), bottomImage);
        imageview.setImageDrawable(drawable);
    }

    public static Bitmap overlay(Bitmap bmp1, Bitmap bmp2) {
        Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), bmp1.getConfig());
        Canvas canvas = new Canvas(bmOverlay);
        canvas.drawBitmap(bmp1, new Matrix(), null); //import could be wrong
        canvas.drawBitmap(bmp2, 0, 0, null);
        return bmOverlay;
    }

    /* nnnnnnnnot used
    public boolean onTouchEvent(MotionEvent touchEvent)
    {
        switch(touchEvent.getAction())
        {
            case MotionEvent.ACTION_UP:
            {


            }
        }
        return false;
    }
    */

}

