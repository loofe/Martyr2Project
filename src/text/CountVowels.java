package text;

/*
 *  Count Vowels –
 *  Enter a string and the program counts the number of vowels in the text.
 *  For added complexity have it report a sum of each vowel found.
 *
 *
 */


public class CountVowels {

    public static int countVowels(String str){
        int count = 0;
        for (char c: str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countVowels("aeioubbs"));
    }
}
