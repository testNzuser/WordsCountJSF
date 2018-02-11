package service;


import beans.WordAndCount;

import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Frequences {

    public void addWord (ArrayList<WordAndCount> words1, String word1) {
        Boolean inList = false;
        for (WordAndCount ww : words1) {
            if (ww.getWord().equals(word1)) {
                int i = ww.getCount();
                i++;
                ww.setCount(i);
                inList = true;
            }
        }
        if (!inList) {words1.add (new WordAndCount(word1, 1)); }//
    }

    public ArrayList <WordAndCount>  wordsWhiteSpaces (Part file, String encoding) {
        ArrayList <WordAndCount> words = new ArrayList<WordAndCount>();
        System.out.println("Encoding "+encoding+" whatever");
if ((encoding == null) || (encoding.length()<1)) {encoding="UTF8";}
        //encoding="UTF8";
            try {
                InputStream input = file.getInputStream();
              // BufferedReader br = new BufferedReader(new InputStreamReader(input, "UTF8" ));
               // BufferedReader br = new BufferedReader(new InputStreamReader(input, "UTF-16LE" ));
                BufferedReader br = new BufferedReader(new InputStreamReader(input, encoding));

              //  BufferedReader br = new BufferedReader(new InputStreamReader(input));

            String line;

            while ((line = br.readLine()) != null) {
            //    line=line.replaceAll("([A-Z])", "").toLowerCase();
                line=line.toLowerCase();
                String[] arr = line.split("[\\s,.()?;!:;\"]+");


                //"[^A-Za-zа-яöäå]" check if real word letters somehow

                for ( String ss : arr) {
                    //if(!(ss.contains("[^A-Za-zа-яöäå]")))
                    if((ss.matches(".*[^a-zа-яåöä].*"))||(ss.length()<1))

                    {
                       // System.out.println("special "+ss);
                    }
                    else
                    {
                        addWord(words, ss);
                     //   System.out.println(ss);
                    }


                }
            }

            /*
        //another way to sort the words with TreeMap
           TreeMap<String, Integer> myMap  = new TreeMap <String, Integer> ();
           while ((line = br.readLine()) != null) {
                String[] arr = line.split("[\\s,;!:;\"]+");
                //"[^A-Za-z0-9]" check if real word letters somehow

                for ( String ss : arr) {

                    if(myMap.get(ss) == null) {
                        myMap.put(ss, 1);
                    }
                    else {
                        myMap.put(ss, (myMap.get(ss))+1);
                    }
                }
            }
            for(Map.Entry<String,Integer> entry : myMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                words.add(new WordAndCount(key, value));
            }
            */
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }


}