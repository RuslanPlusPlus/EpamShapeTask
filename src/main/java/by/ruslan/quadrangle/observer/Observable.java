package by.ruslan.quadrangle.observer;

public interface Observable {
    void attach(CustomObserver customObserver);
    void detach(CustomObserver customObserver);
    void notifyObservers();
}
