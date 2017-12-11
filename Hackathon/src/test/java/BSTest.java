package com.flyingpenguins.app;

import org.junit.*;
import static org.junit.Assert.assertTrue;

public class BSTest{
  BSForJPDF b;

  @Before
  public void init(){
    b = new BSForJPDF();
  }


  @Test
  public void isItFilled(){
    /*for(int i = 0; i < b.myInfo.length; i++){
      System.out.println((i+1) + ": " +b.myInfo[i]);
    }

    //System.out.println(b.myInfo.length);
    //assertTrue(b.myInfo[1704]!=null);TODO there is something very wrong here*/
  }

  @Test
  public void basicTests(){
    int f = b.search("טחול"); assertTrue("tachol did not work out, it was " + f, f == 528);
    int d = b.search("תתתתת"); assertTrue("taph taph taph did not work out, it was " + d, d == 1705);
    int a = b.search("א"); assertTrue("aleph did not work out, it was " + a, a == 1);
    int c = b.search("טט"); assertTrue("tet tet did not work out, it was " + c, c == 528);

  }


}
/*
public static void main (String [] args){//Test code should never be in the main
    JastrowTwo tester= new JastrowTwo();
    try {
        tester.start();
    } catch (IOException e) {
        e.printStackTrace();
    }

    tester.search("טגד"); //This is currently a few pages off. Reason can be in the mapping or the algorithm
}
*/
