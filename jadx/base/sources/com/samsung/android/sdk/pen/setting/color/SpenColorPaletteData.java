package com.samsung.android.sdk.pen.setting.color;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenColorPaletteData.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "", "<init>", "()V", FirebaseAnalytics.Param.SOURCE, "(Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;)V", "valueId", "", "nameId", FirebaseAnalytics.Param.INDEX, "values", "", "names", "", "", "[Ljava/lang/String;", "themeValues", "Companion", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenColorPaletteData {
    public static final int TABLE_SIZE = 8;
    public int index;
    public int nameId;
    public String[] names;
    public int[] themeValues;
    public int valueId;
    public int[] values;

    public SpenColorPaletteData() {
        this.values = new int[8];
        this.names = new String[8];
        this.themeValues = new int[8];
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenColorPaletteData(SpenColorPaletteData source) {
        this();
        Intrinsics.checkNotNullParameter(source, "source");
        this.index = source.index;
        this.valueId = source.valueId;
        this.nameId = source.nameId;
        System.arraycopy(source.values, 0, this.values, 0, 8);
        System.arraycopy(source.names, 0, this.names, 0, 8);
        System.arraycopy(source.themeValues, 0, this.themeValues, 0, 8);
    }
}
