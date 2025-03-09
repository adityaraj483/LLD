package ObserverPattern.WeatherObserver.Observer;

import ObserverPattern.WeatherObserver.Observable.IObservable;

public class EmailAlertObserver implements IObserver {
    String name;
    IObservable observable;
    public EmailAlertObserver(String name, IObservable obj){
        this.name = name;
        observable = obj;
    }
    @Override
    public void update() {
        System.out.println("Email send to "+ name+" for "+ observable.getClass().getName());
    }
}
