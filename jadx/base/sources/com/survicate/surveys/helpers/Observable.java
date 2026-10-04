package com.survicate.surveys.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class Observable<T> {
    private final Collection<Observer<? super T>> observers = new ArrayList();

    public interface Observer<U> {
        void update(U u);
    }

    public void addObserver(Observer<? super T> observer) {
        synchronized (this.observers) {
            if (!this.observers.contains(observer)) {
                this.observers.add(observer);
            }
        }
    }

    public void removeObserver(Observer<? super T> observer) {
        synchronized (this.observers) {
            this.observers.remove(observer);
        }
    }

    public void clearObservers() {
        synchronized (this.observers) {
            this.observers.clear();
        }
    }

    public int countObservers() {
        int size;
        synchronized (this.observers) {
            size = this.observers.size();
        }
        return size;
    }

    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(T t) {
        ArrayList arrayList;
        synchronized (this.observers) {
            arrayList = new ArrayList(this.observers);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Observer) it.next()).update(t);
        }
    }
}
