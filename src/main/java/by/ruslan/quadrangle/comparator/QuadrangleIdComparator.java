package by.ruslan.quadrangle.comparator;
import by.ruslan.quadrangle.entity.CustomPlaneShape;
import java.util.Comparator;

public class QuadrangleIdComparator implements Comparator<CustomPlaneShape> {

    @Override
    public int compare(CustomPlaneShape o1, CustomPlaneShape o2) {
        long id1 = o1.getId();
        long id2 = o2.getId();
        return Double.compare(id1, id2);
    }
}
