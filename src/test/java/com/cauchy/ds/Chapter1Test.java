package com.cauchy.ds;

import com.cauchy.ds.Chapter1;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * @author duangduangda
 */
public class Chapter1Test {

    @Test
    public void testReverseInt(){
        assertEquals(321, Chapter1.reverseInt(123));
        assertEquals(3221,Chapter1.reverseInt(1223));
        assertEquals(121,Chapter1.reverseInt(121));
        assertEquals(21,Chapter1.reverseInt(12));
        assertEquals(1,Chapter1.reverseInt(1));
        assertEquals(0,Chapter1.reverseInt(0));
        assertEquals(-1,Chapter1.reverseInt(-1));
        assertEquals(-11,Chapter1.reverseInt(-11));
        assertEquals(-21,Chapter1.reverseInt(-12));
        assertEquals(-4321,Chapter1.reverseInt(-1234));
    }
    @Test
    public void testReverseInt1(){
        assertEquals(321,Chapter1.reverseInt1(123));
        assertEquals(3221,Chapter1.reverseInt1(1223));
        assertEquals(121,Chapter1.reverseInt1(121));
        assertEquals(21,Chapter1.reverseInt1(12));
        assertEquals(1,Chapter1.reverseInt1(1));
        assertEquals(0,Chapter1.reverseInt1(0));
        assertEquals(-1,Chapter1.reverseInt1(-1));
        assertEquals(-11,Chapter1.reverseInt1(-11));
        assertEquals(-21,Chapter1.reverseInt1(-12));
        assertEquals(-4321,Chapter1.reverseInt1(-1234));
    }

    @Test
    public void testIsPalindrome(){
        assertTrue(Chapter1.isPalindrome(121));
        assertTrue(Chapter1.isPalindrome(11));
        assertTrue(Chapter1.isPalindrome(1221));
        assertFalse(Chapter1.isPalindrome(-121));
        assertFalse(Chapter1.isPalindrome(10));
        assertFalse(Chapter1.isPalindrome(1231));
    }
    @Test
    public void testIsPalindrome1(){
        assertTrue(Chapter1.isPalindrome1(121));
        assertTrue(Chapter1.isPalindrome1(11));
        assertTrue(Chapter1.isPalindrome1(1221));
        assertFalse(Chapter1.isPalindrome1(-121));
        assertFalse(Chapter1.isPalindrome1(10));
        assertFalse(Chapter1.isPalindrome1(1231));
    }


    @Test
    public void testThirdMax(){
        assertEquals(1,Chapter1.thirdMax(new int[]{2,3,1}));
        assertEquals(1,Chapter1.thirdMax(new int[]{2,1,3}));
        assertEquals(1,Chapter1.thirdMax(new int[]{1,2,3}));
        assertEquals(1,Chapter1.thirdMax(new int[]{3,2,1}));
        assertEquals(2,Chapter1.thirdMax(new int[]{1,2}));
        assertEquals(2,Chapter1.thirdMax(new int[]{1,2,3,4}));
        assertEquals(2,Chapter1.thirdMax(new int[]{4,2,3,1}));
        assertEquals(1,Chapter1.thirdMax(new int[]{1,2,3,2}));
        assertEquals(1,Chapter1.thirdMax(new int[]{1,2,2,3}));
        assertEquals(1,Chapter1.thirdMax(new int[]{3,2,2,1}));
        assertEquals(2,Chapter1.thirdMax(new int[]{1,2,2,5,3,5}));
    }

    @Test
    public void testFindKthLargest(){
        assertEquals(5,Chapter1.findKthLargest(new int[]{3,2,1,5,6,4},2));
        assertEquals(4,Chapter1.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }

    @Test
    public void testTopKFrequent(){
        assertTrue(Chapter1.topKFrequent(new int[]{1,1,1,2,2,3},2).contains(1));
        assertTrue(Chapter1.topKFrequent(new int[]{1,1,1,2,2,3},2).contains(2));
        assertTrue(Chapter1.topKFrequent(new int[]{1},1).contains(1));
    }

    @Test
    public void testBinarySearch(){
        assertEquals(4,Chapter1.binarySearch(new int[]{-1,0,3,5,9,12},9));
        assertEquals(-1,Chapter1.binarySearch(new int[]{-1,0,3,5,9,12},2));
        assertEquals(0,Chapter1.binarySearch(new int[]{5},5));
        assertEquals(-1,Chapter1.binarySearch(new int[]{5},1));
    }
    @Test
    public void testBinarySearch1(){
        assertEquals(4,Chapter1.binarySearch1(new int[]{-1,0,3,5,9,12},9));
        assertEquals(-1,Chapter1.binarySearch1(new int[]{-1,0,3,5,9,12},2));
        assertEquals(0,Chapter1.binarySearch1(new int[]{5},5));
        assertEquals(-1,Chapter1.binarySearch1(new int[]{5},1));
    }

    @Test
    public void testMySqrt(){
        assertEquals(2,Chapter1.mySqrt(4));
        assertEquals(2,Chapter1.mySqrt(8));
        assertEquals(46339,Chapter1.mySqrt(2147395599));
    }

    @Test
    public void testIsPerfectSquare(){
        assertTrue(Chapter1.isPerfectSquare(16));
        assertFalse(Chapter1.isPerfectSquare(14));
        assertFalse(Chapter1.isPerfectSquare(-1));
        assertFalse(Chapter1.isPerfectSquare(0));
        assertTrue(Chapter1.isPerfectSquare(1));
        assertFalse(Chapter1.isPerfectSquare(2147483647));
    }

    @Test
    public void testIsPerfectSquare1(){
        assertTrue(Chapter1.isPerfectSquare1(16));
        assertFalse(Chapter1.isPerfectSquare1(14));
        assertFalse(Chapter1.isPerfectSquare1(-1));
        assertFalse(Chapter1.isPerfectSquare1(0));
        assertTrue(Chapter1.isPerfectSquare1(1));
        assertFalse(Chapter1.isPerfectSquare1(2147483647));
    }

    @Test
    public void testJudgeSquareSum(){
        assertTrue(Chapter1.judgeSquareSum(5));
        assertFalse(Chapter1.judgeSquareSum(3));
        assertTrue(Chapter1.judgeSquareSum(0));
        assertTrue(Chapter1.judgeSquareSum(1000000000));
    }

    @Test
    public void testAddDigits(){
        assertEquals(2, Chapter1.addDigits(38));
        assertEquals(1, Chapter1.addDigits(100));
        assertEquals(1, Chapter1.addDigits(10));
        assertEquals(1, Chapter1.addDigits(1));
        assertEquals(0, Chapter1.addDigits(0));
    }

    @Test
    public void testIsHappy(){
        assertTrue(Chapter1.isHappy(19));
        assertTrue(Chapter1.isHappy(190));
        assertTrue(Chapter1.isHappy(1));
        assertFalse(Chapter1.isHappy(2));
        assertFalse(Chapter1.isHappy(0));
    }

    @Test
    public void testPascalTriangle(){
        List<List<Integer>> resultList = Chapter1.pascalTriangle(5);
        for (List<Integer>list:resultList){
            for (Integer i :list){
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

    @Test
    public void testGetPascalTriangleRow(){
        List<Integer> result = Chapter1.gtPascalTriangleRow(0);
        for (Integer i :result){
            System.out.println(i);
        }
    }

}
