package com.samsung.android.spen.libwrapper.utils;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes8.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public static Class classForName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException | LinkageError e) {
            Log.d(TAG, "Cannot load class: " + str + " : " + e.getMessage());
            return null;
        }
    }

    public static Constructor getConstructor(Class cls, Class... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getConstructor(clsArr);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "Cannot load constructor : " + e.getMessage());
            return null;
        }
    }

    public static Method getMethod(Class cls, String str, Class... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "Cannot load method: " + e.getMessage());
            return null;
        }
    }

    public static Field getField(Class cls, String str) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getField(str);
        } catch (NoSuchFieldException | SecurityException e) {
            Log.d(TAG, "Cannot load field: " + e.getMessage());
            return null;
        }
    }
}
