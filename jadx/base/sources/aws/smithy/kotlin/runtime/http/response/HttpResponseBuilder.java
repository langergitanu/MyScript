package aws.smithy.kotlin.runtime.http.response;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpResponseBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\t\b\u0016¢\u0006\u0004\b\b\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0000H\u0016J\n\u0010\u0018\u001a\u00020\u0019H\u0096\u0080\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/response/HttpResponseBuilder;", "Laws/smithy/kotlin/runtime/util/CanDeepCopy;", NotificationCompat.CATEGORY_STATUS, "Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "headers", "Laws/smithy/kotlin/runtime/http/HeadersBuilder;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/http/HttpBody;", "<init>", "(Laws/smithy/kotlin/runtime/http/HttpStatusCode;Laws/smithy/kotlin/runtime/http/HeadersBuilder;Laws/smithy/kotlin/runtime/http/HttpBody;)V", "()V", "getStatus", "()Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "setStatus", "(Laws/smithy/kotlin/runtime/http/HttpStatusCode;)V", "getHeaders", "()Laws/smithy/kotlin/runtime/http/HeadersBuilder;", "getBody", "()Laws/smithy/kotlin/runtime/http/HttpBody;", "setBody", "(Laws/smithy/kotlin/runtime/http/HttpBody;)V", "build", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "deepCopy", "toString", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpResponseBuilder implements CanDeepCopy<HttpResponseBuilder> {
    private HttpBody body;
    private final HeadersBuilder headers;
    private HttpStatusCode status;

    private HttpResponseBuilder(HttpStatusCode httpStatusCode, HeadersBuilder headersBuilder, HttpBody httpBody) {
        this.status = httpStatusCode;
        this.headers = headersBuilder;
        this.body = httpBody;
    }

    public final HttpStatusCode getStatus() {
        return this.status;
    }

    public final void setStatus(HttpStatusCode httpStatusCode) {
        Intrinsics.checkNotNullParameter(httpStatusCode, "<set-?>");
        this.status = httpStatusCode;
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

    public HttpResponseBuilder() {
        this(HttpStatusCode.INSTANCE.getOK(), new HeadersBuilder(), HttpBody.Empty.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [aws.smithy.kotlin.runtime.http.Headers] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final HttpResponse build() {
        return HttpResponseKt.HttpResponse(this.status, this.headers.isEmpty() ? Headers.INSTANCE.getEmpty() : this.headers.build(), this.body);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // aws.smithy.kotlin.runtime.util.CanDeepCopy
    public HttpResponseBuilder deepCopy() {
        return new HttpResponseBuilder(this.status, this.headers.deepCopy(), this.body);
    }

    public String toString() {
        return "HttpResponseBuilder(status=" + this.status + ", headers=" + this.headers + ", body=" + this.body + ')';
    }
}
