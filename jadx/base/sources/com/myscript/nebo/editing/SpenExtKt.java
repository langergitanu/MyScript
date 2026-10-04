package com.myscript.nebo.editing;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenExt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"isSamsungSpenTablet", "", "Landroid/content/Context;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SpenExtKt {
    public static final boolean isSamsungSpenTablet(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getPackageManager().hasSystemFeature("com.sec.feature.spen_usp") && (context.getResources().getConfiguration().smallestScreenWidthDp >= 600);
    }
}
