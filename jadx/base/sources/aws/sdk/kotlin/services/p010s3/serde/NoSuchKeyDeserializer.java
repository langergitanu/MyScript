package aws.sdk.kotlin.services.p010s3.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.model.NoSuchKey;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.operation.HttpDeserializer;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoSuchKeyDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/NoSuchKeyDeserializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$NonStreaming;", "Laws/sdk/kotlin/services/s3/model/NoSuchKey;", "<init>", "()V", "deserialize", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoSuchKeyDeserializer implements HttpDeserializer.NonStreaming<NoSuchKey> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserializer.NonStreaming
    public NoSuchKey deserialize(ExecutionContext context, HttpCall call, byte[] payload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(call, "call");
        call.getResponse();
        NoSuchKey.Builder builder = new NoSuchKey.Builder();
        builder.correctErrors$s3();
        return builder.build();
    }
}
