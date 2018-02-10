package text;

public class PalindromeCheck {



    public static boolean checkPalindrome(String str){
        
        boolean isPalindromed = true;

        for (int i = 0; i < ((str.length() + 1)/2); i++) {

            if (str.charAt(i) != str.charAt(str.length() - 1 - i) ){
                return false;
            }

        }
        
        
        
        return isPalindromed;
    }


    public static void main(String[] args) {
        System.out.println(checkPalindrome("abc"));
    }

}
