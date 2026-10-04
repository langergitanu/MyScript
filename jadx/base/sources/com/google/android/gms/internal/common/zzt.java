package com.google.android.gms.internal.common;

import com.survicate.surveys.TextRecallingManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.10.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzt implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzw zzb;

    zzt(zzw zzwVar, CharSequence charSequence) {
        this.zza = charSequence;
        Objects.requireNonNull(zzwVar);
        this.zzb = zzwVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zzb.zze(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(zzq.zza(it.next(), TextRecallingManager.ANSWER_SEPARATOR));
                while (it.hasNext()) {
                    sb.append((CharSequence) TextRecallingManager.ANSWER_SEPARATOR);
                    sb.append(zzq.zza(it.next(), TextRecallingManager.ANSWER_SEPARATOR));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
