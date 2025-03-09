package ObserverPattern.CartObserver.Observable;

import ObserverPattern.CartObserver.Observer.IObserver;

import java.util.LinkedList;
import java.util.List;

public class cartService implements IObservable{
    List<IObserver> observers;
    int cartCount;
    public cartService(){
        observers = new LinkedList<>();
        cartCount = 0;
    }
    @Override
    public void add(IObserver obj) {
        observers.add(obj);
    }

    @Override
    public void remove(IObserver obj) {
        observers.remove(obj);
    }

    @Override
    public void notification() {
        for(IObserver obj : observers){
            obj.update();
        }
    }

    @Override
    public void setData(int data) {
        if(cartCount == 0){
            cartCount = data;
            notification();
        }
        cartCount = data;
    }
}
