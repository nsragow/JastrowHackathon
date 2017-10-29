import org.junit.*;

public class TestAramaicTrie
{
  @Test
  public void basicInput() {
    String[] defs = new String[]{"adg", "dggont", "adgd", "addfg"};
    Entry a = new Entry("five", defs);
    Entry aa = new Entry("four", defs);
    Entry aaa = new Entry("three", defs);
    Entry as = new Entry("two", defs);
    Entry ass = new Entry("one", defs);
    Entry[] entries = new Entry[]{a,aa,aaa,as,ass};

    AramaicTrie aT = new AramaicTrie();
    for(Entry e : entries){
      aT.addEntry(e);
    }
  }
}
