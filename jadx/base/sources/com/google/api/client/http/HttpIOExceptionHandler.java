package com.google.api.client.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public interface HttpIOExceptionHandler {
    boolean handleIOException(HttpRequest httpRequest, boolean z) throws IOException;
}
