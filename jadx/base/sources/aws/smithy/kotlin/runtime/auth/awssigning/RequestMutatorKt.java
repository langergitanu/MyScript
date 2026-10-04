package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.time.TimestampFormat;
import com.fasterxml.jackson.core.JsonPointer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequestMutator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m1599d2 = {"credentialScope", "", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "getCredentialScope", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;)Ljava/lang/String;", "credentialValue", "config", "aws-signing-default"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RequestMutatorKt {

    /* JADX INFO: compiled from: RequestMutator.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AwsSigningAlgorithm.values().length];
            try {
                iArr[AwsSigningAlgorithm.SIGV4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AwsSigningAlgorithm.SIGV4_ASYMMETRIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String getCredentialScope(AwsSigningConfig awsSigningConfig) {
        Intrinsics.checkNotNullParameter(awsSigningConfig, "<this>");
        String str = awsSigningConfig.getSigningDate().format(TimestampFormat.ISO_8601_CONDENSED_DATE);
        int i = WhenMappings.$EnumSwitchMapping$0[awsSigningConfig.getAlgorithm().ordinal()];
        if (i == 1) {
            return str + JsonPointer.SEPARATOR + awsSigningConfig.getRegion() + JsonPointer.SEPARATOR + awsSigningConfig.getService() + "/aws4_request";
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return str + JsonPointer.SEPARATOR + awsSigningConfig.getService() + "/aws4_request";
    }

    public static final String credentialValue(AwsSigningConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return config.getCredentials().getAccessKeyId() + JsonPointer.SEPARATOR + getCredentialScope(config);
    }
}
