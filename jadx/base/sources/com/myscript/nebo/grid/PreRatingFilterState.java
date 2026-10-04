package com.myscript.nebo.grid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/grid/PreRatingFilterState;", "", "show", "", "analyticsOrigin", "", "<init>", "(ZLjava/lang/String;)V", "getShow", "()Z", "getAnalyticsOrigin", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class PreRatingFilterState {
    public static final int $stable = 0;
    private final String analyticsOrigin;
    private final boolean show;

    /* JADX WARN: Multi-variable type inference failed */
    public PreRatingFilterState() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PreRatingFilterState copy$default(PreRatingFilterState preRatingFilterState, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = preRatingFilterState.show;
        }
        if ((i & 2) != 0) {
            str = preRatingFilterState.analyticsOrigin;
        }
        return preRatingFilterState.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAnalyticsOrigin() {
        return this.analyticsOrigin;
    }

    public final PreRatingFilterState copy(boolean show, String analyticsOrigin) {
        Intrinsics.checkNotNullParameter(analyticsOrigin, "analyticsOrigin");
        return new PreRatingFilterState(show, analyticsOrigin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreRatingFilterState)) {
            return false;
        }
        PreRatingFilterState preRatingFilterState = (PreRatingFilterState) other;
        return this.show == preRatingFilterState.show && Intrinsics.areEqual(this.analyticsOrigin, preRatingFilterState.analyticsOrigin);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.show) * 31) + this.analyticsOrigin.hashCode();
    }

    public String toString() {
        return "PreRatingFilterState(show=" + this.show + ", analyticsOrigin=" + this.analyticsOrigin + ")";
    }

    public PreRatingFilterState(boolean z, String analyticsOrigin) {
        Intrinsics.checkNotNullParameter(analyticsOrigin, "analyticsOrigin");
        this.show = z;
        this.analyticsOrigin = analyticsOrigin;
    }

    public /* synthetic */ PreRatingFilterState(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str);
    }

    public final String getAnalyticsOrigin() {
        return this.analyticsOrigin;
    }

    public final boolean getShow() {
        return this.show;
    }
}
