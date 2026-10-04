package com.myscript.nebo.editing;

import android.os.Parcel;
import android.os.Parcelable;
import com.myscript.nebo.note.p030ui.PageBackgroundColor;
import com.myscript.nebo.note.p030ui.PageBackgroundPattern;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000e¨\u0006 "}, m1599d2 = {"Lcom/myscript/nebo/editing/BackgroundSettingsUIState;", "Landroid/os/Parcelable;", "backgroundColors", "", "Lcom/myscript/nebo/note/ui/PageBackgroundColor;", "backgroundPatterns", "Lcom/myscript/nebo/note/ui/PageBackgroundPattern;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getBackgroundColors", "()Ljava/util/List;", "getBackgroundPatterns", "isBackgroundPatternListVisible", "", "()Z", "isBackgroundColorListVisible", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class BackgroundSettingsUIState implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<BackgroundSettingsUIState> CREATOR = new Creator();
    private final List<PageBackgroundColor> backgroundColors;
    private final List<PageBackgroundPattern> backgroundPatterns;

    /* JADX INFO: compiled from: PageViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<BackgroundSettingsUIState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BackgroundSettingsUIState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(PageBackgroundColor.CREATOR.createFromParcel(parcel));
            }
            ArrayList arrayList2 = arrayList;
            int i3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList3.add(PageBackgroundPattern.CREATOR.createFromParcel(parcel));
            }
            return new BackgroundSettingsUIState(arrayList2, arrayList3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BackgroundSettingsUIState[] newArray(int i) {
            return new BackgroundSettingsUIState[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundSettingsUIState() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackgroundSettingsUIState copy$default(BackgroundSettingsUIState backgroundSettingsUIState, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = backgroundSettingsUIState.backgroundColors;
        }
        if ((i & 2) != 0) {
            list2 = backgroundSettingsUIState.backgroundPatterns;
        }
        return backgroundSettingsUIState.copy(list, list2);
    }

    public final List<PageBackgroundColor> component1() {
        return this.backgroundColors;
    }

    public final List<PageBackgroundPattern> component2() {
        return this.backgroundPatterns;
    }

    public final BackgroundSettingsUIState copy(List<PageBackgroundColor> backgroundColors, List<PageBackgroundPattern> backgroundPatterns) {
        Intrinsics.checkNotNullParameter(backgroundColors, "backgroundColors");
        Intrinsics.checkNotNullParameter(backgroundPatterns, "backgroundPatterns");
        return new BackgroundSettingsUIState(backgroundColors, backgroundPatterns);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackgroundSettingsUIState)) {
            return false;
        }
        BackgroundSettingsUIState backgroundSettingsUIState = (BackgroundSettingsUIState) other;
        return Intrinsics.areEqual(this.backgroundColors, backgroundSettingsUIState.backgroundColors) && Intrinsics.areEqual(this.backgroundPatterns, backgroundSettingsUIState.backgroundPatterns);
    }

    public int hashCode() {
        return (this.backgroundColors.hashCode() * 31) + this.backgroundPatterns.hashCode();
    }

    public String toString() {
        return "BackgroundSettingsUIState(backgroundColors=" + this.backgroundColors + ", backgroundPatterns=" + this.backgroundPatterns + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        List<PageBackgroundColor> list = this.backgroundColors;
        dest.writeInt(list.size());
        Iterator<PageBackgroundColor> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        List<PageBackgroundPattern> list2 = this.backgroundPatterns;
        dest.writeInt(list2.size());
        Iterator<PageBackgroundPattern> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(dest, flags);
        }
    }

    public BackgroundSettingsUIState(List<PageBackgroundColor> backgroundColors, List<PageBackgroundPattern> backgroundPatterns) {
        Intrinsics.checkNotNullParameter(backgroundColors, "backgroundColors");
        Intrinsics.checkNotNullParameter(backgroundPatterns, "backgroundPatterns");
        this.backgroundColors = backgroundColors;
        this.backgroundPatterns = backgroundPatterns;
    }

    public /* synthetic */ BackgroundSettingsUIState(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final List<PageBackgroundColor> getBackgroundColors() {
        return this.backgroundColors;
    }

    public final List<PageBackgroundPattern> getBackgroundPatterns() {
        return this.backgroundPatterns;
    }

    public final boolean isBackgroundPatternListVisible() {
        return !this.backgroundPatterns.isEmpty();
    }

    public final boolean isBackgroundColorListVisible() {
        return !this.backgroundColors.isEmpty();
    }
}
