package aws.sdk.kotlin.runtime.config;

import aws.smithy.kotlin.runtime.collections.AttributeKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: AwsSdkClientOption.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/AwsSdkClientOption;", "", "<init>", "()V", "ApplicationId", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "getApplicationId", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsSdkClientOption {
    public static final AwsSdkClientOption INSTANCE = new AwsSdkClientOption();
    private static final AttributeKey<String> ApplicationId = new AttributeKey<>("aws.sdk.kotlin#ApplicationId");

    private AwsSdkClientOption() {
    }

    public final AttributeKey<String> getApplicationId() {
        return ApplicationId;
    }
}
