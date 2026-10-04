package com.google.android.p015a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: com.google.android.a.a */
/* JADX INFO: compiled from: BaseProxy.java */
/* JADX INFO: loaded from: classes5.dex */
public class C4574a implements IInterface {

    /* JADX INFO: renamed from: a */
    private final IBinder f847a;

    /* JADX INFO: renamed from: b */
    private final String f848b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    protected C4574a(IBinder iBinder) {
        this.f847a = iBinder;
    }

    /* JADX INFO: renamed from: a */
    protected final Parcel m545a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f848b);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f847a;
    }

    /* JADX INFO: renamed from: b */
    protected final Parcel m546b(Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f847a.transact(1, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }
}
