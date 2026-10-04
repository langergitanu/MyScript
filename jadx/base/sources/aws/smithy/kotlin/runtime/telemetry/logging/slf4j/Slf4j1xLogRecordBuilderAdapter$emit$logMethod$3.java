package aws.smithy.kotlin.runtime.telemetry.logging.slf4j;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Slf4j1xLoggerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class Slf4j1xLogRecordBuilderAdapter$emit$logMethod$3 extends FunctionReferenceImpl implements Function2<Throwable, Function0<? extends String>, Unit> {
    Slf4j1xLogRecordBuilderAdapter$emit$logMethod$3(Object obj) {
        super(2, obj, Slf4j1xLoggerAdapter.class, "info", "info(Ljava/lang/Throwable;Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th, Function0<? extends String> function0) {
        invoke2(th, (Function0<String>) function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th, Function0<String> p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((Slf4j1xLoggerAdapter) this.receiver).info(th, p1);
    }
}
