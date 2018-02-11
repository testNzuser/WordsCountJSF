package beans;


public class WordAndCount {
    private String word;
    private int count;


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public WordAndCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

}
