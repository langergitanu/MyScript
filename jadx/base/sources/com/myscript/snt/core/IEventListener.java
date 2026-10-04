package com.myscript.snt.core;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface IEventListener {
    void flush();

    void gestureTriggered(String str, int i, int i2, int i3, String str2);

    void holdItemAdded(String str, List<Long> list);

    void itemAdded(String str, long j);

    void itemChanged(String str, long j);

    void itemRemoved(String str, long j);

    void selectionChanged();
}
