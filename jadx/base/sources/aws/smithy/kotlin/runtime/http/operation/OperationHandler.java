package aws.smithy.kotlin.runtime.http.operation;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.operation.TimeoutScope;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: SdkOperationExecution.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00010\u0003B5\u0012\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u000b\u001a\u00028\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@¢\u0006\u0004\b\u000b\u0010\fR&\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/OperationHandler;", "Input", "Output", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "inner", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "interceptors", "<init>", "(Laws/smithy/kotlin/runtime/io/Handler;Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;)V", "request", NotificationCompat.CATEGORY_CALL, "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class OperationHandler<Input, Output> implements Handler<OperationRequest<Input>, Output> {
    private final Handler<OperationRequest<Input>, Output> inner;
    private final InterceptorExecutor<Input, Output> interceptors;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.OperationHandler$call$1 */
    /* JADX INFO: compiled from: SdkOperationExecution.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.OperationHandler", m1609f = "SdkOperationExecution.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2}, m1611l = {213, 436, 217}, m1612m = NotificationCompat.CATEGORY_CALL, m1613n = {"request", "it", "callTimeout", "scope$iv", "duration$iv", "$completion$iv", "$completion", "$i$a$-mapCatching-OperationHandler$call$result$1", "$i$f$scopedTimeout-hhJSO8g", "$i$a$-scopedTimeout-hhJSO8g-OperationHandler$call$result$1$1", "request", "it", "callTimeout", "scope$iv", "duration$iv", "$completion$iv", "$i$a$-mapCatching-OperationHandler$call$result$1", "$i$f$scopedTimeout-hhJSO8g", "request", "it", "$i$a$-let-OperationHandler$call$result$2"}, m1614nl = {433, 437, 216}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C37311 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OperationHandler<Input, Output> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37311(OperationHandler<Input, Output> operationHandler, Continuation<? super C37311> continuation) {
            super(continuation);
            this.this$0 = operationHandler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.call((OperationRequest) null, (Continuation) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OperationHandler(Handler<? super OperationRequest<Input>, ? extends Output> inner, InterceptorExecutor<Input, Output> interceptors) {
        Intrinsics.checkNotNullParameter(inner, "inner");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        this.inner = inner;
        this.interceptors = interceptors;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x012b, code lost:
    
        if (r0 == r4) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0160, code lost:
    
        if (r0 == r4) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01ce, code lost:
    
        if (r0 == r4) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01d0, code lost:
    
        return r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0185 A[Catch: all -> 0x00a6, TryCatch #1 {all -> 0x00a6, blocks: (B:40:0x0163, B:42:0x0169, B:44:0x0185, B:46:0x018d, B:50:0x019c, B:51:0x01a2, B:47:0x0192, B:48:0x0197, B:49:0x0198, B:24:0x00a1, B:32:0x00d4, B:34:0x00ee, B:37:0x012f), top: B:75:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0198 A[Catch: all -> 0x00a6, TryCatch #1 {all -> 0x00a6, blocks: (B:40:0x0163, B:42:0x0169, B:44:0x0185, B:46:0x018d, B:50:0x019c, B:51:0x01a2, B:47:0x0192, B:48:0x0197, B:49:0x0198, B:24:0x00a1, B:32:0x00d4, B:34:0x00ee, B:37:0x012f), top: B:75:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    @Override // aws.smithy.kotlin.runtime.p011io.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object call(OperationRequest<Input> operationRequest, Continuation<? super Output> continuation) {
        C37311 c37311;
        Object objCreateFailure;
        Object objM14499constructorimpl;
        Object objM12211modifyBeforeCompletionKWTtemM;
        Duration duration;
        TimeoutScope.Call call;
        TimeoutsKt$scopedTimeout$exceptionType$1 timeoutsKt$scopedTimeout$exceptionType$1;
        OperationRequest<Input> operationRequest2 = operationRequest;
        if (continuation instanceof C37311) {
            c37311 = (C37311) continuation;
            if ((c37311.label & Integer.MIN_VALUE) != 0) {
                c37311.label -= Integer.MIN_VALUE;
            } else {
                c37311 = new C37311(this, continuation);
            }
        }
        Object objM16018withTimeoutKLykuaI = c37311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37311.label;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (i == 0) {
            ResultKt.throwOnFailure(objM16018withTimeoutKLykuaI);
            CoroutineContext context = c37311.getContext();
            Function0 function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.http.operation.OperationHandler$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OperationHandler.call$lambda$0();
                }
            };
            LogLevel logLevel = LogLevel.Trace;
            String qualifiedName = Reflection.getOrCreateKotlinClass(OperationHandler.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
            }
            CoroutineContextLogExtKt.log(context, logLevel, qualifiedName, null, function0);
            objCreateFailure = this.interceptors.m12214readBeforeExecutionIoAF18A(operationRequest2.getSubject());
            if (Result.m14506isSuccessimpl(objCreateFailure)) {
                Result.Companion companion = Result.INSTANCE;
                Unit unit = (Unit) objCreateFailure;
                duration = (Duration) operationRequest2.getContext().getOrNull(HttpOperationContext.INSTANCE.getCallTimeout());
                call = TimeoutScope.Call.INSTANCE;
                if (duration == null) {
                    Handler handler = this.inner;
                    c37311.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest2);
                    c37311.L$1 = SpillingKt.nullOutSpilledVariable(unit);
                    c37311.L$2 = SpillingKt.nullOutSpilledVariable(duration);
                    c37311.L$3 = SpillingKt.nullOutSpilledVariable(call);
                    c37311.L$4 = SpillingKt.nullOutSpilledVariable(duration);
                    c37311.L$5 = SpillingKt.nullOutSpilledVariable(c37311);
                    c37311.L$6 = SpillingKt.nullOutSpilledVariable(c37311);
                    c37311.I$0 = 0;
                    c37311.I$1 = 0;
                    c37311.I$2 = 0;
                    c37311.label = 1;
                    objM16018withTimeoutKLykuaI = handler.call(operationRequest2, c37311);
                } else {
                    try {
                        long rawValue = duration.getRawValue();
                        OperationHandler$call$lambda$1$$inlined$scopedTimeouthhJSO8g$1 operationHandler$call$lambda$1$$inlined$scopedTimeouthhJSO8g$1 = new OperationHandler$call$lambda$1$$inlined$scopedTimeouthhJSO8g$1(null, this, operationRequest2);
                        c37311.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest2);
                        c37311.L$1 = SpillingKt.nullOutSpilledVariable(unit);
                        c37311.L$2 = SpillingKt.nullOutSpilledVariable(duration);
                        c37311.L$3 = call;
                        c37311.L$4 = duration;
                        c37311.L$5 = SpillingKt.nullOutSpilledVariable(c37311);
                        c37311.I$0 = 0;
                        c37311.I$1 = 0;
                        c37311.label = 2;
                        objM16018withTimeoutKLykuaI = TimeoutKt.m16018withTimeoutKLykuaI(rawValue, operationHandler$call$lambda$1$$inlined$scopedTimeouthhJSO8g$1, c37311);
                    } catch (TimeoutCancellationException e) {
                        e = e;
                        String str = call.getDescription() + " exceeded configured timeout of " + duration;
                        if (!(call instanceof TimeoutScope.Attempt)) {
                            timeoutsKt$scopedTimeout$exceptionType$1 = TimeoutsKt$scopedTimeout$exceptionType$1.INSTANCE;
                        } else {
                            if (!Intrinsics.areEqual(call, TimeoutScope.Call.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            timeoutsKt$scopedTimeout$exceptionType$1 = TimeoutsKt$scopedTimeout$exceptionType$2.INSTANCE;
                        }
                        throw ((Throwable) timeoutsKt$scopedTimeout$exceptionType$1.invoke(str, e));
                    }
                }
            }
            objM14499constructorimpl = Result.m14499constructorimpl(objCreateFailure);
        } else {
            if (i == 1) {
                int i2 = c37311.I$2;
                int i3 = c37311.I$1;
                int i4 = c37311.I$0;
                operationRequest2 = (OperationRequest) c37311.L$0;
                ResultKt.throwOnFailure(objM16018withTimeoutKLykuaI);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i5 = c37311.I$0;
                    Object obj = c37311.L$1;
                    ResultKt.throwOnFailure(objM16018withTimeoutKLykuaI);
                    objM12211modifyBeforeCompletionKWTtemM = ((Result) objM16018withTimeoutKLykuaI).getValue();
                    Object objM12212readAfterExecutionbjn95JY = this.interceptors.m12212readAfterExecutionbjn95JY(objM12211modifyBeforeCompletionKWTtemM);
                    if (!Result.m14506isSuccessimpl(objM12212readAfterExecutionbjn95JY)) {
                        if (Result.m14505isFailureimpl(objM12212readAfterExecutionbjn95JY)) {
                            CoroutineContext context2 = c37311.getContext();
                            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM12212readAfterExecutionbjn95JY);
                            Function0 function02 = new Function0() { // from class: aws.smithy.kotlin.runtime.http.operation.OperationHandler$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return OperationHandler.call$lambda$5();
                                }
                            };
                            LogLevel logLevel2 = LogLevel.Trace;
                            String qualifiedName2 = Reflection.getOrCreateKotlinClass(OperationHandler.class).getQualifiedName();
                            if (qualifiedName2 == null) {
                                throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                            }
                            CoroutineContextLogExtKt.log(context2, logLevel2, qualifiedName2, thM14502exceptionOrNullimpl, function02);
                        }
                    } else {
                        CoroutineContext context3 = c37311.getContext();
                        Function0 function03 = new Function0() { // from class: aws.smithy.kotlin.runtime.http.operation.OperationHandler$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OperationHandler.call$lambda$4();
                            }
                        };
                        LogLevel logLevel3 = LogLevel.Trace;
                        String qualifiedName3 = Reflection.getOrCreateKotlinClass(OperationHandler.class).getQualifiedName();
                        if (qualifiedName3 == null) {
                            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                        }
                        CoroutineContextLogExtKt.log(context3, logLevel3, qualifiedName3, null, function03);
                    }
                    ResultKt.throwOnFailure(objM12212readAfterExecutionbjn95JY);
                    return objM12212readAfterExecutionbjn95JY;
                }
                int i6 = c37311.I$1;
                int i7 = c37311.I$0;
                Duration duration2 = (Duration) c37311.L$4;
                TimeoutScope timeoutScope = (TimeoutScope) c37311.L$3;
                OperationRequest<Input> operationRequest3 = (OperationRequest) c37311.L$0;
                try {
                    ResultKt.throwOnFailure(objM16018withTimeoutKLykuaI);
                    operationRequest2 = operationRequest3;
                } catch (TimeoutCancellationException e2) {
                    e = e2;
                    call = timeoutScope;
                    duration = duration2;
                    String str2 = call.getDescription() + " exceeded configured timeout of " + duration;
                    if (!(call instanceof TimeoutScope.Attempt)) {
                    }
                    throw ((Throwable) timeoutsKt$scopedTimeout$exceptionType$1.invoke(str2, e));
                } catch (Throwable th2) {
                    th = th2;
                    operationRequest2 = operationRequest3;
                    Result.Companion companion2 = Result.INSTANCE;
                    objCreateFailure = ResultKt.createFailure(th);
                    objM14499constructorimpl = Result.m14499constructorimpl(objCreateFailure);
                }
            }
            objM14499constructorimpl = Result.m14499constructorimpl(objM16018withTimeoutKLykuaI);
        }
        InterceptorExecutor<Input, Output> interceptorExecutor = this.interceptors;
        c37311.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest2);
        c37311.L$1 = SpillingKt.nullOutSpilledVariable(objM14499constructorimpl);
        c37311.L$2 = null;
        c37311.L$3 = null;
        c37311.L$4 = null;
        c37311.L$5 = null;
        c37311.L$6 = null;
        c37311.I$0 = 0;
        c37311.label = 3;
        objM12211modifyBeforeCompletionKWTtemM = interceptorExecutor.m12211modifyBeforeCompletionKWTtemM(objM14499constructorimpl, c37311);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String call$lambda$0() {
        return "operation started";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String call$lambda$4() {
        return "operation completed successfully";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String call$lambda$5() {
        return "operation failed";
    }
}
