package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.10.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zacq extends com.google.android.gms.internal.base.zar {
    final /* synthetic */ zacr zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zacq(zacr zacrVar, Looper looper) {
        super(looper);
        Objects.requireNonNull(zacrVar);
        this.zaa = zacrVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            PendingResult pendingResult = (PendingResult) message.obj;
            zacr zacrVar = this.zaa;
            synchronized (zacrVar.zaf()) {
                zacr zacrVar2 = (zacr) Preconditions.checkNotNull(zacrVar.zae());
                if (pendingResult == null) {
                    zacrVar2.zac(new Status(13, "Transform returned null"));
                } else if (pendingResult instanceof zach) {
                    zacrVar2.zac(((zach) pendingResult).zaa());
                } else {
                    zacrVar2.zaa(pendingResult);
                }
            }
            return;
        }
        if (i == 1) {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String message2 = runtimeException.getMessage();
            String.valueOf(message2);
            Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: ".concat(String.valueOf(message2)));
            throw runtimeException;
        }
        int i2 = message.what;
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 59);
        sb.append("TransformationResultHandler received unknown message type: ");
        sb.append(i2);
        Log.e("TransformedResultImpl", sb.toString());
    }
}
