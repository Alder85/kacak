package com.schzwi.kacak;

/**
 * Creates a card object with a suit and a value
 * Created by Josh on 3/5/2015.
 */
public class Card {
    private int suit = 0;
    private int value = 0;
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
        suit = 0;
        value = 0;
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
        return "Suit = " + suit + "\nValue = " + value;
    }

}
