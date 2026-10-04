package com.survicate.surveys;

import com.survicate.surveys.entities.survey.Survey;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.presentation.base.SurveyAnswerAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnswersManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017JD\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, m1599d2 = {"Lcom/survicate/surveys/AnswerDetails;", "", "answerAction", "Lcom/survicate/surveys/presentation/base/SurveyAnswerAction;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "survey", "Lcom/survicate/surveys/entities/survey/Survey;", "surveyLanguage", "", "disclaimerAccepted", "", "<init>", "(Lcom/survicate/surveys/presentation/base/SurveyAnswerAction;Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;Lcom/survicate/surveys/entities/survey/Survey;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAnswerAction", "()Lcom/survicate/surveys/presentation/base/SurveyAnswerAction;", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "getSurvey", "()Lcom/survicate/surveys/entities/survey/Survey;", "getSurveyLanguage", "()Ljava/lang/String;", "getDisclaimerAccepted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/survicate/surveys/presentation/base/SurveyAnswerAction;Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;Lcom/survicate/surveys/entities/survey/Survey;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/survicate/surveys/AnswerDetails;", "equals", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class AnswerDetails {
    private final SurveyAnswerAction answerAction;
    private final Boolean disclaimerAccepted;
    private final Survey survey;
    private final String surveyLanguage;
    private final SurveyPoint surveyPoint;

    public static /* synthetic */ AnswerDetails copy$default(AnswerDetails answerDetails, SurveyAnswerAction surveyAnswerAction, SurveyPoint surveyPoint, Survey survey, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            surveyAnswerAction = answerDetails.answerAction;
        }
        if ((i & 2) != 0) {
            surveyPoint = answerDetails.surveyPoint;
        }
        if ((i & 4) != 0) {
            survey = answerDetails.survey;
        }
        if ((i & 8) != 0) {
            str = answerDetails.surveyLanguage;
        }
        if ((i & 16) != 0) {
            bool = answerDetails.disclaimerAccepted;
        }
        Boolean bool2 = bool;
        Survey survey2 = survey;
        return answerDetails.copy(surveyAnswerAction, surveyPoint, survey2, str, bool2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SurveyAnswerAction getAnswerAction() {
        return this.answerAction;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SurveyPoint getSurveyPoint() {
        return this.surveyPoint;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Survey getSurvey() {
        return this.survey;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSurveyLanguage() {
        return this.surveyLanguage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getDisclaimerAccepted() {
        return this.disclaimerAccepted;
    }

    public final AnswerDetails copy(SurveyAnswerAction answerAction, SurveyPoint surveyPoint, Survey survey, String surveyLanguage, Boolean disclaimerAccepted) {
        Intrinsics.checkNotNullParameter(answerAction, "answerAction");
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(survey, "survey");
        return new AnswerDetails(answerAction, surveyPoint, survey, surveyLanguage, disclaimerAccepted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnswerDetails)) {
            return false;
        }
        AnswerDetails answerDetails = (AnswerDetails) other;
        return Intrinsics.areEqual(this.answerAction, answerDetails.answerAction) && Intrinsics.areEqual(this.surveyPoint, answerDetails.surveyPoint) && Intrinsics.areEqual(this.survey, answerDetails.survey) && Intrinsics.areEqual(this.surveyLanguage, answerDetails.surveyLanguage) && Intrinsics.areEqual(this.disclaimerAccepted, answerDetails.disclaimerAccepted);
    }

    public int hashCode() {
        int iHashCode = ((((this.answerAction.hashCode() * 31) + this.surveyPoint.hashCode()) * 31) + this.survey.hashCode()) * 31;
        String str = this.surveyLanguage;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.disclaimerAccepted;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "AnswerDetails(answerAction=" + this.answerAction + ", surveyPoint=" + this.surveyPoint + ", survey=" + this.survey + ", surveyLanguage=" + this.surveyLanguage + ", disclaimerAccepted=" + this.disclaimerAccepted + ')';
    }

    public AnswerDetails(SurveyAnswerAction answerAction, SurveyPoint surveyPoint, Survey survey, String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(answerAction, "answerAction");
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(survey, "survey");
        this.answerAction = answerAction;
        this.surveyPoint = surveyPoint;
        this.survey = survey;
        this.surveyLanguage = str;
        this.disclaimerAccepted = bool;
    }

    public final SurveyAnswerAction getAnswerAction() {
        return this.answerAction;
    }

    public final SurveyPoint getSurveyPoint() {
        return this.surveyPoint;
    }

    public final Survey getSurvey() {
        return this.survey;
    }

    public final String getSurveyLanguage() {
        return this.surveyLanguage;
    }

    public final Boolean getDisclaimerAccepted() {
        return this.disclaimerAccepted;
    }
}
