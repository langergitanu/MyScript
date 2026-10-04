package com.survicate.surveys.components.surveyLogic;

import com.survicate.surveys.entities.survey.surveyLogic.date.SurveyPointDateLogic;
import com.survicate.surveys.entities.survey.surveyLogic.form.SurveyPointFormLogic;
import com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyPointMatrixLogic;
import com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyPointMultipleLogic;
import com.survicate.surveys.entities.survey.surveyLogic.range.SurveyPointRangeLogic;
import com.survicate.surveys.entities.survey.surveyLogic.single.SurveyPointSingleLogic;
import com.survicate.surveys.entities.survey.surveyLogic.text.SurveyPointTextLogic;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: SurveyLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0002\u0010\tJ'\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H&¢\u0006\u0002\u0010\tJ'\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H&¢\u0006\u0002\u0010\u000fJ'\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007H&¢\u0006\u0002\u0010\u000fJ+\u0010\u0012\u001a\u0004\u0018\u00010\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H&¢\u0006\u0002\u0010\u0015J;\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u001c\u0010\u0017\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0018j\u0002`\u00190\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0007H&¢\u0006\u0002\u0010\u0015J'\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u001c2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007H&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, m1599d2 = {"Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;", "", "getTextQuestionNextPointId", "", "answer", "", "logics", "", "Lcom/survicate/surveys/entities/survey/surveyLogic/text/SurveyPointTextLogic;", "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/Long;", "getDateQuestionNextPointId", "Lcom/survicate/surveys/entities/survey/surveyLogic/date/SurveyPointDateLogic;", "getRangeQuestionNextPointId", "answerId", "Lcom/survicate/surveys/entities/survey/surveyLogic/range/SurveyPointRangeLogic;", "(Ljava/lang/Long;Ljava/util/List;)Ljava/lang/Long;", "getSingleQuestionNextPointId", "Lcom/survicate/surveys/entities/survey/surveyLogic/single/SurveyPointSingleLogic;", "getMultipleQuestionNextPointId", "answersIds", "Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyPointMultipleLogic;", "(Ljava/util/List;Ljava/util/List;)Ljava/lang/Long;", "getFormQuestionNextPointId", "answers", "Lkotlin/Pair;", "Lcom/survicate/surveys/components/surveyLogic/FormAnswer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyPointFormLogic;", "getMatrixQuestionNextPointId", "Lcom/survicate/surveys/entities/models/MatrixAnswer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyPointMatrixLogic;", "getMatrixQuestionNextPointId-1MonJVE", "(Ljava/util/Map;Ljava/util/List;)Ljava/lang/Long;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurveyLogic {
    Long getDateQuestionNextPointId(String answer, List<SurveyPointDateLogic> logics);

    Long getFormQuestionNextPointId(List<Pair<Long, String>> answers, List<SurveyPointFormLogic> logics);

    /* JADX INFO: renamed from: getMatrixQuestionNextPointId-1MonJVE, reason: not valid java name */
    Long mo14341getMatrixQuestionNextPointId1MonJVE(Map<Long, ? extends Long> answer, List<SurveyPointMatrixLogic> logics);

    Long getMultipleQuestionNextPointId(List<Long> answersIds, List<SurveyPointMultipleLogic> logics);

    Long getRangeQuestionNextPointId(Long answerId, List<SurveyPointRangeLogic> logics);

    Long getSingleQuestionNextPointId(Long answerId, List<SurveyPointSingleLogic> logics);

    Long getTextQuestionNextPointId(String answer, List<SurveyPointTextLogic> logics);
}
