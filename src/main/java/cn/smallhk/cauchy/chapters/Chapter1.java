package cn.smallhk.cauchy.chapters;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duangduangda
 */
public class Chapter1 {

    public static int reverseInt(int x) {
        int dest = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            boolean largerThanMax = dest > Integer.MAX_VALUE / 10 || (dest == Integer.MAX_VALUE / 10 && temp > 7);
            if (largerThanMax) {
                return 0;
            }
            boolean smallerThanMin = dest < Integer.MIN_VALUE / 10 || (dest == Integer.MIN_VALUE / 10 && temp < -8);
            if (smallerThanMin) {
                return 0;
            }
            dest = dest * 10 + temp;
        }
        return dest;
    }

    public static int reverseInt1(int x) {
        int dest = 0;
        try {
            if (x < 0) {
                int temp = Math.abs(x);
                dest = 0 - Integer.parseInt(reverseString(String.valueOf(temp)));
            } else {
                dest = Integer.parseInt(reverseString(String.valueOf(x)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dest;
    }

    private static String reverseString(String input) {
        char[] chars = input.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        char temp;
        while (i <= j) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static boolean isPalindrome(int input) {
        if (input < 0) {
            return false;
        }
        int source = input;
        int dest = 0;
        while (input != 0) {
            int temp = input % 10;
            input = input / 10;
            boolean largerThanMax = dest > Integer.MAX_VALUE / 10 || (dest == Integer.MAX_VALUE / 10 && temp > 7);
            if (largerThanMax) {
                return false;
            }
            boolean smallerThanMin = dest < Integer.MIN_VALUE / 10 || (dest == Integer.MIN_VALUE / 10 && temp < -8);
            if (smallerThanMin) {
                return false;
            }

            dest = dest * 10 + temp;
        }

        if (dest == source) {
            return true;
        }
        return false;
    }

    public static boolean isPalindrome1(int input) {
        boolean isNaV = input < 0 || (input % 10 == 0 && input != 0);
        if (isNaV) {
            return false;
        }

        int dest = 0;
        while (dest < input) {
            dest = dest * 10 + input % 10;
            input = input / 10;
        }

        return dest == input || input == dest / 10;

    }

    /**
     * leetcode 414
     * 1. 去重
     * 2. 处理1个或者两个元素时候取最大值的情况
     * 3. 如果元素为3以上，转化为求top n问题，此处采取了快排分治的思想
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        try {
            if (nums.length < 1){
                throw new Exception();
            }
            int[] temp = arrayUnique(nums);
            int len = temp.length;
            if (len == 1) {
                return temp[0];
            }else if (len == 2) {
                return Math.max(temp[0], temp[1]);
            }else if(len > 2){
                return getTopN(temp, 3, 0, temp.length - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int[] arrayUnique(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0;i < nums.length;i++){
            if (!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        int[]temp = new int[list.size()];
        for (int i = 0;i < list.size();i++){
            temp[i] = list.get(i);
        }
        return temp;
    }

    private static int getTopN(int[] nums, int n, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            if (partitionIndex == n - 1) {
                return nums[n - 1];
            } else if (partitionIndex > n - 1) {
                getTopN(nums, n, left, partitionIndex - 1);
            } else {
                getTopN(nums, n, partitionIndex + 1, right);
            }
        }
        return nums[n - 1];
    }

    private static int partition(int[] nums, int left, int right) {
        int i = left;
        int key = nums[right];
        for (int j = left;j < right;j++){
            if (nums[j] > key){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        nums[right] = nums[i];
        nums[i] = key;
        return i;
    }
}
