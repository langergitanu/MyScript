package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.10.0 */
/* JADX INFO: loaded from: classes5.dex */
public class zar extends Handler {
    private final Looper zaa;

    public zar() {
        this.zaa = Looper.getMainLooper();
    }

    public zar(Looper looper) {
        super(looper);
        this.zaa = Looper.getMainLooper();
    }

    public zar(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zaa = Looper.getMainLooper();
    }
}
