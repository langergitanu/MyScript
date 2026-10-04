package com.myscript.nebo.penpanel;

import kotlin.Metadata;

/* JADX INFO: compiled from: ToolbarViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ColorNonePill;", "", "isVisible", "", "isSelected", "isEnabled", "<init>", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ColorNonePill {
    private final boolean isEnabled;
    private final boolean isSelected;
    private final boolean isVisible;

    public static /* synthetic */ ColorNonePill copy$default(ColorNonePill colorNonePill, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = colorNonePill.isVisible;
        }
        if ((i & 2) != 0) {
            z2 = colorNonePill.isSelected;
        }
        if ((i & 4) != 0) {
            z3 = colorNonePill.isEnabled;
        }
        return colorNonePill.copy(z, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final ColorNonePill copy(boolean isVisible, boolean isSelected, boolean isEnabled) {
        return new ColorNonePill(isVisible, isSelected, isEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorNonePill)) {
            return false;
        }
        ColorNonePill colorNonePill = (ColorNonePill) other;
        return this.isVisible == colorNonePill.isVisible && this.isSelected == colorNonePill.isSelected && this.isEnabled == colorNonePill.isEnabled;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.isVisible) * 31) + Boolean.hashCode(this.isSelected)) * 31) + Boolean.hashCode(this.isEnabled);
    }

    public String toString() {
        return "ColorNonePill(isVisible=" + this.isVisible + ", isSelected=" + this.isSelected + ", isEnabled=" + this.isEnabled + ")";
    }

    public ColorNonePill(boolean z, boolean z2, boolean z3) {
        this.isVisible = z;
        this.isSelected = z2;
        this.isEnabled = z3;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }
}
