package text;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class CountWord {



    public static void wordCounter(String str){


        //将字符串按照规则截取为String数组
        String[] strToArray = str.split("[' '|,|.]");
        //建立Map，存储获得的单词为Key值，出现次数为对应的Value值
        Map<String, Integer> strMap = new HashMap<String, Integer>();
        //遍历数组
        for(int i=0;i<strToArray.length;i++){
            if(" "!=strToArray[i]){
                if(strMap.containsKey(strToArray[i])){
                    strMap.put(strToArray[i], strMap.get(strToArray[i])+1);
                }else
                    strMap.put(strToArray[i], 1);
            }
        }
        Set<Map.Entry<String, Integer>> it = strMap.entrySet();
        Iterator<Entry<String, Integer>> iter = it.iterator();
        while(iter.hasNext()){
            Entry<String, Integer> end = (Entry<String, Integer>) iter.next();
            System.out.println("单词"+end.getKey()+"出现的次数："+end.getValue());
        }

    }

    public static void main(String[] args) {
         String sentence = "Beijing on Friday urged Washington to respect historical facts and "
                + "not take sides on territorial disputes in the East China Sea and South China Sea, as US Secretary "
                + "of State John Kerry met Chinese leaders.";

         wordCounter(sentence);

    }

}
