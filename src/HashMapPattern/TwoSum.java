package HashMapPattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int [] arr = twoSum2(new int[]{3,3}, 6);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int [] result = new int[2];
        for(int i=0 ; i< nums.length ; i++){
            int a = target-nums[i]; // we have to substract nums[i] from target
            if(map.containsKey(a)){  // check substarcted result here
                result[0]=map.get(a); // if value contains get the index of the conatains value
                result[1]=i;
            }else{
                map.put(nums[i],i);//we need to add num[i] and index not the substra ted result (a)
            }
        }
        return result;
    }
}
