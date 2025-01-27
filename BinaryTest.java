package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest {
    /**
     * Test The constructor with a valid binary value
     */
    @Test
    public void normalConstructor() {
        Binary binary = new Binary("1001001");
        assertTrue(binary.getValue().equals("1001001"));
    }

    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits() {
        Binary binary = new Binary("1001001211");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars() {
        Binary binary = new Binary("1001001A");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign() {
        Binary binary = new Binary("-1001001");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing() {
        Binary binary = new Binary("00001001");
        assertTrue(binary.getValue().equals("1001"));
    }

    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString() {
        Binary binary = new Binary("");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The add function with two binary numbers of the same length
     */
    @Test
    public void add() {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("1111");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("10111"));
    }

    /**
     * Test The add function with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add function with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3() {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add function with a binary number with zero
     */
    @Test
    public void add4() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test The add function with two zeros
     */
    @Test
    public void add5() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    /**
     * Test the or function with all 1's vs one 0
     */
    @Test
    public void or1() {
        Binary binary1 = new Binary("11111111");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.or(binary1, binary2);
        assertTrue(binary3.getValue().equals("11111111"));
    }

    /**
     * Test the or function with an alternating pattern
     */
    @Test
    public void or2() {
        Binary binary1 = new Binary("01010101");
        Binary binary2 = new Binary("10101010");
        Binary binary3 = Binary.or(binary1, binary2);
        assertTrue(binary3.getValue().equals("11111111"));
    }

    /**
     * Test or function with long numbers
     */
    @Test
    public void or3() {
        Binary binary1 = new Binary("100100100001010011100");
        Binary binary2 = new Binary("001010011010101010010");
        Binary binary3 = Binary.or(binary1, binary2);
        assertTrue(binary3.getValue().equals("101110111011111011110"));
    }

    /**
     * Test the And function with all 1's
     */
    @Test
    public void and1() {
        Binary binary1 = new Binary("11111111");
        Binary binary2 = new Binary("11111111");
        Binary binary3 = Binary.and(binary1, binary2);
        assertTrue(binary3.getValue().equals("11111111"));
    }

    /**
     * Test the And function with an alternating pattern
     */
    @Test
    public void and2() {
        Binary binary1 = new Binary("01010101");
        Binary binary2 = new Binary("10101010");
        Binary binary3 = Binary.and(binary1, binary2);
        assertTrue(binary3.getValue().equals("00000000"));
    }

    /**
     * Test and function with long numbers
     */
    @Test
    public void and3() {
        Binary binary1 = new Binary("100100100001010011100");
        Binary binary2 = new Binary("001010011010101010010");
        Binary binary3 = Binary.and(binary1, binary2);
        assertTrue(binary3.getValue().equals("10000"));
    }

    /**
     * Test multiply function with all 1's and one 0
     */
    @Test
    public void multi1() {
        Binary binary1 = new Binary("11111111");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.multiplyBinary(binary1, binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    /**
     * Test the Multiply function with an alternating pattern
     */
    @Test
    public void multi2() {
        Binary binary1 = new Binary("01010101");
        Binary binary2 = new Binary("10101010");
        Binary binary3 = Binary.multiplyBinary(binary1, binary2);
        assertTrue(binary3.getValue().equals("11100001110010"));
    }

    /**
     * Test multiply function with long numbers
     */
    @Test
    public void multi3() {
        Binary binary1 = new Binary("10010010000101001");
        Binary binary2 = new Binary("00101001101010101");
        Binary binary3 = Binary.multiplyBinary(binary1, binary2);
        assertTrue(binary3.getValue().equals("1011111000110100100110010011101"));
    }

    /**
     * Test multiply function with a binary number multiplied by 1
     */
    @Test
    public void multi6() {
        Binary binary1 = new Binary("1010"); // Binary 1010 -> 10 in decimal
        Binary binary2 = new Binary("1"); // Binary 1 -> 1 in decimal
        Binary binary3 = Binary.multiplyBinary(binary1, binary2); // Multiply the binary numbers

        // 10 * 1 = 10, which is 1010 in binary
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test multiply function with binary numbers that result in leading zeros being removed
     */
    @Test
    public void multi7() {
        Binary binary1 = new Binary("0011"); // Binary 0011 -> 3 in decimal
        Binary binary2 = new Binary("0101"); // Binary 0101 -> 5 in decimal
        Binary binary3 = Binary.multiplyBinary(binary1, binary2); // Multiply the binary numbers

        // 3 * 5 = 15, which is 1111 in binary
        assertTrue(binary3.getValue().equals("1111"));
    }
}