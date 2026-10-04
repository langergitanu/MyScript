package aws.sdk.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext;
import aws.smithy.kotlin.runtime.client.config.ResponseHttpChecksumConfig;
import aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsResponseInterceptor;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: IgnoreCompositeFlexibleChecksumResponseInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\fH\u0016¨\u0006\u0010"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/interceptors/IgnoreCompositeFlexibleChecksumResponseInterceptor;", "Laws/smithy/kotlin/runtime/http/interceptors/FlexibleChecksumsResponseInterceptor;", "responseValidationRequired", "", "responseChecksumValidation", "Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "<init>", "(ZLaws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;)V", "ignoreChecksum", "checksum", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class IgnoreCompositeFlexibleChecksumResponseInterceptor extends FlexibleChecksumsResponseInterceptor {
    public IgnoreCompositeFlexibleChecksumResponseInterceptor(boolean z, ResponseHttpChecksumConfig responseHttpChecksumConfig) {
        super(z, responseHttpChecksumConfig);
    }

    @Override // aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsResponseInterceptor
    public boolean ignoreChecksum(String checksum, ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> context) {
        Intrinsics.checkNotNullParameter(checksum, "checksum");
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zIsCompositeChecksum = IgnoreCompositeFlexibleChecksumResponseInterceptorKt.isCompositeChecksum(checksum);
        if (!zIsCompositeChecksum) {
            return zIsCompositeChecksum;
        }
        CoroutineContext coroutineContext = context.getExecutionContext().getCoroutineContext();
        Function0 function0 = new Function0() { // from class: aws.sdk.kotlin.runtime.http.interceptors.IgnoreCompositeFlexibleChecksumResponseInterceptor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IgnoreCompositeFlexibleChecksumResponseInterceptor.ignoreChecksum$lambda$0$0();
            }
        };
        LogLevel logLevel = LogLevel.Info;
        String qualifiedName = Reflection.getOrCreateKotlinClass(IgnoreCompositeFlexibleChecksumResponseInterceptor.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        CoroutineContextLogExtKt.log(coroutineContext, logLevel, qualifiedName, null, function0);
        return zIsCompositeChecksum;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ignoreChecksum$lambda$0$0() {
        return "Checksum validation was skipped because it was a composite checksum";
    }
}
