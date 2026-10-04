package aws.smithy.kotlin.runtime.auth.awssigning;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AwsSigningConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignatureType;", "", "<init>", "(Ljava/lang/String;I)V", "HTTP_REQUEST_VIA_HEADERS", "HTTP_REQUEST_VIA_QUERY_PARAMS", "HTTP_REQUEST_CHUNK", "HTTP_REQUEST_TRAILING_HEADERS", "HTTP_REQUEST_EVENT", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsSignatureType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AwsSignatureType[] $VALUES;
    public static final AwsSignatureType HTTP_REQUEST_VIA_HEADERS = new AwsSignatureType("HTTP_REQUEST_VIA_HEADERS", 0);
    public static final AwsSignatureType HTTP_REQUEST_VIA_QUERY_PARAMS = new AwsSignatureType("HTTP_REQUEST_VIA_QUERY_PARAMS", 1);
    public static final AwsSignatureType HTTP_REQUEST_CHUNK = new AwsSignatureType("HTTP_REQUEST_CHUNK", 2);
    public static final AwsSignatureType HTTP_REQUEST_TRAILING_HEADERS = new AwsSignatureType("HTTP_REQUEST_TRAILING_HEADERS", 3);
    public static final AwsSignatureType HTTP_REQUEST_EVENT = new AwsSignatureType("HTTP_REQUEST_EVENT", 4);

    private static final /* synthetic */ AwsSignatureType[] $values() {
        return new AwsSignatureType[]{HTTP_REQUEST_VIA_HEADERS, HTTP_REQUEST_VIA_QUERY_PARAMS, HTTP_REQUEST_CHUNK, HTTP_REQUEST_TRAILING_HEADERS, HTTP_REQUEST_EVENT};
    }

    public static EnumEntries<AwsSignatureType> getEntries() {
        return $ENTRIES;
    }

    public static AwsSignatureType valueOf(String str) {
        return (AwsSignatureType) Enum.valueOf(AwsSignatureType.class, str);
    }

    public static AwsSignatureType[] values() {
        return (AwsSignatureType[]) $VALUES.clone();
    }

    private AwsSignatureType(String str, int i) {
    }

    static {
        AwsSignatureType[] awsSignatureTypeArr$values = $values();
        $VALUES = awsSignatureTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(awsSignatureTypeArr$values);
    }
}
