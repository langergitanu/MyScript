package com.survicate.surveys.core.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: Executor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u0016\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H\u0016R*\u0010\u0007\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/core/utils/SurvicateExecutor;", "Lcom/survicate/surveys/core/utils/Executor;", "<init>", "()V", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "onException", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "getOnException", "()Lkotlin/jvm/functions/Function1;", "setOnException", "(Lkotlin/jvm/functions/Function1;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "dispatchChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function0;", "initialize", "post", "action", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateExecutor implements Executor {
    private final CoroutineScope coroutineScope;
    private final Channel<Function0<Unit>> dispatchChannel;
    private Function1<? super Exception, Unit> onException;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onException$lambda$0(Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @Override // com.survicate.surveys.core.utils.Executor
    public Function1<Exception, Unit> getOnException() {
        return this.onException;
    }

    @Override // com.survicate.surveys.core.utils.Executor
    public void setOnException(Function1<? super Exception, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onException = function1;
    }

    public SurvicateExecutor() {
        this(Dispatchers.getDefault());
    }

    public SurvicateExecutor(CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.onException = new Function1() { // from class: com.survicate.surveys.core.utils.SurvicateExecutor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateExecutor.onException$lambda$0((Exception) obj);
            }
        };
        this.dispatchChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        initialize();
    }

    /* JADX INFO: renamed from: com.survicate.surveys.core.utils.SurvicateExecutor$initialize$1 */
    /* JADX INFO: compiled from: Executor.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.core.utils.SurvicateExecutor$initialize$1", m1609f = "Executor.kt", m1610i = {0}, m1611l = {33}, m1612m = "invokeSuspend", m1613n = {"$this$launch"}, m1615s = {"L$0"})
    static final class C83821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C83821(Continuation<? super C83821> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C83821 c83821 = SurvicateExecutor.this.new C83821(continuation);
            c83821.L$0 = obj;
            return c83821;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C83821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0040 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003e -> B:12:0x0041). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator it;
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                it = SurvicateExecutor.this.dispatchChannel.iterator();
                coroutineScope = coroutineScope2;
                this.L$0 = coroutineScope;
                this.L$1 = it;
                this.label = 1;
                obj = it.hasNext(this);
                if (obj == coroutine_suspended) {
                }
                if (((Boolean) obj).booleanValue()) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (ChannelIterator) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    try {
                    } catch (Exception e) {
                        CoroutineScopeKt.ensureActive(coroutineScope);
                        SurvicateExecutor.this.getOnException().invoke(e);
                    }
                    ((Function0) it.next()).invoke();
                    this.L$0 = coroutineScope;
                    this.L$1 = it;
                    this.label = 1;
                    obj = it.hasNext(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    private final void initialize() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C83821(null), 3, null);
    }

    @Override // com.survicate.surveys.core.utils.Executor
    public void post(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.dispatchChannel.mo16021trySendJP2dKIU(action);
    }
}
