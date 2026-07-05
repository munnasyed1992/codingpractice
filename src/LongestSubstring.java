import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abczabcbb";
        int max = 0;
        int len= 0;
        char[] chars =s.toCharArray();
        Map<Character,Integer> result = new HashMap<>();
        int j = 0;
        for(int i=0;i<chars.length;i++) {
                if (result.containsKey(chars[i])) {
                    j = result.get(chars[i]) + 1;
                }
                    result.put(chars[i], i);
                len = i - j + 1;
                max = Math.max(max, len);
        }
        System.out.println(max);
    }
}
