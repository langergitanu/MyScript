package com.myscript.nebo.common;

import android.os.Handler;
import android.os.Looper;
import com.squareup.otto.Bus;

/* JADX INFO: loaded from: classes3.dex */
public final class MainThreadBus extends Bus {
    public static final Bus eventBus = new MainThreadBus();
    private final Handler handler = new Handler(Looper.getMainLooper());

    private MainThreadBus() {
    }

    @Override // com.squareup.otto.Bus
    public void post(final Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(obj);
        } else {
            this.handler.post(new Runnable() { // from class: com.myscript.nebo.common.MainThreadBus.1
                @Override // java.lang.Runnable
                public void run() {
                    MainThreadBus.super.post(obj);
                }
            });
        }
    }
}
