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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0001\u0002\u0017\u0018¨\u0006\u0019À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "", FirebaseAnalytics.Param.METHOD, "Laws/smithy/kotlin/runtime/http/HttpMethod;", "getMethod", "()Laws/smithy/kotlin/runtime/http/HttpMethod;", ImagesContract.URL, "Laws/smithy/kotlin/runtime/net/url/Url;", "getUrl", "()Laws/smithy/kotlin/runtime/net/url/Url;", "headers", "Laws/smithy/kotlin/runtime/http/Headers;", "getHeaders", "()Laws/smithy/kotlin/runtime/http/Headers;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/http/HttpBody;", "getBody", "()Laws/smithy/kotlin/runtime/http/HttpBody;", "trailingHeaders", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "getTrailingHeaders", "()Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "Companion", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilderView;", "Laws/smithy/kotlin/runtime/http/request/RealHttpRequest;", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HttpRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    HttpBody getBody();

    Headers getHeaders();

    HttpMethod getMethod();

    DeferredHeaders getTrailingHeaders();

    Url getUrl();

    /* JADX INFO: compiled from: HttpRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/request/HttpRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final HttpRequest invoke(Function1<? super HttpRequestBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            block.invoke(httpRequestBuilder);
            return httpRequestBuilder.build();
        }
    }
}
