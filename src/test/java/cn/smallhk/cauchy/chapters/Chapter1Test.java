package cn.smallhk.cauchy.chapters;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * @author duangduangda
 */
public class Chapter1Test {

    @Test
    public void testReverseInt(){
        assertEquals(321,Chapter1.reverseInt(123));
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
}
