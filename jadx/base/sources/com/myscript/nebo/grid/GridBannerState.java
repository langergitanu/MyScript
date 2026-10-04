package com.myscript.nebo.grid;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridBannerState;", "", "isVisible", "", NotificationCompat.CATEGORY_STATUS, "Lcom/myscript/nebo/grid/UserStatus;", "hasInternet", "remainingTrialDays", "", "renewalOfferRemainingHours", "<init>", "(ZLcom/myscript/nebo/grid/UserStatus;ZII)V", "()Z", "getStatus", "()Lcom/myscript/nebo/grid/UserStatus;", "getHasInternet", "getRemainingTrialDays", "()I", "getRenewalOfferRemainingHours", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class GridBannerState {
    public static final int $stable = 0;
    private final boolean hasInternet;
    private final boolean isVisible;
    private final int remainingTrialDays;
    private final int renewalOfferRemainingHours;
    private final UserStatus status;

    public GridBannerState() {
        this(false, null, false, 0, 0, 31, null);
    }

    public static /* synthetic */ GridBannerState copy$default(GridBannerState gridBannerState, boolean z, UserStatus userStatus, boolean z2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = gridBannerState.isVisible;
        }
        if ((i3 & 2) != 0) {
            userStatus = gridBannerState.status;
        }
        if ((i3 & 4) != 0) {
            z2 = gridBannerState.hasInternet;
        }
        if ((i3 & 8) != 0) {
            i = gridBannerState.remainingTrialDays;
        }
        if ((i3 & 16) != 0) {
            i2 = gridBannerState.renewalOfferRemainingHours;
        }
        int i4 = i2;
        boolean z3 = z2;
        return gridBannerState.copy(z, userStatus, z3, i, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UserStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasInternet() {
        return this.hasInternet;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getRemainingTrialDays() {
        return this.remainingTrialDays;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getRenewalOfferRemainingHours() {
        return this.renewalOfferRemainingHours;
    }

    public final GridBannerState copy(boolean isVisible, UserStatus status, boolean hasInternet, int remainingTrialDays, int renewalOfferRemainingHours) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new GridBannerState(isVisible, status, hasInternet, remainingTrialDays, renewalOfferRemainingHours);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GridBannerState)) {
            return false;
        }
        GridBannerState gridBannerState = (GridBannerState) other;
        return this.isVisible == gridBannerState.isVisible && this.status == gridBannerState.status && this.hasInternet == gridBannerState.hasInternet && this.remainingTrialDays == gridBannerState.remainingTrialDays && this.renewalOfferRemainingHours == gridBannerState.renewalOfferRemainingHours;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.isVisible) * 31) + this.status.hashCode()) * 31) + Boolean.hashCode(this.hasInternet)) * 31) + Integer.hashCode(this.remainingTrialDays)) * 31) + Integer.hashCode(this.renewalOfferRemainingHours);
    }

    public String toString() {
        return "GridBannerState(isVisible=" + this.isVisible + ", status=" + this.status + ", hasInternet=" + this.hasInternet + ", remainingTrialDays=" + this.remainingTrialDays + ", renewalOfferRemainingHours=" + this.renewalOfferRemainingHours + ")";
    }

    public GridBannerState(boolean z, UserStatus status, boolean z2, int i, int i2) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.isVisible = z;
        this.status = status;
        this.hasInternet = z2;
        this.remainingTrialDays = i;
        this.renewalOfferRemainingHours = i2;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public /* synthetic */ GridBannerState(boolean z, UserStatus userStatus, boolean z2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? UserStatus.Premium : userStatus, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
    }

    public final UserStatus getStatus() {
        return this.status;
    }

    public final boolean getHasInternet() {
        return this.hasInternet;
    }

    public final int getRemainingTrialDays() {
        return this.remainingTrialDays;
    }

    public final int getRenewalOfferRemainingHours() {
        return this.renewalOfferRemainingHours;
    }
}
