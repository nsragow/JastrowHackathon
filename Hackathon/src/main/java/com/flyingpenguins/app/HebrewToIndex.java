

/**
 * Created by noah on 7/23/17.
 */
package com.flyingpenguins.app;
public class HebrewToIndex {
    static int convertToIndex(char c){
        int toReturn = -1;

        switch(c){
            case 'א':
                toReturn=0;
                break;
            case 'ב':
                toReturn=1;
                break;
            case 'ג':
                toReturn=2;
                break;
            case 'ד':
                toReturn=3;
                break;
            case 'ה':
                toReturn=4;
                break;
            case 'ו':
                toReturn=5;
                break;
            case 'ז':
                toReturn=6;
                break;
            case 'ח':
                toReturn=7;
                break;
            case 'ט':
                toReturn=8;
                break;
            case 'י':
                toReturn=9;
                break;
            case 'ך':
            case 'כ':
                toReturn=10;
                break;
            case 'ל':
                toReturn=11;
                break;
            case 'ם':
            case 'מ':
                toReturn=12;
                break;
            case 'ן' :

            case 'נ':
                toReturn=13;
                break;
            case 'ס':
                toReturn=14;
                break;
            case 'ע':
                toReturn=15;
                break;
            case 'ף':
            case 'פ':
                toReturn=16;
                break;
            case 'צ':
            case 'ץ':
                toReturn=17;
                break;
            case 'ק':
                toReturn=18;
                break;
            case 'ר':
                toReturn=19;
                break;
            case 'ש':
                toReturn=20;
                break;
            case 'ת':
                toReturn=21;
                break;
            default:
                return -1;


        }
        return toReturn;
    }
}
