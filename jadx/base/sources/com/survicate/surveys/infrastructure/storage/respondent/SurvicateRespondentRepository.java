package com.survicate.surveys.infrastructure.storage.respondent;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.core.queue.QueueTask;
import com.survicate.surveys.core.queue.TaskScheduler;
import com.survicate.surveys.entities.models.RespondentEvent;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.helpers.Observable;
import com.survicate.surveys.infrastructure.network.HttpException;
import com.survicate.surveys.infrastructure.network.HttpExceptionKt;
import com.survicate.surveys.infrastructure.network.QuestionAnsweredRequestBodyKt;
import com.survicate.surveys.infrastructure.network.RespondentApi;
import com.survicate.surveys.infrastructure.network.SurveySeenRequestBodyKt;
import com.survicate.surveys.utils.AppState;
import com.survicate.surveys.utils.AppStateProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RespondentRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u001f\u001a\u00060 j\u0002`!H\u0002J\u0014\u0010\"\u001a\u00020\u00112\n\u0010\u001f\u001a\u00060 j\u0002`!H\u0002J\b\u0010#\u001a\u00020\u000fH\u0016J\f\u0010$\u001a\u00020%*\u00020\u0015H\u0002J\"\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)H\u0082\b¢\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/respondent/SurvicateRespondentRepository;", "Lcom/survicate/surveys/infrastructure/storage/respondent/RespondentRepository;", "respondentApi", "Lcom/survicate/surveys/infrastructure/network/RespondentApi;", "respondentStore", "Lcom/survicate/surveys/infrastructure/storage/respondent/RespondentStore;", "taskScheduler", "Lcom/survicate/surveys/core/queue/TaskScheduler;", "appStateProvider", "Lcom/survicate/surveys/utils/AppStateProvider;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/RespondentApi;Lcom/survicate/surveys/infrastructure/storage/respondent/RespondentStore;Lcom/survicate/surveys/core/queue/TaskScheduler;Lcom/survicate/surveys/utils/AppStateProvider;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "init", "", "canSynchronizeEvents", "", "syncCachedEvents", "addRespondentEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/survicate/surveys/entities/models/RespondentEvent;", "sendEvent", "saveEvent", "removeEvent", "sendSeenEvent", "Lcom/survicate/surveys/entities/models/RespondentEvent$SurveySeen;", "sendAnsweredEvent", "Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "onSendSuccess", "onSendFailure", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "shouldNeverTryAgain", "clear", "toTask", "Lcom/survicate/surveys/core/queue/QueueTask;", "withStoreLock", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateRespondentRepository implements RespondentRepository {
    private final AppStateProvider appStateProvider;
    private final SdkLogger logger;
    private final RespondentApi respondentApi;
    private final RespondentStore respondentStore;
    private final TaskScheduler taskScheduler;

    public SurvicateRespondentRepository(RespondentApi respondentApi, RespondentStore respondentStore, TaskScheduler taskScheduler, AppStateProvider appStateProvider, SdkLogger logger) {
        Intrinsics.checkNotNullParameter(respondentApi, "respondentApi");
        Intrinsics.checkNotNullParameter(respondentStore, "respondentStore");
        Intrinsics.checkNotNullParameter(taskScheduler, "taskScheduler");
        Intrinsics.checkNotNullParameter(appStateProvider, "appStateProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.respondentApi = respondentApi;
        this.respondentStore = respondentStore;
        this.taskScheduler = taskScheduler;
        this.appStateProvider = appStateProvider;
        this.logger = logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$0(SurvicateRespondentRepository survicateRespondentRepository, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        survicateRespondentRepository.logger.info(LogTags.RESPONDENT, message);
        return Unit.INSTANCE;
    }

    @Override // com.survicate.surveys.infrastructure.storage.respondent.RespondentRepository
    public void init() {
        this.taskScheduler.setOnLogMessage(new Function1() { // from class: com.survicate.surveys.infrastructure.storage.respondent.SurvicateRespondentRepository$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateRespondentRepository.init$lambda$0(this.f$0, (String) obj);
            }
        });
        this.taskScheduler.setEnabled(canSynchronizeEvents());
        Observable<AppState> observableObserveAppStateChanges = this.appStateProvider.observeAppStateChanges();
        final Function1 function1 = new Function1() { // from class: com.survicate.surveys.infrastructure.storage.respondent.SurvicateRespondentRepository$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateRespondentRepository.init$lambda$1(this.f$0, (AppState) obj);
            }
        };
        observableObserveAppStateChanges.addObserver(new Observable.Observer() { // from class: com.survicate.surveys.infrastructure.storage.respondent.SurvicateRespondentRepository$$ExternalSyntheticLambda2
            @Override // com.survicate.surveys.helpers.Observable.Observer
            public final void update(Object obj) {
                function1.invoke(obj);
            }
        });
        syncCachedEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$1(SurvicateRespondentRepository survicateRespondentRepository, AppState appState) {
        survicateRespondentRepository.taskScheduler.setEnabled(survicateRespondentRepository.canSynchronizeEvents());
        return Unit.INSTANCE;
    }

    private final boolean canSynchronizeEvents() {
        AppState currentState = this.appStateProvider.getCurrentState();
        return currentState.isNetworkAvailable() && currentState.isInForeground();
    }

    @Override // com.survicate.surveys.infrastructure.storage.respondent.RespondentRepository
    public void addRespondentEvent(RespondentEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        saveEvent(event);
        this.taskScheduler.schedule(toTask(event));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean sendEvent(RespondentEvent event) {
        try {
            if (event instanceof RespondentEvent.SurveySeen) {
                sendSeenEvent((RespondentEvent.SurveySeen) event);
            } else {
                if (!(event instanceof RespondentEvent.QuestionAnswered)) {
                    throw new NoWhenBranchMatchedException();
                }
                sendAnsweredEvent((RespondentEvent.QuestionAnswered) event);
            }
            onSendSuccess(event);
            return true;
        } catch (Exception e) {
            return onSendFailure(event, e);
        }
    }

    private final void sendSeenEvent(RespondentEvent.SurveySeen event) throws IOException {
        this.respondentApi.sendSurveySeen(event.getSurveyId(), SurveySeenRequestBodyKt.toRequestBody(event));
        this.logger.info(LogTags.RESPONDENT, "Seen status of survey " + event.getSurveyId() + " has been synchronized.");
    }

    private final void sendAnsweredEvent(RespondentEvent.QuestionAnswered event) throws IOException {
        this.respondentApi.sendQuestionAnswered(event.getSurveyId(), QuestionAnsweredRequestBodyKt.toRequestBody(event));
        this.logger.info(LogTags.RESPONDENT, "Answer has been synchronized.");
    }

    private final void onSendSuccess(RespondentEvent event) {
        removeEvent(event);
    }

    private final boolean onSendFailure(RespondentEvent event, Exception exception) {
        this.logger.error(LogTags.RESPONDENT, "Failed to synchronize " + event.getClass().getSimpleName() + " event", exception);
        if (!shouldNeverTryAgain(exception)) {
            return false;
        }
        removeEvent(event);
        return true;
    }

    private final boolean shouldNeverTryAgain(Exception exception) {
        return (exception instanceof HttpException) && !HttpExceptionKt.canRetry((HttpException) exception);
    }

    @Override // com.survicate.surveys.infrastructure.storage.respondent.RespondentRepository
    public void clear() {
        this.taskScheduler.clear();
        synchronized (this.respondentStore) {
            this.respondentStore.clearRespondentEvents();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final QueueTask toTask(final RespondentEvent respondentEvent) {
        return new QueueTask() { // from class: com.survicate.surveys.infrastructure.storage.respondent.SurvicateRespondentRepository.toTask.1
            @Override // com.survicate.surveys.core.queue.QueueTask
            public final Object run(Continuation<? super Boolean> continuation) {
                return Boxing.boxBoolean(SurvicateRespondentRepository.this.sendEvent(respondentEvent));
            }
        };
    }

    private final <T> T withStoreLock(Function0<? extends T> block) {
        T tInvoke;
        synchronized (this.respondentStore) {
            tInvoke = block.invoke();
        }
        return tInvoke;
    }

    private final void syncCachedEvents() {
        List<RespondentEvent> listLoadRespondentEvents;
        synchronized (this.respondentStore) {
            listLoadRespondentEvents = this.respondentStore.loadRespondentEvents();
        }
        List<RespondentEvent> list = listLoadRespondentEvents;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toTask((RespondentEvent) it.next()));
        }
        this.taskScheduler.schedule(arrayList);
    }

    private final void saveEvent(RespondentEvent event) {
        synchronized (this.respondentStore) {
            this.respondentStore.saveRespondentEvent(event);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void removeEvent(RespondentEvent event) {
        synchronized (this.respondentStore) {
            this.respondentStore.removeRespondentEvent(event);
            Unit unit = Unit.INSTANCE;
        }
    }
}
