package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine;
import aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OkHttpEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class OkHttpEngine$Companion$engineConstructor$1 extends FunctionReferenceImpl implements Function1<Function1<? super OkHttpEngineConfig.Builder, ? extends Unit>, OkHttpEngine> {
    OkHttpEngine$Companion$engineConstructor$1(Object obj) {
        super(1, obj, OkHttpEngine.Companion.class, "invoke", "invoke(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngine;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final OkHttpEngine invoke2(Function1<? super OkHttpEngineConfig.Builder, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((OkHttpEngine.Companion) this.receiver).invoke(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ OkHttpEngine invoke(Function1<? super OkHttpEngineConfig.Builder, ? extends Unit> function1) {
        return invoke2((Function1<? super OkHttpEngineConfig.Builder, Unit>) function1);
    }
}
