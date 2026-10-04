package com.google.common.base;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class Objects extends ExtraObjectsMethodsForWeb {
    private Objects() {
    }

    public static boolean equal(Object a2, Object b) {
        if (a2 != b) {
            return a2 != null && a2.equals(b);
        }
        return true;
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
