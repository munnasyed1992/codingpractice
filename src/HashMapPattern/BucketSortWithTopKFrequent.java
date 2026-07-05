package HashMapPattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BucketSortWithTopKFrequent {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequentBucketSortHeap(new int[]{1, 2, 3, 4, 5, 5, 7, 8, 9, 10}, 2)));
    }

    public static int[] topKFrequentBucketSortHeap(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int[] sortBucket = new int[nums.length+1];

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            sortBucket[entry.getValue()] = entry.getKey();
        }
        return sortBucket;
    }
}
