package com.myscript.nebo.note.p030ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.C6079R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageBackgroundPattern.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\fJ\u0014\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\fHÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/note/ui/PageBackgroundPattern;", "Landroid/os/Parcelable;", "pattern", "Lcom/myscript/atk/core/BackgroundPattern;", "isSelected", "", "<init>", "(Lcom/myscript/atk/core/BackgroundPattern;Z)V", "getPattern", "()Lcom/myscript/atk/core/BackgroundPattern;", "()Z", "assetRes", "", "getAssetRes", "()I", "component1", "component2", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class PageBackgroundPattern implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<PageBackgroundPattern> CREATOR = new Creator();
    private final boolean isSelected;
    private final BackgroundPattern pattern;

    /* JADX INFO: compiled from: PageBackgroundPattern.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<PageBackgroundPattern> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PageBackgroundPattern createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PageBackgroundPattern(BackgroundPattern.valueOf(parcel.readString()), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PageBackgroundPattern[] newArray(int i) {
            return new PageBackgroundPattern[i];
        }
    }

    /* JADX INFO: compiled from: PageBackgroundPattern.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackgroundPattern.values().length];
            try {
                iArr[BackgroundPattern.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackgroundPattern.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BackgroundPattern.LINES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BackgroundPattern.DOTS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ PageBackgroundPattern copy$default(PageBackgroundPattern pageBackgroundPattern, BackgroundPattern backgroundPattern, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            backgroundPattern = pageBackgroundPattern.pattern;
        }
        if ((i & 2) != 0) {
            z = pageBackgroundPattern.isSelected;
        }
        return pageBackgroundPattern.copy(backgroundPattern, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BackgroundPattern getPattern() {
        return this.pattern;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final PageBackgroundPattern copy(BackgroundPattern pattern, boolean isSelected) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        return new PageBackgroundPattern(pattern, isSelected);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageBackgroundPattern)) {
            return false;
        }
        PageBackgroundPattern pageBackgroundPattern = (PageBackgroundPattern) other;
        return this.pattern == pageBackgroundPattern.pattern && this.isSelected == pageBackgroundPattern.isSelected;
    }

    public int hashCode() {
        return (this.pattern.hashCode() * 31) + Boolean.hashCode(this.isSelected);
    }

    public String toString() {
        return "PageBackgroundPattern(pattern=" + this.pattern + ", isSelected=" + this.isSelected + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.pattern.name());
        dest.writeInt(this.isSelected ? 1 : 0);
    }

    public PageBackgroundPattern(BackgroundPattern pattern, boolean z) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        this.pattern = pattern;
        this.isSelected = z;
    }

    public /* synthetic */ PageBackgroundPattern(BackgroundPattern backgroundPattern, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(backgroundPattern, (i & 2) != 0 ? false : z);
    }

    public final BackgroundPattern getPattern() {
        return this.pattern;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final int getAssetRes() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.pattern.ordinal()];
        if (i == 1) {
            return C6079R.drawable.page_pattern_blank;
        }
        if (i == 2) {
            return C6079R.drawable.page_pattern_grid;
        }
        if (i == 3) {
            return C6079R.drawable.page_pattern_lines;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return C6079R.drawable.page_pattern_dots;
    }
}
