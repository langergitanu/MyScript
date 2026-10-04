package com.survicate.surveys.components.branchLogic;

import com.survicate.surveys.components.surveyLogic.FormAnswerMappingKt;
import com.survicate.surveys.components.surveyLogic.SurveyLogic;
import com.survicate.surveys.entities.models.MatrixAnswer;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormSurveyPoint;
import com.survicate.surveys.entities.survey.questions.nps.SurveyNpsSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.date.SurveyPointDateSettings;
import com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings;
import com.survicate.surveys.entities.survey.questions.question.multiple.SurveyPointMultipleSettings;
import com.survicate.surveys.entities.survey.questions.question.rating.csat.SurveyPointCsatSettings;
import com.survicate.surveys.entities.survey.questions.question.rating.numerical.SurveyPointNumericalSettings;
import com.survicate.surveys.entities.survey.questions.question.rating.shape.SurveyPointShapeSettings;
import com.survicate.surveys.entities.survey.questions.question.single.SurveyPointSingleSettings;
import com.survicate.surveys.entities.survey.questions.question.smileyScale.SurveyPointSmileyScaleSettings;
import com.survicate.surveys.entities.survey.questions.question.text.SurveyPointTextSettings;
import com.survicate.surveys.entities.survey.surveyLogic.date.SurveyPointDateLogic;
import com.survicate.surveys.entities.survey.surveyLogic.form.SurveyPointFormLogic;
import com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyPointMultipleLogic;
import com.survicate.surveys.entities.survey.surveyLogic.range.SurveyPointRangeLogic;
import com.survicate.surveys.entities.survey.surveyLogic.single.SurveyPointSingleLogic;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogicResolver.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ-\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0010J-\u0010\u0011\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001dJ-\u0010\u001e\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u001fH\u0002¢\u0006\u0002\u0010 J-\u0010!\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\"H\u0002¢\u0006\u0002\u0010#J-\u0010$\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020%H\u0002¢\u0006\u0002\u0010&J-\u0010'\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020(H\u0002¢\u0006\u0002\u0010)J-\u0010*\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020+H\u0002¢\u0006\u0002\u0010,J-\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020.2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010/J-\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u0002012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u00102¨\u00063"}, m1599d2 = {"Lcom/survicate/surveys/components/branchLogic/BranchLogicResolver;", "", "<init>", "()V", "resolve", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "answers", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "surveyLogic", "Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;", "(Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;)Ljava/lang/Long;", "resolveQuestionNextPointId", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;)Ljava/lang/Long;", "resolveSingleChoiceNextPointId", "settings", "Lcom/survicate/surveys/entities/survey/questions/question/single/SurveyPointSingleSettings;", "(Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;Lcom/survicate/surveys/entities/survey/questions/question/single/SurveyPointSingleSettings;)Ljava/lang/Long;", "resolveMultipleNextPointId", "Lcom/survicate/surveys/entities/survey/questions/question/multiple/SurveyPointMultipleSettings;", "(Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;Lcom/survicate/surveys/entities/survey/questions/question/multiple/SurveyPointMultipleSettings;)Ljava/lang/Long;", "resolveSmileyScaleNextPointId", "Lcom/survicate/surveys/entities/survey/questions/question/smileyScale/SurveyPointSmileyScaleSettings;", "(Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;Lcom/survicate/surveys/entities/survey/questions/question/smileyScale/SurveyPointSmileyScaleSettings;)Ljava/lang/Long;", "resolveCsatNextPointId", "Lcom/survicate/surveys/entities/survey/questions/question/rating/csat/SurveyPointCsatSettings;", "(Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;Lcom/survicate/surveys/entities/survey/questions/question/rating/csat/SurveyPointCsatSettings;)Ljava/lang/Long;", "resolveNumericalNextPointId", "Lcom/survicate/surveys/entities/survey/questions/question/rating/numerical/SurveyPointNumericalSettings;", "(Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;Lcom/survicate/surveys/entities/survey/questions/question/rating/numerical/SurveyPointNumericalSettings;)Ljava/lang/Long;", "resolveShapeNextPointId", "Lcom/survicate/surveys/entities/survey/questions/question/rating/shape/SurveyPointShapeSettings;", "(Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;Lcom/survicate/surveys/entities/survey/questions/question/rating/shape/SurveyPointShapeSettings;)Ljava/lang/Long;", "resolveDateNextPointId", "Lcom/survicate/surveys/entities/survey/questions/question/date/SurveyPointDateSettings;", "(Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;Lcom/survicate/surveys/entities/survey/questions/question/date/SurveyPointDateSettings;)Ljava/lang/Long;", "resolveTextNextPointId", "Lcom/survicate/surveys/entities/survey/questions/question/text/SurveyPointTextSettings;", "(Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;Lcom/survicate/surveys/entities/survey/questions/question/text/SurveyPointTextSettings;)Ljava/lang/Long;", "resolveMatrixNextPointId", "Lcom/survicate/surveys/entities/survey/questions/question/matrix/SurveyPointMatrixSettings;", "(Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;Lcom/survicate/surveys/entities/survey/questions/question/matrix/SurveyPointMatrixSettings;)Ljava/lang/Long;", "resolveNpsNextPointId", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;", "(Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;)Ljava/lang/Long;", "resolveFormNextPointId", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;", "(Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;Ljava/util/List;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;)Ljava/lang/Long;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicResolver {
    public static final BranchLogicResolver INSTANCE = new BranchLogicResolver();

    private BranchLogicResolver() {
    }

    public final Long resolve(SurveyPoint surveyPoint, List<SurveyAnswer> answers, SurveyLogic surveyLogic) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(answers, "answers");
        Intrinsics.checkNotNullParameter(surveyLogic, "surveyLogic");
        if (surveyPoint instanceof SurveyQuestionSurveyPoint) {
            return resolveQuestionNextPointId((SurveyQuestionSurveyPoint) surveyPoint, answers, surveyLogic);
        }
        if (surveyPoint instanceof SurveyNpsSurveyPoint) {
            return resolveNpsNextPointId((SurveyNpsSurveyPoint) surveyPoint, answers, surveyLogic);
        }
        if (surveyPoint instanceof SurveyFormSurveyPoint) {
            return resolveFormNextPointId((SurveyFormSurveyPoint) surveyPoint, answers, surveyLogic);
        }
        if (surveyPoint instanceof SurveyCtaSurveyPoint) {
            return ((SurveyCtaSurveyPoint) surveyPoint).getNextSurveyPointId();
        }
        throw new IllegalArgumentException("Unsupported answer type: " + surveyPoint.getAnswerType());
    }

    private final Long resolveQuestionNextPointId(SurveyQuestionSurveyPoint surveyPoint, List<SurveyAnswer> answers, SurveyLogic surveyLogic) {
        SurveyQuestionPointSettings settings = surveyPoint.getSettings();
        if (settings instanceof SurveyPointSingleSettings) {
            return resolveSingleChoiceNextPointId(answers, surveyLogic, (SurveyPointSingleSettings) settings);
        }
        if (settings instanceof SurveyPointMultipleSettings) {
            return resolveMultipleNextPointId(answers, surveyLogic, (SurveyPointMultipleSettings) settings);
        }
        if (settings instanceof SurveyPointSmileyScaleSettings) {
            return resolveSmileyScaleNextPointId(answers, surveyLogic, (SurveyPointSmileyScaleSettings) settings);
        }
        if (settings instanceof SurveyPointCsatSettings) {
            return resolveCsatNextPointId(answers, surveyLogic, (SurveyPointCsatSettings) settings);
        }
        if (settings instanceof SurveyPointNumericalSettings) {
            return resolveNumericalNextPointId(answers, surveyLogic, (SurveyPointNumericalSettings) settings);
        }
        if (settings instanceof SurveyPointShapeSettings) {
            return resolveShapeNextPointId(answers, surveyLogic, (SurveyPointShapeSettings) settings);
        }
        if (settings instanceof SurveyPointDateSettings) {
            return resolveDateNextPointId(answers, surveyLogic, (SurveyPointDateSettings) settings);
        }
        if (settings instanceof SurveyPointTextSettings) {
            return resolveTextNextPointId(answers, surveyLogic, (SurveyPointTextSettings) settings);
        }
        if (settings instanceof SurveyPointMatrixSettings) {
            return resolveMatrixNextPointId(answers, surveyLogic, (SurveyPointMatrixSettings) settings);
        }
        throw new IllegalArgumentException("Unsupported answer type: " + surveyPoint.getAnswerType());
    }

    private final Long resolveSingleChoiceNextPointId(List<SurveyAnswer> answers, SurveyLogic surveyLogic, SurveyPointSingleSettings settings) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        Long questionAnswerId = ((SurveyAnswer) CollectionsKt.first((List) answers)).getQuestionAnswerId();
        List<SurveyPointSingleLogic> logic = settings.getLogic();
        if (logic == null) {
            logic = CollectionsKt.emptyList();
        }
        return surveyLogic.getSingleQuestionNextPointId(questionAnswerId, logic);
    }

    private final Long resolveMultipleNextPointId(List<SurveyAnswer> answers, SurveyLogic surveyLogic, SurveyPointMultipleSettings settings) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = answers.iterator();
        while (it.hasNext()) {
            Long questionAnswerId = ((SurveyAnswer) it.next()).getQuestionAnswerId();
            if (questionAnswerId != null) {
                arrayList.add(questionAnswerId);
            }
        }
        ArrayList arrayList2 = arrayList;
        List<SurveyPointMultipleLogic> logic = settings.getLogic();
        if (logic == null) {
            logic = CollectionsKt.emptyList();
        }
        return surveyLogic.getMultipleQuestionNextPointId(arrayList2, logic);
    }

    private final Long resolveSmileyScaleNextPointId(List<SurveyAnswer> answers, SurveyLogic surveyLogic, SurveyPointSmileyScaleSettings settings) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        Long questionAnswerId = ((SurveyAnswer) CollectionsKt.first((List) answers)).getQuestionAnswerId();
        List<SurveyPointRangeLogic> logic = settings.getLogic();
        if (logic == null) {
            logic = CollectionsKt.emptyList();
        }
        return surveyLogic.getRangeQuestionNextPointId(questionAnswerId, logic);
    }

    private final Long resolveCsatNextPointId(List<SurveyAnswer> answers, SurveyLogic surveyLogic, SurveyPointCsatSettings settings) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        Long questionAnswerId = ((SurveyAnswer) CollectionsKt.first((List) answers)).getQuestionAnswerId();
        List<SurveyPointRangeLogic> logic = settings.getLogic();
        if (logic == null) {
            logic = CollectionsKt.emptyList();
        }
        return surveyLogic.getRangeQuestionNextPointId(questionAnswerId, logic);
    }

    private final Long resolveNumericalNextPointId(List<SurveyAnswer> answers, SurveyLogic surveyLogic, SurveyPointNumericalSettings settings) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        Long questionAnswerId = ((SurveyAnswer) CollectionsKt.first((List) answers)).getQuestionAnswerId();
        List<SurveyPointRangeLogic> logic = settings.getLogic();
        if (logic == null) {
            logic = CollectionsKt.emptyList();
        }
        return surveyLogic.getRangeQuestionNextPointId(questionAnswerId, logic);
    }

    private final Long resolveShapeNextPointId(List<SurveyAnswer> answers, SurveyLogic surveyLogic, SurveyPointShapeSettings settings) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        Long questionAnswerId = ((SurveyAnswer) CollectionsKt.first((List) answers)).getQuestionAnswerId();
        List<SurveyPointRangeLogic> logic = settings.getLogic();
        if (logic == null) {
            logic = CollectionsKt.emptyList();
        }
        return surveyLogic.getRangeQuestionNextPointId(questionAnswerId, logic);
    }

    private final Long resolveDateNextPointId(List<SurveyAnswer> answers, SurveyLogic surveyLogic, SurveyPointDateSettings settings) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        String content = ((SurveyAnswer) CollectionsKt.first((List) answers)).getContent();
        List<SurveyPointDateLogic> logic = settings.getLogic();
        if (logic == null) {
            logic = CollectionsKt.emptyList();
        }
        return surveyLogic.getDateQuestionNextPointId(content, logic);
    }

    private final Long resolveTextNextPointId(List<SurveyAnswer> answers, SurveyLogic surveyLogic, SurveyPointTextSettings settings) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        return surveyLogic.getTextQuestionNextPointId(((SurveyAnswer) CollectionsKt.first((List) answers)).getContent(), settings.getLogic());
    }

    private final Long resolveMatrixNextPointId(List<SurveyAnswer> answers, SurveyLogic surveyLogic, SurveyPointMatrixSettings settings) {
        return surveyLogic.mo14341getMatrixQuestionNextPointId1MonJVE(MatrixAnswer.INSTANCE.m14357fromRawAnswersyWLOJ_k(answers), settings.getLogic());
    }

    private final Long resolveNpsNextPointId(SurveyNpsSurveyPoint surveyPoint, List<SurveyAnswer> answers, SurveyLogic surveyLogic) {
        if (answers.size() != 1) {
            throw new IllegalArgumentException("The answers list must contain exactly one item, even if it's an empty answer.".toString());
        }
        Long answerId = ((SurveyAnswer) CollectionsKt.first((List) answers)).getAnswerId();
        List<SurveyPointRangeLogic> logic = surveyPoint.getSettings().getLogic();
        if (logic == null) {
            logic = CollectionsKt.emptyList();
        }
        return surveyLogic.getRangeQuestionNextPointId(answerId, logic);
    }

    private final Long resolveFormNextPointId(SurveyFormSurveyPoint surveyPoint, List<SurveyAnswer> answers, SurveyLogic surveyLogic) {
        List<Pair<Long, String>> formAnswers = FormAnswerMappingKt.toFormAnswers(answers);
        List<SurveyPointFormLogic> logic = surveyPoint.getSettings().getLogic();
        if (logic == null) {
            logic = CollectionsKt.emptyList();
        }
        return surveyLogic.getFormQuestionNextPointId(formAnswers, logic);
    }
}
