package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.http.HttpCall;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.HttpVersion;

/* JADX INFO: compiled from: ImdsClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1599d2 = {"DEFAULT_TOKEN_TTL_SECONDS", "", "DEFAULT_MAX_RETRIES", "SERVICE", "", "toTraceString", "Laws/smithy/kotlin/runtime/http/HttpCall;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImdsClientKt {
    public static final int DEFAULT_MAX_RETRIES = 3;
    public static final int DEFAULT_TOKEN_TTL_SECONDS = 21600;
    private static final String SERVICE = "imds";

    public static final String toTraceString(HttpCall httpCall) {
        Intrinsics.checkNotNullParameter(httpCall, "<this>");
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(HttpVersion.HTTP, httpCall.getRequest().getMethod(), httpCall.getRequest().getUrl(), "-->", Integer.valueOf(httpCall.getResponse().getStatus().getValue()), httpCall.getResponse().getStatus().getDescription()), " ", null, null, 0, null, null, 62, null);
    }
}
