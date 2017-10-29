package com.flyingpenguins.app;

public class HebrewCheck {

    private boolean result = false;

    public static void main(String[] args) {
    }

    public boolean Run(String input) {
        return InputCheck(input);
    }

    private boolean InputCheck(String input) {
        int first = (int) 'א';
        int last = (int) 'ת';
        int count = 0;
        int i = 0;
        for (i = 0; i < input.length() - 1; i++) {
            int univalue = (int) input.charAt(i);
            if ((univalue >= first) && (univalue <= last)) {
                count++;
            } else {
		System.out.println("Returned false");
	    }
        }
        System.out.println("Returned true");
	return true;
    }
}
