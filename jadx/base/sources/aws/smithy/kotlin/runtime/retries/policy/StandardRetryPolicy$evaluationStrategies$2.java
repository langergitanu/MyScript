package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.ServiceException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StandardRetryPolicy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class StandardRetryPolicy$evaluationStrategies$2 extends FunctionReferenceImpl implements Function1<ServiceException, RetryDirective> {
    StandardRetryPolicy$evaluationStrategies$2(Object obj) {
        super(1, obj, StandardRetryPolicy.class, "evaluateServiceException", "evaluateServiceException(Laws/smithy/kotlin/runtime/ServiceException;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final RetryDirective invoke(ServiceException p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((StandardRetryPolicy) this.receiver).evaluateServiceException(p0);
    }
}
