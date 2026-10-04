package aws.smithy.kotlin.runtime.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: SingleFlightGroup.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J.\u0010\b\u001a\u00028\u00002\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0086@¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/SingleFlightGroup;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", "singleFlight", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/sync/Mutex;", "mu", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlin/Result;", "inFlight", "Lkotlinx/coroutines/CompletableDeferred;", "", "waitCount", "I", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SingleFlightGroup<T> {
    private CompletableDeferred<Result<T>> inFlight;
    private final Mutex mu = MutexKt.Mutex$default(false, 1, null);
    private int waitCount;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.util.SingleFlightGroup$singleFlight$1 */
    /* JADX INFO: compiled from: SingleFlightGroup.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.util.SingleFlightGroup", m1609f = "SingleFlightGroup.kt", m1610i = {0, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5}, m1611l = {31, 38, 64, 47, ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m1612m = "singleFlight", m1613n = {"block", "block", "job", "block", "job", "$this$withLock_u24default$iv", "$i$f$withLock", "block", "job", "block", "job", "deferred", "$this$singleFlight_u24lambda_u241", "$i$a$-runCatching-SingleFlightGroup$singleFlight$3", "block", "job", "deferred"}, m1614nl = {32, 40, 65, 47, ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m1615s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C37991 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleFlightGroup<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37991(SingleFlightGroup<T> singleFlightGroup, Continuation<? super C37991> continuation) {
            super(continuation);
            this.this$0 = singleFlightGroup;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.singleFlight(null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0108, code lost:
    
        if (r10 != r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0185, code lost:
    
        if (r10 == r1) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec A[Catch: all -> 0x0116, TryCatch #1 {all -> 0x0116, blocks: (B:36:0x00e4, B:38:0x00ec, B:39:0x00ee), top: B:65:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object singleFlight(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        C37991 c37991;
        CompletableDeferred<Result<T>> completableDeferred;
        CompletableDeferred<Result<T>> completableDeferredCompletableDeferred$default;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        CompletableDeferred<Result<T>> completableDeferred2;
        Throwable th;
        Object objInvoke;
        Mutex mutex;
        Function1<? super Continuation<? super T>, ? extends Object> function13;
        Mutex mutex2;
        int i;
        Object objM14499constructorimpl;
        if (continuation instanceof C37991) {
            c37991 = (C37991) continuation;
            if ((c37991.label & Integer.MIN_VALUE) != 0) {
                c37991.label -= Integer.MIN_VALUE;
            } else {
                c37991 = new C37991(this, continuation);
            }
        }
        Object objAwait = c37991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c37991.label) {
            case 0:
                ResultKt.throwOnFailure(objAwait);
                Mutex mutex3 = this.mu;
                c37991.L$0 = function1;
                c37991.label = 1;
                if (Mutex.DefaultImpls.lock$default(mutex3, null, c37991, 1, null) != coroutine_suspended) {
                    completableDeferred = this.inFlight;
                    if (completableDeferred == null && completableDeferred.isActive()) {
                        this.waitCount++;
                        Mutex.DefaultImpls.unlock$default(this.mu, null, 1, null);
                        c37991.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                        c37991.L$1 = completableDeferred;
                        c37991.label = 2;
                        if (completableDeferred.join(c37991) != coroutine_suspended) {
                            mutex = this.mu;
                            c37991.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                            c37991.L$1 = completableDeferred;
                            c37991.L$2 = mutex;
                            c37991.I$0 = 0;
                            c37991.label = 3;
                            if (mutex.lock(null, c37991) != coroutine_suspended) {
                                function13 = function1;
                                mutex2 = mutex;
                                try {
                                    i = this.waitCount - 1;
                                    this.waitCount = i;
                                    if (i == 0) {
                                        this.inFlight = null;
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    mutex2.unlock(null);
                                    c37991.L$0 = SpillingKt.nullOutSpilledVariable(function13);
                                    c37991.L$1 = SpillingKt.nullOutSpilledVariable(completableDeferred);
                                    c37991.L$2 = null;
                                    c37991.label = 4;
                                    objAwait = completableDeferred.await(c37991);
                                } catch (Throwable th2) {
                                    mutex2.unlock(null);
                                    throw th2;
                                }
                            }
                        }
                    } else {
                        completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                        this.inFlight = completableDeferredCompletableDeferred$default;
                        Mutex.DefaultImpls.unlock$default(this.mu, null, 1, null);
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            SingleFlightGroup<T> singleFlightGroup = this;
                            c37991.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                            c37991.L$1 = SpillingKt.nullOutSpilledVariable(completableDeferred);
                            c37991.L$2 = completableDeferredCompletableDeferred$default;
                            c37991.L$3 = SpillingKt.nullOutSpilledVariable(this);
                            c37991.I$0 = 0;
                            c37991.label = 5;
                            objInvoke = function1.invoke(c37991);
                        } catch (Throwable th3) {
                            function12 = function1;
                            completableDeferred2 = completableDeferredCompletableDeferred$default;
                            th = th3;
                            Result.Companion companion2 = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                        }
                        if (objInvoke != coroutine_suspended) {
                            function12 = function1;
                            completableDeferred2 = completableDeferredCompletableDeferred$default;
                            objAwait = objInvoke;
                            objM14499constructorimpl = Result.m14499constructorimpl(objAwait);
                            completableDeferred2.complete(Result.m14498boximpl(objM14499constructorimpl));
                            c37991.L$0 = SpillingKt.nullOutSpilledVariable(function12);
                            c37991.L$1 = SpillingKt.nullOutSpilledVariable(completableDeferred);
                            c37991.L$2 = SpillingKt.nullOutSpilledVariable(completableDeferred2);
                            c37991.L$3 = null;
                            c37991.label = 6;
                            objAwait = completableDeferred2.await(c37991);
                        }
                    }
                    break;
                }
                return coroutine_suspended;
            case 1:
                function1 = (Function1) c37991.L$0;
                ResultKt.throwOnFailure(objAwait);
                completableDeferred = this.inFlight;
                if (completableDeferred == null) {
                    completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                    this.inFlight = completableDeferredCompletableDeferred$default;
                    Mutex.DefaultImpls.unlock$default(this.mu, null, 1, null);
                    Result.Companion companion3 = Result.INSTANCE;
                    SingleFlightGroup<T> singleFlightGroup2 = this;
                    c37991.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                    c37991.L$1 = SpillingKt.nullOutSpilledVariable(completableDeferred);
                    c37991.L$2 = completableDeferredCompletableDeferred$default;
                    c37991.L$3 = SpillingKt.nullOutSpilledVariable(this);
                    c37991.I$0 = 0;
                    c37991.label = 5;
                    objInvoke = function1.invoke(c37991);
                    if (objInvoke != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                completableDeferred2.complete(Result.m14498boximpl(objM14499constructorimpl));
                c37991.L$0 = SpillingKt.nullOutSpilledVariable(function12);
                c37991.L$1 = SpillingKt.nullOutSpilledVariable(completableDeferred);
                c37991.L$2 = SpillingKt.nullOutSpilledVariable(completableDeferred2);
                c37991.L$3 = null;
                c37991.label = 6;
                objAwait = completableDeferred2.await(c37991);
                break;
            case 2:
                CompletableDeferred<Result<T>> completableDeferred3 = (CompletableDeferred) c37991.L$1;
                Function1<? super Continuation<? super T>, ? extends Object> function14 = (Function1) c37991.L$0;
                ResultKt.throwOnFailure(objAwait);
                completableDeferred = completableDeferred3;
                function1 = function14;
                mutex = this.mu;
                c37991.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                c37991.L$1 = completableDeferred;
                c37991.L$2 = mutex;
                c37991.I$0 = 0;
                c37991.label = 3;
                if (mutex.lock(null, c37991) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 3:
                int i2 = c37991.I$0;
                mutex2 = (Mutex) c37991.L$2;
                completableDeferred = (CompletableDeferred) c37991.L$1;
                function13 = (Function1) c37991.L$0;
                ResultKt.throwOnFailure(objAwait);
                i = this.waitCount - 1;
                this.waitCount = i;
                if (i == 0) {
                }
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                c37991.L$0 = SpillingKt.nullOutSpilledVariable(function13);
                c37991.L$1 = SpillingKt.nullOutSpilledVariable(completableDeferred);
                c37991.L$2 = null;
                c37991.label = 4;
                objAwait = completableDeferred.await(c37991);
                break;
            case 4:
                ResultKt.throwOnFailure(objAwait);
                Object value = ((Result) objAwait).getValue();
                ResultKt.throwOnFailure(value);
                return value;
            case 5:
                int i3 = c37991.I$0;
                completableDeferred2 = (CompletableDeferred) c37991.L$2;
                completableDeferred = (CompletableDeferred) c37991.L$1;
                function12 = (Function1) c37991.L$0;
                try {
                    ResultKt.throwOnFailure(objAwait);
                    objM14499constructorimpl = Result.m14499constructorimpl(objAwait);
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion22 = Result.INSTANCE;
                    objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                }
                completableDeferred2.complete(Result.m14498boximpl(objM14499constructorimpl));
                c37991.L$0 = SpillingKt.nullOutSpilledVariable(function12);
                c37991.L$1 = SpillingKt.nullOutSpilledVariable(completableDeferred);
                c37991.L$2 = SpillingKt.nullOutSpilledVariable(completableDeferred2);
                c37991.L$3 = null;
                c37991.label = 6;
                objAwait = completableDeferred2.await(c37991);
                break;
            case 6:
                ResultKt.throwOnFailure(objAwait);
                Object value2 = ((Result) objAwait).getValue();
                ResultKt.throwOnFailure(value2);
                return value2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
