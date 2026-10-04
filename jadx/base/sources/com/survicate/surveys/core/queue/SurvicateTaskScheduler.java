package com.survicate.surveys.core.queue;

import com.pdftron.pdf.pdfa.PDFACompliance;
import com.survicate.surveys.core.queue.SurvicateTaskScheduler;
import com.survicate.surveys.core.queue.TaskScheduler;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.commons.codec.binary.BaseNCodec;

/* JADX INFO: compiled from: TaskScheduler.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0001;B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\tJ\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\u0019H\u0002J\u0016\u0010,\u001a\u00020\u00192\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J\u000e\u0010-\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020&H\u0082@¢\u0006\u0002\u00101J\u000e\u00102\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010.J\b\u00103\u001a\u00020\u0019H\u0016J\u000e\u00104\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010.J\u001c\u00105\u001a\u00020\u00192\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0082@¢\u0006\u0002\u00106J\u0016\u00107\u001a\u00020\u00192\u0006\u00100\u001a\u00020&H\u0082@¢\u0006\u0002\u00101J\u000e\u00108\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010.J\u0010\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, m1599d2 = {"Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler;", "Lcom/survicate/surveys/core/queue/TaskScheduler;", "backoffStrategy", "Lcom/survicate/surveys/core/queue/BackoffStrategy;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/core/queue/BackoffStrategy;Lkotlinx/coroutines/CoroutineDispatcher;)V", "(Lcom/survicate/surveys/core/queue/BackoffStrategy;)V", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "tasksExecutionJob", "Lkotlinx/coroutines/Job;", "<set-?>", "", "isEnabled", "()Z", "setEnabled", "(Z)V", "isEnabled$delegate", "Lkotlin/properties/ReadWriteProperty;", "onLogMessage", "Lkotlin/Function1;", "", "", "getOnLogMessage", "()Lkotlin/jvm/functions/Function1;", "setOnLogMessage", "(Lkotlin/jvm/functions/Function1;)V", "queueOperations", "Lkotlinx/coroutines/channels/Channel;", "Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler$QueueOperation;", "runTriggers", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "tasks", "", "Lcom/survicate/surveys/core/queue/QueueTask;", "consecutiveFailures", "", "initialize", "observeQueueOperations", "observeRunTriggers", "schedule", "runCurrentTasks", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runSafely", "task", "(Lcom/survicate/surveys/core/queue/QueueTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyBackoffStrategy", "clear", "cleanup", "addTasks", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTask", "clearTasks", "log", "message", "QueueOperation", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateTaskScheduler implements TaskScheduler {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SurvicateTaskScheduler.class, "isEnabled", "isEnabled()Z", 0))};
    private final BackoffStrategy backoffStrategy;
    private int consecutiveFailures;
    private final CoroutineScope coroutineScope;
    private final CoroutineDispatcher dispatcher;

    /* JADX INFO: renamed from: isEnabled$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty isEnabled;
    private final Mutex mutex;
    private Function1<? super String, Unit> onLogMessage;
    private final Channel<QueueOperation> queueOperations;
    private final Channel<Unit> runTriggers;
    private List<? extends QueueTask> tasks;
    private Job tasksExecutionJob;

    /* JADX INFO: renamed from: com.survicate.surveys.core.queue.SurvicateTaskScheduler$addTasks$1 */
    /* JADX INFO: compiled from: TaskScheduler.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.core.queue.SurvicateTaskScheduler", m1609f = "TaskScheduler.kt", m1610i = {0, 0}, m1611l = {215}, m1612m = "addTasks", m1613n = {"tasks", "$this$withLock_u24default$iv"}, m1615s = {"L$0", "L$1"})
    static final class C83731 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C83731(Continuation<? super C83731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SurvicateTaskScheduler.this.addTasks(null, this);
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.core.queue.SurvicateTaskScheduler$applyBackoffStrategy$1 */
    /* JADX INFO: compiled from: TaskScheduler.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.core.queue.SurvicateTaskScheduler", m1609f = "TaskScheduler.kt", m1610i = {}, m1611l = {162}, m1612m = "applyBackoffStrategy", m1613n = {}, m1615s = {})
    static final class C83741 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C83741(Continuation<? super C83741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SurvicateTaskScheduler.this.applyBackoffStrategy(this);
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.core.queue.SurvicateTaskScheduler$cleanup$1 */
    /* JADX INFO: compiled from: TaskScheduler.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.core.queue.SurvicateTaskScheduler", m1609f = "TaskScheduler.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_7_4, 175}, m1612m = "cleanup", m1613n = {}, m1615s = {})
    static final class C83751 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C83751(Continuation<? super C83751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SurvicateTaskScheduler.this.cleanup(this);
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.core.queue.SurvicateTaskScheduler$clearTasks$1 */
    /* JADX INFO: compiled from: TaskScheduler.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.core.queue.SurvicateTaskScheduler", m1609f = "TaskScheduler.kt", m1610i = {0}, m1611l = {215}, m1612m = "clearTasks", m1613n = {"$this$withLock_u24default$iv"}, m1615s = {"L$0"})
    static final class C83761 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C83761(Continuation<? super C83761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SurvicateTaskScheduler.this.clearTasks(this);
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.core.queue.SurvicateTaskScheduler$removeTask$1 */
    /* JADX INFO: compiled from: TaskScheduler.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.core.queue.SurvicateTaskScheduler", m1609f = "TaskScheduler.kt", m1610i = {0, 0}, m1611l = {215}, m1612m = "removeTask", m1613n = {"task", "$this$withLock_u24default$iv"}, m1615s = {"L$0", "L$1"})
    static final class C83791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C83791(Continuation<? super C83791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SurvicateTaskScheduler.this.removeTask(null, this);
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.core.queue.SurvicateTaskScheduler$runCurrentTasks$1 */
    /* JADX INFO: compiled from: TaskScheduler.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.core.queue.SurvicateTaskScheduler", m1609f = "TaskScheduler.kt", m1610i = {0, 0, 1, 1, 2, 3}, m1611l = {215, 119, 120, 128, 134}, m1612m = "runCurrentTasks", m1613n = {"$this$withLock_u24default$iv", "hasFailure", "task", "hasFailure", "hasFailure", "hasFailure"}, m1615s = {"L$0", "I$0", "L$1", "I$0", "I$0", "I$0"})
    static final class C83801 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C83801(Continuation<? super C83801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SurvicateTaskScheduler.this.runCurrentTasks(this);
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.core.queue.SurvicateTaskScheduler$runSafely$1 */
    /* JADX INFO: compiled from: TaskScheduler.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.core.queue.SurvicateTaskScheduler", m1609f = "TaskScheduler.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_4_2}, m1612m = "runSafely", m1613n = {}, m1615s = {})
    static final class C83811 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C83811(Continuation<? super C83811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SurvicateTaskScheduler.this.runSafely(null, this);
        }
    }

    @Override // com.survicate.surveys.core.queue.TaskScheduler
    public void schedule(QueueTask queueTask) {
        TaskScheduler.DefaultImpls.schedule(this, queueTask);
    }

    public SurvicateTaskScheduler(BackoffStrategy backoffStrategy, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(backoffStrategy, "backoffStrategy");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Delegates delegates = Delegates.INSTANCE;
        final boolean z = true;
        this.isEnabled = new ObservableProperty<Boolean>(z) { // from class: com.survicate.surveys.core.queue.SurvicateTaskScheduler$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                boolean zBooleanValue = newValue.booleanValue();
                if (oldValue.booleanValue() || !zBooleanValue) {
                    return;
                }
                this.queueOperations.mo16021trySendJP2dKIU(SurvicateTaskScheduler.QueueOperation.Retry.INSTANCE);
            }
        };
        this.onLogMessage = new Function1() { // from class: com.survicate.surveys.core.queue.SurvicateTaskScheduler$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateTaskScheduler.onLogMessage$lambda$1((String) obj);
            }
        };
        this.queueOperations = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.runTriggers = ChannelKt.Channel$default(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.tasks = CollectionsKt.emptyList();
        this.backoffStrategy = backoffStrategy;
        this.dispatcher = dispatcher;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        initialize();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SurvicateTaskScheduler(BackoffStrategy backoffStrategy) {
        this(backoffStrategy, Dispatchers.getIO());
        Intrinsics.checkNotNullParameter(backoffStrategy, "backoffStrategy");
    }

    public SurvicateTaskScheduler() {
        this(BackoffStrategy.INSTANCE.getDEFAULT(), Dispatchers.getIO());
    }

    @Override // com.survicate.surveys.core.queue.TaskScheduler
    public boolean isEnabled() {
        return ((Boolean) this.isEnabled.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    @Override // com.survicate.surveys.core.queue.TaskScheduler
    public void setEnabled(boolean z) {
        this.isEnabled.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLogMessage$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @Override // com.survicate.surveys.core.queue.TaskScheduler
    public Function1<String, Unit> getOnLogMessage() {
        return this.onLogMessage;
    }

    @Override // com.survicate.surveys.core.queue.TaskScheduler
    public void setOnLogMessage(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onLogMessage = function1;
    }

    private final void initialize() {
        observeQueueOperations();
        observeRunTriggers();
    }

    /* JADX INFO: renamed from: com.survicate.surveys.core.queue.SurvicateTaskScheduler$observeQueueOperations$1 */
    /* JADX INFO: compiled from: TaskScheduler.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.core.queue.SurvicateTaskScheduler$observeQueueOperations$1", m1609f = "TaskScheduler.kt", m1610i = {}, m1611l = {73, BaseNCodec.MIME_CHUNK_SIZE, 85}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C83771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C83771(Continuation<? super C83771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SurvicateTaskScheduler.this.new C83771(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C83771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        
            if (r8.this$0.cleanup(r8) == r0) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008d -> B:25:0x0087). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00b2 -> B:34:0x00b5). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator it;
            ChannelIterator channelIterator;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = SurvicateTaskScheduler.this.queueOperations.iterator();
                this.L$0 = it;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    channelIterator = (ChannelIterator) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ChannelResult.m16036boximpl(SurvicateTaskScheduler.this.runTriggers.mo16021trySendJP2dKIU(Unit.INSTANCE));
                    it = channelIterator;
                    this.L$0 = it;
                    this.label = 1;
                    objHasNext = it.hasNext(this);
                    if (objHasNext != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelIterator = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                Unit unit = Unit.INSTANCE;
                it = channelIterator;
                this.L$0 = it;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                    channelIterator = it;
                    obj = objHasNext;
                    if (!((Boolean) obj).booleanValue()) {
                        QueueOperation queueOperation = (QueueOperation) channelIterator.next();
                        if (queueOperation instanceof QueueOperation.Add) {
                            this.L$0 = channelIterator;
                            this.label = 2;
                            if (SurvicateTaskScheduler.this.addTasks(((QueueOperation.Add) queueOperation).getTasks(), this) != coroutine_suspended) {
                                ChannelResult.m16036boximpl(SurvicateTaskScheduler.this.runTriggers.mo16021trySendJP2dKIU(Unit.INSTANCE));
                                it = channelIterator;
                            }
                        } else if (queueOperation instanceof QueueOperation.Retry) {
                            ChannelResult.m16036boximpl(SurvicateTaskScheduler.this.runTriggers.mo16021trySendJP2dKIU(Unit.INSTANCE));
                            it = channelIterator;
                        } else {
                            if (!Intrinsics.areEqual(queueOperation, QueueOperation.Clear.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            this.L$0 = channelIterator;
                            this.label = 3;
                        }
                        this.L$0 = it;
                        this.label = 1;
                        objHasNext = it.hasNext(this);
                        if (objHasNext != coroutine_suspended) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            }
            channelIterator = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (!((Boolean) obj).booleanValue()) {
            }
        }
    }

    private final void observeQueueOperations() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C83771(null), 3, null);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.core.queue.SurvicateTaskScheduler$observeRunTriggers$1 */
    /* JADX INFO: compiled from: TaskScheduler.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.core.queue.SurvicateTaskScheduler$observeRunTriggers$1", m1609f = "TaskScheduler.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA9_5, 96}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C83781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C83781(Continuation<? super C83781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SurvicateTaskScheduler.this.new C83781(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C83781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
        
            if (r6.this$0.runCurrentTasks(r6) == r0) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:7:0x0015). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator it;
            ChannelIterator channelIterator;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = SurvicateTaskScheduler.this.runTriggers.iterator();
                this.L$0 = it;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelIterator = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                it = channelIterator;
                this.L$0 = it;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                    channelIterator = it;
                    obj = objHasNext;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    channelIterator.next();
                    this.L$0 = channelIterator;
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            channelIterator = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }

    private final void observeRunTriggers() {
        this.tasksExecutionJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C83781(null), 3, null);
    }

    @Override // com.survicate.surveys.core.queue.TaskScheduler
    public void schedule(List<? extends QueueTask> tasks) {
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        this.queueOperations.mo16021trySendJP2dKIU(new QueueOperation.Add(tasks));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e3, code lost:
    
        if (kotlinx.coroutines.YieldKt.yield(r0) != r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f8, code lost:
    
        if (applyBackoffStrategy(r0) == r1) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00e3 -> B:19:0x004a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runCurrentTasks(Continuation<? super Unit> continuation) {
        C83801 c83801;
        Mutex mutex;
        int i;
        Iterator<? extends QueueTask> it;
        Iterator<? extends QueueTask> it2;
        QueueTask next;
        if (continuation instanceof C83801) {
            c83801 = (C83801) continuation;
            if ((c83801.label & Integer.MIN_VALUE) != 0) {
                c83801.label -= Integer.MIN_VALUE;
            } else {
                c83801 = new C83801(continuation);
            }
        }
        Object objRunSafely = c83801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c83801.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objRunSafely);
                if (!isEnabled()) {
                    log("TaskScheduler: disabled, skipping execution");
                    return Unit.INSTANCE;
                }
                log("TaskScheduler: running tasks");
                mutex = this.mutex;
                c83801.L$0 = mutex;
                c83801.I$0 = 0;
                c83801.label = 1;
                if (mutex.lock(null, c83801) != coroutine_suspended) {
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                i = c83801.I$0;
                mutex = (Mutex) c83801.L$0;
                ResultKt.throwOnFailure(objRunSafely);
            } else if (i2 == 2) {
                i = c83801.I$0;
                next = (QueueTask) c83801.L$1;
                it = (Iterator) c83801.L$0;
                ResultKt.throwOnFailure(objRunSafely);
                if (((Boolean) objRunSafely).booleanValue()) {
                }
            } else if (i2 == 3) {
                i = c83801.I$0;
                it2 = (Iterator) c83801.L$0;
                ResultKt.throwOnFailure(objRunSafely);
                c83801.L$0 = it2;
                c83801.I$0 = i;
                c83801.label = 4;
            } else {
                if (i2 != 4) {
                    if (i2 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objRunSafely);
                    return Unit.INSTANCE;
                }
                i = c83801.I$0;
                it2 = (Iterator) c83801.L$0;
                ResultKt.throwOnFailure(objRunSafely);
                it = it2;
                if (it.hasNext()) {
                    next = it.next();
                    if (isEnabled()) {
                        c83801.L$0 = it;
                        c83801.L$1 = next;
                        c83801.I$0 = i;
                        c83801.label = 2;
                        objRunSafely = runSafely(next, c83801);
                        if (objRunSafely != coroutine_suspended) {
                            if (((Boolean) objRunSafely).booleanValue()) {
                                i = 1;
                            } else {
                                c83801.L$0 = it;
                                c83801.L$1 = null;
                                c83801.I$0 = i;
                                c83801.label = 3;
                                if (removeTask(next, c83801) != coroutine_suspended) {
                                    it2 = it;
                                    c83801.L$0 = it2;
                                    c83801.I$0 = i;
                                    c83801.label = 4;
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 0) {
                    this.consecutiveFailures++;
                    c83801.L$0 = null;
                    c83801.L$1 = null;
                    c83801.label = 5;
                } else {
                    this.consecutiveFailures = 0;
                    return Unit.INSTANCE;
                }
            }
            List<? extends QueueTask> list = this.tasks;
            mutex.unlock(null);
            it = list.iterator();
            if (it.hasNext()) {
            }
            if (i == 0) {
            }
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runSafely(QueueTask queueTask, Continuation<? super Boolean> continuation) {
        C83811 c83811;
        if (continuation instanceof C83811) {
            c83811 = (C83811) continuation;
            if ((c83811.label & Integer.MIN_VALUE) != 0) {
                c83811.label -= Integer.MIN_VALUE;
            } else {
                c83811 = new C83811(continuation);
            }
        }
        Object obj = c83811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c83811.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            c83811.label = 1;
            Object objRun = queueTask.run(c83811);
            return objRun == coroutine_suspended ? coroutine_suspended : objRun;
        } catch (Exception e) {
            JobKt.ensureActive(c83811.get$context());
            StringBuilder sb = new StringBuilder("TaskScheduler: exception when executing task - ");
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            log(sb.append(message).toString());
            return Boxing.boxBoolean(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object applyBackoffStrategy(Continuation<? super Unit> continuation) {
        C83741 c83741;
        if (continuation instanceof C83741) {
            c83741 = (C83741) continuation;
            if ((c83741.label & Integer.MIN_VALUE) != 0) {
                c83741.label -= Integer.MIN_VALUE;
            } else {
                c83741 = new C83741(continuation);
            }
        }
        Object obj = c83741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c83741.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long delayMillis = this.backoffStrategy.getDelayMillis(this.consecutiveFailures);
            if (delayMillis < 0) {
                return Unit.INSTANCE;
            }
            log("TaskScheduler: applying backoff delay of " + delayMillis + " ms after " + this.consecutiveFailures + " failure(s)");
            if (delayMillis > 0) {
                c83741.label = 1;
                if (DelayKt.delay(delayMillis, c83741) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.queueOperations.mo16021trySendJP2dKIU(QueueOperation.Retry.INSTANCE);
        return Unit.INSTANCE;
    }

    @Override // com.survicate.surveys.core.queue.TaskScheduler
    public void clear() {
        this.queueOperations.mo16021trySendJP2dKIU(QueueOperation.Clear.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        if (clearTasks(r0) == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cleanup(Continuation<? super Unit> continuation) {
        C83751 c83751;
        if (continuation instanceof C83751) {
            c83751 = (C83751) continuation;
            if ((c83751.label & Integer.MIN_VALUE) != 0) {
                c83751.label -= Integer.MIN_VALUE;
            } else {
                c83751 = new C83751(continuation);
            }
        }
        Object obj = c83751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c83751.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = this.tasksExecutionJob;
            if (job != null) {
                c83751.label = 1;
                if (JobKt.cancelAndJoin(job, c83751) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.consecutiveFailures = 0;
                observeRunTriggers();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        c83751.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object addTasks(List<? extends QueueTask> list, Continuation<? super Unit> continuation) {
        C83731 c83731;
        Mutex mutex;
        if (continuation instanceof C83731) {
            c83731 = (C83731) continuation;
            if ((c83731.label & Integer.MIN_VALUE) != 0) {
                c83731.label -= Integer.MIN_VALUE;
            } else {
                c83731 = new C83731(continuation);
            }
        }
        Object obj = c83731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c83731.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            c83731.L$0 = list;
            c83731.L$1 = mutex;
            c83731.label = 1;
            if (mutex.lock(null, c83731) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) c83731.L$1;
            List<? extends QueueTask> list2 = (List) c83731.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            list = list2;
        }
        try {
            this.tasks = CollectionsKt.plus((Collection) this.tasks, (Iterable) list);
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object removeTask(QueueTask queueTask, Continuation<? super Unit> continuation) {
        C83791 c83791;
        Mutex mutex;
        if (continuation instanceof C83791) {
            c83791 = (C83791) continuation;
            if ((c83791.label & Integer.MIN_VALUE) != 0) {
                c83791.label -= Integer.MIN_VALUE;
            } else {
                c83791 = new C83791(continuation);
            }
        }
        Object obj = c83791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c83791.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            c83791.L$0 = queueTask;
            c83791.L$1 = mutex;
            c83791.label = 1;
            if (mutex.lock(null, c83791) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) c83791.L$1;
            QueueTask queueTask2 = (QueueTask) c83791.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            queueTask = queueTask2;
        }
        try {
            this.tasks = CollectionsKt.minus(this.tasks, queueTask);
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearTasks(Continuation<? super Unit> continuation) {
        C83761 c83761;
        Mutex mutex;
        if (continuation instanceof C83761) {
            c83761 = (C83761) continuation;
            if ((c83761.label & Integer.MIN_VALUE) != 0) {
                c83761.label -= Integer.MIN_VALUE;
            } else {
                c83761 = new C83761(continuation);
            }
        }
        Object obj = c83761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c83761.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.mutex;
            c83761.L$0 = mutex2;
            c83761.label = 1;
            if (mutex2.lock(null, c83761) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) c83761.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            this.tasks = CollectionsKt.emptyList();
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    private final void log(String message) {
        getOnLogMessage().invoke(message);
    }

    /* JADX INFO: compiled from: TaskScheduler.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler$QueueOperation;", "", "Add", "Retry", "Clear", "Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler$QueueOperation$Add;", "Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler$QueueOperation$Clear;", "Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler$QueueOperation$Retry;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public interface QueueOperation {

        /* JADX INFO: compiled from: TaskScheduler.kt */
        @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler$QueueOperation$Add;", "Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler$QueueOperation;", "tasks", "", "Lcom/survicate/surveys/core/queue/QueueTask;", "<init>", "(Ljava/util/List;)V", "getTasks", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final /* data */ class Add implements QueueOperation {
            private final List<QueueTask> tasks;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Add copy$default(Add add, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = add.tasks;
                }
                return add.copy(list);
            }

            public final List<QueueTask> component1() {
                return this.tasks;
            }

            public final Add copy(List<? extends QueueTask> tasks) {
                Intrinsics.checkNotNullParameter(tasks, "tasks");
                return new Add(tasks);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Add) && Intrinsics.areEqual(this.tasks, ((Add) other).tasks);
            }

            public int hashCode() {
                return this.tasks.hashCode();
            }

            public String toString() {
                return "Add(tasks=" + this.tasks + ')';
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Add(List<? extends QueueTask> tasks) {
                Intrinsics.checkNotNullParameter(tasks, "tasks");
                this.tasks = tasks;
            }

            public final List<QueueTask> getTasks() {
                return this.tasks;
            }
        }

        /* JADX INFO: compiled from: TaskScheduler.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler$QueueOperation$Retry;", "Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler$QueueOperation;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final /* data */ class Retry implements QueueOperation {
            public static final Retry INSTANCE = new Retry();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Retry)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 332862028;
            }

            public String toString() {
                return "Retry";
            }

            private Retry() {
            }
        }

        /* JADX INFO: compiled from: TaskScheduler.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler$QueueOperation$Clear;", "Lcom/survicate/surveys/core/queue/SurvicateTaskScheduler$QueueOperation;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final /* data */ class Clear implements QueueOperation {
            public static final Clear INSTANCE = new Clear();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Clear)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 319202801;
            }

            public String toString() {
                return "Clear";
            }

            private Clear() {
            }
        }
    }
}
