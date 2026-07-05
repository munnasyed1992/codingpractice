package HashMapPattern;

import java.util.HashMap;
import java.util.Map;
/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.
* An anagram is a word or phrase formed by rearranging the letters of another word or phrase,
*  using all the original letters exactly once*/
public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }
    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        if(s.length() != t.length()){ // if lengths are not matching no need of checking
            return false;
        }
        char [] sArray = s.toCharArray();
        char [] tArray = t.toCharArray();
        //this loops adds all the elements into map with each character frequency
        for (int i=0;i<sArray.length;i++){
            if(map.containsKey(sArray[i])){
                map.put(sArray[i],map.get(sArray[i])+1);

            }else{
                map.put(sArray[i],1);
            }
        }
        //this loops checks each character from second string into map
        for(int i=0;i < tArray.length;i++){
            if(map.containsKey(tArray[i])){
                if(map.get(tArray[i]) == 0 ){ //we are returning false here because when char count is
                    // already 0 and if it is still available means we have extra character means
                    return false;
                }
                map.put(tArray[i],map.get(tArray[i])-1);
            }else{
                return false;
            }
        }
        return true;
    }
}
