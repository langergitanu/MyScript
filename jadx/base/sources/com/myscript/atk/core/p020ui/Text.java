package com.myscript.atk.core.p020ui;

import java.util.ArrayList;

/* JADX INFO: compiled from: FontMetricsProvider.java */
/* JADX INFO: loaded from: classes4.dex */
class Text {
    private final int[] ends;
    private final String label;

    Text(String str, int[] iArr) {
        this.label = str;
        this.ends = iArr;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getGlyphCount() {
        return this.ends.length;
    }

    public final int getGlyphCount(int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException("beginIndex should be <= endIndex");
        }
        ArrayList arrayList = new ArrayList(this.ends.length);
        int i3 = 0;
        for (int i4 : this.ends) {
            arrayList.add(Integer.valueOf(i4));
        }
        int iIndexOf = arrayList.indexOf(Integer.valueOf(i2 + 1));
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("ending byte not in the end of a glyph");
        }
        if (i != 0) {
            int iIndexOf2 = arrayList.indexOf(Integer.valueOf(i));
            if (iIndexOf2 == -1) {
                throw new IllegalArgumentException("beginning byte not in the beginning of a glyph");
            }
            i3 = iIndexOf2 + 1;
        }
        return (iIndexOf - i3) + 1;
    }

    public final int getGlyphBeginAt(int i) {
        if (i >= 0) {
            int[] iArr = this.ends;
            if (i < iArr.length) {
                if (i == 0) {
                    return 0;
                }
                return iArr[i - 1];
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public final int getGlyphEndAt(int i) {
        if (i >= 0) {
            int[] iArr = this.ends;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public final String getGlyphLabelAt(int i) {
        if (i >= 0) {
            int[] iArr = this.ends;
            if (i < iArr.length) {
                return i == 0 ? this.label.substring(0, iArr[0]) : this.label.substring(iArr[i - 1], iArr[i]);
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
