package aws.sdk.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.collections.AttributeKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: AwsClientOption.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/client/AwsClientOption;", "", "<init>", "()V", "Region", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "getRegion", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "AccountId", "getAccountId", "aws-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsClientOption {
    public static final AwsClientOption INSTANCE = new AwsClientOption();
    private static final AttributeKey<String> Region = new AttributeKey<>("aws.smithy.kotlin#AwsRegion");
    private static final AttributeKey<String> AccountId = new AttributeKey<>("aws.sdk.kotlin#AccountId");

    private AwsClientOption() {
    }

    public final AttributeKey<String> getRegion() {
        return Region;
    }

    public final AttributeKey<String> getAccountId() {
        return AccountId;
    }
}
