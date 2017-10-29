/**
 * Created by Aryeh on 10/29/2017.
 */
public class HebrewCompareTester {
    public static void main(String [] args){
        String a = "א";
        String b= "אאי";
        System.out.println(b.compareTo(a));
        if(b.compareTo(a)>0){
            System.out.println("Working properly");
        }else if(b.compareTo(a)<0){
            System.out.println("Miskatake");
        }
    }
}
