package com.myscript.android.utils;

import android.content.SharedPreferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPreferencesExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\"\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0013\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0016¨\u0006\u0017"}, m1599d2 = {"nullableStringPref", "Lcom/myscript/android/utils/NullableStringSharedPreferencesProperty;", "Landroid/content/SharedPreferences;", "name", "", "default", "stringPref", "Lcom/myscript/android/utils/StringSharedPreferencesProperty;", "stringSetPref", "Lcom/myscript/android/utils/StringSetSharedPreferencesProperty;", "", "longPref", "Lcom/myscript/android/utils/LongSharedPreferencesProperty;", "", "intPref", "Lcom/myscript/android/utils/IntSharedPreferencesProperty;", "", "floatPref", "Lcom/myscript/android/utils/FloatSharedPreferencesProperty;", "", "booleanPref", "Lcom/myscript/android/utils/BooleanSharedPreferencesProperty;", "", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SharedPreferencesExtKt {
    public static /* synthetic */ NullableStringSharedPreferencesProperty nullableStringPref$default(SharedPreferences sharedPreferences, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return nullableStringPref(sharedPreferences, str, str2);
    }

    public static final NullableStringSharedPreferencesProperty nullableStringPref(SharedPreferences sharedPreferences, String name, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return new NullableStringSharedPreferencesProperty(sharedPreferences, name, str);
    }

    public static final StringSharedPreferencesProperty stringPref(SharedPreferences sharedPreferences, String name, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(str, "default");
        return new StringSharedPreferencesProperty(sharedPreferences, name, str);
    }

    public static /* synthetic */ StringSetSharedPreferencesProperty stringSetPref$default(SharedPreferences sharedPreferences, String str, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        return stringSetPref(sharedPreferences, str, set);
    }

    public static final StringSetSharedPreferencesProperty stringSetPref(SharedPreferences sharedPreferences, String name, Set<String> set) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(set, "default");
        return new StringSetSharedPreferencesProperty(sharedPreferences, name, set);
    }

    public static /* synthetic */ LongSharedPreferencesProperty longPref$default(SharedPreferences sharedPreferences, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return longPref(sharedPreferences, str, j);
    }

    public static final LongSharedPreferencesProperty longPref(SharedPreferences sharedPreferences, String name, long j) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return new LongSharedPreferencesProperty(sharedPreferences, name, j);
    }

    public static /* synthetic */ IntSharedPreferencesProperty intPref$default(SharedPreferences sharedPreferences, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return intPref(sharedPreferences, str, i);
    }

    public static final IntSharedPreferencesProperty intPref(SharedPreferences sharedPreferences, String name, int i) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return new IntSharedPreferencesProperty(sharedPreferences, name, i);
    }

    public static /* synthetic */ FloatSharedPreferencesProperty floatPref$default(SharedPreferences sharedPreferences, String str, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return floatPref(sharedPreferences, str, f);
    }

    public static final FloatSharedPreferencesProperty floatPref(SharedPreferences sharedPreferences, String name, float f) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return new FloatSharedPreferencesProperty(sharedPreferences, name, f);
    }

    public static /* synthetic */ BooleanSharedPreferencesProperty booleanPref$default(SharedPreferences sharedPreferences, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return booleanPref(sharedPreferences, str, z);
    }

    public static final BooleanSharedPreferencesProperty booleanPref(SharedPreferences sharedPreferences, String name, boolean z) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return new BooleanSharedPreferencesProperty(sharedPreferences, name, z);
    }
}
