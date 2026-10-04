package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.runtime.AwsErrorMetadata;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: S3ErrorMetadata.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/S3ErrorMetadata;", "Laws/sdk/kotlin/runtime/AwsErrorMetadata;", "<init>", "()V", "requestId2", "", "getRequestId2", "()Ljava/lang/String;", "Companion", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3ErrorMetadata extends AwsErrorMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<String> RequestId2 = new AttributeKey<>("S3:RequestId2");

    /* JADX INFO: compiled from: S3ErrorMetadata.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/S3ErrorMetadata$Companion;", "", "<init>", "()V", "RequestId2", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "getRequestId2", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AttributeKey<String> getRequestId2() {
            return S3ErrorMetadata.RequestId2;
        }
    }

    public final String getRequestId2() {
        return (String) getAttributes().getOrNull(RequestId2);
    }
}
