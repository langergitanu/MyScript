package org.apache.http.p044io;

import org.apache.http.HttpMessage;

/* JADX INFO: loaded from: classes7.dex */
public interface HttpMessageWriterFactory<T extends HttpMessage> {
    HttpMessageWriter<T> create(SessionOutputBuffer sessionOutputBuffer);
}
