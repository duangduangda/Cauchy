package cn.smallhk.cauchy.chapters;

import java.util.*;

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
     *
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        try {
            if (nums.length < 1) {
                throw new Exception();
            }
            int[] temp = arrayUnique(nums);
            int len = temp.length;
            if (len == 1) {
                return temp[0];
            } else if (len == 2) {
                return Math.max(temp[0], temp[1]);
            } else if (len > 2) {
                return getTopN(temp, 3, 0, temp.length - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int[] arrayUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        int[] temp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i);
        }
        return temp;
    }

    private static int getTopN(int[] nums, int n, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            if (partitionIndex > n - 1) {
                return getTopN(nums, n, left, partitionIndex - 1);
            }
            if (partitionIndex < n - 1) {
                return getTopN(nums, n, partitionIndex + 1, right);
            }
        }
        return nums[n - 1];
    }

    private static int partition(int[] nums, int left, int right) {
        int i = left;
        int key = nums[right];
        for (int j = left; j < right; j++) {
            if (nums[j] > key) {
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

    /**
     * leetcode215 数组中的第K大元素top n问题
     *
     * @param nums
     * @param n
     * @return
     */
    public static int findKthLargest(int[] nums, int n) {
        int len = nums.length;
        if (n <= 0 || n > len) {
            return -1;
        }

        return getTopN(nums, n, 0, len - 1);
    }

    public static List<Integer> topKFrequent(int[] nums, int n) {
        List<Integer> list = new ArrayList<>(n);
        Map<Integer, Integer> dataMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dataMap.get(nums[i]) == null) {
                dataMap.put(nums[i], 1);
            } else {
                dataMap.put(nums[i], dataMap.get(nums[i]) + 1);
            }
        }

        for (Integer key : dataMap.keySet()) {
            list.add(key);
        }

        return list.subList(0, n);
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        return doBinarySearch(nums, 0, nums.length - 1, target);
    }

    private static int doBinarySearch(int[] nums, int left, int right, int target) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return doBinarySearch(nums, left, mid - 1, target);
            } else {
                return doBinarySearch(nums, mid + 1, right, target);
            }
        }
        return -1;
    }

    public static int binarySearch1(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int mySqrt(int n) {
        if (n <= 1) {
            return n;
        }
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (n / mid >= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }

    /**
     * 如果left,right,mid采用int，会导致超时越界，因此这里采用long类型
     *
     * @param x
     * @return
     */
    public static boolean isPerfectSquare(int x) {
        if (x <= 0) {
            return false;
        }

        long left = 1, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (x == mid * mid) {
                return true;
            } else if (x > mid * mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 任意完全平方数可以表示成连续的奇数和
     *
     * @param i
     * @return
     */
    public static boolean isPerfectSquare1(int i) {
        if (i <= 0) {
            return false;
        }
        int x = 1;
        while (i > 0) {
            i -= x;
            x += 2;
        }
        return i == 0;
    }

    public static boolean judgeSquareSum(int c) {
        int limit = (int) Math.sqrt(c);
        for (int n = 0; n <= limit; n++) {
            double a = Math.sqrt(c - n * n);
            if (a - (int) a == 0) {
                return true;
            }
        }
        return false;
    }

    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        while (num >= 10) {
            int z = 0;
            while (num > 0) {
                int a = num % 10;
                z += a;
                num /= 10;
            }
            num = z;
        }
        return num;
    }

    /**
     * 于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
     *
     * @param num 12 + 92 = 82
     *            82 + 22 = 68
     *            62 + 82 = 100
     *            12 + 02 + 02 = 1
     * @return
     */
    public static boolean isHappy(int num) {
        Set<Integer> integerSet = new HashSet<>();
        while (num != 1 && !integerSet.contains(num)) {
            integerSet.add(num);
            int total = 0;
            while (num > 0) {
                int i = num % 10;
                total = total + i * i;
                num /= 10;
            }
            num = total;
        }
        return num == 1;
    }
}
