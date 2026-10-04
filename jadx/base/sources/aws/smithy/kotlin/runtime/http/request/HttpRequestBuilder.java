package aws.smithy.kotlin.runtime.http.request;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.http.DeferredHeaders;
import aws.smithy.kotlin.runtime.http.DeferredHeadersBuilder;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpRequestBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB\t\b\u0016¢\u0006\u0004\b\f\u0010\u000eJ\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0000H\u0016J\n\u0010 \u001a\u00020!H\u0096\u0080\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/util/CanDeepCopy;", FirebaseAnalytics.Param.METHOD, "Laws/smithy/kotlin/runtime/http/HttpMethod;", ImagesContract.URL, "Laws/smithy/kotlin/runtime/net/url/Url$Builder;", "headers", "Laws/smithy/kotlin/runtime/http/HeadersBuilder;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/http/HttpBody;", "trailingHeaders", "Laws/smithy/kotlin/runtime/http/DeferredHeadersBuilder;", "<init>", "(Laws/smithy/kotlin/runtime/http/HttpMethod;Laws/smithy/kotlin/runtime/net/url/Url$Builder;Laws/smithy/kotlin/runtime/http/HeadersBuilder;Laws/smithy/kotlin/runtime/http/HttpBody;Laws/smithy/kotlin/runtime/http/DeferredHeadersBuilder;)V", "()V", "getMethod", "()Laws/smithy/kotlin/runtime/http/HttpMethod;", "setMethod", "(Laws/smithy/kotlin/runtime/http/HttpMethod;)V", "getUrl", "()Laws/smithy/kotlin/runtime/net/url/Url$Builder;", "getHeaders", "()Laws/smithy/kotlin/runtime/http/HeadersBuilder;", "getBody", "()Laws/smithy/kotlin/runtime/http/HttpBody;", "setBody", "(Laws/smithy/kotlin/runtime/http/HttpBody;)V", "getTrailingHeaders", "()Laws/smithy/kotlin/runtime/http/DeferredHeadersBuilder;", "build", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "deepCopy", "toString", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpRequestBuilder implements CanDeepCopy<HttpRequestBuilder> {
    private HttpBody body;
    private final HeadersBuilder headers;
    private HttpMethod method;
    private final DeferredHeadersBuilder trailingHeaders;
    private final Url.Builder url;

    private HttpRequestBuilder(HttpMethod httpMethod, Url.Builder builder, HeadersBuilder headersBuilder, HttpBody httpBody, DeferredHeadersBuilder deferredHeadersBuilder) {
        this.method = httpMethod;
        this.url = builder;
        this.headers = headersBuilder;
        this.body = httpBody;
        this.trailingHeaders = deferredHeadersBuilder;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final void setMethod(HttpMethod httpMethod) {
        Intrinsics.checkNotNullParameter(httpMethod, "<set-?>");
        this.method = httpMethod;
    }

    public final Url.Builder getUrl() {
        return this.url;
    }

    public final HeadersBuilder getHeaders() {
        return this.headers;
    }

    public final HttpBody getBody() {
        return this.body;
    }

    public final void setBody(HttpBody httpBody) {
        Intrinsics.checkNotNullParameter(httpBody, "<set-?>");
        this.body = httpBody;
    }

    public final DeferredHeadersBuilder getTrailingHeaders() {
        return this.trailingHeaders;
    }

    public HttpRequestBuilder() {
        this(HttpMethod.GET, new Url.Builder(), new HeadersBuilder(), HttpBody.Empty.INSTANCE, new DeferredHeadersBuilder());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [aws.smithy.kotlin.runtime.http.Headers] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r4v4, types: [aws.smithy.kotlin.runtime.http.DeferredHeaders] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public final HttpRequest build() {
        return HttpRequestKt.HttpRequest(this.method, this.url.build(), this.headers.isEmpty() ? Headers.INSTANCE.getEmpty() : this.headers.build(), this.body, this.trailingHeaders.isEmpty() ? DeferredHeaders.INSTANCE.getEmpty() : this.trailingHeaders.build());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // aws.smithy.kotlin.runtime.util.CanDeepCopy
    public HttpRequestBuilder deepCopy() {
        return new HttpRequestBuilder(this.method, this.url.deepCopy(), this.headers.deepCopy(), this.body, this.trailingHeaders.deepCopy());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HttpRequestBuilder(method=" + this.method + ", url=" + this.url + ", headers=" + this.headers + ", body=" + this.body + ", trailingHeaders=" + this.trailingHeaders + ')');
        return sb.toString();
    }
}
