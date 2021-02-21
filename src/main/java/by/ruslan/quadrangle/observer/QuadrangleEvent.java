package by.ruslan.quadrangle.observer;

import by.ruslan.quadrangle.entity.CustomQuadrangle;

import java.util.EventObject;

public class QuadrangleEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public QuadrangleEvent(CustomQuadrangle source) {
        super(source);
    }

    public CustomQuadrangle getSource(){
        return (CustomQuadrangle) super.source;
    }
}
