package aws.smithy.kotlin.runtime.http.middleware;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.SdkBaseException;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import kotlin.Metadata;

/* JADX INFO: compiled from: DefaultValidateResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0002\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\tB\u0013\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006'"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/middleware/HttpResponseException;", "Laws/smithy/kotlin/runtime/SdkBaseException;", "<init>", "()V", "", "message", "(Ljava/lang/String;)V", "", "cause", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "statusCode", "Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "getStatusCode", "()Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "setStatusCode", "(Laws/smithy/kotlin/runtime/http/HttpStatusCode;)V", "Laws/smithy/kotlin/runtime/http/Headers;", "headers", "Laws/smithy/kotlin/runtime/http/Headers;", "getHeaders", "()Laws/smithy/kotlin/runtime/http/Headers;", "setHeaders", "(Laws/smithy/kotlin/runtime/http/Headers;)V", "", TtmlNode.TAG_BODY, "[B", "getBody", "()[B", "setBody", "([B)V", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "request", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "getRequest", "()Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "setRequest", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;)V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpResponseException extends SdkBaseException {
    private byte[] body;
    private Headers headers;
    private HttpRequest request;
    private HttpStatusCode statusCode;

    public HttpResponseException() {
    }

    public HttpResponseException(String str) {
        super(str);
    }

    public HttpResponseException(String str, Throwable th) {
        super(str, th);
    }

    public HttpResponseException(Throwable th) {
        super(th);
    }

    public final HttpStatusCode getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(HttpStatusCode httpStatusCode) {
        this.statusCode = httpStatusCode;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final void setBody(byte[] bArr) {
        this.body = bArr;
    }

    public final HttpRequest getRequest() {
        return this.request;
    }

    public final void setRequest(HttpRequest httpRequest) {
        this.request = httpRequest;
    }
}
