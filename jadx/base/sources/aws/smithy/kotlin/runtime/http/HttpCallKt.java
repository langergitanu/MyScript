package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: HttpCall.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087@¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"complete", "", "Laws/smithy/kotlin/runtime/http/HttpCall;", "(Laws/smithy/kotlin/runtime/http/HttpCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpCallKt {
    @InternalApi
    public static final Object complete(HttpCall httpCall, Continuation<? super Unit> continuation) {
        CoroutineContext.Element element = httpCall.getCoroutineContext().get(Job.INSTANCE);
        CompletableJob completableJob = element instanceof CompletableJob ? (CompletableJob) element : null;
        if (completableJob == null) {
            return Unit.INSTANCE;
        }
        completableJob.complete();
        if (!completableJob.isCompleted()) {
            CoroutineContext coroutineContext = httpCall.getCoroutineContext();
            String qualifiedName = Reflection.getOrCreateKotlinClass(HttpCall.class).getQualifiedName();
            if (qualifiedName != null) {
                Logger.trace$default(CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName), null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.HttpCallKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HttpCallKt.complete$lambda$0();
                    }
                }, 1, null);
                httpCall.cancelInFlight();
            } else {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
        }
        Object objJoin = completableJob.join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String complete$lambda$0() {
        return "cancelling in-flight call";
    }
}
