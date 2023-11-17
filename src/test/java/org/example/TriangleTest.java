package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private String[] input;
    private ByteArrayInputStream inputArray;
    private Triangle triangle;


    // SCANNER

    // testa fel datatyp
    @Test
    @DisplayName("Test for invalid datatype and length input")
    void getCurrentTypeCheckDatatype() {
        triangle = new Triangle();
        input = new String[]{"a","b","c"};
        String combinedInputs = String.join(",", input);
        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
        System.setIn(inputArray);
        assertNull(triangle.getCurrent_type());

    }


    @Test
    @DisplayName("Test for invalid length input")
    void getCurrentTypeCheckLength() {
        triangle = new Triangle();
        input = new String[]{"1","2","3","4"};
        String combinedInputs = String.join(",", input);
        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
        System.setIn(inputArray);
        assertNull(triangle.getCurrent_type());

    }

    //testa empty

    @Test
    @DisplayName("Test for empty input")
    void getCurrentTypeCheckEmpty() {
        triangle = new Triangle();
        input = new String[]{" "};
        String combinedInputs = String.join(",", input);
        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
        System.setIn(inputArray);
        assertNull(triangle.getCurrent_type());

    }

//    @Test
//    @DisplayName("Test for 3 invalid datatype input, throw IllegalArgument exc")
//    void test3InvalidDataType() {
//        triangle = new Triangle();
//        input = new String[]{"a","b","c"};
//        String combinedInputs = String.join(",", input);
//        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
//        System.setIn(inputArray);
//        assertNull(triangle.getCurrent_type());
//
//    }

    // testa rätt datatyp
    @Test
    @DisplayName("Test for valid input for SCALENE")
    void getCurrentTypeCheckSCALENE() {
        triangle = new Triangle();
        input = new String[]{"7","8","9"};
        String combinedInputs = String.join(",", input);
        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
        System.setIn(inputArray);

        triangle.getUserInput();

        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test for valid input for EQUILATERAL")
    void getCurrentTypeCheckEQUILATERAL() {
        triangle = new Triangle();
        input = new String[]{"8","8","8"};
        String combinedInputs = String.join(",", input);
        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
        System.setIn(inputArray);

        triangle.getUserInput();

        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test for valid input for ISOSCELES")
    void getCurrentTypeCheckISOSCELES() {
        triangle = new Triangle();
        input = new String[]{"7","8","8"};
        String combinedInputs = String.join(",", input);
        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
        System.setIn(inputArray);

        triangle.getUserInput();

        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }


    // CONSTRUCTOR

    // testa boundaries i Construktor

    @Test
    @DisplayName("Test with maximum integer values for sides")
    void testMaxIntSides() {
        triangle = new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test with overflow integer values for sides")
    void testOverflowIntSides() {
        triangle = new Triangle(Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1);
        assertNull(triangle.getCurrent_type()); // Assuming this results in invalid sides
    }

    @Test
    @DisplayName("Test with minimum integer values for sides")
    void testMinIntSides() {
        triangle = new Triangle(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test with zero values for sides")
    void testZeroSides() {
        triangle = new Triangle(0, 0, 0);
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test with negative values for sides")
    void testNegativeSides() {
        triangle = new Triangle(-1, -1, -1);
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test with triangle inequality boundary")
    void testTriangleInequalityBoundary() {
        triangle = new Triangle(1, 2, 3); // Should not form a valid triangle
        assertNull(triangle.getCurrent_type());
    }


    //testa rätt datatyp

    @Test
    @DisplayName("S")
    void getCurrentTypeCheckConstructorSCALENE() {
        triangle = new Triangle(8, 9, 10);
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());

    }

    @Test
    @DisplayName("E")
    void getCurrentTypeCheckConstructorEQUILATERAL() {
        triangle = new Triangle(8, 8, 8);
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());

    }

    @Test
    @DisplayName("I")
    void getCurrentTypeCheckConstructorISOSCELES() {
        triangle = new Triangle(8, 8, 10);
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());

    }

    @Test
    @DisplayName("?")
    void getCurrentTypeCheckConstructorInvDatatype(){
        String string1 = "8";
        String string2 = "8";
        String string3 = "8";
        triangle = new Triangle(new String[] {string1, string2, string3});
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
    }

    //gör fler tester här som ovan












    //testa null input värden

//    @Test
//    @DisplayName("Test for null array input, throw NullPointerException")
//    void testNullArrayInput() {
//        assertThrows(NullPointerException.class, () -> {
//            new Triangle((String[]) null);
//        });
//    }

//    @Test
//    public void testNullArrayConstructor() {
//        // Creating a Triangle object with a null array
//        Triangle triangle = new Triangle(null);
//
//        // Asserting that the triangle type is null since no valid input was provided
//        assertNull(triangle.getCurrent_type());
//    }

//    @Test
//    @DisplayName("Test for wrong length input, throw Number exc")
//    void testWrongDataType() {
//        triangle = new Triangle();
//        input = new String[]{"1", "2", "3"};
//        String combinedInputs = String.join("\n", input);
//        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
//        System.setIn(inputArray);
//        assertThrows(IllegalArgumentException.class, triangle::getUserInput);
//
//    }

















//    @Test
//    @DisplayName("Test for no/null input, throw IllegalArgument exc")
//    void testNullInput(){
//        triangle = new Triangle();
//        input = new String[] {"1","2"};
//        String combinedInputs = String.join("\n", input);
//        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
//        System.setIn(inputArray);
//        assertThrows(IllegalArgumentException.class, triangle::getUserInput);
//
//    }

}