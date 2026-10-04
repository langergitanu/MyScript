package aws.smithy.kotlin.runtime.http.operation;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpSerde.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u0003*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0003\u0004\u0005\u0082\u0001\u0002\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "", "Companion", "Streaming", "NonStreaming", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$NonStreaming;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$Streaming;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HttpSerializer<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: HttpSerde.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$NonStreaming;", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "input", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "serialize", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Ljava/lang/Object;)Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface NonStreaming<T> extends HttpSerializer<T> {
        HttpRequestBuilder serialize(ExecutionContext context, T input);
    }

    /* JADX INFO: compiled from: HttpSerde.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0001H¦@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$Streaming;", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "input", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "serialize", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Streaming<T> extends HttpSerializer<T> {
        Object serialize(ExecutionContext executionContext, T t, Continuation<? super HttpRequestBuilder> continuation);
    }

    /* JADX INFO: compiled from: HttpSerde.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "", "Unit", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "getUnit", "()Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final HttpSerializer<Unit> Unit = new NonStreaming<Unit>() { // from class: aws.smithy.kotlin.runtime.http.operation.HttpSerializer$Companion$Unit$1
            @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerializer.NonStreaming
            public HttpRequestBuilder serialize(ExecutionContext context, Unit input) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(input, "input");
                return new HttpRequestBuilder();
            }
        };

        private Companion() {
        }

        public final HttpSerializer<Unit> getUnit() {
            return Unit;
        }
    }
}
