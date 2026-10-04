package com.survicate.surveys.entities.survey.questions.question;

import android.os.Parcelable;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic;
import com.survicate.surveys.entities.survey.translations.SurveyPointSettingsTranslation;
import com.survicate.surveys.entities.survey.translations.Translatable;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* JADX INFO: compiled from: SurveyQuestionPointSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@JsonClassDiscriminator(discriminator = "answer_type")
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionPointSettings;", "Landroid/os/Parcelable;", "Lcom/survicate/surveys/entities/survey/translations/Translatable;", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointSettingsTranslation;", "isMandatory", "", "()Z", "displayLogicOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getDisplayLogicOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "displayLogic", "", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic;", "getDisplayLogic", "()Ljava/util/List;", "surveyPointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "getSurveyPointImage", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "getDisclaimerSettings", "()Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurveyQuestionPointSettings extends Parcelable, Translatable<SurveyPointSettingsTranslation, SurveyQuestionPointSettings> {
    DisclaimerSettings getDisclaimerSettings();

    List<DisplayLogic> getDisplayLogic();

    SurveyLogicOperator getDisplayLogicOperator();

    SurveyPointImage getSurveyPointImage();

    boolean isMandatory();
}
