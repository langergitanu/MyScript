package aws.sdk.kotlin.runtime.region;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: ImdsRegionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class ImdsRegionProvider$resolvedRegion$1 extends FunctionReferenceImpl implements Function1<Continuation<? super String>, Object>, SuspendFunction {
    ImdsRegionProvider$resolvedRegion$1(Object obj) {
        super(1, obj, ImdsRegionProvider.class, "loadRegion", "loadRegion(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super String> continuation) {
        return ((ImdsRegionProvider) this.receiver).loadRegion(continuation);
    }
}
