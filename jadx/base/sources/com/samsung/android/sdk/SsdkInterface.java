package com.samsung.android.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
public interface SsdkInterface {
    int getVersionCode();

    String getVersionName();

    void initialize(Context context) throws SsdkUnsupportedException;

    boolean isFeatureEnabled(int i);
}
