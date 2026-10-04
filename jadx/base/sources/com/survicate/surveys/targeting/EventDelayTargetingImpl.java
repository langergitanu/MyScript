package com.survicate.surveys.targeting;

import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.utils.TimestampProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: compiled from: EventDelayTargeting.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\r*\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0002J\u001c\u0010%\u001a\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0082@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0\r2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0015H\u0016J\b\u0010,\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006-"}, m1599d2 = {"Lcom/survicate/surveys/targeting/EventDelayTargetingImpl;", "Lcom/survicate/surveys/targeting/EventDelayTargeting;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/utils/TimestampProvider;Lcom/survicate/surveys/core/logging/SdkLogger;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "delayTriggers", "", "Lcom/survicate/surveys/targeting/EventDelayTrigger;", "delayedEvents", "Lcom/survicate/surveys/targeting/DelayedEvent;", "delayJob", "Lkotlinx/coroutines/Job;", "onDelayElapsed", "Lkotlin/Function0;", "", "getOnDelayElapsed", "()Lkotlin/jvm/functions/Function0;", "setOnDelayElapsed", "(Lkotlin/jvm/functions/Function0;)V", "setupDelayTriggers", "triggers", "scheduleDelayFor", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "withUpdatedHistoryOf", "createDelayedEventsFor", "getAllRemainingDelaysFor", "", "", "events", "scheduleDelays", "delays", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provideDelayedEventsForSurvey", "surveyId", "", "removeOutdatedEvents", "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventDelayTargetingImpl implements EventDelayTargeting {
    private final CoroutineScope coroutineScope;
    private Job delayJob;
    private List<EventDelayTrigger> delayTriggers;
    private List<DelayedEvent> delayedEvents;
    private final SdkLogger logger;
    private Function0<Unit> onDelayElapsed;
    private final TimestampProvider timestampProvider;

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.EventDelayTargetingImpl$scheduleDelays$1 */
    /* JADX INFO: compiled from: EventDelayTargeting.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.targeting.EventDelayTargetingImpl", m1609f = "EventDelayTargeting.kt", m1610i = {0, 0}, m1611l = {101}, m1612m = "scheduleDelays", m1613n = {"delayedTimeTotal", "delayToSchedule"}, m1615s = {"J$0", "J$1"})
    static final class C84801 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C84801(Continuation<? super C84801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventDelayTargetingImpl.this.scheduleDelays(null, this);
        }
    }

    public EventDelayTargetingImpl(TimestampProvider timestampProvider, SdkLogger logger, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.timestampProvider = timestampProvider;
        this.logger = logger;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(mainDispatcher);
        this.delayTriggers = CollectionsKt.emptyList();
        this.delayedEvents = CollectionsKt.emptyList();
        this.onDelayElapsed = new Function0() { // from class: com.survicate.surveys.targeting.EventDelayTargetingImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.survicate.surveys.targeting.EventDelayTargeting
    public Function0<Unit> getOnDelayElapsed() {
        return this.onDelayElapsed;
    }

    @Override // com.survicate.surveys.targeting.EventDelayTargeting
    public void setOnDelayElapsed(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onDelayElapsed = function0;
    }

    @Override // com.survicate.surveys.targeting.EventDelayTargeting
    public void setupDelayTriggers(List<EventDelayTrigger> triggers) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        if (Intrinsics.areEqual(CollectionsKt.toSet(this.delayTriggers), CollectionsKt.toSet(triggers))) {
            return;
        }
        Job job = this.delayJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.delayTriggers = triggers;
        this.delayedEvents = CollectionsKt.emptyList();
    }

    @Override // com.survicate.surveys.targeting.EventDelayTargeting
    public void scheduleDelayFor(ActiveEvent activeEvent) {
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        Job job = this.delayJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        List<DelayedEvent> listPlus = CollectionsKt.plus((Collection) withUpdatedHistoryOf(this.delayedEvents, activeEvent), (Iterable) createDelayedEventsFor(activeEvent));
        this.delayedEvents = listPlus;
        this.delayJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C84791(getAllRemainingDelaysFor(listPlus), null), 3, null);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.EventDelayTargetingImpl$scheduleDelayFor$1 */
    /* JADX INFO: compiled from: EventDelayTargeting.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.targeting.EventDelayTargetingImpl$scheduleDelayFor$1", m1609f = "EventDelayTargeting.kt", m1610i = {}, m1611l = {50}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<Long> $remainingDelays;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C84791(Set<Long> set, Continuation<? super C84791> continuation) {
            super(2, continuation);
            this.$remainingDelays = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventDelayTargetingImpl.this.new C84791(this.$remainingDelays, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (EventDelayTargetingImpl.this.scheduleDelays(this.$remainingDelays, this) == coroutine_suspended) {
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

    private final List<DelayedEvent> withUpdatedHistoryOf(List<DelayedEvent> list, ActiveEvent activeEvent) {
        List<DelayedEvent> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DelayedEvent delayedEventCopy$default : list2) {
            if (Intrinsics.areEqual(delayedEventCopy$default.getActiveEvent().getName(), activeEvent.getName())) {
                delayedEventCopy$default = DelayedEvent.copy$default(delayedEventCopy$default, ActiveEvent.copy$default(delayedEventCopy$default.getActiveEvent(), null, null, 0L, activeEvent.getHistory(), 7, null), null, 0L, 6, null);
            }
            arrayList.add(delayedEventCopy$default);
        }
        return arrayList;
    }

    private final List<DelayedEvent> createDelayedEventsFor(ActiveEvent activeEvent) {
        List<EventDelayTrigger> list = this.delayTriggers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((EventDelayTrigger) obj).getEventName(), activeEvent.getName())) {
                arrayList.add(obj);
            }
        }
        ArrayList<EventDelayTrigger> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (EventDelayTrigger eventDelayTrigger : arrayList2) {
            arrayList3.add(new DelayedEvent(activeEvent, eventDelayTrigger.getSurveyId(), eventDelayTrigger.getDelayMs()));
        }
        return arrayList3;
    }

    private final Set<Long> getAllRemainingDelaysFor(List<DelayedEvent> events) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (DelayedEvent delayedEvent : events) {
            long expectedDelayMs = delayedEvent.getExpectedDelayMs() - (this.timestampProvider.currentTimeMillis() - delayedEvent.getActiveEvent().getInvokeTimeMs());
            if (expectedDelayMs > 0) {
                linkedHashSet.add(Long.valueOf(expectedDelayMs));
            }
        }
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0083 -> B:20:0x0086). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object scheduleDelays(Set<Long> set, Continuation<? super Unit> continuation) {
        C84801 c84801;
        Iterator it;
        long j;
        if (continuation instanceof C84801) {
            c84801 = (C84801) continuation;
            if ((c84801.label & Integer.MIN_VALUE) != 0) {
                c84801.label -= Integer.MIN_VALUE;
            } else {
                c84801 = new C84801(continuation);
            }
        }
        Object obj = c84801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c84801.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            it = CollectionsKt.sorted(set).iterator();
            j = 0;
            if (it.hasNext()) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long jLongValue = c84801.J$1;
            j = c84801.J$0;
            it = (Iterator) c84801.L$0;
            ResultKt.throwOnFailure(obj);
            this.logger.info(LogTags.TARGETING, "Event delay elapsed");
            getOnDelayElapsed().invoke();
            j += jLongValue;
            if (it.hasNext()) {
                jLongValue = ((Number) it.next()).longValue() - j;
                this.logger.info(LogTags.TARGETING, "Scheduling event delay: " + jLongValue + " ms");
                c84801.L$0 = it;
                c84801.J$0 = j;
                c84801.J$1 = jLongValue;
                c84801.label = 1;
                if (DelayKt.delay(jLongValue, c84801) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.logger.info(LogTags.TARGETING, "Event delay elapsed");
                getOnDelayElapsed().invoke();
                j += jLongValue;
                if (it.hasNext()) {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    @Override // com.survicate.surveys.targeting.provider.DelayedEventProvider
    public List<ActiveEvent> provideDelayedEventsForSurvey(String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        List<DelayedEvent> list = this.delayedEvents;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((DelayedEvent) obj).getSurveyId(), surveyId)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((DelayedEvent) it.next()).getActiveEvent());
        }
        return arrayList3;
    }

    @Override // com.survicate.surveys.targeting.EventDelayTargeting
    public void removeOutdatedEvents() {
        long jCurrentTimeMillis = this.timestampProvider.currentTimeMillis();
        List<DelayedEvent> list = this.delayedEvents;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!EventDelayTargetingKt.isElapsed((DelayedEvent) obj, jCurrentTimeMillis)) {
                arrayList.add(obj);
            }
        }
        this.delayedEvents = arrayList;
    }

    @Override // com.survicate.surveys.targeting.EventDelayTargeting
    public void clear() {
        Job job = this.delayJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.delayTriggers = CollectionsKt.emptyList();
        this.delayedEvents = CollectionsKt.emptyList();
    }
}
