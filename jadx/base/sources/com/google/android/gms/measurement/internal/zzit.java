package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzair;
import com.revenuecat.purchases.common.events.BackendEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzit implements Callable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjd zzc;

    zzit(zzjd zzjdVar, zzbh zzbhVar, String str) {
        this.zza = zzbhVar;
        this.zzb = str;
        Objects.requireNonNull(zzjdVar);
        this.zzc = zzjdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlp zzlpVar;
        zzh zzhVarZzu;
        byte[] bArr;
        zzpg zzpgVar;
        zzpn zzpnVar;
        zzpg zzpgVar2;
        com.google.android.gms.internal.measurement.zzhz zzhzVar;
        zzh zzhVar;
        zzic zzicVar;
        com.google.android.gms.internal.measurement.zzic zzicVar2;
        Bundle bundle;
        String str;
        boolean z;
        Object obj;
        long j;
        zzbd zzbdVarZza;
        byte[] bArr2;
        zzjd zzjdVar = this.zzc;
        zzjdVar.zzL().zzaa();
        zzlp zzlpVarZzn = zzjdVar.zzL().zzn();
        zzlpVarZzn.zzg();
        zzic zzicVar3 = zzlpVarZzn.zzu;
        zzic.zzL();
        zzbh zzbhVar = this.zza;
        Preconditions.checkNotNull(zzbhVar);
        String str2 = this.zzb;
        Preconditions.checkNotEmpty(str2);
        String str3 = zzbhVar.zza;
        if (!"_iap".equals(str3) && !"_iapx".equals(str3)) {
            zzlpVarZzn.zzu.zzaW().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", str2, str3);
            return null;
        }
        zzpg zzpgVar3 = zzlpVarZzn.zzg;
        com.google.android.gms.internal.measurement.zzhz zzhzVarZzi = com.google.android.gms.internal.measurement.zzib.zzi();
        zzpgVar3.zzj().zzb();
        try {
            zzhVarZzu = zzpgVar3.zzj().zzu(str2);
        } catch (Throwable th) {
            th = th;
            zzlpVar = zzlpVarZzn;
        }
        if (zzhVarZzu != null) {
            if (zzhVarZzu.zzD()) {
                com.google.android.gms.internal.measurement.zzic zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                zzicVarZzaE.zza(1);
                zzicVarZzaE.zzC(BackendEvent.Workflows.Context.WORKFLOW_CONTEXT_PLATFORM);
                if (!TextUtils.isEmpty(zzhVarZzu.zzc())) {
                    zzicVarZzaE.zzL(zzhVarZzu.zzc());
                }
                if (!TextUtils.isEmpty(zzhVarZzu.zzv())) {
                    zzicVarZzaE.zzJ((String) Preconditions.checkNotNull(zzhVarZzu.zzv()));
                }
                if (!TextUtils.isEmpty(zzhVarZzu.zzr())) {
                    zzicVarZzaE.zzM((String) Preconditions.checkNotNull(zzhVarZzu.zzr()));
                }
                if (zzhVarZzu.zzt() != SieveCacheKt.NodeMetaAndPreviousMask) {
                    zzicVarZzaE.zzaj((int) zzhVarZzu.zzt());
                }
                zzicVarZzaE.zzN(zzhVarZzu.zzx());
                zzicVarZzaE.zzar(zzhVarZzu.zzB());
                String strZzf = zzhVarZzu.zzf();
                if (!TextUtils.isEmpty(strZzf)) {
                    zzicVarZzaE.zzad(strZzf);
                }
                zzicVarZzaE.zzay(zzhVarZzu.zzak());
                zzjl zzjlVarZzB = zzlpVarZzn.zzg.zzB(str2);
                zzicVarZzaE.zzY(zzhVarZzu.zzz());
                if (zzicVar3.zzB() && zzlpVarZzn.zzu.zzc().zzC(zzicVarZzaE.zzK()) && zzjlVarZzB.zzo(zzjk.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                    zzicVarZzaE.zzam(null);
                }
                zzicVarZzaE.zzat(zzjlVarZzB.zzk());
                zzjk zzjkVar = zzjk.AD_STORAGE;
                if (zzjlVarZzB.zzo(zzjkVar) && zzhVarZzu.zzac()) {
                    Pair pairZzd = (zzjlVarZzB.zzo(zzjkVar) && zzhVarZzu.zzac()) ? zzpgVar3.zzq().zzd(zzhVarZzu.zzc()) : new Pair("", false);
                    if (zzhVarZzu.zzac() && !TextUtils.isEmpty((CharSequence) pairZzd.first)) {
                        try {
                            zzicVarZzaE.zzQ(zzlp.zzc((String) pairZzd.first, Long.toString(zzbhVar.zzd)));
                            if (pairZzd.second != null) {
                                zzicVarZzaE.zzT(((Boolean) pairZzd.second).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzlpVarZzn.zzu.zzaW().zzj().zzb("Resettable device id encryption failed", e.getMessage());
                            bArr = new byte[0];
                            zzpgVar = zzlpVarZzn.zzg;
                            zzpgVar.zzj().zzd();
                            return bArr;
                        }
                    }
                }
                zzic zzicVar4 = zzlpVarZzn.zzu;
                zzicVar4.zzu().zzw();
                zzicVarZzaE.zzF(Build.MODEL);
                zzicVar4.zzu().zzw();
                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                zzicVarZzaE.zzI((int) zzicVar4.zzu().zzb());
                zzicVarZzaE.zzH(zzicVar4.zzu().zzc());
                try {
                    if (zzjlVarZzB.zzo(zzjk.ANALYTICS_STORAGE) && zzhVarZzu.zzd() != null) {
                        zzicVarZzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzhVarZzu.zzd()), Long.toString(zzbhVar.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                        zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                    }
                    String strZzc = zzhVarZzu.zzc();
                    zzpg zzpgVar4 = zzlpVarZzn.zzg;
                    List listZzn = zzpgVar4.zzj().zzn(strZzc);
                    Iterator it = listZzn.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzpnVar = null;
                            break;
                        }
                        zzpnVar = (zzpn) it.next();
                        if ("_lte".equals(zzpnVar.zzc)) {
                            break;
                        }
                    }
                    if (zzpnVar == null || zzpnVar.zze == null) {
                        zzpn zzpnVar2 = new zzpn(strZzc, "auto", "_lte", zzlpVarZzn.zzu.zzba().currentTimeMillis(), 0L);
                        listZzn.add(zzpnVar2);
                        zzpgVar4.zzj().zzl(zzpnVar2);
                    }
                    com.google.android.gms.internal.measurement.zziu[] zziuVarArr = new com.google.android.gms.internal.measurement.zziu[listZzn.size()];
                    for (int i = 0; i < listZzn.size(); i++) {
                        com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
                        zzitVarZzm.zzb(((zzpn) listZzn.get(i)).zzc);
                        zzitVarZzm.zza(((zzpn) listZzn.get(i)).zzd);
                        zzpgVar4.zzp().zzc(zzitVarZzm, ((zzpn) listZzn.get(i)).zze);
                        zziuVarArr[i] = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbd();
                    }
                    zzicVarZzaE.zzq(Arrays.asList(zziuVarArr));
                    zzpg zzpgVar5 = zzlpVarZzn.zzg;
                    zzpgVar5.zzI(zzhVarZzu, zzicVarZzaE);
                    zzpgVar5.zzJ(zzhVarZzu, zzicVarZzaE);
                    zzgv zzgvVarZza = zzgv.zza(zzbhVar);
                    zzic zzicVar5 = zzlpVarZzn.zzu;
                    zzpp zzppVarZzk = zzicVar5.zzk();
                    Bundle bundle2 = zzgvVarZza.zze;
                    zzppVarZzk.zzK(bundle2, zzpgVar4.zzj().zzV(str2));
                    zzicVar5.zzk().zzI(zzgvVarZza, zzicVar5.zzc().zzd(str2));
                    bundle2.putLong("_c", 1L);
                    zzicVar5.zzaW().zzj().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1L);
                    String str4 = zzbhVar.zzc;
                    bundle2.putString("_o", str4);
                    if (zzicVar5.zzk().zzad(zzicVarZzaE.zzK(), zzhVarZzu.zzay())) {
                        zzicVar5.zzk().zzO(bundle2, "_dbg", 1L);
                        zzicVar5.zzk().zzO(bundle2, "_r", 1L);
                    }
                    zzaw zzawVarZzj = zzpgVar4.zzj();
                    String str5 = zzbhVar.zza;
                    zzbd zzbdVarZzf = zzawVarZzj.zzf(str2, str5);
                    if (zzbdVarZzf == null) {
                        zzhVar = zzhVarZzu;
                        zzicVar = zzicVar5;
                        zzicVar2 = zzicVarZzaE;
                        zzpgVar2 = zzpgVar5;
                        obj = null;
                        zzhzVar = zzhzVarZzi;
                        bundle = bundle2;
                        str = str4;
                        zzbdVarZza = new zzbd(str2, str5, 0L, 0L, 0L, zzbhVar.zzd, 0L, null, null, null, null);
                        z = true;
                        j = 0;
                    } else {
                        zzpgVar2 = zzpgVar5;
                        zzhzVar = zzhzVarZzi;
                        zzhVar = zzhVarZzu;
                        zzicVar = zzicVar5;
                        zzicVar2 = zzicVarZzaE;
                        bundle = bundle2;
                        str = str4;
                        z = true;
                        obj = null;
                        j = zzbdVarZzf.zzf;
                        zzbdVarZza = zzbdVarZzf.zza(zzbhVar.zzd);
                    }
                    zzbd zzbdVar = zzbdVarZza;
                    zzpgVar4.zzj().zzh(zzbdVar);
                    boolean z2 = z;
                    long j2 = j;
                    zzic zzicVar6 = zzlpVarZzn.zzu;
                    long j3 = zzbhVar.zzd;
                    com.google.android.gms.internal.measurement.zzic zzicVar7 = zzicVar2;
                    zzpg zzpgVar6 = zzpgVar2;
                    com.google.android.gms.internal.measurement.zzhz zzhzVar2 = zzhzVar;
                    try {
                        zzbc zzbcVar = new zzbc(zzicVar6, str, str2, str5, j3, 0L, j2, bundle);
                        com.google.android.gms.internal.measurement.zzhr zzhrVarZzp = com.google.android.gms.internal.measurement.zzhs.zzp();
                        zzhrVarZzp.zzo(zzbcVar.zzd);
                        zzhrVarZzp.zzl(zzbcVar.zzb);
                        zzhrVarZzp.zzq(zzbcVar.zzf);
                        zzbf zzbfVar = zzbcVar.zzg;
                        zzbe zzbeVar = new zzbe(zzbfVar);
                        while (zzbeVar.hasNext()) {
                            String next = zzbeVar.next();
                            String str6 = next;
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn.zzb(next);
                            Object objZza = zzbfVar.zza(next);
                            if (objZza != null) {
                                zzpgVar4.zzp().zzd(zzhvVarZzn, objZza);
                                zzhrVarZzp.zzg(zzhvVarZzn);
                            }
                        }
                        zzicVar7.zzg(zzhrVarZzp);
                        com.google.android.gms.internal.measurement.zzie zzieVarZza = com.google.android.gms.internal.measurement.zzig.zza();
                        com.google.android.gms.internal.measurement.zzht zzhtVarZza = com.google.android.gms.internal.measurement.zzhu.zza();
                        zzhtVarZza.zzb(zzbdVar.zzc);
                        zzhtVarZza.zza(str5);
                        zzieVarZza.zza(zzhtVarZza);
                        zzicVar7.zzap(zzieVarZza);
                        zzicVar7.zzaf(zzpgVar4.zzm().zzb(zzhVar.zzc(), Collections.emptyList(), zzicVar7.zzk(), Long.valueOf(zzhrVarZzp.zzn()), Long.valueOf(zzhrVarZzp.zzn()), false));
                        if (zzhrVarZzp.zzm()) {
                            zzicVar7.zzv(zzhrVarZzp.zzn());
                            zzicVar7.zzx(zzhrVarZzp.zzn());
                        }
                        long jZzp = zzhVar.zzp();
                        if (jZzp != 0) {
                            zzicVar7.zzA(jZzp);
                        }
                        long jZzn = zzhVar.zzn();
                        if (jZzn != 0) {
                            zzicVar7.zzy(jZzn);
                        } else if (jZzp != 0) {
                            zzicVar7.zzy(jZzp);
                        }
                        String strZzh = zzhVar.zzh();
                        zzair.zza();
                        if (zzicVar.zzc().zzp(str2, zzfy.zzaM) && strZzh != null) {
                            zzicVar7.zzau(strZzh);
                        }
                        zzhVar.zzL();
                        zzicVar7.zzZ((int) zzhVar.zzG());
                        zzicVar.zzc().zzi();
                        zzicVar7.zzO(161000L);
                        zzicVar7.zzs(zzicVar.zzba().currentTimeMillis());
                        zzicVar7.zzae(z2);
                        zzpgVar6.zzS(zzicVar7.zzK(), zzicVar7);
                        zzhzVar2.zze(zzicVar7);
                        zzh zzhVar2 = zzhVar;
                        zzhVar2.zzo(zzicVar7.zzu());
                        zzhVar2.zzq(zzicVar7.zzw());
                        zzpgVar4.zzj().zzv(zzhVar2, false, false);
                        zzpgVar4.zzj().zzc();
                        zzpgVar4.zzj().zzd();
                        try {
                            return zzpgVar4.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar2.zzbd()).zzcd());
                        } catch (IOException e2) {
                            zzlpVarZzn.zzu.zzaW().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgu.zzl(str2), e2);
                            return obj;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zzlpVar = zzlpVarZzn;
                    }
                } catch (SecurityException e3) {
                    zzlpVar = zzlpVarZzn;
                    try {
                        zzlpVar.zzu.zzaW().zzj().zzb("app instance id encryption failed", e3.getMessage());
                        bArr = new byte[0];
                        zzpgVar = zzlpVar.zzg;
                        zzpgVar.zzj().zzd();
                        return bArr;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } else {
                zzlpVarZzn.zzu.zzaW().zzj().zzb("Log and bundle disabled. package_name", str2);
                bArr2 = new byte[0];
            }
            zzlpVar.zzg.zzj().zzd();
            throw th;
        }
        zzlpVarZzn.zzu.zzaW().zzj().zzb("Log and bundle not available. package_name", str2);
        bArr2 = new byte[0];
        zzpgVar3.zzj().zzd();
        return bArr2;
    }
}
