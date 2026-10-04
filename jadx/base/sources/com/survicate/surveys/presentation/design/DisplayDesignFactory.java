package com.survicate.surveys.presentation.design;

import androidx.fragment.app.Fragment;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.theme.ThemeType;
import kotlin.Metadata;

/* JADX INFO: compiled from: DisplayDesign.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/presentation/design/DisplayDesignFactory;", "", "createSurveyPointFragment", "Landroidx/fragment/app/Fragment;", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "themeType", "Lcom/survicate/surveys/entities/survey/theme/ThemeType;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface DisplayDesignFactory {
    Fragment createSurveyPointFragment(SurveyAnswerType answerType, ThemeType themeType);
}
