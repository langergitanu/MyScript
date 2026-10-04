package aws.smithy.kotlin.runtime.http.engine.okhttp;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelKt;
import aws.smithy.kotlin.runtime.p011io.internal.ConvertKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.util.CoroutineUtilsKt;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.p039io.CloseableKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Source;
import org.apache.commons.codec.binary.BaseNCodec;

/* JADX INFO: compiled from: StreamingRequestBody.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/StreamingRequestBody;", "Lokhttp3/RequestBody;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/http/HttpBody;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Laws/smithy/kotlin/runtime/http/HttpBody;Lkotlin/coroutines/CoroutineContext;)V", "contentType", "Lokhttp3/MediaType;", "contentLength", "", "isOneShot", "", "isDuplex", "writeTo", "", "sink", "Lokio/BufferedSink;", "doWriteTo", "transferBody", "(Lokio/BufferedSink;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StreamingRequestBody extends RequestBody {
    private final HttpBody body;
    private final CoroutineContext callContext;

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType */
    public MediaType getContentType() {
        return null;
    }

    public StreamingRequestBody(HttpBody body, CoroutineContext callContext) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        this.body = body;
        this.callContext = callContext;
        if (!(body instanceof HttpBody.ChannelContent) && !(body instanceof HttpBody.SourceContent)) {
            throw new IllegalArgumentException(("Invalid streaming body " + body).toString());
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        Long contentLength = this.body.getContentLength();
        if (contentLength != null) {
            return contentLength.longValue();
        }
        return -1L;
    }

    @Override // okhttp3.RequestBody
    public boolean isOneShot() {
        return this.body.getIsOneShot();
    }

    @Override // okhttp3.RequestBody
    public boolean isDuplex() {
        return this.body.getIsDuplex();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws Exception {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            doWriteTo(sink);
        } catch (Exception e) {
            if (e instanceof CancellationException) {
                CoroutineContext coroutineContext = this.callContext;
                Function0 function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StreamingRequestBody.writeTo$lambda$0();
                    }
                };
                LogLevel logLevel = LogLevel.Trace;
                String qualifiedName = Reflection.getOrCreateKotlinClass(StreamingRequestBody.class).getQualifiedName();
                if (qualifiedName == null) {
                    throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                }
                CoroutineContextLogExtKt.log(coroutineContext, logLevel, qualifiedName, null, function0);
                return;
            }
            if (!(e instanceof IOException)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String writeTo$lambda$0() {
        return "request cancelled";
    }

    private final void doWriteTo(BufferedSink sink) throws InterruptedException {
        CoroutineContext coroutineContext = this.callContext;
        CoroutineContext coroutineContextPlus = coroutineContext.plus(CoroutineUtilsKt.derivedName(coroutineContext, "send-request-body"));
        if (isDuplex()) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, coroutineContextPlus.plus(Dispatchers.getIO()), null, new C37071(sink, this, null), 2, null);
        } else {
            BuildersKt.runBlocking(coroutineContextPlus.minusKey(CoroutineDispatcher.INSTANCE), new C37082(sink, null));
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody$doWriteTo$1 */
    /* JADX INFO: compiled from: StreamingRequestBody.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody$doWriteTo$1", m1609f = "StreamingRequestBody.kt", m1610i = {0, 0}, m1611l = {64}, m1612m = "invokeSuspend", m1613n = {"it", "$i$a$-use-StreamingRequestBody$doWriteTo$1$1"}, m1614nl = {64}, m1615s = {"L$1", "I$0"}, m1616v = 2)
    static final class C37071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BufferedSink $sink;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ StreamingRequestBody this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37071(BufferedSink bufferedSink, StreamingRequestBody streamingRequestBody, Continuation<? super C37071> continuation) {
            super(2, continuation);
            this.$sink = bufferedSink;
            this.this$0 = streamingRequestBody;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C37071(this.$sink, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C37071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Closeable closeable;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BufferedSink bufferedSink = this.$sink;
                StreamingRequestBody streamingRequestBody = this.this$0;
                try {
                    BufferedSink bufferedSink2 = bufferedSink;
                    this.L$0 = bufferedSink;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(bufferedSink2);
                    this.I$0 = 0;
                    this.label = 1;
                    if (streamingRequestBody.transferBody(bufferedSink2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeable = bufferedSink;
                } catch (Throwable th2) {
                    closeable = bufferedSink;
                    th = th2;
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(closeable, th);
                        throw th4;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(closeable, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody$doWriteTo$2 */
    /* JADX INFO: compiled from: StreamingRequestBody.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody$doWriteTo$2", m1609f = "StreamingRequestBody.kt", m1610i = {}, m1611l = {BaseNCodec.MIME_CHUNK_SIZE}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {77}, m1615s = {}, m1616v = 2)
    static final class C37082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BufferedSink $sink;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37082(BufferedSink bufferedSink, Continuation<? super C37082> continuation) {
            super(2, continuation);
            this.$sink = bufferedSink;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StreamingRequestBody.this.new C37082(this.$sink, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C37082) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (StreamingRequestBody.this.transferBody(this.$sink, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object transferBody(BufferedSink bufferedSink, Continuation<? super Unit> continuation) {
        HttpBody httpBody = this.body;
        if (httpBody instanceof HttpBody.ChannelContent) {
            Object all = SdkByteReadChannelKt.readAll(((HttpBody.ChannelContent) httpBody).get$ch(), ConvertKt.toSdk(bufferedSink), continuation);
            return all == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? all : Unit.INSTANCE;
        }
        if (httpBody instanceof HttpBody.SourceContent) {
            Source okio2 = ConvertKt.toOkio(((HttpBody.SourceContent) httpBody).get$this_toHttpBody());
            try {
                bufferedSink.writeAll(okio2);
                CloseableKt.closeFinally(okio2, null);
                return Unit.INSTANCE;
            } finally {
            }
        } else {
            throw new IllegalStateException(("unexpected HttpBody type " + this.body).toString());
        }
    }
}
