package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.10.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zaae extends RemoteCreator {
    private static final zaae zaa = new zaae();

    private zaae() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zaa(Context context, int i, int i2) throws RemoteCreator.RemoteCreatorException {
        zaae zaaeVar = zaa;
        try {
            zaac zaacVar = new zaac(1, i, i2, null);
            return (View) ObjectWrapper.unwrap(((zar) zaaeVar.getRemoteCreatorInstance(context)).zae(ObjectWrapper.wrap(context), zaacVar));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 42 + String.valueOf(i2).length());
            sb.append("Could not get button with size ");
            sb.append(i);
            sb.append(" and color ");
            sb.append(i2);
            throw new RemoteCreator.RemoteCreatorException(sb.toString(), e);
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof zar ? (zar) iInterfaceQueryLocalInterface : new zar(iBinder);
    }
}
