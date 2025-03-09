package ObserverPattern.CartObserver.Observer;

import ObserverPattern.CartObserver.Observable.IObservable;

public class User implements IObserver{
    IObservable observer;
    int id;
    String name;
    public User(int id, String name, IObservable obj){
        this.id = id;
        this.name = name;
        this.observer = obj;
    }
    @Override
    public void update() {
        System.out.println("Cart updated with new stock "+ observer.getClass().getTypeName());
    }
}
