

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by noah on 7/17/17.
 */

class Node implements Serializable {
    Node[] children;
    Entry entry;


    Node[] getChildren() {

        return children;
    }

    List<Node> getActiveChildren(){
        ArrayList<Node> toReturn = new ArrayList<Node>();

        for(Node child : children){
            if(child != null){
                toReturn.add(child);
            }
        }

        return toReturn;
    }

    private void setChild(int index, Entry entry) {
        if(index > 22 || index < 0){
            throw new RuntimeException("out of Bounds, index must be inclusively between 0 and 22");
        }
        if(children[index] == null){
            setUpChild(index);
        }
        this.children[index].setEntry(entry);
    }

    Entry getEntry() {
        return entry;
    }

    void setEntry(Entry entry) {
        this.entry = entry;
    }



    Node(){
        children = new Node[22];
        entry = null;
    }

    void setUpChild(int letter){
        if(letter > 22 || letter < 0){
            throw new RuntimeException("out of Bounds, index must be inclusively between 0 and 22");
        }
        else if(this.children[letter] == null){
            this.children[letter] = new Node();
        }
    }


    public void addDefinition(int index, Entry entry) {
        if(index > 22 || index < 0){
            throw new RuntimeException("out of Bounds, index must be inclusively between 0 and 22");
        }
        Node childToAddTo = children[index];
        if(childToAddTo == null){
            setUpChild(index);
        }
        childToAddTo.addDefinition(entry);
    }

    public void addDefinition(Entry entry){
        this.addToEntry(entry);
    }

    private void addToEntry(Entry entry) {
        String[] newDefinitions;
        int entryLength, thisLength;
        entryLength = entry.getDefinitions().size();
        thisLength = 0; //this is a temporary measure which will be kept if this is null
        if(this.getEntry() != null) { //So there are previous definitions
            if (!this.getEntry().getWord().equals(entry.getWord())) {
                throw new RuntimeException("trying to add to definition with incorrect word! " + this.getEntry().getWord() + "/" + entry.getWord());
            }
            thisLength = this.getEntry().getDefinitions().size();
            newDefinitions = new String[entryLength + thisLength];
            int index = 0;
            while(index < thisLength){
                newDefinitions[index] = this.getEntry().getDefinitions().get(index);
                index++;
            }
            int offset = index;
            while((index - offset) < entryLength){
                newDefinitions[index] = entry.getDefinitions().get(index - offset);
                index++;
            }
            this.getEntry().definitions.clear();
            for(String s : newDefinitions){
                this.getEntry().addDefinition(s);
            }
        }
        else{
            this.setEntry(entry);
        }


    }
}
