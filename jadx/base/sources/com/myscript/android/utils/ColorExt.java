package com.myscript.android.utils;

import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u00012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u001a7\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u0002H\t2\u0006\u0010\u000b\u001a\u0002H\t2\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012*\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0015\u0010\u000e\u001a\u00020\u0007*\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0013\u001a\u00020\u0007*\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010\"\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m1599d2 = {"RED_PERCEPTION", "", "GREEN_PERCEPTION", "BLUE_PERCEPTION", "BRIGHTNESS_THRESHOLD", "getPerceivedBrightness", "color", "", "getBrightnessAwareValue", ExifInterface.GPS_DIRECTION_TRUE, "valueIfLight", "valueIfDark", "threshold", "(ILjava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "opaque", "getOpaque", "(I)I", "asOpaqueColors", "", "toRGBA", "getToRGBA", "toHex", "", "getToHex", "(I)Ljava/lang/String;", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ColorExt {
    private static final float BLUE_PERCEPTION = 0.114f;
    public static final float BRIGHTNESS_THRESHOLD = 0.75f;
    private static final float GREEN_PERCEPTION = 0.587f;
    private static final float RED_PERCEPTION = 0.299f;

    public static final <T> T getBrightnessAwareValue(int i, T t, T t2) {
        return (T) getBrightnessAwareValue$default(i, t, t2, 0.0f, 8, null);
    }

    public static final int getToRGBA(int i) {
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        return ((i & 255) << 8) | (i2 << 24) | (i3 << 16) | ((i >> 24) & 255);
    }

    public static final float getPerceivedBrightness(int i) {
        float f = ((i >> 24) & 255) / 255.0f;
        float f2 = ((i >> 16) & 255) / 255.0f;
        float f3 = ((i >> 8) & 255) / 255.0f;
        float f4 = (i & 255) / 255.0f;
        return 1 - (f * ((float) (((double) 1) - Math.sqrt((((double) ((RED_PERCEPTION * f2) * f2)) + ((double) ((GREEN_PERCEPTION * f3) * f3))) + ((double) ((BLUE_PERCEPTION * f4) * f4))))));
    }

    public static /* synthetic */ Object getBrightnessAwareValue$default(int i, Object obj, Object obj2, float f, int i2, Object obj3) {
        if ((i2 & 8) != 0) {
            f = 0.75f;
        }
        return getBrightnessAwareValue(i, obj, obj2, f);
    }

    public static final <T> T getBrightnessAwareValue(int i, T t, T t2, float f) {
        return getPerceivedBrightness(i) < f ? t : t2;
    }

    public static final int getOpaque(int i) {
        return ColorUtils.setAlphaComponent(i, 255);
    }

    public static final List<Integer> asOpaqueColors(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<Integer> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(getOpaque(((Number) it.next()).intValue())));
        }
        return arrayList;
    }

    public static final String getToHex(int i) {
        String str = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
