package com.survicate.surveys.utils;

import android.graphics.Rect;
import androidx.exifinterface.media.ExifInterface;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import com.survicate.surveys.TextRecallingManager;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MiscUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a>\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u0006`\u0007\"\u0004\b\u0000\u0010\u00062\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u00060\t\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u001c\u0010\u0011\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¨\u0006\u0012"}, m1599d2 = {"reflectionToString", "", "obj", "", "filterOutNullValues", "Ljava/util/HashMap;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/HashMap;", "map", "", "setStart", "", "Landroid/graphics/Rect;", "value", "", "isRtl", "", "setEnd", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MiscUtilsKt {
    public static final String reflectionToString(Object obj) throws IllegalAccessException {
        String string;
        Intrinsics.checkNotNullParameter(obj, "obj");
        LinkedList linkedList = new LinkedList();
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            Field[] declaredFields = superclass.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
            ArrayList<Field> arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    arrayList.add(field);
                }
            }
            for (Field field2 : arrayList) {
                field2.setAccessible(true);
                LinkedList linkedList2 = linkedList;
                StringBuilder sbAppend = new StringBuilder().append(field2.getName()).append(Literals.PROPERTY_SPLITTER);
                Object obj2 = field2.get(obj);
                linkedList2.add(sbAppend.append((obj2 == null || (string = obj2.toString()) == null) ? null : StringsKt.trim((CharSequence) string).toString()).toString());
            }
        }
        return obj.getClass().getSimpleName() + "=[" + CollectionsKt.joinToString$default(linkedList, TextRecallingManager.ANSWER_SEPARATOR, null, null, 0, null, null, 62, null) + ']';
    }

    public static final void setStart(Rect rect, int i, boolean z) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        if (z) {
            rect.right = i;
        } else {
            rect.left = i;
        }
    }

    public static final void setEnd(Rect rect, int i, boolean z) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        if (z) {
            rect.left = i;
        } else {
            rect.right = i;
        }
    }

    public static final <T> HashMap<String, T> filterOutNullValues(Map<String, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends T> entry : map.entrySet()) {
            String key = entry.getKey();
            T value = entry.getValue();
            Pair pairM1606to = value != null ? TuplesKt.m1606to(key, value) : null;
            if (pairM1606to != null) {
                arrayList.add(pairM1606to);
            }
        }
        return (HashMap) MapsKt.toMap(arrayList, new HashMap());
    }
}
