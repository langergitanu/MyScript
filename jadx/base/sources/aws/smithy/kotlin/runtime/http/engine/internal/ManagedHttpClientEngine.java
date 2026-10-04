package aws.smithy.kotlin.runtime.http.engine.internal;

import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.engine.CloseableHttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.SdkManagedCloseable;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManagedHttpClientEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096A¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/internal/ManagedHttpClientEngine;", "Laws/smithy/kotlin/runtime/io/SdkManagedCloseable;", "Laws/smithy/kotlin/runtime/http/engine/CloseableHttpClientEngine;", "delegate", "<init>", "(Laws/smithy/kotlin/runtime/http/engine/CloseableHttpClientEngine;)V", "", "close", "()V", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "request", "Laws/smithy/kotlin/runtime/http/HttpCall;", "roundTrip", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/http/engine/CloseableHttpClientEngine;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig;", "getConfig", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig;", "config", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class ManagedHttpClientEngine extends SdkManagedCloseable implements CloseableHttpClientEngine {
    private final CloseableHttpClientEngine delegate;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngine
    public HttpClientEngineConfig getConfig() {
        return this.delegate.getConfig();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.delegate.getCoroutineContext();
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngine
    public Object roundTrip(ExecutionContext executionContext, HttpRequest httpRequest, Continuation<? super HttpCall> continuation) {
        return this.delegate.roundTrip(executionContext, httpRequest, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManagedHttpClientEngine(CloseableHttpClientEngine delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }
}
