public class ReverseString {
    public static void main(String[] args) {
        String s = "munna";
        System.out.println(isPalindrome(s));
        System.out.println(recurssive(s,0,s.length()-1));
    }

    public static boolean isPalindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;

        }
       return true;
    }
    public static boolean recurssive(String s,int l1,int r1){

        if(l1>=r1){
            return true;
        }
        if (s.charAt(l1)!=s.charAt(r1)){
            return false;
        }
        return recurssive(s,l1+1,r1-1);
    }

    public static boolean isNumberpalindrome(int number){

        return true;
    }
}
