package ObserverPattern.CartObserver;

import ObserverPattern.CartObserver.Observable.IObservable;
import ObserverPattern.CartObserver.Observable.cartService;
import ObserverPattern.CartObserver.Observer.User;

public class Main {
    public static void main(String[] args) {
        IObservable observable1 = new cartService();
        User user1 = new User(1, "Aditya", observable1);
        observable1.add(user1);
        observable1.setData(20);
    }
}
