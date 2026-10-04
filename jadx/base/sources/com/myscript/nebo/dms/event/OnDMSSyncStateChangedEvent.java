package com.myscript.nebo.dms.event;

import com.myscript.snt.dms.DMSSyncState;

/* JADX INFO: loaded from: classes7.dex */
public class OnDMSSyncStateChangedEvent {
    public int mNumberOfNotebookToSynchronize;
    public DMSSyncState mSyncState;
    public final boolean mUserAction;

    public OnDMSSyncStateChangedEvent(DMSSyncState dMSSyncState, int i, boolean z) {
        this.mSyncState = dMSSyncState;
        this.mNumberOfNotebookToSynchronize = i;
        this.mUserAction = z;
    }
}
