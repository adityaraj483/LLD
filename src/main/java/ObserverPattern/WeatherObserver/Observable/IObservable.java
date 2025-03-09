package ObserverPattern.WeatherObserver.Observable;

import ObserverPattern.WeatherObserver.Observer.IObserver;

public interface IObservable {
    void add(IObserver observer);
    void remove(IObserver observer);
    void notification();
    void updateData(int temp);
}
