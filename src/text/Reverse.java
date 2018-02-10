package text;

public class Reverse {

    static String reverseWord(String word){

        int len = word.length();
        String reverse = "";

        for(int i=(len-1); i >= 0; i-- ){
            reverse += word.charAt(i);
        }

        return reverse;
    }




}
