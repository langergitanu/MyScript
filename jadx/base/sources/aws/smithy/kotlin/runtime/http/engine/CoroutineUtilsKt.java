package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContext;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContextKt;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElement;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElementKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LoggingContextElement;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: CoroutineUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0010\u0010\n\u001a\u00020\u0001H\u0087@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "Lkotlin/coroutines/CoroutineContext;", "outerContext", "createCallContext", "(Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/Job;", "requestJob", "", "attachToOuterJob", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/Job;)V", "callContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CoroutineUtilsKt {
    public static final CoroutineContext createCallContext(HttpClientEngine httpClientEngine, CoroutineContext outerContext) {
        Intrinsics.checkNotNullParameter(httpClientEngine, "<this>");
        Intrinsics.checkNotNullParameter(outerContext, "outerContext");
        CompletableJob completableJobJob = JobKt.Job((Job) httpClientEngine.getCoroutineContext().get(Job.INSTANCE));
        CoroutineContext coroutineContextPlus = httpClientEngine.getCoroutineContext().plus(completableJobJob).plus(new CoroutineName("call-context")).plus(new TelemetryProviderContext(TelemetryProviderContextKt.getTelemetryProvider(outerContext))).plus(new LoggingContextElement((Map<String, ? extends Object>) CoroutineContextLogExtKt.getLoggingContext(outerContext)));
        Context telemetryContext = TelemetryContextElementKt.getTelemetryContext(outerContext);
        CoroutineContext coroutineContextPlus2 = coroutineContextPlus.plus(telemetryContext != null ? new TelemetryContextElement(telemetryContext) : EmptyCoroutineContext.INSTANCE);
        attachToOuterJob(outerContext, completableJobJob);
        return coroutineContextPlus2;
    }

    private static final void attachToOuterJob(CoroutineContext coroutineContext, final Job job) {
        Job job2 = (Job) coroutineContext.get(Job.INSTANCE);
        if (job2 == null) {
            return;
        }
        final DisposableHandle disposableHandleInvokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job2, true, false, new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.CoroutineUtilsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoroutineUtilsKt.attachToOuterJob$lambda$0(job, (Throwable) obj);
            }
        }, 2, null);
        job.invokeOnCompletion(new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.CoroutineUtilsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoroutineUtilsKt.attachToOuterJob$lambda$1(disposableHandleInvokeOnCompletion$default, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachToOuterJob$lambda$0(Job job, Throwable th) {
        if (th == null) {
            return Unit.INSTANCE;
        }
        job.cancel(ExceptionsKt.CancellationException(th.getMessage(), th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachToOuterJob$lambda$1(DisposableHandle disposableHandle, Throwable th) {
        disposableHandle.dispose();
        return Unit.INSTANCE;
    }

    @InternalApi
    public static final Object callContext(Continuation<? super CoroutineContext> continuation) {
        CoroutineContext.Element element = continuation.get$context().get(SdkRequestContextElement.INSTANCE);
        Intrinsics.checkNotNull(element);
        return ((SdkRequestContextElement) element).getCallContext();
    }
}
