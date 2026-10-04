package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.SdkBaseException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StandardRetryPolicy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class StandardRetryPolicy$evaluationStrategies$4 extends FunctionReferenceImpl implements Function1<SdkBaseException, RetryDirective> {
    StandardRetryPolicy$evaluationStrategies$4(Object obj) {
        super(1, obj, StandardRetryPolicy.class, "evaluateBaseException", "evaluateBaseException(Laws/smithy/kotlin/runtime/SdkBaseException;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final RetryDirective invoke(SdkBaseException p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((StandardRetryPolicy) this.receiver).evaluateBaseException(p0);
    }
}
