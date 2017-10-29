package com.flyingpenguins.app;

public class HebrewCheck {

    private boolean result = false;

    public static void main(String[] args) {
    }

    public boolean Run(String input) {
        return InputCheck(input);
    }

    private boolean InputCheck(String input) {
        int א = (int) 'א';
        int ת = (int) 'ת';
        int count = 0;
        int i = 0;
        for (i = 0; i < input.length() - 1; i++) {
            int univalue = (int) input.charAt(i);
            if ((univalue >= א) && (univalue <= ת)) {
                count++;
            }
        }
        if (count++ == input.length()) {
            result = true;
            return result;
        }
        return result;
    }
}
