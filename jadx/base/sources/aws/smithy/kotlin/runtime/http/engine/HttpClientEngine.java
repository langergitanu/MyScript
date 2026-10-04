package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HttpClientEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "Lkotlinx/coroutines/CoroutineScope;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "request", "Laws/smithy/kotlin/runtime/http/HttpCall;", "roundTrip", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig;", "getConfig", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig;", "config", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HttpClientEngine extends CoroutineScope {
    HttpClientEngineConfig getConfig();

    Object roundTrip(ExecutionContext executionContext, HttpRequest httpRequest, Continuation<? super HttpCall> continuation);
}
