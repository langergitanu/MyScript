package com.google.android.gms.common.data;

import com.myscript.atk.core.SWIGVectorInkStyle;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.10.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        SWIGVectorInkStyle sWIGVectorInkStyle = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sWIGVectorInkStyle.add(arrayList.get(i).freeze());
        }
        return sWIGVectorInkStyle;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        SWIGVectorInkStyle sWIGVectorInkStyle = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            sWIGVectorInkStyle.add(it.next().freeze());
        }
        return sWIGVectorInkStyle;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        SWIGVectorInkStyle sWIGVectorInkStyle = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            sWIGVectorInkStyle.add(e.freeze());
        }
        return sWIGVectorInkStyle;
    }
}
