package aws.smithy.kotlin.runtime.http.engine;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TlsContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/AlpnId;", "", "", "protocolId", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getProtocolId", "()Ljava/lang/String;", "HTTP1_1", "HTTP2", "H2_PRIOR_KNOWLEDGE", "HTTP3", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AlpnId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AlpnId[] $VALUES;
    private final String protocolId;
    public static final AlpnId HTTP1_1 = new AlpnId("HTTP1_1", 0, "http/1.1");
    public static final AlpnId HTTP2 = new AlpnId("HTTP2", 1, "h2");
    public static final AlpnId H2_PRIOR_KNOWLEDGE = new AlpnId("H2_PRIOR_KNOWLEDGE", 2, "h2_prior_knowledge");
    public static final AlpnId HTTP3 = new AlpnId("HTTP3", 3, "h3");

    private static final /* synthetic */ AlpnId[] $values() {
        return new AlpnId[]{HTTP1_1, HTTP2, H2_PRIOR_KNOWLEDGE, HTTP3};
    }

    public static EnumEntries<AlpnId> getEntries() {
        return $ENTRIES;
    }

    public static AlpnId valueOf(String str) {
        return (AlpnId) Enum.valueOf(AlpnId.class, str);
    }

    public static AlpnId[] values() {
        return (AlpnId[]) $VALUES.clone();
    }

    private AlpnId(String str, int i, String str2) {
        this.protocolId = str2;
    }

    public final String getProtocolId() {
        return this.protocolId;
    }

    static {
        AlpnId[] alpnIdArr$values = $values();
        $VALUES = alpnIdArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(alpnIdArr$values);
    }
}
