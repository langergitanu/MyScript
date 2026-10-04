package com.survicate.surveys.targeting;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.helpers.Observable;
import com.survicate.surveys.utils.AppLifecycleProvider;
import com.survicate.surveys.utils.AppLifecycleState;
import com.survicate.surveys.utils.TimestampProvider;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: TimeIntervalTargeting.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0001#B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m1599d2 = {"Lcom/survicate/surveys/targeting/SurvicateTimeIntervalTargeting;", "Lcom/survicate/surveys/targeting/TimeIntervalTargeting;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "appLifecycleProvider", "Lcom/survicate/surveys/utils/AppLifecycleProvider;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/utils/TimestampProvider;Lcom/survicate/surveys/utils/AppLifecycleProvider;Lcom/survicate/surveys/core/logging/SdkLogger;Lkotlinx/coroutines/CoroutineDispatcher;)V", "onTimePassed", "Lkotlin/Function0;", "", "getOnTimePassed", "()Lkotlin/jvm/functions/Function0;", "setOnTimePassed", "(Lkotlin/jvm/functions/Function0;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "intervalJob", "Lkotlinx/coroutines/Job;", "started", "", "remainingDelayMs", "", "lastDelayStartTimeMs", "backgroundStartTimeMs", "isInForeground", "onAppForeground", "onAppBackground", TtmlNode.START, "startTimer", "clear", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateTimeIntervalTargeting implements TimeIntervalTargeting {
    public static final long RECHALLENGE_INTERVAL_MS = 60000;
    private long backgroundStartTimeMs;
    private final CoroutineScope coroutineScope;
    private Job intervalJob;
    private boolean isInForeground;
    private long lastDelayStartTimeMs;
    private final SdkLogger logger;
    private Function0<Unit> onTimePassed;
    private long remainingDelayMs;
    private boolean started;
    private final TimestampProvider timestampProvider;

    /* JADX INFO: compiled from: TimeIntervalTargeting.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppLifecycleState.values().length];
            try {
                iArr[AppLifecycleState.FOREGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppLifecycleState.BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SurvicateTimeIntervalTargeting(TimestampProvider timestampProvider, AppLifecycleProvider appLifecycleProvider, SdkLogger logger, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        Intrinsics.checkNotNullParameter(appLifecycleProvider, "appLifecycleProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.timestampProvider = timestampProvider;
        this.logger = logger;
        this.onTimePassed = new Function0() { // from class: com.survicate.surveys.targeting.SurvicateTimeIntervalTargeting$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(mainDispatcher);
        this.remainingDelayMs = 60000L;
        this.isInForeground = appLifecycleProvider.getCurrentState() == AppLifecycleState.FOREGROUND;
        Observable<AppLifecycleState> observableObserveLifecycleChanges = appLifecycleProvider.observeLifecycleChanges();
        final Function1 function1 = new Function1() { // from class: com.survicate.surveys.targeting.SurvicateTimeIntervalTargeting$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateTimeIntervalTargeting._init_$lambda$1(this.f$0, (AppLifecycleState) obj);
            }
        };
        observableObserveLifecycleChanges.addObserver(new Observable.Observer() { // from class: com.survicate.surveys.targeting.SurvicateTimeIntervalTargeting$$ExternalSyntheticLambda2
            @Override // com.survicate.surveys.helpers.Observable.Observer
            public final void update(Object obj) {
                function1.invoke(obj);
            }
        });
    }

    @Override // com.survicate.surveys.targeting.TimeIntervalTargeting
    public Function0<Unit> getOnTimePassed() {
        return this.onTimePassed;
    }

    @Override // com.survicate.surveys.targeting.TimeIntervalTargeting
    public void setOnTimePassed(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onTimePassed = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(SurvicateTimeIntervalTargeting survicateTimeIntervalTargeting, AppLifecycleState lifecycleState) {
        Intrinsics.checkNotNullParameter(lifecycleState, "lifecycleState");
        int i = WhenMappings.$EnumSwitchMapping$0[lifecycleState.ordinal()];
        if (i == 1) {
            survicateTimeIntervalTargeting.onAppForeground();
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            survicateTimeIntervalTargeting.onAppBackground();
        }
        return Unit.INSTANCE;
    }

    private final void onAppForeground() {
        if (!this.isInForeground && this.started) {
            long jCurrentTimeMillis = this.timestampProvider.currentTimeMillis() - this.backgroundStartTimeMs;
            this.remainingDelayMs = Math.max(0L, this.remainingDelayMs - jCurrentTimeMillis);
            this.logger.info(LogTags.TARGETING, "App returned to foreground. Time in background: " + jCurrentTimeMillis + "ms, remaining delay: " + this.remainingDelayMs + "ms");
            startTimer();
        }
        this.isInForeground = true;
    }

    private final void onAppBackground() {
        if (this.isInForeground && this.started) {
            this.remainingDelayMs = Math.max(0L, this.remainingDelayMs - (this.timestampProvider.currentTimeMillis() - this.lastDelayStartTimeMs));
            this.backgroundStartTimeMs = this.timestampProvider.currentTimeMillis();
            this.logger.info(LogTags.TARGETING, "App went to background. Pausing timer, remaining delay: " + this.remainingDelayMs + "ms");
            Job job = this.intervalJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
        this.isInForeground = false;
    }

    @Override // com.survicate.surveys.targeting.TimeIntervalTargeting
    public void start() {
        this.started = true;
        this.remainingDelayMs = 60000L;
        if (this.isInForeground) {
            startTimer();
        } else {
            this.logger.info(LogTags.TARGETING, "Timer started but app is in background. Will resume when app returns to foreground.");
        }
    }

    private final void startTimer() {
        Job job = this.intervalJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.intervalJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C84841(null), 3, null);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.SurvicateTimeIntervalTargeting$startTimer$1 */
    /* JADX INFO: compiled from: TimeIntervalTargeting.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.targeting.SurvicateTimeIntervalTargeting$startTimer$1", m1609f = "TimeIntervalTargeting.kt", m1610i = {0}, m1611l = {PDFACompliance.e_PDFA9_5}, m1612m = "invokeSuspend", m1613n = {"$this$launch"}, m1615s = {"L$0"})
    static final class C84841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C84841(Continuation<? super C84841> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C84841 c84841 = SurvicateTimeIntervalTargeting.this.new C84841(continuation);
            c84841.L$0 = obj;
            return c84841;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0047 -> B:14:0x004a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                SurvicateTimeIntervalTargeting.this.logger.info(LogTags.TARGETING, "Time interval targeting triggered");
                SurvicateTimeIntervalTargeting.this.getOnTimePassed().invoke();
                SurvicateTimeIntervalTargeting.this.remainingDelayMs = 60000L;
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    SurvicateTimeIntervalTargeting survicateTimeIntervalTargeting = SurvicateTimeIntervalTargeting.this;
                    survicateTimeIntervalTargeting.lastDelayStartTimeMs = survicateTimeIntervalTargeting.timestampProvider.currentTimeMillis();
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    if (DelayKt.delay(SurvicateTimeIntervalTargeting.this.remainingDelayMs, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    SurvicateTimeIntervalTargeting.this.logger.info(LogTags.TARGETING, "Time interval targeting triggered");
                    SurvicateTimeIntervalTargeting.this.getOnTimePassed().invoke();
                    SurvicateTimeIntervalTargeting.this.remainingDelayMs = 60000L;
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    @Override // com.survicate.surveys.targeting.TimeIntervalTargeting
    public void clear() {
        this.started = false;
        Job job = this.intervalJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.remainingDelayMs = 60000L;
    }
}
