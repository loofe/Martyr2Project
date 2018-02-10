package text;

public class PigLatin {

    static String pigLatinGame(String word){

        int len = word.length();
        String pig = "";
        char first = word.charAt(0);

        if( !isVowel(first) ){
            for(int i=1; i < len; i++){
                pig += word.charAt(i);
            }
            pig = pig + "-" + first + "ay";
        }else{
            pig = word + "-way";
        }


        return pig;
    }

    static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

}
