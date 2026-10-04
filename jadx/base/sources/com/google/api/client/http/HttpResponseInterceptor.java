package com.google.api.client.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public interface HttpResponseInterceptor {
    void interceptResponse(HttpResponse httpResponse) throws IOException;
}
