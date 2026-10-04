package aws.smithy.kotlin.runtime.http.response;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: HttpResponseBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001e\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b!J\u001d\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0083\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004J\n\u0010(\u001a\u00020\u001bHÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006)"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/response/HttpResponseBuilderView;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "builder", "Laws/smithy/kotlin/runtime/http/response/HttpResponseBuilder;", "allowToBuilder", "", "<init>", "(Laws/smithy/kotlin/runtime/http/response/HttpResponseBuilder;Z)V", "getBuilder$http", "()Laws/smithy/kotlin/runtime/http/response/HttpResponseBuilder;", "getAllowToBuilder$http", "()Z", NotificationCompat.CATEGORY_STATUS, "Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "getStatus", "()Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "headers", "Laws/smithy/kotlin/runtime/http/Headers;", "getHeaders", "()Laws/smithy/kotlin/runtime/http/Headers;", "headers$delegate", "Lkotlin/Lazy;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/http/HttpBody;", "getBody", "()Laws/smithy/kotlin/runtime/http/HttpBody;", "summary", "", "getSummary", "()Ljava/lang/String;", "component1", "component1$http", "component2", "component2$http", "copy", "equals", "other", "", "hashCode", "", "toString", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class HttpResponseBuilderView implements HttpResponse {
    private final boolean allowToBuilder;
    private final HttpBody body;
    private final HttpResponseBuilder builder;

    /* JADX INFO: renamed from: headers$delegate, reason: from kotlin metadata */
    private final Lazy headers;
    private final HttpStatusCode status;
    private final String summary;

    public static /* synthetic */ HttpResponseBuilderView copy$default(HttpResponseBuilderView httpResponseBuilderView, HttpResponseBuilder httpResponseBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            httpResponseBuilder = httpResponseBuilderView.builder;
        }
        if ((i & 2) != 0) {
            z = httpResponseBuilderView.allowToBuilder;
        }
        return httpResponseBuilderView.copy(httpResponseBuilder, z);
    }

    /* JADX INFO: renamed from: component1$http, reason: from getter */
    public final HttpResponseBuilder getBuilder() {
        return this.builder;
    }

    /* JADX INFO: renamed from: component2$http, reason: from getter */
    public final boolean getAllowToBuilder() {
        return this.allowToBuilder;
    }

    public final HttpResponseBuilderView copy(HttpResponseBuilder builder, boolean allowToBuilder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return new HttpResponseBuilderView(builder, allowToBuilder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpResponseBuilderView)) {
            return false;
        }
        HttpResponseBuilderView httpResponseBuilderView = (HttpResponseBuilderView) other;
        return Intrinsics.areEqual(this.builder, httpResponseBuilderView.builder) && this.allowToBuilder == httpResponseBuilderView.allowToBuilder;
    }

    public int hashCode() {
        return (this.builder.hashCode() * 31) + Boolean.hashCode(this.allowToBuilder);
    }

    public String toString() {
        return "HttpResponseBuilderView(builder=" + this.builder + ", allowToBuilder=" + this.allowToBuilder + ')';
    }

    public HttpResponseBuilderView(HttpResponseBuilder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.allowToBuilder = z;
        this.status = builder.getStatus();
        this.headers = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.http.response.HttpResponseBuilderView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HttpResponseBuilderView.headers_delegate$lambda$0(this.f$0);
            }
        });
        this.body = builder.getBody();
        this.summary = "HTTP " + getStatus().getValue() + TokenParser.f2383SP + getStatus().getDescription();
    }

    public final HttpResponseBuilder getBuilder$http() {
        return this.builder;
    }

    public final boolean getAllowToBuilder$http() {
        return this.allowToBuilder;
    }

    @Override // aws.smithy.kotlin.runtime.http.response.HttpResponse
    public HttpStatusCode getStatus() {
        return this.status;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v3, types: [aws.smithy.kotlin.runtime.http.Headers] */
    public static final Headers headers_delegate$lambda$0(HttpResponseBuilderView httpResponseBuilderView) {
        return httpResponseBuilderView.builder.getHeaders().build();
    }

    @Override // aws.smithy.kotlin.runtime.http.response.HttpResponse
    public Headers getHeaders() {
        return (Headers) this.headers.getValue();
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
