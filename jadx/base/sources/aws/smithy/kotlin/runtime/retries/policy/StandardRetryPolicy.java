package aws.smithy.kotlin.runtime.retries.policy;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.ErrorMetadata;
import aws.smithy.kotlin.runtime.SdkBaseException;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import aws.smithy.kotlin.runtime.retries.policy.EvaluationStrategy;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: StandardRetryPolicy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001d2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0016\u0010\fR1\u0010\u001b\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u0015\b\u0001\u0012\u00110\n¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u000b0\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/StandardRetryPolicy;", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "", "<init>", "()V", "Lkotlin/Result;", "result", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "evaluate", "(Ljava/lang/Object;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "", "ex", "(Ljava/lang/Throwable;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "Laws/smithy/kotlin/runtime/SdkBaseException;", "evaluateBaseException", "(Laws/smithy/kotlin/runtime/SdkBaseException;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "Laws/smithy/kotlin/runtime/ClientException;", "evaluateClientException", "(Laws/smithy/kotlin/runtime/ClientException;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "Laws/smithy/kotlin/runtime/ServiceException;", "evaluateServiceException", "(Laws/smithy/kotlin/runtime/ServiceException;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "evaluateSpecificExceptions", "Lkotlin/sequences/Sequence;", "Laws/smithy/kotlin/runtime/retries/policy/EvaluationStrategy;", "Lkotlin/ParameterName;", "name", "evaluationStrategies", "Lkotlin/sequences/Sequence;", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class StandardRetryPolicy implements RetryPolicy<Object> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final StandardRetryPolicy Default = new StandardRetryPolicy();
    private final Sequence<EvaluationStrategy<? extends Throwable>> evaluationStrategies;

    protected RetryDirective evaluateSpecificExceptions(Throwable ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        return null;
    }

    /* JADX INFO: compiled from: StandardRetryPolicy.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/StandardRetryPolicy$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/retries/policy/StandardRetryPolicy;", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/retries/policy/StandardRetryPolicy;", "getDefault", "()Laws/smithy/kotlin/runtime/retries/policy/StandardRetryPolicy;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StandardRetryPolicy getDefault() {
            return StandardRetryPolicy.Default;
        }
    }

    public StandardRetryPolicy() {
        EvaluationStrategy.Companion companion = EvaluationStrategy.INSTANCE;
        StandardRetryPolicy$evaluationStrategies$1 standardRetryPolicy$evaluationStrategies$1 = new StandardRetryPolicy$evaluationStrategies$1(this);
        EvaluationStrategy.Companion companion2 = EvaluationStrategy.INSTANCE;
        StandardRetryPolicy$evaluationStrategies$2 standardRetryPolicy$evaluationStrategies$2 = new StandardRetryPolicy$evaluationStrategies$2(this);
        EvaluationStrategy.Companion companion3 = EvaluationStrategy.INSTANCE;
        StandardRetryPolicy$evaluationStrategies$3 standardRetryPolicy$evaluationStrategies$3 = new StandardRetryPolicy$evaluationStrategies$3(this);
        EvaluationStrategy.Companion companion4 = EvaluationStrategy.INSTANCE;
        this.evaluationStrategies = SequencesKt.sequenceOf((Object[]) new EvaluationStrategy[]{new EvaluationStrategy(Reflection.getOrCreateKotlinClass(Throwable.class), standardRetryPolicy$evaluationStrategies$1), new EvaluationStrategy(Reflection.getOrCreateKotlinClass(ServiceException.class), standardRetryPolicy$evaluationStrategies$2), new EvaluationStrategy(Reflection.getOrCreateKotlinClass(ClientException.class), standardRetryPolicy$evaluationStrategies$3), new EvaluationStrategy(Reflection.getOrCreateKotlinClass(SdkBaseException.class), new StandardRetryPolicy$evaluationStrategies$4(this))});
    }

    @Override // aws.smithy.kotlin.runtime.retries.policy.RetryPolicy
    public RetryDirective evaluate(Object result) {
        if (Result.m14506isSuccessimpl(result)) {
            return RetryDirective.TerminateAndSucceed.INSTANCE;
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(result);
        Intrinsics.checkNotNull(thM14502exceptionOrNullimpl);
        return evaluate(thM14502exceptionOrNullimpl);
    }

    private final RetryDirective evaluate(Throwable ex) {
        RetryDirective retryDirectiveEvaluate;
        Iterator<EvaluationStrategy<? extends Throwable>> it = this.evaluationStrategies.iterator();
        while (true) {
            if (!it.hasNext()) {
                retryDirectiveEvaluate = null;
                break;
            }
            retryDirectiveEvaluate = it.next().evaluate(ex);
            if (retryDirectiveEvaluate != null) {
                break;
            }
        }
        return retryDirectiveEvaluate == null ? RetryDirective.TerminateAndFail.INSTANCE : retryDirectiveEvaluate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RetryDirective evaluateBaseException(SdkBaseException ex) {
        RetryDirective.RetryError retryError;
        ErrorMetadata sdkErrorMetadata = ex.getSdkErrorMetadata();
        if (sdkErrorMetadata.isThrottling()) {
            retryError = new RetryDirective.RetryError(RetryErrorType.Throttling);
        } else {
            retryError = sdkErrorMetadata.isRetryable() ? new RetryDirective.RetryError(RetryErrorType.Transient) : null;
        }
        return retryError;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RetryDirective evaluateClientException(ClientException ex) {
        if (ex.getSdkErrorMetadata().isRetryable()) {
            return new RetryDirective.RetryError(RetryErrorType.ClientSide);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RetryDirective evaluateServiceException(ServiceException ex) {
        RetryDirective.RetryError retryError;
        ServiceErrorMetadata sdkErrorMetadata = ex.getSdkErrorMetadata();
        if (sdkErrorMetadata.isRetryable() && sdkErrorMetadata.getErrorType() == ServiceException.ErrorType.Server) {
            retryError = new RetryDirective.RetryError(RetryErrorType.ServerSide);
        } else {
            retryError = (sdkErrorMetadata.isRetryable() && sdkErrorMetadata.getErrorType() == ServiceException.ErrorType.Client) ? new RetryDirective.RetryError(RetryErrorType.ClientSide) : null;
        }
        return retryError;
    }
}
