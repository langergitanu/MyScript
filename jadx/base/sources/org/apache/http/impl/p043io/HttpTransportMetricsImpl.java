package org.apache.http.impl.p043io;

import org.apache.http.p044io.HttpTransportMetrics;

/* JADX INFO: loaded from: classes7.dex */
public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    private long bytesTransferred = 0;

    @Override // org.apache.http.p044io.HttpTransportMetrics
    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void setBytesTransferred(long j) {
        this.bytesTransferred = j;
    }

    public void incrementBytesTransferred(long j) {
        this.bytesTransferred += j;
    }

    @Override // org.apache.http.p044io.HttpTransportMetrics
    public void reset() {
        this.bytesTransferred = 0L;
    }
}
