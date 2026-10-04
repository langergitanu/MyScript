package com.myscript.nebo.grid;

import com.myscript.nebo.C6079R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayMode.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00102\u00020\u0001:\u0003\u000e\u000f\u0010B\u0013\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\u0000*\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u0011\u0012¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/grid/DisplayMode;", "", "iconResource", "", "<init>", "(I)V", "getIconResource", "()I", "name", "", "getName", "()Ljava/lang/String;", "toDisplayMode", "defaultDisplayMode", "Grid", "List", "Companion", "Lcom/myscript/nebo/grid/DisplayMode$Grid;", "Lcom/myscript/nebo/grid/DisplayMode$List;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class DisplayMode {
    public static final int $stable = 0;
    public static final String PREF_FOLDER_DISPLAY_MODE_KEY = "PREF_FOLDER_DISPLAY_MODE_KEY";
    private final int iconResource;

    public /* synthetic */ DisplayMode(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    /* JADX INFO: compiled from: DisplayMode.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/DisplayMode$Grid;", "Lcom/myscript/nebo/grid/DisplayMode;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Grid extends DisplayMode {
        public static final int $stable = 0;
        public static final Grid INSTANCE = new Grid();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Grid)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1951989431;
        }

        public String toString() {
            return "Grid";
        }

        private Grid() {
            super(C6079R.drawable.ic_list_view, null);
        }
    }

    private DisplayMode(int i) {
        this.iconResource = i;
    }

    public /* synthetic */ DisplayMode(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, null);
    }

    public final int getIconResource() {
        return this.iconResource;
    }

    /* JADX INFO: compiled from: DisplayMode.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/DisplayMode$List;", "Lcom/myscript/nebo/grid/DisplayMode;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class List extends DisplayMode {
        public static final int $stable = 0;
        public static final List INSTANCE = new List();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof List)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1952130063;
        }

        public String toString() {
            return "List";
        }

        private List() {
            super(C6079R.drawable.ic_grid_view, null);
        }
    }

    public final String getName() {
        if (Intrinsics.areEqual(this, Grid.INSTANCE)) {
            return "grid";
        }
        if (Intrinsics.areEqual(this, List.INSTANCE)) {
            return "list";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ DisplayMode toDisplayMode$default(DisplayMode displayMode, String str, DisplayMode displayMode2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toDisplayMode");
        }
        if ((i & 1) != 0) {
            displayMode2 = Grid.INSTANCE;
        }
        return displayMode.toDisplayMode(str, displayMode2);
    }

    public final DisplayMode toDisplayMode(String str, DisplayMode defaultDisplayMode) {
        Intrinsics.checkNotNullParameter(defaultDisplayMode, "defaultDisplayMode");
        return Intrinsics.areEqual(str, Grid.INSTANCE.getName()) ? Grid.INSTANCE : Intrinsics.areEqual(str, List.INSTANCE.getName()) ? List.INSTANCE : defaultDisplayMode;
    }
}
