package ObserverPattern.CartObserver.Observable;

import ObserverPattern.CartObserver.Observer.IObserver;

public interface IObservable {
    void add(IObserver obj);
    void remove(IObserver obj);
    void notification();
    void setData(int data);

}
