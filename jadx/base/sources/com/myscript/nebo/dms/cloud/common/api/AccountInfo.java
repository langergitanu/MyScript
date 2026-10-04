package com.myscript.nebo.dms.cloud.common.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccountInfo.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, m1599d2 = {"Lcom/myscript/nebo/dms/cloud/common/api/AccountInfo;", "", "email", "", "spaceAllocation", "", "spaceUsed", "<init>", "(Ljava/lang/String;JJ)V", "getEmail", "()Ljava/lang/String;", "getSpaceAllocation", "()J", "getSpaceUsed", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dms-cloud-common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class AccountInfo {
    private final String email;
    private final long spaceAllocation;
    private final long spaceUsed;

    public AccountInfo() {
        this(null, 0L, 0L, 7, null);
    }

    public static /* synthetic */ AccountInfo copy$default(AccountInfo accountInfo, String str, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accountInfo.email;
        }
        if ((i & 2) != 0) {
            j = accountInfo.spaceAllocation;
        }
        if ((i & 4) != 0) {
            j2 = accountInfo.spaceUsed;
        }
        return accountInfo.copy(str, j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSpaceAllocation() {
        return this.spaceAllocation;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSpaceUsed() {
        return this.spaceUsed;
    }

    public final AccountInfo copy(String email, long spaceAllocation, long spaceUsed) {
        return new AccountInfo(email, spaceAllocation, spaceUsed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountInfo)) {
            return false;
        }
        AccountInfo accountInfo = (AccountInfo) other;
        return Intrinsics.areEqual(this.email, accountInfo.email) && this.spaceAllocation == accountInfo.spaceAllocation && this.spaceUsed == accountInfo.spaceUsed;
    }

    public int hashCode() {
        String str = this.email;
        return ((((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.spaceAllocation)) * 31) + Long.hashCode(this.spaceUsed);
    }

    public String toString() {
        return "AccountInfo(email=" + this.email + ", spaceAllocation=" + this.spaceAllocation + ", spaceUsed=" + this.spaceUsed + ")";
    }

    public AccountInfo(String str, long j, long j2) {
        this.email = str;
        this.spaceAllocation = j;
        this.spaceUsed = j2;
    }

    public /* synthetic */ AccountInfo(String str, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? -1L : j, (i & 4) != 0 ? -1L : j2);
    }

    public final String getEmail() {
        return this.email;
    }

    public final long getSpaceAllocation() {
        return this.spaceAllocation;
    }

    public final long getSpaceUsed() {
        return this.spaceUsed;
    }
}
