package com.survicate.surveys.presentation.page;

import com.survicate.surveys.entities.survey.SurveyAnswerType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPageContentViewFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/SurveyPageContentViewFactory;", "", "<init>", "()V", "supportedTypes", "", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "isSupportedType", "", "answerType", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyPageContentViewFactory {
    public static final SurveyPageContentViewFactory INSTANCE = new SurveyPageContentViewFactory();
    private static final Set<SurveyAnswerType> supportedTypes = SetsKt.setOf((Object[]) new SurveyAnswerType[]{SurveyAnswerType.SINGLE, SurveyAnswerType.MULTIPLE, SurveyAnswerType.NPS, SurveyAnswerType.SMILEY_SCALE, SurveyAnswerType.CSAT, SurveyAnswerType.NUMERICAL, SurveyAnswerType.SHAPE, SurveyAnswerType.DATE, SurveyAnswerType.TEXT, SurveyAnswerType.MATRIX, SurveyAnswerType.FORM, SurveyAnswerType.BUTTON_NEXT, SurveyAnswerType.BUTTON_LINK, SurveyAnswerType.BUTTON_CLOSE});

    private SurveyPageContentViewFactory() {
    }

    public final boolean isSupportedType(String answerType) {
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        SurveyAnswerType surveyAnswerTypeFromString = SurveyAnswerType.INSTANCE.fromString(answerType);
        if (surveyAnswerTypeFromString == null) {
            return false;
        }
        return supportedTypes.contains(surveyAnswerTypeFromString);
    }
}
