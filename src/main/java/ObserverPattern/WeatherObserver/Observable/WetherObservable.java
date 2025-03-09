package ObserverPattern.WeatherObserver.Observable;

import ObserverPattern.WeatherObserver.Observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class WetherObservable implements IObservable {
    int temp;
    List<IObserver> observerList = new ArrayList<>();
    @Override
    public void add(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notification() {
        for(IObserver obj : observerList)
            obj.update();
    }
    public void updateData(int temp){
        if(this.temp == temp)
            return;
        this.temp = temp;
        notification();
    }
}
