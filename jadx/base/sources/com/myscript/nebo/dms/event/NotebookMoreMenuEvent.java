package com.myscript.nebo.dms.event;

import android.os.Bundle;
import com.myscript.snt.core.NotebookKey;

/* JADX INFO: loaded from: classes7.dex */
public class NotebookMoreMenuEvent {
    public Bundle menuState;
    public NotebookKey notebookKey;

    /* JADX INFO: renamed from: x */
    public final int f1361x;

    /* JADX INFO: renamed from: y */
    public final int f1362y;

    public NotebookMoreMenuEvent(NotebookKey notebookKey, Bundle bundle, int i, int i2) {
        this.notebookKey = notebookKey;
        this.menuState = bundle;
        this.f1361x = i;
        this.f1362y = i2;
    }
}
