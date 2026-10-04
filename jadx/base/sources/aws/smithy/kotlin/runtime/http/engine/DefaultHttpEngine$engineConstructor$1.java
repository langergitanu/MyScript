package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: DefaultHttpEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class DefaultHttpEngine$engineConstructor$1 extends FunctionReferenceImpl implements Function1<Function1<? super HttpClientEngineConfig.Builder, ? extends Unit>, CloseableHttpClientEngine> {
    public static final DefaultHttpEngine$engineConstructor$1 INSTANCE = new DefaultHttpEngine$engineConstructor$1();

    DefaultHttpEngine$engineConstructor$1() {
        super(1, DefaultHttpEngineKt.class, "DefaultHttpEngine", "DefaultHttpEngine(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/http/engine/CloseableHttpClientEngine;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CloseableHttpClientEngine invoke2(Function1<? super HttpClientEngineConfig.Builder, Unit> function1) {
        return DefaultHttpEngineKt.DefaultHttpEngine(function1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CloseableHttpClientEngine invoke(Function1<? super HttpClientEngineConfig.Builder, ? extends Unit> function1) {
        return invoke2((Function1<? super HttpClientEngineConfig.Builder, Unit>) function1);
    }
}
