package aws.smithy.kotlin.runtime.http.operation;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpSerde.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u0003*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0003\u0004\u0005\u0082\u0001\u0002\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", ExifInterface.GPS_DIRECTION_TRUE, "", "Companion", "Streaming", "NonStreaming", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$NonStreaming;", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$Streaming;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HttpDeserializer<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: HttpSerde.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002J)\u0010\t\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$NonStreaming;", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/http/HttpCall;", NotificationCompat.CATEGORY_CALL, "", "payload", "deserialize", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/HttpCall;[B)Ljava/lang/Object;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface NonStreaming<T> extends HttpDeserializer<T> {
        T deserialize(ExecutionContext context, HttpCall call, byte[] payload);
    }

    /* JADX INFO: compiled from: HttpSerde.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002J \u0010\u0007\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$Streaming;", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/http/HttpCall;", NotificationCompat.CATEGORY_CALL, "deserialize", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/HttpCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Streaming<T> extends HttpDeserializer<T> {
        Object deserialize(ExecutionContext executionContext, HttpCall httpCall, Continuation<? super T> continuation);
    }

    /* JADX INFO: compiled from: HttpSerde.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Identity", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "getIdentity", "()Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "", "Unit", "getUnit", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final HttpDeserializer<HttpResponse> Identity = new NonStreaming<HttpResponse>() { // from class: aws.smithy.kotlin.runtime.http.operation.HttpDeserializer$Companion$Identity$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserializer.NonStreaming
            public HttpResponse deserialize(ExecutionContext context, HttpCall call, byte[] payload) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(call, "call");
                return call.getResponse();
            }
        };
        private static final HttpDeserializer<Unit> Unit = new NonStreaming<Unit>() { // from class: aws.smithy.kotlin.runtime.http.operation.HttpDeserializer$Companion$Unit$1
            /* JADX INFO: renamed from: deserialize, reason: avoid collision after fix types in other method */
            public void deserialize2(ExecutionContext context, HttpCall call, byte[] payload) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(call, "call");
            }

            @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserializer.NonStreaming
            public /* bridge */ /* synthetic */ Unit deserialize(ExecutionContext executionContext, HttpCall httpCall, byte[] bArr) {
                deserialize2(executionContext, httpCall, bArr);
                return Unit.INSTANCE;
            }
        };

        private Companion() {
        }

        public final HttpDeserializer<HttpResponse> getIdentity() {
            return Identity;
        }

        public final HttpDeserializer<Unit> getUnit() {
            return Unit;
        }
    }
}
