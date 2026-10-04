package com.survicate.surveys.entities.survey.translations;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPointTranslation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003J[\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/translations/SurveyPointTranslation;", "", "id", "", FirebaseAnalytics.Param.CONTENT, "", "description", "answers", "", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointEntryTranslation;", "fields", "settings", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointSettingsTranslation;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/survicate/surveys/entities/survey/translations/SurveyPointSettingsTranslation;)V", "getId", "()J", "getContent", "()Ljava/lang/String;", "getDescription", "getAnswers", "()Ljava/util/List;", "getFields", "getSettings", "()Lcom/survicate/surveys/entities/survey/translations/SurveyPointSettingsTranslation;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveyPointTranslation {
    private final List<SurveyPointEntryTranslation> answers;
    private final String content;
    private final String description;
    private final List<SurveyPointEntryTranslation> fields;
    private final long id;
    private final SurveyPointSettingsTranslation settings;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyPointTranslation copy$default(SurveyPointTranslation surveyPointTranslation, long j, String str, String str2, List list, List list2, SurveyPointSettingsTranslation surveyPointSettingsTranslation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = surveyPointTranslation.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = surveyPointTranslation.content;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = surveyPointTranslation.description;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            list = surveyPointTranslation.answers;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = surveyPointTranslation.fields;
        }
        List list4 = list2;
        if ((i & 32) != 0) {
            surveyPointSettingsTranslation = surveyPointTranslation.settings;
        }
        return surveyPointTranslation.copy(j2, str3, str4, list3, list4, surveyPointSettingsTranslation);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<SurveyPointEntryTranslation> component4() {
        return this.answers;
    }

    public final List<SurveyPointEntryTranslation> component5() {
        return this.fields;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SurveyPointSettingsTranslation getSettings() {
        return this.settings;
    }

    public final SurveyPointTranslation copy(long id, String content, String description, List<SurveyPointEntryTranslation> answers, List<SurveyPointEntryTranslation> fields, SurveyPointSettingsTranslation settings) {
        return new SurveyPointTranslation(id, content, description, answers, fields, settings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPointTranslation)) {
            return false;
        }
        SurveyPointTranslation surveyPointTranslation = (SurveyPointTranslation) other;
        return this.id == surveyPointTranslation.id && Intrinsics.areEqual(this.content, surveyPointTranslation.content) && Intrinsics.areEqual(this.description, surveyPointTranslation.description) && Intrinsics.areEqual(this.answers, surveyPointTranslation.answers) && Intrinsics.areEqual(this.fields, surveyPointTranslation.fields) && Intrinsics.areEqual(this.settings, surveyPointTranslation.settings);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<SurveyPointEntryTranslation> list = this.answers;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<SurveyPointEntryTranslation> list2 = this.fields;
        int iHashCode5 = (iHashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        SurveyPointSettingsTranslation surveyPointSettingsTranslation = this.settings;
        return iHashCode5 + (surveyPointSettingsTranslation != null ? surveyPointSettingsTranslation.hashCode() : 0);
    }

    public String toString() {
        return "SurveyPointTranslation(id=" + this.id + ", content=" + this.content + ", description=" + this.description + ", answers=" + this.answers + ", fields=" + this.fields + ", settings=" + this.settings + ')';
    }

    public SurveyPointTranslation(long j, String str, String str2, List<SurveyPointEntryTranslation> list, List<SurveyPointEntryTranslation> list2, SurveyPointSettingsTranslation surveyPointSettingsTranslation) {
        this.id = j;
        this.content = str;
        this.description = str2;
        this.answers = list;
        this.fields = list2;
        this.settings = surveyPointSettingsTranslation;
    }

    public final long getId() {
        return this.id;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<SurveyPointEntryTranslation> getAnswers() {
        return this.answers;
    }

    public final List<SurveyPointEntryTranslation> getFields() {
        return this.fields;
    }

    public final SurveyPointSettingsTranslation getSettings() {
        return this.settings;
    }
}
