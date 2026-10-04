package aws.smithy.kotlin.runtime.client.region;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: RegionProviderChain.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class RegionProviderChain$resolvedRegion$1 extends FunctionReferenceImpl implements Function1<Continuation<? super String>, Object>, SuspendFunction {
    RegionProviderChain$resolvedRegion$1(Object obj) {
        super(1, obj, RegionProviderChain.class, "resolveRegion", "resolveRegion(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super String> continuation) {
        return ((RegionProviderChain) this.receiver).resolveRegion(continuation);
    }
}
