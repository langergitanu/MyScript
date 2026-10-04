package com.survicate.surveys.utils;

import kotlin.Metadata;

/* JADX INFO: compiled from: AppStateProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/utils/AppState;", "", "isNetworkAvailable", "", "isInForeground", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class AppState {
    private final boolean isInForeground;
    private final boolean isNetworkAvailable;

    public static /* synthetic */ AppState copy$default(AppState appState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = appState.isNetworkAvailable;
        }
        if ((i & 2) != 0) {
            z2 = appState.isInForeground;
        }
        return appState.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsNetworkAvailable() {
        return this.isNetworkAvailable;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsInForeground() {
        return this.isInForeground;
    }

    public final AppState copy(boolean isNetworkAvailable, boolean isInForeground) {
        return new AppState(isNetworkAvailable, isInForeground);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppState)) {
            return false;
        }
        AppState appState = (AppState) other;
        return this.isNetworkAvailable == appState.isNetworkAvailable && this.isInForeground == appState.isInForeground;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isNetworkAvailable) * 31) + Boolean.hashCode(this.isInForeground);
    }

    public String toString() {
        return "AppState(isNetworkAvailable=" + this.isNetworkAvailable + ", isInForeground=" + this.isInForeground + ')';
    }

    public AppState(boolean z, boolean z2) {
        this.isNetworkAvailable = z;
        this.isInForeground = z2;
    }

    public final boolean isNetworkAvailable() {
        return this.isNetworkAvailable;
    }

    public final boolean isInForeground() {
        return this.isInForeground;
    }
}
