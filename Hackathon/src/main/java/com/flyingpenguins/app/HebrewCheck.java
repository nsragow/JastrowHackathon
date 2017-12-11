package com.flyingpenguins.app;

public class HebrewCheck {

    public boolean isBasicHebrewCharacters(String input) {
        char[] chars = input.toCharArray();
        for(char c : chars){
          if(HebrewToIndex.convertToIndex(c) == -1)
          return false; //found a char that is not hebrew
        }
        return true;
    }

}
