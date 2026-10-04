package aws.smithy.kotlin.runtime.http;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: HttpException.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECT_TIMEOUT", "CONNECTION_ACQUIRE_TIMEOUT", "TLS_NEGOTIATION_TIMEOUT", "TLS_NEGOTIATION_ERROR", "CONNECTION_CLOSED", "SOCKET_TIMEOUT", "PROTOCOL_NEGOTIATION_ERROR", "SDK_UNKNOWN", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HttpErrorCode[] $VALUES;
    public static final HttpErrorCode CONNECT_TIMEOUT = new HttpErrorCode("CONNECT_TIMEOUT", 0);
    public static final HttpErrorCode CONNECTION_ACQUIRE_TIMEOUT = new HttpErrorCode("CONNECTION_ACQUIRE_TIMEOUT", 1);
    public static final HttpErrorCode TLS_NEGOTIATION_TIMEOUT = new HttpErrorCode("TLS_NEGOTIATION_TIMEOUT", 2);
    public static final HttpErrorCode TLS_NEGOTIATION_ERROR = new HttpErrorCode("TLS_NEGOTIATION_ERROR", 3);
    public static final HttpErrorCode CONNECTION_CLOSED = new HttpErrorCode("CONNECTION_CLOSED", 4);
    public static final HttpErrorCode SOCKET_TIMEOUT = new HttpErrorCode("SOCKET_TIMEOUT", 5);
    public static final HttpErrorCode PROTOCOL_NEGOTIATION_ERROR = new HttpErrorCode("PROTOCOL_NEGOTIATION_ERROR", 6);
    public static final HttpErrorCode SDK_UNKNOWN = new HttpErrorCode("SDK_UNKNOWN", 7);

    private static final /* synthetic */ HttpErrorCode[] $values() {
        return new HttpErrorCode[]{CONNECT_TIMEOUT, CONNECTION_ACQUIRE_TIMEOUT, TLS_NEGOTIATION_TIMEOUT, TLS_NEGOTIATION_ERROR, CONNECTION_CLOSED, SOCKET_TIMEOUT, PROTOCOL_NEGOTIATION_ERROR, SDK_UNKNOWN};
    }

    public static EnumEntries<HttpErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static HttpErrorCode valueOf(String str) {
        return (HttpErrorCode) Enum.valueOf(HttpErrorCode.class, str);
    }

    public static HttpErrorCode[] values() {
        return (HttpErrorCode[]) $VALUES.clone();
    }

    private HttpErrorCode(String str, int i) {
    }

    static {
        HttpErrorCode[] httpErrorCodeArr$values = $values();
        $VALUES = httpErrorCodeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(httpErrorCodeArr$values);
    }
}
