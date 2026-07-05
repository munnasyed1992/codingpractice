package strings;

import java.util.HashSet;
import java.util.Set;

public class SecondDuplicate {
    public static void main(String[] args) {
        String s= "munnamunna";

        /*LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();

        for(char c : s.toCharArray()){

            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int count =0;

       for(Map.Entry<Character,Integer> entry : map.entrySet()){
           if(count == 1 && entry.getValue()>1){
               System.out.println(entry.getKey());
               return;
           }
           if(entry.getValue() >1){
               count++;
           }
       }*/

        Set<Character> set = new HashSet<>();
        int count = 0;
        for(char c : s.toCharArray()){
            if(!set.add(c)){
                count++;
                if(count == 2){
                    System.out.println(c);
                    return;
                }
            }
        }


    }
}
