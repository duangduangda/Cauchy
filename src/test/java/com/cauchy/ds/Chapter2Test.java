package com.cauchy.ds;

import com.cauchy.ds.Chapter2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author duangduangda
 */
public class Chapter2Test {

    @Test
    public void testNumJewelsInStones(){
        assertEquals(3, Chapter2.numJewelsInStones("aA","aAAbbbb"));
        assertEquals(0,Chapter2.numJewelsInStones("z","ZZ"));
    }

    @Test
    public void testToLowerCase(){
        assertEquals("hello",Chapter2.toLowerCase("HELlo"));
        assertEquals("hello",Chapter2.toLowerCase("HELLO"));
        assertEquals("hello",Chapter2.toLowerCase("hello"));
    }

    @Test
    public void testLengthOfLongestSubstring(){
        assertEquals(3,Chapter2.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1,Chapter2.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3,Chapter2.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void testSortArrayByParity(){
        assertEquals(0,Chapter2.sortArrayByParity(new int[]{3,1,2,4})[0] % 2);
        assertEquals(0,Chapter2.sortArrayByParity(new int[]{3,1,2,4})[1] % 2);
        assertEquals(1,Chapter2.sortArrayByParity(new int[]{3,1,2,4})[2] % 2);
        assertEquals(1,Chapter2.sortArrayByParity(new int[]{3,1,2,4})[3] % 2);
        assertEquals(0,Chapter2.sortArrayByParity(new int[]{2})[0] % 2);
        assertEquals(1,Chapter2.sortArrayByParity(new int[]{3})[0] % 2);
        assertEquals(0,Chapter2.sortArrayByParity(new int[]{2,4})[0] % 2);
        assertEquals(0,Chapter2.sortArrayByParity(new int[]{2,4})[1] % 2);
        assertEquals(0,Chapter2.sortArrayByParity(new int[]{1,2,3,4,5})[0] % 2);
        assertEquals(0,Chapter2.sortArrayByParity(new int[]{1,2,3,4,5})[1] % 2);
        assertEquals(1,Chapter2.sortArrayByParity(new int[]{1,2,3,4,5})[2] % 2);
    }

    @Test
    public void testReverseString(){
        assertEquals("olleh",Chapter2.reverseString("hello"));
        assertEquals("amanaP :lanac a ,nalp a ,nam A",Chapter2.reverseString("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testShortestToChar(){
        int[] result = Chapter2.shortestToChar("loveleetcode",'e');
        for (int i = 0;i < result.length;i++){
            System.out.println(result[i]);
        }
    }

    @Test
    public void testSingleNumber(){
        assertEquals(1, Chapter2.singleNumber(new int[]{2,2,1}));
        assertEquals(1, Chapter2.singleNumber(new int[]{2,1,2}));
        assertEquals(4,Chapter2.singleNumber(new int[]{4,1,2,1,2}));
    }


}
