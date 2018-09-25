package cn.smallhk.cauchy.chapters;
/**
 * @author duangduangda
 */
public class Chapter1 {

    public static int reverseInt(int x){
        int dest = 0;
        while (x != 0){
            int temp = x % 10;
            x = x / 10;
            boolean largerThanMax = dest > Integer.MAX_VALUE / 10 || (dest == Integer.MAX_VALUE / 10 && temp > 7);
            if (largerThanMax){
                return 0;
            }
            boolean smallerThanMin = dest < Integer.MIN_VALUE / 10 || (dest == Integer.MIN_VALUE / 10 && temp < -8);
            if (smallerThanMin){
                return 0;
            }
            dest = dest * 10 + temp;
        }
        return dest;
    }

    public static int reverseInt1(int x){
        int dest = 0;
        try{
            if(x < 0){
                int temp = Math.abs(x);
                dest = 0 - Integer.parseInt(reverseString(String.valueOf(temp)));
            }else{
                dest =  Integer.parseInt(reverseString(String.valueOf(x)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dest;
    }

    private static String reverseString(String input) {
        char[] chars = input.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        char temp;
        while (i <= j){
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static boolean isPalindrome(int input) {
        if (input < 0){
            return  false;
        }
        int source = input;
        int dest = 0;
        while (input != 0){
            int temp = input % 10;
            input = input / 10;
            boolean largerThanMax = dest > Integer.MAX_VALUE / 10 || (dest == Integer.MAX_VALUE / 10 && temp > 7);
            if (largerThanMax){
                return false;
            }
            boolean smallerThanMin = dest < Integer.MIN_VALUE / 10 || (dest == Integer.MIN_VALUE / 10 && temp < -8);
            if (smallerThanMin){
                return false;
            }

            dest = dest * 10 + temp;
        }

        if (dest == source){
            return true;
        }
        return false;
    }

    public static boolean isPalindrome1(int input) {
        boolean isNaV = input < 0 || (input % 10 == 0 && input != 0);
        if (isNaV){
            return false;
        }

        int dest = 0;
        while (dest < input){
            dest = dest * 10 + input % 10;
            input = input / 10;
        }

        return dest == input || input == dest / 10;

    }
}
