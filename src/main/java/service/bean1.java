package service;


import beans.WordAndCount;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import javax.inject.Named;
import javax.servlet.http.Part;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

//@ViewScoped
//@SessionScoped
@ApplicationScoped
@ManagedBean

//@Named

public class bean1 {

 //   private String fileImitation="";
    private String fileImitation1="";
    private String encoding2;

    public String getEncoding2() {
        return encoding2;
    }

    public void setEncoding2(String encoding2) {
        this.encoding2 = encoding2;
    }

    private Part file2;

    public Part getFile2() {
        return file2;
    }
    public void setFile2(Part file2) {
        this.file2 = file2;
    }

   public void printWordsToPage() {

    ArrayList<WordAndCount> wordlist = new ArrayList<WordAndCount>();
       fileImitation1="";
       //encoding2="UTF8";


       Set encodingA = Charset.availableCharsets().keySet();
       for (Object a:encodingA){
           String b= (String) a;
           System.out.println(b);
       }
      // final JComboBox var5 = new JComboBox(var4.toArray());
    wordlist = new Frequences().wordsWhiteSpaces(file2, encoding2);

    wordlist.sort(Comparator.comparing(WordAndCount::getCount).reversed());

    for (WordAndCount wac : wordlist) {
fileImitation1+=wac.getWord()+ " "+ wac.getCount()+"<br />";
    }
}
   // public String getMessage3() {        return fileImitation;    }
    public String getMessage4() {
        return fileImitation1;
    }




}


