package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.GapComposerKt;
import androidx.concurrent.futures.ListenableFutureKt;
import androidx.core.util.Consumer;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerExceptionInfo;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.WorkerExceptionUtilsKt;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ConstraintTrackingWorker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\nJ&\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Landroidx/work/impl/workers/ConstraintTrackingWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupAndRunConstraintTrackingWork", "runWorker", "delegate", "Landroidx/work/ListenableWorker;", "workConstraintsTracker", "Landroidx/work/impl/constraints/WorkConstraintsTracker;", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "(Landroidx/work/ListenableWorker;Landroidx/work/impl/constraints/WorkConstraintsTracker;Landroidx/work/impl/model/WorkSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ConstraintUnsatisfiedException", "work-runtime_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ConstraintTrackingWorker extends CoroutineWorker {
    private final WorkerParameters workerParameters;

    /* JADX INFO: renamed from: androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$1 */
    /* JADX INFO: compiled from: ConstraintTrackingWorker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.work.impl.workers.ConstraintTrackingWorker", m1609f = "ConstraintTrackingWorker.kt", m1610i = {}, m1611l = {GapComposerKt.nodeKey}, m1612m = "runWorker", m1613n = {}, m1615s = {})
    static final class C29941 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C29941(Continuation<? super C29941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConstraintTrackingWorker.this.runWorker(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$1 */
    /* JADX INFO: compiled from: ConstraintTrackingWorker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.work.impl.workers.ConstraintTrackingWorker", m1609f = "ConstraintTrackingWorker.kt", m1610i = {0}, m1611l = {97}, m1612m = "setupAndRunConstraintTrackingWork", m1613n = {"delegate"}, m1615s = {"L$0"})
    static final class C29961 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29961(Continuation<? super C29961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConstraintTrackingWorker.this.setupAndRunConstraintTrackingWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context appContext, WorkerParameters workerParameters) {
        super(appContext, workerParameters);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        this.workerParameters = workerParameters;
    }

    /* JADX INFO: renamed from: androidx.work.impl.workers.ConstraintTrackingWorker$doWork$2 */
    /* JADX INFO: compiled from: ConstraintTrackingWorker.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.work.impl.workers.ConstraintTrackingWorker$doWork$2", m1609f = "ConstraintTrackingWorker.kt", m1610i = {}, m1611l = {58}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C29932 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
        int label;

        C29932(Continuation<? super C29932> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConstraintTrackingWorker.this.new C29932(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
            return ((C29932) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object obj2 = ConstraintTrackingWorker.this.setupAndRunConstraintTrackingWork(this);
            return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
        }
    }

    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        Executor backgroundExecutor = getBackgroundExecutor();
        Intrinsics.checkNotNullExpressionValue(backgroundExecutor, "getBackgroundExecutor(...)");
        return BuildersKt.withContext(ExecutorsKt.from(backgroundExecutor), new C29932(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.work.ListenableWorker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setupAndRunConstraintTrackingWork(Continuation<? super ListenableWorker.Result> continuation) {
        C29961 c29961;
        int stopReason;
        if (continuation instanceof C29961) {
            c29961 = (C29961) continuation;
            if ((c29961.label & Integer.MIN_VALUE) != 0) {
                c29961.label -= Integer.MIN_VALUE;
            } else {
                c29961 = new C29961(continuation);
            }
        }
        C29961 c299612 = c29961;
        Object objWithContext = c299612.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = c299612.label;
        try {
            if (r2 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                String string = getInputData().getString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME);
                String str = string;
                if (str == null || str.length() == 0) {
                    Logger.get().error(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
                    ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
                    Intrinsics.checkNotNullExpressionValue(resultFailure, "failure(...)");
                    return resultFailure;
                }
                WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(getApplicationContext());
                Intrinsics.checkNotNullExpressionValue(workManagerImpl, "getInstance(...)");
                WorkSpecDao workSpecDao = workManagerImpl.getWorkDatabase().workSpecDao();
                String string2 = getId().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                WorkSpec workSpec = workSpecDao.getWorkSpec(string2);
                if (workSpec == null) {
                    ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
                    Intrinsics.checkNotNullExpressionValue(resultFailure2, "failure(...)");
                    return resultFailure2;
                }
                Trackers trackers = workManagerImpl.getTrackers();
                Intrinsics.checkNotNullExpressionValue(trackers, "getTrackers(...)");
                WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(trackers);
                if (!workConstraintsTracker.areAllConstraintsMet(workSpec)) {
                    Logger.get().debug(ConstraintTrackingWorkerKt.TAG, "Constraints not met for delegate " + string + ". Requesting retry.");
                    ListenableWorker.Result resultRetry = ListenableWorker.Result.retry();
                    Intrinsics.checkNotNullExpressionValue(resultRetry, "retry(...)");
                    return resultRetry;
                }
                Logger.get().debug(ConstraintTrackingWorkerKt.TAG, "Constraints met for delegate " + string);
                try {
                    WorkerFactory workerFactory = getWorkerFactory();
                    Context applicationContext = getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    ListenableWorker listenableWorkerCreateWorkerWithDefaultFallback = workerFactory.createWorkerWithDefaultFallback(applicationContext, string, this.workerParameters);
                    Executor mainThreadExecutor = this.workerParameters.getTaskExecutor().getMainThreadExecutor();
                    Intrinsics.checkNotNullExpressionValue(mainThreadExecutor, "getMainThreadExecutor(...)");
                    CoroutineDispatcher coroutineDispatcherFrom = ExecutorsKt.from(mainThreadExecutor);
                    C29975 c29975 = new C29975(listenableWorkerCreateWorkerWithDefaultFallback, workConstraintsTracker, workSpec, null);
                    c299612.L$0 = listenableWorkerCreateWorkerWithDefaultFallback;
                    c299612.label = 1;
                    objWithContext = BuildersKt.withContext(coroutineDispatcherFrom, c29975, c299612);
                    r2 = listenableWorkerCreateWorkerWithDefaultFallback;
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable th) {
                    Logger.get().debug(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
                    Consumer<WorkerExceptionInfo> workerInitializationExceptionHandler = workManagerImpl.getConfiguration().getWorkerInitializationExceptionHandler();
                    if (workerInitializationExceptionHandler != null) {
                        WorkerExceptionUtilsKt.safeAccept(workerInitializationExceptionHandler, new WorkerExceptionInfo(string, this.workerParameters, th), ConstraintTrackingWorkerKt.TAG);
                    }
                    ListenableWorker.Result resultFailure3 = ListenableWorker.Result.failure();
                    Intrinsics.checkNotNullExpressionValue(resultFailure3, "failure(...)");
                    return resultFailure3;
                }
            } else {
                if (r2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ListenableWorker listenableWorker = (ListenableWorker) c299612.L$0;
                ResultKt.throwOnFailure(objWithContext);
                r2 = listenableWorker;
            }
            return (ListenableWorker.Result) objWithContext;
        } catch (CancellationException e) {
            if (isStopped() || (e instanceof ConstraintUnsatisfiedException)) {
                if (Build.VERSION.SDK_INT < 31) {
                    stopReason = WorkInfo.STOP_REASON_UNKNOWN;
                } else if (isStopped()) {
                    stopReason = getStopReason();
                } else {
                    if (!(e instanceof ConstraintUnsatisfiedException)) {
                        throw new IllegalStateException("Unreachable");
                    }
                    stopReason = ((ConstraintUnsatisfiedException) e).getStopReason();
                }
                r2.stop(stopReason);
            }
            if (!(e instanceof ConstraintUnsatisfiedException)) {
                throw e;
            }
            ListenableWorker.Result resultRetry2 = ListenableWorker.Result.retry();
            Intrinsics.checkNotNull(resultRetry2);
            return resultRetry2;
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5 */
    /* JADX INFO: compiled from: ConstraintTrackingWorker.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5", m1609f = "ConstraintTrackingWorker.kt", m1610i = {}, m1611l = {98}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C29975 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
        final /* synthetic */ ListenableWorker $delegate;
        final /* synthetic */ WorkConstraintsTracker $workConstraintsTracker;
        final /* synthetic */ WorkSpec $workSpec;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29975(ListenableWorker listenableWorker, WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, Continuation<? super C29975> continuation) {
            super(2, continuation);
            this.$delegate = listenableWorker;
            this.$workConstraintsTracker = workConstraintsTracker;
            this.$workSpec = workSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConstraintTrackingWorker.this.new C29975(this.$delegate, this.$workConstraintsTracker, this.$workSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
            return ((C29975) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objRunWorker = ConstraintTrackingWorker.this.runWorker(this.$delegate, this.$workConstraintsTracker, this.$workSpec, this);
            return objRunWorker == coroutine_suspended ? coroutine_suspended : objRunWorker;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runWorker(ListenableWorker listenableWorker, WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, Continuation<? super ListenableWorker.Result> continuation) {
        C29941 c29941;
        if (continuation instanceof C29941) {
            c29941 = (C29941) continuation;
            if ((c29941.label & Integer.MIN_VALUE) != 0) {
                c29941.label -= Integer.MIN_VALUE;
            } else {
                c29941 = new C29941(continuation);
            }
        }
        Object objCoroutineScope = c29941.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c29941.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCoroutineScope);
            C29952 c29952 = new C29952(listenableWorker, workConstraintsTracker, workSpec, null);
            c29941.label = 1;
            objCoroutineScope = CoroutineScopeKt.coroutineScope(c29952, c29941);
            if (objCoroutineScope == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objCoroutineScope);
        }
        Intrinsics.checkNotNullExpressionValue(objCoroutineScope, "coroutineScope(...)");
        return objCoroutineScope;
    }

    /* JADX INFO: renamed from: androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2 */
    /* JADX INFO: compiled from: ConstraintTrackingWorker.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2", m1609f = "ConstraintTrackingWorker.kt", m1610i = {0, 0, 0}, m1611l = {134}, m1612m = "invokeSuspend", m1613n = {"atomicReason", "future", "constraintTrackingJob"}, m1615s = {"L$0", "L$1", "L$2"})
    static final class C29952 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
        final /* synthetic */ ListenableWorker $delegate;
        final /* synthetic */ WorkConstraintsTracker $workConstraintsTracker;
        final /* synthetic */ WorkSpec $workSpec;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29952(ListenableWorker listenableWorker, WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, Continuation<? super C29952> continuation) {
            super(2, continuation);
            this.$delegate = listenableWorker;
            this.$workConstraintsTracker = workConstraintsTracker;
            this.$workSpec = workSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C29952 c29952 = new C29952(this.$delegate, this.$workConstraintsTracker, this.$workSpec, continuation);
            c29952.L$0 = obj;
            return c29952;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
            return ((C29952) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00da  */
        /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.Job] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            AtomicInteger atomicInteger;
            ListenableFuture<ListenableWorker.Result> listenableFuture;
            Job job;
            CancellationException cancellationException;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            try {
                if (r1 == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    AtomicInteger atomicInteger2 = new AtomicInteger(-256);
                    ListenableFuture<ListenableWorker.Result> listenableFutureStartWork = this.$delegate.startWork();
                    Intrinsics.checkNotNullExpressionValue(listenableFutureStartWork, "startWork(...)");
                    Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1(this.$workConstraintsTracker, this.$workSpec, atomicInteger2, listenableFutureStartWork, null), 3, null);
                    try {
                        this.L$0 = atomicInteger2;
                        this.L$1 = listenableFutureStartWork;
                        this.L$2 = jobLaunch$default;
                        this.label = 1;
                        Object objAwait = ListenableFutureKt.await(listenableFutureStartWork, this);
                        if (objAwait == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        listenableFuture = listenableFutureStartWork;
                        obj = objAwait;
                        atomicInteger = atomicInteger2;
                        job = jobLaunch$default;
                    } catch (CancellationException e) {
                        e = e;
                        atomicInteger = atomicInteger2;
                        listenableFuture = listenableFutureStartWork;
                        cancellationException = e;
                        Logger.get().debug(ConstraintTrackingWorkerKt.TAG, "Delegated worker " + this.$delegate.getClass() + " was cancelled", cancellationException);
                        if (atomicInteger.get() == -256) {
                        }
                        if (!listenableFuture.isCancelled()) {
                            throw cancellationException;
                        }
                        throw cancellationException;
                    } catch (Throwable th2) {
                        th = th2;
                        Logger.get().debug(ConstraintTrackingWorkerKt.TAG, "Delegated worker " + this.$delegate.getClass() + " threw exception in startWork.", th);
                        throw th;
                    }
                } else {
                    if (r1 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    job = (Job) this.L$2;
                    listenableFuture = (ListenableFuture) this.L$1;
                    atomicInteger = (AtomicInteger) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (CancellationException e2) {
                        e = e2;
                        cancellationException = e;
                        Logger.get().debug(ConstraintTrackingWorkerKt.TAG, "Delegated worker " + this.$delegate.getClass() + " was cancelled", cancellationException);
                        boolean z = atomicInteger.get() == -256;
                        if (!listenableFuture.isCancelled() && z) {
                            throw new ConstraintUnsatisfiedException(atomicInteger.get());
                        }
                        throw cancellationException;
                    } catch (Throwable th3) {
                        th = th3;
                        Logger.get().debug(ConstraintTrackingWorkerKt.TAG, "Delegated worker " + this.$delegate.getClass() + " threw exception in startWork.", th);
                        throw th;
                    }
                }
                ListenableWorker.Result result = (ListenableWorker.Result) obj;
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                return result;
            } catch (Throwable th4) {
                Job.DefaultImpls.cancel$default((Job) r1, (CancellationException) null, 1, (Object) null);
                throw th4;
            }
        }
    }

    /* JADX INFO: compiled from: ConstraintTrackingWorker.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Landroidx/work/impl/workers/ConstraintTrackingWorker$ConstraintUnsatisfiedException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "stopReason", "", "<init>", "(I)V", "getStopReason", "()I", "work-runtime_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    private static final class ConstraintUnsatisfiedException extends CancellationException {
        private final int stopReason;

        public ConstraintUnsatisfiedException(int i) {
            this.stopReason = i;
        }

        public final int getStopReason() {
            return this.stopReason;
        }
    }
}
