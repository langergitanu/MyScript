package com.myscript.nebo.penpanel;

import kotlin.Metadata;

/* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ThicknessPill;", "", "iconRes", "", "thicknessRatio", "", "<init>", "(IF)V", "getIconRes", "()I", "getThicknessRatio", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ThicknessPill {
    private final int iconRes;
    private final float thicknessRatio;

    public static /* synthetic */ ThicknessPill copy$default(ThicknessPill thicknessPill, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = thicknessPill.iconRes;
        }
        if ((i2 & 2) != 0) {
            f = thicknessPill.thicknessRatio;
        }
        return thicknessPill.copy(i, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getThicknessRatio() {
        return this.thicknessRatio;
    }

    public final ThicknessPill copy(int iconRes, float thicknessRatio) {
        return new ThicknessPill(iconRes, thicknessRatio);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThicknessPill)) {
            return false;
        }
        ThicknessPill thicknessPill = (ThicknessPill) other;
        return this.iconRes == thicknessPill.iconRes && Float.compare(this.thicknessRatio, thicknessPill.thicknessRatio) == 0;
    }

    public int hashCode() {
        return (Integer.hashCode(this.iconRes) * 31) + Float.hashCode(this.thicknessRatio);
    }

    public String toString() {
        return "ThicknessPill(iconRes=" + this.iconRes + ", thicknessRatio=" + this.thicknessRatio + ")";
    }

    public ThicknessPill(int i, float f) {
        this.iconRes = i;
        this.thicknessRatio = f;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final float getThicknessRatio() {
        return this.thicknessRatio;
    }
}
