package aws.sdk.kotlin.runtime.config.imds;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpStatusCodeKt;
import aws.smithy.kotlin.runtime.http.operation.HttpDeserializer;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ImdsClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m1599d2 = {"aws/sdk/kotlin/runtime/config/imds/ImdsClient$get$op$1$1", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$NonStreaming;", "", "deserialize", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImdsClient$get$op$1$1 implements HttpDeserializer.NonStreaming<String> {
    final /* synthetic */ Logger $logger;

    ImdsClient$get$op$1$1(Logger logger) {
        this.$logger = logger;
    }

    @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserializer.NonStreaming
    public String deserialize(ExecutionContext context, final HttpCall call, byte[] payload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(call, "call");
        HttpResponse response = call.getResponse();
        Logger.trace$default(this.$logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.config.imds.ImdsClient$get$op$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImdsClientKt.toTraceString(call);
            }
        }, 1, null);
        if (HttpStatusCodeKt.isSuccess(response.getStatus())) {
            Intrinsics.checkNotNull(payload);
            return StringsKt.decodeToString(payload);
        }
        throw new EC2MetadataError(response.getStatus(), "error retrieving instance metadata: " + response.getStatus().getDescription());
    }
}
