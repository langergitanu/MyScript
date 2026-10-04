package com.google.android.gms.internal.measurement;

import aws.sdk.kotlin.runtime.config.profile.Literals;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import okio.Utf8;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzc implements zzyk {
    private static final Set zza = new HashSet(Arrays.asList(Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class));
    private final StringBuilder zzd;
    private boolean zze = false;
    private final String zzb = "[CONTEXT ";
    private final String zzc = " ]";

    public zzzc(String str, String str2, StringBuilder sb) {
        this.zzd = sb;
    }

    private static int zzc(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt == '\"' || cCharAt == '\\') {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzyk
    public final void zza(String str, Object obj) {
        boolean z = this.zze;
        char c = TokenParser.f2383SP;
        if (z) {
            this.zzd.append(TokenParser.f2383SP);
        } else {
            StringBuilder sb = this.zzd;
            if (sb.length() > 0) {
                if (sb.length() > 1000 || sb.indexOf("\n") != -1) {
                    c = '\n';
                }
                sb.append(c);
            }
            sb.append(this.zzb);
            this.zze = true;
        }
        StringBuilder sb2 = this.zzd;
        sb2.append(str);
        sb2.append(Literals.PROPERTY_SPLITTER);
        if (obj == null) {
            sb2.append(true);
            return;
        }
        if (zza.contains(obj.getClass())) {
            sb2.append(obj);
            return;
        }
        sb2.append('\"');
        String string = obj.toString();
        int i = 0;
        while (true) {
            int iZzc = zzc(string, i);
            if (iZzc == -1) {
                sb2.append((CharSequence) string, i, string.length());
                sb2.append('\"');
                return;
            }
            sb2.append((CharSequence) string, i, iZzc);
            i = iZzc + 1;
            char cCharAt = string.charAt(iZzc);
            if (cCharAt == '\t') {
                cCharAt = 't';
            } else if (cCharAt == '\n') {
                cCharAt = 'n';
            } else if (cCharAt == '\r') {
                cCharAt = 'r';
            } else if (cCharAt != '\"' && cCharAt != '\\') {
                sb2.append(Utf8.REPLACEMENT_CHARACTER);
            }
            sb2.append("\\");
            sb2.append(cCharAt);
        }
    }

    public final void zzb() {
        if (this.zze) {
            this.zzd.append(this.zzc);
        }
    }
}
