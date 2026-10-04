package aws.smithy.kotlin.runtime.http.request;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.http.DeferredHeaders;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.net.url.Url;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/request/RealHttpRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", FirebaseAnalytics.Param.METHOD, "Laws/smithy/kotlin/runtime/http/HttpMethod;", ImagesContract.URL, "Laws/smithy/kotlin/runtime/net/url/Url;", "headers", "Laws/smithy/kotlin/runtime/http/Headers;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/http/HttpBody;", "trailingHeaders", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "<init>", "(Laws/smithy/kotlin/runtime/http/HttpMethod;Laws/smithy/kotlin/runtime/net/url/Url;Laws/smithy/kotlin/runtime/http/Headers;Laws/smithy/kotlin/runtime/http/HttpBody;Laws/smithy/kotlin/runtime/http/DeferredHeaders;)V", "getMethod", "()Laws/smithy/kotlin/runtime/http/HttpMethod;", "getUrl", "()Laws/smithy/kotlin/runtime/net/url/Url;", "getHeaders", "()Laws/smithy/kotlin/runtime/http/Headers;", "getBody", "()Laws/smithy/kotlin/runtime/http/HttpBody;", "getTrailingHeaders", "()Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class RealHttpRequest implements HttpRequest {
    private final HttpBody body;
    private final Headers headers;
    private final HttpMethod method;
    private final DeferredHeaders trailingHeaders;
    private final Url url;

    public static /* synthetic */ RealHttpRequest copy$default(RealHttpRequest realHttpRequest, HttpMethod httpMethod, Url url, Headers headers, HttpBody httpBody, DeferredHeaders deferredHeaders, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = realHttpRequest.method;
        }
        if ((i & 2) != 0) {
            url = realHttpRequest.url;
        }
        if ((i & 4) != 0) {
            headers = realHttpRequest.headers;
        }
        if ((i & 8) != 0) {
            httpBody = realHttpRequest.body;
        }
        if ((i & 16) != 0) {
            deferredHeaders = realHttpRequest.trailingHeaders;
        }
        DeferredHeaders deferredHeaders2 = deferredHeaders;
        Headers headers2 = headers;
        return realHttpRequest.copy(httpMethod, url, headers2, httpBody, deferredHeaders2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HttpMethod getMethod() {
        return this.method;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Url getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Headers getHeaders() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final HttpBody getBody() {
        return this.body;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DeferredHeaders getTrailingHeaders() {
        return this.trailingHeaders;
    }

    public final RealHttpRequest copy(HttpMethod method, Url url, Headers headers, HttpBody body, DeferredHeaders trailingHeaders) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(trailingHeaders, "trailingHeaders");
        return new RealHttpRequest(method, url, headers, body, trailingHeaders);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RealHttpRequest)) {
            return false;
        }
        RealHttpRequest realHttpRequest = (RealHttpRequest) other;
        return this.method == realHttpRequest.method && Intrinsics.areEqual(this.url, realHttpRequest.url) && Intrinsics.areEqual(this.headers, realHttpRequest.headers) && Intrinsics.areEqual(this.body, realHttpRequest.body) && Intrinsics.areEqual(this.trailingHeaders, realHttpRequest.trailingHeaders);
    }

    public int hashCode() {
        return (((((((this.method.hashCode() * 31) + this.url.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.body.hashCode()) * 31) + this.trailingHeaders.hashCode();
    }

    public String toString() {
        return "RealHttpRequest(method=" + this.method + ", url=" + this.url + ", headers=" + this.headers + ", body=" + this.body + ", trailingHeaders=" + this.trailingHeaders + ')';
    }

    public RealHttpRequest(HttpMethod method, Url url, Headers headers, HttpBody body, DeferredHeaders trailingHeaders) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(trailingHeaders, "trailingHeaders");
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
        this.trailingHeaders = trailingHeaders;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public HttpMethod getMethod() {
        return this.method;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public Url getUrl() {
        return this.url;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public Headers getHeaders() {
        return this.headers;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public HttpBody getBody() {
        return this.body;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public DeferredHeaders getTrailingHeaders() {
        return this.trailingHeaders;
    }
}
