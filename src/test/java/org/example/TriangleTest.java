package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private String[] input;
    private ByteArrayInputStream inputArray;
    private Triangle triangle;


    // testa fel datatyp
//    @Test
//    @DisplayName("Test for invalid datatype and length input, throw ArrayOOB exc")
//    void testInvalidDataType() {
//        triangle = new Triangle();
//        input = new String[]{"a","b","c","d"};
//        String combinedInputs = String.join(",", input);
//        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
//        System.setIn(inputArray);
//        assertThrows(ArrayIndexOutOfBoundsException.class, triangle::getUserInput);
//
//    }

//    @Test
//    @DisplayName("Test for invalid length input, throw ArrayOOB exc")
//    void testInvalidNumberOfIntInputs() {
//        triangle = new Triangle();
//        input = new String[]{"1","2","3","4"};
//        String combinedInputs = String.join(",", input);
//        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
//        System.setIn(inputArray);
//        assertThrows(ArrayIndexOutOfBoundsException.class, triangle::getUserInput);
//
//    }

    @Test
    @DisplayName("Test for invalid length input, throw ArrayOOB exc")
    void testInvalidNumberOfIntInputs() {
        triangle = new Triangle();
        input = new String[]{"1","2","3","4"};
        String combinedInputs = String.join(",", input);
        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
        System.setIn(inputArray);
        assertNull(triangle.getCurrent_type());

    }

    @Test
    @DisplayName("Test for 3 invalid datatype input, throw IllegalArgument exc")
    void test3InvalidDataType() {
        triangle = new Triangle();
        input = new String[]{"a","b","c"};
        String combinedInputs = String.join(",", input);
        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
        System.setIn(inputArray);
        assertThrows(NumberFormatException.class, triangle::getUserInput);

    }

    // testa rätt datatyp
    @Test
    @DisplayName("Test for valid input for SCALENE")
    void testValidInputTypeS() {
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
    void testValidInputTypeE() {
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
    void testValidInputTypeI() {
        triangle = new Triangle();
        input = new String[]{"7","8","8"};
        String combinedInputs = String.join(",", input);
        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
        System.setIn(inputArray);

        triangle.getUserInput();

        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }


    // testa längd?


    //testa empty??

    @Test
    @DisplayName("Test for 3 invalid datatype input, throw IllegalArgument exc")
    void testEmptyArray() {
        triangle = new Triangle();
        input = new String[]{" "};
        String combinedInputs = String.join(",", input);
        inputArray = new ByteArrayInputStream(combinedInputs.getBytes());
        System.setIn(inputArray);
        assertThrows(IllegalArgumentException.class, triangle::getUserInput);

    }


    //testa null input värden

    @Test
    @DisplayName("Test for null array input, throw NullPointerException")
    void testNullArrayInput() {
        assertThrows(NullPointerException.class, () -> {
            new Triangle((String[]) null);
        });
    }

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