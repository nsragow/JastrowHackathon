

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by noah on 7/17/17.
 */

public class AramaicTrie implements Serializable {
    Node root;
    int autoCompleteCount;

    AramaicTrie(){
        root = new Node();
    }

    Entry getEntry(String searchTerm){ //TODO make sure to check all possible nulls
        Node toReturn = getNodeOf(searchTerm, false);
        if(toReturn == null){
            return null;
        }
        else{
            return toReturn.getEntry();
        }
    }

    void addEntry(Entry toAdd){
        /*Node startingPoint = root;
        int index = 0;
        char[] word = toAdd.getWord().toCharArray();

        addEntry(word, index, startingPoint, toAdd);
        */

        if(toAdd == null){
          throw new NullPointerException("cannot add null entry");
        }
        Node toBeAddedTo = getNodeOf(toAdd.getWord(), true);
        toBeAddedTo.addDefinition(toAdd);
    }

    void addEntries(ArrayList<ArrayList<String>> dictionary){
        for(ArrayList<String> entry : dictionary){
            String[] keywords;
            if(entry.size() == 0){// temporary measure for making sure the source is formatted properlly TODO:Remove this
                throw new RuntimeException("empty entry");
            }
            if(entry.get(0).contains(" ")) {
                keywords = entry.get(0).split(" ");
            }
            else {
                keywords = new String[]{entry.get(0)};
            }
            entry.remove(0);

            String[] definitions = entry.toArray(new String[entry.size()]);
            for (String keyword : keywords) {
                addEntry(new Entry(keyword, definitions));
            }

        }
    }

    private void addEntry(char[] word, int index, Node node, Entry toAdd) {
        int letter = HebrewToIndex.convertToIndex(word[index]);

        if(index == word.length-1){//we are ready to insert
            node.addDefinition(letter, toAdd);



        }

        else if(index < word.length-1) {

            node = node.getChildren()[letter];
            index++;
            addEntry(word, index, node, toAdd);

        }

    }

    private Node getNodeOf(char[] combination, int index, Node node, boolean createEntries){
        int childIndex = HebrewToIndex.convertToIndex(combination[index]);
        if(childIndex == -1){
            return null;
        }
        if(createEntries){
            node.setUpChild(childIndex);

        }
        Node nextNode = node.getChildren()[childIndex];

        if(nextNode == null){
            if(createEntries) nextNode = new Node();
            else return null;
        }
        if(index == combination.length-1){//we are ready to insert
            return nextNode;
        }


        else if(index < combination.length-1) {
            return getNodeOf(combination, ++index, nextNode, createEntries);
        }
        else{
            throw new RuntimeException("index out of bounds");
        }
    }

    private Node getNodeOf(String combination, boolean createEntries){
        return getNodeOf(combination.toCharArray(), 0, root, createEntries);
    }

    /*
    this method returns in depth order, which is alphabetical order
     */
    List<String> getAutoComplete(String prefix, int amount){
        if(prefix.isEmpty()){
            return new ArrayList<String>();
        }
        Node startingFrom = getNodeOf(prefix, false);
        autoCompleteCount = amount;

        return getAutoComplete(startingFrom);

    }

    private List<String> getAutoComplete(Node startingFrom) {
        List<String> toReturn = new LinkedList<>();
        if(startingFrom == null){
            return toReturn;
        }
        List<Node> children = startingFrom.getActiveChildren();


        if(autoCompleteCount < 1){ //this prevents too many calls to this method
            return toReturn;
        }
        Entry e = startingFrom.getEntry();
        if(e != null){
            toReturn.add(e.getWord());
            autoCompleteCount--;
        }

        if(!children.isEmpty()){ //this 'if' is not necessary

            for(Node child : children){
                toReturn.addAll(getAutoComplete(child));
            }
        }

        return toReturn;

    }

}
