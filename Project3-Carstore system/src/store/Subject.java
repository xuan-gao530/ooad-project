package store;

public interface Subject {
        public void registerObserver(Observer o);//take an Observer as an argument
        public void removeObserver(Observer o);
        public void notifyObservers();            //notify all observer
    }

