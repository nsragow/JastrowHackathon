
package com.flyingpenguins.app;


import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by noah on 7/17/17.
 */

public class Entry implements Serializable {
    String word;
    ArrayList<String> definitions;
    File pageImage;

    Entry(String word, String[] definitions){

        this.definitions = new ArrayList<String>();
        for(String s : definitions){
            this.definitions.add(s);
        }
        setWord(word);
    }

    boolean hasDefinitions(){
        return (definitions.size() > 0) ? true : false;
    }

    boolean hasPDF(){
        return (pageImage == null) ? false : true;
    }



    void setWord(String word){
        this.word = word;
    }
    String getWord(){
        return this.word;
    }
    List<String> getDefinitions(){
        return this.definitions;
    }
    void setDefinition(int index, String definition){
        this.definitions.add(index, definition);
    }

    void addDefinition(String definition){
        definitions.add(definition);
    }

    File getPageImage(){
        return pageImage;
    }

    byte[] toByteArray(){
        StringBuilder toReturn = new StringBuilder();
        toReturn.append(getWord() + "\n");

        for(String s : definitions){
            toReturn.append(s + "\n");
        }
        toReturn.append("\n");
        return toReturn.toString().getBytes();
    }

}
