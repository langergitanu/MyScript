package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import com.revenuecat.purchases.common.HTTPClient;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class GZipEncoding implements HttpEncoding {
    @Override // com.google.api.client.http.HttpEncoding
    public String getName() {
        return HTTPClient.RC_FORMAT_ACCEPT_ENCODING;
    }

    @Override // com.google.api.client.http.HttpEncoding
    public void encode(StreamingContent streamingContent, OutputStream outputStream) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(outputStream) { // from class: com.google.api.client.http.GZipEncoding.1
            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    flush();
                } catch (IOException unused) {
                }
            }
        });
        streamingContent.writeTo(gZIPOutputStream);
        gZIPOutputStream.close();
    }
}
