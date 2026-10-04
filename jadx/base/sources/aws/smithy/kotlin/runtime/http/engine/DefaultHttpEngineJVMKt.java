package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DefaultHttpEngineJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u00012\u0019\u0010\u0002\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006H\u0000¨\u0006\u0007"}, m1599d2 = {"newDefaultHttpEngine", "Laws/smithy/kotlin/runtime/http/engine/CloseableHttpClientEngine;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "http-client-engine-default"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultHttpEngineJVMKt {
    public static final CloseableHttpClientEngine newDefaultHttpEngine(Function1<? super HttpClientEngineConfig.Builder, Unit> function1) {
        if (function1 != null) {
            return OkHttpEngine.INSTANCE.invoke(function1);
        }
        return new OkHttpEngine();
    }
}
