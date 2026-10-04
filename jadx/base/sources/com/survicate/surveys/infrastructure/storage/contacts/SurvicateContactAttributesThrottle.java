package com.survicate.surveys.infrastructure.storage.contacts;

import com.survicate.surveys.PersistenceManager;
import com.survicate.surveys.core.utils.Executor;
import com.survicate.surveys.helpers.UserTraitUtilsKt;
import com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactAttributesThrottle;
import com.survicate.surveys.traits.UserTrait;
import com.survicate.surveys.utils.TimestampProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: ContactAttributesThrottle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u001a\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u001fJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J$\u0010#\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0016\u0010%\u001a\u00020\u00112\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/SurvicateContactAttributesThrottle;", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactAttributesThrottle;", "persistenceManager", "Lcom/survicate/surveys/PersistenceManager;", "contactsRepository", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "sdkExecutor", "Lcom/survicate/surveys/core/utils/Executor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/PersistenceManager;Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;Lcom/survicate/surveys/utils/TimestampProvider;Lcom/survicate/surveys/core/utils/Executor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "sendThrottledTraits", "", "getElapsedTraits", "", "Lcom/survicate/surveys/traits/UserTrait;", "savedTraits", "updateThrottleTimestamps", "updatedTraits", "applyThrottling", "updatedTrait", "savedTrait", "canApplyThrottling", "", "calculateThrottleTimestamp", "", "(Lcom/survicate/surveys/traits/UserTrait;Lcom/survicate/surveys/traits/UserTrait;)Ljava/lang/Long;", "getTraitsReadyToSend", "traits", "flush", "sendTraits", "toSend", "markTraitsAsSent", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateContactAttributesThrottle implements ContactAttributesThrottle {
    private final ContactsRepository contactsRepository;
    private final CoroutineScope coroutineScope;
    private final PersistenceManager persistenceManager;
    private final Executor sdkExecutor;
    private final TimestampProvider timestampProvider;

    public SurvicateContactAttributesThrottle(PersistenceManager persistenceManager, ContactsRepository contactsRepository, TimestampProvider timestampProvider, Executor sdkExecutor, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(persistenceManager, "persistenceManager");
        Intrinsics.checkNotNullParameter(contactsRepository, "contactsRepository");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        Intrinsics.checkNotNullParameter(sdkExecutor, "sdkExecutor");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.persistenceManager = persistenceManager;
        this.contactsRepository = contactsRepository;
        this.timestampProvider = timestampProvider;
        this.sdkExecutor = sdkExecutor;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.coroutineScope = CoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C84151(null), 3, null);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactAttributesThrottle$1 */
    /* JADX INFO: compiled from: ContactAttributesThrottle.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactAttributesThrottle$1", m1609f = "ContactAttributesThrottle.kt", m1610i = {0}, m1611l = {41}, m1612m = "invokeSuspend", m1613n = {"$this$launch"}, m1615s = {"L$0"})
    static final class C84151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C84151(Continuation<? super C84151> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C84151 c84151 = SurvicateContactAttributesThrottle.this.new C84151(continuation);
            c84151.L$0 = obj;
            return c84151;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (CoroutineScopeKt.isActive(coroutineScope)) {
                Executor executor = SurvicateContactAttributesThrottle.this.sdkExecutor;
                final SurvicateContactAttributesThrottle survicateContactAttributesThrottle = SurvicateContactAttributesThrottle.this;
                executor.post(new Function0() { // from class: com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactAttributesThrottle$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SurvicateContactAttributesThrottle.C84151.invokeSuspend$lambda$0(survicateContactAttributesThrottle);
                    }
                });
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.m16008delayVtjQ1oo(ContactAttributesThrottleKt.TIMER_INTERVAL, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(SurvicateContactAttributesThrottle survicateContactAttributesThrottle) {
            survicateContactAttributesThrottle.sendThrottledTraits();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendThrottledTraits() {
        List<UserTrait> listProvideUserTraits = this.persistenceManager.provideUserTraits();
        List<UserTrait> elapsedTraits = getElapsedTraits(listProvideUserTraits);
        if (elapsedTraits.isEmpty()) {
            return;
        }
        sendTraits(elapsedTraits, listProvideUserTraits);
    }

    private final List<UserTrait> getElapsedTraits(List<? extends UserTrait> savedTraits) {
        long jCurrentTimeMillis = this.timestampProvider.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (Object obj : savedTraits) {
            Long throttledToMs = ((UserTrait) obj).getThrottledToMs();
            if (throttledToMs != null && jCurrentTimeMillis >= throttledToMs.longValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactAttributesThrottle
    public List<UserTrait> updateThrottleTimestamps(List<? extends UserTrait> updatedTraits, List<? extends UserTrait> savedTraits) {
        Intrinsics.checkNotNullParameter(updatedTraits, "updatedTraits");
        Intrinsics.checkNotNullParameter(savedTraits, "savedTraits");
        List<? extends UserTrait> list = savedTraits;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((UserTrait) obj).key, obj);
        }
        List<? extends UserTrait> list2 = updatedTraits;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (UserTrait userTrait : list2) {
            arrayList.add(applyThrottling(userTrait, (UserTrait) linkedHashMap.get(userTrait.key)));
        }
        return arrayList;
    }

    private final UserTrait applyThrottling(UserTrait updatedTrait, UserTrait savedTrait) {
        if (savedTrait == null || !canApplyThrottling(updatedTrait, savedTrait)) {
            return updatedTrait;
        }
        UserTrait userTraitCopy$survicate_sdk_release = updatedTrait.copy$survicate_sdk_release();
        userTraitCopy$survicate_sdk_release.setThrottledToMs$survicate_sdk_release(calculateThrottleTimestamp(updatedTrait, savedTrait));
        return userTraitCopy$survicate_sdk_release;
    }

    private final boolean canApplyThrottling(UserTrait updatedTrait, UserTrait savedTrait) {
        return (UserTraitUtilsKt.isCredential(updatedTrait) || savedTrait.getTimestampMs() == null) ? false : true;
    }

    private final Long calculateThrottleTimestamp(UserTrait updatedTrait, UserTrait savedTrait) {
        Long timestampMs = updatedTrait.getTimestampMs();
        long jLongValue = timestampMs != null ? timestampMs.longValue() : 0L;
        Long timestampMs2 = savedTrait.getTimestampMs();
        long jLongValue2 = timestampMs2 != null ? timestampMs2.longValue() : 0L;
        if (jLongValue - jLongValue2 < Duration.m15867getInWholeMillisecondsimpl(ContactAttributesThrottleKt.THROTTLE_DELAY) && savedTrait.getThrottledToMs() == null) {
            return Long.valueOf(jLongValue2 + Duration.m15867getInWholeMillisecondsimpl(ContactAttributesThrottleKt.THROTTLE_DELAY));
        }
        return savedTrait.getThrottledToMs();
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactAttributesThrottle
    public List<UserTrait> getTraitsReadyToSend(List<? extends UserTrait> traits) {
        Intrinsics.checkNotNullParameter(traits, "traits");
        ArrayList arrayList = new ArrayList();
        for (Object obj : traits) {
            if (((UserTrait) obj).getThrottledToMs() == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactAttributesThrottle
    public void flush() {
        List<UserTrait> listProvideUserTraits = this.persistenceManager.provideUserTraits();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listProvideUserTraits) {
            if (((UserTrait) obj).getThrottledToMs() != null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        sendTraits(arrayList2, listProvideUserTraits);
    }

    private final void sendTraits(List<? extends UserTrait> toSend, List<? extends UserTrait> savedTraits) {
        this.contactsRepository.updateUserTraits(toSend, savedTraits);
        markTraitsAsSent(toSend);
    }

    private final void markTraitsAsSent(List<? extends UserTrait> traits) {
        List<? extends UserTrait> list = traits;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            UserTrait userTraitCopy$survicate_sdk_release = ((UserTrait) it.next()).copy$survicate_sdk_release();
            userTraitCopy$survicate_sdk_release.setThrottledToMs$survicate_sdk_release(null);
            arrayList.add(userTraitCopy$survicate_sdk_release);
        }
        this.persistenceManager.saveTraits(arrayList);
    }
}
