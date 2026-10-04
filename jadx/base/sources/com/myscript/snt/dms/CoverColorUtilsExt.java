package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public final class CoverColorUtilsExt {
    private CoverColorUtilsExt() {
    }

    public static int computeGradientEndColor(int i, float f) {
        return NeboDMS.computeARGBGradientEndColor(i, f);
    }

    public static int computeGradientEndColor(int i) {
        return NeboDMS.computeARGBGradientEndColor(i, 0.2f);
    }
}
