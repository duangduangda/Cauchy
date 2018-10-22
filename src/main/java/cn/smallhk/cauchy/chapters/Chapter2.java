package cn.smallhk.cauchy.chapters;

import java.util.*;

/**
 * @author duangduangda
 */
public class Chapter2 {

    /**
     * 宝石与石头
     * @param jew
     * @param stone
     * @return
     */
    public static int numJewelsInStones(String jew, String stone) {
        char[] jews = jew.toCharArray();
        char[] stones = stone.toCharArray();
        int total = 0;
        for (int i = 0,len = jews.length;i < len;i++){
            for (int j = 0,length = stones.length;j < length;j++){
                if (stones[j] == jews[i]){
                    total += 1;
                }
            }
        }
        return total;
    }

    /**
     * 字母转小写
     * @param word
     * @return
     */
    public static String toLowerCase(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0;i < chars.length;i++){
            if (chars[i] >= 'A' && chars[i] <= 'Z'){
                chars[i] += 32;
            }
        }
        return new String(chars);
    }

    public static int lengthOfLongestSubstring(String word) {
        int len = word.length();

        return  len;
    }

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            while (left < right && nums[right] % 2 == 1){
                right--;
            }
            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            while (left < right && nums[left] % 2 == 0){
                left++;
            }
            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

        }
        for (int i = 0;i < nums.length;i++){
            System.out.print(nums[i] + "    ");
        }
        System.out.println();
        return nums;
    }

    /**
     * 反转字符串
     * @param word
     * @return
     */
    public static String reverseString(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0,k = chars.length - 1;i <= k;i++,k--){
            char temp = chars[i];
            chars[i] = chars[k];
            chars[k] = temp;
        }
        return new String(chars);
    }

    /**
     * 字符的最短距离
     * @param S
     * @param C
     * @return
     */
    public static int[] shortestToChar(String S, char C) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0;i < S.length();i++){
            if (S.charAt(i) == C){
                indexList.add(i);
            }
        }
        int[] result = new int[S.length()];
        for (int i = 0;i < result.length;i++){
            int min = Integer.MAX_VALUE;
            for (int j:indexList){
                int temp = Math.abs(j - i);
                if (temp < min){
                    min = temp;
                }
                result[i] = min;
            }
        }
        return result;
    }


    /**
     * 只出现一个数字
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0;i < nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
}
