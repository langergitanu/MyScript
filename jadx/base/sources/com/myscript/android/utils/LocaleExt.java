package com.myscript.android.utils;

import android.content.res.Configuration;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocaleExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"getPrimaryLocale", "Ljava/util/Locale;", "Landroid/content/res/Configuration;", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LocaleExt {
    public static final Locale getPrimaryLocale(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        Locale locale = configuration.getLocales().get(0);
        Intrinsics.checkNotNull(locale);
        return locale;
    }
}
