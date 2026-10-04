package com.survicate.surveys.targeting;

import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.core.queue.BackoffStrategy;
import com.survicate.surveys.core.queue.JitterBackoffStrategy;
import com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore;
import com.survicate.surveys.entities.survey.Survey;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.infrastructure.network.HttpException;
import com.survicate.surveys.infrastructure.network.HttpExceptionKt;
import com.survicate.surveys.infrastructure.network.contacts.BackendTargetingAudienceResult;
import com.survicate.surveys.infrastructure.network.contacts.BackendTargetingResult;
import com.survicate.surveys.infrastructure.network.contacts.BackendTargetingResultKt;
import com.survicate.surveys.infrastructure.network.contacts.BackendTargetingSurveyResult;
import com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository;
import com.survicate.surveys.targeting.audience.Audience;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BackendTargetingResultLoader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0086@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J*\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fH\u0082@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m1599d2 = {"Lcom/survicate/surveys/targeting/BackendTargetingResultLoader;", "", "backendTargetingResultStore", "Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultStore;", "contactsRepository", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;", "backoffStrategy", "Lcom/survicate/surveys/core/queue/BackoffStrategy;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultStore;Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;Lcom/survicate/surveys/core/queue/BackoffStrategy;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "loadResultsFor", "", "surveys", "", "Lcom/survicate/surveys/entities/survey/Survey;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDistinctAudienceIdsFrom", "", "loadTargetingResult", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingResult;", "surveyIds", "", "audienceIds", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldRetry", "", "error", "", "attemptNumber", "", "(Ljava/lang/Throwable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canRetryError", "logResult", "result", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BackendTargetingResultLoader {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_RETRY_ATTEMPTS = 7;
    private final BackendTargetingResultStore backendTargetingResultStore;
    private final BackoffStrategy backoffStrategy;
    private final ContactsRepository contactsRepository;
    private final SdkLogger logger;

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.BackendTargetingResultLoader$loadResultsFor$1 */
    /* JADX INFO: compiled from: BackendTargetingResultLoader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.targeting.BackendTargetingResultLoader", m1609f = "BackendTargetingResultLoader.kt", m1610i = {}, m1611l = {40}, m1612m = "loadResultsFor", m1613n = {}, m1615s = {})
    static final class C84751 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C84751(Continuation<? super C84751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BackendTargetingResultLoader.this.loadResultsFor(null, this);
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.BackendTargetingResultLoader$shouldRetry$1 */
    /* JADX INFO: compiled from: BackendTargetingResultLoader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.targeting.BackendTargetingResultLoader", m1609f = "BackendTargetingResultLoader.kt", m1610i = {}, m1611l = {77}, m1612m = "shouldRetry", m1613n = {}, m1615s = {})
    static final class C84781 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C84781(Continuation<? super C84781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BackendTargetingResultLoader.this.shouldRetry(null, 0, this);
        }
    }

    @JvmStatic
    public static final BackoffStrategy defaultBackoffStrategy() {
        return INSTANCE.defaultBackoffStrategy();
    }

    public BackendTargetingResultLoader(BackendTargetingResultStore backendTargetingResultStore, ContactsRepository contactsRepository, BackoffStrategy backoffStrategy, SdkLogger logger) {
        Intrinsics.checkNotNullParameter(backendTargetingResultStore, "backendTargetingResultStore");
        Intrinsics.checkNotNullParameter(contactsRepository, "contactsRepository");
        Intrinsics.checkNotNullParameter(backoffStrategy, "backoffStrategy");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.backendTargetingResultStore = backendTargetingResultStore;
        this.contactsRepository = contactsRepository;
        this.backoffStrategy = backoffStrategy;
        this.logger = logger;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadResultsFor(List<Survey> list, Continuation<? super Unit> continuation) {
        C84751 c84751;
        if (continuation instanceof C84751) {
            c84751 = (C84751) continuation;
            if ((c84751.label & Integer.MIN_VALUE) != 0) {
                c84751.label -= Integer.MIN_VALUE;
            } else {
                c84751 = new C84751(continuation);
            }
        }
        Object objLoadTargetingResult = c84751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c84751.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objLoadTargetingResult);
            List<Survey> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((Survey) it.next()).getId());
            }
            List<String> surveysToRefresh = this.backendTargetingResultStore.getSurveysToRefresh(arrayList);
            List<Long> audiencesToRefresh = this.backendTargetingResultStore.getAudiencesToRefresh(getDistinctAudienceIdsFrom(list));
            if (surveysToRefresh.isEmpty() && audiencesToRefresh.isEmpty()) {
                return Unit.INSTANCE;
            }
            this.logger.info(LogTags.TARGETING, "Loading targeting result for: " + surveysToRefresh.size() + " surveys, " + audiencesToRefresh.size() + " audiences");
            c84751.label = 1;
            objLoadTargetingResult = loadTargetingResult(surveysToRefresh, audiencesToRefresh, c84751);
            if (objLoadTargetingResult == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objLoadTargetingResult);
        }
        BackendTargetingResult backendTargetingResult = (BackendTargetingResult) objLoadTargetingResult;
        logResult(backendTargetingResult);
        List<BackendTargetingSurveyResult> surveys = backendTargetingResult.getSurveys();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(surveys, 10));
        Iterator<T> it2 = surveys.iterator();
        while (it2.hasNext()) {
            arrayList2.add(BackendTargetingResultKt.toCoreResult((BackendTargetingSurveyResult) it2.next()));
        }
        this.backendTargetingResultStore.updateSurveyResults(arrayList2);
        List<BackendTargetingAudienceResult> audiences = backendTargetingResult.getAudiences();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(audiences, 10));
        Iterator<T> it3 = audiences.iterator();
        while (it3.hasNext()) {
            arrayList3.add(BackendTargetingResultKt.toCoreResult((BackendTargetingAudienceResult) it3.next()));
        }
        this.backendTargetingResultStore.updateAudienceResults(arrayList3);
        return Unit.INSTANCE;
    }

    private final List<Long> getDistinctAudienceIdsFrom(List<Survey> surveys) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = surveys.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((Survey) it.next()).getAudiences());
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Long.valueOf(((Audience) it2.next()).getId()));
        }
        return CollectionsKt.distinct(arrayList3);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.BackendTargetingResultLoader$loadTargetingResult$2 */
    /* JADX INFO: compiled from: BackendTargetingResultLoader.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingResult;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.targeting.BackendTargetingResultLoader$loadTargetingResult$2", m1609f = "BackendTargetingResultLoader.kt", m1610i = {}, m1611l = {59, 59}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84762 extends SuspendLambda implements Function2<FlowCollector<? super BackendTargetingResult>, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Long> $audienceIds;
        final /* synthetic */ List<String> $surveyIds;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C84762(List<String> list, List<Long> list2, Continuation<? super C84762> continuation) {
            super(2, continuation);
            this.$surveyIds = list;
            this.$audienceIds = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C84762 c84762 = BackendTargetingResultLoader.this.new C84762(this.$surveyIds, this.$audienceIds, continuation);
            c84762.L$0 = obj;
            return c84762;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super BackendTargetingResult> flowCollector, Continuation<? super Unit> continuation) {
            return ((C84762) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
        
            if (r1.emit(r8, r7) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws IOException {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                this.L$0 = flowCollector;
                this.label = 1;
                obj = BackendTargetingResultLoader.this.contactsRepository.checkBackendTargeting(this.$surveyIds, this.$audienceIds, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadTargetingResult(List<String> list, List<Long> list2, Continuation<? super BackendTargetingResult> continuation) {
        return FlowKt.first(FlowKt.retryWhen(FlowKt.flow(new C84762(list, list2, null)), new C84773(null)), continuation);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.BackendTargetingResultLoader$loadTargetingResult$3 */
    /* JADX INFO: compiled from: BackendTargetingResultLoader.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingResult;", "error", "", "attemptIdx", ""}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.targeting.BackendTargetingResultLoader$loadTargetingResult$3", m1609f = "BackendTargetingResultLoader.kt", m1610i = {}, m1611l = {61}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84773 extends SuspendLambda implements Function4<FlowCollector<? super BackendTargetingResult>, Throwable, Long, Continuation<? super Boolean>, Object> {
        /* synthetic */ long J$0;
        /* synthetic */ Object L$0;
        int label;

        C84773(Continuation<? super C84773> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super BackendTargetingResult> flowCollector, Throwable th, Long l, Continuation<? super Boolean> continuation) {
            return invoke(flowCollector, th, l.longValue(), continuation);
        }

        public final Object invoke(FlowCollector<? super BackendTargetingResult> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
            C84773 c84773 = BackendTargetingResultLoader.this.new C84773(continuation);
            c84773.L$0 = th;
            c84773.J$0 = j;
            return c84773.invokeSuspend(Unit.INSTANCE);
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
            Throwable th = (Throwable) this.L$0;
            long j = this.J$0;
            this.label = 1;
            Object objShouldRetry = BackendTargetingResultLoader.this.shouldRetry(th, ((int) j) + 1, this);
            return objShouldRetry == coroutine_suspended ? coroutine_suspended : objShouldRetry;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object shouldRetry(Throwable th, int i, Continuation<? super Boolean> continuation) {
        C84781 c84781;
        if (continuation instanceof C84781) {
            c84781 = (C84781) continuation;
            if ((c84781.label & Integer.MIN_VALUE) != 0) {
                c84781.label -= Integer.MIN_VALUE;
            } else {
                c84781 = new C84781(continuation);
            }
        }
        Object obj = c84781.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c84781.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!canRetryError(th)) {
                return Boxing.boxBoolean(false);
            }
            long delayMillis = this.backoffStrategy.getDelayMillis(i);
            if (delayMillis < 0) {
                return Boxing.boxBoolean(false);
            }
            this.logger.error(LogTags.TARGETING, "Failed to load targeting result. Retry " + i + " in " + delayMillis + " ms", th);
            c84781.label = 1;
            if (DelayKt.delay(delayMillis, c84781) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(true);
    }

    private final boolean canRetryError(Throwable error) {
        if (error instanceof HttpException) {
            return HttpExceptionKt.canRetry((HttpException) error);
        }
        return error instanceof IOException;
    }

    private final void logResult(BackendTargetingResult result) {
        int i;
        List<BackendTargetingSurveyResult> surveys = result.getSurveys();
        int i2 = 0;
        if ((surveys instanceof Collection) && surveys.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = surveys.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((BackendTargetingSurveyResult) it.next()).getCanShow() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        List<BackendTargetingAudienceResult> audiences = result.getAudiences();
        if (!(audiences instanceof Collection) || !audiences.isEmpty()) {
            Iterator<T> it2 = audiences.iterator();
            while (it2.hasNext()) {
                if (((BackendTargetingAudienceResult) it2.next()).isSatisfied() && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        this.logger.info(LogTags.TARGETING, "Loaded targeting result: " + i + " approved surveys, " + i2 + " approved audiences");
    }

    /* JADX INFO: compiled from: BackendTargetingResultLoader.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/targeting/BackendTargetingResultLoader$Companion;", "", "<init>", "()V", "MAX_RETRY_ATTEMPTS", "", "defaultBackoffStrategy", "Lcom/survicate/surveys/core/queue/BackoffStrategy;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BackoffStrategy defaultBackoffStrategy() {
            return new JitterBackoffStrategy(7);
        }
    }
}
