package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p015a.BinderC4575b;
import com.google.android.p015a.C4574a;
import com.google.android.p015a.C4576c;

/* JADX INFO: loaded from: classes5.dex */
public interface IGetInstallReferrerService extends IInterface {

    public static abstract class Stub extends BinderC4575b implements IGetInstallReferrerService {

        public static class Proxy extends C4574a implements IGetInstallReferrerService {
            Proxy(IBinder iBinder) {
                super(iBinder);
            }

            @Override // com.google.android.finsky.externalreferrer.IGetInstallReferrerService
            /* JADX INFO: renamed from: c */
            public final Bundle mo585c(Bundle bundle) throws RemoteException {
                Parcel parcelM545a = m545a();
                C4576c.m549b(parcelM545a, bundle);
                Parcel parcelM546b = m546b(parcelM545a);
                Bundle bundle2 = (Bundle) C4576c.m548a(parcelM546b, Bundle.CREATOR);
                parcelM546b.recycle();
                return bundle2;
            }
        }

        /* JADX INFO: renamed from: b */
        public static IGetInstallReferrerService m586b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return iInterfaceQueryLocalInterface instanceof IGetInstallReferrerService ? (IGetInstallReferrerService) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.p015a.BinderC4575b
        /* JADX INFO: renamed from: a */
        protected final boolean mo547a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            Bundle bundleC = mo585c((Bundle) C4576c.m548a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            C4576c.m550c(parcel2, bundleC);
            return true;
        }
    }

    /* JADX INFO: renamed from: c */
    Bundle mo585c(Bundle bundle) throws RemoteException;
}
