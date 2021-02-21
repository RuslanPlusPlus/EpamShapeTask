package by.ruslan.quadrangle.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    static final Logger logger = LogManager.getLogger();
    private static final Warehouse warehouse = new Warehouse();
    private Map<Long, ShapeValue> valueMap = new HashMap<>();

    private Warehouse(){}

    public static Warehouse getInstance(){
        return warehouse;
    }

    public ShapeValue putShapeValue(long id, ShapeValue value){
        return valueMap.put(id, value);
    }

    public ShapeValue getShapeValue(long id){
        return valueMap.get(id);
    }

    public ShapeValue remove(long id){
        return valueMap.remove(id);
    }
}
