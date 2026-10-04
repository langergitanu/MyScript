package com.myscript.nebo.editing.search;

import com.myscript.atk.core.Extent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchPageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/editing/search/SearchHitNavState;", "", "currentHitNumber", "", "hitCount", "selectedHitExtent", "Lcom/myscript/atk/core/Extent;", "<init>", "(IILcom/myscript/atk/core/Extent;)V", "getCurrentHitNumber", "()I", "getHitCount", "getSelectedHitExtent", "()Lcom/myscript/atk/core/Extent;", "isVisible", "", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SearchHitNavState {
    public static final int $stable = 8;
    private final int currentHitNumber;
    private final int hitCount;
    private final boolean isVisible;
    private final Extent selectedHitExtent;

    public SearchHitNavState() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ SearchHitNavState copy$default(SearchHitNavState searchHitNavState, int i, int i2, Extent extent, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = searchHitNavState.currentHitNumber;
        }
        if ((i3 & 2) != 0) {
            i2 = searchHitNavState.hitCount;
        }
        if ((i3 & 4) != 0) {
            extent = searchHitNavState.selectedHitExtent;
        }
        return searchHitNavState.copy(i, i2, extent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCurrentHitNumber() {
        return this.currentHitNumber;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHitCount() {
        return this.hitCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Extent getSelectedHitExtent() {
        return this.selectedHitExtent;
    }

    public final SearchHitNavState copy(int currentHitNumber, int hitCount, Extent selectedHitExtent) {
        return new SearchHitNavState(currentHitNumber, hitCount, selectedHitExtent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchHitNavState)) {
            return false;
        }
        SearchHitNavState searchHitNavState = (SearchHitNavState) other;
        return this.currentHitNumber == searchHitNavState.currentHitNumber && this.hitCount == searchHitNavState.hitCount && Intrinsics.areEqual(this.selectedHitExtent, searchHitNavState.selectedHitExtent);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.currentHitNumber) * 31) + Integer.hashCode(this.hitCount)) * 31;
        Extent extent = this.selectedHitExtent;
        return iHashCode + (extent == null ? 0 : extent.hashCode());
    }

    public String toString() {
        return "SearchHitNavState(currentHitNumber=" + this.currentHitNumber + ", hitCount=" + this.hitCount + ", selectedHitExtent=" + this.selectedHitExtent + ")";
    }

    public SearchHitNavState(int i, int i2, Extent extent) {
        this.currentHitNumber = i;
        this.hitCount = i2;
        this.selectedHitExtent = extent;
        this.isVisible = i2 > 1;
    }

    public /* synthetic */ SearchHitNavState(int i, int i2, Extent extent, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : extent);
    }

    public final int getCurrentHitNumber() {
        return this.currentHitNumber;
    }

    public final int getHitCount() {
        return this.hitCount;
    }

    public final Extent getSelectedHitExtent() {
        return this.selectedHitExtent;
    }

    /* JADX INFO: renamed from: isVisible, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }
}
