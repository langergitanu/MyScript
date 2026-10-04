package com.survicate.surveys;

import android.os.Handler;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.survicate.surveys.entities.survey.Integration;
import com.survicate.surveys.entities.survey.Workspace;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.utils.PanelAnswerUrlBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0002J(\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001dH\u0002J\u001e\u0010\"\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\rH\u0002J\u000e\u0010%\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0002J\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020+0*J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001e0\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m1599d2 = {"Lcom/survicate/surveys/EventManager;", "", "mainHandler", "Landroid/os/Handler;", "persistenceManager", "Lcom/survicate/surveys/PersistenceManager;", "<init>", "(Landroid/os/Handler;Lcom/survicate/surveys/PersistenceManager;)V", "workspace", "Lcom/survicate/surveys/entities/survey/Workspace;", "getWorkspace", "()Lcom/survicate/surveys/entities/survey/Workspace;", "listeners", "", "Lcom/survicate/surveys/SurvicateEventListener;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "clearListeners", "surveySeen", "surveyId", "", "questionAnswered", "responseUuid", "visitorUuid", "answerDetails", "Lcom/survicate/surveys/AnswerDetails;", "shouldSendInputFields", "", "Lcom/survicate/surveys/IntegrationListener;", "buildQuestionAnsweredEvent", "Lcom/survicate/surveys/QuestionAnsweredEvent;", "includeInputFields", "checkIsSurveyCompleted", "answers", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "surveyClosed", "runOnMainThread", "runnable", "Ljava/lang/Runnable;", "onWillSendAnswer", "", "Lcom/survicate/surveys/IntegrationPayload;", "getListenersToNotify", "getEnabledIntegrationListeners", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventManager {
    private List<? extends SurvicateEventListener> listeners;
    private final Handler mainHandler;
    private final PersistenceManager persistenceManager;

    public EventManager(Handler mainHandler, PersistenceManager persistenceManager) {
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(persistenceManager, "persistenceManager");
        this.mainHandler = mainHandler;
        this.persistenceManager = persistenceManager;
        this.listeners = CollectionsKt.emptyList();
    }

    private final Workspace getWorkspace() {
        Workspace workspace = this.persistenceManager.getWorkspace();
        if (workspace != null) {
            return workspace;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void addListener(SurvicateEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners = CollectionsKt.plus((Collection<? extends SurvicateEventListener>) this.listeners, listener);
    }

    public final void removeListener(SurvicateEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners = CollectionsKt.minus(this.listeners, listener);
    }

    public final void clearListeners() {
        this.listeners = CollectionsKt.emptyList();
    }

    public final void surveySeen(final String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        runOnMainThread(new Runnable() { // from class: com.survicate.surveys.EventManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EventManager.surveySeen$lambda$0(this.f$0, surveyId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void surveySeen$lambda$0(EventManager eventManager, String str) {
        Iterator<SurvicateEventListener> it = eventManager.getListenersToNotify().iterator();
        while (it.hasNext()) {
            it.next().onSurveyDisplayed(new SurveyDisplayedEvent(str));
        }
    }

    public final void questionAnswered(final String responseUuid, final String visitorUuid, final AnswerDetails answerDetails) {
        Intrinsics.checkNotNullParameter(responseUuid, "responseUuid");
        Intrinsics.checkNotNullParameter(visitorUuid, "visitorUuid");
        Intrinsics.checkNotNullParameter(answerDetails, "answerDetails");
        runOnMainThread(new Runnable() { // from class: com.survicate.surveys.EventManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                EventManager.questionAnswered$lambda$1(this.f$0, responseUuid, visitorUuid, answerDetails);
            }
        });
        checkIsSurveyCompleted(answerDetails.getSurvey().getId(), answerDetails.getAnswerAction().getAnswers());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void questionAnswered$lambda$1(EventManager eventManager, String str, String str2, AnswerDetails answerDetails) {
        for (SurvicateEventListener survicateEventListener : eventManager.getListenersToNotify()) {
            survicateEventListener.onQuestionAnswered(eventManager.buildQuestionAnsweredEvent(str, str2, answerDetails, !(survicateEventListener instanceof IntegrationListener) || eventManager.shouldSendInputFields((IntegrationListener) survicateEventListener)));
        }
    }

    private final boolean shouldSendInputFields(IntegrationListener integrationListener) {
        Object next;
        Iterator<T> it = getWorkspace().getIntegrations().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Integration) next).getProvider(), integrationListener.getProviderName())) {
                break;
            }
        }
        Integration integration = (Integration) next;
        return integration != null && integration.getSendInputFields();
    }

    private final QuestionAnsweredEvent buildQuestionAnsweredEvent(String responseUuid, String visitorUuid, AnswerDetails answerDetails, boolean includeInputFields) {
        SurvicateAnswer survicateAnswerCreateSurvicateAnswer = SurvicateAnswerFactory.INSTANCE.createSurvicateAnswer(answerDetails.getSurveyPoint(), answerDetails.getAnswerAction().getAnswers(), includeInputFields);
        String strBuild = PanelAnswerUrlBuilder.INSTANCE.build(getWorkspace().getPanelAnswerUrlTemplate(), answerDetails.getSurvey().getId(), responseUuid);
        String id = answerDetails.getSurvey().getId();
        String name = answerDetails.getSurvey().getName();
        long id2 = answerDetails.getSurveyPoint().getId();
        String content = answerDetails.getSurveyPoint().getContent();
        if (content == null) {
            content = "";
        }
        return new QuestionAnsweredEvent(responseUuid, visitorUuid, id, name, id2, content, survicateAnswerCreateSurvicateAnswer, strBuild);
    }

    private final void checkIsSurveyCompleted(final String surveyId, List<SurveyAnswer> answers) {
        List<SurveyAnswer> list = answers;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((Object) ((SurveyAnswer) it.next()).getFinished(), (Object) true)) {
                runOnMainThread(new Runnable() { // from class: com.survicate.surveys.EventManager$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        EventManager.checkIsSurveyCompleted$lambda$4(this.f$0, surveyId);
                    }
                });
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIsSurveyCompleted$lambda$4(EventManager eventManager, String str) {
        Iterator<SurvicateEventListener> it = eventManager.getListenersToNotify().iterator();
        while (it.hasNext()) {
            it.next().onSurveyCompleted(new SurveyCompletedEvent(str));
        }
    }

    public final void surveyClosed(final String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        runOnMainThread(new Runnable() { // from class: com.survicate.surveys.EventManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                EventManager.surveyClosed$lambda$5(this.f$0, surveyId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void surveyClosed$lambda$5(EventManager eventManager, String str) {
        Iterator<SurvicateEventListener> it = eventManager.getListenersToNotify().iterator();
        while (it.hasNext()) {
            it.next().onSurveyClosed(new SurveyClosedEvent(str));
        }
    }

    private final void runOnMainThread(Runnable runnable) {
        this.mainHandler.post(runnable);
    }

    public final Map<String, IntegrationPayload> onWillSendAnswer() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<IntegrationListener> it = getEnabledIntegrationListeners().iterator();
        while (it.hasNext()) {
            linkedHashMap.putAll(it.next().onWillSendAnswer());
        }
        return linkedHashMap;
    }

    private final List<SurvicateEventListener> getListenersToNotify() {
        List<? extends SurvicateEventListener> list = this.listeners;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            SurvicateEventListener survicateEventListener = (SurvicateEventListener) obj;
            if (!(survicateEventListener instanceof IntegrationListener) || getEnabledIntegrationListeners().contains(survicateEventListener)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final List<IntegrationListener> getEnabledIntegrationListeners() {
        List<Integration> integrations = getWorkspace().getIntegrations();
        ArrayList arrayList = new ArrayList();
        for (Object obj : integrations) {
            if (((Integration) obj).getEnabled()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((Integration) it.next()).getProvider());
        }
        ArrayList arrayList4 = arrayList3;
        List<? extends SurvicateEventListener> list = this.listeners;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : list) {
            if (obj2 instanceof IntegrationListener) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj3 : arrayList5) {
            if (arrayList4.contains(((IntegrationListener) obj3).getProviderName())) {
                arrayList6.add(obj3);
            }
        }
        return arrayList6;
    }
}
