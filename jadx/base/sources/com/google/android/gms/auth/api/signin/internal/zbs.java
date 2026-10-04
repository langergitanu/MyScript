package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.5.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zbs extends com.google.android.gms.internal.p058authapi.zba implements IInterface {
    zbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void zbc(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p058authapi.zbc.zbc(parcelZba, zbrVar);
        com.google.android.gms.internal.p058authapi.zbc.zbb(parcelZba, googleSignInOptions);
        zbb(101, parcelZba);
    }

    public final void zbd(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p058authapi.zbc.zbc(parcelZba, zbrVar);
        com.google.android.gms.internal.p058authapi.zbc.zbb(parcelZba, googleSignInOptions);
        zbb(102, parcelZba);
    }

    public final void zbe(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p058authapi.zbc.zbc(parcelZba, zbrVar);
        com.google.android.gms.internal.p058authapi.zbc.zbb(parcelZba, googleSignInOptions);
        zbb(HttpStatusCodesKt.HTTP_EARLY_HINTS, parcelZba);
    }
}
