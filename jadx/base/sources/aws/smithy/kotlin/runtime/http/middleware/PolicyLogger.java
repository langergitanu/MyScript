package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: RetryMiddleware.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/middleware/PolicyLogger;", "O", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "policy", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlin/Result;", "result", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "evaluate", "(Ljava/lang/Object;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "Lkotlin/coroutines/CoroutineContext;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class PolicyLogger<O> implements RetryPolicy<O> {
    private final CoroutineContext coroutineContext;
    private final RetryPolicy<O> policy;

    /* JADX WARN: Multi-variable type inference failed */
    public PolicyLogger(RetryPolicy<? super O> policy, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.policy = policy;
        this.coroutineContext = coroutineContext;
    }

    @Override // aws.smithy.kotlin.runtime.retries.policy.RetryPolicy
    public RetryDirective evaluate(Object result) {
        RetryDirective retryDirectiveEvaluate = this.policy.evaluate(result);
        if (!(retryDirectiveEvaluate instanceof RetryDirective.TerminateAndFail)) {
            return retryDirectiveEvaluate;
        }
        CoroutineContext coroutineContext = this.coroutineContext;
        Function0 function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.http.middleware.PolicyLogger$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PolicyLogger.evaluate$lambda$0$0();
            }
        };
        LogLevel logLevel = LogLevel.Debug;
        String qualifiedName = Reflection.getOrCreateKotlinClass(RetryMiddleware.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        CoroutineContextLogExtKt.log(coroutineContext, logLevel, qualifiedName, null, function0);
        return retryDirectiveEvaluate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String evaluate$lambda$0$0() {
        return "request failed with non-retryable error";
    }
}
