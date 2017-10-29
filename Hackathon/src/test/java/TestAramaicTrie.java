package com.flyingpenguins.app;

import org.junit.*;
import static org.junit.Assert.assertTrue;


public class TestAramaicTrie
{
  @Test
  public void basicInput() {
    String[] defs = new String[]{"adg", "dggont", "adgd", "addfg"};
    Entry a = new Entry("ככ", defs);
    Entry aa = new Entry("דד", defs);
    Entry aaa = new Entry("שש", defs);
    Entry as = new Entry("עע", defs);
    Entry ass = new Entry("גע", defs);
    Entry[] entries = new Entry[]{a,aa,aaa,as,ass};

    AramaicTrie aT = new AramaicTrie();
    assertTrue("The trie is null", aT!=null);
    System.out.println("This is the object \n\n\n" + aT.toString());
    for(Entry e : entries){
      if(e == null){
        System.out.println("its null\n\n\n\n");
      }
      System.out.println(aT.toString());
      aT.addEntry(e);
    }
    assertTrue(true);
  }
}
