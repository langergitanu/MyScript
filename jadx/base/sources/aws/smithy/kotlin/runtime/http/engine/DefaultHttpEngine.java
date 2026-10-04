package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.http.config.EngineFactory;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DefaultHttpEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R1\u0010\u0006\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/DefaultHttpEngine;", "Laws/smithy/kotlin/runtime/http/config/EngineFactory;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "<init>", "()V", "engineConstructor", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "getEngineConstructor", "()Lkotlin/jvm/functions/Function1;", "http-client-engine-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultHttpEngine implements EngineFactory<HttpClientEngineConfig.Builder, HttpClientEngine> {
    public static final DefaultHttpEngine INSTANCE = new DefaultHttpEngine();
    private static final Function1<Function1<? super HttpClientEngineConfig.Builder, Unit>, HttpClientEngine> engineConstructor = DefaultHttpEngine$engineConstructor$1.INSTANCE;

    private DefaultHttpEngine() {
    }

    @Override // aws.smithy.kotlin.runtime.http.config.EngineFactory
    public Function1<Function1<? super HttpClientEngineConfig.Builder, Unit>, HttpClientEngine> getEngineConstructor() {
        return engineConstructor;
    }
}
