package aws.smithy.kotlin.runtime.auth.awssigning;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AwsSigningConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;", "", "signingName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSigningName", "()Ljava/lang/String;", "SIGV4", "SIGV4_ASYMMETRIC", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsSigningAlgorithm {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AwsSigningAlgorithm[] $VALUES;
    public static final AwsSigningAlgorithm SIGV4 = new AwsSigningAlgorithm("SIGV4", 0, "AWS4-HMAC-SHA256");
    public static final AwsSigningAlgorithm SIGV4_ASYMMETRIC = new AwsSigningAlgorithm("SIGV4_ASYMMETRIC", 1, "AWS4-ECDSA-P256-SHA256");
    private final String signingName;

    private static final /* synthetic */ AwsSigningAlgorithm[] $values() {
        return new AwsSigningAlgorithm[]{SIGV4, SIGV4_ASYMMETRIC};
    }

    public static EnumEntries<AwsSigningAlgorithm> getEntries() {
        return $ENTRIES;
    }

    public static AwsSigningAlgorithm valueOf(String str) {
        return (AwsSigningAlgorithm) Enum.valueOf(AwsSigningAlgorithm.class, str);
    }

    public static AwsSigningAlgorithm[] values() {
        return (AwsSigningAlgorithm[]) $VALUES.clone();
    }

    private AwsSigningAlgorithm(String str, int i, String str2) {
        this.signingName = str2;
    }

    public final String getSigningName() {
        return this.signingName;
    }

    static {
        AwsSigningAlgorithm[] awsSigningAlgorithmArr$values = $values();
        $VALUES = awsSigningAlgorithmArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(awsSigningAlgorithmArr$values);
    }
}
