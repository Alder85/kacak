package com.schzwi.kacak;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;

/**
 * Creates a card object with a suit and a value
 * Created by Josh on 3/5/2015.
 */
public class Card {
    private int suit;
    private int value;
    private boolean activated;
    private boolean revealed = false;
    private static boolean selected = false;
    private boolean mselected = false;

    public Card(int suitIn, int valueIn) {
        if(suitIn > 0 && suitIn <= 4)
            suit = suitIn;
        if(valueIn > 0 && valueIn <= 13)
            value = valueIn;

    }

    public Card(Card x) {
        suit = x.getSuit();
        value = x.getValue();
    }
    public Card() { //null
    }

    public void setRevealed(boolean x) {
        revealed = x;
    }
    public void setMselected(boolean x) {
        mselected = x;
    }
    public static void setSelected(boolean x) {
        selected = x;
    }
    public boolean isSelected() {
        return mselected;
    }
    public int getAttack() {
        if(isLowMonster())
            return value;
        else if(isFaceCard())
            return 10;
        else if(isAce())
            return 15;
        else //isTrap
            return 0;
    }

    public boolean isBlank() {
        return suit == 0 && value == 0;
    }

    public void setBlank() {
        suit = 0;
        value = 0;
    }

    public int getDefense() {
        if(isAce())
            return 5;
        return getAttack();
    }

    public boolean isActivated() {
        return activated;
    }
    public void activate() {
        activated = true;
    }

    public boolean isLowMonster() {
        return value >= 6 && value <= 9;
    }

    public boolean isAce() {
        return value == 1;
    }

    public boolean isFaceCard() {
        return value >= 11 && value <= 13;
    }

    public boolean isTrap() {
        return value >= 2 && value <= 5;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public void setSuit(int x) {
        suit = x;
    }

    public void setValue(int x) {
        value = x;
    }

    public String toString() {
        String val = "";
        String suitVal = "";
        switch(value) {
            case 1: val = "Ace";
                break;
            case 11: val = "Jack";
                break;
            case 12: val = "Queen";
                break;
            case 13: val = "King";
                break;
            default: val = value + "";
                break;

        }
        //heart club diamond spade
        switch(suit) {
            case 1: suitVal = "Hearts.";
                break;
            case 2: suitVal = "Clubs.";
                break;
            case 3: suitVal = "Diamonds.";
                break;
            case 4: suitVal = "Spades.";
                break;
            default: suitVal = "Invalid. YOU ARE POTATOE.";
                break;
        }
        return val + " of " + suitVal;
    }

    public int getImage() {
        if (!revealed)
            return R.drawable.card_back;
        switch (suit) {
            case 1:
                switch (value) {
                    case 1:
                        return R.drawable.ace_of_hearts;
                    case 2:
                        return R.drawable.two_of_hearts;
                    case 3:
                        return R.drawable.three_of_hearts;
                    case 4:
                        return R.drawable.four_of_hearts;
                    case 5:
                        return R.drawable.five_of_hearts;
                    case 6:
                        return R.drawable.six_of_hearts;
                    case 7:
                        return R.drawable.seven_of_hearts;
                    case 8:
                        return R.drawable.eight_of_hearts;
                    case 9:
                        return R.drawable.nine_of_hearts;
                    case 10:
                        return R.drawable.ten_of_hearts;
                    case 11:
                        return R.drawable.jack_of_hearts;
                    case 12:
                        return R.drawable.queen_of_hearts;
                    case 13:
                        return R.drawable.king_of_hearts;
                    default:
                        return R.drawable.card_back;
                }
            case 2:
                switch (value) {
                    case 1:
                        return R.drawable.ace_of_clubs;
                    case 2:
                        return R.drawable.two_of_clubs;
                    case 3:
                        return R.drawable.three_of_clubs;
                    case 4:
                        return R.drawable.four_of_clubs;
                    case 5:
                        return R.drawable.five_of_clubs;
                    case 6:
                        return R.drawable.six_of_clubs;
                    case 7:
                        return R.drawable.seven_of_clubs;
                    case 8:
                        return R.drawable.eight_of_clubs;
                    case 9:
                        return R.drawable.nine_of_clubs;
                    case 10:
                        return R.drawable.ten_of_clubs;
                    case 11:
                        return R.drawable.jack_of_clubs;
                    case 12:
                        return R.drawable.queen_of_clubs;
                    case 13:
                        return R.drawable.king_of_clubs;
                    default:
                        return R.drawable.card_back;
                }
            case 3:
                switch (value) {
                    case 1:
                        return R.drawable.ace_of_diamonds;
                    case 2:
                        return R.drawable.two_of_diamonds;
                    case 3:
                        return R.drawable.three_of_diamonds;
                    case 4:
                        return R.drawable.four_of_diamonds;
                    case 5:
                        return R.drawable.five_of_diamonds;
                    case 6:
                        return R.drawable.six_of_diamonds;
                    case 7:
                        return R.drawable.seven_of_diamonds;
                    case 8:
                        return R.drawable.eight_of_diamonds;
                    case 9:
                        return R.drawable.nine_of_diamonds;
                    case 10:
                        return R.drawable.ten_of_diamonds;
                    case 11:
                        return R.drawable.jack_of_diamonds;
                    case 12:
                        return R.drawable.queen_of_diamonds;
                    case 13:
                        return R.drawable.king_of_diamonds;
                    default:
                        return R.drawable.card_back;
                }
            case 4:
                switch (value) {
                    case 1:
                        return R.drawable.ace_of_spades;
                    case 2:
                        return R.drawable.two_of_spades;
                    case 3:
                        return R.drawable.three_of_spades;
                    case 4:
                        return R.drawable.four_of_spades;
                    case 5:
                        return R.drawable.five_of_spades;
                    case 6:
                        return R.drawable.six_of_spades;
                    case 7:
                        return R.drawable.seven_of_spades;
                    case 8:
                        return R.drawable.eight_of_spades;
                    case 9:
                        return R.drawable.nine_of_spades;
                    case 10:
                        return R.drawable.ten_of_spades;
                    case 11:
                        return R.drawable.jack_of_spades;
                    case 12:
                        return R.drawable.queen_of_spades;
                    case 13:
                        return R.drawable.king_of_spades;
                    default:
                        return R.drawable.card_back;
                }
            default:
                return R.drawable.card_back;

        }
    }
}
