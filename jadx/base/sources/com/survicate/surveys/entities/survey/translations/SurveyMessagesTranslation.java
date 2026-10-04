package com.survicate.surveys.entities.survey.translations;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyTranslation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/translations/SurveyMessagesTranslation;", "", "submitText", "", "navigationBackText", "answerRequiredText", "inputTextPlaceholder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSubmitText", "()Ljava/lang/String;", "getNavigationBackText", "getAnswerRequiredText", "getInputTextPlaceholder", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveyMessagesTranslation {
    private final String answerRequiredText;
    private final String inputTextPlaceholder;
    private final String navigationBackText;
    private final String submitText;

    public static /* synthetic */ SurveyMessagesTranslation copy$default(SurveyMessagesTranslation surveyMessagesTranslation, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = surveyMessagesTranslation.submitText;
        }
        if ((i & 2) != 0) {
            str2 = surveyMessagesTranslation.navigationBackText;
        }
        if ((i & 4) != 0) {
            str3 = surveyMessagesTranslation.answerRequiredText;
        }
        if ((i & 8) != 0) {
            str4 = surveyMessagesTranslation.inputTextPlaceholder;
        }
        return surveyMessagesTranslation.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubmitText() {
        return this.submitText;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNavigationBackText() {
        return this.navigationBackText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAnswerRequiredText() {
        return this.answerRequiredText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInputTextPlaceholder() {
        return this.inputTextPlaceholder;
    }

    public final SurveyMessagesTranslation copy(String submitText, String navigationBackText, String answerRequiredText, String inputTextPlaceholder) {
        return new SurveyMessagesTranslation(submitText, navigationBackText, answerRequiredText, inputTextPlaceholder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyMessagesTranslation)) {
            return false;
        }
        SurveyMessagesTranslation surveyMessagesTranslation = (SurveyMessagesTranslation) other;
        return Intrinsics.areEqual(this.submitText, surveyMessagesTranslation.submitText) && Intrinsics.areEqual(this.navigationBackText, surveyMessagesTranslation.navigationBackText) && Intrinsics.areEqual(this.answerRequiredText, surveyMessagesTranslation.answerRequiredText) && Intrinsics.areEqual(this.inputTextPlaceholder, surveyMessagesTranslation.inputTextPlaceholder);
    }

    public int hashCode() {
        String str = this.submitText;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.navigationBackText;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.answerRequiredText;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.inputTextPlaceholder;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "SurveyMessagesTranslation(submitText=" + this.submitText + ", navigationBackText=" + this.navigationBackText + ", answerRequiredText=" + this.answerRequiredText + ", inputTextPlaceholder=" + this.inputTextPlaceholder + ')';
    }

    public SurveyMessagesTranslation(String str, String str2, String str3, String str4) {
        this.submitText = str;
        this.navigationBackText = str2;
        this.answerRequiredText = str3;
        this.inputTextPlaceholder = str4;
    }

    public final String getSubmitText() {
        return this.submitText;
    }

    public final String getNavigationBackText() {
        return this.navigationBackText;
    }

    public final String getAnswerRequiredText() {
        return this.answerRequiredText;
    }

    public final String getInputTextPlaceholder() {
        return this.inputTextPlaceholder;
    }
}
