package com.yalantis.ucrop;

import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes8.dex */
public class UCropInitializer {
    public UCropInitializer setOkHttpClient(OkHttpClient okHttpClient) {
        OkHttpClientStore.INSTANCE.setClient(okHttpClient);
        return this;
    }
}
