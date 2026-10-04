package aws.sdk.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomUserAgentMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"CUSTOM_METADATA_ENV_PREFIX", "", "CUSTOM_METADATA_PROP_PREFIX", "customUserAgentMetadata", "Laws/sdk/kotlin/runtime/http/operation/CustomUserAgentMetadata;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getCustomUserAgentMetadata", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Laws/sdk/kotlin/runtime/http/operation/CustomUserAgentMetadata;", "aws-http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CustomUserAgentMetadataKt {
    private static final String CUSTOM_METADATA_ENV_PREFIX = "AWS_CUSTOM_METADATA_";
    private static final String CUSTOM_METADATA_PROP_PREFIX = "aws.customMetadata.";

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomUserAgentMetadata _get_customUserAgentMetadata_$lambda$0() {
        return new CustomUserAgentMetadata(null, null, 3, null);
    }

    public static final CustomUserAgentMetadata getCustomUserAgentMetadata(ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        return (CustomUserAgentMetadata) executionContext.computeIfAbsent(CustomUserAgentMetadata.INSTANCE.getContextKey(), new Function0() { // from class: aws.sdk.kotlin.runtime.http.operation.CustomUserAgentMetadataKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomUserAgentMetadataKt._get_customUserAgentMetadata_$lambda$0();
            }
        });
    }
}
