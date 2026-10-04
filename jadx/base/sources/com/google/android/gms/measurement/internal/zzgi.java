package com.google.android.gms.measurement.internal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgi extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private final long zzh;
    private List zzi;
    private String zzj;
    private final String zzk;
    private int zzl;
    private String zzm;
    private String zzn;
    private long zzo;
    private String zzp;

    zzgi(zzic zzicVar, long j, long j2, String str) {
        super(zzicVar);
        this.zzo = 0L;
        this.zzp = null;
        this.zzg = j;
        this.zzh = j2;
        this.zzk = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|2|(1:4)(19:85|6|(1:10)(2:11|(1:13))|87|14|(4:16|(1:18)(1:20)|81|21)|26|(2:28|(2:30|(2:32|(2:34|(2:36|(2:38|(1:40)(1:41))(1:42))(1:43))(1:44))(1:45))(1:46))(1:47)|48|83|49|(1:51)(1:52)|53|(1:55)(1:56)|57|(1:59)|63|(2:66|(1:68)(4:69|(3:72|(1:90)(1:91)|70)|89|75))(1:75)|(2:77|78)(2:79|80))|5|26|(0)(0)|48|83|49|(0)(0)|53|(0)(0)|57|(0)|63|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a3, code lost:
    
        r11.zzu.zzaW().zzb().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r1), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0176 A[Catch: IllegalStateException -> 0x01a2, TryCatch #1 {IllegalStateException -> 0x01a2, blocks: (B:49:0x016d, B:53:0x0184, B:57:0x018c, B:59:0x0190, B:52:0x0176), top: B:83:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0190 A[Catch: IllegalStateException -> 0x01a2, TRY_LEAVE, TryCatch #1 {IllegalStateException -> 0x01a2, blocks: (B:49:0x016d, B:53:0x0184, B:57:0x018c, B:59:0x0190, B:52:0x0176), top: B:83:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020b  */
    @Override // com.google.android.gms.measurement.internal.zzg
    @EnsuresNonNull({RemoteConfigConstants.RequestFieldKey.APP_ID, "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzf() {
        String str;
        String string;
        int iZzC;
        List listZzs;
        String strZza;
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzk().zzc("sdkVersion bundled with app, dynamiteVersion", Long.valueOf(this.zzh), Long.valueOf(this.zzg));
        String packageName = zzicVar.zzaZ().getPackageName();
        PackageManager packageManager = zzicVar.zzaZ().getPackageManager();
        String str2 = "";
        int i = Integer.MIN_VALUE;
        String str3 = "Unknown";
        String installerPackageName = "unknown";
        if (packageManager != null) {
            try {
                installerPackageName = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                this.zzu.zzaW().zzb().zzb("Error retrieving app installer package name. appId", zzgu.zzl(packageName));
            }
            if (installerPackageName == null) {
                installerPackageName = "manual_install";
            } else if ("com.android.vending".equals(installerPackageName)) {
                installerPackageName = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(this.zzu.zzaZ().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                    try {
                        str3 = packageInfo.versionName;
                        i = packageInfo.versionCode;
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str = str3;
                        str3 = string;
                        this.zzu.zzaW().zzb().zzc("Error retrieving package info. appId, appName", zzgu.zzl(packageName), str3);
                        string = str3;
                        str3 = str;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused3) {
                str = "Unknown";
            }
            this.zza = packageName;
            this.zzd = installerPackageName;
            this.zzb = str3;
            this.zzc = i;
            this.zze = string;
            this.zzf = 0L;
            zzic zzicVar2 = this.zzu;
            iZzC = zzicVar2.zzC();
            if (iZzC != 0) {
                this.zzu.zzaW().zzk().zza("App measurement collection enabled");
            } else if (iZzC == 1) {
                this.zzu.zzaW().zzi().zza("App measurement deactivated via the manifest");
            } else if (iZzC == 3) {
                this.zzu.zzaW().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
            } else if (iZzC == 4) {
                this.zzu.zzaW().zzi().zza("App measurement disabled via the manifest");
            } else if (iZzC == 6) {
                this.zzu.zzaW().zzh().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
            } else if (iZzC == 7) {
                this.zzu.zzaW().zzi().zza("App measurement disabled via the global data collection setting");
            } else if (iZzC != 8) {
                zzic zzicVar3 = this.zzu;
                zzicVar3.zzaW().zzi().zza("App measurement disabled");
                zzicVar3.zzaW().zzc().zza("Invalid scion state in identity");
            } else {
                this.zzu.zzaW().zzi().zza("App measurement disabled due to denied storage consent");
            }
            this.zzm = "";
            zzic zzicVar4 = this.zzu;
            zzicVar4.zzaV();
            strZza = this.zzk;
            if (!TextUtils.isEmpty(strZza)) {
                strZza = zzlt.zza(zzicVar4.zzaZ(), "google_app_id", zzicVar2.zzq());
            }
            if (TextUtils.isEmpty(strZza)) {
                str2 = strZza;
            }
            this.zzm = str2;
            if (iZzC == 0) {
                zzicVar4.zzaW().zzk().zzc("App measurement enabled for app package, google app id", this.zza, this.zzm);
            }
            this.zzi = null;
            zzic zzicVar5 = this.zzu;
            zzicVar5.zzaV();
            listZzs = zzicVar5.zzc().zzs("analytics.safelisted_events");
            if (listZzs == null) {
                this.zzi = listZzs;
            } else if (listZzs.isEmpty()) {
                zzicVar5.zzaW().zzh().zza("Safelisted event list is empty. Ignoring");
            } else {
                Iterator it = listZzs.iterator();
                while (it.hasNext()) {
                    if (!zzicVar5.zzk().zzl("safelisted event", (String) it.next())) {
                        break;
                    }
                }
                this.zzi = listZzs;
            }
            if (packageManager == null) {
                this.zzl = InstantApps.isInstantApp(zzicVar5.zzaZ()) ? 1 : 0;
                return;
            } else {
                this.zzl = 0;
                return;
            }
        }
        zzicVar.zzaW().zzb().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzgu.zzl(packageName));
        string = "Unknown";
        this.zza = packageName;
        this.zzd = installerPackageName;
        this.zzb = str3;
        this.zzc = i;
        this.zze = string;
        this.zzf = 0L;
        zzic zzicVar22 = this.zzu;
        iZzC = zzicVar22.zzC();
        if (iZzC != 0) {
        }
        this.zzm = "";
        zzic zzicVar42 = this.zzu;
        zzicVar42.zzaV();
        strZza = this.zzk;
        if (!TextUtils.isEmpty(strZza)) {
        }
        if (TextUtils.isEmpty(strZza)) {
        }
        this.zzm = str2;
        if (iZzC == 0) {
        }
        this.zzi = null;
        zzic zzicVar52 = this.zzu;
        zzicVar52.zzaV();
        listZzs = zzicVar52.zzc().zzs("analytics.safelisted_events");
        if (listZzs == null) {
        }
        if (packageManager == null) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v0 com.google.android.gms.measurement.internal.zzr, still in use, count: 4, list:
          (r2v0 com.google.android.gms.measurement.internal.zzr) from 0x0150: MOVE (r21v1 com.google.android.gms.measurement.internal.zzr) = (r2v0 com.google.android.gms.measurement.internal.zzr)
          (r2v0 com.google.android.gms.measurement.internal.zzr) from 0x017b: MOVE (r21v2 com.google.android.gms.measurement.internal.zzr) = (r2v0 com.google.android.gms.measurement.internal.zzr)
          (r2v0 com.google.android.gms.measurement.internal.zzr) from 0x0155: MOVE (r21v3 com.google.android.gms.measurement.internal.zzr) = (r2v0 com.google.android.gms.measurement.internal.zzr)
          (r2v0 com.google.android.gms.measurement.internal.zzr) from 0x00fd: MOVE (r21v6 com.google.android.gms.measurement.internal.zzr) = (r2v0 com.google.android.gms.measurement.internal.zzr)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    final com.google.android.gms.measurement.internal.zzr zzh(java.lang.String r45) {
        /*
            Method dump skipped, instruction units count: 894
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgi.zzh(java.lang.String):com.google.android.gms.measurement.internal.zzr");
    }

    final void zzi() {
        String str;
        zzg();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzicVar.zzk().zzf().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            zzicVar.zzaW().zzj().zza("Analytics Storage consent is not granted");
            str = null;
        }
        zzicVar.zzaW().zzj().zza(String.format("Resetting session stitching token to %s", str == null ? AbstractJsonLexerKt.NULL : "not null"));
        this.zzn = str;
        this.zzo = zzicVar.zzba().currentTimeMillis();
    }

    final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    final String zzk() {
        zzg();
        zzb();
        Preconditions.checkNotNull(this.zzm);
        return this.zzm;
    }

    final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    final int zzm() {
        zzb();
        return this.zzc;
    }

    final long zzn() {
        return this.zzh;
    }

    final int zzo() {
        zzb();
        return this.zzl;
    }

    final List zzp() {
        return this.zzi;
    }

    final boolean zzq(String str) {
        String str2 = this.zzp;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzp = str;
        return z;
    }
}
