package aws.sdk.kotlin.runtime.auth.credentials;

import aws.smithy.kotlin.runtime.http.operation.HttpSerializer;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: EcsCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/EcsCredentialsSerializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$NonStreaming;", "", "authToken", "", "<init>", "(Ljava/lang/String;)V", "serialize", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Lkotlin/Unit;)Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class EcsCredentialsSerializer implements HttpSerializer.NonStreaming<Unit> {
    private final String authToken;

    /* JADX WARN: Multi-variable type inference failed */
    public EcsCredentialsSerializer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public EcsCredentialsSerializer(String str) {
        this.authToken = str;
    }

    public /* synthetic */ EcsCredentialsSerializer(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerializer.NonStreaming
    public HttpRequestBuilder serialize(ExecutionContext context, Unit input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.getUrl().getPath();
        HttpRequestBuilderKt.header(httpRequestBuilder, "Accept", "application/json");
        HttpRequestBuilderKt.header(httpRequestBuilder, "Accept-Encoding", HTTP.IDENTITY_CODING);
        String str = this.authToken;
        if (str != null) {
            HttpRequestBuilderKt.header(httpRequestBuilder, "Authorization", str);
        }
        return httpRequestBuilder;
    }
}
