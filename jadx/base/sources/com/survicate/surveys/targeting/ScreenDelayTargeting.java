package com.survicate.surveys.targeting;

import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.core.models.ActiveScreen;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.utils.TimestampProvider;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ScreenDelayTargeting.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\"\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\rH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J*\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0082@¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019J\u0006\u0010\"\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m1599d2 = {"Lcom/survicate/surveys/targeting/ScreenDelayTargeting;", "", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/utils/TimestampProvider;Lcom/survicate/surveys/core/logging/SdkLogger;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "screenTriggers", "", "Lcom/survicate/surveys/targeting/ScreenDelayTrigger;", "activeScreenDelayJob", "Lkotlinx/coroutines/Job;", "screenOrientationDelayJob", "setupDelayTriggers", "", "triggers", "updateActiveScreens", "activeScreens", "Lcom/survicate/surveys/core/models/ActiveScreen;", "onDelayElapsed", "Lkotlin/Function0;", "getAllRemainingDelaysFor", "", "findMatchingTriggerFor", "activeScreen", "scheduleScreenDelays", "delays", "(Ljava/util/Set;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleScreenOrientationDelay", "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ScreenDelayTargeting {
    private Job activeScreenDelayJob;
    private final CoroutineScope coroutineScope;
    private final SdkLogger logger;
    private Job screenOrientationDelayJob;
    private Set<ScreenDelayTrigger> screenTriggers;
    private final TimestampProvider timestampProvider;

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.ScreenDelayTargeting$scheduleScreenDelays$1 */
    /* JADX INFO: compiled from: ScreenDelayTargeting.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.targeting.ScreenDelayTargeting", m1609f = "ScreenDelayTargeting.kt", m1610i = {0, 0, 0}, m1611l = {72}, m1612m = "scheduleScreenDelays", m1613n = {"onDelayElapsed", "delayedTimeTotal", "delayToSchedule"}, m1615s = {"L$0", "J$0", "J$1"})
    static final class C84811 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C84811(Continuation<? super C84811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScreenDelayTargeting.this.scheduleScreenDelays(null, null, this);
        }
    }

    public ScreenDelayTargeting(TimestampProvider timestampProvider, SdkLogger logger, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.timestampProvider = timestampProvider;
        this.logger = logger;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(mainDispatcher);
        this.screenTriggers = SetsKt.emptySet();
    }

    public final void setupDelayTriggers(Set<ScreenDelayTrigger> triggers) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        this.screenTriggers = triggers;
        Job job = this.activeScreenDelayJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void updateActiveScreens(Set<ActiveScreen> activeScreens, Function0<Unit> onDelayElapsed) {
        Intrinsics.checkNotNullParameter(activeScreens, "activeScreens");
        Intrinsics.checkNotNullParameter(onDelayElapsed, "onDelayElapsed");
        Job job = this.activeScreenDelayJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.activeScreenDelayJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C84831(getAllRemainingDelaysFor(activeScreens), onDelayElapsed, null), 3, null);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.ScreenDelayTargeting$updateActiveScreens$1 */
    /* JADX INFO: compiled from: ScreenDelayTargeting.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.targeting.ScreenDelayTargeting$updateActiveScreens$1", m1609f = "ScreenDelayTargeting.kt", m1610i = {}, m1611l = {37}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDelayElapsed;
        final /* synthetic */ Set<Long> $remainingDelays;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C84831(Set<Long> set, Function0<Unit> function0, Continuation<? super C84831> continuation) {
            super(2, continuation);
            this.$remainingDelays = set;
            this.$onDelayElapsed = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScreenDelayTargeting.this.new C84831(this.$remainingDelays, this.$onDelayElapsed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ScreenDelayTargeting.this.scheduleScreenDelays(this.$remainingDelays, this.$onDelayElapsed, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final Set<Long> getAllRemainingDelaysFor(Set<ActiveScreen> activeScreens) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ActiveScreen activeScreen : activeScreens) {
            ScreenDelayTrigger screenDelayTriggerFindMatchingTriggerFor = findMatchingTriggerFor(activeScreen);
            if (screenDelayTriggerFindMatchingTriggerFor != null && screenDelayTriggerFindMatchingTriggerFor.getDelayInSeconds() > 0) {
                long delayInSeconds = (((long) screenDelayTriggerFindMatchingTriggerFor.getDelayInSeconds()) * 1000) - (this.timestampProvider.currentTimeMillis() - activeScreen.getTimeOfCreationMs());
                if (delayInSeconds > 0) {
                    linkedHashSet.add(Long.valueOf(delayInSeconds));
                }
            }
        }
        return linkedHashSet;
    }

    private final ScreenDelayTrigger findMatchingTriggerFor(ActiveScreen activeScreen) {
        Object next;
        Iterator<T> it = this.screenTriggers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((ScreenDelayTrigger) next).getScreenName(), activeScreen.getScreenName())) {
                break;
            }
        }
        return (ScreenDelayTrigger) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x008c -> B:21:0x008f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object scheduleScreenDelays(Set<Long> set, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        C84811 c84811;
        long j;
        Iterator it;
        if (continuation instanceof C84811) {
            c84811 = (C84811) continuation;
            if ((c84811.label & Integer.MIN_VALUE) != 0) {
                c84811.label -= Integer.MIN_VALUE;
            } else {
                c84811 = new C84811(continuation);
            }
        }
        Object obj = c84811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c84811.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j = 0;
            it = CollectionsKt.sorted(set).iterator();
            if (it.hasNext()) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = c84811.J$1;
            j = c84811.J$0;
            it = (Iterator) c84811.L$1;
            Function0<Unit> function02 = (Function0) c84811.L$0;
            ResultKt.throwOnFailure(obj);
            this.logger.info(LogTags.TARGETING, "Delay elapsed");
            function02.invoke();
            j += j2;
            function0 = function02;
            if (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue() - j;
                this.logger.info(LogTags.TARGETING, "Scheduling screen delay: " + jLongValue + " ms");
                c84811.L$0 = function0;
                c84811.L$1 = it;
                c84811.J$0 = j;
                c84811.J$1 = jLongValue;
                c84811.label = 1;
                if (DelayKt.delay(jLongValue, c84811) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function02 = function0;
                j2 = jLongValue;
                this.logger.info(LogTags.TARGETING, "Delay elapsed");
                function02.invoke();
                j += j2;
                function0 = function02;
                if (it.hasNext()) {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.ScreenDelayTargeting$scheduleScreenOrientationDelay$1 */
    /* JADX INFO: compiled from: ScreenDelayTargeting.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.targeting.ScreenDelayTargeting$scheduleScreenOrientationDelay$1", m1609f = "ScreenDelayTargeting.kt", m1610i = {}, m1611l = {82}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDelayElapsed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C84821(Function0<Unit> function0, Continuation<? super C84821> continuation) {
            super(2, continuation);
            this.$onDelayElapsed = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C84821(this.$onDelayElapsed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$onDelayElapsed.invoke();
            return Unit.INSTANCE;
        }
    }

    public final void scheduleScreenOrientationDelay(Function0<Unit> onDelayElapsed) {
        Intrinsics.checkNotNullParameter(onDelayElapsed, "onDelayElapsed");
        Job job = this.screenOrientationDelayJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.screenOrientationDelayJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C84821(onDelayElapsed, null), 3, null);
    }

    public final void clear() {
        Job job = this.activeScreenDelayJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.screenOrientationDelayJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.screenTriggers = SetsKt.emptySet();
    }
}
