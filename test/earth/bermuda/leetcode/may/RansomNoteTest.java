package earth.bermuda.leetcode.may;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RansomNoteTest {

    @Test
    public void exampleTest1() {
        String ransomNote = "a", magazine = "b";
        boolean expected = false;
        boolean actual = new RansomNote().canConstruct(ransomNote, magazine);
        assertEquals(actual, expected, String.format("(%s, %s) -> %b != %b", ransomNote, magazine, actual, expected));
    }

    @Test
    public void exampleTest2() {
        String ransomNote = "aa", magazine = "ab";
        boolean expected = false;
        boolean actual = new RansomNote().canConstruct(ransomNote, magazine);
        assertEquals(actual, expected, String.format("(%s, %s) -> %b != %b", ransomNote, magazine, actual, expected));
    }

    @Test
    public void exampleTest3() {
        String ransomNote = "aa", magazine = "aab";
        boolean expected = true;
        boolean actual = new RansomNote().canConstruct(ransomNote, magazine);
        assertEquals(actual, expected, String.format("(%s, %s) -> %b != %b", ransomNote, magazine, actual, expected));
    }

    @Test
    public void eedgeCase1() {
        String ransomNote = "azzzzaaaa", magazine = "aaaaazzzz";
        boolean expected = true;
        boolean actual = new RansomNote().canConstruct(ransomNote, magazine);
        assertEquals(actual, expected, String.format("(%s, %s) -> %b != %b", ransomNote, magazine, actual, expected));
    }

}