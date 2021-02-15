package by.ruslan.quadrangle.entity;

import by.ruslan.quadrangle.generator.IdGenerator;

public abstract class CustomShape {
    private long id;
    private String name ;

    public CustomShape(String name){
        this.name = name;
        id = IdGenerator.getId();
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
