package com.myscript.nebo.penpanel;

import aws.sdk.kotlin.runtime.config.profile.Literals;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ColorExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ToolbarViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ColorPill;", "", FirebaseAnalytics.Param.INDEX, "", "color", "displayedColor", "isSelected", "", "<init>", "(IIIZ)V", "getIndex", "()I", "getColor", "getDisplayedColor", "()Z", "toString", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ColorPill {
    private final int color;
    private final int displayedColor;
    private final int index;
    private final boolean isSelected;

    public static /* synthetic */ ColorPill copy$default(ColorPill colorPill, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = colorPill.index;
        }
        if ((i4 & 2) != 0) {
            i2 = colorPill.color;
        }
        if ((i4 & 4) != 0) {
            i3 = colorPill.displayedColor;
        }
        if ((i4 & 8) != 0) {
            z = colorPill.isSelected;
        }
        return colorPill.copy(i, i2, i3, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDisplayedColor() {
        return this.displayedColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final ColorPill copy(int index, int color, int displayedColor, boolean isSelected) {
        return new ColorPill(index, color, displayedColor, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorPill)) {
            return false;
        }
        ColorPill colorPill = (ColorPill) other;
        return this.index == colorPill.index && this.color == colorPill.color && this.displayedColor == colorPill.displayedColor && this.isSelected == colorPill.isSelected;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.index) * 31) + Integer.hashCode(this.color)) * 31) + Integer.hashCode(this.displayedColor)) * 31) + Boolean.hashCode(this.isSelected);
    }

    public ColorPill(int i, int i2, int i3, boolean z) {
        this.index = i;
        this.color = i2;
        this.displayedColor = i3;
        this.isSelected = z;
    }

    public /* synthetic */ ColorPill(int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i4 & 8) != 0 ? false : z);
    }

    public final int getColor() {
        return this.color;
    }

    public final int getDisplayedColor() {
        return this.displayedColor;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        String str = Literals.COMMENT_1 + ColorExt.getToHex(this.color) + "/#" + ColorExt.getToHex(this.displayedColor) + "(displayed) @" + this.index;
        return this.isSelected ? str + " ✓" : str;
    }
}
