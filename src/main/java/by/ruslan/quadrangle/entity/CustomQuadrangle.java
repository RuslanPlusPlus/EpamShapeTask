package by.ruslan.quadrangle.entity;

import by.ruslan.quadrangle.exception.ShapeException;
import by.ruslan.quadrangle.validator.CreateValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomQuadrangle extends CustomPlaneShape {
    static final Logger logger = LogManager.getLogger();
    private CustomPoint pointA;
    private CustomPoint pointB;
    private CustomPoint pointC;
    private CustomPoint pointD;

    public CustomQuadrangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC,
                            CustomPoint pointD, String name) throws ShapeException {
        super(name);
        if (!CreateValidator.isPossibleToCreateQuadrangle(pointA, pointB, pointC, pointD)){
            throw new ShapeException("Impossible to create quadrangle with such points");
        }
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        logger.info("New CustomQuadrangle object created");
    }

    public CustomQuadrangle(CustomPoint[] points, String name) throws ShapeException {
        super(name);
        if (!CreateValidator.isPossibleToCreateQuadrangle(points)){
            throw new ShapeException("Impossible to create quadrangle with such points");
        }
        this.pointA = points[0];
        this.pointB = points[1];
        this.pointC = points[2];
        this.pointD = points[3];
        logger.info("New CustomQuadrangle object created");
    }

    public CustomPoint getPointA() throws ShapeException {
        try {
            return pointA.clone();
        } catch (CloneNotSupportedException e) {
            throw new ShapeException("Cannot clone CustomPoint object", e);
        }
    }

    public void setPointA(CustomPoint pointA) throws ShapeException {
        if (!CreateValidator.isPossibleToCreateQuadrangle(pointA, pointB, pointC, pointD)){
            throw new ShapeException("Points do not form a quadrangle with " + pointA);
        }
        this.pointA = pointA;
        logger.info("PointA is reset to " + pointA);
    }

    public CustomPoint getPointB() throws ShapeException {
        try {
            return pointB.clone();
        } catch (CloneNotSupportedException e) {
            throw new ShapeException("Cannot clone CustomPoint object", e);
        }
    }

    public void setPointB(CustomPoint pointB) throws ShapeException {
        if (!CreateValidator.isPossibleToCreateQuadrangle(pointA, pointB, pointC, pointD)){
            throw new ShapeException("Points do not form a quadrangle with " + pointB);
        }
        this.pointB = pointB;
        logger.info("PointB is reset to " + pointB);
    }

    public CustomPoint getPointC() throws ShapeException {
        try {
            return pointC.clone();
        } catch (CloneNotSupportedException e) {
            throw new ShapeException("Cannot clone CustomPoint object", e);
        }
    }

    public void setPointC(CustomPoint pointC) throws ShapeException {
        if (!CreateValidator.isPossibleToCreateQuadrangle(pointA, pointB, pointC, pointD)){
            throw new ShapeException("Points do not form a quadrangle with " + pointC);
        }
        this.pointC = pointC;
        logger.info("PointC is reset to " + pointC);
    }

    public CustomPoint getPointD() throws ShapeException {
        try {
            return pointD.clone();
        } catch (CloneNotSupportedException e) {
            throw new ShapeException("Cannot clone CustomPoint object", e);
        }
    }

    public void setPointD(CustomPoint pointD) throws ShapeException {
        if (!CreateValidator.isPossibleToCreateQuadrangle(pointA, pointB, pointC, pointD)){
            throw new ShapeException("Points do not form a quadrangle with " + pointD);
        }
        this.pointD = pointD;
        logger.info("PointD is reset to " + pointD);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomQuadrangle quadrangle = (CustomQuadrangle) o;
        return pointA.equals(quadrangle.pointA) &&
                pointB.equals(quadrangle.pointB) &&
                pointC.equals(quadrangle.pointC) &&
                pointD.equals(quadrangle.pointD);
    }

    @Override
    public int hashCode() {
        int hash = 31;
        int result = 1;
        result = hash * result + pointA.hashCode();
        result = hash * result + pointB.hashCode();
        result = hash * result + pointC.hashCode();
        result = hash * result + pointD.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CustomQuadrangle{")
                .append("pointA=").append(pointA)
                .append(", pointB=").append(pointB)
                .append(", pointC=").append(pointC)
                .append(", pointD=").append(pointD)
                .append("}");
        return builder.toString();
    }
}
