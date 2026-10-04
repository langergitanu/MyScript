package com.dropbox.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LangUtil {
    public static RuntimeException mkAssert(String str, Throwable th) {
        RuntimeException runtimeException = new RuntimeException(str + ": " + th.getMessage());
        runtimeException.initCause(th);
        return runtimeException;
    }

    public static AssertionError badType(Object obj) {
        String str;
        if (obj == null) {
            str = "bad type: null";
        } else {
            str = "bad type: " + obj.getClass().getName();
        }
        return new AssertionError(str);
    }

    public static <T> T[] arrayConcat(T[] tArr, T[] tArr2) {
        if (tArr == null) {
            throw new IllegalArgumentException("'a' can't be null");
        }
        if (tArr2 == null) {
            throw new IllegalArgumentException("'b' can't be null");
        }
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static <T> boolean nullableEquals(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        if (t2 == null) {
            return false;
        }
        return t.equals(t2);
    }

    public static int nullableHashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode() + 1;
    }

    public static Date truncateMillis(Date date) {
        if (date == null) {
            return date;
        }
        long time = date.getTime();
        return new Date(time - (time % 1000));
    }

    public static List<Date> truncateMillis(List<Date> list) {
        if (list == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Date> it = list.iterator();
        while (it.hasNext()) {
            long time = it.next().getTime();
            arrayList.add(new Date(time - (time % 1000)));
        }
        return arrayList;
    }
}
