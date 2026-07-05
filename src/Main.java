//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] input = {1,2,4,5};
        int n =input.length+1;
        int naturalTotal = n* (n + 1) / 2;
        int arrTotal = 0;
int arrXor = 0;
        for (int i = 0; i < input.length; i++) {
            arrTotal += input[i];
            arrXor ^= input[i];
        }
        System.out.println(arrTotal);
        System.out.println(naturalTotal);
        System.out.println(naturalTotal-arrTotal);
        System.out.println(10^11);
        int j =0;
        int xorResult=0;
        while(j<= n){
             xorResult = xorResult ^ j;
             j++;
        }
        System.out.println(xorResult ^ arrXor);
    }
}
