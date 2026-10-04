package com.myscript.nebo.common;

import kotlin.Metadata;

/* JADX INFO: compiled from: OngoingProgress.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/common/OngoingProgress;", "", "progress", "", "max", "<init>", "(II)V", "getProgress", "()I", "getMax", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class OngoingProgress {
    private final int max;
    private final int progress;

    public static /* synthetic */ OngoingProgress copy$default(OngoingProgress ongoingProgress, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = ongoingProgress.progress;
        }
        if ((i3 & 2) != 0) {
            i2 = ongoingProgress.max;
        }
        return ongoingProgress.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMax() {
        return this.max;
    }

    public final OngoingProgress copy(int progress, int max) {
        return new OngoingProgress(progress, max);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OngoingProgress)) {
            return false;
        }
        OngoingProgress ongoingProgress = (OngoingProgress) other;
        return this.progress == ongoingProgress.progress && this.max == ongoingProgress.max;
    }

    public int hashCode() {
        return (Integer.hashCode(this.progress) * 31) + Integer.hashCode(this.max);
    }

    public String toString() {
        return "OngoingProgress(progress=" + this.progress + ", max=" + this.max + ")";
    }

    public OngoingProgress(int i, int i2) {
        this.progress = i;
        this.max = i2;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getMax() {
        return this.max;
    }
}
