public class LongestAlternativeContinuousSubArray {
    public static void main(String[] args) {
        int arr[] ={1,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0};
        System.out.println(longestAlternativeSubarray(arr));
    }

    public static String longestAlternativeSubarray(int[] nums) {
        int currentLength = 1;
        int maxLength = 1;
        int startIndex = 0;
        int bestIndex = 0;
        for(int i = 1; i < nums.length; i++){

            if(nums[i] != nums[i-1]){
                currentLength++;
                //endIndex++;
                //maxLength = Math.max(maxLength, currentLength);
            }else {
                startIndex = i;
                currentLength = 1;
            }
            if(currentLength > maxLength){
                maxLength = currentLength;
                bestIndex= startIndex;

            }
        }

        return bestIndex+","+(maxLength-1);
    }
}
