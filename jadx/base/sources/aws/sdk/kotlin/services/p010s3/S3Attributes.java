package aws.sdk.kotlin.services.p010s3;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: S3Attributes.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/S3Attributes;", "", "<init>", "()V", "Bucket", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "getBucket", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "ExpressClient", "Laws/smithy/kotlin/runtime/client/SdkClient;", "getExpressClient", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final class S3Attributes {
    public static final S3Attributes INSTANCE = new S3Attributes();
    private static final AttributeKey<String> Bucket = new AttributeKey<>("aws.sdk.kotlin#S3Bucket");
    private static final AttributeKey<SdkClient> ExpressClient = new AttributeKey<>("aws.sdk.kotlin#S3ExpressClient");

    private S3Attributes() {
    }

    public final AttributeKey<String> getBucket() {
        return Bucket;
    }

    public final AttributeKey<SdkClient> getExpressClient() {
        return ExpressClient;
    }
}
