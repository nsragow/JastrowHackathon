package com.flyingpenguins.app;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

/**
 * Created by Aryeh on 10/28/2017.
 */
public class JastrowTwo {
    String [] myInfo;
    public JastrowTwo(){

    }

    public static void main (String [] args){
        JastrowTwo tester= new JastrowTwo();
        try {
            tester.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tester.search("אא"); //This is currently a few pages off. Reason can be in the mapping or the algorithm.
    }

    private void start() throws IOException{
        myInfo = splitFile();
        // myInfo =  new String[10];
        // myInfo[0]= "א";
        // myInfo[1] = "אב";
        // myInfo[2]= "אבד";
        // myInfo[3] = "אבוי";
        // myInfo[4] = "אבטוניות";
        //TAKE OUT PAGE 700


    }

    public void search(String input){
        int answer= search(input, 0, 1704);
        System.out.println("First element in array is " + myInfo[0]);
        System.out.println(input.compareTo(myInfo[0]));
        answer=answer+=1;
        System.out.println(answer);

    }

    private int search(String input, int low, int high){
        int mid= (high+low)/2;
        String a = myInfo[mid];
        if(low==high){
            return low;
        }else if(low>high){
            return high;
        }
        else if (input.compareTo(a)==0){
            return mid;
        }else if(input.compareTo(a)>0){
            System.out.println(input.compareTo(a + 1));

            low=mid+1;
            return search(input, low, high);
        }else if(input.compareToIgnoreCase(a)<0){
            System.out.println(input.compareTo(a));
            high=mid-1;
            return search(input, low, high);
        }
        return 0;
    }

    public static String[] splitFile() throws IOException {
        String[] result = new String[1704];//create new array of strings (dictoinary)
        String line;
        int i = 0;
        try (//read doc
                FileInputStream fis = new FileInputStream("C:\\Users\\yosef\\Documents\\YU Hackathon 2017\\JastrowHackathon\\jastrow.txt"); //C:/Users/Aryeh/OneDrive/Documents/YU/Hackathon2/JastrowHackathon/jastrow.txt");  //Specify filepath for jastrow.txt (list of header words in hebrew)
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null) {
                for (String n : line.split(" ")) {
                	String g = n.replaceAll("[\uFEFF-\uFFFF]", "");//this should get rid of our problem with א
                    result[i] = g;
                    i++;
                }
            }
        }catch(Exception e){
            throw new IOException("Oops");
        }
        return result;
    }
}
