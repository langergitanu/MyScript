package com.myscript.nebo.settings;

import kotlin.Metadata;

/* JADX INFO: compiled from: AccountSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/settings/AccountFreemiumDisplayState;", "", "titleRes", "", "summaryRes", "isPurchased", "", "<init>", "(IIZ)V", "getTitleRes", "()I", "getSummaryRes", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class AccountFreemiumDisplayState {
    public static final int $stable = 0;
    private final boolean isPurchased;
    private final int summaryRes;
    private final int titleRes;

    public static /* synthetic */ AccountFreemiumDisplayState copy$default(AccountFreemiumDisplayState accountFreemiumDisplayState, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = accountFreemiumDisplayState.titleRes;
        }
        if ((i3 & 2) != 0) {
            i2 = accountFreemiumDisplayState.summaryRes;
        }
        if ((i3 & 4) != 0) {
            z = accountFreemiumDisplayState.isPurchased;
        }
        return accountFreemiumDisplayState.copy(i, i2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTitleRes() {
        return this.titleRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSummaryRes() {
        return this.summaryRes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsPurchased() {
        return this.isPurchased;
    }

    public final AccountFreemiumDisplayState copy(int titleRes, int summaryRes, boolean isPurchased) {
        return new AccountFreemiumDisplayState(titleRes, summaryRes, isPurchased);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountFreemiumDisplayState)) {
            return false;
        }
        AccountFreemiumDisplayState accountFreemiumDisplayState = (AccountFreemiumDisplayState) other;
        return this.titleRes == accountFreemiumDisplayState.titleRes && this.summaryRes == accountFreemiumDisplayState.summaryRes && this.isPurchased == accountFreemiumDisplayState.isPurchased;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.titleRes) * 31) + Integer.hashCode(this.summaryRes)) * 31) + Boolean.hashCode(this.isPurchased);
    }

    public String toString() {
        return "AccountFreemiumDisplayState(titleRes=" + this.titleRes + ", summaryRes=" + this.summaryRes + ", isPurchased=" + this.isPurchased + ")";
    }

    public AccountFreemiumDisplayState(int i, int i2, boolean z) {
        this.titleRes = i;
        this.summaryRes = i2;
        this.isPurchased = z;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final int getSummaryRes() {
        return this.summaryRes;
    }

    public final boolean isPurchased() {
        return this.isPurchased;
    }
}
