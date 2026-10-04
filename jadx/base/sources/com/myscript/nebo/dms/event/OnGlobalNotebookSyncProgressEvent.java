package com.myscript.nebo.dms.event;

import kotlin.Metadata;

/* JADX INFO: compiled from: OnGlobalNotebookSyncProgressEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/dms/event/OnGlobalNotebookSyncProgressEvent;", "", "amountDone", "", "totalAmount", "numberOfNotebookToSynchronize", "<init>", "(III)V", "getAmountDone", "()I", "getTotalAmount", "getNumberOfNotebookToSynchronize", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class OnGlobalNotebookSyncProgressEvent {
    public static final int $stable = 0;
    private final int amountDone;
    private final int numberOfNotebookToSynchronize;
    private final int totalAmount;

    public static /* synthetic */ OnGlobalNotebookSyncProgressEvent copy$default(OnGlobalNotebookSyncProgressEvent onGlobalNotebookSyncProgressEvent, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = onGlobalNotebookSyncProgressEvent.amountDone;
        }
        if ((i4 & 2) != 0) {
            i2 = onGlobalNotebookSyncProgressEvent.totalAmount;
        }
        if ((i4 & 4) != 0) {
            i3 = onGlobalNotebookSyncProgressEvent.numberOfNotebookToSynchronize;
        }
        return onGlobalNotebookSyncProgressEvent.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAmountDone() {
        return this.amountDone;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTotalAmount() {
        return this.totalAmount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getNumberOfNotebookToSynchronize() {
        return this.numberOfNotebookToSynchronize;
    }

    public final OnGlobalNotebookSyncProgressEvent copy(int amountDone, int totalAmount, int numberOfNotebookToSynchronize) {
        return new OnGlobalNotebookSyncProgressEvent(amountDone, totalAmount, numberOfNotebookToSynchronize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnGlobalNotebookSyncProgressEvent)) {
            return false;
        }
        OnGlobalNotebookSyncProgressEvent onGlobalNotebookSyncProgressEvent = (OnGlobalNotebookSyncProgressEvent) other;
        return this.amountDone == onGlobalNotebookSyncProgressEvent.amountDone && this.totalAmount == onGlobalNotebookSyncProgressEvent.totalAmount && this.numberOfNotebookToSynchronize == onGlobalNotebookSyncProgressEvent.numberOfNotebookToSynchronize;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.amountDone) * 31) + Integer.hashCode(this.totalAmount)) * 31) + Integer.hashCode(this.numberOfNotebookToSynchronize);
    }

    public String toString() {
        return "OnGlobalNotebookSyncProgressEvent(amountDone=" + this.amountDone + ", totalAmount=" + this.totalAmount + ", numberOfNotebookToSynchronize=" + this.numberOfNotebookToSynchronize + ")";
    }

    public OnGlobalNotebookSyncProgressEvent(int i, int i2, int i3) {
        this.amountDone = i;
        this.totalAmount = i2;
        this.numberOfNotebookToSynchronize = i3;
    }

    public final int getAmountDone() {
        return this.amountDone;
    }

    public final int getTotalAmount() {
        return this.totalAmount;
    }

    public final int getNumberOfNotebookToSynchronize() {
        return this.numberOfNotebookToSynchronize;
    }
}
