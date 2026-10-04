package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhn implements com.google.android.gms.internal.measurement.zzr {
    final /* synthetic */ zzht zza;

    zzhn(zzht zzhtVar) {
        Objects.requireNonNull(zzhtVar);
        this.zza = zzhtVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        int i2 = i - 1;
        zzgs zzgsVarZzi = i2 != 0 ? i2 != 1 ? i2 != 3 ? i2 != 4 ? this.zza.zzu.zzaW().zzi() : z ? this.zza.zzu.zzaW().zzf() : !z2 ? this.zza.zzu.zzaW().zzh() : this.zza.zzu.zzaW().zze() : this.zza.zzu.zzaW().zzk() : z ? this.zza.zzu.zzaW().zzc() : !z2 ? this.zza.zzu.zzaW().zzd() : this.zza.zzu.zzaW().zzb() : this.zza.zzu.zzaW().zzj();
        int size = list.size();
        if (size == 1) {
            zzgsVarZzi.zzb(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzgsVarZzi.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzgsVarZzi.zza(str);
        } else {
            zzgsVarZzi.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
