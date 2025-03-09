package ObserverPattern.WeatherObserver;


import ObserverPattern.WeatherObserver.Observable.IObservable;
import ObserverPattern.WeatherObserver.Observable.WetherObservable;
import ObserverPattern.WeatherObserver.Observer.EmailAlertObserver;
import ObserverPattern.WeatherObserver.Observer.IObserver;
import ObserverPattern.WeatherObserver.Observer.SMSAlertObserver;

public class Main {
    public static void main(String[] args) {
        IObservable wetherObservable = new WetherObservable();

        IObserver observer1 = new SMSAlertObserver("Aditya", wetherObservable);
        IObserver observer2 = new EmailAlertObserver("ravi", wetherObservable);

        wetherObservable.add(observer1);
        wetherObservable.add(observer2);
        wetherObservable.updateData(10);
//        wetherObservable.updateTemp(10);
//        wetherObservable.updateTemp(20);

    }
}
