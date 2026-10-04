package aws.smithy.kotlin.runtime.awsprotocol;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: AwsAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/AwsAttributes;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "Region", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "getRegion", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "aws-protocol-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsAttributes {
    public static final AwsAttributes INSTANCE = new AwsAttributes();
    private static final AttributeKey<String> Region = new AttributeKey<>("aws.smithy.kotlin#AwsRegion");

    private AwsAttributes() {
    }

    public final AttributeKey<String> getRegion() {
        return Region;
    }
}
