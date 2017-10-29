import net.sourceforge.tess4j.Tesseract;

import java.io.File;

/**
 * Created by Aryeh on 10/28/2017.
 */
public class Jastrow {
    public static void main(String [] args_){
        String inputFilePath = "C:\\Users\\Aryeh\\OneDrive\\Documents\\YU\\Hackathon2\\JastrowHackathon\\Threepages.pdf";
        Tesseract tess = new Tesseract();
        tess.setDatapath("C:\\Users\\Aryeh\\OneDrive\\Documents\\YU\\Hackathon2\\JastrowHackathon\\TessLanguages");
        tess.setLanguage("eng");
        String myText= "";
        try{
             myText =  tess.doOCR(new File(inputFilePath));
        }catch(Exception e){
            System.out.println("oops");
        }
        System.out.println(myText);



    }
}
