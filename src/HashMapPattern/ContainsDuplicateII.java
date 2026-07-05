package HashMapPattern;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 1, 1}, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){

            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]); // get the previous value from map once it is matched
                                             // (key is actual value from array and value will be indices of array )
                int calValue = i-value; // calculate the distance, i always higher than the previous value index
                if(calValue <= k){
                    return true;
                }
            }
                map.put(nums[i],i); // always update the index because we need to add when new key and if key already available and not satisfy the condition
        }
        return false ;
    }
}
