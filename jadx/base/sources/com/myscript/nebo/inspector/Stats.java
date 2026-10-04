package com.myscript.nebo.inspector;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NeboFilesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/inspector/Stats;", "", "collectionsCount", "", "notebooksCount", "pagesCount", "<init>", "(III)V", "getCollectionsCount", "()I", "getNotebooksCount", "getPagesCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Stats {
    private final int collectionsCount;
    private final int notebooksCount;
    private final int pagesCount;

    public Stats() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ Stats copy$default(Stats stats, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = stats.collectionsCount;
        }
        if ((i4 & 2) != 0) {
            i2 = stats.notebooksCount;
        }
        if ((i4 & 4) != 0) {
            i3 = stats.pagesCount;
        }
        return stats.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCollectionsCount() {
        return this.collectionsCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getNotebooksCount() {
        return this.notebooksCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPagesCount() {
        return this.pagesCount;
    }

    public final Stats copy(int collectionsCount, int notebooksCount, int pagesCount) {
        return new Stats(collectionsCount, notebooksCount, pagesCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stats)) {
            return false;
        }
        Stats stats = (Stats) other;
        return this.collectionsCount == stats.collectionsCount && this.notebooksCount == stats.notebooksCount && this.pagesCount == stats.pagesCount;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.collectionsCount) * 31) + Integer.hashCode(this.notebooksCount)) * 31) + Integer.hashCode(this.pagesCount);
    }

    public String toString() {
        return "Stats(collectionsCount=" + this.collectionsCount + ", notebooksCount=" + this.notebooksCount + ", pagesCount=" + this.pagesCount + ")";
    }

    public Stats(int i, int i2, int i3) {
        this.collectionsCount = i;
        this.notebooksCount = i2;
        this.pagesCount = i3;
    }

    public /* synthetic */ Stats(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public final int getCollectionsCount() {
        return this.collectionsCount;
    }

    public final int getNotebooksCount() {
        return this.notebooksCount;
    }

    public final int getPagesCount() {
        return this.pagesCount;
    }
}
