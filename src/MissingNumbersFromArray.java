public class MissingNumbersFromArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4};
        int xor = arr.length;
        for (int i = 0; i < arr.length; i++) {
            xor ^= i ^ arr[i];
            }
        }
    }

