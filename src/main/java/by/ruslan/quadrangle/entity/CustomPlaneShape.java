package by.ruslan.quadrangle.entity;

import by.ruslan.quadrangle.util.IdGenerator;

public abstract class CustomPlaneShape {
    private long id;
    private String name ;

    public CustomPlaneShape(String name){
        this.name = name;
        id = IdGenerator.generateId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
