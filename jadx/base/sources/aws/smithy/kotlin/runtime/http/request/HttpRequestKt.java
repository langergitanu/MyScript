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
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0001¨\u0006\u000e"}, m1599d2 = {"HttpRequest", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", FirebaseAnalytics.Param.METHOD, "Laws/smithy/kotlin/runtime/http/HttpMethod;", ImagesContract.URL, "Laws/smithy/kotlin/runtime/net/url/Url;", "headers", "Laws/smithy/kotlin/runtime/http/Headers;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/http/HttpBody;", "trailingHeaders", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "toBuilder", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpRequestKt {
    public static /* synthetic */ HttpRequest HttpRequest$default(HttpMethod httpMethod, Url url, Headers headers, HttpBody httpBody, DeferredHeaders deferredHeaders, int i, Object obj) {
        if ((i & 4) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        if ((i & 8) != 0) {
            httpBody = HttpBody.Empty.INSTANCE;
        }
        if ((i & 16) != 0) {
            deferredHeaders = DeferredHeaders.INSTANCE.getEmpty();
        }
        return HttpRequest(httpMethod, url, headers, httpBody, deferredHeaders);
    }

    public static final HttpRequest HttpRequest(HttpMethod method, Url url, Headers headers, HttpBody body, DeferredHeaders trailingHeaders) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(trailingHeaders, "trailingHeaders");
        return new RealHttpRequest(method, url, headers, body, trailingHeaders);
    }

    public static final HttpRequestBuilder toBuilder(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<this>");
        if (httpRequest instanceof HttpRequestBuilderView) {
            HttpRequestBuilderView httpRequestBuilderView = (HttpRequestBuilderView) httpRequest;
            if (!httpRequestBuilderView.getAllowToBuilder$http()) {
                throw new IllegalStateException("This is an immutable HttpRequest that should not be converted to a builder".toString());
            }
            return httpRequestBuilderView.getBuilder$http();
        }
        if (!(httpRequest instanceof RealHttpRequest)) {
            throw new NoWhenBranchMatchedException();
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        RealHttpRequest realHttpRequest = (RealHttpRequest) httpRequest;
        httpRequestBuilder.setMethod(realHttpRequest.getMethod());
        httpRequestBuilder.getHeaders().appendAll(realHttpRequest.getHeaders());
        HttpRequestBuilderKt.url(httpRequestBuilder, realHttpRequest.getUrl());
        httpRequestBuilder.setBody(realHttpRequest.getBody());
        httpRequestBuilder.getTrailingHeaders().appendAll(realHttpRequest.getTrailingHeaders());
        return httpRequestBuilder;
    }
}
