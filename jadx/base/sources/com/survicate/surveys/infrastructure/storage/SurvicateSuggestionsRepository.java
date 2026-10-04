package com.survicate.surveys.infrastructure.storage;

import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.entities.models.EventSuggestion;
import com.survicate.surveys.entities.models.EventSuggestionKt;
import com.survicate.surveys.entities.survey.Workspace;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.infrastructure.network.EventSuggestionRequestBodyKt;
import com.survicate.surveys.infrastructure.network.HttpException;
import com.survicate.surveys.infrastructure.network.SuggestionsApi;
import com.survicate.surveys.infrastructure.storage.interfaces.SuggestionsRepository;
import com.survicate.surveys.targeting.ActiveEvent;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: SurvicateSuggestionsRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u000eH\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u000eH\u0002J\u0014\u0010\"\u001a\u00020\u00142\n\u0010#\u001a\u00060$j\u0002`%H\u0002J\b\u0010&\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/SurvicateSuggestionsRepository;", "Lcom/survicate/surveys/infrastructure/storage/interfaces/SuggestionsRepository;", "suggestionsApi", "Lcom/survicate/surveys/infrastructure/network/SuggestionsApi;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/SuggestionsApi;Lcom/survicate/surveys/core/logging/SdkLogger;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "workspaceSuggestions", "", "Lcom/survicate/surveys/entities/models/EventSuggestion;", "localSuggestions", "suggestionsEnabled", "", "sendingBlockedInSession", "updateSuggestionsFrom", "", "workspace", "Lcom/survicate/surveys/entities/survey/Workspace;", "addEventSuggestionFor", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "getNewSuggestionFor", "isEventNameAlreadySent", "eventName", "", "getNewPropertiesFor", "sendSuggestion", "suggestion", "cacheSuggestion", "logEventSendingError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateSuggestionsRepository implements SuggestionsRepository {
    private final CoroutineScope coroutineScope;
    private final CoroutineDispatcher ioDispatcher;
    private List<EventSuggestion> localSuggestions;
    private final SdkLogger logger;
    private boolean sendingBlockedInSession;
    private final SuggestionsApi suggestionsApi;
    private boolean suggestionsEnabled;
    private List<EventSuggestion> workspaceSuggestions;

    public SurvicateSuggestionsRepository(SuggestionsApi suggestionsApi, SdkLogger logger, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(suggestionsApi, "suggestionsApi");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.suggestionsApi = suggestionsApi;
        this.logger = logger;
        this.ioDispatcher = ioDispatcher;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(ioDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.workspaceSuggestions = CollectionsKt.emptyList();
        this.localSuggestions = CollectionsKt.emptyList();
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.SuggestionsRepository
    public void updateSuggestionsFrom(Workspace workspace) {
        Intrinsics.checkNotNullParameter(workspace, "workspace");
        this.workspaceSuggestions = workspace.getEventSuggestions();
        this.suggestionsEnabled = workspace.getEventSuggestionsEnabled();
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.SuggestionsRepository
    public void addEventSuggestionFor(ActiveEvent activeEvent) {
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        EventSuggestion newSuggestionFor = getNewSuggestionFor(activeEvent);
        if (newSuggestionFor == null || !this.suggestionsEnabled || this.sendingBlockedInSession) {
            return;
        }
        sendSuggestion(newSuggestionFor);
        cacheSuggestion(newSuggestionFor);
    }

    private final EventSuggestion getNewSuggestionFor(ActiveEvent activeEvent) {
        if (!isEventNameAlreadySent(activeEvent.getName())) {
            return EventSuggestion.INSTANCE.fromActiveEvent(activeEvent);
        }
        List<String> newPropertiesFor = getNewPropertiesFor(activeEvent);
        if (newPropertiesFor.isEmpty()) {
            return null;
        }
        return new EventSuggestion(activeEvent.getName(), newPropertiesFor);
    }

    private final boolean isEventNameAlreadySent(String eventName) {
        List<EventSuggestion> list = this.workspaceSuggestions;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((EventSuggestion) it.next()).getName(), eventName)) {
                    return true;
                }
            }
        }
        List<EventSuggestion> list2 = this.localSuggestions;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (Intrinsics.areEqual(((EventSuggestion) it2.next()).getName(), eventName)) {
                return true;
            }
        }
        return false;
    }

    private final List<String> getNewPropertiesFor(ActiveEvent activeEvent) {
        Object next;
        Object next2;
        Iterator<T> it = this.workspaceSuggestions.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((EventSuggestion) next).getName(), activeEvent.getName())) {
                break;
            }
        }
        EventSuggestion eventSuggestion = (EventSuggestion) next;
        List<String> properties = eventSuggestion != null ? eventSuggestion.getProperties() : null;
        if (properties == null) {
            properties = CollectionsKt.emptyList();
        }
        Iterator<T> it2 = this.localSuggestions.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (Intrinsics.areEqual(((EventSuggestion) next2).getName(), activeEvent.getName())) {
                break;
            }
        }
        EventSuggestion eventSuggestion2 = (EventSuggestion) next2;
        List<String> properties2 = eventSuggestion2 != null ? eventSuggestion2.getProperties() : null;
        if (properties2 == null) {
            properties2 = CollectionsKt.emptyList();
        }
        return CollectionsKt.toList(CollectionsKt.subtract(CollectionsKt.subtract(activeEvent.getProperties().keySet(), CollectionsKt.toSet(properties)), CollectionsKt.toSet(properties2)));
    }

    /* JADX INFO: renamed from: com.survicate.surveys.infrastructure.storage.SurvicateSuggestionsRepository$sendSuggestion$1 */
    /* JADX INFO: compiled from: SurvicateSuggestionsRepository.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.infrastructure.storage.SurvicateSuggestionsRepository$sendSuggestion$1", m1609f = "SurvicateSuggestionsRepository.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EventSuggestion $suggestion;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C84141(EventSuggestion eventSuggestion, Continuation<? super C84141> continuation) {
            super(2, continuation);
            this.$suggestion = eventSuggestion;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C84141 c84141 = SurvicateSuggestionsRepository.this.new C84141(this.$suggestion, continuation);
            c84141.L$0 = obj;
            return c84141;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                try {
                    SurvicateSuggestionsRepository.this.suggestionsApi.sendEventSuggestion(EventSuggestionRequestBodyKt.toRequestBody(this.$suggestion));
                } catch (HttpException e) {
                    CoroutineScopeKt.ensureActive(coroutineScope);
                    SurvicateSuggestionsRepository.this.sendingBlockedInSession = true;
                    SurvicateSuggestionsRepository.this.logEventSendingError(e);
                } catch (Exception e2) {
                    CoroutineScopeKt.ensureActive(coroutineScope);
                    SurvicateSuggestionsRepository.this.logEventSendingError(e2);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void sendSuggestion(EventSuggestion suggestion) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.ioDispatcher, null, new C84141(suggestion, null), 2, null);
    }

    private final void cacheSuggestion(EventSuggestion suggestion) {
        List<EventSuggestion> mutableList = CollectionsKt.toMutableList((Collection) this.localSuggestions);
        Iterator<EventSuggestion> it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getName(), suggestion.getName())) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            mutableList.set(i, EventSuggestionKt.withMergedPropertiesFrom(mutableList.get(i), suggestion));
        } else {
            mutableList.add(suggestion);
        }
        this.localSuggestions = mutableList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logEventSendingError(Exception exception) {
        this.logger.error(LogTags.TARGETING, "Failed to send an event suggestion", exception);
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.SuggestionsRepository
    public void clear() {
        this.workspaceSuggestions = CollectionsKt.emptyList();
        this.localSuggestions = CollectionsKt.emptyList();
        this.suggestionsEnabled = false;
        this.sendingBlockedInSession = false;
        JobKt__JobKt.cancelChildren$default(this.coroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }
}
