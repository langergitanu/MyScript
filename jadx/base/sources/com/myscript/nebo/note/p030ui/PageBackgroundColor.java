package com.myscript.nebo.note.p030ui;

import android.os.Parcel;
import android.os.Parcelable;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: PageBackgroundColor.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0003J\u0014\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u001d"}, m1599d2 = {"Lcom/myscript/nebo/note/ui/PageBackgroundColor;", "Landroid/os/Parcelable;", "color", "", "color2", "isSelected", "", "<init>", "(IIZ)V", "getColor", "()I", "getColor2", "()Z", "toString", "", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class PageBackgroundColor implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<PageBackgroundColor> CREATOR = new Creator();
    private final int color;
    private final int color2;
    private final boolean isSelected;

    /* JADX INFO: compiled from: PageBackgroundColor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<PageBackgroundColor> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PageBackgroundColor createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PageBackgroundColor(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PageBackgroundColor[] newArray(int i) {
            return new PageBackgroundColor[i];
        }
    }

    public static /* synthetic */ PageBackgroundColor copy$default(PageBackgroundColor pageBackgroundColor, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = pageBackgroundColor.color;
        }
        if ((i3 & 2) != 0) {
            i2 = pageBackgroundColor.color2;
        }
        if ((i3 & 4) != 0) {
            z = pageBackgroundColor.isSelected;
        }
        return pageBackgroundColor.copy(i, i2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor2() {
        return this.color2;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final PageBackgroundColor copy(int color, int color2, boolean isSelected) {
        return new PageBackgroundColor(color, color2, isSelected);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageBackgroundColor)) {
            return false;
        }
        PageBackgroundColor pageBackgroundColor = (PageBackgroundColor) other;
        return this.color == pageBackgroundColor.color && this.color2 == pageBackgroundColor.color2 && this.isSelected == pageBackgroundColor.isSelected;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.color) * 31) + Integer.hashCode(this.color2)) * 31) + Boolean.hashCode(this.isSelected);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.color);
        dest.writeInt(this.color2);
        dest.writeInt(this.isSelected ? 1 : 0);
    }

    public PageBackgroundColor(int i, int i2, boolean z) {
        this.color = i;
        this.color2 = i2;
        this.isSelected = z;
    }

    public /* synthetic */ PageBackgroundColor(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? false : z);
    }

    public final int getColor() {
        return this.color;
    }

    public final int getColor2() {
        return this.color2;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf(this.color)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf(this.color2)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        String str3 = Literals.COMMENT_1 + str + "/#" + str2 + "(displayed)";
        return this.isSelected ? str3 + " ✓" : str3;
    }
}
