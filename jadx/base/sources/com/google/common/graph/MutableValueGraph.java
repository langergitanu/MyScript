package com.google.common.graph;

/* JADX INFO: loaded from: classes6.dex */
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    boolean addNode(N node);

    V putEdgeValue(EndpointPair<N> endpoints, V value);

    V putEdgeValue(N nodeU, N nodeV, V value);

    V removeEdge(EndpointPair<N> endpoints);

    V removeEdge(N nodeU, N nodeV);

    boolean removeNode(N node);
}
