package com.myscript.nebo.grid;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToolbarExt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, m1599d2 = {"setElevationBasedOnScroll", "", "Landroid/view/View;", "scrollOffset", "", "scrollRange", "maxElevation", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ToolbarExtKt {
    public static final void setElevationBasedOnScroll(View view, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (i2 == 0) {
            return;
        }
        float f = (i / i2) * 100;
        float f2 = 2;
        float f3 = f <= f2 ? (f / f2) * i3 : f > f2 ? i3 : 0.0f;
        if (f3 == view.getElevation()) {
            return;
        }
        view.setElevation(f3);
    }
}
