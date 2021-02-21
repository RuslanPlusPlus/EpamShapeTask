package by.ruslan.quadrangle.entity;

import by.ruslan.quadrangle.exception.ShapeException;
import by.ruslan.quadrangle.factory.CustomQuadrangleFactory;
import by.ruslan.quadrangle.observer.Observable;
import by.ruslan.quadrangle.observer.CustomObserver;
import by.ruslan.quadrangle.observer.QuadrangleEvent;
import by.ruslan.quadrangle.validator.CreateValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomQuadrangle extends CustomPlaneShape implements Observable {
    static final Logger logger = LogManager.getLogger();
    private CustomPoint pointA;
    private CustomPoint pointB;
    private CustomPoint pointC;
    private CustomPoint pointD;
    private List<CustomObserver> customObservers = new ArrayList<>();

    public CustomQuadrangle(String name, CustomPoint...points) throws ShapeException {
        super(name);
        this.pointA = points[0];
        this.pointB = points[1];
        this.pointC = points[2];
        this.pointD = points[3];
        logger.info("New CustomQuadrangle object created");
    }

    public CustomPoint[] getPoints(){
        CustomPoint[] points = new CustomPoint[4];
        points[0] = pointA;
        points[1] = pointB;
        points[2] = pointC;
        points[3] = pointD;
        return points.clone();
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
        CustomQuadrangleFactory.sortPointsInTraversingOrder(getPoints());
        notifyObservers();
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
        CustomQuadrangleFactory.sortPointsInTraversingOrder(getPoints());
        notifyObservers();
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
        CustomQuadrangleFactory.sortPointsInTraversingOrder(getPoints());
        notifyObservers();
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
        CustomQuadrangleFactory.sortPointsInTraversingOrder(getPoints());
        notifyObservers();
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

    @Override
    public void attach(CustomObserver customObserver) {
        if (customObserver != null){
            customObservers.add(customObserver);
        }
    }

    @Override
    public void detach(CustomObserver customObserver) {
        customObservers.remove(customObserver);
    }

    @Override
    public void notifyObservers() {
        QuadrangleEvent event = new QuadrangleEvent(this);
        customObservers.forEach(o -> {
            try {
                o.parameterChanged(event);
            } catch (ShapeException e) {
                logger.error(e.getMessage());
            }
        });
    }
}
