package com.schzwi.kacak;

/**
 * Created by Josh on 3/5/2015.
 */
public class Card {
    private int suit;
    private int value;
    private boolean activated;

    public Card(int suitIn, int valueIn) {
        if(suitIn > 0 && suitIn <= 4)
            suit = suitIn;
        if(valueIn > 0 && valueIn <= 13)
            value = valueIn;

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
        if(value >= 6 && value <= 9)
            return true;
        return false;
    }

    public boolean isAce() {
        if(value == 1)
            return true;
        return false;
    }

    public boolean isFaceCard() {
        if(value >= 11 && value <= 13)
            return true;
        return false;
    }

    public boolean isTrap() {
        if(value >= 2 && value <= 5)
            return true;
        return false;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

}
