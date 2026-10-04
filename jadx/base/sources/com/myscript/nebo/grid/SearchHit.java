package com.myscript.nebo.grid;

import com.myscript.snt.core.PageKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/grid/SearchHit;", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "hitCount", "", "<init>", "(Lcom/myscript/snt/core/PageKey;I)V", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "getHitCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SearchHit {
    public static final int $stable = 8;
    private final int hitCount;
    private final PageKey pageKey;

    public static /* synthetic */ SearchHit copy$default(SearchHit searchHit, PageKey pageKey, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            pageKey = searchHit.pageKey;
        }
        if ((i2 & 2) != 0) {
            i = searchHit.hitCount;
        }
        return searchHit.copy(pageKey, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PageKey getPageKey() {
        return this.pageKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHitCount() {
        return this.hitCount;
    }

    public final SearchHit copy(PageKey pageKey, int hitCount) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        return new SearchHit(pageKey, hitCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchHit)) {
            return false;
        }
        SearchHit searchHit = (SearchHit) other;
        return Intrinsics.areEqual(this.pageKey, searchHit.pageKey) && this.hitCount == searchHit.hitCount;
    }

    public int hashCode() {
        return (this.pageKey.hashCode() * 31) + Integer.hashCode(this.hitCount);
    }

    public String toString() {
        return "SearchHit(pageKey=" + this.pageKey + ", hitCount=" + this.hitCount + ")";
    }

    public SearchHit(PageKey pageKey, int i) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        this.pageKey = pageKey;
        this.hitCount = i;
    }

    public final int getHitCount() {
        return this.hitCount;
    }

    public final PageKey getPageKey() {
        return this.pageKey;
    }
}
