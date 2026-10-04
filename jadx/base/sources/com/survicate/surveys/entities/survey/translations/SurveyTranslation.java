package com.survicate.surveys.entities.survey.translations;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyTranslation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/translations/SurveyTranslation;", "", "id", "", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "points", "", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointTranslation;", "settings", "Lcom/survicate/surveys/entities/survey/translations/SurveySettingsTranslation;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/survicate/surveys/entities/survey/translations/SurveySettingsTranslation;)V", "getId", "()Ljava/lang/String;", "getLanguageCode", "getPoints", "()Ljava/util/List;", "getSettings", "()Lcom/survicate/surveys/entities/survey/translations/SurveySettingsTranslation;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveyTranslation {
    private final String id;
    private final String languageCode;
    private final List<SurveyPointTranslation> points;
    private final SurveySettingsTranslation settings;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyTranslation copy$default(SurveyTranslation surveyTranslation, String str, String str2, List list, SurveySettingsTranslation surveySettingsTranslation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = surveyTranslation.id;
        }
        if ((i & 2) != 0) {
            str2 = surveyTranslation.languageCode;
        }
        if ((i & 4) != 0) {
            list = surveyTranslation.points;
        }
        if ((i & 8) != 0) {
            surveySettingsTranslation = surveyTranslation.settings;
        }
        return surveyTranslation.copy(str, str2, list, surveySettingsTranslation);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final List<SurveyPointTranslation> component3() {
        return this.points;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SurveySettingsTranslation getSettings() {
        return this.settings;
    }

    public final SurveyTranslation copy(String id, String languageCode, List<SurveyPointTranslation> points, SurveySettingsTranslation settings) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(settings, "settings");
        return new SurveyTranslation(id, languageCode, points, settings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyTranslation)) {
            return false;
        }
        SurveyTranslation surveyTranslation = (SurveyTranslation) other;
        return Intrinsics.areEqual(this.id, surveyTranslation.id) && Intrinsics.areEqual(this.languageCode, surveyTranslation.languageCode) && Intrinsics.areEqual(this.points, surveyTranslation.points) && Intrinsics.areEqual(this.settings, surveyTranslation.settings);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.languageCode.hashCode()) * 31) + this.points.hashCode()) * 31) + this.settings.hashCode();
    }

    public String toString() {
        return "SurveyTranslation(id=" + this.id + ", languageCode=" + this.languageCode + ", points=" + this.points + ", settings=" + this.settings + ')';
    }

    public SurveyTranslation(String id, String languageCode, List<SurveyPointTranslation> points, SurveySettingsTranslation settings) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.id = id;
        this.languageCode = languageCode;
        this.points = points;
        this.settings = settings;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final List<SurveyPointTranslation> getPoints() {
        return this.points;
    }

    public final SurveySettingsTranslation getSettings() {
        return this.settings;
    }
}
