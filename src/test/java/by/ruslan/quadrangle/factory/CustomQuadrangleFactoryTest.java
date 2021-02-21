package by.ruslan.quadrangle.factory;

import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.exception.ShapeException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomQuadrangleFactoryTest {

    CustomQuadrangleFactory factory;
    CustomPoint pointA;
    CustomPoint pointB;
    CustomPoint pointC;
    CustomPoint pointD;

    @BeforeMethod
    public void setUp() {
        factory = new CustomQuadrangleFactory();
        pointA = new CustomPoint(3,3);
        pointB = new CustomPoint(7,6);
        pointC = new CustomPoint(7,3);
        pointD = new CustomPoint(3,6);
    }

    @AfterMethod
    public void tearDown() {
        factory = null;
        pointA = null;
        pointB = null;
        pointC = null;
        pointD = null;
    }

    @Test
    public void testGetInstance() throws ShapeException {
        CustomQuadrangle expected = new CustomQuadrangle("QUAD", pointA, pointC, pointB, pointD);
        CustomQuadrangle actual = factory.getInstance("QUAD", pointA, pointB, pointC, pointD);
        assertEquals(actual, expected);
    }
}