package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum GuidePurpose {
    NONE(0),
    TEXT_BASELINE(1),
    TEXT_MIDLINE(2),
    TEXT_ASCENDER(3),
    TEXT_DESCENDER(4),
    MUSIC_STAFF(5);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static GuidePurpose swigToEnum(int i) {
        GuidePurpose[] guidePurposeArr = (GuidePurpose[]) GuidePurpose.class.getEnumConstants();
        if (i < guidePurposeArr.length && i >= 0) {
            GuidePurpose guidePurpose = guidePurposeArr[i];
            if (guidePurpose.swigValue == i) {
                return guidePurpose;
            }
        }
        for (GuidePurpose guidePurpose2 : guidePurposeArr) {
            if (guidePurpose2.swigValue == i) {
                return guidePurpose2;
            }
        }
        throw new IllegalArgumentException("No enum " + GuidePurpose.class + " with value " + i);
    }

    GuidePurpose() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    GuidePurpose(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    GuidePurpose(GuidePurpose guidePurpose) {
        int i = guidePurpose.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
