package com.survicate.surveys.components.surveyLogic;

import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormAnswerMapping.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00050\u0001*\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0000¨\u0006\u0007"}, m1599d2 = {"toFormAnswers", "", "Lkotlin/Pair;", "", "", "Lcom/survicate/surveys/components/surveyLogic/FormAnswer;", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class FormAnswerMappingKt {
    public static final List<Pair<Long, String>> toFormAnswers(List<SurveyAnswer> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            SurveyAnswer surveyAnswer = (SurveyAnswer) obj;
            if (surveyAnswer.getAnswerId() != null && surveyAnswer.getContent() != null) {
                arrayList.add(obj);
            }
        }
        ArrayList<SurveyAnswer> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (SurveyAnswer surveyAnswer2 : arrayList2) {
            Long answerId = surveyAnswer2.getAnswerId();
            Intrinsics.checkNotNull(answerId);
            String content = surveyAnswer2.getContent();
            Intrinsics.checkNotNull(content);
            arrayList3.add(new Pair(answerId, content));
        }
        return arrayList3;
    }
}
