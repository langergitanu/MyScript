package com.survicate.surveys;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.entities.models.ContactAction;
import com.survicate.surveys.entities.models.RespondentEvent;
import com.survicate.surveys.entities.survey.Survey;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormSurveyPoint;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.helpers.UserTraitUtils;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.infrastructure.network.VisitData;
import com.survicate.surveys.infrastructure.network.VisitorData;
import com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository;
import com.survicate.surveys.infrastructure.storage.respondent.RespondentRepository;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import com.survicate.surveys.traits.UserTrait;
import com.survicate.surveys.utils.TimestampProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AnswersManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bm\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012(\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ&\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0082@¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u000200H\u0082@¢\u0006\u0002\u00101J\u0016\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u0010H\u0082@¢\u0006\u0002\u00101J\u000e\u00104\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u00105\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ \u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020-H\u0002J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020%2\u0006\u0010$\u001a\u00020%J\b\u0010>\u001a\u00020-H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, m1599d2 = {"Lcom/survicate/surveys/AnswersManager;", "", "persistenceManager", "Lcom/survicate/surveys/PersistenceManager;", "eventManager", "Lcom/survicate/surveys/EventManager;", "respondentRepository", "Lcom/survicate/surveys/infrastructure/storage/respondent/RespondentRepository;", "contactsRepository", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "setUserTraits", "Lkotlin/Function2;", "", "Lcom/survicate/surveys/traits/UserTrait;", "Lkotlin/coroutines/Continuation;", "", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/PersistenceManager;Lcom/survicate/surveys/EventManager;Lcom/survicate/surveys/infrastructure/storage/respondent/RespondentRepository;Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;Lcom/survicate/surveys/utils/TimestampProvider;Lcom/survicate/surveys/core/logging/SdkLogger;Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lkotlin/jvm/functions/Function2;", "responseIds", "Ljava/util/concurrent/ConcurrentHashMap;", "", "surveySeen", "survey", "Lcom/survicate/surveys/entities/survey/Survey;", "questionAnswered", "answerDetails", "Lcom/survicate/surveys/AnswerDetails;", "overwrite", "", "maxPath", "", "(Lcom/survicate/surveys/AnswerDetails;ZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveFormFieldsAsUserTraits", "(Lcom/survicate/surveys/AnswerDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAnsweredQuestion", "answerEvent", "Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "questionId", "", "(Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadVisitorData", "Lcom/survicate/surveys/infrastructure/network/VisitorData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadResponseAttributes", "Lcom/survicate/surveys/ResponseAttribute;", "surveyClosed", "surveyCompleted", "saveInteraction", "surveyId", "type", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteractionType;", "timestampMs", "calculateCompletionRate", "", "answerCount", "currentTimeMillis", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AnswersManager {
    private final ContactsRepository contactsRepository;
    private final EventManager eventManager;
    private final CoroutineDispatcher ioDispatcher;
    private final SdkLogger logger;
    private final PersistenceManager persistenceManager;
    private final RespondentRepository respondentRepository;
    private final ConcurrentHashMap<String, String> responseIds;
    private final Function2<List<? extends UserTrait>, Continuation<? super Unit>, Object> setUserTraits;
    private final TimestampProvider timestampProvider;

    /* JADX INFO: renamed from: com.survicate.surveys.AnswersManager$questionAnswered$1 */
    /* JADX INFO: compiled from: AnswersManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.AnswersManager", m1609f = "AnswersManager.kt", m1610i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3}, m1611l = {79, PDFACompliance.e_PDFA8_1, 83, 100}, m1612m = "questionAnswered", m1613n = {"answerDetails", "question", "answers", "survey", "overwrite", "answerDetails", "question", "answers", "survey", "overwrite", "answerDetails", "question", "answers", "survey", "visitorData", "integrationsPayload", "overwrite", "answerDetails", "survey", "visitorData", "answerEvent"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3"})
    static final class C83651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C83651(Continuation<? super C83651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnswersManager.this.questionAnswered(null, false, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.AnswersManager$saveAnsweredQuestion$1 */
    /* JADX INFO: compiled from: AnswersManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.AnswersManager", m1609f = "AnswersManager.kt", m1610i = {0}, m1611l = {137}, m1612m = "saveAnsweredQuestion", m1613n = {"questionId"}, m1615s = {"J$0"})
    static final class C83661 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        C83661(Continuation<? super C83661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnswersManager.this.saveAnsweredQuestion(null, 0L, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnswersManager(PersistenceManager persistenceManager, EventManager eventManager, RespondentRepository respondentRepository, ContactsRepository contactsRepository, TimestampProvider timestampProvider, SdkLogger logger, Function2<? super List<? extends UserTrait>, ? super Continuation<? super Unit>, ? extends Object> setUserTraits) {
        this(persistenceManager, eventManager, respondentRepository, contactsRepository, timestampProvider, logger, setUserTraits, null, 128, null);
        Intrinsics.checkNotNullParameter(persistenceManager, "persistenceManager");
        Intrinsics.checkNotNullParameter(eventManager, "eventManager");
        Intrinsics.checkNotNullParameter(respondentRepository, "respondentRepository");
        Intrinsics.checkNotNullParameter(contactsRepository, "contactsRepository");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(setUserTraits, "setUserTraits");
    }

    public final double calculateCompletionRate(int answerCount, int maxPath) {
        int i = maxPath + answerCount;
        return i == 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : (((double) answerCount) / ((double) i)) * ((double) 100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnswersManager(PersistenceManager persistenceManager, EventManager eventManager, RespondentRepository respondentRepository, ContactsRepository contactsRepository, TimestampProvider timestampProvider, SdkLogger logger, Function2<? super List<? extends UserTrait>, ? super Continuation<? super Unit>, ? extends Object> setUserTraits, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(persistenceManager, "persistenceManager");
        Intrinsics.checkNotNullParameter(eventManager, "eventManager");
        Intrinsics.checkNotNullParameter(respondentRepository, "respondentRepository");
        Intrinsics.checkNotNullParameter(contactsRepository, "contactsRepository");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(setUserTraits, "setUserTraits");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.persistenceManager = persistenceManager;
        this.eventManager = eventManager;
        this.respondentRepository = respondentRepository;
        this.contactsRepository = contactsRepository;
        this.timestampProvider = timestampProvider;
        this.logger = logger;
        this.setUserTraits = setUserTraits;
        this.ioDispatcher = ioDispatcher;
        this.responseIds = new ConcurrentHashMap<>();
    }

    public /* synthetic */ AnswersManager(PersistenceManager persistenceManager, EventManager eventManager, RespondentRepository respondentRepository, ContactsRepository contactsRepository, TimestampProvider timestampProvider, SdkLogger sdkLogger, Function2 function2, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(persistenceManager, eventManager, respondentRepository, contactsRepository, timestampProvider, sdkLogger, function2, (i & 128) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final void surveySeen(Survey survey) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        this.responseIds.put(survey.getId(), UUID.randomUUID().toString());
        try {
            boolean z = !this.persistenceManager.surveyWasSeen(survey.getId());
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            this.respondentRepository.addRespondentEvent(new RespondentEvent.SurveySeen(string, survey.getId(), z));
            long jCurrentTimeMillis = currentTimeMillis();
            this.persistenceManager.saveSeenSurvey(survey.getId(), jCurrentTimeMillis);
            this.logger.info(LogTags.RESPONDENT, "`Seen` status of survey " + survey.getId() + " has been saved.");
            saveInteraction(survey.getId(), ContactAction.SurveyInteractionType.SEEN, jCurrentTimeMillis);
            this.eventManager.surveySeen(survey.getId());
        } catch (Exception e) {
            this.logger.error(LogTags.RESPONDENT, "Could not save the `seen` status of the survey", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object questionAnswered(AnswerDetails answerDetails, boolean z, int i, Continuation<? super Unit> continuation) {
        C83651 c83651;
        SurveyPoint surveyPoint;
        Survey survey;
        AnswerDetails answerDetails2;
        boolean z2;
        List<SurveyAnswer> list;
        SurveyPoint surveyPoint2;
        AnswerDetails answerDetails3;
        Object objLoadResponseAttributes;
        VisitorData visitorData;
        Map<String, IntegrationPayload> map;
        String str;
        VisitorData visitorData2;
        AnswerDetails answerDetails4;
        RespondentEvent.QuestionAnswered questionAnswered;
        if (continuation instanceof C83651) {
            c83651 = (C83651) continuation;
            if ((c83651.label & Integer.MIN_VALUE) != 0) {
                c83651.label -= Integer.MIN_VALUE;
            } else {
                c83651 = new C83651(continuation);
            }
        }
        Object objLoadVisitorData = c83651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c83651.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objLoadVisitorData);
            surveyPoint = answerDetails.getSurveyPoint();
            List<SurveyAnswer> answers = answerDetails.getAnswerAction().getAnswers();
            if (Intrinsics.areEqual(surveyPoint.getAnswerType(), QuestionSurveyAnswerType.SMILEY_SCALE)) {
                Iterator<T> it = answers.iterator();
                while (it.hasNext()) {
                    ((SurveyAnswer) it.next()).setContent(null);
                }
            }
            survey = answerDetails.getSurvey();
            survey.incrementAnswerCount();
            double dCalculateCompletionRate = calculateCompletionRate(survey.getAnswerCount(), i);
            Iterator<SurveyAnswer> it2 = answers.iterator();
            while (it2.hasNext()) {
                it2.next().setCompletionRate(dCalculateCompletionRate);
            }
            c83651.L$0 = answerDetails;
            c83651.L$1 = surveyPoint;
            c83651.L$2 = answers;
            c83651.L$3 = survey;
            c83651.Z$0 = z;
            c83651.label = 1;
            if (saveFormFieldsAsUserTraits(answerDetails, c83651) != coroutine_suspended) {
                answerDetails2 = answerDetails;
                z2 = z;
                list = answers;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                z2 = c83651.Z$0;
                survey = (Survey) c83651.L$3;
                List<SurveyAnswer> list2 = (List) c83651.L$2;
                SurveyPoint surveyPoint3 = (SurveyPoint) c83651.L$1;
                answerDetails3 = (AnswerDetails) c83651.L$0;
                ResultKt.throwOnFailure(objLoadVisitorData);
                list = list2;
                surveyPoint2 = surveyPoint3;
                VisitorData visitorData3 = (VisitorData) objLoadVisitorData;
                Map<String, IntegrationPayload> mapOnWillSendAnswer = this.eventManager.onWillSendAnswer();
                c83651.L$0 = answerDetails3;
                c83651.L$1 = surveyPoint2;
                c83651.L$2 = list;
                c83651.L$3 = survey;
                c83651.L$4 = visitorData3;
                c83651.L$5 = mapOnWillSendAnswer;
                c83651.Z$0 = z2;
                c83651.label = 3;
                objLoadResponseAttributes = loadResponseAttributes(c83651);
                if (objLoadResponseAttributes != coroutine_suspended) {
                    visitorData = visitorData3;
                    objLoadVisitorData = objLoadResponseAttributes;
                    map = mapOnWillSendAnswer;
                    boolean z3 = z2;
                    List<SurveyAnswer> list3 = list;
                    List list4 = (List) objLoadVisitorData;
                    long id = surveyPoint2.getId();
                    String id2 = survey.getId();
                    str = this.responseIds.get(survey.getId());
                    if (str != null) {
                    }
                }
                return coroutine_suspended;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                questionAnswered = (RespondentEvent.QuestionAnswered) c83651.L$3;
                visitorData2 = (VisitorData) c83651.L$2;
                survey = (Survey) c83651.L$1;
                answerDetails4 = (AnswerDetails) c83651.L$0;
                ResultKt.throwOnFailure(objLoadVisitorData);
                saveInteraction(survey.getId(), ContactAction.SurveyInteractionType.ANSWERED, currentTimeMillis());
                this.eventManager.questionAnswered(questionAnswered.getResponseUuid(), visitorData2.getVisitorUuid(), answerDetails4);
                return Unit.INSTANCE;
            }
            z2 = c83651.Z$0;
            Map<String, IntegrationPayload> map2 = (Map) c83651.L$5;
            VisitorData visitorData4 = (VisitorData) c83651.L$4;
            Survey survey2 = (Survey) c83651.L$3;
            list = (List) c83651.L$2;
            SurveyPoint surveyPoint4 = (SurveyPoint) c83651.L$1;
            AnswerDetails answerDetails5 = (AnswerDetails) c83651.L$0;
            ResultKt.throwOnFailure(objLoadVisitorData);
            map = map2;
            visitorData = visitorData4;
            survey = survey2;
            surveyPoint2 = surveyPoint4;
            answerDetails3 = answerDetails5;
            boolean z32 = z2;
            List<SurveyAnswer> list32 = list;
            List list42 = (List) objLoadVisitorData;
            long id3 = surveyPoint2.getId();
            String id22 = survey.getId();
            str = this.responseIds.get(survey.getId());
            if (str != null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            String str2 = str;
            VisitData visitData = new VisitData();
            visitData.setLanguageCode(answerDetails3.getSurveyLanguage());
            RespondentEvent.QuestionAnswered questionAnswered2 = new RespondentEvent.QuestionAnswered(id22, str2, id3, visitorData, visitData, list32, z32, map, answerDetails3.getDisclaimerAccepted(), list42);
            VisitorData visitorData5 = visitorData;
            long id4 = surveyPoint2.getId();
            c83651.L$0 = answerDetails3;
            c83651.L$1 = survey;
            c83651.L$2 = visitorData5;
            c83651.L$3 = questionAnswered2;
            c83651.L$4 = null;
            c83651.L$5 = null;
            c83651.label = 4;
            if (saveAnsweredQuestion(questionAnswered2, id4, c83651) != coroutine_suspended) {
                visitorData2 = visitorData5;
                answerDetails4 = answerDetails3;
                questionAnswered = questionAnswered2;
                saveInteraction(survey.getId(), ContactAction.SurveyInteractionType.ANSWERED, currentTimeMillis());
                this.eventManager.questionAnswered(questionAnswered.getResponseUuid(), visitorData2.getVisitorUuid(), answerDetails4);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        z2 = c83651.Z$0;
        survey = (Survey) c83651.L$3;
        list = (List) c83651.L$2;
        surveyPoint = (SurveyPoint) c83651.L$1;
        answerDetails2 = (AnswerDetails) c83651.L$0;
        ResultKt.throwOnFailure(objLoadVisitorData);
        c83651.L$0 = answerDetails2;
        c83651.L$1 = surveyPoint;
        c83651.L$2 = list;
        c83651.L$3 = survey;
        c83651.Z$0 = z2;
        c83651.label = 2;
        objLoadVisitorData = loadVisitorData(c83651);
        if (objLoadVisitorData != coroutine_suspended) {
            surveyPoint2 = surveyPoint;
            answerDetails3 = answerDetails2;
            VisitorData visitorData32 = (VisitorData) objLoadVisitorData;
            Map<String, IntegrationPayload> mapOnWillSendAnswer2 = this.eventManager.onWillSendAnswer();
            c83651.L$0 = answerDetails3;
            c83651.L$1 = surveyPoint2;
            c83651.L$2 = list;
            c83651.L$3 = survey;
            c83651.L$4 = visitorData32;
            c83651.L$5 = mapOnWillSendAnswer2;
            c83651.Z$0 = z2;
            c83651.label = 3;
            objLoadResponseAttributes = loadResponseAttributes(c83651);
            if (objLoadResponseAttributes != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveFormFieldsAsUserTraits(AnswerDetails answerDetails, Continuation<? super Unit> continuation) {
        String str;
        SurveyPoint surveyPoint = answerDetails.getSurveyPoint();
        if (!(surveyPoint instanceof SurveyFormSurveyPoint)) {
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(((SurveyFormSurveyPoint) surveyPoint).getSettings().getIdentifyRespondents(), Boxing.boxBoolean(true))) {
            return Unit.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        for (SurveyAnswer surveyAnswer : answerDetails.getAnswerAction().getAnswers()) {
            String answerType = surveyAnswer.getAnswerType();
            String content = surveyAnswer.getContent();
            String str2 = answerType;
            if (str2 != null && !StringsKt.isBlank(str2) && (str = content) != null && !StringsKt.isBlank(str)) {
                arrayList.add(new UserTrait(answerType, content));
            }
        }
        if (!arrayList.isEmpty()) {
            Object objInvoke = this.setUserTraits.invoke(arrayList, continuation);
            return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object saveAnsweredQuestion(RespondentEvent.QuestionAnswered questionAnswered, long j, Continuation<? super Unit> continuation) {
        C83661 c83661;
        AnswersManager answersManager;
        Exception exc;
        CoroutineDispatcher coroutineDispatcher;
        if (continuation instanceof C83661) {
            c83661 = (C83661) continuation;
            if ((c83661.label & Integer.MIN_VALUE) != 0) {
                c83661.label -= Integer.MIN_VALUE;
            } else {
                c83661 = new C83661(continuation);
            }
        }
        Object obj = c83661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c83661.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                coroutineDispatcher = this.ioDispatcher;
                answersManager = this;
            } catch (Exception e) {
                answersManager = this;
                exc = e;
            }
            try {
                C83672 c83672 = answersManager.new C83672(questionAnswered, j, null);
                c83661.J$0 = j;
                c83661.label = 1;
                if (BuildersKt.withContext(coroutineDispatcher, c83672, c83661) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Exception e2) {
                exc = e2;
                j = j;
                answersManager.logger.error(LogTags.RESPONDENT, "Could not save the answer to the question with id: " + j, exc);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c83661.J$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e3) {
                exc = e3;
                answersManager = this;
                answersManager.logger.error(LogTags.RESPONDENT, "Could not save the answer to the question with id: " + j, exc);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.survicate.surveys.AnswersManager$saveAnsweredQuestion$2 */
    /* JADX INFO: compiled from: AnswersManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.AnswersManager$saveAnsweredQuestion$2", m1609f = "AnswersManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C83672 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RespondentEvent.QuestionAnswered $answerEvent;
        final /* synthetic */ long $questionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C83672(RespondentEvent.QuestionAnswered questionAnswered, long j, Continuation<? super C83672> continuation) {
            super(2, continuation);
            this.$answerEvent = questionAnswered;
            this.$questionId = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AnswersManager.this.new C83672(this.$answerEvent, this.$questionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C83672) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AnswersManager.this.respondentRepository.addRespondentEvent(this.$answerEvent);
                AnswersManager.this.logger.info(LogTags.RESPONDENT, "Answer to the question (id: " + this.$questionId + ") has been saved and will be sent.");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.AnswersManager$loadVisitorData$2 */
    /* JADX INFO: compiled from: AnswersManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/survicate/surveys/infrastructure/network/VisitorData;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.AnswersManager$loadVisitorData$2", m1609f = "AnswersManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C83642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VisitorData>, Object> {
        int label;

        C83642(Continuation<? super C83642> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AnswersManager.this.new C83642(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super VisitorData> continuation) {
            return ((C83642) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new VisitorData(AnswersManager.this.persistenceManager.provideRespondent().getUuid(), UserTraitUtils.INSTANCE.getVisitorAttributes(AnswersManager.this.persistenceManager.loadUserTraits()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadVisitorData(Continuation<? super VisitorData> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C83642(null), continuation);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.AnswersManager$loadResponseAttributes$2 */
    /* JADX INFO: compiled from: AnswersManager.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/survicate/surveys/ResponseAttribute;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.AnswersManager$loadResponseAttributes$2", m1609f = "AnswersManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C83632 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ResponseAttribute>>, Object> {
        int label;

        C83632(Continuation<? super C83632> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AnswersManager.this.new C83632(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ResponseAttribute>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<ResponseAttribute>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<ResponseAttribute>> continuation) {
            return ((C83632) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List<ResponseAttribute> listLoadResponseAttributes = AnswersManager.this.persistenceManager.loadResponseAttributes();
                if (listLoadResponseAttributes.isEmpty()) {
                    return null;
                }
                return listLoadResponseAttributes;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadResponseAttributes(Continuation<? super List<ResponseAttribute>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C83632(null), continuation);
    }

    public final void surveyClosed(Survey survey) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        saveInteraction(survey.getId(), ContactAction.SurveyInteractionType.CLOSED, currentTimeMillis());
        this.eventManager.surveyClosed(survey.getId());
    }

    public final void surveyCompleted(Survey survey) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        saveInteraction(survey.getId(), ContactAction.SurveyInteractionType.COMPLETED, currentTimeMillis());
    }

    private final void saveInteraction(String surveyId, ContactAction.SurveyInteractionType type, long timestampMs) {
        this.contactsRepository.addSurveyInteraction(new ContactAction.SurveyInteraction.Interaction(surveyId, timestampMs, type));
    }

    private final long currentTimeMillis() {
        return this.timestampProvider.currentTimeMillis();
    }
}
