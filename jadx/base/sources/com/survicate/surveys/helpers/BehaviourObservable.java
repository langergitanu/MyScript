package com.survicate.surveys.helpers;

import com.survicate.surveys.helpers.Observable;

/* JADX INFO: loaded from: classes8.dex */
public class BehaviourObservable<T> extends Observable<T> {
    private volatile T lastValue;

    @Override // com.survicate.surveys.helpers.Observable
    public void addObserver(Observable.Observer<? super T> observer) {
        super.addObserver(observer);
        synchronized (this) {
            if (this.lastValue != null) {
                observer.update(this.lastValue);
            }
        }
    }

    @Override // com.survicate.surveys.helpers.Observable
    public void notifyObservers(T t) {
        super.notifyObservers(t);
        this.lastValue = t;
    }

    public T getLastValue() {
        return this.lastValue;
    }
}
