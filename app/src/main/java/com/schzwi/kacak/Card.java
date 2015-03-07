package com.schzwi.kacak;

/**
 * Creates a card object with a suit and a value
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

    public Card(Card x) {
        suit = x.getSuit();
        value = x.getValue();
    }
    public Card() { //null
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

}
