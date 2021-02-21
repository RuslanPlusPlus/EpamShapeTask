package by.ruslan.quadrangle.action.impl;

import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.exception.ShapeException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadrangleCalculatorTest {

    private QuadrangleCalculator calculator;
    private CustomQuadrangle quadrangle;
    CustomPoint pointA;
    CustomPoint pointB;
    CustomPoint pointC;
    CustomPoint pointD;

    @BeforeMethod
    public void setUp() throws ShapeException {
        calculator = new QuadrangleCalculator();
        pointA = new CustomPoint(3,3);
        pointB = new CustomPoint(7,3);
        pointC = new CustomPoint(7,6);
        pointD = new CustomPoint(3,6);
        quadrangle = new CustomQuadrangle("QUAD", pointA, pointB, pointC, pointD);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
        quadrangle = null;
        pointA = null;
        pointB = null;
        pointC = null;
        pointD = null;
    }

    @Test
    public void testFindSquare() throws ShapeException {
        double expected = 12;
        double actual = calculator.findSquare(quadrangle);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testFindPerimeter() throws ShapeException {
        double expected = 14;
        double actual = calculator.findPerimeter(quadrangle);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testFindSideLength() {
        double expected = 5;
        double actual = calculator.findSideLength(pointA, pointC);
        assertEquals(actual, expected, 0.001);
    }
}