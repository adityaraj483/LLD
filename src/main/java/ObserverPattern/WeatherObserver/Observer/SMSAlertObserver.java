package ObserverPattern.WeatherObserver.Observer;

import ObserverPattern.WeatherObserver.Observable.IObservable;

public class SMSAlertObserver implements IObserver {
    String name;
    IObservable observable;
    public SMSAlertObserver(String name, IObservable obj){
        this.name = name;
        observable = obj;
    }
    @Override
    public void update() {
        System.out.println("SMS send to "+ name+" for "+ observable.getClass().getName());
    }
}
