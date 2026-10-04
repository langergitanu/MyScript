package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface ListMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    boolean equals(Object obj);

    @Override // 
    List<V> get(K key);

    @Override // 
    List<V> removeAll(Object key);

    @Override // 
    List<V> replaceValues(K key, Iterable<? extends V> values);
}
