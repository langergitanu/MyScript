package aws.smithy.kotlin.runtime.http.request;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.http.DeferredHeaders;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.net.url.Url;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpRequestBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010$\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b%J\u000e\u0010&\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b'J\u001d\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0083\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004J\n\u0010.\u001a\u00020/HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b!\u0010\"¨\u00060"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilderView;", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "builder", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "allowToBuilder", "", "<init>", "(Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;Z)V", "getBuilder$http", "()Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "getAllowToBuilder$http", "()Z", FirebaseAnalytics.Param.METHOD, "Laws/smithy/kotlin/runtime/http/HttpMethod;", "getMethod", "()Laws/smithy/kotlin/runtime/http/HttpMethod;", ImagesContract.URL, "Laws/smithy/kotlin/runtime/net/url/Url;", "getUrl", "()Laws/smithy/kotlin/runtime/net/url/Url;", "url$delegate", "Lkotlin/Lazy;", "headers", "Laws/smithy/kotlin/runtime/http/Headers;", "getHeaders", "()Laws/smithy/kotlin/runtime/http/Headers;", "headers$delegate", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/http/HttpBody;", "getBody", "()Laws/smithy/kotlin/runtime/http/HttpBody;", "trailingHeaders", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "getTrailingHeaders", "()Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "trailingHeaders$delegate", "component1", "component1$http", "component2", "component2$http", "copy", "equals", "other", "", "hashCode", "", "toString", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class HttpRequestBuilderView implements HttpRequest {
    private final boolean allowToBuilder;
    private final HttpBody body;
    private final HttpRequestBuilder builder;

    /* JADX INFO: renamed from: headers$delegate, reason: from kotlin metadata */
    private final Lazy headers;
    private final HttpMethod method;

    /* JADX INFO: renamed from: trailingHeaders$delegate, reason: from kotlin metadata */
    private final Lazy trailingHeaders;

    /* JADX INFO: renamed from: url$delegate, reason: from kotlin metadata */
    private final Lazy url;

    public static /* synthetic */ HttpRequestBuilderView copy$default(HttpRequestBuilderView httpRequestBuilderView, HttpRequestBuilder httpRequestBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            httpRequestBuilder = httpRequestBuilderView.builder;
        }
        if ((i & 2) != 0) {
            z = httpRequestBuilderView.allowToBuilder;
        }
        return httpRequestBuilderView.copy(httpRequestBuilder, z);
    }

    /* JADX INFO: renamed from: component1$http, reason: from getter */
    public final HttpRequestBuilder getBuilder() {
        return this.builder;
    }

    /* JADX INFO: renamed from: component2$http, reason: from getter */
    public final boolean getAllowToBuilder() {
        return this.allowToBuilder;
    }

    public final HttpRequestBuilderView copy(HttpRequestBuilder builder, boolean allowToBuilder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return new HttpRequestBuilderView(builder, allowToBuilder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpRequestBuilderView)) {
            return false;
        }
        HttpRequestBuilderView httpRequestBuilderView = (HttpRequestBuilderView) other;
        return Intrinsics.areEqual(this.builder, httpRequestBuilderView.builder) && this.allowToBuilder == httpRequestBuilderView.allowToBuilder;
    }

    public int hashCode() {
        return (this.builder.hashCode() * 31) + Boolean.hashCode(this.allowToBuilder);
    }

    public String toString() {
        return "HttpRequestBuilderView(builder=" + this.builder + ", allowToBuilder=" + this.allowToBuilder + ')';
    }

    public HttpRequestBuilderView(HttpRequestBuilder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.allowToBuilder = z;
        this.method = builder.getMethod();
        this.url = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HttpRequestBuilderView.url_delegate$lambda$0(this.f$0);
            }
        });
        this.headers = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HttpRequestBuilderView.headers_delegate$lambda$0(this.f$0);
            }
        });
        this.body = builder.getBody();
        this.trailingHeaders = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HttpRequestBuilderView.trailingHeaders_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final HttpRequestBuilder getBuilder$http() {
        return this.builder;
    }

    public final boolean getAllowToBuilder$http() {
        return this.allowToBuilder;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public HttpMethod getMethod() {
        return this.method;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Url url_delegate$lambda$0(HttpRequestBuilderView httpRequestBuilderView) {
        return httpRequestBuilderView.builder.getUrl().build();
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public Url getUrl() {
        return (Url) this.url.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v3, types: [aws.smithy.kotlin.runtime.http.Headers] */
    public static final Headers headers_delegate$lambda$0(HttpRequestBuilderView httpRequestBuilderView) {
        return httpRequestBuilderView.builder.getHeaders().build();
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public Headers getHeaders() {
        return (Headers) this.headers.getValue();
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public HttpBody getBody() {
        return this.body;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v3, types: [aws.smithy.kotlin.runtime.http.DeferredHeaders] */
    public static final DeferredHeaders trailingHeaders_delegate$lambda$0(HttpRequestBuilderView httpRequestBuilderView) {
        return httpRequestBuilderView.builder.getTrailingHeaders().build();
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public DeferredHeaders getTrailingHeaders() {
        return (DeferredHeaders) this.trailingHeaders.getValue();
    }
}
