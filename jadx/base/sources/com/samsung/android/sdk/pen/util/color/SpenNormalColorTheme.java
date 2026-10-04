package com.samsung.android.sdk.pen.util.color;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenNormalColorTheme.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/util/color/SpenNormalColorTheme;", "Lcom/samsung/android/sdk/pen/util/color/SpenIColorTheme;", "<init>", "()V", "getColor", "", "color", "", "input", "", "output", "close", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public class SpenNormalColorTheme implements SpenIColorTheme {
    @Override // com.samsung.android.sdk.pen.util.color.SpenIColorTheme
    public void close() {
    }

    @Override // com.samsung.android.sdk.pen.util.color.SpenIColorTheme
    public int getColor(int color) {
        return color;
    }

    @Override // com.samsung.android.sdk.pen.util.color.SpenIColorTheme
    public boolean getColor(float[] input, float[] output) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        System.arraycopy(input, 0, output, 0, input.length);
        return true;
    }
}
