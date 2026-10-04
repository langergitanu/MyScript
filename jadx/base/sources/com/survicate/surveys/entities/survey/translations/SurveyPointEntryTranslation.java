package com.survicate.surveys.entities.survey.translations;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPointTranslation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/translations/SurveyPointEntryTranslation;", "", "id", "", "value", "", "<init>", "(JLjava/lang/String;)V", "getId", "()J", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveyPointEntryTranslation {
    private final long id;
    private final String value;

    public static /* synthetic */ SurveyPointEntryTranslation copy$default(SurveyPointEntryTranslation surveyPointEntryTranslation, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = surveyPointEntryTranslation.id;
        }
        if ((i & 2) != 0) {
            str = surveyPointEntryTranslation.value;
        }
        return surveyPointEntryTranslation.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final SurveyPointEntryTranslation copy(long id, String value) {
        return new SurveyPointEntryTranslation(id, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPointEntryTranslation)) {
            return false;
        }
        SurveyPointEntryTranslation surveyPointEntryTranslation = (SurveyPointEntryTranslation) other;
        return this.id == surveyPointEntryTranslation.id && Intrinsics.areEqual(this.value, surveyPointEntryTranslation.value);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.value;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SurveyPointEntryTranslation(id=" + this.id + ", value=" + this.value + ')';
    }

    public SurveyPointEntryTranslation(long j, String str) {
        this.id = j;
        this.value = str;
    }

    public final long getId() {
        return this.id;
    }

    public final String getValue() {
        return this.value;
    }
}
