package com.google.android.gms.internal.measurement;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.revenuecat.purchases.common.events.BackendEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrx extends zzsy {
    private final Context zza;
    private final zzsx zzb;
    private final Object zzc = new Object();

    @Nullable
    private String zzd;

    /* synthetic */ zzrx(zzrw zzrwVar, byte[] bArr) {
        this.zzb = new zzsd(zzrwVar.zzc());
        this.zza = zzrwVar.zzb();
    }

    public static zzrw zza(Context context) {
        return new zzrw(context, null);
    }

    private final boolean zzh(Uri uri) {
        return (TextUtils.isEmpty(uri.getAuthority()) || this.zza.getPackageName().equals(uri.getAuthority())) ? false : true;
    }

    private static final void zzi() throws zzsg {
        throw new zzsg("Android backend cannot perform remote operations without a remote backend");
    }

    @Override // com.google.android.gms.internal.measurement.zzsy
    protected final zzsx zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final String zzc() {
        return BackendEvent.Workflows.Context.WORKFLOW_CONTEXT_PLATFORM;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final InputStream zzd(Uri uri) throws IOException {
        if (!zzh(uri)) {
            return zzsl.zzb(zzsc.zza(zzf(uri)));
        }
        zzi();
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final boolean zze(Uri uri) throws IOException {
        if (!zzh(uri)) {
            return zzsc.zza(zzf(uri)).exists();
        }
        zzi();
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzsy
    protected final Uri zzf(Uri uri) throws IOException {
        if (zzh(uri)) {
            throw new zzsi("Operation across authorities is not allowed.");
        }
        File fileZzg = zzg(uri);
        zzsb zzsbVar = new zzsb(null);
        zzsbVar.zza(fileZzg);
        return zzsbVar.zzb();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    @Override // com.google.android.gms.internal.measurement.zzsx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final File zzg(Uri uri) throws IOException {
        byte b;
        File filesDir;
        String str;
        Account account;
        if (zzh(uri)) {
            throw new IOException("operation is not permitted in other authorities.");
        }
        Context context = this.zza;
        if (!uri.getScheme().equals(BackendEvent.Workflows.Context.WORKFLOW_CONTEXT_PLATFORM)) {
            throw new zzsi("Scheme must be 'android'");
        }
        if (uri.getPathSegments().isEmpty()) {
            throw new zzsi(String.format("Path must start with a valid logical location: %s", uri));
        }
        if (!TextUtils.isEmpty(uri.getQuery())) {
            throw new zzsi("Did not expect uri to have query");
        }
        ArrayList arrayList = new ArrayList(uri.getPathSegments());
        String str2 = (String) arrayList.get(0);
        switch (str2.hashCode()) {
            case -1820761141:
                b = !str2.equals("external") ? (byte) -1 : (byte) 5;
                break;
            case 94416770:
                if (str2.equals("cache")) {
                    b = 3;
                    break;
                }
                break;
            case 97434231:
                if (str2.equals("files")) {
                    b = 2;
                    break;
                }
                break;
            case 835260319:
                if (str2.equals("managed")) {
                    b = 4;
                    break;
                }
                break;
            case 988548496:
                if (str2.equals("directboot-cache")) {
                    b = 1;
                    break;
                }
                break;
            case 991565957:
                if (str2.equals("directboot-files")) {
                    b = 0;
                    break;
                }
                break;
        }
        if (b == 0) {
            filesDir = context.createDeviceProtectedStorageContext().getFilesDir();
        } else if (b == 1) {
            filesDir = context.createDeviceProtectedStorageContext().getCacheDir();
        } else if (b == 2) {
            filesDir = zzry.zza(context);
        } else if (b == 3) {
            filesDir = context.getCacheDir();
        } else if (b == 4) {
            File file = new File(zzry.zza(context), "managed");
            if (arrayList.size() >= 3) {
                try {
                    String str3 = (String) arrayList.get(2);
                    Account account2 = zzrv.zza;
                    if ("shared".equals(str3)) {
                        account = zzrv.zza;
                    } else {
                        int iIndexOf = str3.indexOf(58);
                        zzsq.zza(iIndexOf >= 0, "Malformed account", new Object[0]);
                        account = new Account(str3.substring(iIndexOf + 1), str3.substring(0, iIndexOf));
                    }
                    if (!zzrv.zza.equals(account)) {
                        throw new zzsi("AccountManager cannot be null");
                    }
                } catch (IllegalArgumentException e) {
                    throw new zzsi(e);
                }
            }
            filesDir = file;
        } else {
            if (b != 5) {
                throw new zzsi(String.format("Path must start with a valid logical location: %s", uri));
            }
            filesDir = context.getExternalFilesDir(null);
        }
        File file2 = new File(filesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
        if (!zzky.zzc(context)) {
            synchronized (this.zzc) {
                if (this.zzd == null) {
                    this.zzd = zzry.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                }
                str = this.zzd;
            }
            if (!file2.getAbsolutePath().startsWith(str)) {
                throw new zzsg("Cannot access credential-protected data from direct boot");
            }
        }
        return file2;
    }
}
