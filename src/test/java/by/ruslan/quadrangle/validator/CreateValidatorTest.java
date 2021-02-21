package by.ruslan.quadrangle.validator;

import by.ruslan.quadrangle.entity.CustomPoint;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateValidatorTest {

    CustomPoint pointA;
    CustomPoint pointB;
    CustomPoint pointC;
    CustomPoint pointD;

    @BeforeMethod
    public void setUp() {
        pointA = new CustomPoint(3.3, 18.1);
        pointB = new CustomPoint(10, 0.12);
        pointC = new CustomPoint(4.5, 15);
        pointD = new CustomPoint(15, 24);
    }

    @AfterMethod
    public void tearDown() {
        pointA = null;
        pointB = null;
        pointC = null;
        pointD = null;
    }

    @Test
    public void testIsPossibleToCreateQuadrangle() {
        boolean actual = CreateValidator.isPossibleToCreateQuadrangle(pointA, pointB, pointC, pointD);
        assertTrue(actual);
    }
}