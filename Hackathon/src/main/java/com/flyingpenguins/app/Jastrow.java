package com.flyingpenguins.app;
import net.sourceforge.tess4j.Tesseract;

import java.io.File;

/**
 * Created by Aryeh on 10/28/2017.
 */
public class Jastrow {
    public static void main(String [] args_){
        //String inputFilePath = "C:\\Users\\Aryeh\\OneDrive\\Documents\\YU\\Hackathon2\\JastrowHackathon\\Testertiff.tiff";
       String inputFilePath = "C:/Users/Aryeh/OneDrive/Documents/YU/Hackathon2/JastrowHackathon/Testertiff.tiff";


        Tesseract tess = new Tesseract();
        System.out.println("hello");
        tess.setDatapath("C:/Users/Aryeh/OneDrive/Documents/YU/Hackathon2/JastrowHackathon/TessLanguages/");
        //tess.setDatapath("C:\\Users\\Aryeh\\OneDrive\\Documents\\YU\\Hackathon2\\JastrowHackathon\\TessLanguages\\");
        //tess.setLanguage("eng");
        String myText= "";
        File myFile = new File(inputFilePath);
        try{
             myText =  tess.doOCR(myFile);
            //myText =  tess.doOCR(new File(inputFilePath));

        }catch(Exception e){
            System.out.println("oops");
        }
        System.out.println(myText);



    }
}
