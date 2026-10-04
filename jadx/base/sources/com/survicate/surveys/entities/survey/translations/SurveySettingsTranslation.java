package com.survicate.surveys.entities.survey.translations;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyTranslation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/translations/SurveySettingsTranslation;", "", "messages", "Lcom/survicate/surveys/entities/survey/translations/SurveyMessagesTranslation;", "<init>", "(Lcom/survicate/surveys/entities/survey/translations/SurveyMessagesTranslation;)V", "getMessages", "()Lcom/survicate/surveys/entities/survey/translations/SurveyMessagesTranslation;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveySettingsTranslation {
    private final SurveyMessagesTranslation messages;

    public static /* synthetic */ SurveySettingsTranslation copy$default(SurveySettingsTranslation surveySettingsTranslation, SurveyMessagesTranslation surveyMessagesTranslation, int i, Object obj) {
        if ((i & 1) != 0) {
            surveyMessagesTranslation = surveySettingsTranslation.messages;
        }
        return surveySettingsTranslation.copy(surveyMessagesTranslation);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SurveyMessagesTranslation getMessages() {
        return this.messages;
    }

    public final SurveySettingsTranslation copy(SurveyMessagesTranslation messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        return new SurveySettingsTranslation(messages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SurveySettingsTranslation) && Intrinsics.areEqual(this.messages, ((SurveySettingsTranslation) other).messages);
    }

    public int hashCode() {
        return this.messages.hashCode();
    }

    public String toString() {
        return "SurveySettingsTranslation(messages=" + this.messages + ')';
    }

    public SurveySettingsTranslation(SurveyMessagesTranslation messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.messages = messages;
    }

    public final SurveyMessagesTranslation getMessages() {
        return this.messages;
    }
}
