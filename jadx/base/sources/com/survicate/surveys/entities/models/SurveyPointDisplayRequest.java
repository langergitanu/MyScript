package com.survicate.surveys.entities.models;

import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPointDisplayRequest.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/SurveyPointDisplayRequest;", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "isNavigatingBack", "", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;Z)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveyPointDisplayRequest {
    private final boolean isNavigatingBack;
    private final SurveyPoint surveyPoint;

    public static /* synthetic */ SurveyPointDisplayRequest copy$default(SurveyPointDisplayRequest surveyPointDisplayRequest, SurveyPoint surveyPoint, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            surveyPoint = surveyPointDisplayRequest.surveyPoint;
        }
        if ((i & 2) != 0) {
            z = surveyPointDisplayRequest.isNavigatingBack;
        }
        return surveyPointDisplayRequest.copy(surveyPoint, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SurveyPoint getSurveyPoint() {
        return this.surveyPoint;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsNavigatingBack() {
        return this.isNavigatingBack;
    }

    public final SurveyPointDisplayRequest copy(SurveyPoint surveyPoint, boolean isNavigatingBack) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        return new SurveyPointDisplayRequest(surveyPoint, isNavigatingBack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPointDisplayRequest)) {
            return false;
        }
        SurveyPointDisplayRequest surveyPointDisplayRequest = (SurveyPointDisplayRequest) other;
        return Intrinsics.areEqual(this.surveyPoint, surveyPointDisplayRequest.surveyPoint) && this.isNavigatingBack == surveyPointDisplayRequest.isNavigatingBack;
    }

    public int hashCode() {
        return (this.surveyPoint.hashCode() * 31) + Boolean.hashCode(this.isNavigatingBack);
    }

    public String toString() {
        return "SurveyPointDisplayRequest(surveyPoint=" + this.surveyPoint + ", isNavigatingBack=" + this.isNavigatingBack + ')';
    }

    public SurveyPointDisplayRequest(SurveyPoint surveyPoint, boolean z) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        this.surveyPoint = surveyPoint;
        this.isNavigatingBack = z;
    }

    public final SurveyPoint getSurveyPoint() {
        return this.surveyPoint;
    }

    public final boolean isNavigatingBack() {
        return this.isNavigatingBack;
    }
}
