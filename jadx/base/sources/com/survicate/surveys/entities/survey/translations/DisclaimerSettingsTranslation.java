package com.survicate.surveys.entities.survey.translations;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPointTranslation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/translations/DisclaimerSettingsTranslation;", "", "title", "", "description", "checkboxLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getDescription", "getCheckboxLabel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class DisclaimerSettingsTranslation {
    private final String checkboxLabel;
    private final String description;
    private final String title;

    public static /* synthetic */ DisclaimerSettingsTranslation copy$default(DisclaimerSettingsTranslation disclaimerSettingsTranslation, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = disclaimerSettingsTranslation.title;
        }
        if ((i & 2) != 0) {
            str2 = disclaimerSettingsTranslation.description;
        }
        if ((i & 4) != 0) {
            str3 = disclaimerSettingsTranslation.checkboxLabel;
        }
        return disclaimerSettingsTranslation.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCheckboxLabel() {
        return this.checkboxLabel;
    }

    public final DisclaimerSettingsTranslation copy(String title, String description, String checkboxLabel) {
        return new DisclaimerSettingsTranslation(title, description, checkboxLabel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisclaimerSettingsTranslation)) {
            return false;
        }
        DisclaimerSettingsTranslation disclaimerSettingsTranslation = (DisclaimerSettingsTranslation) other;
        return Intrinsics.areEqual(this.title, disclaimerSettingsTranslation.title) && Intrinsics.areEqual(this.description, disclaimerSettingsTranslation.description) && Intrinsics.areEqual(this.checkboxLabel, disclaimerSettingsTranslation.checkboxLabel);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.checkboxLabel;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "DisclaimerSettingsTranslation(title=" + this.title + ", description=" + this.description + ", checkboxLabel=" + this.checkboxLabel + ')';
    }

    public DisclaimerSettingsTranslation(String str, String str2, String str3) {
        this.title = str;
        this.description = str2;
        this.checkboxLabel = str3;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getCheckboxLabel() {
        return this.checkboxLabel;
    }
}
