package com.survicate.surveys.presentation.base.micro;

import com.survicate.surveys.entities.survey.questions.question.QuestionPointAnswer;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings;
import com.survicate.surveys.entities.survey.questions.question.multiple.SurveyPointMultipleSettings;
import com.survicate.surveys.entities.survey.questions.question.single.SurveyPointSingleSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: QuestionOptionsShuffler.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\fJ.\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005H\u0002J4\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\fH\u0002¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/presentation/base/micro/QuestionOptionsShuffler;", "", "<init>", "()V", "shuffleListIfNecessary", "", "Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "point", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "savedOrder", "", "shuffle", "Lkotlin/Function1;", "", "", "restoreSavedOrder", "answers", "order", "shuffleRespectingPinned", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class QuestionOptionsShuffler {
    public static final QuestionOptionsShuffler INSTANCE = new QuestionOptionsShuffler();

    private QuestionOptionsShuffler() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.survicate.surveys.presentation.base.micro.QuestionOptionsShuffler$shuffleListIfNecessary$1 */
    /* JADX INFO: compiled from: QuestionOptionsShuffler.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class C84271 extends FunctionReferenceImpl implements Function1<List<?>, Unit> {
        public static final C84271 INSTANCE = new C84271();

        C84271() {
            super(1, Collections.class, "shuffle", "shuffle(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<?> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<?> list) {
            Collections.shuffle(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List shuffleListIfNecessary$default(QuestionOptionsShuffler questionOptionsShuffler, SurveyQuestionSurveyPoint surveyQuestionSurveyPoint, List list, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            function1 = C84271.INSTANCE;
        }
        return questionOptionsShuffler.shuffleListIfNecessary(surveyQuestionSurveyPoint, list, function1);
    }

    public final List<QuestionPointAnswer> shuffleListIfNecessary(SurveyQuestionSurveyPoint point, List<Long> savedOrder, Function1<? super List<?>, Unit> shuffle) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(shuffle, "shuffle");
        SurveyQuestionPointSettings settings = point.getSettings();
        if (point.getAnswers().isEmpty()) {
            return point.getAnswers();
        }
        boolean zValueOf = false;
        if (settings instanceof SurveyPointSingleSettings) {
            zValueOf = ((SurveyPointSingleSettings) settings).getRandomizeAnswers();
        }
        if (settings instanceof SurveyPointMultipleSettings) {
            zValueOf = ((SurveyPointMultipleSettings) settings).getRandomizeAnswers();
        }
        if (settings instanceof SurveyPointMatrixSettings) {
            zValueOf = Boolean.valueOf(((SurveyPointMatrixSettings) settings).getRandomizeAnswers());
        }
        if (!Intrinsics.areEqual((Object) zValueOf, (Object) true)) {
            return point.getAnswers();
        }
        List<QuestionPointAnswer> listRestoreSavedOrder = restoreSavedOrder(point.getAnswers(), savedOrder);
        return listRestoreSavedOrder != null ? listRestoreSavedOrder : shuffleRespectingPinned(point.getAnswers(), shuffle);
    }

    private final List<QuestionPointAnswer> restoreSavedOrder(List<QuestionPointAnswer> answers, List<Long> order) {
        if (order != null && order.size() == answers.size()) {
            List<QuestionPointAnswer> list = answers;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(Long.valueOf(((QuestionPointAnswer) obj).getId()), obj);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = order.iterator();
            while (it.hasNext()) {
                QuestionPointAnswer questionPointAnswer = (QuestionPointAnswer) linkedHashMap.get(Long.valueOf(((Number) it.next()).longValue()));
                if (questionPointAnswer != null) {
                    arrayList.add(questionPointAnswer);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2.size() == answers.size()) {
                return arrayList2;
            }
        }
        return null;
    }

    private final List<QuestionPointAnswer> shuffleRespectingPinned(List<QuestionPointAnswer> answers, Function1<? super List<?>, Unit> shuffle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        List<QuestionPointAnswer> list = answers;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            QuestionPointAnswer questionPointAnswer = answers.get(i);
            Boolean randomizable = questionPointAnswer.getRandomizable();
            if (randomizable != null ? randomizable.booleanValue() : true) {
                arrayList.add(questionPointAnswer);
            } else {
                linkedHashMap.put(Integer.valueOf(i), questionPointAnswer);
            }
        }
        shuffle.invoke(arrayList);
        ArrayList arrayList2 = new ArrayList(answers.size());
        Iterator it = arrayList.iterator();
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            QuestionPointAnswer questionPointAnswer2 = (QuestionPointAnswer) linkedHashMap.get(Integer.valueOf(i2));
            if (questionPointAnswer2 != null) {
                arrayList2.add(questionPointAnswer2);
            } else {
                arrayList2.add(it.next());
            }
        }
        return arrayList2;
    }
}
