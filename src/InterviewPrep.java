import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InterviewPrep {
    public static void main(String[] args) {
        majarityElement();
        System.out.println(twoSum(new int[]{1,2,3,4,4,4,4,5,6,7}, 8));

        System.out.println("shift zeros to left ");
        shiftZerosToLeft(new int [] {1,0,3,4,0,5,0});

        System.out.println("Three sum ");
        System.out.println("3Sum pairs = "+threeSum(new int[]{1,2,3,4,4,4,4,5,6,7}, 8));

        System.out.println("Highest water container");
        System.out.println("Highest water container= "+highestWaterContainer(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

        System.out.println("Consecutive zeros");
        System.out.println(consecutiveZerosCount(new int[]{1,2,0,0,0,3,5}));

        System.out.println("Longest consecutive zeros");
        System.out.println(longestConsecutiveZeros(new int[]{1,2,0,0,0,3,5,0,0,0,0,0}));

        System.out.println("Squares of a Sorted Array");
        System.out.println(squaresOfSortedArray(new int[]{-4,-3,-2,-1,0,1,2,3,4,5}));

        System.out.println("Reverse a string");
        System.out.println(reverseString("Hello World"));

        System.out.println("Merge sorted array");
        mergeSortedArray(new int[] {4, 5, 6, 0, 0, 0},new int []{1, 2, 3},3,3);

        System.out.println("Remove Element (#27)");
        removeElement(new int[] {3, 2, 2, 3},3);

       int [] arr = twoSum2(new int[]{3,3}, 6);
       System.out.println(Arrays.toString(arr));
    }

    private static void majarityElement() {
        //int arr [] = {2,2,1,1,1,2,2,1};
        int arr [] = {1,2,3,4};

        int count = 0;
        int candidate = 0;
        for (int i =0 ;i< arr.length ; i++){
            if(count == 0){
                candidate=arr[i];
            }
            if(arr[i] == candidate){
                count ++;
            }else{
                count --;
            }
        }
        if(count > arr.length){
            System.out.println(candidate);
        }else {
            System.out.println("no candidate found");
        }
    }

    //TWO SUM PROBLEM
    //move right when sum is greater than target
    //move left when sum is less than target
    public static String twoSum(int input [],int target){
        
        int left =0;
        int right =input.length-1;
        String result = "";
        
        while(left<right){
            
            if (input[left] +input[right] > target){
                right --;
            }else if(input[left] +input[right] < target){
                left ++;
            }else {
                //Single pair
                //result= "("+left+","+right+")";
                //All pairs
                result += "("+left+","+right+")";
                right--;
                left++;
            }
            if(left < right && input[left] == input[left-1]){
                left++;
            }
            if (left < right && input[right] == input[right+1]){
                right--;
            }
        }
        
        
        return result;
    }

    public static void shiftZerosToLeft(int arr [] ){

        int assigner = arr.length-1;
        for(int i=arr.length-1; i>=0 ;i --){
            if(arr[i] != 0){
                arr[assigner] = arr[i];
                assigner--;
            }

        }
        while(assigner >=0){
            arr[assigner] =0;
            assigner--;
        }
        for (int a : arr){
            System.out.print(a + " ");
        }
        System.out.println();
    }
    public static String threeSum(int [] arr,int target){

        //3Sum, you fix one element, then use two pointers on the remaining subarray.

        int left =0;
        int right =arr.length-1;

        var output = "";

for(int i=0;i <arr.length;i++) {
    left = i+1;
    while (left < right) {
        if (arr[left] + arr[i] + arr[right] > target) {
            right--;
        } else if (arr[left] + arr[i] + arr[right] < target) {
            left++;
        } else {
            output += "(" + i + "," + left + "," + right + ")";
            right--;
            left++;
        }
        if(left < right && arr[left] == arr[left-1]){
            left++;
        }if(left < right && arr[right]== arr[right+1]){
            right --;
        }
    }
}
        return output;
    }

    public static int highestWaterContainer(int [] arr){

        int left =0;
        int right = arr.length-1;
        int maxWater=0;

        while (left < right){

            int area =  Math.min(arr[left],arr[right])*(right-left);
            maxWater = Math.max(maxWater,area);

            if(arr[left ]< arr[right])
                left ++;
            else
                right --;
        }

        return maxWater;
    }

    public static int consecutiveZerosCount(int [] arr){

        int i=0;
        int count=0;
        while(i < arr.length){
            if(arr[i] ==0 && arr[i+1]==0){
                count++;
            }
            i++;

        }
        return count;

    }

    public static int longestConsecutiveZeros(int [] arr){


        int count=0;
        int maxCount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] ==0){
                count++;
                maxCount =Math.max(maxCount,count);
            }else {
                count =0;
            }


        }
        return maxCount;

    }

    public static int [] squaresOfSortedArray(int [] arr){

        int [] result = new int[arr.length];
        int left =0;
        int right =arr.length-1;
        int pos = 0;

        while(left <= right ){
            /*int rightValue = arr[right];
            arr[right] = arr[left] * arr[left];
            arr[left] = rightValue*rightValue;*/
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if(leftSquare > rightSquare){
                result[pos] =  leftSquare;
               left++;
            }else{
                result[pos] = rightSquare;
                right--;
            }
            pos++;
        }
        for(int i : result){
            System.out.print(i+",");
        }

        return arr;
    }

    public static String reverseString(String s){

        char [] arr=s.toCharArray();

        int left =0;
        int right =arr.length-1;
        while(left < right){
            char ch = arr[left];
            arr[left] = arr[right];
            arr[right]=ch;
            left++;
            right--;
        }

        return Arrays.toString(arr);
    }

    public static void mergeSortedArray(int [] arr1,int [] arr2,int m,int n){
        int p1 = m-1;
        int p2 = n-1;
        int pos = arr1.length-1;

        while(p1 >=0 && p2 >=0){
            if(arr2[p2] > arr1[p1]){
                arr1[pos] = arr2[p2];
                p2--;
            }else{
                arr1[pos] = arr1[p1];
                p1--;
            }
            pos--;
        }
        while(p2>=0){
            arr1[pos] =arr2[p2];
            p2--;
            pos--;
        }
        System.out.println(Arrays.toString(arr1));

    }

    //Remove Element (#27)
    //Given an integer array nums and a value val, remove all occurrences of val in-place.
    // The order of remaining elements can stay the same. Return the count of elements that are not equal to val.
    public static void removeElement(int [] arr,int value){

        int pos = 0;

        for(int i =0;i < arr.length;i++){
            if(arr[i] != value){
                arr[pos] = arr[i];
                pos++;
            }

        }
        System.out.println("count of unmatched elements "+ (arr.length-pos));
        while(pos < arr.length){
            arr[pos] = 0;
            pos++;
        }
        printArray(arr);


    }





    public  static void printArray(int [] arr){
        for(int i : arr){
            System.out.print(i+",");
        }
        System.out.println();
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int [] result = new int[2];
        for(int i=0 ; i< nums.length ; i++){
            int a = target-nums[i];
            if(map.containsKey(a)){
                result[0]=map.get(a);
                result[1]=i;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }

}
