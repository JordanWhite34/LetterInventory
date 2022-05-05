// Jordan White
// 1/15/2020
// Take Home Assessment 1: LetterInventory
//
// The letter inventory object takes a String and stores a count of how many
// times each letter in the alphabet exists in the String, while also being able to
// get counts for specific letters, change count values, show total amount ofletters,
// show if the String is empty, return a visual representation of all the letters,
// and add or subtract letter inventories.

import java.util.*;

public class LetterInventory {
    private int[] elementData;
    private int size;

    public static final int ALPHABET_SIZE = 26;

    // Takes a String and counts all letters case insensitively,
    // ignoring all non-alphabetic characters
    public LetterInventory(String data){
        data = data.toLowerCase();
        size = 0;
        elementData = new int[ALPHABET_SIZE];
        for (int i = 0; i < data.length(); i ++){
            if (data.charAt(i) >= 'a' && data.charAt(i) <= 'z'){
                elementData[data.charAt(i) - 'a'] ++;
                size ++;
            }
        }
    }

    // Takes a character while ignoring casing and if it is a letter 
    // it returns how many times that letter was in the String
    public int get(char letter){
        letter = check(letter);
        return elementData[letter - 'a'];
    }

    // Takes a value and a character while ignoring casing and if it is a letter
    // it changes the count of that letter to the value
    public void set(char letter, int value){
        letter = check(letter, value);
        size += value - elementData[letter - 'a'];
        elementData[letter - 'a'] = value;
    }

    // Returns sum of all the values the String
    public int size(){
        return size;
    }

    // If the String is empty this will return true and if not it will return false
    public boolean isEmpty(){
        return size == 0;
    }

    // Returns a visual representation of the letter counts in the String
    // in lowercase and in alphabetical order, returning each letter the amount
    // of times it was counted in the String
    public String toString(){
        String result = "";
        for (int i = 0; i < ALPHABET_SIZE; i ++){
            for (int o = 0; o < elementData[i]; o ++){
                result += (char) ('a' + i);
            }
        }
        return "[" + result + "]";
    }

    // Takes a different LetterInventory and adds its size to the size of the original
    // LetterInventory and returns the sum of the two sizes. The size of each LetterInventory
    // is the total amount of the letters in the String
    public LetterInventory add(LetterInventory other){
        LetterInventory total = new LetterInventory("");
        for (int i = 0; i < ALPHABET_SIZE; i ++){
            total.elementData[i] = other.elementData[i] + this.elementData[i];
        }
        total.size = other.size + this.size;
        return total;
    }

    // Takes a LetterInventory and subtracts its size from the size of the original
    // LetterInventory and returns the difference of the two sizes if the result is
    // positive, but if it is negative it will return null
    public LetterInventory subtract(LetterInventory other){
        LetterInventory diff = new LetterInventory("");
        for (int i = 0; i < ALPHABET_SIZE; i ++){
            diff.elementData[i] = this.elementData[i] - other.elementData[i];
            if (diff.elementData[i] < 0){
                return null;
            }
        }
        diff.size = this.size - other.size;
        return diff;
    }

    // Takes a character and checks if it is a letter case insensitively,
    // if it is a letter then it will return that letter but it will otherwise
    // give an error if it is not a letter
    private char check(char letter) throws IllegalArgumentException {
        letter = Character.toLowerCase(letter);
        if (letter < 'a' || letter > 'z'){
            throw new IllegalArgumentException();
        }
        return letter;
    }

    // Takes a character and a value and checks if the character is a letter
    // case insensitively and also checks if the value is positive. If the
    // character is a letter and the value is positive it will return the letter.
    // Otherwise, it will give an error if the character is not a letter or if
    // the value is negative
    private char check(char letter, int value) throws IllegalArgumentException {
        letter = check(letter);
        if (value < 0){
            throw new IllegalArgumentException();
        }
        return letter;
    }
}
