package io.grpc;

/* JADX INFO: loaded from: classes8.dex */
public abstract class ClientTransportFilter {
    public Attributes transportReady(Attributes attributes) {
        return attributes;
    }

    public void transportTerminated(Attributes attributes) {
    }
}
