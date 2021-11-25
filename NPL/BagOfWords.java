package NPL;

import java.util.HashMap;
import java.util.Map;

public class BagOfWords{
    private static Map<Character, Integer> countLetters(String word){
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for(Character c: word.toCharArray()){
            if(dict.get(c)==null){
                dict.put(c,1);
            }else{
                dict.put(c,dict.get(c)+1);
            }
        }
        return dict;
    }
    public static Double percMatch(String first, String second){
        double result = -1;
        if(first.length()!=0 && second.length()!=0){
            double diff = wordDist(first, second);
            result = (first.length()-diff)/first.length();
        }
        return result;
    }
    public static Double wordDist(String first, String second){
        Map<Character, Integer> dictFirst = countLetters(first);
        Map<Character, Integer> dictSecond = countLetters(second);
        Map<Character, Integer> difference = new HashMap<Character, Integer>();

        double diff = 0;
        for(Character key: dictFirst.keySet()){
            int diffAux = 0;
            if(dictSecond.get(key)!=null){
                diffAux = Math.abs(dictFirst.get(key)-dictSecond.get(key));
            }else{
                diffAux = dictFirst.get(key);
            }
            difference.put(key,diffAux);
            diff += diffAux;
            
        }
        for(Character key: dictSecond.keySet()){
            if(difference.get(key)==null){
                diff += dictSecond.get(key);
                difference.put(key,dictSecond.get(key));
            }
        }
        return diff;
    }
}