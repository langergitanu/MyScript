package aws.smithy.kotlin.runtime.net;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TlsVersion.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/TlsVersion;", "", "<init>", "(Ljava/lang/String;I)V", "TLS_1_0", "TLS_1_1", "TLS_1_2", "TLS_1_3", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TlsVersion {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TlsVersion[] $VALUES;
    public static final TlsVersion TLS_1_0 = new TlsVersion("TLS_1_0", 0);
    public static final TlsVersion TLS_1_1 = new TlsVersion("TLS_1_1", 1);
    public static final TlsVersion TLS_1_2 = new TlsVersion("TLS_1_2", 2);
    public static final TlsVersion TLS_1_3 = new TlsVersion("TLS_1_3", 3);

    private static final /* synthetic */ TlsVersion[] $values() {
        return new TlsVersion[]{TLS_1_0, TLS_1_1, TLS_1_2, TLS_1_3};
    }

    public static EnumEntries<TlsVersion> getEntries() {
        return $ENTRIES;
    }

    public static TlsVersion valueOf(String str) {
        return (TlsVersion) Enum.valueOf(TlsVersion.class, str);
    }

    public static TlsVersion[] values() {
        return (TlsVersion[]) $VALUES.clone();
    }

    private TlsVersion(String str, int i) {
    }

    static {
        TlsVersion[] tlsVersionArr$values = $values();
        $VALUES = tlsVersionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(tlsVersionArr$values);
    }
}
