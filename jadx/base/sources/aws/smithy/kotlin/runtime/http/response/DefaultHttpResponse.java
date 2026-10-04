package aws.smithy.kotlin.runtime.http.response;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: HttpResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0011HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/response/DefaultHttpResponse;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", NotificationCompat.CATEGORY_STATUS, "Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "headers", "Laws/smithy/kotlin/runtime/http/Headers;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/http/HttpBody;", "<init>", "(Laws/smithy/kotlin/runtime/http/HttpStatusCode;Laws/smithy/kotlin/runtime/http/Headers;Laws/smithy/kotlin/runtime/http/HttpBody;)V", "getStatus", "()Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "getHeaders", "()Laws/smithy/kotlin/runtime/http/Headers;", "getBody", "()Laws/smithy/kotlin/runtime/http/HttpBody;", "summary", "", "getSummary", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class DefaultHttpResponse implements HttpResponse {
    private final HttpBody body;
    private final Headers headers;
    private final HttpStatusCode status;
    private final String summary;

    public static /* synthetic */ DefaultHttpResponse copy$default(DefaultHttpResponse defaultHttpResponse, HttpStatusCode httpStatusCode, Headers headers, HttpBody httpBody, int i, Object obj) {
        if ((i & 1) != 0) {
            httpStatusCode = defaultHttpResponse.status;
        }
        if ((i & 2) != 0) {
            headers = defaultHttpResponse.headers;
        }
        if ((i & 4) != 0) {
            httpBody = defaultHttpResponse.body;
        }
        return defaultHttpResponse.copy(httpStatusCode, headers, httpBody);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HttpStatusCode getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Headers getHeaders() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HttpBody getBody() {
        return this.body;
    }

    public final DefaultHttpResponse copy(HttpStatusCode status, Headers headers, HttpBody body) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        return new DefaultHttpResponse(status, headers, body);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefaultHttpResponse)) {
            return false;
        }
        DefaultHttpResponse defaultHttpResponse = (DefaultHttpResponse) other;
        return Intrinsics.areEqual(this.status, defaultHttpResponse.status) && Intrinsics.areEqual(this.headers, defaultHttpResponse.headers) && Intrinsics.areEqual(this.body, defaultHttpResponse.body);
    }

    public int hashCode() {
        return (((this.status.hashCode() * 31) + this.headers.hashCode()) * 31) + this.body.hashCode();
    }

    public String toString() {
        return "DefaultHttpResponse(status=" + this.status + ", headers=" + this.headers + ", body=" + this.body + ')';
    }

    public DefaultHttpResponse(HttpStatusCode status, Headers headers, HttpBody body) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        this.status = status;
        this.headers = headers;
        this.body = body;
        this.summary = "HTTP " + getStatus().getValue() + TokenParser.f2383SP + getStatus().getDescription();
    }

    @Override // aws.smithy.kotlin.runtime.http.response.HttpResponse
    public HttpStatusCode getStatus() {
        return this.status;
    }

    @Override // aws.smithy.kotlin.runtime.http.response.HttpResponse
    public Headers getHeaders() {
        return this.headers;
    }

    @Override // aws.smithy.kotlin.runtime.http.response.HttpResponse
    public HttpBody getBody() {
        return this.body;
    }

    @Override // aws.smithy.kotlin.runtime.ProtocolResponse
    public String getSummary() {
        return this.summary;
    }
}
