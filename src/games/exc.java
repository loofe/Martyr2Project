package games;
import java.util.Random;
import java.util.Scanner;

public class exc { // 差点写成ex咖喱棒啊

    static final String [] strBased = {"string","class","interface","main","static" };
    static int guessedNum = 0;


    public static void main(String[] args) {

        Random random = new Random(  );
        char[] chars = strBased[random.nextInt( strBased.length )].toCharArray();
        System.out.println("你要猜测的单词是" + new String( chars ) );
        char guessChar =' ' ;

        for (int i = 20; i > 0; i--){
            int temp = guessedNum;
            System.out.println("现在你有" + i +"次机会");
            System.out.println("现在你猜测的情况是：");
            for (int j = 0; j < chars.length; j++) {

                if( temp == 0 ){
                    System.out.print( '_' );
                } else {
                    System.out.print(chars[j] );
                    temp--;
                }

            }
            System.out.println();
            System.out.println("请输入你猜测的字母");

            Scanner scan = new Scanner(System.in);
            String tempStr = scan.nextLine();
            if ( tempStr.length() != 0 ){
                System.out.println("你的输入有误");
                continue;
            }else {
                guessChar = tempStr.charAt( 0 );
            }


            if( chars[guessedNum ] == guessChar){
                guessedNum++;
                System.out.println("恭喜你猜对了");
            }else {
                System.out.println("猜错了很遗憾");
            }

            if(guessedNum == chars.length ){
                System.out.println("恭喜你全部蒙对了");
                break;
            }


        }
    }


}