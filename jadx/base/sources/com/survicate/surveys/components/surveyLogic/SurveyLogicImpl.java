package com.survicate.surveys.components.surveyLogic;

import com.survicate.surveys.components.branchLogic.BranchLogicDateExKt;
import com.survicate.surveys.components.branchLogic.BranchLogicFormExKt;
import com.survicate.surveys.components.branchLogic.BranchLogicMatrixExKt;
import com.survicate.surveys.components.branchLogic.BranchLogicMultipleExKt;
import com.survicate.surveys.components.branchLogic.BranchLogicRangeExKt;
import com.survicate.surveys.components.branchLogic.BranchLogicSingleExKt;
import com.survicate.surveys.components.branchLogic.BranchLogicTextExKt;
import com.survicate.surveys.core.logic.branch.BranchLogicController;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import com.survicate.surveys.entities.survey.surveyLogic.date.SurveyPointDateLogic;
import com.survicate.surveys.entities.survey.surveyLogic.form.SurveyPointFormLogic;
import com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyPointMatrixLogic;
import com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyPointMultipleLogic;
import com.survicate.surveys.entities.survey.surveyLogic.range.SurveyPointRangeLogic;
import com.survicate.surveys.entities.survey.surveyLogic.single.SurveyPointSingleLogic;
import com.survicate.surveys.entities.survey.surveyLogic.text.SurveyPointTextLogic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyLogicImpl.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0016¢\u0006\u0002\u0010\u000bJ'\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0016¢\u0006\u0002\u0010\u0011J'\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0016¢\u0006\u0002\u0010\u0011J+\u0010\u0014\u001a\u0004\u0018\u00010\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00160\tH\u0016¢\u0006\u0002\u0010\u0017J;\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u001c\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u001aj\u0002`\u001b0\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001c0\tH\u0016¢\u0006\u0002\u0010\u0017J'\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u001e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001f0\tH\u0016¢\u0006\u0004\b \u0010!¨\u0006#"}, m1599d2 = {"Lcom/survicate/surveys/components/surveyLogic/SurveyLogicImpl;", "Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;", "<init>", "()V", "getTextQuestionNextPointId", "", "answer", "", "logics", "", "Lcom/survicate/surveys/entities/survey/surveyLogic/text/SurveyPointTextLogic;", "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/Long;", "getDateQuestionNextPointId", "Lcom/survicate/surveys/entities/survey/surveyLogic/date/SurveyPointDateLogic;", "getRangeQuestionNextPointId", "answerId", "Lcom/survicate/surveys/entities/survey/surveyLogic/range/SurveyPointRangeLogic;", "(Ljava/lang/Long;Ljava/util/List;)Ljava/lang/Long;", "getSingleQuestionNextPointId", "Lcom/survicate/surveys/entities/survey/surveyLogic/single/SurveyPointSingleLogic;", "getMultipleQuestionNextPointId", "answersIds", "Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyPointMultipleLogic;", "(Ljava/util/List;Ljava/util/List;)Ljava/lang/Long;", "getFormQuestionNextPointId", "answers", "Lkotlin/Pair;", "Lcom/survicate/surveys/components/surveyLogic/FormAnswer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyPointFormLogic;", "getMatrixQuestionNextPointId", "Lcom/survicate/surveys/entities/models/MatrixAnswer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyPointMatrixLogic;", "getMatrixQuestionNextPointId-1MonJVE", "(Ljava/util/Map;Ljava/util/List;)Ljava/lang/Long;", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyLogicImpl implements SurveyLogic {
    public static final long ALL_ANSWER_CHOICES_ID = -1;
    public static final long ANY_FIELD_ID = -1;

    @Override // com.survicate.surveys.components.surveyLogic.SurveyLogic
    public Long getTextQuestionNextPointId(String answer, List<SurveyPointTextLogic> logics) {
        Intrinsics.checkNotNullParameter(logics, "logics");
        BranchLogicController branchLogicController = BranchLogicController.INSTANCE;
        QuestionAnswered.Text coreTextAnswered$default = BranchLogicTextExKt.toCoreTextAnswered$default(answer, 0L, 1, null);
        List<SurveyPointTextLogic> list = logics;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BranchLogicTextExKt.toCoreLogic((SurveyPointTextLogic) it.next()));
        }
        return branchLogicController.resolveNextPointId(coreTextAnswered$default, arrayList);
    }

    @Override // com.survicate.surveys.components.surveyLogic.SurveyLogic
    public Long getDateQuestionNextPointId(String answer, List<SurveyPointDateLogic> logics) {
        Intrinsics.checkNotNullParameter(logics, "logics");
        BranchLogicController branchLogicController = BranchLogicController.INSTANCE;
        QuestionAnswered.Date coreDateAnswered$default = BranchLogicDateExKt.toCoreDateAnswered$default(answer, 0L, 1, null);
        List<SurveyPointDateLogic> list = logics;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BranchLogicDateExKt.toCoreLogic((SurveyPointDateLogic) it.next()));
        }
        return branchLogicController.resolveNextPointId(coreDateAnswered$default, arrayList);
    }

    @Override // com.survicate.surveys.components.surveyLogic.SurveyLogic
    public Long getRangeQuestionNextPointId(Long answerId, List<SurveyPointRangeLogic> logics) {
        Intrinsics.checkNotNullParameter(logics, "logics");
        BranchLogicController branchLogicController = BranchLogicController.INSTANCE;
        QuestionAnswered.Range coreRangeAnswered$default = BranchLogicRangeExKt.toCoreRangeAnswered$default(answerId, 0L, 1, null);
        List<SurveyPointRangeLogic> list = logics;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BranchLogicRangeExKt.toCoreLogic((SurveyPointRangeLogic) it.next()));
        }
        return branchLogicController.resolveNextPointId(coreRangeAnswered$default, arrayList);
    }

    @Override // com.survicate.surveys.components.surveyLogic.SurveyLogic
    public Long getSingleQuestionNextPointId(Long answerId, List<SurveyPointSingleLogic> logics) {
        Intrinsics.checkNotNullParameter(logics, "logics");
        BranchLogicController branchLogicController = BranchLogicController.INSTANCE;
        QuestionAnswered.Single coreSingleAnswered$default = BranchLogicSingleExKt.toCoreSingleAnswered$default(answerId, 0L, 1, null);
        List<SurveyPointSingleLogic> list = logics;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BranchLogicSingleExKt.toCoreLogic((SurveyPointSingleLogic) it.next()));
        }
        return branchLogicController.resolveNextPointId(coreSingleAnswered$default, arrayList);
    }

    @Override // com.survicate.surveys.components.surveyLogic.SurveyLogic
    public Long getMultipleQuestionNextPointId(List<Long> answersIds, List<SurveyPointMultipleLogic> logics) {
        Intrinsics.checkNotNullParameter(answersIds, "answersIds");
        Intrinsics.checkNotNullParameter(logics, "logics");
        BranchLogicController branchLogicController = BranchLogicController.INSTANCE;
        QuestionAnswered.Multiple coreMultipleAnswered$default = BranchLogicMultipleExKt.toCoreMultipleAnswered$default(answersIds, 0L, 1, null);
        List<SurveyPointMultipleLogic> list = logics;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BranchLogicMultipleExKt.toCoreLogic((SurveyPointMultipleLogic) it.next()));
        }
        return branchLogicController.resolveNextPointId(coreMultipleAnswered$default, arrayList);
    }

    @Override // com.survicate.surveys.components.surveyLogic.SurveyLogic
    public Long getFormQuestionNextPointId(List<Pair<Long, String>> answers, List<SurveyPointFormLogic> logics) {
        Intrinsics.checkNotNullParameter(answers, "answers");
        Intrinsics.checkNotNullParameter(logics, "logics");
        BranchLogicController branchLogicController = BranchLogicController.INSTANCE;
        QuestionAnswered.Form coreFormAnswered$default = BranchLogicFormExKt.toCoreFormAnswered$default(answers, 0L, 1, null);
        List<SurveyPointFormLogic> list = logics;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BranchLogicFormExKt.toCoreLogic((SurveyPointFormLogic) it.next()));
        }
        return branchLogicController.resolveNextPointId(coreFormAnswered$default, arrayList);
    }

    @Override // com.survicate.surveys.components.surveyLogic.SurveyLogic
    /* JADX INFO: renamed from: getMatrixQuestionNextPointId-1MonJVE */
    public Long mo14341getMatrixQuestionNextPointId1MonJVE(Map<Long, ? extends Long> answer, List<SurveyPointMatrixLogic> logics) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(logics, "logics");
        BranchLogicController branchLogicController = BranchLogicController.INSTANCE;
        QuestionAnswered.Matrix matrixM14340toCoreMatrixAnswered1MonJVE$default = BranchLogicMatrixExKt.m14340toCoreMatrixAnswered1MonJVE$default(answer, 0L, 1, null);
        List<SurveyPointMatrixLogic> list = logics;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BranchLogicMatrixExKt.toCoreLogic((SurveyPointMatrixLogic) it.next()));
        }
        return branchLogicController.resolveNextPointId(matrixM14340toCoreMatrixAnswered1MonJVE$default, arrayList);
    }
}
