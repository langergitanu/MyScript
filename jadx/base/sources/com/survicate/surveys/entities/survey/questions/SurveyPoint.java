package com.survicate.surveys.entities.survey.questions;

import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.survicate.surveys.entities.survey.translations.SurveyPointTranslation;
import com.survicate.surveys.entities.survey.translations.Translatable;
import com.survicate.surveys.presentation.base.DisplayEngine;
import com.survicate.surveys.presentation.base.SurveyPointDisplayer;
import com.survicate.surveys.presentation.base.SurveyViewModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: SurveyPoint.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0003:\u0001 J\u001c\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "Lcom/survicate/surveys/entities/survey/translations/Translatable;", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointTranslation;", "Landroid/os/Parcelable;", "id", "", "getId", "()J", "answerType", "", "getAnswerType", "()Ljava/lang/String;", FirebaseAnalytics.Param.CONTENT, "getContent", "description", "getDescription", "maxPath", "", "getMaxPath", "()I", "getDisplayer", "Lcom/survicate/surveys/presentation/base/SurveyPointDisplayer;", "displayEngine", "Lcom/survicate/surveys/presentation/base/DisplayEngine;", "surveyViewModel", "Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "isMandatory", "", "getSurveyPointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "getDisclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurveyPoint extends Translatable<SurveyPointTranslation, SurveyPoint>, Parcelable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final long FINISH_SURVEY_NEXT_POINT_ID = -1;

    String getAnswerType();

    String getContent();

    String getDescription();

    DisclaimerSettings getDisclaimerSettings();

    SurveyPointDisplayer<?> getDisplayer(DisplayEngine displayEngine, SurveyViewModel surveyViewModel);

    long getId();

    int getMaxPath();

    SurveyPointImage getSurveyPointImage();

    boolean isMandatory();

    /* JADX INFO: compiled from: SurveyPoint.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/SurveyPoint$Companion;", "", "<init>", "()V", "FINISH_SURVEY_NEXT_POINT_ID", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long FINISH_SURVEY_NEXT_POINT_ID = -1;

        private Companion() {
        }
    }
}
