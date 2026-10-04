package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.HttpStatusCodeKt;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import aws.smithy.kotlin.runtime.retries.policy.StandardRetryPolicy;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ImdsRetryPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/ImdsRetryPolicy;", "Laws/smithy/kotlin/runtime/retries/policy/StandardRetryPolicy;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "evaluateSpecificExceptions", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective$RetryError;", "ex", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImdsRetryPolicy extends StandardRetryPolicy {
    private final CoroutineContext callContext;

    public ImdsRetryPolicy(CoroutineContext callContext) {
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        this.callContext = callContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // aws.smithy.kotlin.runtime.retries.policy.StandardRetryPolicy
    public RetryDirective.RetryError evaluateSpecificExceptions(final Throwable ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        if (!(ex instanceof EC2MetadataError)) {
            return null;
        }
        final HttpStatusCode status = ((EC2MetadataError) ex).getStatus();
        if (HttpStatusCodeKt.category(status) != HttpStatusCode.Category.SERVER_ERROR && !Intrinsics.areEqual(status, HttpStatusCode.INSTANCE.getUnauthorized())) {
            CoroutineContext coroutineContext = this.callContext;
            String qualifiedName = Reflection.getOrCreateKotlinClass(ImdsRetryPolicy.class).getQualifiedName();
            if (qualifiedName != null) {
                Logger.debug$default(CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName), null, new Function0() { // from class: aws.sdk.kotlin.runtime.config.imds.ImdsRetryPolicy$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ImdsRetryPolicy.evaluateSpecificExceptions$lambda$0(status, ex);
                    }
                }, 1, null);
                return null;
            }
            throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
        }
        return new RetryDirective.RetryError(RetryErrorType.ServerSide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String evaluateSpecificExceptions$lambda$0(HttpStatusCode httpStatusCode, Throwable th) {
        return "IMDS error: statusCode=" + httpStatusCode + "; " + ((EC2MetadataError) th).getMessage();
    }
}
