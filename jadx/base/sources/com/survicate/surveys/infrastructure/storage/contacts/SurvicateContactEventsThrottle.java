package com.survicate.surveys.infrastructure.storage.contacts;

import androidx.compose.p004ui.spatial.RectListKt;
import com.survicate.surveys.entities.models.ContactAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: ContactEventsThrottle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\u000e\u0010\u001e\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u0019*\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0014\u0010!\u001a\u00020\u000b*\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010H\u0002J\u0014\u0010#\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006$"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/SurvicateContactEventsThrottle;", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactEventsThrottle;", "contactStore", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactStore;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/infrastructure/storage/contacts/ContactStore;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "throttleInProgress", "", "flushJob", "Lkotlinx/coroutines/Job;", "onEventThrottled", "Lkotlin/Function1;", "Lcom/survicate/surveys/entities/models/ContactAction$InvokeEvent;", "", "getOnEventThrottled", "()Lkotlin/jvm/functions/Function1;", "setOnEventThrottled", "(Lkotlin/jvm/functions/Function1;)V", "enqueue", "action", "mergeOrAppend", "", "Lcom/survicate/surveys/entities/models/ContactAction;", "newAction", "scheduleFlush", "onFlushDelayElapsed", "awaitNextFlush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnscheduledEvents", "canBeMergedWith", "other", "mergeWith", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateContactEventsThrottle implements ContactEventsThrottle {
    private final ContactStore contactStore;
    private final CoroutineScope coroutineScope;
    private Job flushJob;
    private Function1<? super ContactAction.InvokeEvent, Unit> onEventThrottled;
    private boolean throttleInProgress;

    public SurvicateContactEventsThrottle(ContactStore contactStore, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(contactStore, "contactStore");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.contactStore = contactStore;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.onEventThrottled = new Function1() { // from class: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactEventsThrottle$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateContactEventsThrottle.onEventThrottled$lambda$0((ContactAction.InvokeEvent) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onEventThrottled$lambda$0(ContactAction.InvokeEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactEventsThrottle
    public Function1<ContactAction.InvokeEvent, Unit> getOnEventThrottled() {
        return this.onEventThrottled;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactEventsThrottle
    public void setOnEventThrottled(Function1<? super ContactAction.InvokeEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onEventThrottled = function1;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactEventsThrottle
    public void enqueue(final ContactAction.InvokeEvent action) {
        Intrinsics.checkNotNullParameter(action, "action");
        synchronized (this.contactStore) {
            this.contactStore.updateContactActions(new Function1() { // from class: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactEventsThrottle$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SurvicateContactEventsThrottle.enqueue$lambda$2$lambda$1(this.f$0, action, (List) obj);
                }
            });
            if (!this.throttleInProgress) {
                this.throttleInProgress = true;
                scheduleFlush();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List enqueue$lambda$2$lambda$1(SurvicateContactEventsThrottle survicateContactEventsThrottle, ContactAction.InvokeEvent invokeEvent, List currentActions) {
        Intrinsics.checkNotNullParameter(currentActions, "currentActions");
        return survicateContactEventsThrottle.mergeOrAppend(currentActions, invokeEvent);
    }

    private final List<ContactAction> mergeOrAppend(List<? extends ContactAction> list, ContactAction.InvokeEvent invokeEvent) {
        ContactAction.InvokeEvent invokeEvent2 = (ContactAction.InvokeEvent) CollectionsKt.lastOrNull((List) getUnscheduledEvents(list));
        if (invokeEvent2 == null || !canBeMergedWith(invokeEvent2, invokeEvent)) {
            return CollectionsKt.plus((Collection<? extends ContactAction.InvokeEvent>) list, invokeEvent);
        }
        List<? extends ContactAction> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Object objMergeWith : list2) {
            if (Intrinsics.areEqual(objMergeWith, invokeEvent2)) {
                objMergeWith = mergeWith(invokeEvent2, invokeEvent);
            }
            arrayList.add(objMergeWith);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactEventsThrottle$scheduleFlush$1 */
    /* JADX INFO: compiled from: ContactEventsThrottle.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactEventsThrottle$scheduleFlush$1", m1609f = "ContactEventsThrottle.kt", m1610i = {}, m1611l = {RectListKt.BitOffsetForGesturable}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C84161(Continuation<? super C84161> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SurvicateContactEventsThrottle.this.new C84161(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            SurvicateContactEventsThrottle.this.onFlushDelayElapsed();
            return Unit.INSTANCE;
        }
    }

    private final void scheduleFlush() {
        Job job = this.flushJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.flushJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C84161(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.util.List] */
    public final void onFlushDelayElapsed() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.contactStore) {
            List<ContactAction.InvokeEvent> unscheduledEvents = getUnscheduledEvents(this.contactStore.loadContactActions());
            ContactEventsThrottleKt.markEventsAsScheduled(this.contactStore);
            List<ContactAction.InvokeEvent> list = unscheduledEvents;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ContactAction.InvokeEvent.copy$default((ContactAction.InvokeEvent) it.next(), null, null, null, null, true, 15, null));
            }
            objectRef.element = arrayList;
            this.throttleInProgress = false;
            Unit unit = Unit.INSTANCE;
        }
        Iterator it2 = ((List) objectRef.element).iterator();
        while (it2.hasNext()) {
            getOnEventThrottled().invoke((ContactAction.InvokeEvent) it2.next());
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactEventsThrottle
    public Object awaitNextFlush(Continuation<? super Unit> continuation) {
        Job job;
        Object objJoin;
        synchronized (this.contactStore) {
            job = this.flushJob;
        }
        return (job != null && (objJoin = job.join(continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objJoin : Unit.INSTANCE;
    }

    private final List<ContactAction.InvokeEvent> getUnscheduledEvents(List<? extends ContactAction> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof ContactAction.InvokeEvent) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!((ContactAction.InvokeEvent) obj2).isScheduled()) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    private final boolean canBeMergedWith(ContactAction.InvokeEvent invokeEvent, ContactAction.InvokeEvent invokeEvent2) {
        return Intrinsics.areEqual(invokeEvent.getUserId(), invokeEvent2.getUserId()) && Intrinsics.areEqual(invokeEvent.getUserKey(), invokeEvent2.getUserKey()) && Intrinsics.areEqual(invokeEvent.getRespondentUuid(), invokeEvent2.getRespondentUuid()) && invokeEvent.getEvents().size() + invokeEvent2.getEvents().size() <= 100;
    }

    private final ContactAction.InvokeEvent mergeWith(ContactAction.InvokeEvent invokeEvent, ContactAction.InvokeEvent invokeEvent2) {
        return new ContactAction.InvokeEvent(invokeEvent.getUserId(), invokeEvent.getUserKey(), invokeEvent.getRespondentUuid(), CollectionsKt.plus((Collection) invokeEvent.getEvents(), (Iterable) invokeEvent2.getEvents()), invokeEvent.isScheduled());
    }
}
