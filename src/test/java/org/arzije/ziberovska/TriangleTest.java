package org.arzije.ziberovska;

import org.arzije.ziberovska.main.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private Triangle triangle;
    private InputStream originalIn;

    @BeforeEach
    void setUp(){
        triangle = new Triangle();
        originalIn = System.in;
    }

    private void setSimulatedInput(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private void restoreOriginalSystemIn(){
        System.setIn(originalIn);
    }

    // Input/Output, datatype
    // SCANNER och konstruktor utan parametrar med getUserInput metod

    @Test
    @DisplayName("Test invalid string input handling")
    void testInvalidStringInputHandling(){
        setSimulatedInput("a,b,c");
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
        restoreOriginalSystemIn();
    }

    @Test
    @DisplayName("Test input with too many elements")
    void testInputWithTooManyElements() {
        setSimulatedInput("1,2,3,4");
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
        restoreOriginalSystemIn();
    }

    @Test
    @DisplayName("Test input with too few elements")
    void testInputWithTooFewElements() {
        setSimulatedInput("1,2");
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
        restoreOriginalSystemIn();
    }

    @Test
    @DisplayName("Test handling of empty input")
    void testHandlingEmptyInput() {
        setSimulatedInput(" ");
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
        restoreOriginalSystemIn();
    }

    @Test
    @DisplayName("Test valid scalene triangle input")
    void testValidScaleneTriangleInput() {
        setSimulatedInput("7,8,9");
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
        restoreOriginalSystemIn();
    }

    @Test
    @DisplayName("Test valid equilateral triangle input")
    void testValidEquilateralTriangleInput() {
        setSimulatedInput("8,8,8");
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
        restoreOriginalSystemIn();
    }

    @Test
    @DisplayName("Test valid isosceles triangle input")
    void testValidIsoscelesTriangleInput() {
        setSimulatedInput("7,8,8");
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
        restoreOriginalSystemIn();
    }

    // Konstruktor med int parametrar, boundary tester och null value

    @Test
    @DisplayName("Test with maximum integer values for sides")
    void testMaxIntSides() {
        Triangle maxTriangle = new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(Triangle.TYPE.EQUILATERAL, maxTriangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test with overflow integer values for sides")
    void testOverflowIntSides() {
        Triangle overflowTriangle = new Triangle(Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1);
        assertNull(overflowTriangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test with minimum integer values for sides")
    void testMinIntSides() {
        Triangle minTriangle = new Triangle(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertNull(minTriangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test with zero values for sides")
    void testZeroSides() {
        Triangle zeroTriangle = new Triangle(0, 0, 0);
        assertNull(zeroTriangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test with negative values for sides")
    void testNegativeSides() {
        Triangle negativeTriangle = new Triangle(-1, -1, -1);
        assertNull(negativeTriangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test with triangle inequality boundary")
    void testTriangleInequalityBoundary() {
        Triangle inequalityTriangle = new Triangle(1, 2, 3);
        assertNull(inequalityTriangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test scalene triangle with valid side lengths")
    void testScaleneTriangleWithValidSides() {
        Triangle scaleneTriangle = new Triangle(8, 9, 10);
        assertEquals(Triangle.TYPE.SCALENE, scaleneTriangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test equilateral triangle with valid side lengths")
    void testEquilateralTriangleWithValidSides() {
        Triangle equilateralTriangle = new Triangle(8, 8, 8);
        assertEquals(Triangle.TYPE.EQUILATERAL, equilateralTriangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test isosceles triangle with valid side lengths")
    void testIsoscelesTriangleWithValidSides() {
        Triangle isoscelesTriangle = new Triangle(8, 8, 10);
        assertEquals(Triangle.TYPE.ISOSCELES, isoscelesTriangle.getCurrent_type());
    }

    // Konstruktor med string array parameter, input/output, datatype, length

    @Test
    @DisplayName("Test constructor with valid equilateral string inputs")
    void testConstructorWithValidEquilateralStringInputs() {
        Triangle stringTriangle = new Triangle(new String[]{"8", "8", "8"});
        assertEquals(Triangle.TYPE.EQUILATERAL, stringTriangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test constructor with invalid datatype inputs")
    void testConstructorWithInValidStringInputs() {
        Triangle stringTriangle = new Triangle(new String[]{"a", "b", "8"});
        assertNull(stringTriangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test constructor with invalid equilateral string inputs")
    void testConstructorWithInValidLengthInputs() {
        Triangle stringTriangle = new Triangle(new String[]{"8", "8", "8", "8"});
        assertNull(stringTriangle.getCurrent_type());
    }

}