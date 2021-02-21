package by.ruslan.quadrangle.validator;

import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.exception.ShapeException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadrangleValidatorTest {
    private CustomPoint[] quadratePoints;
    private CustomPoint[] rhombusPoints;

    @BeforeMethod
    public void setUp(){
        quadratePoints = new CustomPoint[4];
        quadratePoints[0] = new CustomPoint(3,3);
        quadratePoints[1] = new CustomPoint(3,5);
        quadratePoints[2] = new CustomPoint(5,5);
        quadratePoints[3] = new CustomPoint(5,3);

        rhombusPoints= new CustomPoint[4];
        rhombusPoints[0] = new CustomPoint(4,5);
        rhombusPoints[1] = new CustomPoint(6,8);
        rhombusPoints[2] = new CustomPoint(8,5);
        rhombusPoints[3] = new CustomPoint(6,2);

    }

    @AfterMethod
    public void tearDown() {
       quadratePoints = null;
       rhombusPoints = null;
    }

    @Test
    public void testIsRhombus() throws ShapeException {
        CustomQuadrangle actual = new CustomQuadrangle("QUAD", rhombusPoints);
        assertTrue(QuadrangleValidator.isRhombus(actual));
    }

    @Test
    public void testIsQuadrate() throws ShapeException {
        CustomQuadrangle actual = new CustomQuadrangle("QUAD", quadratePoints);
        assertTrue(QuadrangleValidator.isQuadrate(actual));
    }
}