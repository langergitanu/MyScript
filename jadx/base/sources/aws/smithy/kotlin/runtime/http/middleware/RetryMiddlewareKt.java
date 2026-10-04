package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import kotlin.Metadata;

/* JADX INFO: compiled from: RetryMiddleware.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0018\u0010\u0002\u001a\u00020\u0001*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "", "isRetryable", "(Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;)Z", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RetryMiddlewareKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRetryable(HttpRequestBuilder httpRequestBuilder) {
        return !httpRequestBuilder.getBody().getIsOneShot();
    }
}
