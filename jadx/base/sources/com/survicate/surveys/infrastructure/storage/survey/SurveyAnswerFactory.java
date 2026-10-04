package com.survicate.surveys.infrastructure.storage.survey;

import com.survicate.surveys.components.surveyLogic.FormAnswerMappingKt;
import com.survicate.surveys.core.logic.display.models.FormAnswer;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import com.survicate.surveys.entities.models.MatrixAnswer;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormSurveyPoint;
import com.survicate.surveys.entities.survey.questions.nps.SurveyNpsSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.infrastructure.storage.interfaces.QuestionAnswerItem;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyAnswerFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00152\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00172\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aJ,\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u001c\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001d0\u001cj\u0002`\u001e0\tJ'\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\"J'\u0010#\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\"J,\u0010$\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\t2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\tJ\u0016\u0010'\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001dJ\u0016\u0010)\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001dJ\u001d\u0010*\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020+¢\u0006\u0004\b,\u0010-¨\u0006."}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/survey/SurveyAnswerFactory;", "", "<init>", "()V", "create", "Lcom/survicate/surveys/infrastructure/storage/interfaces/QuestionAnswerItem;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "answers", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "createForQuestionPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "createForSingleChoicePoint", "createForMultipleChoicePoint", "createForSmileyScalePoint", "createForRatingPoint", "createForDatePoint", "createForTextPoint", "createForMatrixPoint", "createForNpsPoint", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;", "createForFormPoint", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;", "createCtaAnswer", "pointId", "", "createFormAnswer", "Lkotlin/Pair;", "", "Lcom/survicate/surveys/components/surveyLogic/FormAnswer;", "createRangeAnswer", "answerId", "textValue", "(JLjava/lang/Long;Ljava/lang/String;)Lcom/survicate/surveys/infrastructure/storage/interfaces/QuestionAnswerItem;", "createSingleChoiceAnswer", "createMultipleChoiceAnswer", "answerIds", "textValues", "createTextAnswer", "answer", "createDateAnswer", "createMatrixAnswer", "Lcom/survicate/surveys/entities/models/MatrixAnswer;", "createMatrixAnswer-AGWYiuQ", "(JLjava/util/Map;)Lcom/survicate/surveys/infrastructure/storage/interfaces/QuestionAnswerItem;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyAnswerFactory {
    public final QuestionAnswerItem create(SurveyPoint surveyPoint, List<SurveyAnswer> answers) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(answers, "answers");
        if (surveyPoint instanceof SurveyQuestionSurveyPoint) {
            return createForQuestionPoint((SurveyQuestionSurveyPoint) surveyPoint, answers);
        }
        if (surveyPoint instanceof SurveyNpsSurveyPoint) {
            return createForNpsPoint((SurveyNpsSurveyPoint) surveyPoint, answers);
        }
        if (surveyPoint instanceof SurveyFormSurveyPoint) {
            return createForFormPoint((SurveyFormSurveyPoint) surveyPoint, answers);
        }
        if (surveyPoint instanceof SurveyCtaSurveyPoint) {
            return createCtaAnswer(((SurveyCtaSurveyPoint) surveyPoint).getId());
        }
        throw new IllegalArgumentException("Unsupported answer type: " + surveyPoint.getAnswerType());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final QuestionAnswerItem createForQuestionPoint(SurveyQuestionSurveyPoint surveyPoint, List<SurveyAnswer> answers) {
        String answerType = surveyPoint.getAnswerType();
        switch (answerType.hashCode()) {
            case -1710937533:
                if (answerType.equals(QuestionSurveyAnswerType.NUMERICAL)) {
                    return createForRatingPoint(surveyPoint, answers);
                }
                break;
            case -1081239615:
                if (answerType.equals(QuestionSurveyAnswerType.MATRIX)) {
                    return createForMatrixPoint(surveyPoint, answers);
                }
                break;
            case -938102371:
                if (answerType.equals(QuestionSurveyAnswerType.SHAPE)) {
                    return createForRatingPoint(surveyPoint, answers);
                }
                break;
            case -902265784:
                if (answerType.equals(QuestionSurveyAnswerType.SINGLE)) {
                    return createForSingleChoicePoint(surveyPoint, answers);
                }
                break;
            case 3062947:
                if (answerType.equals(QuestionSurveyAnswerType.CSAT)) {
                    return createForRatingPoint(surveyPoint, answers);
                }
                break;
            case 3076014:
                if (answerType.equals(QuestionSurveyAnswerType.DATE)) {
                    return createForDatePoint(surveyPoint, answers);
                }
                break;
            case 3556653:
                if (answerType.equals("text")) {
                    return createForTextPoint(surveyPoint, answers);
                }
                break;
            case 653829648:
                if (answerType.equals(QuestionSurveyAnswerType.MULTIPLE)) {
                    return createForMultipleChoicePoint(surveyPoint, answers);
                }
                break;
            case 1047773692:
                if (answerType.equals(QuestionSurveyAnswerType.SMILEY_SCALE)) {
                    return createForSmileyScalePoint(surveyPoint, answers);
                }
                break;
        }
        throw new IllegalArgumentException("Unsupported answer type: " + surveyPoint.getAnswerType());
    }

    private final QuestionAnswerItem createForSingleChoicePoint(SurveyQuestionSurveyPoint surveyPoint, List<SurveyAnswer> answers) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        SurveyAnswer surveyAnswer = (SurveyAnswer) CollectionsKt.first((List) answers);
        return createSingleChoiceAnswer(surveyPoint.getId(), surveyAnswer.getQuestionAnswerId(), surveyAnswer.getAnswer());
    }

    private final QuestionAnswerItem createForMultipleChoicePoint(SurveyQuestionSurveyPoint surveyPoint, List<SurveyAnswer> answers) {
        long id = surveyPoint.getId();
        List<SurveyAnswer> list = answers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Long questionAnswerId = ((SurveyAnswer) it.next()).getQuestionAnswerId();
            if (questionAnswerId != null) {
                arrayList.add(questionAnswerId);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            String answer = ((SurveyAnswer) it2.next()).getAnswer();
            if (answer != null) {
                arrayList3.add(answer);
            }
        }
        return createMultipleChoiceAnswer(id, arrayList2, arrayList3);
    }

    private final QuestionAnswerItem createForSmileyScalePoint(SurveyQuestionSurveyPoint surveyPoint, List<SurveyAnswer> answers) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        SurveyAnswer surveyAnswer = (SurveyAnswer) CollectionsKt.first((List) answers);
        return createRangeAnswer(surveyPoint.getId(), surveyAnswer.getQuestionAnswerId(), surveyAnswer.getContent());
    }

    private final QuestionAnswerItem createForRatingPoint(SurveyQuestionSurveyPoint surveyPoint, List<SurveyAnswer> answers) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        SurveyAnswer surveyAnswer = (SurveyAnswer) CollectionsKt.first((List) answers);
        return createRangeAnswer(surveyPoint.getId(), surveyAnswer.getQuestionAnswerId(), surveyAnswer.getAnswer());
    }

    private final QuestionAnswerItem createForDatePoint(SurveyQuestionSurveyPoint surveyPoint, List<SurveyAnswer> answers) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        SurveyAnswer surveyAnswer = (SurveyAnswer) CollectionsKt.first((List) answers);
        long id = surveyPoint.getId();
        String content = surveyAnswer.getContent();
        if (content == null) {
            content = "";
        }
        return createDateAnswer(id, content);
    }

    private final QuestionAnswerItem createForTextPoint(SurveyQuestionSurveyPoint surveyPoint, List<SurveyAnswer> answers) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        SurveyAnswer surveyAnswer = (SurveyAnswer) CollectionsKt.first((List) answers);
        long id = surveyPoint.getId();
        String content = surveyAnswer.getContent();
        if (content == null) {
            content = "";
        }
        return createTextAnswer(id, content);
    }

    private final QuestionAnswerItem createForMatrixPoint(SurveyQuestionSurveyPoint surveyPoint, List<SurveyAnswer> answers) {
        return m14423createMatrixAnswerAGWYiuQ(surveyPoint.getId(), MatrixAnswer.INSTANCE.m14357fromRawAnswersyWLOJ_k(answers));
    }

    private final QuestionAnswerItem createForNpsPoint(SurveyNpsSurveyPoint surveyPoint, List<SurveyAnswer> answers) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        SurveyAnswer surveyAnswer = (SurveyAnswer) CollectionsKt.first((List) answers);
        return createRangeAnswer(surveyPoint.getId(), surveyAnswer.getAnswerId(), surveyAnswer.getContent());
    }

    private final QuestionAnswerItem createForFormPoint(SurveyFormSurveyPoint surveyPoint, List<SurveyAnswer> answers) {
        return createFormAnswer(surveyPoint.getId(), FormAnswerMappingKt.toFormAnswers(answers));
    }

    public final QuestionAnswerItem createCtaAnswer(long pointId) {
        return new QuestionAnswerItem(pointId, CollectionsKt.emptyList(), null);
    }

    public final QuestionAnswerItem createFormAnswer(long pointId, List<Pair<Long, String>> answers) {
        Intrinsics.checkNotNullParameter(answers, "answers");
        List<Pair<Long, String>> list = answers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(new FormAnswer(((Number) pair.getFirst()).longValue(), (String) pair.getSecond()));
        }
        return new QuestionAnswerItem(pointId, CollectionsKt.emptyList(), new QuestionAnswered.Form(pointId, arrayList));
    }

    public final QuestionAnswerItem createRangeAnswer(long pointId, Long answerId, String textValue) {
        return new QuestionAnswerItem(pointId, CollectionsKt.listOfNotNull(textValue), new QuestionAnswered.Range(pointId, answerId));
    }

    public final QuestionAnswerItem createSingleChoiceAnswer(long pointId, Long answerId, String textValue) {
        return new QuestionAnswerItem(pointId, CollectionsKt.listOfNotNull(textValue), new QuestionAnswered.Single(pointId, answerId));
    }

    public final QuestionAnswerItem createMultipleChoiceAnswer(long pointId, List<Long> answerIds, List<String> textValues) {
        Intrinsics.checkNotNullParameter(answerIds, "answerIds");
        Intrinsics.checkNotNullParameter(textValues, "textValues");
        return new QuestionAnswerItem(pointId, CollectionsKt.filterNotNull(textValues), new QuestionAnswered.Multiple(pointId, answerIds));
    }

    public final QuestionAnswerItem createTextAnswer(long pointId, String answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        return new QuestionAnswerItem(pointId, CollectionsKt.listOf(answer), new QuestionAnswered.Text(pointId, answer));
    }

    public final QuestionAnswerItem createDateAnswer(long pointId, String answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        return new QuestionAnswerItem(pointId, CollectionsKt.listOf(answer), new QuestionAnswered.Date(pointId, answer));
    }

    /* JADX INFO: renamed from: createMatrixAnswer-AGWYiuQ, reason: not valid java name */
    public final QuestionAnswerItem m14423createMatrixAnswerAGWYiuQ(long pointId, Map<Long, ? extends Long> answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        ArrayList arrayList = new ArrayList(answer.size());
        for (Map.Entry<Long, ? extends Long> entry : answer.entrySet()) {
            arrayList.add(new com.survicate.surveys.core.logic.display.models.MatrixAnswer(entry.getKey().longValue(), entry.getValue().longValue()));
        }
        return new QuestionAnswerItem(pointId, CollectionsKt.emptyList(), new QuestionAnswered.Matrix(pointId, arrayList));
    }
}
