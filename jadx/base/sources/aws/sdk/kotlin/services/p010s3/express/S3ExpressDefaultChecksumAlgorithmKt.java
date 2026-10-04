package aws.sdk.kotlin.services.p010s3.express;

import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3ExpressDefaultChecksumAlgorithm.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"S3_EXPRESS_ENDPOINT_PROPERTY_KEY", "", "S3_EXPRESS_ENDPOINT_PROPERTY_VALUE", "usingS3Express", "", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3ExpressDefaultChecksumAlgorithmKt {
    public static final String S3_EXPRESS_ENDPOINT_PROPERTY_KEY = "backend";
    public static final String S3_EXPRESS_ENDPOINT_PROPERTY_VALUE = "S3Express";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean usingS3Express(ExecutionContext executionContext) {
        return !Intrinsics.areEqual(executionContext.getOrNull(new AttributeKey(S3_EXPRESS_ENDPOINT_PROPERTY_KEY)), S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
    }
}
