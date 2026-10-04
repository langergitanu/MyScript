package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.10.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zah extends zad {
    public final ListenerHolder.ListenerKey zab;

    public zah(ListenerHolder.ListenerKey listenerKey, TaskCompletionSource taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zab = listenerKey;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zaa(zabk zabkVar) {
        zacc zaccVar = (zacc) zabkVar.zag().get(this.zab);
        if (zaccVar == null) {
            return null;
        }
        return zaccVar.zaa.getRequiredFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zab(zabk zabkVar) {
        zacc zaccVar = (zacc) zabkVar.zag().get(this.zab);
        return zaccVar != null && zaccVar.zaa.zaa();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final int zac(zabk zabkVar) {
        zacc zaccVar = (zacc) zabkVar.zag().get(this.zab);
        if (zaccVar != null) {
            return zaccVar.zaa.zab();
        }
        return -1;
    }

    @Override // com.google.android.gms.common.api.internal.zad, com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void zaf(zaaa zaaaVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void zah(zabk zabkVar) throws RemoteException {
        zacc zaccVar = (zacc) zabkVar.zag().remove(this.zab);
        if (zaccVar == null) {
            this.zaa.trySetResult(false);
            return;
        }
        zaccVar.zab.unregisterListener(zabkVar.zaf(), this.zaa);
        zaccVar.zaa.clearListener();
    }
}
